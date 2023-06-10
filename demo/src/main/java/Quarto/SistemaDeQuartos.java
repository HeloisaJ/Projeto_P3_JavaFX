package Quarto;
public class SistemaDeQuartos {
    
    private static int numeroQuartosOcupados;
    private static final int QUARTOS_POR_ANDAR = 6;
    private static final int NUMERO_ANDARES = 6;
    private static Quarto quantQuartos [][] = new Quarto [QUARTOS_POR_ANDAR][NUMERO_ANDARES];

    /*public SistemaDeQuartos(){
        this.quantQuartos = new Quarto [QUARTOS_POR_ANDAR][NUMERO_ANDARES];
        inicializarQuartos();
    }*/

    public static void inicializarQuartos(){
        for(int i = 0; i < QUARTOS_POR_ANDAR; i++){
            for(int j = 0; j < NUMERO_ANDARES; j++){
                quantQuartos[i][j] = new Quarto(casalOuSolteiro(j));
            }
        }
    }

    private static boolean casalOuSolteiro(int j){
        if(j % 2 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static int buscarQuarto(Quarto modelo){
        if(numeroQuartosOcupados == QUARTOS_POR_ANDAR * NUMERO_ANDARES){ // Ver se todos os quartos estão ocupados
            return -1;
        }
        
        int i, j = 0;
        loopBusca:
        for(i = 0; i < QUARTOS_POR_ANDAR; i++){
            for(j = 0; j < NUMERO_ANDARES; j++){ // Procura uma cama com base no modelo que o usuário deseja
                if(modelo.equals(quantQuartos[i][j])){
                    break loopBusca;
                }
            }
        }    

        if(i == QUARTOS_POR_ANDAR && j == NUMERO_ANDARES){ // Não encontrou um quarto daquele estilo do qual o usuário deseja
            return -2;
        }

        int chave = calculoDaChave(i, j); // Criação da chave do quarto
        quantQuartos[i][j].setDisponivel(false);
        numeroQuartosOcupados++;

        return chave;
    }

    private static int calculoDaChave(int i, int j){
        return (i + 1) * 100 + (j + 1);
    }

    public static void checkOutDoCliente(int chave){
        quantQuartos[converterChaveI(chave)][converterChaveJ(chave)].setDisponivel(true);
    }

    private static int converterChaveI(int chave){
        return chave/100 - 1;
    }

    private static int converterChaveJ(int chave){
        return chave % 100 - 1;
    }
}
