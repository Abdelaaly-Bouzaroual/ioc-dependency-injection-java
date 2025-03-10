package net.bouz.dao;

/**
 * Deuxième implémentation de l'interface IDao.
 * Cette classe simule l'accès aux données via des capteurs.
 */
import org.springframework.stereotype.Component;

@Component("d2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("version capteurs ... ! ");
        double t = 12;
        return t;
    }
}
