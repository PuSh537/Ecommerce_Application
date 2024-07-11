package com.wipro.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.wipro.ecommerce.dto.CategoryDTO;
import com.wipro.ecommerce.dto.SubCategoryDTO;
import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.entity.SubCategory;
import com.wipro.ecommerce.exception.CategoryNotFoundException;
import com.wipro.ecommerce.exception.SubCategoryNotFoundException;
import com.wipro.ecommerce.service.ICategoryService;
import com.wipro.ecommerce.service.ISubCategoryService;

import ch.qos.logback.classic.Logger;
import jakarta.transaction.Transactional;
@SpringBootTest
class SubCategoryServiceImpTest {
	
	@Autowired
	ISubCategoryService service;
	@Autowired
	ICategoryService service2;

	@Test
	void testAddSubCategory() throws CategoryNotFoundException {
		//fail("Not yet implemented");
		CategoryDTO categorydto = service2.getCategoryById(101);
		Category category = service2.updateCategory(categorydto);
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO(201,"Shirts",category);
		SubCategory subCategory = service.addSubCategory(subCategoryDTO);
		assertEquals("Shirts",subCategory.getSubCategoryName());
	}

	@Test
	void testUpdateSubCategory() throws CategoryNotFoundException, SubCategoryNotFoundException {
		//fail("Not yet implemented");
		CategoryDTO categorydto = service2.getCategoryById(101);
		Category category = service2.updateCategory(categorydto);
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO(202,"T-shirts",category);
		SubCategory subCategory = service.addSubCategory(subCategoryDTO);
		SubCategoryDTO subCategoryDTO2 = new SubCategoryDTO(202,"T Shirts",category);
		SubCategory subCategory2 = service.updateSubCategory(subCategoryDTO2);
		assertEquals("T Shirts",subCategory2.getSubCategoryName());
	}

	@Test
	void testDeleteSubCategoryById() throws CategoryNotFoundException, SubCategoryNotFoundException {
		//fail("Not yet implemented");
		CategoryDTO categorydto = service2.getCategoryById(101);
		Category category = service2.updateCategory(categorydto);
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO(203,"Jeans",category);
		SubCategory subCategory = service.addSubCategory(subCategoryDTO);
		String delete = service.deleteSubCategoryById(subCategory.getSubCategoryId());
		assertNotEquals(null,delete);
	}

	@Test
	void testGetSubCategoryById() throws CategoryNotFoundException, SubCategoryNotFoundException {
		//fail("Not yet implemented");
		CategoryDTO categorydto = service2.getCategoryById(102);
		Category category = service2.updateCategory(categorydto);
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO(301,"TV",category);
		SubCategory subCategory = service.addSubCategory(subCategoryDTO);
		SubCategoryDTO subCategoryDTO2 = service.getSubCategoryById(subCategory.getSubCategoryId());
		assertEquals(301,subCategoryDTO2.getSubCategoryId());
		
	}

	@Test
	void testGetAllSubCategory() {
		//fail("Not yet implemented");
		List list = service.getAllSubCategory();
		int size = list.size();

		assertNotEquals(0,size);
	}

}
