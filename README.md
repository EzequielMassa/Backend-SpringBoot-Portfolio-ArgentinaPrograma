Backend API REST desarrollada en JAVA/SPRINGBOOT para el proyecto "Portfolio web fullstack" del bootcamp "Argentina Programa";

#Patron MVC 
Desde el backend el portfolio utiliza el patron MVC;

<img width="278" alt="Captura de pantalla 2022-09-21 112632" src="https://user-images.githubusercontent.com/94617066/191531694-257e1b28-52bc-4d01-a55e-5941b350e123.png">


#Capa de Seguridad con JWT

<img width="276" alt="Captura de pantalla 2022-09-21 112802" src="https://user-images.githubusercontent.com/94617066/191531770-f600a59c-7115-44aa-9116-b749575adfa2.png">

#Validaciones de campos en tablas

<img width="400" alt="Captura de pantalla 2022-09-21 113042" src="https://user-images.githubusercontent.com/94617066/191532454-c2cd6be5-e4da-40ab-a4c6-29ced13a12d7.png">

#Relaciones entre tablas para su correcto almacenamiento en la base de datos MYSQL.

<img width="608" alt="Captura de pantalla 2022-09-21 113111" src="https://user-images.githubusercontent.com/94617066/191532591-a125ef38-1897-460c-9a92-474045e5ac9b.png">

#Diagra Entidad Relacion (DER)

<img width="589" alt="Captura de pantalla 2022-09-21 124415" src="https://user-images.githubusercontent.com/94617066/191550227-32312537-63b2-4c78-ae46-db4b0f3b11df.png">


#Dependencias y Plugins utilizados

 <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
       

        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
            <version>0.9.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
