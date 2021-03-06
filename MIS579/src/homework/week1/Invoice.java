package homework.week1;

/*
 * Matt Wolff
 * MIS579 iLab / Week 1 / Problem 2a
 * Requirements:
 * Create a class called Invoice that a hardware store might use to represent an invoice 
 * for an item sold at the store. An invoice should include four pieces of information as 
 * instance variables: a part number (type String), a part description (type String), a 
 * quantity of the item being purchased (type int), and a price per item (type double). Your 
 * class should have a constructor that initializes the four instance variables. Provide a 
 * set and a get method for each instance variable. In addition, provide a method named 
 * getInvoiceAmount that calculates the invoice amount (i.e., multiplies the quantity by 
 * the price per item) then returns the amount as a double value. If the quantity is not 
 * positive, it should be set to zero. If the price per item is not positive, it should be 
 * set to 0.0. Write a test application named InvoiceTest that demonstrates the class 
 * Invoice's capabilities.
 */
public class Invoice {

	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	//Generic constructor provided so that setters can be used to set variable values
	public Invoice() {
		partNumber = "";
		partDescription ="";
		quantity = 0;
		pricePerItem = 0.0;
	}
	
	//Constructor using several all of the class variables
	public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
		
		// I don't normally use Bean style setter methods from the constructor, but in this case
		// I wanted to only implement the logic making sure that quantity and pricePerItem are positive
		// in one place (their setter methods)
		setPartNumber(partNumber);
		setPartDescription(partDescription);
		setQuantity(quantity);
		setPricePerItem(pricePerItem);
	}
	
	//This get method provides the Invoice Amount, which is calculated (not an instance variable)
	public double getInvoiceAmount(){
		return quantity * pricePerItem;
	}

	//Generic getter method
	public String getPartNumber() {
		return partNumber;
	}
	//Generic setter method
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	//Generic getter method
	public String getPartDescription() {
		return partDescription;
	}

	//Generic setter method
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	//Generic getter method
	public int getQuantity() {
		return quantity;
	}
	
	//Setter method makes sure that quantity is a positive number
	public void setQuantity(int quantity) {
		//If the quantity is not positive, it should be set to zero
		if (quantity > 0) {
			this.quantity = quantity;
		} else {
			this.quantity = 0;
		}
	}
	//Generic getter method
	public double getPricePerItem() {
		return pricePerItem;
	}
	
	//Setter method makes sure that price per item is a positive number
	public void setPricePerItem(double pricePerItem) {
		if (pricePerItem > 0) {
			this.pricePerItem = pricePerItem;
		} else {
			this.pricePerItem = 0.0;
		}
	}

	//Just a toString() to help me with printing out tests
	@Override
	public String toString() {
		return "Invoice [partNumber=" + partNumber + ", partDescription="
				+ partDescription + ", quantity=" + quantity
				+ ", pricePerItem=" + pricePerItem + "]";
	}
	
	
}
