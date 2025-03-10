package net.bouz.pres;

import net.bouz.dao.DaoImpl;
import net.bouz.metier.MetierImpl;

/**
 * Classe de présentation qui utilise une injection de dépendance statique.
 */
public class Pres {
    public static void main(String[] args) {

        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao); //injection de dependence via le constructeur
//        metier.setDao(dao); // injection de dependence via le setter
        System.out.println("res " + metier.calcul());
    }
}
