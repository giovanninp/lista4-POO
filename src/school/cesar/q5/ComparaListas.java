package school.cesar.q5;

import java.util.ArrayList;
import java.util.Random;

public class ComparaListas {

    public static boolean existeLaNoArray(int [] lista, int valor){
        for(int a : lista) {
            if(a == valor){
                return true;
            }
        }
        return false;
    }

    public static boolean existeLaNoArrayList(ArrayList<Integer> lista, int valor){
        for(int a: lista){
            if(a == valor){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> comparar(int [] listaA, int [] listaB) {
        ArrayList <Integer> result = null;
        if(listaA.length > 0 && listaB.length > 0){
            result = new ArrayList<>();
            for(int a : listaA){
                if(existeLaNoArray(listaB,a) && !existeLaNoArrayList(result,a)){
                    result.add(a);
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static int randomize(int init,int len) {
        Random random = new Random();
        int result = random.nextInt(len);
        return result + init;
    }

    public static int [] geradorDeLista() {
        int [] result = new int[randomize(1,100)];
        for(int i = 0; i < result.length; i++){
            result[i] = randomize(-1000,2000);
        }
        return result;
    }

    public static void printarArray(int [] array, String title) {
        System.out.print("|"+title +":");
        for(int i:array){
            System.out.printf("%d ",i);
        }
        System.out.print("\n");
    }

    public static void main(String [] args) {

        for(int i = 0; i < 10; i++){
            System.out.println("Teste numero: " + (i + 1));
            int [] testA = geradorDeLista();
            printarArray(testA,"ListaA");
            int [] testB = geradorDeLista();
            printarArray(testB,"ListaB");

            comparar(testA,testB);
        }
    }
}
