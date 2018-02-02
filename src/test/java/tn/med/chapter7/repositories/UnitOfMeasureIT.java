package tn.med.chapter7.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.med.chapter7.models.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureIT {
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void findByUom() throws Exception {
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByUom("mg");
		assertEquals("mg", uomOptional.get().getUom());
	}
}
