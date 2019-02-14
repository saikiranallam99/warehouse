package com.app.validator;

import com.app.model.PurchaseOrder;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Component
public class PurchaseOrderValidator implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    return PurchaseOrder.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
  }
}
