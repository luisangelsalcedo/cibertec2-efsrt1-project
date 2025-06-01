package bembos.utils;

import java.util.List;
import java.util.function.Function;

import javax.swing.JComboBox;

public class Utils {

	public static boolean hasBlankSpaces(String text) {
		return text.indexOf(" ") != -1;
	}
	
	public static String createSlug(String text) {
		String textLowerCase = text.toLowerCase().trim();	
		
		if(Utils.hasBlankSpaces(textLowerCase))
			return textLowerCase.replace(" ", "-");
		else return textLowerCase;
	}
	
	public static <T> String[] createComboBoxArray(
		List<T> list,
		String firstItem,
		Function<T, String> nameExtractor
    ) {
        String[] array = new String[list.size() + 1];
        array[0] = firstItem;

        for (int i = 0; i < list.size(); i++) {
            array[i + 1] = nameExtractor.apply(list.get(i));
        }
        return array;
    }
	
	public static int comboBoxIndexOf(JComboBox<String> comboBox, String itemMatch) {
		int index = -1;
		for(int i=0; comboBox.getItemCount() > i; i++) {			
			if(comboBox.getItemAt(i) == itemMatch ) {
				index = i;
			}
		}
		return index;
	}
}
