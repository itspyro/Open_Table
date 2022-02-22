package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.TableOrderDto;

public class TableOrderDetailsResponse extends ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -783598144088955000L;

	List<TableOrderDto> tableOrders;

	public TableOrderDetailsResponse(List<TableOrderDto> tableOrders) {
		this.tableOrders = tableOrders;
	}

	public List<TableOrderDto> getTableOrders() {
		return tableOrders;
	}

	public void setTableOrders(List<TableOrderDto> tableOrders) {
		this.tableOrders = tableOrders;
	}
	
	
}
