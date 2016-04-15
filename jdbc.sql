DROP SCHEMA IF EXISTS JDBC;

CREATE SCHEMA JDBC;

USE JDBC;

CREATE TABLE Jugador (
    nom VARCHAR(20),
    lema VARCHAR(20),
    victories INT DEFAULT '0', 
    derrotes INT DEFAULT '0', 
    empats INT DEFAULT '0',
    CONSTRAINT PK_Jugador PRIMARY KEY(nom)
);

# ------- INSERTS --------
INSERT INTO Jugador VALUES ('Ingemar', 'Gogogo', 0, 0, 0);
INSERT INTO Jugador VALUES ('Marta', 'Em mm emm', 0, 0, 0);
INSERT INTO Jugador VALUES ('Albert', 'un lema?', 0, 0, 0);

            
CREATE TABLE Criatura (
    nom VARCHAR(20),
    atac INT,
    defensa INT,
    raça VARCHAR(10),
    medi VARCHAR(10),
    habilitat_esp VARCHAR(20),
    imatge VARCHAR(20),
    propietari VARCHAR(20),
    ready BOOLEAN DEFAULT '0',
    equip INT,
    CONSTRAINT PK_Criatura PRIMARY KEY(nom),
    CONSTRAINT FK_Criatura_Jugador FOREIGN KEY (propietari) REFERENCES Jugador(nom)
);

# ------- INSERTS --------
INSERT INTO Criatures VALUES ('Draco azur', 4, 4, 'Drac', 'aire', null, 'img/draco.jpg','#nomForeignPropietari#');
INSERT INTO Criatures VALUES ('Asaltante Múrloc', 2, 1, 'Múrloc', 'acuatic', null, 'img/murloc.jpg','#nomForeignPropietari#');
INSERT INTO Criatures VALUES ('Caballero Múrloc', 3, 4, 'Múrloc', 'acuatic', null, 'img/murloc.jpg','#nomForeignPropietari#');
INSERT INTO Criatures VALUES ('Rei Mukla', 4, 4, 'Bestia', 'volador', null, 'img/draco.jpg','#nomForeignPropietari#');


CREATE TABLE Equip (
    id INT AUTO_INCREMENT,
    nomEquip VARCHAR(20),
    propietari VARCHAR(20),
    ready BOOLEAN DEFAULT '0',
    CONSTRAINT PK_Equipa PRIMARY KEY(id),
    CONSTRAINT FK_Equip_Jugador FOREIGN KEY (propietari) REFERENCES Jugador(nom)
);
