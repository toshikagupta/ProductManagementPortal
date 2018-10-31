package com.nagarro.pmp.PMPBackend.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nagarro.pmp.PMPBackend.dao.SellerRegistrationDAO;
import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.hibernate.util.HibernateUtil;
import com.nagarro.pmp.PMPBackend.model.Seller;
import com.nagarro.pmp.PMPBackend.model.SellerLogin;


@Repository
public class SellerRegistrationDAOImpl implements SellerRegistrationDAO {
	final Session session = HibernateUtil.openSession();

	@Override
	public SellerDTO createSeller(final SellerDTO sellerDTO) {
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
			
			e.printStackTrace();
		}
		return sellerDTO;

	}

	@Override
	public String login(LoginDTO sellerLoginDTO) {
		final int sellerId = sellerLoginDTO.getId();
		final String password = sellerLoginDTO.getPassword();
		final String hql = "select status from Seller " + "WHERE sellerId = :sellerId " + "and password = :password";
		final Query query = session.createQuery(hql);
		query.setParameter("sellerId", sellerId);
		query.setParameter("password", password);
		final List id = query.list();
		return (String) id.get(0);
	}

	@Override
	public int getSellerIdByEmail(final String email) {
		final String hql = "select sellerId from Seller " + "WHERE email = :email ";
		final Query query = session.createQuery(hql);
		query.setParameter("email", email);
		final List id = query.list();
		return (int) id.get(0);

	}

	@Override
	public List<SellerDTO> getAllSellers() {
		final String hql="from Seller seller order by seller.status";
		final Query query=session.createQuery(hql);
		List<SellerDTO> listOfSellers=query.list();
		return listOfSellers;
	}

}
