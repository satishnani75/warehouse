package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {

public Integer saveItem(Item iobj);
	
	
	public void deleteItem(Integer itemId); 
	
	
	public Item getItemById(Integer itemId);
	
	public List<Item> getAllItems();
	
	public void update(Item iobj);
	
}
