package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.idao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;
	
	
	@Override
	@Transactional
	public Integer saveWhUserType(WhUserType wutobj) {


		return dao.saveWhUserType(wutobj);
	}

	@Override
	@Transactional
	public void updateWhUserType(WhUserType wutobj) {

          dao.updateWhUserType(wutobj);

	}

	@Override
	@Transactional
	public void deleteWhUserType(Integer wutid) {
             dao.deleteWhUserType(wutid);

	}

	@Override
	@Transactional(readOnly=true)
	public WhUserType getWhUserTypeById(Integer wutid) {
		
		return dao.getWhUserTypeById(wutid);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserTypes() {
		
		return dao.getAllWhUserTypes();
	}

}
