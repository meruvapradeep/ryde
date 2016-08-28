package com.ryde.fm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ryde.fm.domain.Type;
import com.ryde.fm.domain.Vehicle;
import com.ryde.fm.domain.VehicleStatus;
import com.ryde.repository.VehicleRepository;

import javassist.tools.web.BadHttpRequest;

import javax.annotation.Resource;


@Service
public class FleetService {

	 @Resource
	 private VehicleRepository vehicleRepository;
	
	
    public List<Vehicle> getVehicles() {    	
    	return vehicleRepository.findAll();
    }
    
      public List<Vehicle> fetchByStatus(String status){     	
    	if(status.equalsIgnoreCase("ALL") || status.isEmpty())
  		  return vehicleRepository.findAll();
  	  else
  		  return vehicleRepository.findByStatus(VehicleStatus.valueOf(status));
    }
     
      public List<Vehicle> fetchByType(String type){     	  
    	  if(type.equalsIgnoreCase("ALL") || type.isEmpty())
    		  return vehicleRepository.findAll();
    	  else
    		  return vehicleRepository.findByType(Type.valueOf(type));      	
      }
      
    
    
    public List<Vehicle> getVehicleFallback() {
	
	System.out.println("FleetService.getVehicleFallback()");
	Vehicle v2 = new Vehicle();
	v2.setId((long) 22);
	v2.setMake("Toyota2");
	v2.setModel("Camry2");
	v2.setVin("BBB222");
	
	List<Vehicle> fleet = new ArrayList<Vehicle>();

	//fleet.add(v1);
	fleet.add(v2);

	return fleet;
    }
    
    public Vehicle createVehicle( Vehicle vehicle){
    	
    	return vehicleRepository.save(vehicle);
    }

	public Vehicle updateVehicle(long id, Vehicle vehicle) throws Exception {
		
		Vehicle existingVehicle =  vehicleRepository.findOne(id);
		
		if(existingVehicle != null){
			vehicle.setId(existingVehicle.getId());
			existingVehicle = vehicleRepository.save(vehicle);
		}else{
			
			throw new Exception("Vehicle with not found with ID : " +id);
		}
	
		return existingVehicle;
		
	}

	public Vehicle getVehicleById(long id) {
		
		return  vehicleRepository.findOne(id);
	}

	public void deleteVehicle(long id) {
	
		vehicleRepository.delete(id);
		
	}

}
