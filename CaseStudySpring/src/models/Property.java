package models;

import java.sql.Date;

public class Property {       // join P_Property with P_Salesperson
	private int property_id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String owner_name;
	private String owner_phone;
	private String sales_type;
	private String property_type;
	private int bedrooms;
	private int salesperon_id;
	private String salesperson_name;      // display only
	private String salesperson_phone;     // display only
	private String salesperson_email;     // display only
	private Float salesperson_comm;      // display only
	private Date posted_date;       // Date datatype?????  import from java SQL?????
	private String mls_number;
	private Double asking_price;
	private Double acceptance_price;
	private String status;
	private String photo_filename;
	
	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_phone() {
		return owner_phone;
	}
	public void setOwner_phone(String owner_phone) {
		this.owner_phone = owner_phone;
	}
	public String getSales_type() {
		return sales_type;
	}
	public void setSales_type(String sales_type) {
		this.sales_type = sales_type;
	}
	public String getProperty_type() {
		return property_type;
	}
	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getSalesperon_id() {
		return salesperon_id;
	}
	public void setSalesperon_id(int salesperon_id) {
		this.salesperon_id = salesperon_id;
	}
	public String getSalesperson_name() {
		return salesperson_name;
	}
	public void setSalesperson_name(String salesperson_name) {
		this.salesperson_name = salesperson_name;
	}
	public String getSalesperson_phone() {
		return salesperson_phone;
	}
	public void setSalesperson_phone(String salesperson_phone) {
		this.salesperson_phone = salesperson_phone;
	}
	public String getSalesperson_email() {
		return salesperson_email;
	}
	public void setSalesperson_email(String salesperson_email) {
		this.salesperson_email = salesperson_email;
	}
	public Float getSalesperson_comm() {
		return salesperson_comm;
	}
	public void setSalesperson_comm(Float salesperson_comm) {
		this.salesperson_comm = salesperson_comm;
	}
	public Date getPosted_date() {
		return posted_date;
	}
	public void setPosted_date(Date posted_date) {
		this.posted_date = posted_date;
	}
	public String getMls_number() {
		return mls_number;
	}
	public void setMls_number(String mls_number) {
		this.mls_number = mls_number;
	}
	public Double getAsking_price() {
		return asking_price;
	}
	public void setAsking_price(Double asking_price) {
		this.asking_price = asking_price;
	}
	public Double getAcceptance_price() {
		return acceptance_price;
	}
	public void setAcceptance_price(Double acceptance_price) {
		this.acceptance_price = acceptance_price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhoto_filename() {
		return photo_filename;
	}
	public void setPhoto_filename(String photo_filename) {
		this.photo_filename = photo_filename;
	}
}
