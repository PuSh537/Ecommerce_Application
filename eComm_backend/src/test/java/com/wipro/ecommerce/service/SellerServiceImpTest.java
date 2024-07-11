package com.wipro.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.ecommerce.dto.SellerDTO;
import com.wipro.ecommerce.entity.Seller;
import com.wipro.ecommerce.exception.SellerNotFoundException;
import com.wipro.ecommerce.service.ISellerService;

import jakarta.transaction.Transactional;
@SpringBootTest
@Transactional
class SellerServiceImpTest {
	
	@Autowired
	ISellerService service;

	@Test
	void testAddSeller() throws SellerNotFoundException {
		SellerDTO sellerDTO = new SellerDTO(101,"Bhaskar","Raymond","9848283421","raymond@gmail.com","Mumbai","Clothing","bh@sk@r123","bhaskar@123","seller",null,null);
		SellerDTO seller = service.registerSeller(sellerDTO);
		assertEquals(101,seller.getSellerId());
	}

	@Test
	void testUpdateSeller() throws SellerNotFoundException {
		SellerDTO sellerDTO = new SellerDTO(102,"Ranjeeth","LOUIS PHILIPPE","8074537575","louisphilippe@gmail.com","Hyderabad","Clothing","Ranjeeth*1","ranjeeth@1","seller",null,null);
		SellerDTO seller = service.registerSeller(sellerDTO);
		SellerDTO sellerDTO2 = new SellerDTO(102,"Ranjeeth","LOUIS PHILIPPE","9392029482","louisphilippe@gmail.com","Hyderabad","Clothing","Ranjeeth*1","ranjeeth@1","seller",null,null);
		Seller seller2 = service.updateSeller(sellerDTO2);
		assertEquals("9392029482",seller2.getPhoneNumber());
	}

	@Test
	void testDeleteSellerById() throws SellerNotFoundException {
		SellerDTO sellerDTO = new SellerDTO(104,"John","ASUS","7124932415","asus@gmail.com","Chennai","Electronics","John@234","John@1","seller",null,null);
		SellerDTO seller = service.registerSeller(sellerDTO);
		String delete = service.deleteSellerById(seller.getSellerId());
		assertNotEquals(null,delete);
		
	}

	@Test
	void testGetSellerById() throws SellerNotFoundException {
		SellerDTO sellerDTO = new SellerDTO(103,"Ramesh","SAMSUNG","8435242468","samsung@gmail.com","Kochi","Electronics","RamEsh#999","ramesh@1","seller",null,null);
		SellerDTO seller = service.registerSeller(sellerDTO);
		SellerDTO sellerDTO2 = service.getSellerById(seller.getSellerId());
		assertEquals(103,sellerDTO2.getSellerId());
	}

	@Test
	void testGetAllSeller() {
		List list = service.getAllSeller();
		int size = list.size();

		assertNotEquals(0,size);
	}

}

