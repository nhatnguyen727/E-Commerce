package com.ecommerce.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.ecommerce.Models.*;

@Entity
@Table(name = "OrDetailTopping")
public class OrDetailTopping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name ="idOrdD")
	private OrdersDetail idOrdD;
	
	@ManyToOne
	@JoinColumn(name ="idTopping")
	private Topping idTopping;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public OrdersDetail getIdOrdetails() {
		return idOrdD;
	}
	public void setIdOrdetails(OrdersDetail idOrdD) {
		this.idOrdD = idOrdD;
	}
	public Topping getIdTopping() {
		return idTopping;
	}
	public void setIdTopping(Topping idTopping) {
		this.idTopping = idTopping;
	}
	
}
