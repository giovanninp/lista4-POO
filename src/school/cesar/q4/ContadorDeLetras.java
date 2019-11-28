package school.cesar.q4;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class ContadorDeLetras {

    public static int contarOcorrencias(char entrada, String list){
        int result = 0;
        String temp;
        list = list.toLowerCase();
        for(int i = 0; i < list.length();i++) {
            if(list.charAt(i) == entrada) {
                result++;
            }
        }
        return result;
    }

    public static boolean existeLaNoArrayList(ArrayList<Character> lista, char valor){
        for(char a: lista){
            if(a == valor){
                return true;
            }
        }
        return false;
    }

    private boolean eValido(String el) {
        return el.matches("^[a-zA-Z]*$");
    }

    private void validadorDeEntrada(String text){
        if (!eValido(text)) throw new InvalidParameterException();
    }

    private char [] paraArray(String entrada) {
        char [] result;
        result = new char [entrada.length()];
        for(int i = 0; i < 3; i++) {
            result[i] = entrada.charAt(i);
        }
        return result;
    }

    public static void printDouble(ArrayList<Character> caracters, ArrayList<Integer> ocorrencias) {
        for(int i = 0; i< caracters.size();i++) {
            System.out.printf("\n%d ocorrencias da letra %c",ocorrencias.get(i),caracters.get(i));
        }
    }

    public static void comparador(String input) {
        input = input.toLowerCase();
        ArrayList <Character> caracteres = new ArrayList<>();
        ArrayList <Integer> ocorrencias = new ArrayList<>();
        for(int i = 0; i < input.length();i++){
            char actual = input.charAt(i);
            if(existeLaNoArrayList(caracteres,actual)){
                int index = caracteres.indexOf(actual);
                ocorrencias.set(index,caracteres.get(index) + 1);
            }
            else {
                caracteres.add(actual);
                ocorrencias.add(1);
            }
        }
//        for(char a : caracteres){
//            System.out.println(a);
//        }
        printDouble(caracteres,ocorrencias);
    }

    public static void main(String [] args) {
        comparador("Amoeba");
    }

}
