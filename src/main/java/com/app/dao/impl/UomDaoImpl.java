package com.app.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.idao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired       
	private HibernateTemplate ht;


	@Override
	public Integer saveUom(Uom uobj) {



		return (Integer)ht.save(uobj);
	}

	@Override
	public void updateUom(Uom uobj) {

		ht.update(uobj);


	}

	@Override
	public void deleteUom(Integer uid) {
		ht.delete(new Uom(uid));



	}

	@Override
	public Uom getUomById(Integer uid) {




		return ht.get(Uom.class, uid);
	}

	@Override
	public List<Uom> getAllUoms() {


		return ht.loadAll(Uom.class);
	}


	@Override
	public boolean isUomModelExist(String uomModel) {

		long count=0;

		// by using hql type
		/*String hql=" select count(uomModel) from com.app.model.Uom where uomModel=? ";

		List<Long> list =       (List<Long>)  ht.find(hql, uomModel);*/


		// by using detached criteria

		DetachedCriteria hql2 = DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.projectionList()
						.add(Projections.count("uomModel"))
						);

		@SuppressWarnings("unchecked")
		List<Long> list =	(List<Long>) ht.findByCriteria(hql2);		


		if(list!= null && ! list.isEmpty() ) {

			count=list.get(0);


		}

		return count>0?true:false;


	}


	@Override
	public Map<Integer, String> getUomIdandName() {
		
		 // by using hql type

		/*String hql =" select uomId,uomModel " + " from " + Uom.class.getName() ;
		List<Object[]> list =	(List<Object[]>) ht.find(hql);*/

		// by using detached criteria
		
		
	             DetachedCriteria hql  = DetachedCriteria.forClass(Uom.class)
	            		 
	            		     .setProjection(Projections.projectionList()
	            		    		 
	            		    		 .add(Projections.property("uomId"))
	            		    		 .add(Projections.property("uomModel"))
	            		    		 
	            		    		 
	            		    		 );
	             
	                              List<Object[]> list=(List<Object[]>) ht.findByCriteria(hql);
		
		
		// converting on list to map

		Map<Integer, String> map = list.stream().collect(

				Collectors.toMap(ob->(Integer)ob[0], ob->(String)ob[1]));



		return map;
	}


}
