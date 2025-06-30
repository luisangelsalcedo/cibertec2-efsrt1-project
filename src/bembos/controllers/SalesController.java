package bembos.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import bembos.models.Sale;
import bembos.utils.FileUtil;

public class SalesController {
	private final static String filePath =  "data/ventas.txt";
	private static List<Sale> sales = new ArrayList<>();
	private static ComboController comboController = new ComboController();
	
	//	discounts
	public static double discount1, discount2, discount3,discount4;

	// 	gifts
	public static String gift1, gift2, gift3;

	// sell variables
	public static int generalSalesCount;
	public static double generalSalesAmount, daily;
	public static String SalesMessages;
	
	static {
		discount1 = 7.5;
		discount2 = 10.0;
		discount3 = 12.5;
		discount4 = 15.0;
		
		gift1 = "Cupones de descuento";
		gift2 = "Cono de helado";
		gift3 = "Cajita Bembos";
		
		generalSalesCount = 0;
		generalSalesAmount = 0.0;
		daily = 50000.0;
	}	
	
	public static void addSale(Sale sale) {
		sales.add(sale);
		salesRegister();
		calculateSales(sale.getPaymentAmount());
	}
	public static List<Sale> getAllsales() {
		sales.removeAll(sales);
		try {
			for(String line : FileUtil.readFile(filePath)) {
				String[] fields = line.split(",");
				
				UUID saleID = UUID.fromString(fields[0]);
				UUID comboID = UUID.fromString(fields[1]);
				
				Sale current = new Sale(
						comboController.getCompleteComboByID(comboID),
						Integer.parseInt(fields[2]), 
						Double.parseDouble(fields[3])
						);
				current.setId(saleID);
				current.setSaleDate(LocalDate.parse(fields[4]));
				sales.add(current);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return new ArrayList<>(sales);
		
	}
	public static void calculateSales(double paymentAmount) {
		generalSalesCount++;
		generalSalesAmount += paymentAmount;
		
		// set message
		SalesMessages = "Venta Nro " + generalSalesCount;
		SalesMessages += "\nImporte total general acomulado: S/." + String.format("%,5.2f", generalSalesAmount);
		SalesMessages += "\nPorcentaje de la cuota diaria: " + String.format("%,5.2f", calculatePercentageDailyQuota()) + "%";
	}
	public static double calculateDiscount(int count, double cost) {
		if(count == 0)
			return 0.0;
		
		else if(count <= 5)
			return cost * (discount1 / 100);
		
		else if(count <= 10)
			return cost * (discount2 / 100);
		
		else if(count <= 15)
			return cost * (discount3 / 100);
		
		else 
			return cost * (discount4 / 100);
	}
	public static String calculateGifts(int count) {
		if(count == 1)
			return gift1;
		
		else if(count <= 5)
			return gift2;
		
		else 
			return gift3;
	}
	private static void salesRegister() {
		try {
			FileUtil.writeFile(filePath, sales.stream().map(sale -> sale.toString()).collect(Collectors.toList()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	private static double calculatePercentageDailyQuota() {
		return (100 * generalSalesAmount) / daily;
	}
	
}
