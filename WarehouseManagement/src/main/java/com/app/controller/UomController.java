package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Controller
@RequestMapping("/uom")
public class UomController {
	
	private static final Logger log=Logger.getLogger(UomController.class); 
	
	@Autowired
	private IUomService service;
	@Autowired
	private UomValidator validator;

	@RequestMapping("/register")
	public String regUom(ModelMap map) {
		map.addAttribute("uom",new Uom());
		return "UomRegister";
	}

	@RequestMapping(value = "/save",method = POST)
	public String saveUom(@ModelAttribute Uom uom, Errors errors, ModelMap map) {
		log.info("Entered into Uom Controller save method");
		validator.validate(uom, errors);
		log.info("Uom Validator completed");
		if(!errors.hasErrors()) { //no errors
			log.info("No Errors found about to save");
			Integer id=service.saveUom(uom) ;
			log.debug("Saved Uom with Id:"+id);
			map.addAttribute("message","Uom created with Id:"+id);
			map.addAttribute("uom",new Uom()) ;
		}
		log.info("About leave Uom Controller");
		return "UomRegister";
	}

	@RequestMapping(value = "/update",method = POST)
	public String updateUom(@ModelAttribute Uom uom, ModelMap map) {
		service.updateUom(uom);
		map.addAttribute("message","Uom updated");
		return "UomData";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam Integer id,ModelMap map) {
		String message=null;
		try {
			if(service.isUomConnectedToItem(id)) {
				message="Uom '"+id+"' Used in other Operations can't be deleted";
			}else {
				service.deleteUom(id);
				message="Uom '"+id+"' deleted successfully";
			}
		}catch (HibernateOptimisticLockingFailureException e) {
			log.error("Uom unable to delete :"+id);
			message="Uom '"+id+"' Not Found";
		}
		map.addAttribute("message",message );
		List<Uom> uoms=service.getAllUoms();
		map.addAttribute("uoms",uoms);
		return "UomData";
	}

	@RequestMapping("/edit")
	public String editUom(@RequestParam Integer id, ModelMap map) {
		Uom ob=service.getOneUom(id);
		map.addAttribute("uom",ob);
		return "UomEdit";
	}

	@RequestMapping("/getAll")
	public String getAllUoms(ModelMap map) {
		List<Uom> uoms=service.getAllUoms();
		map.addAttribute("uoms",uoms);
		return "UomData";
	}
}
