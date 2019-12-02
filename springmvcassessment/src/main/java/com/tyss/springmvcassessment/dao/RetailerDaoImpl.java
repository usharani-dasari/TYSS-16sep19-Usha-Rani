package com.tyss.springmvcassessment.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.springmvcassessment.dto.Order;
import com.tyss.springmvcassessment.dto.Product;
import com.tyss.springmvcassessment.dto.RetailerBean;

@Repository
public class RetailerDaoImpl implements RetailerDAO {
	
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public int createProfile(RetailerBean bean) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(bean);
			transaction.commit();
			return bean.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}
	
	@Override
	public Order getOrders(int id) {
		String jpql = "from Order where id=:id";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Order> query = manager.createQuery(jpql,Order.class);
		
		try {
		Order order = query.getSingleResult();
		return order;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	@Override
	public RetailerBean login(int id, String password) {
		String jpql = "from RetailerBean where id=:id and password=:password";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<RetailerBean> query = manager.createQuery(jpql,RetailerBean.class);
		query.setParameter("id", id);
		query.setParameter("password", password);
		try {
		RetailerBean bean = query.getSingleResult();
		return bean;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	@Override
	public Product search(int pid) {
		EntityManager manager = factory.createEntityManager();
		Product product = manager.find(Product.class,pid);
		
		return product;
		
	}
	
	@Override
	public double totalAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean updatePassword(int id,String password) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		RetailerBean bean  = manager.find(RetailerBean.class,id);
		
		bean.setPassword(password);
		
		transaction.commit();
		return true;
	}
	
	@Override
	public boolean doOrder(Product p,int quantity,int retailerid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			Order order = new Order();
			order.setOrderid(p.getPid());
			order.setProductname(p.getPname());
			order.setPriceperunit(p.getPriceperproduct());
			order.setQuantity(quantity);
			order.setAmountpayable(quantity*p.getPriceperproduct());
			order.setRetailerid(retailerid);
			manager.persist(order);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

}
