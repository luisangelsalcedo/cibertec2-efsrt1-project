package bembos.utils;

import java.awt.Color;
import java.net.URL;
import bembos.models.User;

public class StyleTheme {

	// general
	public static String AppTitle = "Bembos App";
	public static String sourcePath = "/assets/";
	public static String version = "2.0.0";
	public static URL favicon = StyleTheme.class.getResource(StyleTheme.sourcePath + "favicon.png");

	//	discounts
	public static double discount1 = 7.5;
	public static double discount2 = 10.0;
	public static double discount3 = 12.5;
	public static double discount4 = 15.0;

	// 	gifts
	public static String gift1 = "Cupones de descuento";
	public static String gift2 = "Cono de helado";
	public static String gift3 = "Cajita Bembos";

	// sell variables
	public static int generalSalesCount = 0;
	public static double generalSalesAmount = 0.0;
	public static double daily = 50000.0;
	
	public static double calculatePercentageDailyQuota() {
		return (100 * generalSalesAmount) / daily;
	}
	
	// session
	public static User loggedUser = null;	
	
	// styles
	public static Color $primaryColor = new Color(2, 22, 137);
	public static Color $secondaryColor = new Color(255, 182, 0);
	public static Color $white = new Color(255, 255, 255);
	public static Color $primaryLightColor = new Color(0, 20, 219);
}
