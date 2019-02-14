package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
import com.app.validator.PurchaseOrderValidator;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Controller
@RequestMapping("/purchaseorder")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;

	@Autowired
	private PurchaseOrderValidator validator;

	@RequestMapping("/register")
	public String regPurchaseOrder(ModelMap map) {
		map.addAttribute("purchaseOrder",new PurchaseOrder());
		return "PurchaseOrderRegister";
	}

	@RequestMapping(
			value = "/save",
			method = POST
			)
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseorder, Errors errors,
			ModelMap map) {
		validator.validate(purchaseorder, errors);
		if(!errors.hasErrors()){ 
			Integer id=service.savePurchaseOrder(purchaseorder) ;
			map.addAttribute("message","PurchaseOrder created with Id:"+id);
			map.addAttribute("purchaseOrder",new PurchaseOrder()) ;
		};
		return "PurchaseOrderRegister";
	}

	@RequestMapping(
			value = "/update",
			method = POST
			)
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder purchaseorder, ModelMap map) {
		service.updatePurchaseOrder(purchaseorder);
		map.addAttribute("message","PurchaseOrder updated");
		return "PurchaseOrderData";
	}

	@RequestMapping("/delete")
	public String deletePurchaseOrder(@RequestParam Integer id) {
		service.deletePurchaseOrder(id);
		return "PurchaseOrderData";
	}

	@RequestMapping("/edit")
	public String editPurchaseOrder(@RequestParam Integer id, ModelMap map) {
		PurchaseOrder ob=service.getOnePurchaseOrder(id);
		map.addAttribute("purchaseOrder",ob);
		return "PurchaseOrderEdit";
	}

	@RequestMapping("/getAll")
	public String getAllPurchaseOrders() {
		service.getAllPurchaseOrders();
		return "PurchaseOrderData";
	}
}
