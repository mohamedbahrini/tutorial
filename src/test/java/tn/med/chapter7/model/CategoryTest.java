package tn.med.chapter7.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tn.med.chapter7.models.Category;

public class CategoryTest {
	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void getId() throws Exception {
		Long id = 4L;
		category.setId(id);
		assertEquals(4L, category.getId(), 0);
	}
}
