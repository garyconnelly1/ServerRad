package com.ships.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import com.ships.model.ShippingCompany;
import com.ships.services.OrderService;
import com.ships.services.ShippingService;
import com.ships.services.ShippingCompanyService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//so we can access a list of ships
	@Autowired
	private ShippingService shipService;
	
	//so we can access a list of shipping companies
	@Autowired
	private ShippingCompanyService companyService;
	
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getOrders(Model m) {

		ArrayList<OrderInfo> orders = orderService.listAll();
		m.addAttribute("orders", orders);

		return "showOrders";
	}//end getShips
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String getOrder(@ModelAttribute("orderAdd") OrderInfo o, HttpServletRequest h, Model m) {
		
ArrayList<Ship> ships = shipService.listAll();
		
		Map<Long,String> orderShipList = new HashMap<Long,String>();
		
		//for each ship object returned from the database
		for (Ship s : ships) {	
			
				//insert details into the orderShipList
				orderShipList.put((long) s.getSid(), s.getName() + ", Cost = " + s.getCost());
			
		}//end for each
		
		m.addAttribute("shippingList", orderShipList);
		
		ArrayList<ShippingCompany> companies = companyService.listAll();
		
		Map<Long,String> companyList = new HashMap<Long,String>();
		
		for (ShippingCompany sc : companies) {	
			companyList.put((long) sc.getScid(), sc.getName() + ", Balance = " + sc.getBalance());
		}
		
		m.addAttribute("orderCompanyList", companyList);
		
		
		
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
