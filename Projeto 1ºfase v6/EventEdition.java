
/**
 * Esta classe gere a informação relacionada ás edições dos eventos e as suas funcionalidades.
 * 
 * @author (Rita e Diana) 
 * @version (v5)
 */
//código adicional para se conseguir fazer uso das listas de arrays
import java.util.ArrayList;
import java.util.List;
//criação da classe EventEdition para gerir a edição de eventos
public class EventEdition
{
    //atribútos da classe presentes no enunciado do projeto
    private int numberOfEdition;
    private String initialDate;
    private String endDate;
    private String location;
    private List<Lecture> lectures;
    private int totalRegistrations;
    private List<EventEdition>editions;

    //construtor da classe EventEdition com parâmetros
    //os parâmetros são o número de edição, a data de inicio e fim, e o local
    public EventEdition(int numberOfEdition, String initialDate, String endDate, String location)
    {
        
        //inicialização dos atríbutos
        this.numberOfEdition =numberOfEdition;
        this.initialDate = initialDate;
        this.endDate = endDate;
        this.location = location;
        this.lectures = new ArrayList<>();
        
        //o valor total das inscrições de participantes é inicialmente -1
        this.totalRegistrations = -1;
        
    }
    public void addEdition(EventEdition edition){
        editions.add(edition);
    }
    
    //método registerLecture com um parâmetro do tipo Lecture
    //neste método conseguimos registrar novas palestras
    public void registerLecture(Lecture lecture) {
        
        //fazemos uso do método add que a classe ArrayList já possui
        lectures.add(lecture);
    }
    
    //método getIntersectedLectures, com parâmetro Lecture para com base numa palestra, sabermos que existe alguma outra,
    //cujo o tempo se intersete
    public List<Lecture> getIntersectedLectures(Lecture lecture) {
        //variável do tipo lista de arrays
        List<Lecture> intersectedLectures = new ArrayList<>();

        //ciclo for-each para podermos percorrer todas as palestras
        for (Lecture l : lectures) {
            if (intervalTimeIntersects(l, lecture)) {
                //intersectedLectures.get(l);
            }
        }

        //retorno da lista
        return intersectedLectures;
    }
    
    //método do tipo boolean com parâmetros
    //este método serve de auxilio ao método anterior
    private boolean intervalTimeIntersects(Lecture lecture1, Lecture lecture2) {
        
        //retorna os valores do tempo de inicio e fim das palestras
        return (lecture1.getStartTime().isBefore(lecture2.getEndTime())|| lecture1.getStartTime().equals(lecture2.getEndTime())) &&
               (lecture1.getEndTime().isAfter(lecture2.getStartTime()))|| lecture1.getEndTime().equals(lecture2.getStartTime());
    }
    
    //método do tipo boolean para se saber se a edição já foi simulada
    public boolean hasBeenSimulated() {
        
        //condição if, caso o número de incritos seja diferente de -1 (valor inicial)
        if(totalRegistrations != -1){
            
            //retorna verdade
            return true;
        }
        else{
            
            //retorna falso
            return false;
        }
    }
    
    //método printInformation, que serve para imprimir toda a informação sobre a edição do evento
    public void printInformation() {
        System.out.println("Edition: " + numberOfEdition);
        System.out.println("Data de Início: " + initialDate);
        System.out.println("Data de Fim: " + endDate);
        System.out.println("Local: " + location);
        System.out.println("Lista de Palestras: " + lectures);
        System.out.println("Inscrições: " + totalRegistrations);
    }
    
    //método simulateRegistrations para conseguirmos simular inscrições de participantes nas edições
    public void simulateRegistrations() {
        
        /*ordem que está na lista das palestras
            int participantes1 = lectures.get(0);
            int participantes2 = lectures.get(1);
            int participantes3 = lectures.get(2);
            int participantes4 = lectures.get(3);
            int participantes5 = lectures.get(4);
            int participantes6 = lectures.get(5);
            int participantes7 = lectures.get(6);
            int participantes8 = lectures.get(7);
            int participantes9 = lectures.get(8);
            int participantes10 = lectures.get(9);
            
            
            ou então podemos fazer um ciclo?
        */
        /*1ºpalestra - 100%
            if(participantes1 diferente de -1){
            participantes1 * 1 = participantes1;
            }
        */
        /*2ºpalestra - 90%
            if(participantes2 diferente de -1){
            participantes2 * 0.9 = participantes2;
            }
        */
        /*3ºpalestra - 80%
            if(participantes3 diferente de -1){
            participantes3 * 0.8 = participantes3;
            }
        */
        /*4ºpalestra - 70%
            if(participantes4 diferente de -1){
            participantes4 * 0.7 = participantes4;
            }
        */
        /*5ºpalestra - 60%
            if(participantes5 diferente de -1){
            participantes5 * 0.6 = participantes5;
            }
        */
        /*6ºpalestra - 50%
            if(participantes6 diferente de -1){
            participantes6 * 0.5 = participantes6;
            }
        */
        /*7ºpalestra - 40%
            if(participantes7 diferente de -1){
            participantes7 * 0.4 = participantes7;
            }
        */
        /*8ºpalestra - 30%
            if(participantes7 diferente de -1){
            participantes7 * 0.3 = participantes7;
            }
        */
        /*9ºpalestra - 20%
            if(participantes9 diferente de -1){
            participantes9 * 0.2 = participantes9;
            }
        */
        /*10ºpalestra - 10%
            if(participantes10 diferente de -1){
            participantes10 * 0.1 = participantes10;
            }
        */
       
       //ou então acho que podemos fazer assim
       //não sei se é para verificar por palestra ou no total de palestras
       
       /*
            if(participantesTotal diferente de -1){
            participantes1 * 1 = participantes1;
            .
            .
            .
            participantes10 * 0.1 = participantes10;
            }
        */
       
       /*Somar tudo no fim
            int totalParticipants = participantes1 + participantes2 + participantes3 + participantes4 + participantes5 + participantes6 + participantes7 + participantes8 + participantes9 + participantes10;
        */
    }
     
    }

    

//fim da classe EventEdition
