/* Copyright 2014 Caterpillar Inc. All rights reserved. 
 * The work contains Caterpillar’s proprietary information, 
 * which may constitute a trade secret and/or be confidential. 
 * Copyright notice is precautionary only and does not imply publication.
 * 
 *  
 * Create By : wolffml
 * Create On : Jan 7, 2014
 */
package homework.week1;

import java.util.Scanner;


/*
 * Matt Wolff
 * MIS579 iLab / Week 1 / Problem 3
 * Requirements:
 * Develop a Java application that determines whether any of several department store customers has exceeded 
 * the credit limit on a charge account. For each customer, the following facts are available:
	A. account number;
	B. balance at the beginning of the month;
	C. total of all items charged by the customer this month;
	D. total of all credits applied to the customer's account this month; and
	E. allowed credit limit.
 * The program should input all of these facts as integers, then calculate the new balance (= beginning balance
 *  + charges - credits), display the new balance, and determine whether the new balance exceeds the customers 
 *  credit limit. For those customers whose credit limit is exceeded, the program should display the message 
 *  "Credit Limit Exceeded."
 */

public class Credit {
	private int accountNumber;
	private int beginningBalance;
	private int totalCharges;
	private int totalCredits;
	private int allowedCreditLimit;
	private int currentBalance;
	
	

	public Credit(int accountNumber, int beginningBalance, int totalCharges, int totalCredits, int allowedCreditLimit) {
		this.accountNumber = accountNumber;
		this.beginningBalance = beginningBalance;
		this.totalCharges = totalCharges;
		this.totalCredits = totalCredits;
		this.allowedCreditLimit = allowedCreditLimit;
		updateCurrentBalance();
	}
	
	public Credit(){
		
	}

	
	
	public static void main(String[] args) {
		
		//Tests of the Credit Class
		//Test 1: Account in Good Standing
		Credit testCredit =  new Credit(1234, 0, 1000, 500, 2000);
		System.out.println("***Credit Class Test1:");
		testCredit.showCreditMessage();
		//Test 2: Account in Good Standing
		Credit testCredit2 =  new Credit(1234, 500, 1000, 500, 750);
		System.out.println("***Credit Class Test2:");
		testCredit2.showCreditMessage();
		//Test 3: Change a value on existing object to verify balance is updated
		System.out.println("***Test Beginning Balance Change:");
		testCredit2.setBeginningBalance(0);
		testCredit2.showCreditMessage();
		
		
		//Now get User Input for Credit Class Use
		Scanner input = new Scanner(System.in);
		
		//Create Instance of Credit class for user input
		Credit credit = new Credit();
		
		//Get input from user for the relevant data
		System.out.printf("Input Credit Account Number: ");
		credit.setAccountNumber(input.nextInt());
		System.out.printf("Input Beginning Balance: ");
		credit.setBeginningBalance(input.nextInt());
		System.out.printf("Input Total Charges: ");
		credit.setTotalCharges(input.nextInt());
		System.out.printf("Input Total Credits: ");
		credit.setTotalCredits(input.nextInt());
		System.out.printf("Input Credit Limit: ");
		credit.setAllowedCreditLimit(input.nextInt());
		System.out.println("***Account Infomormation: ");
		credit.showCreditMessage();
		

	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBeginningBalance() {
		return beginningBalance;
	}

	public void setBeginningBalance(int beginningBalance) {
		this.beginningBalance = beginningBalance;
		updateCurrentBalance();  //need to update the current balance when this value changes
	}

	
	public int getAllowedCreditLimit() {
		return allowedCreditLimit;
	}

	public void setAllowedCreditLimit(int allowedCreditLimit) {
		this.allowedCreditLimit = allowedCreditLimit;
	}

	
	
	public void updateCurrentBalance() {
		//= beginning balance + charges - credits)
		currentBalance = beginningBalance + totalCharges - totalCredits;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	private void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(int totalCharges) {
		this.totalCharges = totalCharges;
		updateCurrentBalance();  //need to update the current balance when this value changes
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
		updateCurrentBalance();  //need to update the current balance when this value changes
	}

	@Override
	public String toString() {
		return "Credit [accountNumber=" + accountNumber + ", beginningBalance="
				+ beginningBalance + ", totalCharges=" + totalCharges
				+ ", totalCredits=" + totalCredits + ", allowedCreditLimit="
				+ allowedCreditLimit
				+ "]";
	}
	public void showCreditMessage() {
		System.out.println(this);
		System.out.println("Account Balance: " + currentBalance);
		if (currentBalance > allowedCreditLimit) {
			//Over the credit Limit
			System.out.println("Credit Limit Exceeded");
		} else {
			System.out.println("Account in Good Standing");
		}
	}
	
	
}

