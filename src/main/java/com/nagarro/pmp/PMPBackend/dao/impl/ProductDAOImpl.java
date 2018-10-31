package com.nagarro.pmp.PMPBackend.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.pmp.PMPBackend.dao.ProductDAO;
import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.hibernate.util.HibernateUtil;
import com.nagarro.pmp.PMPBackend.model.Categories;
import com.nagarro.pmp.PMPBackend.model.PdfManual;
import com.nagarro.pmp.PMPBackend.model.Product;
import com.nagarro.pmp.PMPBackend.model.SecondaryImages;

@Repository
public class ProductDAOImpl implements ProductDAO {
	Session session = HibernateUtil.openSession();
	@Override
	public void addProducts(ProductDTO productDTO) {
	
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				
				Product product = new Product();
				product.setComments(productDTO.getComments());
				product.setLongDesc(productDTO.getLongDesc());
				product.setMrp(productDTO.getMrp());
				product.setPrimaryImage(productDTO.getPrimaryImage());
				product.setProductName(productDTO.getProductName());
				product.setShortDesc(productDTO.getShortDesc());
				product.setYmp(productDTO.getYmp());
				product.setStatus("NEW");
				product.setSsp(productDTO.getSsp());
				
				PdfManual pdfManual= new PdfManual();
				pdfManual.setManualUrl(productDTO.getPdfUrl());
				
				Set<Categories> categoriesSet = new HashSet<Categories>();
				Set<SecondaryImages> imageset= new HashSet<>();
				
				for(String str: productDTO.getCategories()) {
					Categories categories1= new Categories(); 
					//categories1.setCategoryId(2);
					categories1.setCategory(str);
					
					categoriesSet.add(categories1);
				}
				for(String url: productDTO.getImagesUrl()) {
					
					SecondaryImages s1=new SecondaryImages();
					s1.setSimageUrl(url);
					s1.setProduct(product);
					imageset.add(s1);
					
				}
					product.setCategories(categoriesSet);
					pdfManual.setProduct(product);
					session.save(product);
					session.save(pdfManual);
	
					for(SecondaryImages image: imageset) {
						session.save(image);
					
					}

					transaction.commit();
					} catch (HibernateException e) {
						System.err.println("error" + e);
						
						e.printStackTrace();
					} 
		}
	@Override
	public void updateProduct(ProductDTO productDTO) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			Product product = new Product();
			product.setProductId(1);
			product.setComments(productDTO.getComments());
			product.setLongDesc(productDTO.getLongDesc());
			product.setMrp(productDTO.getMrp());
			product.setPrimaryImage(productDTO.getPrimaryImage());
			product.setProductName(productDTO.getProductName());
			product.setShortDesc(productDTO.getShortDesc());
			product.setYmp(productDTO.getYmp());
			product.setStatus("NEW");
			product.setSsp(productDTO.getSsp());
			
			PdfManual pdfManual= new PdfManual();
			pdfManual.setManualUrl(productDTO.getPdfUrl());
			
			Set<Categories> categoriesSet = new HashSet<Categories>();
			Set<SecondaryImages> imageset= new HashSet<>();
			
			for(String str: productDTO.getCategories()) {
				Categories categories1= new Categories(); 
				//categories1.setCategoryId(2);
				categories1.setCategory(str);
				
				categoriesSet.add(categories1);
			}
			for(String url: productDTO.getImagesUrl()) {
				
				SecondaryImages s1=new SecondaryImages();
				s1.setSimageUrl(url);
				s1.setProduct(product);
				imageset.add(s1);
				
			}
				product.setCategories(categoriesSet);
				pdfManual.setProduct(product);
				session.saveOrUpdate(product);
				session.saveOrUpdate(pdfManual);

				for(SecondaryImages image: imageset) {
					session.saveOrUpdate(image);
				
				}

				transaction.commit();
				} catch (HibernateException e) {
					System.err.println("error" + e);
					
					e.printStackTrace();
				} 
		
	}
	
	
	@Override
	public ProductDTO getAllProducts(int code){
		String productHql="from Product where productId =:productId";
		String imageHql="select s.simageUrl from SecondaryImages s where s.product.productId =:productId";
		String pdfHql="select p.manualUrl from PdfManual p where p.product.productId =:productId";
		String categoriesHql="from Categories c ,Product p where p.productId =:productId";
		
		final Session session = HibernateUtil.openSession();

		final int productId = code;
		
		final Query productQuery = session.createQuery(productHql);
		productQuery.setParameter("productId", productId);
		final List<Product> productResult = productQuery.list();
		
		
		final Query imageQuery = session.createQuery(imageHql);
		imageQuery.setParameter("productId", productId);
		final List<String> imageSet = imageQuery.list();
		 
		
		
		final Query pdfQuery = session.createQuery(pdfHql);
		pdfQuery.setParameter("productId", productId);
		final List<String> pdfResult = pdfQuery.list();
		
//		final Query categoriesQuery = session.createQuery(categoriesHql);
//		categoriesQuery.setParameter("productId", productId);
//		final List<Categories> categoriesResult = categoriesQuery.list();
//		List<String> categoriesSet= new ArrayList<>(); 
//		for(Categories ci:  categoriesResult) {
//			categoriesSet.add(ci.getCategory());
//		}
		
		
		
		ProductDTO productDTO= new ProductDTO();
		productDTO.setProductId(productResult.get(0).getProductId());
		productDTO.setComments(productResult.get(0).getComments());
		productDTO.setLongDesc(productResult.get(0).getLongDesc());
		productDTO.setMrp(productResult.get(0).getMrp());
		productDTO.setPrimaryImage(productResult.get(0).getPrimaryImage());
		productDTO.setProductName(productResult.get(0).getProductName());
		productDTO.setSellerId(productResult.get(0).getSellerId());
		productDTO.setShortDesc(productResult.get(0).getShortDesc());
		productDTO.setSsp(productResult.get(0).getSsp());
		productDTO.setStatus(productResult.get(0).getStatus());
		productDTO.setYmp(productResult.get(0).getYmp());
		productDTO.setPdfUrl(pdfResult.get(0));
		productDTO.setImagesUrl(imageSet);
		//productDTO.setCategories(categorieSet);
		return productDTO;

		
	}
	@Override
	public void editProducts(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		
	}
	
}