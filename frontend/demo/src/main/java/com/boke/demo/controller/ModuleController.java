package com.boke.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/module")
public class ModuleController {
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "王镇");

        return "index";
    }
    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "王镇");

        return "about";
    }
    @RequestMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("name", "王镇");

        return "gallery";
    }
    @RequestMapping("/mail")
    public String mail(Model model) {
        model.addAttribute("name", "王镇");

        return "mail";
    }
    @RequestMapping("/services")
    public String services(Model model) {
        model.addAttribute("name", "王镇");

        return "services";
    }
    @RequestMapping("/short-codes")
    public String shortCodes(Model model) {
        model.addAttribute("name", "王镇");

        return "short-codes";
    }
    @RequestMapping("/single")
    public String single(Model model) {
        model.addAttribute("name", "王镇");

        return "single";
    }
}
