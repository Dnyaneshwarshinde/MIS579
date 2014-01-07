package homework.week1;

public class InvoiceTest {

	public static void main(String[] args) {
		// This is really just a run harness to test Invoice.java
		
		Invoice invoice1 = new Invoice("P000001", "Part Number 1", 5, 4.99);
		printInvoiceMessage(invoice1);
		Invoice invoice2 = new Invoice("P000002", "Part Number 2", 0, 4.99);
		printInvoiceMessage(invoice2);
		Invoice invoice3 = new Invoice("P000003", "Part Number 3", -2, 4.99);
		printInvoiceMessage(invoice3);
		Invoice invoice4 = new Invoice("P000004", "Part Number 4", 5, -4.99);
		printInvoiceMessage(invoice4);
	}
	
	public static void printInvoiceMessage(Invoice invoice){
		//Just print the relevant invoice information
		System.out.printf("Invoice for Part: %s \t", invoice.getPartNumber() );
		System.out.printf("Part Description: %s \t", invoice.getPartDescription() );
		System.out.printf("Quantity: %s \t", invoice.getQuantity() );
		System.out.printf("Price Per Item: %.2f \n", invoice.getPricePerItem());
		System.out.printf("Total Invoice Amount: %.2f \n", invoice.getInvoiceAmount() );
		System.out.println();
	}

}
