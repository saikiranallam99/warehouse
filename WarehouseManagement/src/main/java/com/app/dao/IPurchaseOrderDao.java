package com.app.dao;

import com.app.model.PurchaseOrder;
import java.lang.Integer;
import java.util.List;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
public interface IPurchaseOrderDao {
  Integer savePurchaseOrder(PurchaseOrder purchaseorder);

  void updatePurchaseOrder(PurchaseOrder purchaseorder);

  void deletePurchaseOrder(Integer id);

  PurchaseOrder getOnePurchaseOrder(Integer id);

  List<PurchaseOrder> getAllPurchaseOrders();
}
