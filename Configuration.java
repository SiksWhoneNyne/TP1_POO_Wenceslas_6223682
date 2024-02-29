public class Configuration {
    private final String description;
    private double prixMax;
    private Composant[] composants;
    private int nbComposants;
    public static final int MAX_COMPOSANTS = 20;

    public Configuration(String description, double prixMax, Composant[] composants) {
        this.description = description.toUpperCase();
        this.prixMax = prixMax;
        this.composants = new Composant[MAX_COMPOSANTS];
        this.nbComposants = 0;

        for (int i = 0; i < composants.length; i++) {
            if (composants[i] != null) {
                this.ajouter(composants[i]);
            }
        }
    }

    public Configuration(Configuration originale) {
        this.description = originale.getDescription();
        this.prixMax = originale.getPrixMax();
        this.composants = new Composant[MAX_COMPOSANTS];
        this.nbComposants = 0;

        for (int i = 0; i < originale.getNbComposants(); i++) {
            if (originale.getComposants()[i] != null) {
                Composant copie = new Composant(
                        originale.getComposants()[i].getCategorie(),
                        originale.getComposants()[i].getMarque(),
                        originale.getComposants()[i].getNom(),
                        originale.getComposants()[i].getPrix()
                );
                copie.setRabais(originale.getComposants()[i].getRabais());
                this.composants[i] = copie;
                this.nbComposants++;
            }
        }
    }

    public double calculerTotal(double taxe) {
        double total = 0;
        for (int i = 0; i < nbComposants; i++) {
            total += composants[i].getPrix();
        }
        return total * (1 + taxe);
    }

    public Composant rechercher(String categorie) {
        for (int i = 0; i < nbComposants; i++) {
            if (composants[i].getCategorie().equalsIgnoreCase(categorie)) {
                return composants[i];
            }
        }
        return null;
    }

    public boolean ajouter(Composant nouveauComposant) {
        if (nbComposants >= MAX_COMPOSANTS) {
            return false;
        }
        if (calculerTotal(0) + nouveauComposant.getPrix() > prixMax) {
            return false;
        }
        if (rechercher(nouveauComposant.getCategorie()) != null) {
            return false;
        }
        composants[nbComposants] = nouveauComposant.copier();
        nbComposants++;
        return true;
    }

    public boolean retirer(Composant composantASupprimer) {
        for (int i = 0; i < nbComposants; i++) {
            if (composants[i].estIdentique(composantASupprimer)) {
                for (int j = i; j < nbComposants - 1; j++) {
                    composants[j] = composants[j + 1];
                }
                composants[nbComposants - 1] = null;
                nbComposants--;
                return true;
            }
        }
        return false;
    }

    public boolean remplacer(Composant composantRemplacement) {
        for (int i = 0; i < nbComposants; i++) {
            if (composants[i].getCategorie().equalsIgnoreCase(composantRemplacement.getCategorie())) {
                composants[i] = composantRemplacement.copier();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String resultat = description + " (max " + prixMax + "$):\n";
        for (int i = 0; i < nbComposants; i++) {
            resultat += " " + (i + 1) + " : " + composants[i] + " (" + composants[i].getPrix() + "$)\n";
        }
        return resultat;
    }

    public String getDescription() {
        return description;
    }

    public double getPrixMax() {
        return prixMax;
    }

    public Composant[] getComposants() {
        return composants;
    }

    public int getNbComposants() {
        return nbComposants;
    }

    public void setPrixMax(double prixMax) {
        this.prixMax = prixMax;
    }
}
