package pl.sportplusopole.bucklet;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("/bucklet")
@RequiredArgsConstructor
public class BuckletController {

    private final BuckletService buckletService;

    @GetMapping("/all")
    public String showAllBucklets (Model model){
        int size = buckletService.showAll().size();
        model.addAttribute("bucklets", buckletService.showAll());
        model.addAttribute("size", size);
        return "bucklets/all";
    }

    @GetMapping("/add")
    public String addBucklet(Model model){
        model.addAttribute("bucklet", new Bucklet());
        return "bucklets/add";
    }

    @PostMapping("/add")
    public String addBucklet(@Valid Bucklet bucklet, BindingResult result){
        if(result.hasErrors()){
            return "bucklets/add";
        }
        buckletService.addBucklet(bucklet);
        return "redirect:/bucklet/all";
    }

    @GetMapping("edit/{buckletId}")
    public String editBucklet(@PathVariable int buckletId, Model model){
        model.addAttribute("bucklet", buckletService.findById(buckletId));
        return "/bucklets/add";
    }

    @PostMapping("edit/{buckletId}")
    public String editBucklet(Bucklet bucklet){
        buckletService.editBucklet(bucklet);
        return "redirect:/bucklet/all";
    }

    @GetMapping("delete/{buckletId}")
    public String deleteBucklet(@PathVariable int buckletId){
        Bucklet bucklet = buckletService.findById(buckletId);
        try {
            buckletService.deleteBucklet(bucklet);
        }catch (Exception e){
            return "bucklets/warning";
        }
        return "redirect:/bucklet/all";
    }

}
