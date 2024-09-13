package com.skilldistillery.caves.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cave")
public class Cave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	@CreationTimestamp
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;
	
	@Column(name = "image_url")
	private String imageUrl;
	private String description;
	private Boolean enabled = true;
	
	@Column(name = "explored_length_km")
	private Double exploredLengthKm;
	@Column(name = "open_to_public")
	private Boolean openToPublic;
	@Column(name = "entrance_authority")
	private String entranceAuthority;
	
	@ManyToOne
	@JoinColumn(name = "formation_type_id")
	private FormationType formationType;

	public Cave() {
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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public FormationType getFormationType() {
		return formationType;
	}

	public Double getExploredLengthKm() {
		return exploredLengthKm;
	}

	public Boolean getOpenToPublic() {
		return openToPublic;
	}

	public void setOpenToPublic(Boolean openToPublic) {
		this.openToPublic = openToPublic;
	}

	public String getEntranceAuthority() {
		return entranceAuthority;
	}

	public void setEntranceAuthority(String entranceAuthority) {
		this.entranceAuthority = entranceAuthority;
	}

	public void setExploredLengthKm(Double exploredLengthKm) {
		this.exploredLengthKm = exploredLengthKm;
	}

	public void setFormationType(FormationType formationType) {
		this.formationType = formationType;
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
		Cave other = (Cave) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cave [id=").append(id).append(", name=").append(name).append(", createDate=").append(createDate)
				.append(", lastUpdate=").append(lastUpdate).append(", imageUrl=").append(imageUrl)
				.append(", description=").append(description).append(", enabled=").append(enabled).append("]");
		return builder.toString();
	}

}
