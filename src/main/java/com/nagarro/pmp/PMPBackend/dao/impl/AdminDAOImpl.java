/**
 * 
 */
package com.nagarro.pmp.PMPBackend.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.pmp.PMPBackend.dao.AdminDAO;
import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.hibernate.util.HibernateUtil;
import com.nagarro.pmp.PMPBackend.model.Admin;

/**
 * @author toshikagupta
 *
 */

@Repository
public class AdminDAOImpl implements AdminDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.pmpadmin.repository.impl.AdminStub#validateCredentials(com.
	 * nagarro.pmpadmin.model.Admin)
	 */
	@Override
	public LoginDTO validateCredentials(LoginDTO adminloginDTO) {

		Session session = HibernateUtil.openSession();

		try {

			String hql = "from Admin admin where admin.id=:id and admin.password=:password";

			// System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setParameter("id", adminloginDTO.getId());
			query.setParameter("password", adminloginDTO.getPassword());
			List<Admin> res = query.list();
			LoginDTO loginDTO = new LoginDTO();
			loginDTO.setId(res.get(0).getId());
			loginDTO.setPassword(res.get(0).getPassword());

			if (!res.isEmpty()) {
				return loginDTO;
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.pmp.yourmart.repository.AdminStub#sortList(com.nagarro.pmp.
	 * yourmart.model.Seller, java.lang.String)
	 */
	@Override
	public List<SellerDTO> sortList(String classifier) {

		Query query = null;
		List<SellerDTO> result = null;
		Transaction transaction = null;
		Session session = HibernateUtil.openSession();
		try {

			transaction = session.getTransaction();
			transaction.begin();
			String hql = null;
			if (classifier.equalsIgnoreCase("SellerId")) {
				hql = "from Seller seller order by sellerId desc";

			} else if (classifier.equalsIgnoreCase("Registration time")) {
				hql = "from Seller seller order by time desc";
			}
			query = session.createQuery(hql);
			result = query.list();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();

			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.pmp.yourmart.repository.AdminStub#getSearchResult(java.lang.
	 * String)
	 */
	@Override
	public List<SellerDTO> getSearchResult(String searchparam, String classifier) {

		Query query = null;
		List<SellerDTO> result = null;
		Transaction transaction = null;
		Session session = HibernateUtil.openSession();

		try {

			transaction = session.getTransaction();
			transaction.begin();
			String hql = null;
			if (classifier.equalsIgnoreCase("Company Name")) {
				hql = "from Seller seller where seller.companyName like :searchparam";

			} else if (classifier.equalsIgnoreCase("Owner Name")) {
				hql = "from Seller seller where seller.sellerName like :searchparam";
			}

			else if (classifier.equalsIgnoreCase("Contact Number")) {
				hql = "from Seller seller where seller.contactNumber like :searchparam";
			}

			query = session.createQuery(hql);
			query.setParameter("searchparam", searchparam + "%");
			result = query.list();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();

			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagarro.pmp.yourmart.repository.AdminStub#filterbyStatus(java.lang.
	 * String)
	 */
	@Override
	public List<SellerDTO> filterbyStatus(String status) {
		List<SellerDTO> result;
		Session session = HibernateUtil.openSession();
		String hql = "from Seller seller where status=:status";
		Query query = session.createQuery(hql);
		query.setParameter("status", status);
		result = query.list();
		session.close();
		return result;
	}

	@Override
	public List<ProductDTO> sortProductList(String classifier) {

		Query query = null;
		List<ProductDTO> result = null;
		Transaction transaction = null;
		Session session = HibernateUtil.openSession();
		try {

			transaction = session.getTransaction();
			transaction.begin();
			String hql = null;
			if (classifier.equalsIgnoreCase("MRP")) {
				hql = "from Product product order by mrp desc";

			} else if (classifier.equalsIgnoreCase("SSP")) {
				hql = "from Product product order by ssp desc";
			} else if (classifier.equalsIgnoreCase("YMP")) {
				hql = "from Product product order by ymp desc";
			}
			query = session.createQuery(hql);
			result = query.list();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();

			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<ProductDTO> getProductSearchResult(String searchparam, String classifier) {

		Query query = null;
		List<ProductDTO> result = null;
		Transaction transaction = null;
		Session session = HibernateUtil.openSession();

		try {

			transaction = session.getTransaction();
			transaction.begin();
			String hql = null;
			if (classifier.equalsIgnoreCase("Product Code")) {
				hql = "from Product product where product.productId like :searchparam";

			} else if (classifier.equalsIgnoreCase("Product Name")) {
				hql = "from Product product where product.productName like :searchparam";
			}

			else if (classifier.equalsIgnoreCase("Product Id")) {
				hql = "from Product product where product.productId like :searchparam";
			}

			query = session.createQuery(hql);
			query.setParameter("searchparam", searchparam + "%");
			result = query.list();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();

			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	
}
