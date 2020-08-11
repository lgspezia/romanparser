package converter;

import java.util.List;

class RomanParserService {

	// converte Romano para Arabico
    public static int romanToArabic(String input) {
        String romanStr = input.toUpperCase();
        int result = 0;
        
        List<RomanFigure> romanNumerals = RomanFigure.getReverseSortedValues();

        int i = 0;

        while ((romanStr.length() > 0) && (i < romanNumerals.size())) {
            RomanFigure symbol = romanNumerals.get(i);
            if (romanStr.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanStr = romanStr.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romanStr.length() > 0) {
            throw new IllegalArgumentException(input + " Não foi possível converter para algarismo Romano");
        }

        return result;
    }

    // converte Arabico para Romano
    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " Algarismo fora da faixa aceitada");
        }

        List<RomanFigure> romanNumerals = RomanFigure.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (number > 0 && i < romanNumerals.size()) {
            RomanFigure currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
