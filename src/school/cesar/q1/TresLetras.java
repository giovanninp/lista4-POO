package school.cesar.q1;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class TresLetras {
    private void swap(char [] entrada, int a, int b){
        char temp = entrada[b];
        entrada[b] = entrada[a];
        entrada[a] = temp;
    }

    private char [] paraArray(String entrada) {
        char [] result;
        result = new char [3];
        for(int i = 0; i < 3; i++) {
            result[i] = entrada.charAt(i);
        }
        return result;
    }

    private char [][] permutadorDeTres(String entrada) {
        char [][] result = new char [6][3];
        char [] entradaArr = paraArray(entrada);

        for(int linha = 0;linha < 6;linha++){
            System.out.println(entradaArr);
            result[linha] = entradaArr;
            swap(entradaArr,1,2);
            if((linha + 1) % 2 == 0){
                swap(entradaArr, 1, 2);
                swap(entradaArr, 0, 1);
            }
        }
        return result;
    }

    private boolean eValido(String el) {
        return (el.matches("^[a-zA-Z]*$") && el.length() == 5);
    }

    private void validadorDeEntrada(String text){
        if (!eValido(text)) throw new InvalidParameterException();
    }

    public void recepcao(Scanner s) {
        String input;
        System.out.println("|Digite um texto como entrada com o maximo de 5 caracteres:");
        input = s.nextLine();
        validadorDeEntrada(input);
        permutadorDeTres(input);
    }

    public static void main(String [] args) {
        TresLetras tres = new TresLetras();
        Scanner s = new Scanner(System.in);
        tres.recepcao(s);
        s.close();
    }
}
