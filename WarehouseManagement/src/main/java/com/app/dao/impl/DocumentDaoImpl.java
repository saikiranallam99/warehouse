package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveDocument(Document doc) {
		return (Integer) ht.save(doc);
	}
	
	@Override
	public List<Object[]> getDocumentIdAndNames() {
		//String hql="select fileId,fileName from "+Document.class.getName();
		@SuppressWarnings("unchecked")
		List<Object[]> data=(List<Object[]>)ht.findByCriteria(
				DetachedCriteria.forClass(Document.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("fileId"))
						.add(Projections.property("fileName"))
						)
				);
		return data;
	}
	
	@Override
	public Document getDocumentById(int docId) {
		return ht.get(Document.class, docId);
	}
	
}
