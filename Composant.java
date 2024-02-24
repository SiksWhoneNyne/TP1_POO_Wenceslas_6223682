public class Composant {
    private final String categorie;
    private String marque;
    private String nom;
    private double prix;
    private double rabais;

    public Composant(String categorie, String marque, String nom, double prix){
        this.categorie = categorie.toUpperCase();
        this.marque = marque;
        this.nom = nom;
        this.prix = prix > 0 ? prix : 0;
        this.rabais = 0;
    }

    public Composant Copier(){
        //Faire methode de copie standard de l'objet
        Composant copie = new Composant(this.categorie, this.marque, this.nom, this.prix);
        copie.rabais = this.rabais;
        return copie;
    }

    public boolean estIdentique(){
        //Faire methode pour vérifier si deux composants sont égaux sur la base de la catégorie, de la
        //marque et du nom
    }

    public double getPrix(){
        //Faire accesseur qui devrai retourner le prix AVEC le rabais
    }

    public String toString(){
        //Faire methode pour convertir un composant en String, comme ceci:
        // [categorie] marque,nom
    }

}
