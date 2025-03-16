# Inversion de Contrôle & Injection de Dépendances en Java

Ce projet illustre les concepts de l'Inversion de Contrôle (IoC) et de l'Injection de Dépendance (DI) en Java avec Spring.

## 🔹 Introduction
L'**Inversion de Contrôle (IoC)** est un principe fondamental en programmation qui permet de **découpler** les composants d'une application. L'**Injection de Dépendances (DI)** est une implémentation de l'IoC qui consiste à **fournir** les dépendances d'un objet au lieu de les créer directement. 

### 📌 Pourquoi utiliser l'injection dynamique ?
L'injection dynamique permet d'éviter le **fort couplage** entre les classes. Plutôt que d'instancier manuellement les objets, ils sont injectés par un **conteneur** (Spring, par exemple) ou via des mécanismes comme la **réflexion**. Cela facilite :
- **La maintenance** du code
- **Le changement des dépendances** sans modifier le code source
- **L'intégration facile avec des frameworks** comme Spring


## 📌 Contenu
- **Injection statique** (par constructeur et setter)
- **Injection dynamique** avec réflexion
- **Injection via Spring (XML & annotations)**

## 🛠️ Technologies utilisées
- Java
- Spring Framework
- Git/GitHub

## 🚀 Comment exécuter ?
### 🔹 1. Tester l'Injection Statique
L'injection statique signifie que nous créons manuellement les objets et les injectons dans notre classe métier.

#### 🔹 Injection via le constructeur
1. Exécuter la classe `Pres.java` :
   ```bash
   java -cp bin net.bouz.pres.Pres
   ```
2. Résultat attendu :
   ```
   Version base de données
   Résultat: 1023.456
   ```

#### 🔹 Injection via le setter
1. Décommenter la ligne `metier.setDao(dao);` dans `Pres.java`
2. Compiler et exécuter :
   ```bash
   java -cp bin net.bouz.pres.Pres
   ```

✅ **Différence** : Avec le constructeur, l'injection se fait dès l'instanciation. Avec le setter, elle peut être modifiée à tout moment.

---
### 🔹 2. Tester l'Injection Dynamique

L'injection dynamique permet de charger dynamiquement les classes à partir d'un fichier de configuration.

1. Vérifier que `config.txt` contient :
   ```
   net.bouz.dao.DaoImpl
   net.bouz.metier.MetierImpl
   ```
2. Exécuter la classe `Pres2.java` :
   ```bash
   java -cp bin net.bouz.pres.Pres2
   ```
3. Résultat attendu :
   ```
   Version base de données
   Résultat: 1023.456
   ```
✅ **Avantage** : L'application peut changer de classe sans recompiler.

---
### 🔹 3. Tester l'Injection avec Spring et XML
Cette méthode utilise un fichier `config.xml` pour configurer Spring et injecter les dépendances automatiquement.

1. Vérifier le fichier `config.xml` :
   ```xml
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
       <bean id="d" class="net.bouz.dao.DaoImpl"/>
       <bean id="metier" class="net.bouz.metier.MetierImpl">
           <property name="dao" ref="d"/>
       </bean>
   </beans>
   ```
2. Exécuter `PreSpringXml.java` :
   ```bash
   java -cp bin net.bouz.pres.PreSpringXml
   ```
3. Résultat attendu :
   - Spring crée et injecte automatiquement les objets définis dans `config.xml`.


---
### 🔹 3. Tester l'Injection avec Spring et XML

Cette méthode utilise un fichier `config.xml` pour injecter les dépendances automatiquement.

1. Vérifier `config.xml` :
   ```xml
   <bean id="d" class="net.bouz.dao.DaoImpl"/>
   <bean id="metier" class="net.bouz.metier.MetierImpl">
       <property name="dao" ref="d"/>
   </bean>
   ```
2. Exécuter `PreSpringXml.java` :
   ```bash
   java -cp bin net.bouz.pres.PreSpringXml
   ```
✅ **Spring gère l'injection automatiquement grâce à la configuration XML.**

---
### 🔹 4. Tester l'Injection avec Spring et les Annotations
Cette méthode utilise `@Component` et `@Autowired` pour gérer l'injection des dépendances.

1. Vérifier que les classes sont annotées avec `@Component` et `@Autowired`.
2. Exécuter `PresSpringAnnotation.java` :
   ```bash
   java -cp bin net.bouz.pres.PresSpringAnnotation
   ```
✅ **Spring scanne les annotations et injecte automatiquement les dépendances.**

---
