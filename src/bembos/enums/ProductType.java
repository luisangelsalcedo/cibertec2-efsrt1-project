package bembos.enums;

public enum ProductType {
	BURGER("hamburguesa"),
	SODA("bebida"),
	POTATOES("papas");
	
	private String name;
	
	ProductType(String name){
		this.name = name;
	}

	@Override
    public String toString(){
        return name;
    }
	
	public static ProductType fromTo(String typeName) {
		for(ProductType pt : ProductType.values()){
			if(pt.toString().equalsIgnoreCase(typeName)) return pt;
		}
		throw new IllegalArgumentException("No enum constant interfaces.ParkingStatus." + typeName);
	}
	

}
