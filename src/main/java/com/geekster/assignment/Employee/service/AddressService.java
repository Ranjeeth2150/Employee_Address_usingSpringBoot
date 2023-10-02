package com.geekster.assignment.Employee.service;

import com.geekster.assignment.Employee.model.Address;
import com.geekster.assignment.Employee.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepo addressRepo;
    @Autowired
    public AddressService(AddressRepo addressRepository) {
        this.addressRepo = addressRepository;
    }
    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public Address getAddressById(Long id) {
        Optional<Address> address = addressRepo.findById(id);
        return address.orElse(null);
    }

    public void createAddress(Address address) {
        addressRepo.save(address);
    }

    public void updateAddress(Long id, Address updatedAddress) {
        Optional<Address> address = addressRepo.findById(id);
        if (address.isPresent()) {
            Address existingAddress = address.get();
            existingAddress.setStreet(updatedAddress.getStreet());
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setState(updatedAddress.getState());
            existingAddress.setZipCode(updatedAddress.getZipCode());
            addressRepo.save(existingAddress);
        }
    }

    public void deleteAddress(Long id) {
        addressRepo.deleteById(id);
    }
}


