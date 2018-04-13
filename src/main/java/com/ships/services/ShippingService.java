package com.ships.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShippingInterface;

@Service
public class ShippingService {
	
	@Autowired
	private ShippingInterface shipInterface;
	
	//access the db
	public ArrayList<Ship> listAll() {
		return (ArrayList<Ship>) shipInterface.findAll();
	}
	
	public Ship addShip(Ship ship) {
		return shipInterface.save(ship);
	}

}
