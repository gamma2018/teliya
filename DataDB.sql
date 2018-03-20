INSERT INTO "client" ("clientid","nomclient","prenomclient","telclient") VALUES (1,'sdfsd','fdsf','fsdqf');
GO
INSERT INTO "client" ("clientid","nomclient","prenomclient","telclient") VALUES (3,'Diallo II','645336677','645336677');
GO
INSERT INTO "client" ("clientid","nomclient","prenomclient","telclient") VALUES (2,'mamadou','00000','00000');
GO
INSERT INTO "client" ("clientid","mutuelleid","nomclient","prenomclient","telclient") VALUES (4,2,'BAH','Aicha','656002234');
GO
INSERT INTO "client" ("clientid","mutuelleid","nomclient","prenomclient","telclient") VALUES (5,2,'DIALLO','Aria','656445566');
GO
INSERT INTO "client" ("clientid","mutuelleid","nomclient","prenomclient","telclient") VALUES (6,3,'Barry','Binta','622544534');
GO

﻿INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (28,2,26,'2018-03-05','validé');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (29,1,27,'2018-03-07','validé');
GO
INSERT INTO "commande" ("commandeid","facturecommandeid","datecommande","statutcommande") VALUES (13,11,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","facturecommandeid","datecommande","statutcommande") VALUES (14,12,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","facturecommandeid","datecommande","statutcommande") VALUES (15,13,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","facturecommandeid","datecommande","statutcommande") VALUES (16,14,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (17,1,15,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (18,3,16,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (19,3,17,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (20,4,18,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (21,2,19,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (22,2,20,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (23,1,21,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (24,2,22,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","facturecommandeid","datecommande","statutcommande") VALUES (25,23,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","facturecommandeid","datecommande","statutcommande") VALUES (26,24,'2018-03-05','brouillon');
GO
INSERT INTO "commande" ("commandeid","grossisteid","facturecommandeid","datecommande","statutcommande") VALUES (27,1,25,'2018-03-05','brouillon');
GO

﻿INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (4,17,30,95000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (5,17,40,25000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (4,18,50,72000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (4,19,9,407000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (6,20,5,12000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (4,20,6,13000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (5,20,7,14000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (6,21,2,45000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (5,22,5,20000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (6,23,4,50000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (6,24,9,45800);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (6,27,4,452000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (4,27,6,78000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (5,27,12,100000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (7,28,4,80000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (6,28,64,124000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (4,28,28,75000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (5,28,30,90000);
GO
INSERT INTO "concerne" ("produitid","commandeid","quantitdemande","prixunitaire") VALUES (8,29,30,45000);
GO

﻿
﻿
﻿
﻿INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (11,'FAC/2018/03/N5',0,0,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (12,'FAC/2018/03/N6',0,0,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (13,'FAC/2018/03/N7',0,0,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (14,'FAC/2018/03/N8',0,0,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (15,'FAC/2018/03/N99',3850000,3850000,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (16,'FAC/2018/03/N100',3600000,3600000,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (17,'FAC/2018/03/N101',3663000,3663000,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (18,'FAC/2018/03/N102',236000,236000,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (19,'FAC/2018/03/N103',90000,90000,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (20,'FAC/2018/03/N104',100000,100000,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (21,'FAC/2018/03/N105',200000,200000,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (22,'FAC/2018/03/N106',412200,412200,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (23,'FAC/2018/03/N107',0,0,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (24,'FAC/2018/03/N108',0,0,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (25,'FAC/2018/03/N109',3476000,3476000,'brouillon');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (26,'FAC/2018/03/N110',26912000,26912000,'validé');
GO
INSERT INTO "facturecommande" ("facturecommandeid","numerofacturecommande","montantfacturecommande","restefacturecommande","statutfacturecommande") VALUES (27,'FAC/2018/03/N111',2700000,2700000,'validé');
GO

﻿INSERT INTO "forme" ("formeid","libelleforme") VALUES (1,'Injection');
GO
INSERT INTO "forme" ("formeid","libelleforme") VALUES (2,'Forme');
GO

﻿INSERT INTO "grossiste" ("grossisteid","nomgrossiste","telgrossiste","adressegrossister") VALUES (2,'Alpha Saliou','Sangoya','634455678');
GO
INSERT INTO "grossiste" ("grossisteid","nomgrossiste","telgrossiste","adressegrossister") VALUES (1,'Pharma Guinee','Dixinn IV','622350375');
GO
INSERT INTO "grossiste" ("grossisteid","nomgrossiste","telgrossiste","adressegrossister") VALUES (3,'Samba','Alphayaya','6334455');
GO
INSERT INTO "grossiste" ("grossisteid","nomgrossiste","telgrossiste","adressegrossister") VALUES (4,'Aminata','656140976','Soloprimo');
GO

﻿INSERT INTO "mutuelle" ("mutuelleid","nommutuelle","phonemutuelle","adressemutuelle","emailmutuelle") VALUES (2,'SOGAM','655352553','Matam','sogam@gmail.com');
GO
INSERT INTO "mutuelle" ("mutuelleid","nommutuelle","phonemutuelle","adressemutuelle","emailmutuelle") VALUES (3,'UGAR','653221142','Kaloum','ugar@gmail.com');
GO
INSERT INTO "mutuelle" ("mutuelleid","nommutuelle","phonemutuelle","adressemutuelle","emailmutuelle") VALUES (4,'UGAR ASSURANCE','656009178','Kaloum','kaloum@gmail.com');
GO
INSERT INTO "mutuelle" ("mutuelleid","nommutuelle","phonemutuelle","adressemutuelle","emailmutuelle") VALUES (5,'Yaya Assurance','645335566','Taouyah','yaya@gmail.com');
GO
INSERT INTO "mutuelle" ("mutuelleid","nommutuelle","phonemutuelle","adressemutuelle","emailmutuelle") VALUES (6,'Saar Assurance','622456151','Kaloum','saarguinee@gmail.com');
GO

﻿
﻿INSERT INTO "produit" ("produitid","typeproduitid","designation","formeid","code","seuil","prixunitaire") VALUES (5,1,'Doliprane',2,'#Pdl0001',5,90000);
GO
INSERT INTO "produit" ("produitid","typeproduitid","designation","formeid","code","seuil","prixunitaire") VALUES (4,1,'Sulfobactin',1,'#PSul0001',2,75000);
GO
INSERT INTO "produit" ("produitid","typeproduitid","designation","formeid","code","seuil","prixunitaire") VALUES (6,1,'Paracétamol',2,'#Pra0007',4,124000);
GO
INSERT INTO "produit" ("produitid","typeproduitid","designation","formeid","code","seuil","prixunitaire") VALUES (7,1,'Gripex',2,'#PO0009',5,80000);
GO
INSERT INTO "produit" ("produitid","typeproduitid","designation","formeid","code","seuil","prixunitaire") VALUES (8,1,'Nivaquine',2,'#P0009',10,45000);
GO

﻿INSERT INTO "reception" ("commandeid","produitid","quantitelivre","prixunitaire") VALUES (28,5,30,90000);
GO
INSERT INTO "reception" ("commandeid","produitid","quantitelivre","prixunitaire") VALUES (28,4,28,75000);
GO
INSERT INTO "reception" ("commandeid","produitid","quantitelivre","prixunitaire") VALUES (28,6,64,124000);
GO
INSERT INTO "reception" ("commandeid","produitid","quantitelivre","prixunitaire") VALUES (28,7,14,80000);
GO
INSERT INTO "reception" ("commandeid","produitid","quantitelivre","prixunitaire") VALUES (29,8,30,45000);
GO

﻿INSERT INTO "stock" ("stockid","produitid","dateperemption","quantitereel","quantitetheorique") VALUES (2,5,'2018-02-23',30,30);
GO
INSERT INTO "stock" ("stockid","produitid","dateperemption","quantitereel","quantitetheorique") VALUES (1,4,'2018-02-23',28,28);
GO
INSERT INTO "stock" ("stockid","produitid","dateperemption","quantitereel","quantitetheorique") VALUES (3,6,'2018-03-05',64,64);
GO
INSERT INTO "stock" ("stockid","produitid","dateperemption","quantitereel","quantitetheorique") VALUES (4,7,'2018-03-05',14,14);
GO
INSERT INTO "stock" ("stockid","produitid","dateperemption","quantitereel","quantitetheorique") VALUES (5,8,'2018-03-07',30,30);
GO

﻿INSERT INTO "typeproduit" ("typeproduitid","libelletype") VALUES (1,'Comprimet');
GO
INSERT INTO "typeproduit" ("typeproduitid","libelletype") VALUES (2,'daux');
GO

﻿INSERT INTO "utilisateur" ("utilisateurid","username","password","nom","prenom") VALUES (2,'yaya','123456','Diallo','Yaya');
GO
INSERT INTO "utilisateur" ("utilisateurid","username","password","nom","prenom") VALUES (3,'shawanda10','123456','Sylla','Shawanda');
GO
INSERT INTO "utilisateur" ("utilisateurid","username","password","nom","prenom") VALUES (1,'sabari','00000','Barry','Sadou II');
GO

﻿
