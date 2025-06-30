package bembos.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import bembos.models.Combo;
import bembos.utils.FileUtil;

public class ComboDAO {
	private static final String filePath = "data/combos.txt";
	
	private List<Combo> combos;
	
	public ComboDAO() {
		combos = new ArrayList<>();
		loadDataFromFile();
	}
	
	public List<Combo> getAllCombos(){
		return new ArrayList<>(combos);
	}
	
	public Combo findComboById(UUID id) {
		return combos.stream().filter(combo -> combo.getId().equals(id)).findFirst().orElse(null);
	}
	
	public void insertCombo(Combo combo) {					
		combos.add(combo);
		writeDataToFile();
	}

	public void updateCombo(Combo combo) {
		combos.replaceAll(current -> current.getId().equals(combo.getId()) ? combo : current);
		writeDataToFile();
	}

	private void loadDataFromFile() {
		try {
			for(String line : FileUtil.readFile(filePath)) {
				String[] fields = line.split(",");
				
				Combo combo = new Combo();
				combo.setId(UUID.fromString(fields[0]));
				combo.setName(fields[1]);
				
				combos.add(combo);
			}
		} catch (Exception e) {
			System.out.println("Error leyendo el archivo " + filePath + ": " + e.getMessage());
		}
	}
	
	private void writeDataToFile() {
		try {
			List<String> lines = new ArrayList<>();
			
			for(Combo combo : combos)
				lines.add(combo.toString());

			FileUtil.writeFile(filePath, lines);
			
		} catch (Exception e) {
			System.out.println("Error escribiendo el archivo " + filePath + ": " + e.getMessage());
		}
	}
}
