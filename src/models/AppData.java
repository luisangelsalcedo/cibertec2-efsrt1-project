package models;

import java.awt.Color;

public class AppData {
	
//	product 1
	public static String productName1 = "Duo Sabroso";
	public static int burgerName1 = 2;
	public static int burgerSize1 = 0;
	public static int burgerCount1 = 2;
	public static int potatoesSize1 = 0;
	public static int potatoesCount1 = 2;
	public static int sodaName1 = 1;
	public static int sodaCount1 = 2;
	public static double price1 = 61.40;

//	product 2
	public static String productName2 = "Duo Queso Tocino";
	public static int burgerName2 = 9;
	public static int burgerSize2 = 0;
	public static int burgerCount2 = 2;
	public static int potatoesSize2 = 1;
	public static int potatoesCount2 = 2;
	public static int sodaName2 = 2;
	public static int sodaCount2 = 0;
	public static double price2 = 49.60;
	
//	product 3
	public static String productName3 = "Familiar Perfecto";
	public static int burgerName3 = 10;
	public static int burgerSize3 = 0;
	public static int burgerCount3 = 4;
	public static int potatoesSize3 = 0;
	public static int potatoesCount3 = 4;
	public static int sodaName3 = 1;
	public static int sodaCount3 = 4;
	public static double price3 = 112.00;

//	product 4
	public static String productName4 = "Promo Royal";
	public static int burgerName4 = 8;
	public static int burgerSize4 = 1;
	public static int burgerCount4 = 1;
	public static int potatoesSize4 = 1;
	public static int potatoesCount4 = 1;
	public static int sodaName4 = 0;
	public static int sodaCount4 = 1;
	public static double price4 = 33.70;

//	product 5
	public static String productName5 = "Duo A lo Pobre";
	public static int burgerName5 = 6;
	public static int burgerSize5 = 1;
	public static int burgerCount5 = 2;
	public static int potatoesSize5 = 1;
	public static int potatoesCount5 = 2;
	public static int sodaName5 = 0;
	public static int sodaCount5 = 0;
	public static double price5 = 57.60;

//	product 6
	public static String productName6 = "Promo Epica";
	public static int burgerName6 = 0;
	public static int burgerSize6 = 0;
	public static int burgerCount6 = 1;
	public static int potatoesSize6 = 0;
	public static int potatoesCount6 = 1;
	public static int sodaName6 = 2;
	public static int sodaCount6 = 1;
	public static double price6 = 22.70;
	
	
	public static String[] burgers = {
			"La Épica", //0
			"Extrema", //1
			"Parrillera", //2
			"La carretillera", //3
			"Mexicana", //4
			"La Churrita", //5
			"A lo Pobre", //6
			"Hawaiana", //7
			"Royal", //8
			"Queso Tocino", //9
			"Cheese", //10
			"Clásica" //11
	};
	
	public static String[] burgerSlugs = {
			"epica", //0
			"extrema", //1
			"parrillera", //2
			"carretillera", //3
			"mexicana", //4
			"churrita", //5
			"a-lo-pobre", //6
			"hawaiana", //7
			"royal", //8
			"queso-tocino", //9
			"cheese", //10
			"clasica" //11
	};
	
	public static String[] sizeProducts = {
			"Regular",  //0
			"Mediana",  //1
			"Grande" //2
	};
	
	public static String[] sodas = {
			"Coca Cola", //0
			"Inca kola", //1
			"Fanta" //2
	};
	
	public static String[] sodasSlug = {
			"coca-cola", //0
			"inca-kola", //1
			"fanta" //2
	};
	
	public static String sourcePath = "C:\\Users\\seemc\\Work\\cibertec\\cibertec1-iaa-project\\assets\\";
	
	public static Color $primaryColor = new Color(2, 22, 137);
	public static Color $secondaryColor = new Color(255, 182, 0);
	public static Color $white = new Color(255, 255, 255);
}
