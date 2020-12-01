package com.gil.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no;
	
	@Column(unique=true)
	private String name;
	
	@Column
	private int qty;
	
	@Column(unique=true)
	private String code;
	
	
	public Item() {}
	
	public Item(int no, String name, int qty, String code)
	{
		this.no=no;
		this.name=name;
		this.qty=qty;
		this.code=code;
	}


	public int getNo()
	{
		return no;
	}
	
	public String getName()
	{
		return name;
	}

	public int getQty()
	{
		return qty;
	}

	public void setQty(int qty)
	{
		this.qty=qty;
	}

	public String getCode()
	{
		return code;
	}

	
	@Override
	public String toString()
	{
		return "Item no: "+no+", Name: "+name+", Quantity: "+qty+", Inventory code: "+code;
	}
}