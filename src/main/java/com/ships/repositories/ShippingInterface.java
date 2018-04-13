package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.Ship;

public interface ShippingInterface extends CrudRepository<Ship, Long> {

}
