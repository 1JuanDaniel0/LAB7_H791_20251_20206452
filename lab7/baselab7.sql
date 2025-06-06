CREATE DATABASE IF NOT EXISTS baselab7;
USE baselab7;

CREATE TABLE alumno (
                        id INT NOT NULL AUTO_INCREMENT,
                        nombres VARCHAR(50) NOT NULL,
                        apellidos VARCHAR(50) NOT NULL,
                        dni INT NOT NULL,
                        codigo INT NOT NULL,
                        fechaNacimiento DATE NOT NULL,
                        sexo VARCHAR(1) NOT NULL,
                        correoInstitucional VARCHAR(100) NOT NULL,
                        correoPersonal VARCHAR(100) NULL DEFAULT NULL,
                        telefono VARCHAR(9) NULL DEFAULT NULL,
                        direccion TEXT NULL DEFAULT NULL,
                        departamento VARCHAR(30) NULL DEFAULT NULL,
                        provincia VARCHAR(30) NULL DEFAULT NULL,
                        carrera VARCHAR(40) NULL DEFAULT NULL,
                        fechaRegistro DATETIME NOT NULL,
                        ultimaActualizacion DATETIME NOT NULL,
                        estado BOOLEAN NOT NULL,
                        PRIMARY KEY (id)
);

INSERT INTO alumno VALUES (
                              1,
                              'Juan Daniel',
                              'Ulloa Vega',
                              '76676676',
                              '20206452',
                              '2003-06-05',
                              'M',
                              'a20206452@pucp.edu.pe',
                              'juanulloavega3@gmail.com',
                              '999999999',
                              'direccion prueba',
                              'Lima',
                              'Lima',
                              'Ingeniería',
                              current_date,
                              current_date,
                              1
                          );