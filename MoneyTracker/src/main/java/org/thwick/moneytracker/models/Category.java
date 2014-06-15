package org.thwick.moneytracker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "category")
@XmlRootElement
public class Category {

	@Id
	@Column(name = "category_pkid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "category_name")
	@JsonProperty("categoryName")
	private String categoryName;

	@OneToOne
	@JoinColumn(name="parent_category_pkid")
	private Category parentCategory;
	
	public Category() {}
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", parentCategory=" + parentCategory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((parentCategory == null) ? 0 : parentCategory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (parentCategory == null) {
			if (other.parentCategory != null)
				return false;
		} else if (!parentCategory.equals(other.parentCategory))
			return false;
		return true;
	}

	
}
