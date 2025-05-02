# Proyecto
El programa tiene las capacidades para la gestión de una biblioteca, teniendo la posibilidad de registrar libros (rústicos, ebooks y audiolibros), usuarios (estudiantes y profesores), así como préstamos de los libros y su devolución.
El proyecto cuenta con nueve clases: dos de las cuales son clases abstractas, cinco son clases hijas: 
* La clase BibliotecaApp tiene una relación de agregación con las clases Libro, Usuario y Prestamo.
* La clase Usuario tiene una relación padre-hija con las subclases Estudiante y profesor.
* La clase Libro tiene una relación padre-hija con las subclases Rustico, Audiolibro y Ebook.
* La clase Prestamo tiene una relación de asociación con las clases Libro y Usuario.
## Instalación
El proyecto cuenta con documentación de **Javadoc** generado con el IDE Intellij IDEA (véase [Documentación](javadoc/index.html)).
También se agregaron pruebas unitarias utilizando JUnit, para lo cual se agregaron las siguientes tags en el documento `pom.xml`, como dependencias:
```xml
<dependencies>

<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->

<dependency>

<groupId>org.junit.jupiter</groupId>

<artifactId>junit-jupiter-api</artifactId>

<version>5.13.0-M2</version>

<scope>test</scope>

</dependency>

</dependencies>
```
También se agregó un plugin **jacoco** para la generación de un documento que muestra la completitud de pruebas en el proyecto (véase [Pruebas](target/site/jacoco/index.html)):
```xml
<build>

<plugins>

<plugin>

<groupId>org.jacoco</groupId>

<artifactId>jacoco-maven-plugin</artifactId>

<version>0.8.12</version>

<executions>

<execution>

<goals>

<goal>prepare-agent</goal>

</goals>

</execution>

<execution>

<id>report</id>

<phase>test</phase>

<goals>

<goal>report</goal>

</goals>

</execution>

<execution>

<id>jacoco-check</id>

<goals>

<goal>check</goal>

</goals>

<configuration>

<rules>

<rule>

<element>PACKAGE</element>

<limits>

<limit>

<counter>LINE</counter>

<value>COVEREDRATIO</value>

</limit>

</limits>

</rule>

</rules>

</configuration>

</execution>

</executions>

</plugin>

</plugins>

</build>
```
**Por lo cual es importante instalar las dependencias**. En VS Code se puede utilizar la extención **Maven for Java** para reconocer e instalar las dependencias. En Intellij IDEA es necesario iniciar el proyecto con Maven para reconocer e instalar las dependencias.