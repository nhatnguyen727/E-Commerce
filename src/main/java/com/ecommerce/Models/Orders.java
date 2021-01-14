package com.ecommerce.Models;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrd;
	@ManyToOne
	@JoinColumn(name ="idUser")
	private User idUser;
	@Column (length = 100000)
	private String orderToName;
	@Column (length = 100000)
	private String orderAdress;
	@Column (length = 10)
	private String phone;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date orderDate;
	@Column (length = 10000)
	private String orderStatus;
	public int getIdOrd() {
		return idOrd;
	}
	public void setIdOrd(int idOrd) {
		this.idOrd = idOrd;
	}
	public User getIdUser() {
		return idUser;
	}
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	public String getOrderToName() {
		return orderToName;
	}
	public void setOrderToName(String orderToName) {
		this.orderToName = orderToName;
	}
	public String getOrderAdress() {
		return orderAdress;
	}
	public void setOrderAdress(String orderAdress) {
		this.orderAdress = orderAdress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@OneToMany(mappedBy = "idOrder", cascade = CascadeType.ALL)
	private Collection<OrdersDetail> orderdetail;
	
}
