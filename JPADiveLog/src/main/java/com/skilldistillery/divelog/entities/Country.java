package com.skilldistillery.divelog.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Country {

	@Id
	@Column(name = "country_code")
	private String countryCode;
	private String name;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "flag_image_url")
	private String flagImageUrl;

	public Country() {
		super();
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getFlagImageUrl() {
		return flagImageUrl;
	}

	public void setFlagImageUrl(String flagImageUrl) {
		this.flagImageUrl = flagImageUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(countryCode, other.countryCode);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [countryCode=").append(countryCode).append(", name=").append(name).append(", imageUrl=")
				.append(imageUrl).append(", flagImageUrl=").append(flagImageUrl).append("]");
		return builder.toString();
	}
}
