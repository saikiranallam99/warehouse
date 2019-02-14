package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
	@Autowired
	private IShipmentTypeDao dao;

	@Override
	@Transactional
	public Integer saveShipmentType(ShipmentType shipmenttype) {
		return dao.saveShipmentType(shipmenttype);
	}

	@Override
	@Transactional
	public void updateShipmentType(ShipmentType shipmenttype) {
		dao.updateShipmentType(shipmenttype);
	}

	@Override
	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public ShipmentType getOneShipmentType(Integer id) {
		return dao.getOneShipmentType(id);
	}

	@Override
	@Transactional(
			readOnly = true
			)
	public List<ShipmentType> getAllShipmentTypes() {
		return dao.getAllShipmentTypes();
	}
}
