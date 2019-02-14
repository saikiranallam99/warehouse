package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodValidator validator;
	

	@RequestMapping("/register")
	public String regOrderMethod(ModelMap map) {
		map.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}

	@RequestMapping(value = "/save",method = POST)
	public String saveOrderMethod(@ModelAttribute OrderMethod orderMethod, Errors errors,
			ModelMap map) {
		validator.validate(orderMethod, errors);
		if(!errors.hasErrors()) {
			//no errors , execute operaton
			Integer id=service.saveOrderMethod(orderMethod) ;
			map.addAttribute("message","OrderMethod created with Id:"+id);
			map.addAttribute("orderMethod",new OrderMethod()) ;
		}
		
		return "OrderMethodRegister";
	}

	@RequestMapping(
			value = "/update",
			method = POST
			)
	public String updateOrderMethod(@ModelAttribute OrderMethod ordermethod, ModelMap map) {
		service.updateOrderMethod(ordermethod);
		map.addAttribute("message","OrderMethod updated");
		return "OrderMethodData";
	}

	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam Integer id) {
		service.deleteOrderMethod(id);
		return "OrderMethodData";
	}

	@RequestMapping("/edit")
	public String editOrderMethod(@RequestParam Integer id, ModelMap map) {
		OrderMethod ob=service.getOneOrderMethod(id);
		map.addAttribute("orderMethod",ob);
		return "OrderMethodEdit";
	}

	@RequestMapping("/getAll")
	public String getAllOrderMethods(ModelMap map) {
		List<OrderMethod> oms=service.getAllOrderMethods();
		map.addAttribute("orderMethods", oms);
		return "OrderMethodData";
	}
}
