package com.app.dao.impl;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import java.lang.Integer;
import java.lang.Override;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author:RAGHU SIR 
 *  Generated F/w:SHWR-Framework 
 */
@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {
  @Autowired
  private HibernateTemplate ht;

  @Override
  public Integer savePurchaseOrder(PurchaseOrder purchaseorder) {
    return (Integer)ht.save(purchaseorder);
  }

  @Override
  public void updatePurchaseOrder(PurchaseOrder purchaseorder) {
    ht.update(purchaseorder);
  }

  @Override
  public void deletePurchaseOrder(Integer id) {
    ht.delete(new PurchaseOrder(id));
  }

  @Override
  public PurchaseOrder getOnePurchaseOrder(Integer id) {
    return ht.get(PurchaseOrder.class,id);
  }

  @Override
  public List<PurchaseOrder> getAllPurchaseOrders() {
    return ht.loadAll(PurchaseOrder.class);
  }
}
