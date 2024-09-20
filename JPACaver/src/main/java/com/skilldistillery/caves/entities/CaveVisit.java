package com.skilldistillery.caves.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cave_visit")
public class CaveVisit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	@Column(name = "date_in")
	private LocalDate dateIn;
	@Column(name = "time_in")
	private LocalTime timeIn;
	@Column(name = "date_out")
	private LocalDate dateOut;
	@Column(name = "time_out")
	private LocalTime timeOut;
	@Column(name = "vertical_depth_reached_meters")
	private Double verticalDepthReachedMeters;
	@Column(name = "vertical_depth_on_rope_meters")
	private Double verticalDepthOnRopeMeters;
	private String notes;
	
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
	@JoinColumn(name = "cave_id")
	private Cave cave;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "trip_members",
			joinColumns = @JoinColumn(name = "cave_visit_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> tripMembers;

	public CaveVisit() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDateIn() {
		return dateIn;
	}

	public void setDateIn(LocalDate dateIn) {
		this.dateIn = dateIn;
	}

	public LocalTime getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(LocalTime timeIn) {
		this.timeIn = timeIn;
	}

	public LocalDate getDateOut() {
		return dateOut;
	}

	public void setDateOut(LocalDate dateOut) {
		this.dateOut = dateOut;
	}

	public LocalTime getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(LocalTime timeOut) {
		this.timeOut = timeOut;
	}

	public Double getVerticalDepthReachedMeters() {
		return verticalDepthReachedMeters;
	}

	public void setVerticalDepthReachedMeters(Double verticalDepthReachedMeters) {
		this.verticalDepthReachedMeters = verticalDepthReachedMeters;
	}

	public Double getVerticalDepthOnRopeMeters() {
		return verticalDepthOnRopeMeters;
	}

	public void setVerticalDepthOnRopeMeters(Double verticalDepthOnRopeMeters) {
		this.verticalDepthOnRopeMeters = verticalDepthOnRopeMeters;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	public List<User> getTripMembers() {
		return tripMembers;
	}

	public void setTripMembers(List<User> tripMembers) {
		this.tripMembers = tripMembers;
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
		CaveVisit other = (CaveVisit) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CaveVisit [id=").append(id).append(", title=").append(title).append(", dateIn=").append(dateIn)
				.append(", timeIn=").append(timeIn).append(", dateOut=").append(dateOut).append(", timeOut=")
				.append(timeOut).append(", verticalDepthReachedMeters=").append(verticalDepthReachedMeters)
				.append(", verticalDepthOnRopeMeters=").append(verticalDepthOnRopeMeters).append(", notes=")
				.append(notes).append("]");
		return builder.toString();
	}

}
