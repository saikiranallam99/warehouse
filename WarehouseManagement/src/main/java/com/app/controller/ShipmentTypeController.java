package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.validator.ShipmentTypeValidator;


@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;

	@Autowired
	private ShipmentTypeValidator validator;

	@RequestMapping("/register")
	public String regShipmentType(ModelMap map) {
		map.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@RequestMapping(
			value = "/save",
			method = POST
			)
	public String saveShipmentType(@ModelAttribute ShipmentType shipmenttype, Errors errors,
			ModelMap map) {
		validator.validate(shipmenttype, errors);
		if(!errors.hasErrors()){ 
			Integer id=service.saveShipmentType(shipmenttype) ;
			map.addAttribute("message","ShipmentType created with Id:"+id);
			map.addAttribute("shipmentType",new ShipmentType()) ;
		};
		return "ShipmentTypeRegister";
	}

	@RequestMapping(
			value = "/update",
			method = POST
			)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmenttype, ModelMap map) {
		service.updateShipmentType(shipmenttype);
		map.addAttribute("message","ShipmentType updated");
		return "ShipmentTypeData";
	}

	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam Integer id) {
		service.deleteShipmentType(id);
		return "ShipmentTypeData";
	}

	@RequestMapping("/edit")
	public String editShipmentType(@RequestParam Integer id, ModelMap map) {
		ShipmentType ob=service.getOneShipmentType(id);
		map.addAttribute("shipmentType",ob);
		return "ShipmentTypeEdit";
	}

	@RequestMapping("/getAll")
	public String getAllShipmentTypes() {
		service.getAllShipmentTypes();
		return "ShipmentTypeData";
	}
}
