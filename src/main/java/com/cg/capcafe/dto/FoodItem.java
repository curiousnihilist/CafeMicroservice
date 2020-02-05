package com.cg.capcafe.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity class for storing food item details.
 * @author akasverm
 *
 */
@Entity
@Table(name = "food_item")
public class FoodItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_type",length = 10)
	@Enumerated(EnumType.STRING)
	private ItemType itemType;
	
	@Column(length = 20)
	private String name;
	
	private double price;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "cart")
	private Set<Order> orders = new HashSet<Order>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "menu")
	private Set<Cafe> cafe;
	
	public FoodItem(int itemId, ItemType itemType, String name, double price, Set<Order> orders, Set<Cafe> cafe) {
		super();
		this.itemId = itemId;
		this.itemType = itemType;
		this.name = name;
		this.price = price;
		this.orders = orders;
		this.cafe = cafe;
	}

	public FoodItem() {}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Cafe> getCafe() {
		return cafe;
	}

	public void setCafe(Set<Cafe> cafe) {
		this.cafe = cafe;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cafe == null) ? 0 : cafe.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItem other = (FoodItem) obj;
		if (cafe == null) {
			if (other.cafe != null)
				return false;
		} else if (!cafe.equals(other.cafe))
			return false;
		if (itemId != other.itemId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FoodItem [itemId=" + itemId + ", itemType=" + itemType + ", name=" + name + ", price=" + price
				+ ", orders=" + orders + ", cafe=" + cafe + "]";
	}
	
	
}
