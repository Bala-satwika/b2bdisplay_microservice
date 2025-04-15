package com.tvsmotor.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dealers") // Use the actual name of your MongoDB collection here
public class DealerData {

    @Id
    private String _id;

    private String name;
    private String address;
    private String pincode;
    private double lat;
    private double lng;
    private double ratings;
    private String timings;
    private String category;
    private String phoneNumber;
    private String website;
    private String businessStatus;
    private String photoUrl;
    private String state;

    
    private List<String> type;

    private List<Vehicle> vehicles;
    
    private String dealerId;
    private String stateId;
    
     
    public DealerData(String _id, String name, String address, String pincode, double lat, double lng, double ratings,
			String timings, String category, String phoneNumber, String website, String businessStatus, String photoUrl,
			String state, List<String> type, List<Vehicle> vehicles, String dealerId, String stateId) {
		super();
		this._id = _id;
		this.name = name;
		this.address = address;
		this.pincode = pincode;
		this.lat = lat;
		this.lng = lng;
		this.ratings = ratings;
		this.timings = timings;
		this.category = category;
		this.phoneNumber = phoneNumber;
		this.website = website;
		this.businessStatus = businessStatus;
		this.photoUrl = photoUrl;
		this.state = state;
		this.type = type;
		this.vehicles = vehicles;
		this.dealerId = dealerId;
		this.stateId = stateId;
	}



	public String getDealerId() {
		return dealerId;
	}



	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}



	public String getStateId() {
		return stateId;
	}



	public void setStateId(String stateId) {
		this.stateId = stateId;
	}



	public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public double getLat() {
		return lat;
	}



	public void setLat(double lat) {
		this.lat = lat;
	}



	public double getLng() {
		return lng;
	}



	public void setLng(double lng) {
		this.lng = lng;
	}



	public double getRatings() {
		return ratings;
	}



	public void setRatings(double ratings) {
		this.ratings = ratings;
	}



	public String getTimings() {
		return timings;
	}



	public void setTimings(String timings) {
		this.timings = timings;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public String getBusinessStatus() {
		return businessStatus;
	}



	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}



	public String getPhotoUrl() {
		return photoUrl;
	}



	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public List<String> getType() {
		return type;
	}



	public void setType(List<String> type) {
		this.type = type;
	}



	public List<Vehicle> getVehicles() {
		return vehicles;
	}



	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}



	public DealerData() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DealerData(String _id, String name, String address, String pincode, double lat, double lng, double ratings,
			String timings, String category, String phoneNumber, String website, String businessStatus, String photoUrl,
			String state, List<String> type, List<Vehicle> vehicles) {
		super();
		this._id = _id;
		this.name = name;
		this.address = address;
		this.pincode = pincode;
		this.lat = lat;
		this.lng = lng;
		this.ratings = ratings;
		this.timings = timings;
		this.category = category;
		this.phoneNumber = phoneNumber;
		this.website = website;
		this.businessStatus = businessStatus;
		this.photoUrl = photoUrl;
		this.state = state;
		this.type = type;
		this.vehicles = vehicles;
	}


     
	// Getters and Setters
    

    @Override
	public String toString() {
		return "DealerData [_id=" + _id + ", name=" + name + ", address=" + address + ", pincode=" + pincode + ", lat="
				+ lat + ", lng=" + lng + ", ratings=" + ratings + ", timings=" + timings + ", category=" + category
				+ ", phoneNumber=" + phoneNumber + ", website=" + website + ", businessStatus=" + businessStatus
				+ ", photoUrl=" + photoUrl + ", state=" + state + ", type=" + type + ", vehicles=" + vehicles
				+ ", dealerId=" + dealerId + ", stateId=" + stateId + "]";
	}



	public static class Vehicle {
        private String name;
        private int stock;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public Vehicle(String name, int stock) {
			super();
			this.name = name;
			this.stock = stock;
		}
		public Vehicle() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Vehicle [name=" + name + ", stock=" + stock + "]";
		}

        // Getters and Setters
        
        
    }
}

