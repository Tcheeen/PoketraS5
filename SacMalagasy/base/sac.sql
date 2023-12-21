create database poketra;
grant all on database poketra to postgres;
\c poketra

create table Composition (
    idComposition serial primary key,
    nomComposition varchar(20),
    quantiteComposition int
);

create table look (
    idLook serial primary key,
    categorieLook varchar(20)
);

create table materiels(
    idmateriel VARCHAR(20),
    taille VARCHAR(20) not null,
    matierePremiere VARCHAR(30) not null,
    typeMatiere VARCHAR(20) not null,
    look VARCHAR(20) not null,
    prixUnitaire double precision,
    quantite int not null 
);

INSERT INTO materiels VALUES ('S1','Grande','Cuir','Cabas','Luxe',990.90,6);

CREATE  TABLE client ( 
	id                   serial  ,
	nom                  varchar(50)  NOT NULL  ,
	prenom               varchar(100)    ,
	email                varchar(50)  NOT NULL  ,
	mot_de_passe         varchar(255)  NOT NULL  ,
	CONSTRAINT pk_client PRIMARY KEY ( id )
 );

CREATE  TABLE client_fidele ( 
	idclient             integer  NOT NULL  
 );

CREATE  TABLE devis ( 
	id                   serial  ,
	idclient             integer  NOT NULL  ,
	prix                 double precision  NOT NULL  ,
	CONSTRAINT pk_devis PRIMARY KEY ( id )
 );

CREATE  TABLE etude ( 
	id                   serial  ,
	annee                integer  NOT NULL  ,
	total_ecolage        double precision    ,
	CONSTRAINT pk_dentiste PRIMARY KEY ( id )
 );

CREATE  TABLE genre ( 
	id                   serial  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT pk_genre PRIMARY KEY ( id )
 );

CREATE  TABLE niveau_etude ( 
	id                   serial  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT pk_niveau_etude PRIMARY KEY ( id )
 );

CREATE  TABLE service ( 
	id                   serial  ,
	libelle              varchar(100)  NOT NULL  ,
	CONSTRAINT pk_service PRIMARY KEY ( id )
 );

CREATE  TABLE materiel ( 
	id                   serial  ,
	nom              varchar(100)  NOT NULL  ,
	prix                 double precision  NOT NULL  ,
	CONSTRAINT pk_materiel PRIMARY KEY ( id )
 );

CREATE  TABLE specialite ( 
	id                   serial  ,
	nom                  varchar(50)  NOT NULL  ,
	salaire_horaire      double precision  NOT NULL  ,
	CONSTRAINT pk_specialite PRIMARY KEY ( id )
 );

CREATE  TABLE type_depense ( 
	id                   serial  ,
	libelle              varchar(100)  NOT NULL  ,
	CONSTRAINT pk_type_depense PRIMARY KEY ( id )
 );

CREATE  TABLE consultation ( 
	id                   serial  ,
	idclient             integer  NOT NULL  ,
	date_heure           timestamp  NOT NULL  ,
	iddevis              integer    ,
	CONSTRAINT pk_consultation PRIMARY KEY ( id )
 );

CREATE  TABLE depense ( 
	id                   serial  ,
	idtype_depense       integer  NOT NULL  ,
	montant              double precision  NOT NULL  ,
	"date"               date DEFAULT CURRENT_DATE NOT NULL  ,
	CONSTRAINT pk_depense PRIMARY KEY ( id )
 );

CREATE  TABLE devis_service ( 
	iddevis              integer  NOT NULL  ,
	idservice            integer  NOT NULL  
 );

CREATE  TABLE employe ( 
	id                   serial  ,
	nom                  varchar(50)  NOT NULL  ,
	prenom               varchar(100)    ,
	idgenre              integer  NOT NULL  ,
	date_naissance       date  NOT NULL  ,
	idniveau_etude       integer  NOT NULL  ,
	CONSTRAINT pk_employe PRIMARY KEY ( id )
 );

CREATE  TABLE employe_consultation ( 
	idemploye            integer  NOT NULL  ,
	idconsultation       integer  NOT NULL  
 );

CREATE  TABLE employe_specialite ( 
	idemploye            integer  NOT NULL  ,
	idspecialite         integer    
 );

CREATE  TABLE paiement ( 
	id                   serial  ,
	idclient             integer  NOT NULL  ,
	prix                 double precision  NOT NULL  ,
	"date"               date DEFAULT CURRENT_DATE   ,
	idconsultation       integer  NOT NULL  ,
	CONSTRAINT pk_paiement PRIMARY KEY ( id )
 );



INSERT INTO employe (nom, prenom, idgenre, date_naissance, idniveau_etude)
VALUES ('Doe', 'John', 1, '1990-01-15', 2);

INSERT INTO employe (nom, prenom, idgenre, date_naissance, idniveau_etude)
VALUES ('Smith', 'Jane', 2, '2012-05-20', 3);

INSERT INTO employe (id, nom, prenom, idgenre, date_naissance, idniveau_etude)
VALUES (DEFAULT, 'Johnson', 'Bob', 1, '2003-09-10', 4);

INSERT INTO employe (id, nom, prenom, idgenre, date_naissance, idniveau_etude)
VALUES (DEFAULT, 'Williams', 'Alice', 2, '2004-03-25', 2);


INSERT INTO employe (id, nom, prenom, idgenre, date_naissance, idniveau_etude)
VALUES (DEFAULT, 'Ravelojaona', 'Mahazo', 2, '2002-03-25', 2);


ALTER TABLE entana
DROP COLUMN  prixunitaire;