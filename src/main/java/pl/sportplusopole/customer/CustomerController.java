package pl.sportplusopole.customer;


import jxl.write.WriteException;
import lombok.RequiredArgsConstructor;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


import pl.sportplusopole.bucklet.Bucklet;
import pl.sportplusopole.bucklet.BuckletService;
import pl.sportplusopole.excelExport.JExcel;
import pl.sportplusopole.trainer.Trainer;
import pl.sportplusopole.trainer.TrainerService;



@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final TrainerService trainerService;
    private final BuckletService buckletService;
    private final JExcel jExcel;

    @GetMapping("/all")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String showAllCustomers(Model model){
        int size = customerService.showALL().size();
        model.addAttribute("customers", customerService.showALL());
        model.addAttribute("bucklets", buckletService.showAll());
        model.addAttribute("size", size);
        return "customers/all";
    }

    @PostMapping(value = "/all")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String showCustomerBySurname(HttpServletRequest request, Model model){
        int size = customerService.customerBySurname(request.getParameter("surname")).size();
        model.addAttribute("customers", customerService.customerBySurname(request.getParameter("surname")));
        model.addAttribute("bucklets", buckletService.showAll());
        model.addAttribute("size", size);
        return "customers/all";
    }

    @GetMapping("/lastVisit")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String showLastVisit(Model model){
        int size = customerService.visitCustomer().size();
        model.addAttribute("size", size);
        model.addAttribute("bucklets", buckletService.showAll());
        model.addAttribute("customers", customerService.visitCustomer());
        return "customers/all";
    }

    //szczegóły klienta
    @GetMapping("/details/{clientId}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String aboutTheCustomer(@PathVariable int clientId, Model model){
        model.addAttribute("customer", customerService.findById(clientId));
        return "/customers/details";
    }

    @ModelAttribute("trainers")
    public List<Trainer> setTrainer(){
        return trainerService.findAll();
    }

    @ModelAttribute("bucklets")
    public List<Bucklet> setBucklet(){
        return buckletService.showAll();
    }

    @GetMapping("/add")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customers/add";
    }

    @PostMapping("/add")
    public String addCustomer(@Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "customers/add";
        }
        buckletService.setVisitsAndExpiryDate(customer);
        customerService.addCustomer(customer);
        return "redirect:/customer/all";
    }

    @GetMapping("/edit/{clientId}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String editCustomer (@PathVariable int clientId, Model model){
        model.addAttribute("customer", customerService.findById(clientId));
        return "customers/add";
    }

    @PostMapping("/edit/{clientId}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String editClient(Customer customer) {
        buckletService.setVisitsAndExpiryDate(customer);
        customerService.editCustomer(customer);
        return "redirect:/customer/all";
    }

    //     odnawianie karnetu
    @GetMapping ("/renew/{clientId}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String renewBucklet(@PathVariable int clientId, Model model){
        Customer customer = customerService.findById(clientId);
        List<Bucklet> bucklets = buckletService.showAll();
        model.addAttribute("customer", customer);
        model.addAttribute("bucklets", bucklets);
        model.addAttribute("newDateSet", customer.getExpiryDate().plusDays(1));
        return "customers/renew";
    }

    @PostMapping("/renew/{clientId}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String renewBucklet(@PathVariable int clientId, int buckletType, String date){
        if(date.isEmpty()){
            return "customers/renew";
        }
        Customer customer = customerService.findById(clientId);
        List<Bucklet> bucklet = buckletService.showAll();
        customer.setPurchaseDate(Date.valueOf(LocalDate.parse(date)));
        for (Bucklet b: bucklet){
            if(b.getBuckletId() == buckletType){
                customer.setBucklet(b);
                customer.setVisitsLeft(b.getNumberOfVisits());
                customer.setExpiryDate(LocalDate.parse(date).plusDays(customer.getBucklet().getValidity()));
            }
        }
        customerService.editCustomer(customer);
        return "redirect:/customer/all";
    }

    @GetMapping("/presence")
    public String notePresence(HttpServletRequest request, HttpServletResponse response, Model model){
        List <Cookie> cookiesList = List.of(request.getCookies());
        String info = null;
        for(Cookie c : cookiesList){
            if(c.getName().equals("info")){
                info = c.getValue();
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        if(info != null){
            model.addAttribute("info", info);
        }
        return "customers/presence";
    }

    @PostMapping("/presence")
    public String notePresence(@RequestParam String cartNumber, HttpServletResponse response) {
        try {
            customerService.notePresence(cartNumber);
            Cookie c = new Cookie("info", "1");
            c.setPath("http://localhost:8080/customer/presence");
            response.addCookie(c);
        } catch (NullPointerException e){
            Cookie c = new Cookie("info", "0");
            c.setPath("http://localhost:8080/customer/presence");
            response.addCookie(c);
        }
        return "redirect:/customer/presence";
    }

    //export do excela
    @GetMapping("/export")
    public String exportToExcel() throws WriteException, IOException {
        jExcel.exportToExcel(customerService.showALL(), "NewExport");
        return "redirect:/customer/all";
    }

    @GetMapping("/delete/{clientId}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String deleteCustomer(@PathVariable int clientId){
        Customer customer = customerService.findById(clientId);
        customerService.deleteCustomer(customer);
        return "redirect:/customer/all";
    }

}
