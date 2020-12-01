package com.gil.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>
{
	Item findItemByName(String name);
	
	Item findItemByCode(String code);
}