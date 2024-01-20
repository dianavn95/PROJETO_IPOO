/**
 * Esta classe irá gerir a interação do utilizador com o Gestor e as suas funcionalidades.
 * 
 * @author (Rita e Diana) 
 * @version (v5)
 */
//código adicional para uso das listas, scanner e Input
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
//criação da classe Console
public class Console
{
    //atríbutos listados no enunciado
    private Manager manager;
    private Scanner scanner;
    
    //construtor da classe Console
    public Console()
    {
        //inicialização dos atríbutos
        this.manager = manager;
        this.scanner = new Scanner(System.in);
        
    }
    
    //construtor da classe Console com o parâmetro manager
    public Console(Manager manager)
    {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
        
    }
    
    //método run
    public void run() {
        
        //variável para representar a escolha do utilizador
        int choice;
        
        //ciclo do-while, que irá efetuar as instruções abaixo e de seguida conferir as condições
        do {
            
            //mostra o menu e as opções
            displayMainMenu();
            choice = getUserChoice(1, 3);

            //uso do switch com 3 casos e o default onde mostra uma mensagem
            switch (choice) {
                
                //primeiro caso gere a informação
                case 1:
                    manageInformation();
                    break;
                    
                //segundo caso lista a informação
                case 2:
                    listAllData();
                    break;
                    
                //terceiro caso mostra a mensagem de encerramento da aplicaçãp
                case 3:
                    System.out.println("A encerrar a aplicação.");
                    break;
                    
                ////mostra uma mensagem que pede ao utilizador para inserir valores válidos
                default:
                    System.out.println("Insira uma opção válida.");
            }
        } 
        
        //condição while, enquanto a escolha do utilizador for diferente de 3
        while (choice != 3);
    }

    //método para mostrar o menu principal
    private void displayMainMenu() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Gerir Informações");
        System.out.println("2. Listagem de todos os dados");
        System.out.println("3. Sair");
        System.out.print("Enter your choice: ");
    }

    //método para gerir a informação
    private void manageInformation() {
        
        //variável para representar a escolha do utilizador
        int choice;
        
        //ciclo do-while que efetua as instruções e seguidamente verifica as suas condiçções
        do {
            
            //mostar o menu e as opções
            displayManageMenu();
            choice = getUserChoice(1, 4);

            //uso do switch com 4 casos e um default que mostra uma mensagem
            switch (choice) {
                
                //primeiro caso cria um palestrante
                case 1:
                    createLecturer();
                    break;
                    
                //segundo caso cria um evento
                case 2:
                    createEvent();
                    break;
                    
                //terceiro caso cria uma localização
                case 3:
                    createLocation();
                    break;
                    
                //quarto caso retorna
                case 4:
                    return;
                    
                //mostra uma mensagem que pede ao utilizador para inserir valores válidos
                default:
                    System.out.println("Insira uma opção válida.");
            }
        } 
        
        //condição while, enquanto a escolha do utilizador for diferente de 4
        while (choice != 4);
    }

    //método para mostrar o menu de opções
    private void displayManageMenu() {
        System.out.println("\n Menu de Gestão de Informações:");
        System.out.println("1. Criar Palestrante");
        System.out.println("2. Criar evento");
        System.out.println("3. Criar localização");
        System.out.println("4. Voltar ao Menu Principal");
        System.out.print("Enter your choice: ");
    }

    //método para criar um palestrante
    private void createLecturer() {
        System.out.print("Insira o nome do palestrante: ");
        String name = scanner.nextLine();
        manager.createLecturer(name);
        System.out.println("Palestrante criado com sucesso.");
    }

    //método para criar um evento
    private void createEvent() {
        System.out.print("Insira o nome do evento: ");
        String name = scanner.nextLine();
        manager.createEvent(name);
        System.out.println("Evento criado com sucesso.");
    }

    //método para criar uma localização
    private void createLocation() {
        System.out.print("Insira o nome da localização: ");
        String name = scanner.nextLine();
        manager.createLocation(name);
        System.out.println("Localização criada com sucesso.");
    }

    //método para listar toda a informação 
    private void listAllData() {
        
        //faz-se uso do println e do manager para mostrar todas as listas (3 no total)
        System.out.println("\nListagem de todos os dados:");
        System.out.println("Palestrantes:");
        listEntities(manager.getLecturers());

        System.out.println("\nEventos:");
        listEntities(manager.getEvents());

        System.out.println("\nLocalizações:");
        listEntities(manager.getLocations());
    }

    //método auxiliar com parâmetro entities
    private <T> void listEntities(List<T> entities) {
        
        //ciclo for-each, percorre as entidades todas e imprime a sua lista
        for (T entity : entities) {
            System.out.println(entity);
        }
    }

    //método int com parâmetros min e max
    private int getUserChoice(int min, int max) {
        
        //variáveis de auxilio, escolha e validInput
        int choice = 0;
        boolean validInput = false;

        //ciclo while que efetua instruções enquanto a condição se mostrar verdade
        //condição pede que equanto não existir um input válido vai enviar uma mensagem
        while (!validInput) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 
                
                //condição if, em caso de a escolha seja maior ou igual a min e menor ou igual a max
                if (choice >= min && choice <= max) {
                    
                    //retorna verdade
                    validInput = true;
                } 
                
                //caso contrário envia uma mensagem a pedir para colocar um valor válido
                else {
                    System.out.print("Por favor insira um número entre" + min + " e " + max + ": ");
                }
            } 
            
            catch (InputMismatchException e) {
                System.out.print("Por favor insira um número válido.");
                scanner.nextLine(); 
            }
        }

        //retorna a escolha
        return choice;
    }

    //método estático com parâmetro do tipo array
    public static void main(String[] args) {
        Manager manager = new Manager();
        Console console = new Console(manager);
        console.run();
    }

    
}
//fim da classe Console