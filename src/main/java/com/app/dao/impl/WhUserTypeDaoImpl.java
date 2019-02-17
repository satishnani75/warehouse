package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.idao.IWhUserTypeDao;
import com.app.model.WhuserType;


@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer saveWhUserType(WhuserType wutobj) {
		
		return (Integer) ht.save(wutobj);
	}

	@Override
	public void updateWhUserType(WhuserType wutobj) {

        ht.update(wutobj);

	}

	@Override
	public void deleteWhUserType(Integer wutid) {

            ht.delete(new WhuserType(wutid));

	}

	@Override
	public WhuserType getWhUserTypeById(Integer wutid) {
		
		return ht.get(WhuserType.class, wutid);
	}

	@Override
	public List<WhuserType> getAllWhUserTypes() {
		
		return ht.loadAll(WhuserType.class) ;
	}

}
