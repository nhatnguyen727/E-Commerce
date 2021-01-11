package com.ecommerce.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrDetailTopping")
public class OrDetailTopping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name ="idOrder")
	private Orders idOrder;
	@ManyToOne
	@JoinColumn(name ="idProduct")
	private Product idPro;
	@ManyToOne
	@JoinColumn(name ="idTopping")
	private Topping idTopping;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Orders getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Orders idOrder) {
		this.idOrder = idOrder;
	}
	public Product getIdPro() {
		return idPro;
	}
	public void setIdPro(Product idPro) {
		this.idPro = idPro;
	}
	public Topping getIdTopping() {
		return idTopping;
	}
	public void setIdTopping(Topping idTopping) {
		this.idTopping = idTopping;
	}
	
}
