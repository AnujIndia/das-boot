package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boot.controller.HomeController;


/**
 * Unit test for simple App.
 */
public class AppTest{
	@Test
    public void testApp()
    {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "Webclome to Spring Boot");
    }
}
