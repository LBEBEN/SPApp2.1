package pl.sportplusopole.trainer;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sportplusopole.customer.CustomerRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
@RequestMapping("/trainer")
@RequiredArgsConstructor
//@SessionAttributes({"info"})
public class TrainerController {

    private final TrainerService trainerService;
    private final CustomerRepository customerRepository;

    @RequestMapping ("/all")
    public String showAllTrainers(Model model){
        int size = trainerService.findAll().size();
        model.addAttribute("trainers", trainerService.findAll());
        model.addAttribute("size", size);
        return "trainers/all";
    }

    //lista rozwijana do typów trenerów
    @ModelAttribute("descryptions")
    public List<String> setDescryption(){
        List <String> descryption = new ArrayList<>();
        descryption.add("Sport Plus");
        descryption.add("PERSONALNY");
        return descryption;
    }

    @GetMapping("/add")
    public String addTrainer(Model model){
        model.addAttribute("trainer", new Trainer());
        return "trainers/add";
    }

    @PostMapping("/add")
    public String addTrainer(@Valid Trainer trainer, BindingResult result){
        if(result.hasErrors()){
            return "trainers/add";
        }
        trainerService.addTrainer(trainer);
        return "redirect:/trainer/all";
    }

    @GetMapping("/edit/{trainerId}")
    public String editTrainer(@PathVariable int trainerId, Model model){
        model.addAttribute("trainer", trainerService.findById(trainerId));
        return "/trainers/add";
    }

    @PostMapping("/edit/{trainerId}")
    public String editTrainer(Trainer trainer){
        trainerService.editTrainer(trainer);
        return "redirect:/trainer/all";
    }

    @ModelAttribute("views")
    public List <String> views(){
        List<String> views = new ArrayList<>();
        views.add("W klubie");
        views.add("Aktywni");
        views.add("Archiwum");
        return views;
    }

    @GetMapping("/client/{trainerId}")
    public String showAllTrainerClients(@PathVariable int trainerId, Model model){
        int size = customerRepository.coachesClients(trainerId).size();
        model.addAttribute("trainer", trainerService.findById(trainerId).getDisplayName());
        model.addAttribute("customers", customerRepository.coachesClients(trainerId));
        model.addAttribute("size", size);
        return "customers/all";
    }

    @GetMapping("/delete/{trainerId}")
    public String deleteTrainer(@PathVariable int trainerId) {
        Trainer trainer = trainerService.findById(trainerId);
        try{
            trainerService.deleteTrainer(trainer);
        } catch (Exception e){
            return "trainers/warning";
        }
        return "redirect:/trainer/all";
    }

}
