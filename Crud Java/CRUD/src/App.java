import java.util.List;
import java.util.Scanner;



public class App {

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");
        DatabaseConnector.getConnection();
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- Gestion apprenants ---");
            System.out.println("1. Créé apprenant");
            System.out.println("2. Voir les apprenants");
            System.out.println("3. Supprimer un apprenant");
            System.out.println("4. Mettre à jour le nombre d'absences d'un apprenant");
        
            System.out.print("Select an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            switch (option) {
                case 1:
                    addNewApprenant();
                    break;
                 case 2:
                     viewAllApprenants();
                     break;
                case 3:
                    deleteApprenant();
                    break;
                case 4:
                    updateAbsence();
                    break;
            
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");}
        
    }}

    private static void viewAllApprenants() {
        System.out.println("\n--- Liste des apprenants ---");
        List<Apprenant> apprenants = ApprenantManagement.getAllApprenants();
        for (Apprenant apprenant : apprenants) {
            System.out.println(apprenant.getId());
            
        }
    }

        private static void deleteApprenant() {
            viewAllApprenants();
            System.out.println("\n--- Supprimer un apprenant ---");
            System.out.print("Entrez l'identifiant de l'apprenant à supprimer : ");
            int id = scanner.nextInt();
            
            scanner.nextLine(); // Consume the newline left-over
            
        
            // Appeler la méthode de gestion pour supprimer l'apprenant
            ApprenantManagement.deleteApprenant(id);
        }
        
    private static void addNewApprenant() {

        System.out.println("\n--- Ajouter un nouvel étudiant ---");
        System.out.print("Entrez l'identifiant de l'étudiant : ");

        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        System.out.print("Entrez le nom de promotion : ");
        String promotionName = scanner.nextLine();

        System.out.print("Entrez le prénom de l'étudiant : ");
        String name = scanner.nextLine();

        System.out.print("Entrez le nom de famille de l'étudiant : ");
        String lastName = scanner.nextLine();

        System.out.print("Entrez l'adresse de l'étudiant : ");
        String adress = scanner.nextLine();

        System.out.print("Entrez l'email de l'étudiant : ");
        String email = scanner.nextLine();

        System.out.print("Entrez le téléphone de l'étudiant : ");
        String tel = scanner.nextLine();

        System.out.print("Entrez le nombre d'absences de l'étudiant : ");
        int absence = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        System.out.print("Est-ce que l'étudiant est délégué ? (true/false) : ");
        boolean isDelegue = scanner.nextBoolean();

        // Créer un nouvel objet Apprenant avec les informations fournies
        Apprenant nouvelApprenant = new Apprenant(id, promotionName, name, lastName, adress, email, tel, absence, isDelegue);
        System.out.println(nouvelApprenant);

        // Ajouter l'étudiant à la base de données
        ApprenantManagement.addApprenant(nouvelApprenant);

        System.out.println("L'étudiant a été ajouté avec succès !");

    }
    private static void updateAbsence() {
        System.out.println("\n--- Mettre à jour le nombre d'absences d'un apprenant ---");
        viewAllApprenants();
        System.out.print("Entrez l'identifiant de l'apprenant : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
        
        System.out.print("Entrez le nouveau nombre d'absences : ");
        int newAbsence = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
    
        // Appeler la méthode de gestion pour mettre à jour le nombre d'absences
        ApprenantManagement.updateAbsence(id, newAbsence);
    }

    }