public class Configuration {
    private final String description;
    private final double prixMax;
    private final Composant[] composants;
    private int nbComposants;
    private static final int MAX_COMPOSANTS = 20;

    public Configuration(String description, double prixMax, Composant[] composants) {
        this.description = description.toUpperCase();
        this.prixMax = prixMax;
        this.nbComposants = composants.length;
        this.composants = new Composant[MAX_COMPOSANTS];
        for (int i = 0; i < nbComposants; i++) {
            this.composants[i] = composants[i].copier();
        }
    }

    public Configuration(Configuration originale) {
        this.description = originale.description;
        this.prixMax = originale.prixMax;
        this.nbComposants = originale.nbComposants;
        this.composants = new Composant[MAX_COMPOSANTS];
        for (int i = 0; i < nbComposants; i++) {
            this.composants[i] = originale.composants[i].copier();
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
        for (Composant composant : composants) {
            if (composant != null && composant.getCategorie().equalsIgnoreCase(categorie)) {
                return composant;
            }
        }
        return null;
    }

    public boolean ajouter(Composant composant) {
        if (nbComposants >= MAX_COMPOSANTS || calculerTotal(0) + composant.getPrix() > prixMax) {
            return false;
        }
        for (int i = 0; i < nbComposants; i++) {
            if (composants[i].getCategorie().equalsIgnoreCase(composant.getCategorie())) {
                return false;
            }
        }
        composants[nbComposants++] = composant.copier();
        return true;
    }

    public boolean retirer(Composant composant) {
        for (int i = 0; i < nbComposants; i++) {
            if (composants[i].estIdentique(composant)) {
                for (int j = i; j < nbComposants - 1; j++) {
                    composants[j] = composants[j + 1];
                }
                composants[--nbComposants] = null;
                return true;
            }
        }
        return false;
    }

    public boolean remplacer(Composant composant) {
        for (int i = 0; i < nbComposants; i++) {
            if (composants[i].getCategorie().equalsIgnoreCase(composant.getCategorie())) {
                composants[i] = composant.copier();
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String result = description + " (max " + prixMax + ",00$) :\n";
        int index = 1;

        for (Composant composant : composants) {
            if (composant != null) {
                result += index + " : " + composant.toString() + "\n";
                index++;
            }
        }

        return result;
    }

    public int getNbComposants() {
        return nbComposants;
    }

    public Composant[] getComposants() {
        return composants;
    }
}
