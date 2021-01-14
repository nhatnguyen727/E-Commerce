package com.ecommerce.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Topping")
public class Topping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTopping;
	@Column(length = 1000)
	private String toppingname;
	@Column(length = 100000)
	private float price;
	public int getIdTopping() {
		return idTopping;
	}
	public void setIdTopping(int idTopping) {
		this.idTopping = idTopping;
	}
	public String getToppingname() {
		return toppingname;
	}
	public void setToppingname(String toppingname) {
		this.toppingname = toppingname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
