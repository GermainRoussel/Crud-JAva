import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ApprenantManagement {
    
    public static List<Apprenant> getAllApprenants() {
        List<Apprenant> apprenants = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM apprenants";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String promotionName = resultSet.getString("PromotionName");
                String name = resultSet.getString("Name");
                String lastName = resultSet.getString("LastName");
                String adress = resultSet.getString("Adress");
                String email = resultSet.getString("Email");
                String tel = resultSet.getString("Tel");
                int absence = resultSet.getInt("Absence");
                boolean isDelegue = resultSet.getBoolean("IsDelegue");
                
                Apprenant apprenant = new Apprenant(id, promotionName, name, lastName, adress, email, tel, absence, isDelegue);

                System.out.println("ID apprenant :" + apprenant.getId());
                System.out.println("Nom apprenant :" + apprenant.getName());
                System.out.println("Prénom apprenant :" + apprenant.getLastName());
                System.out.println("Absence apprenant :" + apprenant.getAbsence());
                System.out.println("Délégué apprenant :" + apprenant.getIsDelegue());
                System.out.println("");
                
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des apprenants !");
            e.printStackTrace();
        }
        return apprenants;
    }

    public static Apprenant getApprenantById(int id) {
        Apprenant apprenant = null;
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM apprenants WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String promotionName = resultSet.getString("PromotionName");
                String name = resultSet.getString("Name");
                String lastName = resultSet.getString("LastName");
                String adress = resultSet.getString("Adress");
                String email = resultSet.getString("Email");
                String tel = resultSet.getString("Tel");
                int absence = resultSet.getInt("Absence");
                boolean isDelegue = resultSet.getBoolean("IsDelegue");

                apprenant = new Apprenant(id, promotionName, name, lastName, adress, email, tel, absence, isDelegue);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de l'apprenant !");
            e.printStackTrace();
        }
        return apprenant;
    }
    public static List<Apprenant> getApprenantsByPromotion(String promotionName) {
        List<Apprenant> apprenants = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM apprenants WHERE PromotionName = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, promotionName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String lastName = resultSet.getString("LastName");
                String adress = resultSet.getString("Adress");
                String email = resultSet.getString("Email");
                String tel = resultSet.getString("Tel");
                int absence = resultSet.getInt("Absence");
                boolean isDelegue = resultSet.getBoolean("IsDelegue");
    
                Apprenant apprenant = new Apprenant(id, promotionName, name, lastName, adress, email, tel, absence, isDelegue);
                apprenants.add(apprenant);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche des apprenants par nom de promotion !");
            e.printStackTrace();
        }
        return apprenants;
    }
    

    public static void updateAbsence(int id, int newAbsence) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "UPDATE apprenants SET Absence = ? WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, newAbsence);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Nombre d'absences mis à jour avec succès !");
                System.out.println("Nouveau nombre d'absences : " + newAbsence);
            } else {
                System.out.println("Aucun apprenant trouvé avec cet identifiant.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du nombre d'absences !");
            e.printStackTrace();
        }
    }
    public static void deleteApprenant(int id) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "DELETE FROM apprenants WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Apprenant supprimé avec succès !");
            } else {
                System.out.println("Aucun apprenant trouvé avec cet identifiant.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'apprenant !");
            e.printStackTrace();
        }
    }

public static void addApprenant(Apprenant apprenant) {
    try (Connection connection = DatabaseConnector.getConnection()) {
        String sql = "INSERT INTO apprenants (Id, PromotionName, Name, LastName, Adress, Email, Tel, Absence, IsDelegue) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, apprenant.getId());
        statement.setString(2, apprenant.getPromotionName());
        statement.setString(3, apprenant.getName());
        statement.setString(4, apprenant.getLastName());
        statement.setString(5, apprenant.getAdress());
        statement.setString(6, apprenant.getEmail());
        statement.setString(7, apprenant.getTel());
        statement.setInt(8, apprenant.getAbsence());
        statement.setBoolean(9, apprenant.getIsDelegue());
        System.out.println(sql);
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Apprenant ajouté avec succès !");
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'ajout de l'apprenant !");
        e.printStackTrace();
    }
}

}
