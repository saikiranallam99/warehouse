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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidator;

@Controller
@RequestMapping("/whusertype")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;

	@Autowired
	private WhUserTypeValidator validator;

	@RequestMapping("/register")
	public String regWhUserType(ModelMap map) {
		map.addAttribute("whUserType",new WhUserType());
		return "WhUserTypeRegister";
	}

	@RequestMapping(value = "/save",method = POST)
	public String saveWhUserType(@ModelAttribute WhUserType whusertype, Errors errors, ModelMap map) {
		validator.validate(whusertype, errors);
		if(!errors.hasErrors()) {
			Integer id=service.saveWhUserType(whusertype) ;
			map.addAttribute("message","WhUserType created with Id:"+id);
			map.addAttribute("whUserType",new WhUserType()) ;
		}
		return "WhUserTypeRegister";
	}

	@RequestMapping(
			value = "/update",
			method = POST
			)
	public String updateWhUserType(@ModelAttribute WhUserType whusertype, ModelMap map) {
		service.updateWhUserType(whusertype);
		map.addAttribute("message","WhUserType updated");
		return "WhUserTypeData";
	}

	@RequestMapping("/delete")
	public String deleteWhUserType(@RequestParam Integer id) {
		service.deleteWhUserType(id);
		return "WhUserTypeData";
	}

	@RequestMapping("/edit")
	public String editWhUserType(@RequestParam Integer id, ModelMap map) {
		WhUserType ob=service.getOneWhUserType(id);
		map.addAttribute("whUserType",ob);
		return "WhUserTypeEdit";
	}

	@RequestMapping("/getAll")
	public String getAllWhUserTypes(ModelMap map) {
		List<WhUserType> users=service.getAllWhUserTypes();
		map.addAttribute("users",users);
		return "WhUserTypeData";
	}
	
}




