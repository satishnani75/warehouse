package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.idao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;

@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer savePurchaserOrder(PurchaseOrder pobj) {
		return (Integer) ht.save(pobj);
	}

	@Override
	public void updatePurchaserOrder(PurchaseOrder pobj) {
             ht.update(pobj);
	}

	@Override
	public void deletePurchaserOrder(Integer pid) {

		
		ht.delete(new PurchaseOrder(pid));
	}

	@Override
	public PurchaseOrder getOnePurchaserOrder(Integer pid) {

		return ht.get(PurchaseOrder.class, pid);
	}

	@Override
	public List<PurchaseOrder> getAllPurchases() {
		return ht.loadAll(PurchaseOrder.class);
	}

}
