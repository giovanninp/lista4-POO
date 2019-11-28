package school.cesar.q2;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class ConversorMorse {
    private String[][] morseChars = {
            {"a", ".-"},    {"b", "-..."},  {"c", "-.-."},  {"c", "-.-."},
            {"d", "-.."},   {"e", "."},     {"f", "..-."},  {"g", "--."},
            {"h", "...."},  {"i", ".."},    {"j", ".---"},  {"k", "-.-"},
            {"l", ".-.."},  {"m", "--"},    {"n", "-."},    {"o", "---"},
            {"p", ".--."},  {"q", "--.-"},  {"r", ".-."},   {"s", "..."},
            {"t", "-"},     {"u", "..-"},   {"v", "...-"},  {"w", ".--"},
            {"x", "-..-"},  {"y", "-.--"},  {"z", "--.."},
            {"1", ".----"}, {"2", "..---"}, {"3", "...--"}, {"4", "....-"},
            {"5", "....."}, {"6", "-...."}, {"7", "--..."}, {"8", "---.."},
            {"9", "----."}, {"0", "-----"}, {"-", "-"}
    };

    private String converterString(String input,int type) {
        String result = "";
        for (String[] morseChar : this.morseChars) {
            if (morseChar[type].equalsIgnoreCase(input)) {
                result = morseChar[(type == 0) ? 1 : 0];
            }
        }
        return result;
    }

    private boolean eValido(String el) {
        return el.matches("^[a-zA-Z.\\x29-\\x300-9\\s]*$");
    }


    private String morseParaPortugues(String text) {
        StringBuilder result = new StringBuilder();
        String [] linhaTexto = text.split("\\s{3}");
        for (String s : linhaTexto) {
            String[] textoInterno = s.split("\\s");
            for (String value : textoInterno) {
                result.append(this.converterString(value, 1));
            }
            result.append(" ");
        }
        return result.toString();
    }

    private String portuguesParaMorse(String text) {
        StringBuilder result = new StringBuilder();
        String [] linhaText = text.split(" ");
        for (String s : linhaText) {
            for (int j = 0; j < s.length(); j++) {
                result.append(converterString(Character.toString(s.charAt(j)), 0)).append(" ");
            }
            result.append("   ");
        }
        return result.toString();
    }

    private void validadorDeEntrada(String text){
        if (!eValido(text)) throw new InvalidParameterException();
    }

    public void execute() {
        Scanner s = new Scanner(System.in);Scanner s2 = new Scanner(System.in);
        int choice;String input;

        System.out.println("|Selecione a operacao:\n|(0) Portugues -> Morse\n|(1) Morse -> Porgtugues");
        choice = s.nextInt();
        System.out.println("|Digite o texto a ser traduzido:");
        input = s2.nextLine();
        input = input.toLowerCase();
        s.close(); s2.close();
        this.validadorDeEntrada(input);
        System.out.println((choice == 0)
                ? this.portuguesParaMorse(input)
                : this.morseParaPortugues(input));
    }

    public static void main(String [] args) {
        ConversorMorse c = new ConversorMorse();
        c.execute();
    }
}
