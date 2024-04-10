public class Apprenant {

    private int id;
    private string PromotionName;
    private string Name;
    private string LastName;
    private string Adress;
    private string Email;
    private string Tel;
    private int Absence;
    private boolean IsDelegue;

    #region constructors
    public Apprenant(int id, string promotionName, string name, string lastName, string adress, string email, string tel, int absence, boolean isDelegue) {
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
    #endregion

    #region Getters & Setters
    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public string getPromotionName() {
        return this.PromotionName;
    }
    public string setPromotionName(string promotionName) {
        this.PromotionName = promotionName;
    }

    public string getName() {
        return this.Name;
    }
    public string setName(string name) {
        this.Name = name;
    }
    public string getLastName() {
        return this.LastName;
    }
    public string setLastName(string lastName) {
        this.LastName = lastName;
    }
    public string getAdress() {
        return this.Adress;
    }
    public string setAdress(string adress) {
        this.Adress = adress;
    }
    public string getEmail() {
        return this.Email;
    }
    public string setEmail(string email) {
        this.Email = email;
    }
    public string getTel() {
        return this.Tel;
    }
    public string setTel(string tel) {
        this.Tel = tel;
    }
    public int getAbsence() {
        return this.Absence;
    }
    public int setAbsence(int absence) {
        this.Absence = absence;
    }
    public boolean getIsDelegue() {
        return this.IsDelegue;
    }
    public boolean setIsDelegue(boolean isDelegue) {
        this.IsDelegue = isDelegue;
    }
    
//#endregion
}
