public class Composant {
    private final String categorie;
    private final String marque;
    private final String nom;
    private double prix;
    private double rabais;

    public Composant(String categorie, String marque, String nom, double prix) {
        this.categorie = categorie.toUpperCase();
        this.marque = marque;
        this.nom = nom;
        this.prix = prix;
        this.rabais = 0;
    }

    public Composant copier() {
        return new Composant(categorie, marque, nom, prix);
    }

    public boolean estIdentique(Composant autre) {
        return this.categorie.equals(autre.getCategorie()) &&
                this.marque.equals(autre.getMarque()) &&
                this.nom.equals(autre.getNom());
    }

    public double getPrix() {
        return prix * (1 - rabais);
    }

    public String getCategorie() {
        return categorie;
    }

    public String getMarque() {
        return marque;
    }

    public String getNom() {
        return nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getRabais() {
        return rabais;
    }

    public void setRabais(double rabais) {
        if (rabais >= 0 && rabais <= 1) {
            this.rabais = rabais;
        }
    }

    @Override
    public String toString() {
        return "[" + categorie + "] " + marque + " " + nom;
    }
}
