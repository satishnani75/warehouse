package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.idao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao dao;
	
	@Override
	@Transactional
	public Integer saveItem(Item iobj) {

		
		
		return dao.saveItem(iobj);
	}

	@Override
	@Transactional
	public void deleteItem(Integer itemId) {

		dao.deleteItem(itemId);
		
	}

	@Override
	@Transactional
	public Item getItemById(Integer itemId) {

		return dao.getItemById(itemId);
	}

	@Transactional(readOnly=true)
	public List<Item> getAllItems() {

		
		return dao.getAllItems();
	}

	
	
	@Override
	@Transactional
	public void update(Item iobj) {
		
		
		dao.update(iobj);
	}
}
