package com.skilldistillery.divelog.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

@Entity
public class Dive {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "dive_date")
	private LocalDate diveDate;
	@Column(name = "time_in")
	private LocalTime timeIn;
	@Column(name = "time_out")
	private LocalTime timeOut;
	@Column(name = "decompress_minutes")
	private Integer decompressMinutes;
	private String notes;
	@Column(name = "wildlife_seen")
	private String wildlifeSeen;
	@Column(name = "maximum_depth_meters")
	private Integer maximumDepthMeters;
	@Column(name = "weight_kilograms")
	private Double weightKilograms;
	
	@CreationTimestamp
	@Column(name = "create_date")
	private LocalDateTime createDate;
	@UpdateTimestamp
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "dive_site_id")
	private DiveSite diveSite;

	public Dive() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDiveDate() {
		return diveDate;
	}

	public void setDiveDate(LocalDate diveDate) {
		this.diveDate = diveDate;
	}

	public LocalTime getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(LocalTime timeIn) {
		this.timeIn = timeIn;
	}

	public LocalTime getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(LocalTime timeOut) {
		this.timeOut = timeOut;
	}

	public Integer getDecompressMinutes() {
		return decompressMinutes;
	}

	public void setDecompressMinutes(Integer decompressMinutes) {
		this.decompressMinutes = decompressMinutes;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getMaximumDepthMeters() {
		return maximumDepthMeters;
	}

	public void setMaximumDepthMeters(Integer maximumDepthMeters) {
		this.maximumDepthMeters = maximumDepthMeters;
	}

	public Double getWeightKilograms() {
		return weightKilograms;
	}

	public void setWeightKilograms(Double weightKilograms) {
		this.weightKilograms = weightKilograms;
	}

	public String getWildlifeSeen() {
		return wildlifeSeen;
	}

	public void setWildlifeSeen(String wildlifeSeen) {
		this.wildlifeSeen = wildlifeSeen;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DiveSite getDiveSite() {
		return diveSite;
	}

	public void setDiveSite(DiveSite diveSite) {
		this.diveSite = diveSite;
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
		Dive other = (Dive) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dive [id=").append(id).append(", diveDate=").append(diveDate).append(", timeIn=").append(timeIn)
				.append(", timeOut=").append(timeOut).append(", decompressMinutes=").append(decompressMinutes)
				.append(", notes=").append(notes).append(", maximumDepthMeters=").append(maximumDepthMeters)
				.append(", weightKilograms=").append(weightKilograms).append("]");
		return builder.toString();
	}

}
