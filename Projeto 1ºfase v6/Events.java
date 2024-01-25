/**
 * Esta classe gere toda a informação relativamente aos eventos e as funcionalidades do mesmo.
 * 
 * @author (Rita e Diana) 
 * @version (v9)
 */
//código adicional de forma a fazer uso das listas de arrays
import java.util.ArrayList;
import java.util.List;
//criação da class events
public class Events
{
    //3 atributos iniciais de nome (string), lista de edições (array list) e popularidade (string).
    private String name;
    private ArrayList<EventEdition> editions; 
    private String popularity;
    private double ocupation;
    //construtor da classe Events com um parâmetro para o nome (string).
    public Events(String name){
        
        //inicialização dos atributos.
        this.name=name;
        this.editions = new ArrayList<>();
        
        //o valor inicial do atributo da popularidade é "desconhecida".
        this.popularity="desconhecida";
         this.ocupation = ocupation;
    }
    
    //método addEdition que serve para adicionar novas edições.
    //fazemos uso do método add que a classe ArrayList já possui.
    public void addEdition(EventEdition eventEdition){
        editions.add(eventEdition);
    }
    
    //método printInformation para imprimir toda a informação relativa ao evento, com a inclusão da informação de toda as edições
    //fazemos uso da instrução println para imprimir o nome, a popularidade e a lista de edições
    public void printInformation(){
        System.out.println("Name: " + name);
        System.out.println("Popularidade: " + popularity);
        System.out.println("Edições: " + editions);
    }
    
    //método calculatePopularity onde usamos a fórmula de cálculo dada no enunciado do projeto
    public void calculatePopularity(){        
        /*
         * if(popularidadeMedia <= 0.25){
            this.popularity = "Fraca";
            }
        
        if(popularidadeMedia <= 0.5 && popularidadeMedia > 0.25){
            this.popularity = "Nova";
        }
        
        if(popularidadeMedia <= 0.75 && popularidadeMedia > 0.5){
            this.popularity = "Grande";
        }
        
        if(popularidadeMedia <= 1 && popularidadeMedia > 0.75){
            this.popularity = "Topo";
        }
         */
    }
    
    //foi criado um método estático double que têm como parâmetros 2 arrays de int que no fimnos retorna um valor em double
    //os parâmetros são o número de participantes em cada palestra e o número da capaciade total das salas
    private static double calculatePopularity(int[] participantes, int[] totalCapacity) {
        
        //adicionámos uma variável double de forma a auxiliar os cálculos
        double somaPopularidade = 0;
        
        //utilizamos o ciclo for-each de forma a conseguir percorrer todas as palestras de uma edição
        for (int i = 0; i < participantes.length; i++) {
            //o valor da popularidade da palestra calcula-se ao dividir o valor dos participantes pelo valor da capacidade total da sala onde a mesma ocurreu
            //de seguida multiplica-se esse valor por 100
            double popularidadePalestra = ((double) participantes[i] / totalCapacity[i]) * 100;
            
            //ao percorrer as palestras, e efetuar os cálculos, os valores são adicionados á variável criada anteriormente
            somaPopularidade += popularidadePalestra;
        }
        
        //a variável para a popularidade média dá-se por fim, ao dividir o valor obtido na soma da popularidade de todas as palestras da eição
        //que depois é dividido pelo número de elementos dos participantes
        double popularidadeMedia = somaPopularidade / participantes.length;
        
        //retorna o valor da popularidade média
        return popularidadeMedia;
    }
    
    //outro método estático String para separar a popularidade em níveis
    //temos como parâmetro a popularidade em tipo double
    private static String PopularityLevel(double popularidade) {
        
        //se a popularidade for menor ou igual a 25% designa-se fraca
        if (popularidade <= 25) {
            return "Fraca";
        } 
        //se a popularidade for menor ou igual a 50%, e maior que 25% designa-se média
        else if (popularidade <= 50 && popularidade > 25) {
            return "Média";
        } 
        //se a popularidade for menor ou igual a 75%, e maior que 50% designa-se grande
        else if (popularidade <= 75 && popularidade > 50) {
            return "Grande";
        } 
        //se a popularidade for menor ou igual a 100%,e maior que 75 designa-se de topo
        else {
            return "De topo";
        }
    }
}
//fim da classe Events
