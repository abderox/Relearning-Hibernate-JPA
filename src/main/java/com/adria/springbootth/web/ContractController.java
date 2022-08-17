package com.adria.springbootth.web;


import com.adria.springbootth.entities.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import com.adria.springbootth.repositories.ContratRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="/adria")
public class ContractController {


    private ContratRepository contratRepository;

    public ContractController(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @GetMapping(path="/")
    public String index() {
        return "index";
    }

    @GetMapping(path="/contrats")
    public String contrats(Model model , @RequestParam(name="size" , defaultValue = "5") int size ,@RequestParam(name="page" , defaultValue = "0") int page ,@RequestParam(name="search" ,defaultValue = "") String search) {
        Page<Contrat> contrats = contratRepository.findByTitleContaining(search, PageRequest.of(page, size));

        model.addAttribute("listContracts", contrats);
        return "contracts";
    }

    @GetMapping(path="/contrats/delete")
    public String deleteContract(@RequestParam(name = "id") Long id, @RequestParam(name="page",defaultValue="0") int page) {
        contratRepository.deleteById(id);
        return "redirect:/adria/contrats?page="+page;
    }
    @GetMapping(path="/activate")
    public String activate(@RequestParam(name = "id") Long id , @RequestParam(name="page",defaultValue="0") int page) {
        Contrat c = contratRepository.findById(id).get();
        c.setCloture(!c.isCloture());
        contratRepository.save(c);
        return "redirect:/adria/contrats?page="+page;
    }

    @GetMapping(path="/addContrat")
    public String createContrat(Model model) {
        Contrat contrat = new Contrat();
        model.addAttribute("contrat", contrat);
        return "form_contrat";
    }

    // ! store validation in binding result
    @PostMapping(path="/saveContrat")
    public String addContrat(@Valid Contrat contrat, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form_contrat";
        }
        contratRepository.save(contrat);
        return "redirect:/adria/contrats";
    }




}
