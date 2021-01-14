package com.ecommerce.Models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.ecommerce.Models.*;

@Entity
@Table(name = "OrdersDetails")
public class OrdersDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrdD;
	@ManyToOne
	@JoinColumn(name ="idOrder")
	private Orders idOrder;
	@ManyToOne
	@JoinColumn(name ="idProduct")
	private Product idPro;
	@ManyToOne
	@JoinColumn(name ="idSize")
	private Size idSize;
	@Column (length = 100000)
	private float quantity;
	@Column (length =1000000)
	private String note;
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
	public int getIdOrdD() {
		return idOrdD;
	}
	public void setIdOrdD(int idOrdD) {
		this.idOrdD = idOrdD;
	}
	public Size getIdSize() {
		return idSize;
	}
	public void setIdSize(Size idSize) {
		this.idSize = idSize;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@OneToMany(mappedBy = "idOrdD", cascade = CascadeType.ALL)
	private Collection<OrDetailTopping> orDetailToppings;
	
}
