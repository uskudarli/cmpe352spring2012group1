package com.soda.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceTest 
{

	public final static int SERVICE_ID = -5;
	
	@Test
	public void testSetServiceID() 
	{
		Service tester = new Service(SERVICE_ID);
		assertEquals("Result", false, tester.setServiceID(SERVICE_ID));		
	}
	
	@Test
	public void testConstructor() 
	{
		Service tester = new Service(SERVICE_ID);
		assertFalse(tester.getServiceID() == SERVICE_ID);
	}
}
