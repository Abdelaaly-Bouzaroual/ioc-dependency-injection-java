package net.bouz.pres;

import net.bouz.dao.IDao;
import net.bouz.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Exemple d'injection dynamique de dépendances avec réflexion.
 */
public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner sc = new Scanner(new File("config.txt")); // ouvrire le fichie
        String daoClassName = sc.nextLine(); // lire la premier ligne
        /*
        on dois faire l'instanciation dynamique , car on connait pas la class
         */
        Class<?> cDao = Class.forName(daoClassName); // charger la class en memoire
        IDao dao=(IDao) cDao.newInstance(); // pour utiliser l'objet de cette class + newInstance ; constructuer sans paremtres
        System.out.println(dao.getData());

        String metierClassName = sc.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
//        IMetier metier=(IMetier) cMetier.getConstructor().newInstance();
//        Method setDao = cMetier.getMethod("setDao", IDao.class);
//        setDao.invoke(metier,dao);
        System.out.println("rest = "+  metier.calcul());

    }
}
