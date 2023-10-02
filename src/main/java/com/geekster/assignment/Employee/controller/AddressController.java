package com.geekster.assignment.Employee.controller;

import com.geekster.assignment.Employee.model.Address;
import com.geekster.assignment.Employee.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("address")
    public List<Address> getAllAddress()
    {
        return addressService.getAllAddress();
    }


    @GetMapping("address/id/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }
    @PostMapping("addresses")
    public void createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
    }

    @PutMapping("address/update/{id}")
    public void updateAddress(@PathVariable Long id, @RequestBody Address address) {
        addressService.updateAddress(id, address);
    }

    @DeleteMapping("address/del/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
