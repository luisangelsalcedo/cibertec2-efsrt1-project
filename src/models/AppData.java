package models;

import java.awt.Color;

public class AppData {
	
//	product 1
	public static String productName1 = "Duo Sabroso";
	public static int burgerName1 = 3;
	public static int burgerSize1 = 1;
	public static int burgerCount1 = 2;
	public static int potatoesSize1 = 1;
	public static int potatoesCount1 = 2;
	public static int sodaName1 = 2;
	public static int sodaCount1 = 2;
	public static double price1 = 61.40;

//	product 2
	public static String productName2 = "Duo Queso Tocino";
	public static int burgerName2 = 10;
	public static int burgerSize2 = 1;
	public static int burgerCount2 = 2;
	public static int potatoesSize2 = 2;
	public static int potatoesCount2 = 2;
	public static int sodaName2 = 0;
	public static int sodaCount2 = 0;
	public static double price2 = 49.60;
	
//	product 3
	public static String productName3 = "Familiar Perfecto";
	public static int burgerName3 = 11;
	public static int burgerSize3 = 1;
	public static int burgerCount3 = 4;
	public static int potatoesSize3 = 1;
	public static int potatoesCount3 = 4;
	public static int sodaName3 = 2;
	public static int sodaCount3 = 4;
	public static double price3 = 112.00;

//	product 4
	public static String productName4 = "Promo Royal";
	public static int burgerName4 = 9;
	public static int burgerSize4 = 2;
	public static int burgerCount4 = 1;
	public static int potatoesSize4 = 2;
	public static int potatoesCount4 = 1;
	public static int sodaName4 = 1;
	public static int sodaCount4 = 1;
	public static double price4 = 33.70;

//	product 5
	public static String productName5 = "Duo A lo Pobre";
	public static int burgerName5 = 7;
	public static int burgerSize5 = 2;
	public static int burgerCount5 = 2;
	public static int potatoesSize5 = 2;
	public static int potatoesCount5 = 2;
	public static int sodaName5 = 0;
	public static int sodaCount5 = 0;
	public static double price5 = 57.60;

//	product 6
	public static String productName6 = "Promo Epica";
	public static int burgerName6 = 1;
	public static int burgerSize6 = 1;
	public static int burgerCount6 = 1;
	public static int potatoesSize6 = 1;
	public static int potatoesCount6 = 1;
	public static int sodaName6 = 3;
	public static int sodaCount6 = 1;
	public static double price6 = 22.70;

//	discounts
	public static double discount1 = 7.5;
	public static double discount2 = 10.0;
	public static double discount3 = 12.5;
	public static double discount4 = 15.0;

// 	gifts
	public static String gift1 = "Cafetera";
	public static String gift2 = "Licuadora";
	public static String gift3 = "Extractor";

// sell variables
	public static int generalSalesCount = 0;
	public static double generalSalesAmount = 0.0;
	public static double daily = 50000.0;
	
	public static double calculatePercentageDailyQuota() {
		return (100 * generalSalesAmount) / daily;
	}
	
	
	public static String[] burgers = {
			"Ninguna",//0
			"La Épica", //1
			"Extrema", //2
			"Parrillera", //3
			"La carretillera", //4
			"Mexicana", //5
			"La Churrita", //6
			"A lo Pobre", //7
			"Hawaiana", //8
			"Royal", //9
			"Queso Tocino", //10
			"Cheese", //11
			"Clásica" //12
	};
	
	public static String[] burgerSlugs = {
			"", //0
			"epica", //1
			"extrema", //2
			"parrillera", //3
			"carretillera", //4
			"mexicana", //5
			"churrita", //6
			"a-lo-pobre", //7
			"hawaiana", //8
			"royal", //9
			"queso-tocino", //10
			"cheese", //11
			"clasica" //12
	};
	
	public static String[] sizeProducts = {
			"Ninguna", //0
			"Regular", //1
			"Mediana", //2
			"Grande" //3 
	};
	
	public static String[] sodas = {
			"Ninguna", //0
			"Coca Cola", //1
			"Inca kola", //2
			"Fanta" //3
	};
	
	public static String[] sodasSlug = {
			"", //0
			"coca-cola", //1
			"inca-kola", //2
			"fanta" //3 
	};
	
	public static String sourcePath = "C:\\Users\\seemc\\Work\\cibertec\\cibertec1-iaa-project\\assets\\";
	public static String favicon = "favicon.png";
	
	public static Color $primaryColor = new Color(2, 22, 137);
	public static Color $secondaryColor = new Color(255, 182, 0);
	public static Color $white = new Color(255, 255, 255);
	public static Color $primaryLightColor = new Color(0, 20, 219);
}
