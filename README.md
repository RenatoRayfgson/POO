<h1 align="center"> Instruções de compilação </h1> 

Bom dia! Eu usei o maven na criação do projeto. Portanto, para execução do projeto basta você colocar os seguintes comandos no terminal integrado aberto em univproj: 

* mvn package
* mvn exec:java

Caso queira abrir o .jar utilize:

* mvn clean package
* java -jar target/univproj-1.0.jar

A versão de release no pom.xml é 24. Por volta da linha 31 do main, é invocado o método Utilities.initTestEvents();. Este método cria um evento de cada tipo e eu usei como testes, caso queira iniciar com 0 eventos, basta comentá-lo.

<h1 align="center"> Links </h1>
<div id="Links">
Link do projeto no github: 
https://github.com/RenatoRayfgson/POO

Link do video com a execução dos comandos e do programa:
</div>
