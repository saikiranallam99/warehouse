package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
@Component
public class OrderMethodValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//down cast to model class object
		OrderMethod om=(OrderMethod)target;

		if(om.getMode()==null || "".equals(om.getMode())) {
			errors.rejectValue("mode", null, "Please choose one Mode");
		}
		
		if(!Pattern.compile("[A-Z]{3,7}").matcher(om.getCode()).matches()) {
			errors.rejectValue("code", null, "Enter Valid code(3 to 7 Uppercase only)");
		}
		//check boxes and multi-select dropdown
		if(om.getAccept()==null || om.getAccept().isEmpty()) {
			errors.rejectValue("accept", null,"Please choose at least one option");
		}
		
		if("".equals(om.getMethd())) {
			errors.rejectValue("methd",null,"Plese choose one Method");
		}
		if("".equals(om.getDsc().trim())) {
			errors.rejectValue("dsc", null, "Please enter Description");
		}
	}

}
