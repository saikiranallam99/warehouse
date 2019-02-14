package com.app.dao;

import java.util.List;

import com.app.model.Uom;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IUomDao {
	Integer saveUom(Uom uom);

	void updateUom(Uom uom);

	void deleteUom(Integer id);

	Uom getOneUom(Integer id);

	List<Uom> getAllUoms();

	boolean isUomAlreadyExist(String uomModel);

	boolean isUomConnectedToItem(Integer id);
}
