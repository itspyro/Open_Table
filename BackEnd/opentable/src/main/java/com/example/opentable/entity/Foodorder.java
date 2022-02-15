package com.example.opentable.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FoodorderTable")
public class Foodorder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToOne
	@JoinColumn(name = "foodorder_id")
	private int foodorderId;
	
	@OneToOne(mappedBy = "BookingId")
	private Booking BookersId;
	
	@OneToMany(mappedBy = "item_Id")
	private List<Menu> items;
	
	@Column
	private int quantity;
	
	
	public Foodorder() {
	
	}


    public Foodorder(int foodorderId, Booking bookersId, List<Menu> items, int quantity) {
		super();
		this.foodorderId = foodorderId;
		BookersId = bookersId;
		this.items = items;
		this.quantity = quantity;
	}


	public int getFoodorderId() {
		return foodorderId;
	}


	public void setFoodorderId(int foodorderId) {
		this.foodorderId = foodorderId;
	}


	public Booking getBookersId() {
		return BookersId;
	}


	public void setBookersId(Booking bookersId) {
		BookersId = bookersId;
	}


	public List<Menu> getItems() {
		return items;
	}


	public void setItems(List<Menu> items) {
		this.items = items;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Foodorder [foodorderId=" + foodorderId + ", BookersId=" + BookersId + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}
