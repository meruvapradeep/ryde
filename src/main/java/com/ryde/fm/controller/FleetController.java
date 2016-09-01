package com.ryde.fm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ryde.fm.domain.InsuranceMode;
import com.ryde.fm.domain.Title;
import com.ryde.fm.domain.Type;
import com.ryde.fm.domain.Vehicle;
import com.ryde.fm.domain.VehicleStatus;
import com.ryde.fm.service.FleetService;

@RestController
public class FleetController {

	@Autowired
	FleetService fleetService;

	@RequestMapping(value = "/vehicles", method = RequestMethod.GET, produces = "application/json")
	public List<Vehicle> getVehicles() {

		System.out.println("FleetController.getVehicles()");

		return fleetService.getVehicles();

	}

	@RequestMapping(value = "/vehiclesByStatus/{status}", method = RequestMethod.GET, produces = "application/json")
	public List<Vehicle> getVehiclesByStatus(@PathVariable("status") String status) {

		System.out.println("FleetController.getVehiclesByStatus()");

		return fleetService.fetchByStatus(status);

	}

	@RequestMapping(value = "/vehiclesByType/{type}", method = RequestMethod.GET, produces = "application/json")
	public List<Vehicle> getVehiclesByType(@PathVariable("type") String type) {

		System.out.println("FleetController.getVehiclesByStatus()");

		return fleetService.fetchByType(type);

	}

	@RequestMapping(value = "/vehicles", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {

		Vehicle createdVehicle = fleetService.createVehicle(vehicle);

		return new ResponseEntity<Vehicle>(createdVehicle, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/vehicles/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") long id, @RequestBody Vehicle vehicle)
			throws Exception {

		Vehicle updatedVehicle = fleetService.updateVehicle(id, vehicle);

		return new ResponseEntity<Vehicle>(updatedVehicle, HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "/vehicles/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") long id) throws Exception {

		Vehicle vehicle = fleetService.getVehicleById(id);

		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);

	}

	@RequestMapping(value = "/vehicles/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity deleteVehicle(@PathVariable("id") long id) throws Exception {

		fleetService.deleteVehicle(id);

		return new ResponseEntity(HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "/vehicleTypes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Type[]> getVehicleTypes() {

		return new ResponseEntity<Type[]>(Type.values(), HttpStatus.OK);
	}

	@RequestMapping(value = "/titleTypes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Title[]> getTitleTypes() {

		return new ResponseEntity<Title[]>(Title.values(), HttpStatus.OK);
	}

	@RequestMapping(value = "/vehicleStatusValues", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<VehicleStatus[]> getVehicleStatusValues() {

		return new ResponseEntity<VehicleStatus[]>(VehicleStatus.values(), HttpStatus.OK);
	}

	@RequestMapping(value = "/insuranceModeValues", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<InsuranceMode[]> getInsuranceModeValues() {

		return new ResponseEntity<InsuranceMode[]>(InsuranceMode.values(), HttpStatus.OK);
	}

	
	
	
}