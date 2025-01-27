package com.skilldistillery.dirtysoda.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "dirty_drink_add_in")
public class DirtyDrinkAddIn {

	@EmbeddedId
	private DirtyDrinkAddInId id;

	private Double amount;
	@Column(name = "amount_unit")
	private String amountUnit;

	@ManyToOne
	@JoinColumn(name = "dirty_drink_id")
	@MapsId("dirtyDrinkId")
	private DirtyDrink dirtyDrink;
	@ManyToOne
	@JoinColumn(name = "add_in_id")
	@MapsId("addInId")
	private AddIn addIn;

	public DirtyDrinkAddIn() {
		super();
	}

	public DirtyDrinkAddInId getId() {
		return id;
	}

	public void setId(DirtyDrinkAddInId id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAmountUnit() {
		return amountUnit;
	}

	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}

	public DirtyDrink getDirtyDrink() {
		return dirtyDrink;
	}

	public void setDirtyDrink(DirtyDrink dirtyDrink) {
		this.dirtyDrink = dirtyDrink;
	}

	public AddIn getAddIn() {
		return addIn;
	}

	public void setAddIn(AddIn addIn) {
		this.addIn = addIn;
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
		DirtyDrinkAddIn other = (DirtyDrinkAddIn) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DirtyDrinkAddIn [id=").append(id).append(", amount=").append(amount).append(", amountUnit=")
				.append(amountUnit).append(", dirtyDrink=").append(dirtyDrink).append(", addIn=").append(addIn)
				.append("]");
		return builder.toString();
	}

}
