package com.aglassman.springsecurityexample.inventory;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String location;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="item_id", insertable = false, updatable = false)
	private Item item;

	public Stock() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Stock{");
		sb.append("id=").append(id);
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
			Objects.equals(location, stock.location);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, location);
	}
}
