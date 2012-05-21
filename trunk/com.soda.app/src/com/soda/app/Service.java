package com.soda.app;

/*
 * Service base class
 * (different kind of services can be derived from this)
 * */

public class Service 
{
	/* CLASS VARIABLES */
	private int serviceID;	
	
	/* MEMBER FUNCTIONS */
	public Service(int serviceID)
	{
		this.setServiceID(serviceID);
	}
	
	public boolean setServiceID(int serviceID) 
	{
		if (serviceID < 0)
			return false;

		this.serviceID = serviceID;			
		return true;
	}

	public int getServiceID() 
	{
		return serviceID;
	}
	
	public void offer()
	{
		// TO DO
	}
	
	public void request()
	{
		// TO DO
	}
	
	public void search()
	{
		// TO DO
	}
	
	public void complementaryProcedures()
	{
		// TO DO
	}
	
	public void viewDetails()
	{
		// TO DO
	}
	
	public void sendFeedback()
	{
		// TO DO
	}	
}
