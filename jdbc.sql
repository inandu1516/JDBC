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
    ready BOOLEAN DEFAULT FALSE,
    equip INT,
    CONSTRAINT PK_Criatura PRIMARY KEY(nom),
    CONSTRAINT FK_Criatura_Jugador FOREIGN KEY (propietari) REFERENCES Jugador(nom)
);


INSERT INTO Criatura (nom, atac, defensa, raça, medi, imatge, propietari) VALUES ('Draco azur', 4, 4, 'Dragon', 'aire', 'img/draco.jpg','Albert');
INSERT INTO Criatura (nom, atac, defensa, raça, medi, imatge, propietari) VALUES ('Asaltante Murloc', 2, 1, 'Murloc', 'acuatico', 'img/murloc.jpg','Albert');
INSERT INTO Criatura (nom, atac, defensa, raça, medi, imatge, propietari) VALUES ('Caballero Murloc', 3, 4, 'Murloc', 'acuatico', 'img/murloc.jpg','Albert');
INSERT INTO Criatura (nom, atac, defensa, raça, medi, imatge, propietari) VALUES ('Rei Mukla', 4, 4, 'Bestia', 'volador', 'img/draco.jpg','Albert');


CREATE TABLE Equip (
    id INT AUTO_INCREMENT,
    nomEquip VARCHAR(20),
    propietari VARCHAR(20),
    ready BOOLEAN DEFAULT FALSE,
    CONSTRAINT PK_Equipa PRIMARY KEY(id),
    CONSTRAINT FK_Equip_Jugador FOREIGN KEY (propietari) REFERENCES Jugador(nom)
);
