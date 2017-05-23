package com.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwrackController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwrackControllerTest {
	
	@InjectMocks
	ShipwrackController objShipwrackController;
	
	@Mock
	ShipwreckRepository objShipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void testShipwrackController(){
		Shipwreck objsw = new Shipwreck();
		objsw.setId(1l);
		when(objShipwreckRepository.findOne(1l)).thenReturn(objsw);
		
		//verify(objShipwreckRepository).findOne(1l);
		
		Shipwreck sw = objShipwrackController.get(1L);
		assertEquals(1l, sw.getId().longValue());
	}
}
