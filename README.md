# springbootproj
== INTRODUCTION ==
Projet créé à partir du tutorial spring boot https://spring.io/guides/gs/spring-boot/
Auquel ont été ajoutés quelques éléments :
Dans le build.gradle : 
 - Plugin Gradle pour créer un conteneur docker selon le tuto Spring https://spring.io/guides/gs/spring-boot-docker/
 - Ajout de module complémentaires pour les Metrics 
   compile("org.springframework.hateoas:spring-hateoas:0.20.0.RELEASE")
    compile("org.jolokia:jolokia-core")
    compile("org.webjars:hal-browser")
 - Ajout du plugin gitt properties pour generer des infos disposnibles aupres des Metrics 
  id "com.gorylenko.gradle-git-properties" version "1.4.17"
Dans le code source :
 - Modification du HelloController pour ajouter deux  metriques personnalisées



== INSTALLATION ==
Download Gradle 
unzip gradle-3.0-bin.zip
export GRADLE_HOME=$(pwd)/gradle-3.0
export PATH=$GRADLE_HOME/bin:$PATH
git clone springbootproj
cd springbootproj

== RUN ==
Lancement option 1 : 
gradle build
java -jar build/libs/springbootproj-0.1.0.jar
Lancement option 2 : 
gradle bootRun
Lancement option 3 : 
gradle buildDocker
docker run -p 8080:8080 -t n3biot/springbootproj



