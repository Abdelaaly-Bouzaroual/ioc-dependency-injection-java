package net.bouz.pres;

import net.bouz.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Exemple d'injection de dépendance avec Spring et les annotations.
 */
public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext("net.bouz.dao");
        IMetier metier = (IMetier) appContext.getBean(IMetier.class);
        System.out.println("res " + metier.calcul());
    }
}
