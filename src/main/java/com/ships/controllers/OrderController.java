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
	/*
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String getShip(@ModelAttribute("shipAdd") Ship s, HttpServletRequest h) {
		return "addShip";
	}//end getShip
	*/

}
