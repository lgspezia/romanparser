package converter;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		RomanParserService rac = new RomanParserService();
		
		List<String> romans = new ArrayList<String>();
		romans.add("V");
		romans.add("L");
		romans.add("XL");
		romans.add("XX");
		
		List<Integer> arabics = new ArrayList<Integer>();
		arabics.add(5);
		arabics.add(50);
		arabics.add(40);
		arabics.add(20);

		System.out.println("Conversor de Algarismos / Figure Parser");
		System.out.println("Conversão de Romano para Arabico : ");
		for (String romanStr : romans) {
			System.out.println(rac.romanToArabic(romanStr));
		}

		System.out.println("Conversão de Arábico para Romano : ");
		for (Integer arabicInt : arabics) {
			System.out.println(rac.arabicToRoman(arabicInt));
		}
		
		
		

	}

}
