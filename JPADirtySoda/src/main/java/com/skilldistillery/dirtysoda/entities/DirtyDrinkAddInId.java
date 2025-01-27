package com.skilldistillery.dirtysoda.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DirtyDrinkAddInId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "dirty_drink_id")
	private int dirtyDrinkId;
	@Column(name = "add_in_id")
	private int addInId;

	public DirtyDrinkAddInId() {
		super();
	}

	public DirtyDrinkAddInId(int dirtyDrinkId, int addInId) {
		super();
		this.dirtyDrinkId = dirtyDrinkId;
		this.addInId = addInId;
	}

	public int getDirtyDrinkId() {
		return dirtyDrinkId;
	}

	public void setDirtyDrinkId(int dirtyDrinkId) {
		this.dirtyDrinkId = dirtyDrinkId;
	}

	public int getAddInId() {
		return addInId;
	}

	public void setAddInId(int addInId) {
		this.addInId = addInId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addInId, dirtyDrinkId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirtyDrinkAddInId other = (DirtyDrinkAddInId) obj;
		return addInId == other.addInId && dirtyDrinkId == other.dirtyDrinkId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DrinkAddInId [dirtyDrinkId=").append(dirtyDrinkId).append(", addInId=").append(addInId)
				.append("]");
		return builder.toString();
	}
}
