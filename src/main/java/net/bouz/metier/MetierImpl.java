package net.bouz.metier;

import net.bouz.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implémentation de l'interface métier.
 * Cette classe applique l'Inversion de Contrôle en utilisant l'injection de dépendance.
 */
@Component("m")
public class MetierImpl implements IMetier {
    @Autowired // Injection automatique de Spring
    private IDao dao; // Couplage faible


    /**
     * Injection de dépendance via le constructeur; au moment de l'instantiation.
     * @param dao L'implémentation de IDao à injecter.
     *
     */
    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
    }
    public MetierImpl() {}

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t *12 * Math.PI/2 * Math.cos(t);
        return res;
    }

    /**
     * Injection de dépendance via un setter u moment de l'instantiation.
     * @param dao L'implémentation de IDao à injecter.
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
