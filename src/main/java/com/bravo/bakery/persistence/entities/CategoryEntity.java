package com.bravo.bakery.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 6779092777916051074L;
	private static final Logger log = Logger.getLogger(CategoryEntity.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_category;

	private Long id_category_parent;

	private String name;
	private String description;
	private String image1;

	@Column(name = "created_at")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;

	@Column(name = "created_by")
	@CreatedBy
	private String created_by;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<ProductEntity> products;

	public CategoryEntity() {
	}

	public CategoryEntity(Long id_category, Long id_category_parent, String name, String description) {
		super();
		this.id_category = id_category;
		this.id_category_parent = id_category_parent;
		this.name = name;
		this.description = description;
	}

	public Long getId_category() {
		return id_category;
	}

	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}

	public Long getId_category_parent() {
		return id_category_parent;
	}

	public void setId_category_parent(Long id_category_parent) {
		this.id_category_parent = id_category_parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

}
