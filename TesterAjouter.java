import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TesterAjouter {

    private Configuration config;
    private Composant composant1, composant2, composant3;

    @BeforeEach
    void setUp() {
        config = new Configuration("Test Config", 1000.0, new Composant[]{});
        composant1 = new Composant("CPU", "Intel", "i5", 200.0);
        composant2 = new Composant("CPU", "AMD", "Ryzen 5", 250.0);
        composant3 = new Composant("RAM", "Corsair", "Vengeance", 100.0);
    }

    @Test
    void testAjouterComposantFonctionne() {
        assertTrue(config.ajouter(composant1), "Le composant devrait être ajouté avec succès");
    }

    @Test
    void testAjouterComposantEchoueCategorieExistante() {
        config.ajouter(composant1);
        assertFalse(config.ajouter(composant2), "Le composant ne devrait pas être ajouté car la catégorie existe déjà");
    }

    @Test
    void testAjouterComposantEchouePrixMaximal() {
        Composant composantCher = new Composant("GPU", "Nvidia", "RTX 3090", 1500.0);
        assertFalse(config.ajouter(composantCher), "Le composant ne devrait pas être ajouté car il dépasse le prix maximal permis");
    }

    @Test
    void testAjouterComposantEchoueMaxComposants() {
        for (int i = 0; i < Configuration.MAX_COMPOSANTS; i++) {
            config.ajouter(new Composant("RAM" + i, "Brand" + i, "Model" + i, 50.0));
        }
        assertFalse(config.ajouter(composant3), "Le composant ne devrait pas être ajouté car on dépasse le nombre de composants maximum permis");
    }
}
