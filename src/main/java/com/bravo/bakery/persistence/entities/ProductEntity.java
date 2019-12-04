package com.bravo.bakery.persistence.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.log4j.Logger;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = 6632934954794951174L;
	private static final Logger log = Logger.getLogger(ProductEntity.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_product;

	@ManyToOne
	@JoinColumn(name = "id_category")
	@JsonBackReference
	private CategoryEntity category;

	@Column(insertable = false, updatable = false)
	private Long id_category;

	private String name;
	private String description;
	private BigDecimal price;

	private String image1;
	private String image2;
	private String image3;

	@Column(name = "created_at")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;

	@Column(name = "created_by")
	@CreatedBy
	private String created_by;

	public ProductEntity() {
	}

	public ProductEntity(Long id_product, CategoryEntity category, String name, String description, BigDecimal price, String image1, String image2, String image3, String created_by) {
		super();
		this.id_product = id_product;
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.created_by = created_by;
	}

	public Long getId_product() {
		return id_product;
	}

	public void setId_product(Long id_product) {
		this.id_product = id_product;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public Long getId_category() {
		return id_category;
	}

	public void setId_category(Long id_category) {
		this.id_category = id_category;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
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

}
