package db;

import java.awt.Color;
import java.net.URL;
import bembos.models.User;

public class StyleTheme {
	
//	public static List<Burger> burgersList;
//	public static List<Soda> sodasList;
//	public static List<BembosMenu> menusList;
//	public static List<User> usersList;
		
	static {
//		// burger
//		Burger epica 		= new Burger("Epica", 13.90);
//		Burger extrema 		= new Burger("Extrema", 25.90);
//		Burger parrillera 	= new Burger("Parrillera", 23.90);
//		Burger carretillera = new Burger("Carretillera", 23.90);
//		Burger mexicana 	= new Burger("Mexicana", 21.90);
//		Burger churrita 	= new Burger("Churrita", 21.90);
//		Burger alopobre 	= new Burger("A lo Pobre", 21.90);
//		Burger hawaiana 	= new Burger("Hawaiana", 21.90);
//		Burger royal 		= new Burger("Royal", 20.90);
//		Burger quesotocino 	= new Burger("Queso Tocino", 20.90);
//		Burger cheese 		= new Burger("Cheese", 19.90);
//		Burger clasica 		= new Burger("Clasica", 17.90);
//		
//		burgersList = new ArrayList<>();
//		burgersList.add(epica);
//		burgersList.add(extrema);
//		burgersList.add(parrillera);
//		burgersList.add(carretillera);
//		burgersList.add(mexicana);
//		burgersList.add(churrita);
//		burgersList.add(alopobre);
//		burgersList.add(hawaiana);
//		burgersList.add(royal);
//		burgersList.add(quesotocino);
//		burgersList.add(cheese);
//		burgersList.add(clasica);
//		
//		// soda
//		Soda cocacola 	= new Soda("Coca Cola", 5.90);
//		Soda incakola 	= new Soda("Inca Kola", 5.90);
//		Soda fanta 		= new Soda("Fanta", 5.90);
//		
//		sodasList = new ArrayList<>();
//		sodasList.add(cocacola);
//		sodasList.add(incakola);
//		sodasList.add(fanta);
//		
//		// potatoes
//		Potatoes potatoes = new Potatoes(6.90);
//		
//		// product 1
//		BembosMenu menu1 = new BembosMenu("Duo Sabroso");
//		menu1.addProduct(new Burger(parrillera));
//		menu1.addProduct(new Burger(parrillera));
//		menu1.addProduct(new Potatoes(potatoes));
//		menu1.addProduct(new Potatoes(potatoes));
//		menu1.addProduct(new Soda(incakola));
//		menu1.addProduct(new Soda(incakola));
//		
//		// product 2
//		BembosMenu menu2 = new BembosMenu("Duo Queso Tocino");
//		menu2.addProduct(new Burger(quesotocino));
//		menu2.addProduct(new Burger(quesotocino));
//		menu2.addProduct(new Potatoes(potatoes));
//		menu2.addProduct(new Potatoes(potatoes));
//		menu2.addProduct(new Soda(cocacola));
//		menu2.addProduct(new Soda(cocacola));
//
//		// product 3
//		BembosMenu menu3 = new BembosMenu("Familiar Perfecto");
//		menu3.addProduct(new Burger(cheese));
//		menu3.addProduct(new Burger(cheese));
//		menu3.addProduct(new Burger(cheese));
//		menu3.addProduct(new Burger(cheese));
//		menu3.addProduct(new Potatoes(potatoes));
//		menu3.addProduct(new Potatoes(potatoes));
//		menu3.addProduct(new Potatoes(potatoes));
//		menu3.addProduct(new Potatoes(potatoes));
//		menu3.addProduct(new Soda(incakola));
//		menu3.addProduct(new Soda(incakola));
//		menu3.addProduct(new Soda(incakola));
//		menu3.addProduct(new Soda(incakola));
//
//		// product 4
//		BembosMenu menu4 = new BembosMenu("Promo Big Royal");
//		menu4.addProduct(new Burger(royal, ProductSize.BIG));
//		menu4.addProduct(new Potatoes(potatoes, ProductSize.BIG));
//		menu4.addProduct(new Soda(cocacola));
//		
//		// product 5
//		BembosMenu menu5 = new BembosMenu("Duo A lo Pobre");
//		menu5.addProduct(new Burger(alopobre, ProductSize.MEDIUM));
//		menu5.addProduct(new Burger(alopobre, ProductSize.MEDIUM));
//		menu5.addProduct(new Potatoes(potatoes, ProductSize.MEDIUM));
//		menu5.addProduct(new Potatoes(potatoes, ProductSize.MEDIUM));
//		
//		// product 6
//		BembosMenu menu6 = new BembosMenu("Promo Epica");
//		menu6.addProduct(new Burger(epica));
//		menu6.addProduct(new Potatoes(potatoes));
//		menu6.addProduct(new Soda(fanta));
//		
//		menusList = new ArrayList<>();
//		menusList.add(menu1);
//		menusList.add(menu2);
//		menusList.add(menu3);
//		menusList.add(menu4);
//		menusList.add(menu5);
//		menusList.add(menu6);
		
		// users
//		usersList = new ArrayList<>();
//		usersList.add(User.createAdmin("seemc9", "12345678"));
//		usersList.add(User.createUser("carlos", "12345678"));
	
	}

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
