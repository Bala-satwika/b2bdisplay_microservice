package com.tvsmotor.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.time.LocalDateTime;
@Document(collection = "Order")
public class Order {
    @Id
    private String _id;
    private String orderId;
    private String dealerId;
    private List<Item> items;
    private LocalDateTime date;
    public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDealerId() {
		return dealerId;
	}
	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Order(String _id, String orderId, String dealerId, List<Item> items, LocalDateTime date) {
		super();
		this._id = _id;
		this.orderId = orderId;
		this.dealerId = dealerId;
		this.items = items;
		this.date = date;
	}
	// Getters and Setters
    public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static class Item {
        private String product;
        private int quantity;
        private String status;
		public Item() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Item(String product, int quantity, String status) {
			super();
			this.product = product;
			this.quantity = quantity;
			this.status = status;
		}
		public String getProduct() {
			return product;
		}
		public void setProduct(String product) {
			this.product = product;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
        // Getters and Setters
    }
	
	
}