package models;

import java.awt.Color;

public class AppData {
	
//	product 1
	public static String productName1 = "Duo Sabroso";
	public static String burgerName1 = "A lo Pobre";
	public static String burgerSize1 = "Regular";
	public static int burgerCount1 = 2;
	public static String potatoesSize1 = "Regular";
	public static int potatoesCount1 = 2;
	public static String sodaName1 = "Inca kola";
	public static int sodaCount1 = 2;
	public static double price1 = 61.40;

//	product 2
	public static String productName2 = "Duo Queso Tocino";
	public static String burgerName2 = "Queso Tocino";
	public static String burgerSize2 = "Regular";
	public static int burgerCount2 = 2;
	public static String potatoesSize2 = "Medianas";
	public static int potatoesCount2 = 2;
	public static String sodaName2 = "";
	public static int sodaCount2 = 0;
	public static double price2 = 49.60;
	
//	product 3
	public static String productName3 = "Familiar Perfecto";
	public static String burgerName3 = "Cheese";
	public static String burgerSize3 = "Regular";
	public static int burgerCount3 = 4;
	public static String potatoesSize3 = "Regular";
	public static int potatoesCount3 = 4;
	public static String sodaName3 = "Inca Kola";
	public static int sodaCount3 = 4;
	public static double price3 = 112.00;

//	product 4
	public static String productName4 = "Promo Royal";
	public static String burgerName4 = "Royal";
	public static String burgerSize4 = "Mediana";
	public static int burgerCount4 = 1;
	public static String potatoesSize4 = "Mediana";
	public static int potatoesCount4 = 1;
	public static String sodaName4 = "Inca Kola";
	public static int sodaCount4 = 1;
	public static double price4 = 33.70;

//	product 5
	public static String productName5 = "Duo A lo Pobre";
	public static String burgerName5 = "A lo Pobre";
	public static String burgerSize5 = "Mediana";
	public static int burgerCount5 = 2;
	public static String potatoesSize5 = "Mediana";
	public static int potatoesCount5 = 2;
	public static String sodaName5 = "";
	public static int sodaCount5 = 0;
	public static double price5 = 57.60;

//	product 6
	public static String productName6 = "Promo Epica";
	public static String burgerName6 = "La Épica";
	public static String burgerSize6 = "Regular";
	public static int burgerCount6 = 1;
	public static String potatoesSize6 = "Regular";
	public static int potatoesCount6 = 1;
	public static String sodaName6 = "Inca Kola";
	public static int sodaCount6 = 1;
	public static double price6 = 22.70;
	
	
	public static String[] burgers = {
			"La Épica",
			"Extrema",
			"Parrillera",
			"La carretillera",
			"Mexicana",
			"La Churrita",
			"A lo Pobre",
			"Hawaiana",
			"Royal",
			"Queso Tocino",
			"Cheese",
			"Clásica"
	};
	
	public static String[] burgerSlugs = {
			"epica",
			"extrema",
			"parrillera",
			"carretillera",
			"mexicana",
			"churrita",
			"a-lo-pobre",
			"hawaiana",
			"royal",
			"queso-tocino",
			"cheese",
			"clasica"
	};
	
	public static String[] sizeProducts = {
			"Regular", 
			"Mediana", 
			"Grande"
	};
	
	public static String[] sodas = {
			"Coca Cola",
			"Inca kola",
			"Fanta"
	};
	
	public static String[] sodasSlug = {
			"coca-cola",
			"inca-kola",
			"fanta"
	};
	
	public static String sourcePath = "C:\\Users\\seemc\\Work\\cibertec\\cibertec1-iaa-project\\assets\\";
	
	public static Color $primaryColor = new Color(2, 22, 137);
	public static Color $secondaryColor = new Color(255, 182, 0);
	public static Color $white = new Color(255, 255, 255);
}
