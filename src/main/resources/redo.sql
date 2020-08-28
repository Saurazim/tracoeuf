DROP DATABASE bdd_tracoeuf;
CREATE DATABASE bdd_tracoeuf DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON bdd_tracoeuf.* TO 'java'@'localhost';

insert into categorie(type,nom) values("BIO", "Bio"),
    ("PA", "Plein Air"),
    ("PAS", "Poule au Sol"),
    ("CAGE", "Poule en cage");