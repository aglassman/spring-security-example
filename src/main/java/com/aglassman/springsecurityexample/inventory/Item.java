package com.aglassman.springsecurityexample.inventory;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ITEM")
@XmlRootElement
public class Item {

	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String sku;
	private String upc;
	private String itemName;
	private String description;
	private boolean preferredOnly;

	public Item() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isPreferredOnly() {
		return preferredOnly;
	}

	public void setPreferredOnly(boolean preferredOnly) {
		this.preferredOnly = preferredOnly;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Item{");
		sb.append("id=").append(id);
		sb.append(", sku='").append(sku).append('\'');
		sb.append(", upc='").append(upc).append('\'');
		sb.append(", itemName='").append(itemName).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", preferredOnly=").append(preferredOnly);
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
		Item item = (Item) o;
		return preferredOnly == item.preferredOnly &&
			Objects.equals(id, item.id) &&
			Objects.equals(sku, item.sku) &&
			Objects.equals(upc, item.upc) &&
			Objects.equals(itemName, item.itemName) &&
			Objects.equals(description, item.description);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, sku, upc, itemName, description, preferredOnly);
	}
}
