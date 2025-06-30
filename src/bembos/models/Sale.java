package bembos.models;

import java.time.LocalDate;
import java.util.UUID;

public class Sale {
	private UUID id;
	private UUID comboID;
	private Combo combo;
    private int count;
    private double paymentAmount;
    private LocalDate saleDate;
    
    public Sale(Combo combo, int count, double paymentAmount) {
    	this.id = UUID.randomUUID();
    	setCombo(combo);
    	setCount(count);
    	setPaymentAmount(paymentAmount);
    	setSaleDate(LocalDate.now());
    }
    
    //getters
	public UUID getId() {
		return id;
	}
	public UUID getComboID() {
		return comboID;
	}
	public Combo getCombo() {
		return combo;
	}
	public int getCount() {
		return count;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}

	//setters
	public void setId(UUID id) {
		this.id = id;
	}
	public void setComboID(UUID comboID) {
		this.comboID = comboID;
	}
	public void setCombo(Combo combo) {
		this.combo = combo;
		setComboID(combo.getId());
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	
	//methods
	@Override
	public String toString() {
		return String.valueOf(id + "," + comboID + "," + count + "," + String.format("%,5.2f", paymentAmount) + "," + saleDate);
	}

	

	


}
