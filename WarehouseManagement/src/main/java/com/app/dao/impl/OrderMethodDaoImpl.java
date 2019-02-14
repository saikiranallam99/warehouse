package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod ordermethod) {
		return (Integer)ht.save(ordermethod);
	}

	@Override
	public void updateOrderMethod(OrderMethod ordermethod) {
		ht.update(ordermethod);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		ht.delete(new OrderMethod(id));
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		return ht.get(OrderMethod.class,id);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}
	
	
	@Override
	public List<OrderMethod> getOrderMethodsByMode(String mode) {
		//select * from omtabwhere mode=?
		@SuppressWarnings("unchecked")
		List<OrderMethod> oms=(List<OrderMethod>) ht.findByCriteria(
				DetachedCriteria.forClass(OrderMethod.class)
				.add(Restrictions.eq("mode", mode))
				);
		return oms;
	}
}
