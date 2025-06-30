package bembos.enums;

public enum ProductSize {
    REGULAR(1.0, "Regular"),
    MEDIUM(1.5, "Mediana"),
    BIG(2.0, "Grande");

    private double factor;
    private String name;

    ProductSize(double factor, String name){
        this.factor = factor;
        this.name = name;
    }

    public double getFactor(){
        return factor;
    }
    @Override
    public String toString(){
        return name;
    }
    
    public static ProductSize fromTo(String sizeName) {
		for(ProductSize ps : ProductSize.values()){
			if(ps.toString().equalsIgnoreCase(sizeName)) return ps;
		}
		throw new IllegalArgumentException("No enum constant interfaces.ParkingStatus." + sizeName);
	}
}