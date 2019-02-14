package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;

@Component
public class UomValidator implements Validator{
	@Autowired
	private IUomService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//down cast to Model class Type
		Uom uom=(Uom)target;

		if("".equals(uom.getUomType())) {
			errors.rejectValue("uomType", null, "Please choose one Type");
		}
		
		if(!Pattern.compile("[A-Z]{4,10}").matcher(uom.getUomModel()).matches()) {
			errors.rejectValue("uomModel", null, "Please enter valid Model(4 to 10 Uppercase only)");
		}else if(service.isUomAlreadyExist(uom.getUomModel())) {
			errors.rejectValue("uomModel", null, "Uom Already Exist Please use some other Model");
		}
		if("".equals(uom.getUomDsc().trim())) {
			errors.rejectValue("uomDsc", null, "Please enter Description");
		}
	}

}
