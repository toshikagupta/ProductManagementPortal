package com.nagarro.pmp.PMPBackend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.pmp.PMPBackend.dao.SellerRegistrationDAO;
import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.hibernate.util.HibernateUtil;
import com.nagarro.pmp.PMPBackend.model.Seller;


@Repository
public class SellerRegistrationDAOImpl implements SellerRegistrationDAO {
	 

	@Override
	public SellerDTO createSeller(final SellerDTO sellerDTO) {
		Session session = HibernateUtil.openSession();
		try {
			Seller seller= new Seller();
			seller.setEmail(sellerDTO.getEmail());
			seller.setGstin(sellerDTO.getGstin());
			seller.setPassword(sellerDTO.getPassword());
			seller.setSellerId(sellerDTO.getSellerId());
			seller.setSellerName(sellerDTO.getSellerName());
			seller.setCompanyName(sellerDTO.getCompanyName());
			seller.setAddress(sellerDTO.getAddress());
			seller.setStatus("Need Approval");
			Transaction transaction = null;
			transaction = session.beginTransaction();
			session.save(seller);
			transaction.commit();
			
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
		return sellerDTO;

	}

	@Override
	public String login(LoginDTO sellerLoginDTO) {
		Session session = HibernateUtil.openSession();
		final int sellerId = sellerLoginDTO.getId();
		final String password = sellerLoginDTO.getPassword();
		final String hql = "select status from Seller " + "WHERE sellerId = :sellerId " + "and password = :password";
		final Query query = session.createQuery(hql);
		query.setParameter("sellerId", sellerId);
		query.setParameter("password", password);
		final List id = query.list();
		session.close();
		return (String) id.get(0);
	}

	@Override
	public int getSellerIdByEmail(final String email) {
		Session session = HibernateUtil.openSession();
		final String hql = "select sellerId from Seller " + "WHERE email = :email ";
		final Query query = session.createQuery(hql);
		query.setParameter("email", email);
		final List id = query.list();
		session.close();
		return (int) id.get(0);

	}

	@Override
	public List<SellerDTO> getAllSellers() {
		Session session = HibernateUtil.openSession();
		final String hql="from Seller seller order by seller.status";
		final Query query=session.createQuery(hql);
		List<Seller> listOfSellers=query.list();
		return converter(listOfSellers);
	}

	@Override
	public List<SellerDTO> approveSellers(int[] sellerIdList) {
		Session session = HibernateUtil.openSession();
		String hql;
		Query query;
		for(int i :sellerIdList ) {
		session.beginTransaction();
		 hql="Update Seller seller set seller.status='Approved' where seller.sellerId = :sellerIdList";
		  query = session.createQuery(hql);
		query.setParameter("sellerIdList", i);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		}
		Session session2 = HibernateUtil.openSession();
		session2.beginTransaction();
		hql = "from Seller seller";
		query = session2.createQuery(hql);
		List<Seller> seller = query.list();
		
		session2.close();
		return converter(seller);
		
		
	}
	@Override
	public void rejectSellers(int[] sellerIdList) {
		Session session = HibernateUtil.openSession();
		for(int i :sellerIdList ) {
		session.beginTransaction();
		String hql="Update Seller seller set seller.status='Rejected' where seller.sellerId = :sellerIdList";
		final Query query = session.createQuery(hql);
		query.setParameter("sellerIdList", i);
		query.executeUpdate();
		session.getTransaction().commit();
		
		}
		session.close();
	}
	List<SellerDTO> converter(List<Seller> sellerList)
	{
		List<SellerDTO> sellerDTOList=new ArrayList<>();
		for(Seller s:sellerList)
		{
			SellerDTO sellerdto=new SellerDTO();
			sellerdto.setAddress(s.getAddress());
			sellerdto.setCompanyName(s.getCompanyName());
			sellerdto.setContactNumber(s.getContactNumber());
			sellerdto.setEmail(s.getEmail());
			sellerdto.setGstin(s.getGstin());
			sellerdto.setPassword(s.getPassword());
			sellerdto.setSellerId(s.getSellerId());
			sellerdto.setSellerName(s.getSellerName());
			sellerdto.setStatus(s.getStatus());
			sellerDTOList.add(sellerdto);
		}
		
		return sellerDTOList;
	}

	@Override
	public SellerDTO displaysSellerById(int sellerId) {
		Session session2 = HibernateUtil.openSession();
		session2.beginTransaction();
		String hql = "from Seller seller where sellerId=:sellerId";
		Query query = session2.createQuery(hql);
		query.setParameter("sellerId",sellerId);
		List<Seller> seller = query.list();
		
		session2.close();
		return converter(seller).get(0);
	}

}
