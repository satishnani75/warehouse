package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.idao.IWhUserTypeDao;
import com.app.model.WhuserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;
	
	
	@Override
	@Transactional
	public Integer saveWhUserType(WhuserType wutobj) {


		return dao.saveWhUserType(wutobj);
	}

	@Override
	@Transactional
	public void updateWhUserType(WhuserType wutobj) {

          dao.updateWhUserType(wutobj);

	}

	@Override
	@Transactional
	public void deleteWhUserType(Integer wutid) {
             dao.deleteWhUserType(wutid);

	}

	@Override
	@Transactional(readOnly=true)
	public WhuserType getWhUserTypeById(Integer wutid) {
		
		return dao.getWhUserTypeById(wutid);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhuserType> getAllWhUserTypes() {
		
		return dao.getAllWhUserTypes();
	}

}
