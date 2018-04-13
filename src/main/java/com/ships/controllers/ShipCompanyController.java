package com.ships.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;

@Controller
public class ShipCompanyController {
	
	@Autowired
	private ShippingCompanyService companyService;
	
	@RequestMapping(value = "/showShippingCompanies", method = RequestMethod.GET)
	public String getShipCompanies(Model m) {

		ArrayList<ShippingCompany> companies = companyService.listAll();
		m.addAttribute("companies", companies);

		return "showShippingCompanies";
	}//end getShips
	
	@RequestMapping(value = "/addShippingCompany", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("shipAdd") Ship s, HttpServletRequest h) {
		return "addShippingCompany";
	}//end getShip
	
	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("shipAdd") Ship s, BindingResult result, HttpServletRequest h, Model m) {
		
		if (result.hasErrors()) {
			return "addShip";
		} else {
			shipService.addShip(s);
			
			ArrayList<Ship> ships = shipService.listAll();
	
			m.addAttribute("ships", ships);
			//once the ship has been successfully added, redirect them to the show ships page to see the ship they added
			return "showShips";
		}
	}//end addShip method

}
