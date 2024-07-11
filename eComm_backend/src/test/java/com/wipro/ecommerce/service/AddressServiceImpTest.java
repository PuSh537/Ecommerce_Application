package com.wipro.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.ecommerce.dto.AddressDTO;
import com.wipro.ecommerce.entity.Address;
import com.wipro.ecommerce.service.IAddressService;
@SpringBootTest
class AddressServiceImpTest {
	
	@Autowired
	IAddressService service;

	@Test
	void testAddAddress() {
		
		AddressDTO addressDTO = new AddressDTO(2," D.NO- 3-16B-63, ABC COLONY","XYZ NAGAR, GACHIBOWLI","533003","Hyderabad","Telangana","India");
		//fail("Not yet implemented");
		Address address = service.addAddress(addressDTO);
		assertEquals(2,address.getAddressId());
	}

	@Test
	void testUpdateAddress() {
		AddressDTO addressDTO = new AddressDTO(3," D.NO- 432,SDF COLONY","DER NAGAR, LB NAGAR","532004","Hyderabad","Telangana","India");
		Address address = service.addAddress(addressDTO);
		AddressDTO addressDTO2 = new AddressDTO(3," D.NO- 432,SDF COLONY","JHG NAGAR, LB NAGAR","532104","Hyderabad","Telangana","India");
		Address address2 = service.updateAddress(addressDTO2);
		assertEquals("532104",address2.getPostalCode());
		
	}

	@Test
	void testDeleteAddressById() {
		//fail("Not yet implemented");
		AddressDTO addressDTO = new AddressDTO(4," D.NO- 7856,GOOD COLONY","GREAT NAGAR","562004","Hyderabad","Telangana","India");
		Address address = service.addAddress(addressDTO);
		String delete = service.deleteAddressById(address.getAddressId());
		assertNotEquals(null,delete);
	}

	@Test
	void testGetAddressById() {
		//fail("Not yet implemented");
		AddressDTO addressDTO = new AddressDTO(5," D.NO- 7856,GOOD COLONY","GREAT NAGAR","562004","Hyderabad","Telangana","India");
		Address address = service.addAddress(addressDTO);
		AddressDTO addressdto2 = service.getAddressById(address.getAddressId());
		assertEquals(5,addressdto2.getAddressId());
		
	}

	@Test
	void testGetAllAddress() {
		//fail("Not yet implemented");
		List list = service.getAllAddress();
		int size = list.size();

		assertNotEquals(0,size);
	}

}
