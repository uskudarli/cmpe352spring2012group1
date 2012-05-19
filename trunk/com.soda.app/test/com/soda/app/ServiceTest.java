package com.soda.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceTest 
{

	@Test
	public void testSetServiceID() 
	{
		Service tester = new Service();
		assertEquals("Result", false, tester.setServiceID(-5));
	}

}
