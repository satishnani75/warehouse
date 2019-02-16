package com.app.idao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderDao {

	public Integer savePurchaserOrder(PurchaseOrder pobj);
	
	public void updatePurchaserOrder(PurchaseOrder pobj);
	
	public void deletePurchaserOrder(Integer pid);
	
	public PurchaseOrder getOnePurchaserOrder( Integer pid);
	
	public List<PurchaseOrder> getAllPurchases();
	
	
	
	
	
	
}
