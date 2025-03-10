package net.bouz.pres;

import net.bouz.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exemple d'injection de dépendance avec Spring et un fichier XML de configuration.
 */
public class PreSpringXml {
    public static void main(String[] args) {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = (IMetier) springContext.getBean("metier");
        System.out.println("res " + metier.calcul());
    }
}
