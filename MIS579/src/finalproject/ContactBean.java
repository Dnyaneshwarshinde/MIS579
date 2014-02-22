package finalproject;
public class ContactBean {
	
	
	private String streetAddress;
	private String streetAddress2;
	private String city;
	private String state;
	private String zip;
	private String phone;
	
	public ContactBean(){
		super();
	}
	
	public ContactBean(String streetAddress, String streetAddress2,
			String city, String state, String zip, String phone) {
		super();
		this.streetAddress = streetAddress;
		this.streetAddress2 = streetAddress2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
	
	
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

