CREATE TABLE "public"."mutuelle" (
	"mutuelleid" serial PRIMARY KEY, 
	"nommutuelle" varchar(50), 
	"phonemutuelle" varchar(20), 
	"adressemutuelle" varchar(100), 
	"emailmutuelle" varchar(100)
)
GO

CREATE TABLE "public"."client" (
	"clientid" serial PRIMARY KEY, 
	"mutuelleid" integer, 
	"nomclient" varchar(50), 
	"prenomclient" varchar(50), 
	"telclient" varchar(20), 
	FOREIGN KEY ("mutuelleid")
		REFERENCES "public"."mutuelle" ("mutuelleid")
		ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE INDEX "association_10_fk"
	ON "public"."client"
	USING btree (mutuelleid);
GO

CREATE TABLE "public"."facturecommande" (
	"facturecommandeid" serial PRIMARY KEY, 
	"numerofacturecommande" varchar(50), 
	"montantfacturecommande" integer, 
	"restefacturecommande" integer, 
	"statutfacturecommande" varchar(50)
)
GO

CREATE TABLE "public"."grossiste" (
	"grossisteid" serial PRIMARY KEY, 
	"nomgrossiste" varchar(50), 
	"telgrossiste" varchar(20), 
	"adressegrossister" text
)
GO

CREATE TABLE "public"."commande" (
	"commandeid" serial PRIMARY KEY, 
	"grossisteid" integer, 
	"facturecommandeid" integer, 
	"datecommande" date, 
	"statutcommande" varchar(50), 
	FOREIGN KEY ("grossisteid")
		REFERENCES "public"."grossiste" ("grossisteid")
		ON UPDATE CASCADE ON DELETE CASCADE, 
	FOREIGN KEY ("facturecommandeid")
		REFERENCES "public"."facturecommande" ("facturecommandeid")
		ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE INDEX "genere2_fk"
	ON "public"."commande"
	USING btree (facturecommandeid);
GO
CREATE INDEX "livre_fk"
	ON "public"."commande"
	USING btree (grossisteid);
GO

CREATE TABLE "public"."typeproduit" (
	"typeproduitid" serial PRIMARY KEY, 
	"libelletype" varchar(50)
)
GO

CREATE TABLE "public"."produit" (
	"produitid" serial PRIMARY KEY, 
	"typeproduitid" integer NOT NULL, 
	"designation" varchar(50), 
	"formeid" integer, 
	"code" varchar(254), 
	"seuil" integer, 
	"prixunitaire" integer, 
	FOREIGN KEY ("formeid")
		REFERENCES "public"."forme" ("formeid")
		ON UPDATE CASCADE ON DELETE CASCADE, 
	FOREIGN KEY ("typeproduitid")
		REFERENCES "public"."typeproduit" ("typeproduitid")
		ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE INDEX "association_2_fk"
	ON "public"."produit"
	USING btree (typeproduitid);
GO

CREATE TABLE "public"."concerne" (
	"produitid" integer NOT NULL, 
	"commandeid" integer NOT NULL, 
	"quantitdemande" integer, 
	"prixunitaire" integer,
	CONSTRAINT "pk_concerne" PRIMARY KEY ("produitid", "commandeid"), 
	FOREIGN KEY ("produitid")
		REFERENCES "public"."produit" ("produitid")
		ON UPDATE CASCADE ON DELETE CASCADE, 
	FOREIGN KEY ("commandeid")
		REFERENCES "public"."commande" ("commandeid")
		ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE INDEX "concerne2_fk"
	ON "public"."concerne"
	USING btree (commandeid);
GO
CREATE INDEX "concerne_fk"
	ON "public"."concerne"
	USING btree (produitid);
GO
CREATE UNIQUE INDEX "concerne_pk"
	ON "public"."concerne"
	USING btree (produitid, commandeid);
GO

CREATE TABLE "public"."paiement" (
	"idpaiement" serial PRIMARY KEY, 
	"datepaiement" date, 
	"montantpaiement" integer
)
GO

CREATE TABLE "public"."vente" (
	"venteid" serial PRIMARY KEY, 
	"clientid" integer, 
	"factureclientid" integer, 
	"datevente" date, 
	"statutvente" varchar(254), 
	FOREIGN KEY ("factureclientid")
		REFERENCES "public"."factureclient" ("factureclientid")
		ON UPDATE CASCADE ON DELETE CASCADE, 
	FOREIGN KEY ("clientid")
		REFERENCES "public"."client" ("clientid")
		ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE INDEX "association_11_fk"
	ON "public"."vente"
	USING btree (factureclientid);
GO
CREATE INDEX "association_9_fk"
	ON "public"."vente"
	USING btree (clientid);
GO

CREATE TABLE "public"."detailspaiement" (
	"idpaiement" integer NOT NULL, 
	"venteid" integer NOT NULL, 
	"datepaiement" date,
	CONSTRAINT "pk_detailspaiement" PRIMARY KEY ("idpaiement", "venteid"), 
	FOREIGN KEY ("idpaiement")
		REFERENCES "public"."paiement" ("idpaiement")
		ON UPDATE CASCADE ON DELETE CASCADE, 
	FOREIGN KEY ("venteid")
		REFERENCES "public"."vente" ("venteid")
		ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE INDEX "detailspaiement2_fk"
	ON "public"."detailspaiement"
	USING btree (venteid);
GO
CREATE INDEX "detailspaiement_fk"
	ON "public"."detailspaiement"
	USING btree (idpaiement);
GO
CREATE UNIQUE INDEX "detailspaiement_pk"
	ON "public"."detailspaiement"
	USING btree (idpaiement, venteid);
GO

CREATE TABLE "public"."detailsvente" (
	"produitid" integer NOT NULL, 
	"venteid" integer NOT NULL, 
	"date" date, 
	"quantite" integer, 
	"remise" integer,
	CONSTRAINT "pk_detailsvente" PRIMARY KEY ("produitid", "venteid"), 
	FOREIGN KEY ("venteid")
		REFERENCES "public"."vente" ("venteid")
		ON UPDATE CASCADE ON DELETE CASCADE, 
	FOREIGN KEY ("produitid")
		REFERENCES "public"."produit" ("produitid")
		ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE INDEX "detailsvente2_fk"
	ON "public"."detailsvente"
	USING btree (venteid);
GO
CREATE INDEX "detailsvente_fk"
	ON "public"."detailsvente"
	USING btree (produitid);
GO
CREATE UNIQUE INDEX "detailsvente_pk"
	ON "public"."detailsvente"
	USING btree (produitid, venteid);
GO

CREATE TABLE "public"."factureclient" (
	"factureclientid" serial PRIMARY KEY, 
	"numerofactureclient" varchar(50), 
	"montantfactureclient" integer, 
	"restefactureclient" integer, 
	"statutfactureclient" varchar(50), 
	"datefactureclient" date
)
GO

CREATE TABLE "public"."forme" (
	"formeid" serial PRIMARY KEY, 
	"libelleforme" varchar(254)
)
GO

CREATE TABLE "public"."reception" (
	"commandeid" integer, 
	"produitid" integer, 
	"quantitelivre" integer, 
	"prixunitaire" integer, 
	FOREIGN KEY ("produitid")
		REFERENCES "public"."produit" ("produitid")
		ON UPDATE CASCADE ON DELETE CASCADE, 
	FOREIGN KEY ("commandeid")
		REFERENCES "public"."commande" ("commandeid")
		ON UPDATE CASCADE ON DELETE CASCADE
)
GO

CREATE TABLE "public"."stock" (
	"stockid" serial PRIMARY KEY, 
	"produitid" integer NOT NULL, 
	"dateperemption" date, 
	"quantitereel" integer, 
	"quantitetheorique" integer, 
	FOREIGN KEY ("produitid")
		REFERENCES "public"."produit" ("produitid")
		ON UPDATE CASCADE ON DELETE CASCADE
)
GO
CREATE INDEX "est_fk"
	ON "public"."stock"
	USING btree (produitid);
GO

CREATE TABLE "public"."utilisateur" (
	"utilisateurid" serial PRIMARY KEY, 
	"username" varchar(254), 
	"password" varchar(254), 
	"nom" varchar(254), 
	"prenom" varchar(254)
)
GO

CREATE OR REPLACE FUNCTION public."fn_genererNumeroFacture"(numerofactureprecedent character varying)
 RETURNS text
 LANGUAGE plpgsql
AS $function$
 DECLARE
 val integer;
 val1 integer;
 val2 integer;
 numeroPrecedant integer;
	BEGIN
	
	    IF numerofacturePrecedent= ''
	    	THEN 
	    		val:= setval('sequence_numemo_facture',1);
	    		val1 := nextval('sequence_numemo_facture');
	    ELSE
			numeroPrecedant:= cast(substring(numerofacturePrecedent from 14 for 5) as integer);
			val:= setval('sequence_numemo_facture',numeroPrecedant+1);
			val1 := nextval('sequence_numemo_facture');
		END IF;
		
		IF cast(to_char(current_date, 'mm') as integer)<12 THEN
			val2 := currval('sequence_numemo_facture');
			val1 := nextval('sequence_numemo_facture');
			IF val2-1< 10
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',14,cast(val2-1 as varchar(1)));
			ELSEIF val2-1< 100
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',15,cast(val2-1 as varchar(2)));
			ELSEIF val2-1< 1000
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',16,cast(val2-1 as varchar(3)));
			ELSEIF val2-1< 10000
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',17,cast(val2-1 as varchar(4)));
			ELSEIF val2-1< 100000
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',18,cast(val2-1 as varchar(5)));
			END IF;
		ELSE 
		    val:= setval('sequence_numemo_facture',1);
		    val1 := nextval('sequence_numemo_facture');
			val2 := currval('sequence_numemo_facture');
			
			IF val2-1< 10
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',14,cast(val2-1 as varchar(1)));
			ELSEIF val2-1< 100
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',15,cast(val2-1 as varchar(2)));
			ELSEIF val2-1< 1000
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',16,cast(val2-1 as varchar(3)));
			ELSEIF val2-1< 10000
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',17,cast(val2-1 as varchar(4)));
			ELSEIF val2-1< 100000
			THEN RETURN rpad('FAC/'||to_char(current_date, 'YYYY') ||'/'|| to_char(current_date, 'mm')||'/N',18,cast(val2-1 as varchar(5)));
			END IF;
		END IF;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."fn_montantCommandeFournisseur"(idcmd integer)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
DECLARE
 montnt integer;
 BEGIN
 
 	SELECT sum("quantitdemande"*"prixunitaire") INTO montnt
 	FROM "concerne"
 	WHERE "commandeid" = idCmd;
 	
 	RETURN montnt;
 
 END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_add_client(nom_client character varying, prenom_client character varying, telephone_client character varying, nom_mutuelle character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		INSERT INTO "public"."client"
		("mutuelleid"
		,"nomclient"
		,"prenomclient"
		,"telclient")
	VALUES
		(
			(SELECT "mutuelleid" FROM "mutuelle" WHERE "nommutuelle"=nom_mutuelle)
			,nom_client
			,prenom_client
			,telephone_client
		);
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_add_facture_commande(id_commande integer, numero_facture_commande character varying, montant integer, reste integer, statut character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		INSERT INTO "public"."facturecommande"
		("commlandeid"
		,"numerofacturecommande"
		,"montantfacturecommande"
		,"restefacturecommande"
		,"statutfacturecommande")
	VALUES
		(id_commande
		,numero_facture_commande
		,montant
		,reste
		,statut);
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_add_grossiste(nom_grossiste character varying, telephone_grossiste character varying, adresse_grossiste text)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		INSERT INTO "public"."grossiste"
		("nomgrossiste"
		,"telgrossiste"
		,"adressegrossister")
	VALUES
		(
		nom_grossiste,
		telephone_grossiste,
		adresse_grossiste
		);
	END
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_add_mutuelle(nom_mutuelle character varying, phone_mutuelle character varying, adresse_mutuelle character varying, email_mutuelle character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		INSERT INTO "public"."mutuelle"
		("nommutuelle"
		,"phonemutuelle"
		,"adressemutuelle"
		,"emailmutuelle")
	VALUES
		(nom_mutuelle
		,phone_mutuelle
		,adresse_mutuelle
		,email_mutuelle);
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_add_produit(nomproduit character varying, typeproduits character varying, formeproduits character varying, codeproduits character varying, seuilproduits integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	DECLARE
		id_produit_inserted integer;
	BEGIN
	
	 /*Ajout du produit*/
	
		INSERT INTO "public"."produit"
			("typeproduitid"
			,"designation"
			,"formeid"
			,"code"
			,"seuil"
			,"prixunitaire")
		VALUES
			((select "typeproduitid" from "typeproduit" where "libelletype"=typeProduits)
			,nomProduit
			,(select "formeid" from "forme" where "libelleforme"=formeProduits)
			,codeProduits
			,seuilProduits
			,0)
		/* recuperation de l'id produit insere*/
		RETURNING "produitid" INTO id_produit_inserted;
		
		/*initialisation du stock*/
		INSERT INTO "public"."stock"
			("produitid"
			,"dateperemption"
			,"quantitereel"
			,"quantitetheorique")
		VALUES
			(id_produit_inserted
			,current_date
			,0
			,0);
		
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_add_type_produit(libelle character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		INSERT INTO "public"."typeproduit"
		("libelletype")
	VALUES
		(libelle);
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_add_utilisateur(nom_utilisateur character varying, prenom_utilisateur character varying, pseudo_utilisateur character varying, mot_de_passe character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		INSERT INTO "public"."utilisateur"
		("username"
		,"password"
		,"nom"
		,"prenom")
	VALUES
		(pseudo_utilisateur
		,'123456'
		,nom_utilisateur
		,prenom_utilisateur);
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_addCommande"()
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
	DECLARE
	idCommnde integer;
	idFacture integer;
	numeroDerniereFacture varchar(50);
	BEGIN
	
	/* Creation de la commande */
	INSERT INTO "public"."commande"
		("datecommande"
		,"statutcommande")
	VALUES
		(current_date
		,'brouillon')
		RETURNING "commandeid" INTO idCommnde;
	
	/* Creation de la facture*/
	
	INSERT INTO "public"."facturecommande"
		("numerofacturecommande"
		,"montantfacturecommande"
		,"restefacturecommande"
		,"statutfacturecommande")
	VALUES
		(("public"."fn_genererNumeroFacture"((SELECT "numerofacturecommande" FROM "facturecommande" ORDER BY "facturecommandeid" DESC LIMIT 1)))
		,0
		,0
		,'brouillon')
		RETURNING "facturecommandeid" INTO idFacture;
	/*Ajout de la facture à la commande*/
	UPDATE "public"."commande"
	SET "facturecommandeid" = idFacture
	WHERE "commandeid"=idCommnde;
		
	RETURN idCommnde;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_addLivraisonProduitCommande"(idcommande integer, produitname character varying, puproduit integer, qtproduit integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	DECLARE
	 codeProduit integer;
	BEGIN
	
		/*Recuperation du code du produit*/
		select "produitid" INTO codeProduit from "produit" where "designation"=produitName;
			
		/*Ajout des produits à la commande*/
		INSERT INTO "public"."reception"
			("commandeid"
			,"produitid"
			,"quantitelivre"
			,"prixunitaire")
		VALUES
			(idcommande
			,codeProduit
			,qtproduit
			,puproduit);
		
		/*Mise à jour de la facture*/
		UPDATE "public"."facturecommande"
		SET "montantfacturecommande" = "montantfacturecommande"+(puProduit*qtProduit)
			,"restefacturecommande" = "restefacturecommande"+(puProduit*qtProduit)
			,"statutfacturecommande" = 'validé'
		WHERE "facturecommandeid"=(select "commande"."facturecommandeid" from "commande" where "commandeid"=idCommande);
		
		/*Mise à jour du prix unitaire produit*/
		UPDATE "public"."produit"
			SET "prixunitaire" = puproduit
		WHERE "produitid"= codeProduit;
		
		/*Mise à jour du niveau de stock du produit*/
		UPDATE "public"."stock"
		SET "quantitereel" = qtproduit
			,"quantitetheorique" = qtproduit
		WHERE "produitid" = codeProduit;
		
		/*Mise à jour du statut de la commande*/
		UPDATE "public"."commande"
	SET "statutcommande" = 'validé'
	WHERE "commandeid"= idcommande;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_addProduitInCommande"(idcommande integer, grossistename character varying, produitname character varying, puproduit integer, qtproduit integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
			
		/*Ajout des produits à la commande*/
		INSERT INTO "public"."concerne"
			("produitid"
			,"commandeid"
			,"quantitdemande"
			,"prixunitaire")
		VALUES
			((select "produitid" from "produit" where "designation"=produitName)
			,idCommande
			,qtProduit
			,puProduit);
			
		/*Ajout du grossiste à la commande*/
		UPDATE "public"."commande"
		SET "grossisteid" = (select "grossisteid" from "grossiste" where "nomgrossiste" = grossisteName)
		WHERE "commandeid"=idCommande;
		
		/*Mise à jour de la facture*/
		UPDATE "public"."facturecommande"
		SET "montantfacturecommande" = "montantfacturecommande"+(puProduit*qtProduit)
			,"restefacturecommande" = "restefacturecommande"+(puProduit*qtProduit)
		WHERE "facturecommandeid"=(select "commande"."facturecommandeid" from "commande" where "commandeid"=idCommande);
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_addProduitInVente"(idvente integer, clientid integer, produitname character varying, qtproduit integer, puproduit integer, remiseproduit integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
			
		/*Ajout des produits à la commande*/			
			INSERT INTO "public"."detailsvente"
				("produitid"
				,"venteid"
				,"date"
				,"quantite"
				,"remise")
			VALUES
				((select "produitid" from "produit" where "designation"=produitName)
				,idVente
				,current_date
				,qtProduit
				,remiseProduit);
			
		/*Ajout du client à la vente*/		
		UPDATE "public"."vente"
			SET "clientid" = clientId
		WHERE "venteid"= idVente;
		
		/*Mise à jour de la facture*/		
		UPDATE "public"."factureclient"
		SET "montantfactureclient" = "montantfactureclient"+(puProduit*qtProduit)
			,"restefactureclient" = "restefactureclient"+(puProduit*qtProduit)
		WHERE "factureclientid"= (select "vente"."factureclientid" from "vente" where "venteid"=idVente);
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_addVente"()
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
	DECLARE
	idVente integer;
	idFacture integer;
	numeroDerniereFacture varchar(50);
	BEGIN
	
	/* Creation de la vente */		
		INSERT INTO "public"."vente"
			("datevente"
			,"statutvente")
		VALUES
			(current_date
			,'brouillon')
		RETURNING "venteid" INTO idVente;
	
	/* Creation de la facture*/
		
		INSERT INTO "public"."factureclient"
			("numerofactureclient"
			,"montantfactureclient"
			,"restefactureclient"
			,"statutfactureclient"
			,"datefactureclient")
		VALUES
			(("public"."fn_genererNumeroFacture"((SELECT "numerofactureclient" FROM "factureclient" ORDER BY "factureclientid" DESC LIMIT 1)))
			,0
			,0
			,'brouillon'
			,current_date)
		RETURNING "factureclientid" INTO idFacture;
		
	/*Ajout de la facture à la commande*/
	UPDATE "public"."vente"
	SET "factureclientid" = idFacture
	WHERE "venteid"= idVente;
		
	RETURN idVente;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_delete_client(idclient integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		DELETE FROM "public"."client"
		WHERE "clientid"=idClient;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_delete_facture_client(id_facture_client integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		DELETE FROM "public"."factureclient"
		WHERE "factureclientid"=id_facture_client;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_delete_facture_commande(id_facture integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		DELETE FROM "public"."facturecommande"
		WHERE "facturecommandeid"=id_facture;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_delete_grossiste(id_grossiste integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		DELETE FROM "public"."grossiste"
		WHERE "grossisteid"=id_grossiste;
	END
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_delete_mutuelle(id_mutuelle integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		DELETE FROM "public"."mutuelle"
		WHERE "mutuelleid" = id_mutuelle;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_delete_produit(idproduit integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		DELETE FROM "public"."produit"
		WHERE "produitid" = idProduit;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_delete_type_produit(id_type_produit integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		DELETE FROM "public"."typeproduit"
		WHERE "typeproduitid"= id_type_produit;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_get_mutuelle_by_name(libelle character varying)
 RETURNS SETOF mutuelle
 LANGUAGE plpgsql
AS $function$
	DECLARE
	ligne RECORD;
	BEGIN
		FOR ligne IN 
			select *
			from "mutuelle"
			where "nommutuelle"=libelle
		LOOP
			RETURN NEXT ligne;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_get_produit_atteint_seuil(id_produit integer)
 RETURNS SETOF produit
 LANGUAGE plpgsql
AS $function$
	DECLARE
	ligne RECORD;
	BEGIN
		FOR ligne IN 
			select *
			from "produit"
			where "produitid"=(
				select produitid
				from "stock"
				where "quantitetheorique" = 1)
		LOOP
			RETURN NEXT ligne;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_get_produit_by_name(libelle character varying)
 RETURNS SETOF produit
 LANGUAGE plpgsql
AS $function$
	DECLARE
	ligne RECORD;
	BEGIN
		FOR ligne IN 
			select *
			from "produit"
			where "designation"=libelle
		LOOP
			RETURN NEXT ligne;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getAllFactureFournisseur"()
 RETURNS TABLE(numero character varying, datefac date, grossistefac character varying, montantfac integer)
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		FOR numero, datefac, grossistefac, montantfac IN
		
			SELECT "numerofacturecommande", to_date(cast(current_date as TEXT), 'YYYY/MM/DD'), "nomgrossiste", "montantfacturecommande"
			FROM "facturecommande" INNER JOIN "commande" ON "facturecommande"."facturecommandeid"= "commande"."facturecommandeid"
							INNER JOIN "grossiste" ON "grossiste"."grossisteid"="commande"."grossisteid"
		LOOP
			RETURN NEXT;
		END LOOP;
		RETURN;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getAllMutuelle"()
 RETURNS SETOF mutuelle
 LANGUAGE plpgsql
AS $function$
	DECLARE
	ligne RECORD;
	BEGIN
		FOR ligne IN 
			select * from "mutuelle"
		LOOP 
	  		 RETURN NEXT ligne;
	   	END LOOP;
	   	RETURN;
		
	END;
	
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getclientByID"(idc integer)
 RETURNS TABLE(id integer, nom character varying, prenom character varying, tel character varying, mutuelle character varying)
 LANGUAGE plpgsql
AS $function$
	BEGIN
		FOR id, nom, prenom, tel, mutuelle IN 
			select 
			 "clientid", "nomclient", "prenomclient", "telclient", "nommutuelle"
				from "client"
			INNER JOIN "mutuelle" ON "mutuelle"."mutuelleid"="client"."mutuelleid"
			WHERE "client"."clientid"=idC
		LOOP 
	  		 RETURN NEXT;
	   	END LOOP;
	   	RETURN;
		
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_getclients()
 RETURNS TABLE(id integer, nom character varying, prenom character varying, tel character varying, mutuelle character varying)
 LANGUAGE plpgsql
AS $function$
	BEGIN
		FOR id, nom, prenom, tel, mutuelle IN 
			select 
			 "clientid", "nomclient", "prenomclient", "telclient", "nommutuelle"
				from "client"
			INNER JOIN "mutuelle" ON "mutuelle"."mutuelleid"="client"."mutuelleid"
		LOOP 
	  		 RETURN NEXT;
	   	END LOOP;
	   	RETURN;
		
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_getformeproduits()
 RETURNS SETOF forme
 LANGUAGE plpgsql
AS $function$
	DECLARE
	ligne RECORD;
	BEGIN
		FOR ligne IN select * from "forme" LOOP
			RETURN NEXT ligne;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getGrossiste"()
 RETURNS SETOF grossiste
 LANGUAGE plpgsql
AS $function$
	DECLARE
	ligne RECORD;
	BEGIN
		FOR ligne IN select * from "grossiste" LOOP
			RETURN NEXT ligne;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getGrossisteById"(id integer)
 RETURNS SETOF grossiste
 LANGUAGE plpgsql
AS $function$
DECLARE
  ligne record;
	BEGIN
	
		FOR ligne IN SELECT * FROM "grossiste" WHERE "grossisteid"=id LOOP
        RETURN NEXT ligne;
    END LOOP;
    RETURN;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_getmutuelles()
 RETURNS SETOF mutuelle
 LANGUAGE plpgsql
AS $function$
	DECLARE
	ligne RECORD;
	BEGIN
		FOR ligne IN select * from "mutuelle" LOOP
			RETURN NEXT ligne;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getProduitPourCommande"()
 RETURNS TABLE(nomproduits character varying, typeproduits character varying, formeproduits character varying, codeproduits character varying, seuilproduits integer, puproduits integer, dateproduits date)
 LANGUAGE plpgsql
AS $function$
	BEGIN
		FOR nomProduits, typeProduits, formeProduits, codeProduits, seuilProduits, puProduits, dateProduits IN
		
			SELECT DISTINCT "designation", "libelletype", "libelleforme", "code", "seuil", "prixunitaire", to_date(cast("dateperemption" as TEXT), 'YYYY/MM/DD')
			FROM "produit" INNER JOIN "forme" ON "produit"."formeid"= "forme"."formeid"
						   INNER JOIN "typeproduit" ON "typeproduit"."typeproduitid"="produit"."typeproduitid"
						   INNER JOIN "stock" ON "stock"."produitid"="produit"."produitid"
		LOOP
			RETURN NEXT;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getProduits"()
 RETURNS TABLE(nomproduits character varying, typeproduits character varying, formeproduits character varying, codeproduits character varying, seuilproduits integer, puproduits integer, dateproduits date)
 LANGUAGE plpgsql
AS $function$
	BEGIN
		FOR nomProduits, typeProduits, formeProduits, codeProduits, seuilProduits, puProduits, dateProduits IN
		
			SELECT DISTINCT "designation", "libelletype", "libelleforme", "code", "seuil", "prixunitaire", to_date(cast("dateperemption" as TEXT), 'YYYY/MM/DD')
			FROM "produit" INNER JOIN "forme" ON "produit"."formeid"= "forme"."formeid"
						   INNER JOIN "typeproduit" ON "typeproduit"."typeproduitid"="produit"."typeproduitid"
						   INNER JOIN "stock" ON "stock"."produitid"="produit"."produitid"
		LOOP
			RETURN NEXT;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getProduitsAVendre"()
 RETURNS TABLE(nomproduits character varying, typeproduits character varying, formeproduits character varying, codeproduits character varying, seuilproduits integer, puproduits integer, dateproduits date, quantiteproduit integer)
 LANGUAGE plpgsql
AS $function$
	BEGIN
		FOR nomProduits, typeProduits, formeProduits, codeProduits, seuilProduits, puProduits, dateProduits, quantiteProduit IN
		
			SELECT DISTINCT "designation", "libelletype", "libelleforme", "code", "seuil", "prixunitaire", to_date(cast("dateperemption" as TEXT), 'YYYY/MM/DD'), "quantitetheorique"
			FROM "produit" INNER JOIN "forme" ON "produit"."formeid"= "forme"."formeid"
						   INNER JOIN "typeproduit" ON "typeproduit"."typeproduitid"="produit"."typeproduitid"
						   INNER JOIN "stock" ON "stock"."produitid"="produit"."produitid"
		LOOP
			RETURN NEXT;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_gettypeproduits()
 RETURNS SETOF typeproduit
 LANGUAGE plpgsql
AS $function$
	DECLARE
	ligne RECORD;
	BEGIN
		FOR ligne IN select * from "typeproduit" LOOP
			RETURN NEXT ligne;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getUserByUsername"(usernam character varying)
 RETURNS SETOF utilisateur
 LANGUAGE plpgsql
AS $function$
DECLARE
  ligne record;
	BEGIN
	
		FOR ligne IN SELECT * FROM "utilisateur" WHERE "username"=usernam LOOP
        RETURN NEXT ligne;
    END LOOP;
    RETURN;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_getUtilisateurs"()
 RETURNS SETOF utilisateur
 LANGUAGE plpgsql
AS $function$
DECLARE
  ligne record;
BEGIN
    FOR ligne IN SELECT * FROM "utilisateur" LOOP
        RETURN NEXT ligne;
    END LOOP;
    RETURN;
    
END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_listeCommandeAReceptionne"()
 RETURNS TABLE(idcmd integer, datecmd date, statutcmd character varying, grossistecmd character varying, nbrproduits integer, montantcmd integer)
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		FOR idCmd, dateCmd, statutCmd, grossisteCmd, nbrProduits, montantCmd IN
		
			SELECT "commande"."commandeid", to_date(cast("datecommande" as TEXT), 'YYYY/MM/DD'), "statutcommande", "nomgrossiste", COUNT("produitid"), "public"."fn_montantCommandeFournisseur"("commande"."commandeid")
			FROM "commande" INNER JOIN "concerne" ON "commande"."commandeid"= "concerne"."commandeid"
							INNER JOIN "grossiste" ON "grossiste"."grossisteid"="commande"."grossisteid"
			WHERE "statutcommande"='brouillon'
			GROUP BY "commande"."commandeid","grossiste"."grossisteid"
			ORDER BY "commande"."commandeid"
		LOOP
			RETURN NEXT;
		END LOOP;
		RETURN;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_listeCommandeFournisseur"()
 RETURNS TABLE(idcmd integer, datecmd date, statutcmd character varying, grossistecmd character varying, nbrproduits integer, montantcmd integer)
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		FOR idCmd, dateCmd, statutCmd, grossisteCmd, nbrProduits, montantCmd IN
		
			SELECT "commande"."commandeid", to_date(cast("datecommande" as TEXT), 'YYYY/MM/DD'), "statutcommande", "nomgrossiste", COUNT("produitid"), "public"."fn_montantCommandeFournisseur"("commande"."commandeid")
			FROM "commande" INNER JOIN "concerne" ON "commande"."commandeid"= "concerne"."commandeid"
							INNER JOIN "grossiste" ON "grossiste"."grossisteid"="commande"."grossisteid"
			GROUP BY "commande"."commandeid","grossiste"."grossisteid"
			ORDER BY "commande"."commandeid"
		LOOP
			RETURN NEXT;
		END LOOP;
		RETURN;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_listeProduitCommandeFournisseur"(idcmd integer)
 RETURNS TABLE(libelleprod character varying, qtproduit integer, puproduit integer)
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		FOR libelleProd, qtProduit, puProduit IN
		
			SELECT "designation", "concerne"."quantitdemande","concerne"."prixunitaire"
			FROM "concerne" INNER JOIN "produit" ON "concerne"."produitid"= "produit"."produitid"
			WHERE "commandeid"=idCmd
		LOOP
			RETURN NEXT;
		END LOOP;
		RETURN;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_login(utilisateurs character varying, mot_de_passe character varying)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
declare cnt integer;
begin
 select count(*) into cnt from "public"."utilisateur" where "public"."utilisateur"."username" = utilisateurs
 	and "public"."utilisateur"."password" = mot_de_passe;
 return cnt;
 end;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_template_select_all()
 RETURNS SETOF client
 LANGUAGE plpgsql
AS $function$
	DECLARE
	ligne RECORD;
	BEGIN
		FOR ligne IN select * from "client" LOOP
			RETURN NEXT ligne;
		END LOOP;
		RETURN;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_update_client(idclient integer, nom_client character varying, prenom_client character varying, telephone_client character varying, nom_mutuelle character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	UPDATE "public"."client"
	SET "mutuelleid" = (SELECT "mutuelleid" FROM "mutuelle" WHERE "nommutuelle"=nom_mutuelle)
		,"nomclient" = nom_client
		,"prenomclient" = prenom_client
		,"telclient" = telephone_client
	WHERE "clientid"=idClient;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_update_facture_client(id_facture_client integer, numero_facture_client character varying, montant_facture_client character varying, reste_facture_client integer, statut_facture_client character varying, date_facture_client character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		UPDATE "public"."factureclient"
	SET "numerofactureclient" = numero_facture_client
		,"montantfactureclient" = montant_facture_client
		,"restefactureclient" = reste_facture_client
		,"statutfactureclient" = statut_facture_client
		,"datefactureclient" = date_facture_client
	WHERE "factureclientid"=id_facture_client;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_update_facture_commande(id_facture_commande integer, id_commande integer, numero_facture_commande character varying, montant integer, reste integer, statut character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
	UPDATE "public"."facturecommande"
		SET "commlandeid" = id_commande
			,"numerofacturecommande" = numero_facture_commande
			,"montantfacturecommande" = montant
			,"restefacturecommande" = reste
			,"statutfacturecommande" = statut
	WHERE "facturecommandeid"=id_facture_commande;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_update_grossiste(id_grossiste integer, nom_grossiste character varying, telephone_grossiste character varying, adresse_grossiste text)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		UPDATE "public"."grossiste"
	SET "nomgrossiste" = nom_grossiste
		,"telgrossiste" = telephone_grossiste
		,"adressegrossister" = adresse_grossiste
	WHERE "grossisteid"=id_grossiste;
	END
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_update_mutuelle(id_mutuelle integer, nom_mutuelle character varying, phone_mutuelle character varying, adresse_mutuelle character varying, email_mutuelle character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
		UPDATE "public"."mutuelle"
	SET "nommutuelle" = nom_mutuelle
		,"phonemutuelle" = phone_mutuelle
		,"adressemutuelle" = adresse_mutuelle
		,"emailmutuelle" = email_mutuelle
	WHERE "mutuelleid" = id_mutuelle;
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_update_produit(idproduit integer, designationproduit character varying, formeproduit character varying, typeproduit character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		UPDATE "public"."produit"
	SET "typeproduitid" = (SELECT "typeproduitid" FROM "typeproduit" WHERE "libelletype" =typeProduit)
		,"designation" = designationProduit
		,"forme" = formeProduit
	WHERE "produitid" =idProduit;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_update_type_produit(id_type_produit integer, libelle character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
	BEGIN
	
		UPDATE "public"."typeproduit"
	SET "libelletype" = libelle
	WHERE "typeproduitid" = id_type_produit;
	
	END;
$function$
GO

CREATE OR REPLACE FUNCTION public.ps_update_user_password(usernme character varying, oldpassword character varying, newpassword character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
 BEGIN
    UPDATE "public"."utilisateur"
	SET "password" = newpassword
	WHERE "username" = usernme and "password" = oldpassword;
 END;
$function$
GO

CREATE OR REPLACE FUNCTION public."ps_updateUser"(usernam character varying, nm character varying, prenm character varying, newusername character varying)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN
	UPDATE "public"."utilisateur"
	SET "username" = newusername
		,"nom" = nm
		,"prenom" = prenm
	WHERE "username"=usernam;
END;
$function$
GO
