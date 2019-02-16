package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.idao.IItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveItem(Item iobj) {
		
		 
		
		return (Integer) ht.save(iobj);
	}

	@Override
	public void deleteItem(Integer itemId) {

		ht.delete(new Item(itemId));
		
		
		
	}

	@Override
	public Item getItemById(Integer itemId) {

		
		
		return ht.get(Item.class, itemId);
	}

	@Override
	public List<Item> getAllItems() {
		
		
		
		return ht.loadAll(Item.class);
	}

	
	
	@Override
	public void update(Item iobj) {

		ht.update(iobj);
		
	}
}
