package com.example.opentable.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tableorder")
public class Tableorder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToOne
	@JoinColumn(name = "Tableorder_id")
	private int TableOrderID;
	
	@OneToOne(mappedBy = "table_Id")
	private Table tableid;
	
	@Column
	private int No_of_persons;
	
	@OneToOne(mappedBy = "restId")
	private Restaurant restaurant;
	
	@Column
	private LocalDateTime  arrival_time;
	
	@Column
	private LocalDateTime departure_time;
	
	@Column
	private String note;

	public Tableorder() {
		super();
	}

	public Tableorder(int tableOrderID, Table tableid, int no_of_persons, Restaurant restaurant,
			LocalDateTime arrival_time, LocalDateTime departure_time, String note) {
		super();
		TableOrderID = tableOrderID;
		this.tableid = tableid;
		No_of_persons = no_of_persons;
		this.restaurant = restaurant;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.note = note;
	}

	public int getTableOrderID() {
		return TableOrderID;
	}

	public void setTableOrderID(int tableOrderID) {
		TableOrderID = tableOrderID;
	}

	public Table getTableid() {
		return tableid;
	}

	public void setTableid(Table tableid) {
		this.tableid = tableid;
	}

	public int getNo_of_persons() {
		return No_of_persons;
	}

	public void setNo_of_persons(int no_of_persons) {
		No_of_persons = no_of_persons;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public LocalDateTime getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(LocalDateTime arrival_time) {
		this.arrival_time = arrival_time;
	}

	public LocalDateTime getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(LocalDateTime departure_time) {
		this.departure_time = departure_time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Tableorder [TableOrderID=" + TableOrderID + ", tableid=" + tableid + ", No_of_persons=" + No_of_persons
				+ ", restaurant=" + restaurant + ", arrival_time=" + arrival_time + ", departure_time=" + departure_time
				+ ", note=" + note + "]";
	}
	
	
	
}
