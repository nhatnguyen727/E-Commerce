package com.ecommerce.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Size")
public class size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
