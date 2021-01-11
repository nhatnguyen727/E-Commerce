package com.ecommerce.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Size")
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSize;
	@Column(length = 100)
	private String sizename;
	public Long getIdSize() {
		return idSize;
	}
	public void setIdSize(Long idSize) {
		this.idSize = idSize;
	}
	public String getSizename() {
		return sizename;
	}
	public void setSizename(String sizename) {
		this.sizename = sizename;
	}
	
}
