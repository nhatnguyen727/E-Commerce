package com.ecommerce.Controller;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.Models.Product;

@Controller
public class ProductController {
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping("/list")
	@Transactional
	public String list() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product";
		Query<Product> query = session.createQuery(hql);
		List <Product> list = query.list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			System.out.println("=======Name"+ product.getName());
		}
		return "list";
		
	}
}
