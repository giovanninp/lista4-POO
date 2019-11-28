package school.cesar.q3;

public class Despesa implements Comparable<Despesa> {
    private String nome;
    private Float valor;
    private int [] dataDeInsercao = new int [3];

    public void setNome (String nome) {
        this.nome = nome;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public void setDataDeInsercao(int dia, int mes, int ano){
        int [] data = {dia,mes,ano};
        this.dataDeInsercao = data;
    }

    public String getNome() {
        return this.nome;
    }

    public Float getValor() {
        return this.valor;
    }

    public int [] getDataDeInsercao() {
        return this.dataDeInsercao;
    }

    @Override
    public int compareTo(Despesa outro) {
        int pontuation = -2;
        if(this.valor > outro.getValor()){
            pontuation++;
        }

        if(0 > this.getNome().compareTo(outro.getNome())){
            pontuation++;
        }

        if(this.getDataDeInsercao()[0] > outro.getDataDeInsercao()[0]
            && this.getDataDeInsercao()[1] >= outro.getDataDeInsercao()[1]
            && this.getDataDeInsercao()[2] >= outro.getDataDeInsercao()[2]){
            pontuation++;
        }
        // -2 && -1 menor | 0 && 1 maior
        return (pontuation >= 0 ? 1 : -1 );
    }
}
