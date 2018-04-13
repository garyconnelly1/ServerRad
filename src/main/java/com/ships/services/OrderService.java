package com.ships.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ships.model.OrderInfo;

import com.ships.repositories.OrderInterface;


@Service
public class OrderService {
	
	@Autowired
	private OrderInterface orderInterface;
	
	//access the db
			public ArrayList<OrderInfo> listAll() {
				return (ArrayList<OrderInfo>) orderInterface.findAll();
			}//end list all
			
			//add an order
			public OrderInfo addOrder(OrderInfo order) {
				return orderInterface.save(order);
			}//end add order

}
