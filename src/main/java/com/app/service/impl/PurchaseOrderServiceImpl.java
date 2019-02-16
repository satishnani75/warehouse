package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.idao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDao dao;
	
	
	@Override
	@Transactional
	public Integer savePurchaserOrder(PurchaseOrder pobj) {
		return dao.savePurchaserOrder(pobj);
	}

	@Override
	@Transactional
	public void updatePurchaserOrder(PurchaseOrder pobj) {

		
		dao.updatePurchaserOrder(pobj);
	}

	@Override
	@Transactional
	public void deletePurchaserOrder(Integer pid) {

		
		dao.deletePurchaserOrder(pid);
	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaserOrder(Integer pid) {
		return dao.getOnePurchaserOrder(pid);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchases() {
		return dao.getAllPurchases();
	}

}
