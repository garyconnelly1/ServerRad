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
import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.services.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getOrders(Model m) {

		ArrayList<OrderInfo> orders = orderService.listAll();
		m.addAttribute("orders", orders);

		return "showOrders";
	}//end getShips
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String getOrder(@ModelAttribute("orderAdd") OrderInfo o, HttpServletRequest h) {
		return "createOrder";
	}//end getShip
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("orderAdd") OrderInfo o, BindingResult result, HttpServletRequest h, Model m) {
		
		if (result.hasErrors()) {
			return "createOrder";
		} else {
			orderService.addOrder(o);
			
			ArrayList<OrderInfo> orders = orderService.listAll();
	
			m.addAttribute("orders", orders);
			//once the ship has been successfully added, redirect them to the show ships page to see the ship they added
			return "showOrders";
		}
	}//end addShip method
	

}
