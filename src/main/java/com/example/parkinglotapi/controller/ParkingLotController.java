package com.example.parkinglotapi.controller;

import com.example.parkinglotapi.dto.ParkingRegistryDto;
import com.example.parkinglotapi.dto.VehicleDataDto;
import com.example.parkinglotapi.exception.NoSpotException;
import com.example.parkinglotapi.exception.VehicleTooTallException;
import com.example.parkinglotapi.exception.WeightCapacityException;
import com.example.parkinglotapi.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/parking-lot")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PutMapping("/allocate-vehicle")
    public ResponseEntity<ParkingRegistryDto> allocateVehicle(@RequestBody VehicleDataDto vehicleDataDto)
            throws NoSpotException, VehicleTooTallException, WeightCapacityException {
        return new ResponseEntity<>(parkingLotService.allocateVehicle(vehicleDataDto), HttpStatus.OK);
    }

}
