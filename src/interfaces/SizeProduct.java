package interfaces;

public enum SizeProduct {
    REGULAR(1.0, "Regular"),
    MEDIUM(1.5, "Mediana"),
    BIG(2.0, "Grande");

    private double factor;
    private String name;

    SizeProduct(double factor, String name){
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
}