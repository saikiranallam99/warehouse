package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDao {

	public int saveDocument(Document doc);
	public List<Object[]> getDocumentIdAndNames();
	public Document getDocumentById(int docId);
	
	
	
	
}


