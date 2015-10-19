package wad.controller;

import wad.domain.Koe;
import wad.repository.KoeRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/kokeet")
public class KoeController {

    @Autowired
    private KoeRepository koeRepository;

    @ModelAttribute("koe")
    private Koe getKoe() {
        return new Koe();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("kokeet", koeRepository.findAll());
        return "redirect:/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Koe koe,
            BindingResult result) {
        if (result.hasErrors()) {
            return "kokeet";
        }

        koeRepository.save(koe);
        return "redirect:/index";
    }
}
