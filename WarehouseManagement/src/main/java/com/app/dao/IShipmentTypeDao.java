package com.app.dao;

import java.util.List;

import com.app.model.ShipmentType;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IShipmentTypeDao {
	Integer saveShipmentType(ShipmentType shipmenttype);

	void updateShipmentType(ShipmentType shipmenttype);

	void deleteShipmentType(Integer id);

	ShipmentType getOneShipmentType(Integer id);

	List<ShipmentType> getAllShipmentTypes();
}
