package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Item;
import com.app.model.Uom;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Repository
public class UomDaoImpl implements IUomDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveUom(Uom uom) {
		return (Integer)ht.save(uom);
	}

	@Override
	public void updateUom(Uom uom) {
		ht.update(uom);
	}

	@Override
	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));
	}

	@Override
	public Uom getOneUom(Integer id) {
		return ht.get(Uom.class,id);
	}

	@Override
	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}
	
	@Override
	public boolean isUomAlreadyExist(String uomModel) {
		//select count(*) from uomtab where uom_model=?
		@SuppressWarnings("unchecked")
		List<Long> countList=(List<Long>) 
		ht.findByCriteria(DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("uomModel", uomModel))
		);
		return countList.get(0)!=0?true:false;
	}
	
	@Override
	public boolean isUomConnectedToItem(Integer id) {
		//select count(*) itemtab where uomIdFk=?
		@SuppressWarnings("unchecked")
		List<Long> countList=(List<Long>) 
				ht.findByCriteria(DetachedCriteria.forClass(Item.class)
						.setProjection(Projections.rowCount())
						.add(Restrictions.eq("uom.id", id))
				);
		return countList.get(0)!=0?true:false;
	}
	
}
