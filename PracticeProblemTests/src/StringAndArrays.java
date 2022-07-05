import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;

public class StringAndArrays {

	public static void main(String[] args) {
		
	}

	public static boolean isUnique(String str) {
		Hashtable<Character, Boolean> characterTable = new Hashtable<>();

		for (Character s : str.toCharArray()) {
			if (characterTable.containsKey(s)) {
				return false;
			} else {
				characterTable.put(s, true);
			}
		}

		return true;
	}

	public static boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		Hashtable<Character, Integer> count1 = new Hashtable<>();
		Hashtable<Character, Integer> count2 = new Hashtable<>();

		for (Character c : str1.toCharArray()) {
			if (count1.containsKey(c)) {
				count1.replace(c, count1.get(c) + 1);
			} else {
				count1.put(c, 1);
			}
		}

		for (Character c : str2.toCharArray()) {
			if (count2.containsKey(c)) {
				count2.replace(c, count2.get(c) + 1);
			} else {
				count2.put(c, 1);
			}
		}

		for (Character c : str2.toCharArray()) {
			if (!count1.containsKey(c) || count1.get(c) != count2.get(c)) {
				return false;
			}
		}

		return true;

	}

	public static String urlify(String str) {

		StringBuilder url = new StringBuilder();
		
		for(Character c : str.trim().toCharArray()) {
			if(c == ' ') {
				url.append("%20");
			}
			else {
				url.append(c);
			}
		}
		
		return url.toString();
	}
	
	public static boolean palPerm(String str) {
		Hashtable<Character, Integer> counts = new Hashtable<>();
		int oddCount = 0;
		int charCount = 0;

		for (Character c : str.trim().toLowerCase().toCharArray()) {
			if (counts.containsKey(c)) {
				counts.replace(c, counts.get(c) + 1);
			} else {
				counts.put(c, 1);
			}
		}

		counts.remove(' ');
		Set<Character> setOfKeys = counts.keySet();

		for (Character c : setOfKeys) {
			charCount += counts.get(c);

			if (counts.get(c) % 2 != 0) {
				oddCount++;
			}
		}

		if (charCount % 2 == 0) {
			return oddCount == 0;
		} else {
			return oddCount == 1;
		}
	}
	
	public static boolean hasNoEdits(String str1, String str2){
		if(Math.abs(str1.length() - str2.length()) > 1){
			return false;
		}
		
		int[] characters = new int[128];
		
		for(Character c : str1.toCharArray()){
			characters[c]++;
		}
		for(Character c : str2.toCharArray()){
			if(characters[c] != 0) {
				characters[c]--;
			}
				
		}
		
		int sum = 0;
		for(int i : characters) {
			sum += i;
		}
		
		if(Math.abs(sum) > 1) {
			return false;
		}
		
		return true;
	}

}
