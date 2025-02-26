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
import jakarta.persistence.Table;

@Entity
@Table(name = "add_in")
public class AddIn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String description;
	@Column(name = "image_url")
	private String imageUrl;
	
	@JsonIgnoreProperties({"addIn","dirtyDrink"})
	@OneToMany(mappedBy = "addIn")
	private List<DirtyDrinkAddIn> dirtyDrinkAddIns;

	public AddIn() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<DirtyDrinkAddIn> getDirtyDrinkAddIns() {
		return dirtyDrinkAddIns;
	}

	public void setDirtyDrinkAddIns(List<DirtyDrinkAddIn> dirtyDrinkAddIns) {
		this.dirtyDrinkAddIns = dirtyDrinkAddIns;
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
		AddIn other = (AddIn) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddIn [id=").append(id).append(", name=").append(name).append(", description=")
				.append(description).append(", imageUrl=").append(imageUrl).append("]");
		return builder.toString();
	}

}
