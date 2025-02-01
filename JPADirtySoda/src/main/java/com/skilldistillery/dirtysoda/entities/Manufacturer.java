package com.skilldistillery.dirtysoda.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	@Column(name = "logo_image_url")
	private String logoImageUrl;
	@Column(name = "website_url")
	private String websiteUrl;
	
	@JsonIgnoreProperties("manufacturer")
	@OneToMany(mappedBy = "manufacturer")
	private List<BaseDrink> baseDrinks;

	public Manufacturer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoImageUrl() {
		return logoImageUrl;
	}

	public void setLogoImageUrl(String logoImageUrl) {
		this.logoImageUrl = logoImageUrl;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public List<BaseDrink> getBaseDrinks() {
		return baseDrinks;
	}

	public void setBaseDrinks(List<BaseDrink> baseDrinks) {
		this.baseDrinks = baseDrinks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manufacturer other = (Manufacturer) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Manufacturer [id=").append(id).append(", name=").append(name).append(", logoImageUrl=")
				.append(logoImageUrl).append(", websiteUrl=").append(websiteUrl).append("]");
		return builder.toString();
	}

}
