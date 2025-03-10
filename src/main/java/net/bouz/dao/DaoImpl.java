package net.bouz.dao;

import org.springframework.stereotype.Component;

/**
 * Implémentation de l'interface IDao pour la récupération des données.
 * Cette classe simule l'accès à une base de données.
 * Elle est annotée avec @Component pour permettre l'injection automatique par Spring.
 */
@Component("d")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        System.out.println("Version base de données");
        double t = 34;
        return t;
    }
}
