
/**
 * Esta classe gere a informação relacionada ás palestras e as suas funcionalidades.
 * 
 * @author (Rita e Diana) 
 * @version (v5)
 */
//código adicional para uso das listas de arrays e acesso ao LocalDateTime
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
//criação da classe Lecture para gerir as palestras
public class Lecture
{
    
    //atributos referidos no enunciado do projeto
    private String title;
    private List<Lecturer> lecturers;
    private LocalDateTime startTime;
    private String startDate;
    private LocalDateTime endTime;
    private String endDate;
    private String classroom;
    private int totalRegistrations;

    //construtor da classe Lecture com parâmetros
    //os parâmetros são o titúlo, a data e hora de inicio e fim, a sala e o número de inscrições
    public Lecture(String title, LocalDateTime startTime, String initialDate, String endDate, String classroom, int totalRegistrations)
    {
        
        // inicialização dos atributos
        this.title = title;
        this.lecturers = new ArrayList<>();
        this.startTime = startTime;
        this.startDate = startDate;
        this.endTime = endTime;
        this.endDate = endDate;
        this.classroom = classroom;
        
        //o valor inicial do total de inscrições é -1
        this.totalRegistrations = -1;
    }
    
    public LocalDateTime getStartTime(){
        return startTime;
    }
    public LocalDateTime getEndTime(){
        return endTime;
    }
    
    //método para adicionar uma palestrante, fazendo uso do método add que a classe ArrayList já possui
    public void addLecturer(Lecturer lecturer) {
        
        //verificar datas antes de adicionar palestra
        /*
         * if(isDateValid() == true && ){
         *     lecturers.add(lecturer)
         * }
         * else {
         *     System.out.println("Insira uma data válida!")
         * }
         */
        lecturers.add(lecturer);
    }
    
    /*
     * Novos métodos para veríficar conflitos nas palestras
     * 
     * private boolean isDateValid(LocalDateTime startDate, LocalDateTime endDate, LocalDateTime editionStart, LocalDateTime editionEnd){
     *   
     *   if(startDate >= editionStart && endDate <= editionEnd){
     *      return true 
     *   }
     *   else {
     *       return false
     *   }
     *   
     * }
     */
    
    //método boolean para verificar se um palestrante está inscrito, com parâmetro
    //o parâmetro é o palestrante
    private boolean isLecturerRegistered(String lecturer){
        
        //se a lista de arrays contêm o palestrante, retorna verdade
        if(lecturers.contains(lecturer)){
            return true;
        }
        //caso contrário, retorna falso
        else{
            return false;
        }
    }
    
    
    //método para mostrar os detalhes de uma palestra, usando a instrução println
    public void listDetails() {
        System.out.println("Title: " + getTitle());
        System.out.println("Lecturer: " + lecturers);
        System.out.println("Start Date: " + startDate);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Date: " + endDate);
        System.out.println("End Time: " + endTime);
        System.out.println("Classroom: " + classroom );
        System.out.println("Total Registrations: " + totalRegistrations);
    }
    
    //método boolean para verificar se a palestra já foi simulada
    public boolean hasBeenSimulated() {
        
        //se o número de inscrições é diferente de -1, retorna verdade
        if(totalRegistrations != -1){
            return true;
        }
        //caso contrário, retorna falso
        else{
            return false;
        }
    }
    
    //método boolen para verificar se uma palestra afere as condições necessárias para ser simulada
    public boolean canBeSimulated() {
        
        //se tiver sala e palestrantes, então o método retorna verdade
        if(classroom != null && !lecturers.isEmpty()){
            return true;
        }
        //caso contrário retorna falso
        else{
            return false;
        }
    }
    
    //método para simular inscrições de participantes no evento
    //têm como parâmetro a popularidade do evento
    public void simulateRegistrations(int eventPopularity){
        
        //condição if, para garantir que a palestra têm palestrantes e sala
        if (!lecturers.isEmpty() && classroom != null) {
            
            //cálculo da popularidade máxima do palestrante
            int maxSpeakerPopularity = calculateMaxLecturerPopularity();
            
            //cálculo da participação base para a palestra
            int baseParticipation = calculateBaseParticipation(eventPopularity);
            
            //cálculo da participação final da palestra
            int finalParticipation = Math.min(baseParticipation, classroomCapacity());

            //o numero total de inscrições é igualado ao número da participação final
            totalRegistrations = finalParticipation;
            
            //imprime a informação (título e número de inscrições)
            System.out.println("Registrations simulated for the lecture '" + title + "': " + totalRegistrations);
        } 
        //imprime uma mensagem a avisar que a palestra não pode ser simulada pois não confere as condições para tal
        else {
            System.out.println("The lecture cannot be simulated. Check if it has been simulated, if it has lecturers, and a room assigned.");
        }
    }      
    
    //método para calcular a popularidade máxima do palestrante
    private int calculateMaxLecturerPopularity() {
        
        //variável para a popularidade máxima do palestrante
        int maxPopularity = 0;

        //ciclo for-each para percorrer a popularidade do palestrante e achar o valor mais alto
        for (Lecturer lecturer : lecturers) {
            int lecturerPopularity = getLecturerPopularity(lecturer);
            maxPopularity = Math.max(maxPopularity, lecturerPopularity);
        }

        //retorna o valor da popularidade máxima do palestrante
        return maxPopularity;
    }
    
    //método auxiliar int para calcular e retorna o valor da participação base
    //têm como parâmetro a popularidade do evento
    private int calculateBaseParticipation(int eventPopularity) {
        
        //retorna o valor int da popularidade do evento multiplicado por 0.02
        return (int) (eventPopularity * 0.02);
    }

    //método auxiliar int para retornar a capacidade da sala
     private int classroomCapacity() {
        return getClassroomCapacity(classroom);
    }
    
    //método auxiliar int para retornar a popularidade do palestrante
    private int getLecturerPopularity(Lecturer lecturer) {
        
        //retorna o valor 2
        return 2; 
    }
    
    //método auxiliar get int para retornar a capacidade da sala
    //têm como parâmetro a sala em formato String
    private int getClassroomCapacity(String clasroom) {
        
        //retorna o valor 100
        return 100; 
    }
    
    //método auxiliar para retornar o título
    public String getTitle(){
        return title;
    }
}
//fim da classe Lecture
