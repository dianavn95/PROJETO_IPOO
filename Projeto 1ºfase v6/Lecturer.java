/**
 * Esta classe gere a informação relativa aos palestrantes e as suas funcionalidades.
 * 
 * @author (Rita e Diana) 
 * @version (v9)
 */
//código adicional para fazer uso das listas de arrays
import java.util.ArrayList;
import java.util.List;
//criação da classe Lecturer para gerir a informação sobre os palestrantes
public class Lecturer
{
    
    //atríbutos listados no enunciado do projeto
    private String name;
    private List<Lecture> lectures;
    private Double popularity;
    
    //construtor da classe Lecturer
    public Lecturer()
    {
        
        //inicialização dos atríbutos
        this.name = name;
        this.lectures = new ArrayList<>();
        
        //inialmente a popularidade é desconhecida
        this.popularity = null;
        
    }
    
    //método Lecturer com o parâmetro nome
    public Lecturer(String name)
    {
        this.name = name;
        this.lectures = new ArrayList<>();
        this.popularity = null;
        
    }
    
    //método addLecture com parâmetro Lecture para adicionar novas palestras
    public void addLecture(Lecture lecture) {
        
        //faz-se uso do método add já incluído na classe ArrayList
        lectures.add(lecture);
    }
    
    
    //método para cálcular a popularidade do palestrante
    public void calculatePopularity() {
         
    }
    
    //método estático double para auxiliar no cálculo da popularidade do palestrante
    //têm como parâmetros o número de participantes e o número
    private static double calculatePopularity(int[] participantes, int[] totalCapacity) {
        
        //variável double para representar a popularidade média do palestrante, de forma a auxiliar nos cáclculos
        double popularidadeMedia = 0;
        
        //ciclo for-each, onde se percorre a lista de participantes 
        for (int i = 0; i < participantes.length; i++) {
            
            //variável double para fazer o cálculo da popularidade
            //divide-se o valor dos participantes por a capaciade total da sala e múltiplica-se por 100
            //mesma fórmula de cálculo usada na classe Events
            double popularidadePalestrante = ((double) participantes[i] / totalCapacity[i]) * 100;
            
            //a popularidade média do palestrante é igualada (e somada) á popularidade do palestrante
            popularidadeMedia += popularidadePalestrante;
        }
        
        //retorna o valor da popularidade média do palestrante
        return popularidadeMedia;
    }

    //método listInformation para listar todas as informações relativamente a um palestrante
    public void listInformation() {
        System.out.println("Nome do Palestrante: " + name);
        System.out.println("Palestras em que participou:");
        
        //uso do ciclo for-each para percorrer as palestras e imprimir o titúlo/tema
        for (Lecture lecture : lectures) {
            System.out.println("- " + lecture.getTitle());
        }
        System.out.println("Popularidade: " + (popularity == -1 ? "Desconhecida" : popularity));
    }
}
//fim da classe Lecturer 
