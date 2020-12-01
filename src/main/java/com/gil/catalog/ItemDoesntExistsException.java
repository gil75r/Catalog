package com.gil.catalog;

public class ItemDoesntExistsException extends Exception
{
	private static final long serialVersionUID = 1L;

	public ItemDoesntExistsException()
	{
		super("The item number you've entered doesn't exists.");
	}
}