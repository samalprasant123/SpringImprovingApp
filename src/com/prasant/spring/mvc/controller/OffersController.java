package com.prasant.spring.mvc.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prasant.spring.mvc.model.Offer;
import com.prasant.spring.mvc.service.OfferService;

@Controller
public class OffersController {
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getOffers();
		model.addAttribute("offers", offers);
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model, Principal principal) {
		Offer offer = null;
		if (principal != null && principal.getName() != null) {
			offer = offerService.getOffers(principal.getName());
		}
		
		if (offer == null) {
			offer = new Offer();
		}
		
		model.addAttribute("offer", offer);
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String offerCreated(Model model, @Valid Offer offer, BindingResult bindingResult, Principal principal) {
		if (bindingResult.hasErrors()) {
			return "createoffer";
		}
		String username = principal.getName();
		offer.getUser().setUsername(username);
		offerService.saveOrUpdate(offer);
		return "offercreated";
	}
	
}
