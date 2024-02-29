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
        this.rabais = 0.0;
    }

    public Composant copier() {
        return new Composant(this.categorie, this.marque, this.nom, this.prix - this.prix * this.rabais);
    }

    public boolean estIdentique(Composant autre) {
        return this.categorie.equals(autre.categorie) &&
                this.marque.equals(autre.marque) &&
                this.nom.equals(autre.nom);
    }

    public double getPrix() {
        return this.prix - this.prix * this.rabais;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public String getMarque() {
        return this.marque;
    }

    public String getNom() {
        return this.nom;
    }

    public double getRabais() {
        return this.rabais;
    }

    public void setPrix(double prix) {
        if (prix >= 0) {
            this.prix = prix;
        }
    }

    public void setRabais(double rabais) {
        if (rabais >= 0 && rabais <= 1) {
            this.rabais = rabais;
        }
    }

    @Override
    public String toString() {
        return "[" + this.categorie + "] " + this.marque + " " + this.nom;
    }
}
