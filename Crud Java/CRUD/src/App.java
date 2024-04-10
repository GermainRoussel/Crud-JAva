import java.util.Collections;
import java.util.Comparator;
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
            System.out.println("5. Rechercher un apprenant par promotion");
        
            System.out.print("Select an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); 

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
                case 5:
                    searchApprenantByPromotion();
                    break;
            
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");}
        
    }}


    private static void searchApprenantByPromotion() {
        System.out.println("\n--- Recherche des apprenants par nom de promotion ---");
        System.out.print("Entrez le nom de la promotion : ");
        String promotionName = scanner.nextLine();
    
        List<Apprenant> apprenants = ApprenantManagement.getApprenantsByPromotion(promotionName);
        if (apprenants.isEmpty()) {
            System.out.println("Aucun apprenant trouvé pour la promotion '" + promotionName + "'.");
        } else {
            System.out.println("Voici les Apprenants pour la promotion '" + promotionName + "' :");
            for (Apprenant apprenant : apprenants) {
                System.out.println("ID: " + apprenant.getId() + ", Nom: " + apprenant.getName() + ", Promotion: " + apprenant.getPromotionName());
            }
        }
    }

    
    private static void viewAllApprenants() {
        System.out.println("\n--- Liste des apprenants ---");
        List<Apprenant> apprenants = ApprenantManagement.getAllApprenants();
        
        // Trier les apprenants par nom
        Collections.sort(apprenants, new Comparator<Apprenant>() {
            @Override
            public int compare(Apprenant apprenant1, Apprenant apprenant2) {
                return apprenant1.getName().compareToIgnoreCase(apprenant2.getName());
            }
        });
        
        
        for (Apprenant apprenant : apprenants) {
            System.out.println(apprenant.getId());
        }
        
        System.out.println("\n1. Tirer par nom");
        System.out.println("2. Trier par absence");
        System.out.println("3. Menu Principal");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {
            case 1:
                viewAllApprenantsSortedByName(); 
                break;
            case 2:
                viewAllApprenantsSortedByAbsence();
                break;
            case 3: 
            return;
            default:
                System.out.println("Option invalide. Veuillez réessayer.");
        }
    }

    private static void viewAllApprenantsSortedByName() {
        System.out.println("\n--- Liste des apprenants triée par nom ---");
        List<Apprenant> apprenants = ApprenantManagement.getAllApprenants();
        Collections.sort(apprenants, new Comparator<Apprenant>() {
            @Override
            public int compare(Apprenant apprenant1, Apprenant apprenant2) {
                return apprenant1.getName().compareToIgnoreCase(apprenant2.getName());
            }
        });
        for (Apprenant apprenant : apprenants) {
            System.out.println(apprenant.getId());
        }

     
        System.out.println("\n1. Retourner au menu principal");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();
        if (option == 1) {
            return; 
        } else {
            System.out.println("Option invalide. Retour au menu principal.");
        }
    }

    private static void viewAllApprenantsSortedByAbsence() {
       
        List<Apprenant> apprenants = ApprenantManagement.getAllApprenants();
        Collections.sort(apprenants, new Comparator<Apprenant>() {
           
            public int compare(Apprenant apprenant1, Apprenant apprenant2) {
                return Integer.compare(apprenant2.getAbsence(), apprenant1.getAbsence()); 
            }
        });
        for (Apprenant apprenant : apprenants) {
            System.out.println("ID: " + apprenant.getId() + ", Absence: " + apprenant.getAbsence());
        }
        
        
        System.out.println("\n1. Retourner au menu principal");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();
        if (option == 1) {
            System.out.println("Option invalide. Retour au menu principal.");
            return; 
          
        }
    }

    // Les autres méthodes de votre classe App


        private static void deleteApprenant() {
            viewAllApprenants();
            System.out.println("\n--- Supprimer un apprenant ---");
            System.out.print("Entrez l'identifiant de l'apprenant à supprimer : ");
            int id = scanner.nextInt();
            
            scanner.nextLine(); // Consume the newline left-over
           
            Apprenant apprenantToDelete = ApprenantManagement.getApprenantById(id);

            if (apprenantToDelete == null) {
                System.out.println("Aucun apprenant trouvé avec cet identifiant.");
                return;
            }
        
            // Vérifier si IsDelegue est à 1
            if (apprenantToDelete.getIsDelegue()) {
                System.out.println("Vous ne pouvez pas supprimer un apprenant délégué !");
                return;
            }
        
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

        if (isDuplicateApprenant(name)) {
            System.out.println("Un apprenant avec le même nom existe déjà !");
            return;}

        // Créer un nouvel objet Apprenant avec les informations fournies
        Apprenant nouvelApprenant = new Apprenant(id, promotionName, name, lastName, adress, email, tel, absence, isDelegue);
        System.out.println(nouvelApprenant);

        // Ajouter l'étudiant à la base de données
        ApprenantManagement.addApprenant(nouvelApprenant);

        System.out.println("L'étudiant a été ajouté avec succès !");

    }

    private static boolean isDuplicateApprenant(String name) {
        // Récupérer tous les apprenants existants
        List<Apprenant> apprenants = ApprenantManagement.getAllApprenants();
        // Parcourir la liste des apprenants existants
        for (Apprenant apprenant : apprenants) {
           
            if (apprenant.getName().equalsIgnoreCase(name)) {
                System.out.println("Un apprenant avec le même nom existe déjà !");
                return true; 
                
            }
        }
        return false;
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