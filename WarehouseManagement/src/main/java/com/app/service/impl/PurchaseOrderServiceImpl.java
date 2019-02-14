package com.app.service.impl;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
import java.lang.Integer;
import java.lang.Override;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
  @Autowired
  private IPurchaseOrderDao dao;

  @Override
  @Transactional
  public Integer savePurchaseOrder(PurchaseOrder purchaseorder) {
    return dao.savePurchaseOrder(purchaseorder);
  }

  @Override
  @Transactional
  public void updatePurchaseOrder(PurchaseOrder purchaseorder) {
    dao.updatePurchaseOrder(purchaseorder);
  }

  @Override
  @Transactional
  public void deletePurchaseOrder(Integer id) {
    dao.deletePurchaseOrder(id);
  }

  @Override
  @Transactional(
      readOnly = true
  )
  public PurchaseOrder getOnePurchaseOrder(Integer id) {
    return dao.getOnePurchaseOrder(id);
  }

  @Override
  @Transactional(
      readOnly = true
  )
  public List<PurchaseOrder> getAllPurchaseOrders() {
    return dao.getAllPurchaseOrders();
  }
}
