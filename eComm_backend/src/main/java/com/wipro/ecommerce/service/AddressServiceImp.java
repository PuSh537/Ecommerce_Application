package com.wipro.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.AddressDTO;
import com.wipro.ecommerce.entity.Address;
import com.wipro.ecommerce.repository.AddressRepository;

@Service
public class AddressServiceImp implements IAddressService {
	@Autowired
	AddressRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(AddressServiceImp.class);

	@Override
	public Address addAddress(AddressDTO addressDTO) {
		logger.info("Adding new address: " + addressDTO);
		Address address = new Address();
		address.setAddressId(addressDTO.getAddressId());
		address.setAddressLine1(addressDTO.getAddressLine1());
		address.setAddressLine2(addressDTO.getAddressLine2());
		address.setCity(addressDTO.getCity());
		address.setCountry(addressDTO.getCountry());
		address.setCustomer(addressDTO.getCustomer());
		address.setPostalCode(addressDTO.getPostalCode());
		address.setState(addressDTO.getState());

		return repo.save(address);
	}

	@Override
	public Address updateAddress(AddressDTO addressDTO) {

		Address address = new Address();
		address.setAddressId(addressDTO.getAddressId());
		address.setAddressLine1(addressDTO.getAddressLine1());
		address.setAddressLine2(addressDTO.getAddressLine2());
		address.setCity(addressDTO.getCity());
		address.setCountry(addressDTO.getCountry());
		address.setCustomer(addressDTO.getCustomer());
		address.setPostalCode(addressDTO.getPostalCode());
		address.setState(addressDTO.getState());
		logger.info("Address updated");
		return repo.save(address);
	}

	@Override
	public String deleteAddressById(int addressId) {

		logger.info("Deleting address with Id: " + addressId);

		repo.deleteById(addressId);

		return "Address with addressId " + addressId + " deleted.";
	}

	@Override
	public AddressDTO getAddressById(int addressId) {

		Address address = repo.findById(addressId).orElse(null);
		if (address == null) {
			logger.warn("Address with ID " + addressId + "not found.");
			return null;
		}
		AddressDTO dto = new AddressDTO();
		dto.setAddressId(address.getAddressId());
		dto.setAddressLine1(address.getAddressLine1());
		dto.setAddressLine2(address.getAddressLine2());
		dto.setCity(address.getCity());
		dto.setCountry(address.getCountry());
		dto.setCustomer(address.getCustomer());
		dto.setPostalCode(address.getPostalCode());
		dto.setState(address.getState());
		logger.info("Address fetched successfully");
		return dto;
	}

	@Override
	public List<Address> getAllAddress() {
		logger.info("Fetching all addresses...");
		return repo.findAll();
	}

}
