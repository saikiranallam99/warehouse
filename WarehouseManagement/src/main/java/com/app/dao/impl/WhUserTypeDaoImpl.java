package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhUserType(WhUserType whusertype) {
		return (Integer)ht.save(whusertype);
	}

	@Override
	public void updateWhUserType(WhUserType whusertype) {
		ht.update(whusertype);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		ht.delete(new WhUserType(id));
	}

	@Override
	public WhUserType getOneWhUserType(Integer id) {
		return ht.get(WhUserType.class,id);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

	@Override
	public List<WhUserType> getWhUserTypesByType(String userType) {
		//select * from whusertab where userType=?
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) ht.findByCriteria(
				DetachedCriteria.forClass(WhUserType.class)
				.add(Restrictions.eq("userType", userType))
				);
		return list;
	}

}
