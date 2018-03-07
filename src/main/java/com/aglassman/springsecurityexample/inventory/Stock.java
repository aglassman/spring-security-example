package com.aglassman.springsecurityexample.inventory;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private Long itemId;
	private OffsetDateTime stockedOn;
	private String location;

	public Stock() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public OffsetDateTime getStockedOn() {
		return stockedOn;
	}

	public void setStockedOn(OffsetDateTime stockedOn) {
		this.stockedOn = stockedOn;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Stock{");
		sb.append("id=").append(id);
		sb.append(", itemId=").append(itemId);
		sb.append(", stockedOn=").append(stockedOn);
		sb.append(", location='").append(location).append('\'');
		sb.append('}');
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Stock stock = (Stock) o;
		return Objects.equals(id, stock.id) &&
			Objects.equals(itemId, stock.itemId) &&
			Objects.equals(stockedOn, stock.stockedOn) &&
			Objects.equals(location, stock.location);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, itemId, stockedOn, location);
	}
}
