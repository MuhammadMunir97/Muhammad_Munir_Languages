package com.muhammad.languages.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.muhammad.languages.modell.Language;
import com.muhammad.languages.service.LanguageService;

@Controller
public class LanguageController {

	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/language")
	public String index(Model model, @ModelAttribute("newLanguage") Language language) {
		List<Language> allLanguages = languageService.findAllLanguages();
		model.addAttribute("languages" , allLanguages);
		return "/language/Index.jsp";
	}

	
	@RequestMapping(value="/language" , method=RequestMethod.POST)
	public String create (@Valid @ModelAttribute("newLanguage") Language language, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "/language/Index.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/language";
        }
	}
	
	@RequestMapping("/language/{id}")
	public String languageById(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("languageById" , language);
		return "/language/Show.jsp";
	}
	
	@RequestMapping("/language/{id}/edit")
	public String languageFormForUpdate(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language" , language);
		return "/language/View.jsp";
	}
	
	@RequestMapping(value="/language/{id}" , method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language , BindingResult result) {
		if (result.hasErrors()) {
            return "/language/View.jsp";
        } else {
        	languageService.updateLanguage(language);;
            return "redirect:/language";
        }
	}
	
	@RequestMapping(value="/language/{id}" , method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/language";
	}
}
