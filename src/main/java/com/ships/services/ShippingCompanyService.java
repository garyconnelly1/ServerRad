package com.ships.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ships.model.ShippingCompany;
import com.ships.repositories.ShipCompanyInterface;


@Service
public class ShippingCompanyService {
	
	@Autowired
	private ShipCompanyInterface companyInterface;
	
	//access the db
		public ArrayList<ShippingCompany> listAll() {
			return (ArrayList<ShippingCompany>) companyInterface.findAll();
		}//end list all

}
