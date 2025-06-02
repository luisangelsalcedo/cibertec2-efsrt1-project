package interfaces;

public enum Permission {
	USER(0, "usuario"),
	ADMIN(1, "administrador");
	
	private int key;
	private String name;
	
	Permission(int key, String name){
		this.key = key;
		this.name = name;
	}
	
	// getters
	public int getKey() {
		return key;
	}
	
	@Override
    public String toString(){
        return name;
    }
}
