![Build](https://github.com/guillaumehx/memoire-implementation-java/actions/workflows/maven.yml/badge.svg)

# Télécharger le code

La première étape consiste à télécharger ou cloner le dépôt. Deux options sont possibles :
- Cliquer sur le bouton vert en haut à droite ```<> Code``` puis ```Download ZIP```.
- Ou utiliser git : ``` git clone https://github.com/guillaumehx/memoire-implementation-java.git ```

# Implémentation Java

Il est nécéssaire d'avoir le JDK 21 installé sur votre machine.
Vérifiez dans le terminal de votre machine si la bonne version de Java est installé en lançant la commande ```java --version```

# Compilation et tests

Le programme se compile, test et exécute à l'aide de Maven 3.

Vérifiez dans le terminal de votre machine si Maven 3 est  déjà installé en lançant la commande ```mvn -version```

Pour compiler le programme, lancez la commande ``mvn clean compile``.

Pour tester le programme (avec les tests unitaires JUnit), lancez la commande ``mvn test``.

# Exécution

Pour éxecuter le programme, lancez la commande ``mvn exec:java``.

Vous pouvez aussi lancer le programme en passant des arguments en ligne de commande, en séparant chaque argument par une espace. Par exemple ```mvn exec:java -Dexec.args="6+2*(10/5) 2+2 8-5^2"```
