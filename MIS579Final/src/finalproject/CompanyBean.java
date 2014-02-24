package finalproject;
public class CompanyBean extends ContactBean {
	private String companyName;
	private String contactPerson;
	private String products;
	
	
	public CompanyBean() {
		super();
		
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	
	
}

