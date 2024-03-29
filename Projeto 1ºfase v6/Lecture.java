
/**
 * Esta classe gere a informação relacionada ás palestras e as suas funcionalidades.
 * 
 * @author (Rita e Diana) 
 * @version (v9)
 */
//código adicional para uso das listas de arrays e acesso ao LocalDateTime
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
//código para fazer uso dos métodos equals e hasCode
import java.util.Objects;
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
    
    
    //método para adicionar uma palestrante, fazendo uso do método add que a classe ArrayList já possui
    public void addLecturer(Lecturer lecturer) {
        
        //verificação das datas antes de adicionar palestra
        /*
         * if(isDateValid() == true){
         *     //se a data inserida for válida então a palestra é adicionada
         *     lecturers.add(lecturer)
         * }
         * //se a data inserida não for válida então é mostrada uma mensagem de erro
         * else {
         *     System.out.println("Insira uma data válida!")
         * }
         */
        
        lecturers.add(lecturer);
    }
    
    /* //Método para verificar que uma palestra não têm o mesmo palestrante duas vezes
     * public void assignLecturer(Lecture lecturer){
     *   
     *   //verificar se este palestrante está vazio ou se o palestrante é diferente ao palestrante inserido
     *   if(this.lecturer == null || !this.lecturer.equal.(lecturer)){ 
     *       
     *       //é adicionado o palestrante
     *       this.lecturer = lecturer;
     *       
     *   }
     *   
     *   //caso não seja verdadeiro, é mostrada uma mensagem a avisar que o palestrante
     *   já foi inserido na palestra
     *   else { 
     *       System.out.println("Este palestrante já está inserido nesta palestra!");     
     *   } 
     * }
     * 
     */ 
    
    /* //Novos métodos para veríficar conflitos nas palestras 
     * private boolean isDateValid(LocalDateTime startDate, LocalDateTime endDate, LocalDateTime editionStart, LocalDateTime editionEnd){
     *   
     *   //se as datas estiverem sobrepostas retorna verdade
     *   if(startDate >= editionStart && endDate <= editionEnd){
     *      return true 
     *   }
     *   
     *   //caso contrário retorna falso (as datas não estão sobrepostas)
     *   else {
     *      return false
     *   }
     * }
     * 
     * //através do uso dos métodos de hashCode criamos métodos de auxilio
     * @Override
     * private boolean equals(Object local){
     * 
     *      //verificar se numa sala existe mais de uma palestra no mesmo intervalo de tempo
     *      if(this == classroom) return true;
     *      
     *      //semelhante ao if comum
     *      //se a sala estiver vazia ou a sala for diferente da está "registrada"
     *      //então retorna falso
     *      if(classroom == null || getClassroom() != classroom.getClassroom()) return false;
     *      
     *      //Acho que não está completo aqui
     *      Lecture
     * }
     * 
     * 
     * //Método para garantir que o palestrante não é adicionado a duas palestras cujos horários
     * //se intersectem
     * //Nome "schedule" para representar os horários das palestras
     * 
     * 
     * //através do uso dos métodos de hashCode criamos métodos de auxilio outra vez
     * @Override
     * public boolean equals(Object schedule){
     *     
     *     //verificar se existem horários sobrepostos
     *     if(this == schedule) return true;
     *     
     *     //semelhante ao if comum
     *     //se não houver horário ou as palestras foram a horas diferentes retorna falso
     *     if(schedule == null || getLecture() != schedule.getLecture()) return false;
     *     Lecture that = (Lecture) schedule;
     *     return Objects.equals(hours, that.hours)
     * }
     * 
     * 
     * //através do uso dos métodos de hashCode criamos métodos de auxilio outra vez
     * @Override
     * public int hashCode(){
     *     //retorna as horas
     *     return Objects.hash(hours)
     * }
     * 
     * Depois dentro de um dos voids, adicionar este pedaço de código que faz a 
     * comparação dos dados
     * colocar como parâmetro do método a lista das palestras
     * 
     * if(lecture1.equals(lecture2)){
     *     
     * }
     * //é mostrada uma mensagem de erro
     * else{
     *     System.out.println("Não é possível adicionar o palestrante!");
     * }
     * 
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
    public boolean canBeenSimulated() {
        
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
