/**
 * Esta classe gere a informação relacionada à gestão de eventos e as suas funcionalidades.
 * 
 * @author (Rita e Diana) 
 * @version (v5)
 */
//código adicional para uso das listas de arrays
import java.util.ArrayList;
import java.util.List;
//criação da classe Manager para operações de gestão de eventos
public class Manager
{
    //atributos listados no enunciado do projeto
    private List<Lecturer>lecturers;
    private List<Events> events;
    private List<String> locations;

    //construtor da classe Manager
    public Manager()
    {
        //inicialização dos atributos
        this.lecturers = new ArrayList<>();
        this.events = new ArrayList<>();
        this.locations = new ArrayList<>();
    }
    
    //método para criar um novo palestrante
    //têm como parâmetro o nome de tipo String
    public void createLecturer(String name) {
        Lecturer lecturer = new Lecturer(name);
        
        //uso do método add da classe ArrayList
        lecturers.add(lecturer);
    }
    
    //método auxiliar que retorna a lista dos palestrantes
    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    //método para criar um evento, com parâmetro nome do tipo String
    public void createEvent(String name) {
        Events event = new Events(name);
        
        //uso do método add da class ArrayList
        events.add(event);
    }

    //método auxiliar que retorna a lista dos eventos
    public List<Events> getEvents() {
        return events;
    }
    
    //método que cria uma localização, com parâmetro locationName do tipo String
    public void createLocation(String locationName) {
        
        //uso do método add da class ArrayList
        locations.add(locationName);
    }

    //método auxiliar que retorna a lista de locais
    public List<String> getLocations() {
        return locations;
    }
    
    //método para criar uma edição
    //tem como parâmetros o número, a data de inicio e fim e a localização
    public void createEdition(int numberOfEdition, String initialDate, String endDate, String location) {
        EventEdition edition = new EventEdition(numberOfEdition, initialDate, endDate, location);
        edition.addEdition(edition);
    }
    
    //método auxiliar que retorna a lista das edições
    public List<EventEdition> getEditions() {
        List<EventEdition> editions = new ArrayList<>();
        
        //ciclo for-each que percorre os eventos e adiciona à lista
        for (Events event : events) {
            if (events instanceof EventEdition) {
                editions.add((EventEdition) events);
            }
        }
        
        //retorna a lista de edições
        return editions;
    }
    
    //método que simula uma palestra
    //têm como parâmetros palestrante e a edição
    public void simulateLecture(Lecturer lecturer, EventEdition edition) {
        
    }
    
    //método que simula eventos de uma edição
    //têm como parâmetros edição e popularidade do evento
     public void simularEdicaoEvento(EventEdition edition, int eventPopularity) {
        
    }
}
