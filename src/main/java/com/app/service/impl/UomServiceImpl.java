package com.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.idao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;
@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private IUomDao dao;
	
	
	@Transactional
	public Integer saveUom(Uom uobj) {


		return dao.saveUom(uobj);
	}

	@Transactional
	public void updateUom(Uom uobj) {

                dao.updateUom(uobj);
		
		
	}

	@Transactional
	public void deleteUom(Integer uid) {	
		

		dao.deleteUom(uid);
		
	}

	@Transactional(readOnly=true)
	public Uom getUomById(Integer uid) {
		
		return dao.getUomById(uid);
	}

	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {
		
		return dao.getAllUoms();
	}

	
	@Override
	@Transactional
	public boolean isUomModelExist(String uomModel) {
		
		
		
		return dao.isUomModelExist(uomModel);
	}
	
	
	@Override
	public Map<Integer, String> getUomIdandName() {
		return dao.getUomIdandName();
	}
}
