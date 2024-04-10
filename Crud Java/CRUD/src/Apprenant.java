

public class Apprenant {

    private int Id;
    private String PromotionName;
    private String Name;
    private String LastName;
    private String Adress;
    private String Email;
    private String Tel;
    private int Absence;
    private boolean IsDelegue;

   
    public Apprenant(int id, String promotionName, String name, String lastName, String adress, String email, String tel, int absence, boolean isDelegue) {
        this.Id = id;
        this.PromotionName = promotionName;
        this.Name = name;
        this.LastName = lastName;
        this.Adress = adress;
        this.Email = email;
        this.Tel = tel;
        this.Absence = absence;
        this.IsDelegue = isDelegue;
    }
 
   
    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

  
    public String getPromotionName() {
        return this.PromotionName;
    }

    public void setPromotionName(String promotionName) {
        this.PromotionName = promotionName;
    }

    public String getName() {
        return this.Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getLastName() {
        return this.LastName;
    }
    public void setLastName(String lastName) {
        this.LastName = lastName;
    }
    public String getAdress() {
        return this.Adress;
    }
    public void setAdress(String adress) {
        this.Adress = adress;
    }
    public String getEmail() {
        return this.Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public String getTel() {
        return this.Tel;
    }
    public void setTel(String tel) {
        this.Tel = tel;
    }
    public int getAbsence() {
        return this.Absence;
    }
    public void setAbsence(int absence) {
        this.Absence = absence;
    }
    public boolean getIsDelegue() {
        return this.IsDelegue;
    }
    public void setIsDelegue(boolean isDelegue) {
        this.IsDelegue = isDelegue;
    }
    

}
