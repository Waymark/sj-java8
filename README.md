#Förberedelser

## Installera JDK 8

Ladda hem installationsfil för din plattform här: [JDK 8] (https://jdk8.java.net/download.html).
Koden är testad mot version 1.8.0_112-b16.

  Kontrollera att installationen gått bra genom att köra `java -version`. Du bör då se en utskrift i stil med

    java version "1.8.0_112"
    Java(TM) SE Runtime Environment (build 1.8.0_112-b16)
    Java HotSpot(TM) 64-Bit Server VM (build 25.112-b16, mixed mode)


## Installera Maven 3.x.

  Ladda hem [Maven] (http://maven.apache.org/download.cgi).

  Maven måste använda Java 8 vid körning. Kontrollera att så är fallet genom att köra `mvn -version`. Om en tidigare
  version av Java används av Maven behöver du sätta miljövariabeln `JAVA_HOME` att peka till din Java 8-installation.

## Ladda hem källkoden

    git clone https://radarminnet@github.com/radarminnet/sj-java8.git

## Kör bygget
  Ställ dig i mappen där `pom.xml` ligger och kör

    mvn clean install

  Om allt gick bra ska du se följande i slutet av utskriften

    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 2.533s
    [INFO] Finished at: Sun Nov 17 11:23:22 CET 2013
    [INFO] Final Memory: 15M/189M
    [INFO] ------------------------------------------------------------------------


#Instruktioner

  Öppna någon av övningarna ***Lab.java**. Övningarna är utformade som enhetstester där varje metod behöver fyllas på med kod för att
  testet ska gå igenom. Påbörja en uppgift genom att ta bort annoteringen `@Ignore`. Pröva lösningen genom att köra
  maven-bygget med:

    mvn clean install
