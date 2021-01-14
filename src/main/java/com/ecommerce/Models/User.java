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
@Table (name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	@Column(length = 1000)
	private String fullname;
	@Column(length = 1000)
	private  String username;
	@Column(length =1000)
	private String password;
	@Column(length = 1000)
	private String photo;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	@Column(length = 10)
	private Integer Phone;
	@Column(length = 1000)
	private String address;
	
	@ManyToOne
	@JoinColumn(name ="idRole")
	private Role idRole;
	@Column
	private String userstaus;
	
	@OneToMany(mappedBy = "idUser", cascade = CascadeType.ALL)
	private Collection<Orders> orders;
	
	public int getidUser() {
		return idUser;
	}
	public void setidUser(int id) {
		this.idUser = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getPhone() {
		return Phone;
	}
	public void setPhone(Integer phone) {
		Phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Role getIdRole() {
		return idRole;
	}
	public void setIdRole(Role idRole) {
		this.idRole = idRole;
	}
	public String getUserstaus() {
		return userstaus;
	}
	public void setUserstaus(String userstaus) {
		this.userstaus = userstaus;
	}
	
}
