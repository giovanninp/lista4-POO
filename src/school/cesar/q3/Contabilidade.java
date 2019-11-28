package school.cesar.q3;

import sun.security.krb5.internal.crypto.Des;

import java.util.Collection;
import java.util.LinkedList;

public class Contabilidade {
    private Collection <Despesa> despesas = new LinkedList<>();

    public Despesa buscarDespesaPorNome(String nome) {
        for(Despesa a : despesas) {
            if(a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    public boolean cadastrarDespesa(Despesa nova,int dia, int mes, int ano) {
        boolean result;
        if(buscarDespesaPorNome(nova.getNome()) != null){
            result = false;
        }
        else {
            nova.setDataDeInsercao(dia,mes,ano);
            this.despesas.add(nova);
            result = true;
        }
        return result;
    }

//    public Despesa [] ordenarDespesasPorValor(){
//        Despesa [] result = null;
//        int tamDesp = this.despesas.size();
//        if (tamDesp > 0) {
//             int count = 0;
//             boolean strike = true;
//             while(strike) {
//                 result = new Despesa[tamDesp];
//                 strike = false;
//                 for (Despesa a : this.despesas) {
//                     for (Despesa b : this.despesas) {
//                         if (!a.equals(b)) {
//                            if(b.getValor() > a) {
//
//                            }
//                         }
//                     }
//                 }
//             }
//        }
//        return result;
//    }

//    public Despesa [] despesasEmOrdem(int por) {
//
//    }

    public static void main(String [] args) {
        int result = ("Bola".compareTo("Aula"));
        System.out.println(result);
    }

}
