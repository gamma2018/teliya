package com.example.sad.tpharma.metier.traitement;

import com.example.sad.tpharma.metier.ConnexionDB;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Client;
import com.example.sad.tpharma.metier.entite.Commande;
import com.example.sad.tpharma.metier.entite.FactureGrossiste;
import com.example.sad.tpharma.metier.entite.FamilleProduit;
import com.example.sad.tpharma.metier.entite.Grossiste;
import com.example.sad.tpharma.metier.entite.Mutuelle;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.entite.ProduitCommande;
import com.example.sad.tpharma.metier.entite.User;
import com.example.sad.tpharma.metier.entite.Utilisateur;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model {

    ConnexionDB con;
    ResultSet rs = null;
    CallableStatement cs;
    String sql;

    public int login(String username, String password)
    {
        con = new ConnexionDB();
        con.connexion();
        sql = "{CALL \"public\".\"ps_login\" (?,?)}";
        int count = 0;

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, username);
            cs.setString(2, password);
            rs = cs.executeQuery();

            if (rs.next())
                {
                    count = rs.getInt("result");
                    if (count>0)
                        Partager.setUsername(username);
                        Partager.setPassword(password);
                }

        }catch (SQLException e)
        {
            e.getMessage();
        }
        return count;
    }
    public void addUser(Utilisateur user)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_add_utilisateur\"(?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, user.getNomUtilisateur());
            cs.setString(2, user.getPrenomUtilisateur());
            cs.setString(3, user.getUsername());
            cs.setString(4, user.getPassword());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addClient(Client client)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_add_client\"(?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, client.getNomClient());
            cs.setString(2, client.getPrenomClient());
            cs.setString(3, client.getTelClient());
            cs.setString(4, client.getNomMutuelle());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateClient(int id, Client client)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_update_client\"(?,?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, id);
            cs.setString(2, client.getNomClient());
            cs.setString(3, client.getPrenomClient());
            cs.setString(4, client.getTelClient());
            cs.setString(5, client.getNomMutuelle());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteClient(int clientID)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_delete_client\"(?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, clientID);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addMutuelle(Mutuelle mutuelle)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_add_mutuelle\"(?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, mutuelle.getNomMutuelle());
            cs.setString(2, mutuelle.getPhoneMutuelle());
            cs.setString(3, mutuelle.getAdresseMutuelle());
            cs.setString(4, mutuelle.getEmailMutuelle());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMutuelle(int mutuelleID, Mutuelle mutuelle)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_update_mutuelle\"(?,?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, mutuelleID);
            cs.setString(2, mutuelle.getNomMutuelle());
            cs.setString(3, mutuelle.getPhoneMutuelle());
            cs.setString(4, mutuelle.getAdresseMutuelle());
            cs.setString(5, mutuelle.getEmailMutuelle());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteMutuelle(int mutuelleID)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_delete_mutuelle\"(?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, mutuelleID);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addGrossiste(Grossiste grossiste)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_add_grossiste\"(?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, grossiste.getLibelle());
            cs.setString(2, grossiste.getTelephone());
            cs.setString(3, grossiste.getAdresse());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Grossiste> getAllGrossiste()
    {
        ArrayList<Grossiste> listGrossite = new ArrayList<Grossiste>();
        Grossiste grossiste;

        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_getGrossiste\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next())
            {
                do {
                    grossiste = new Grossiste(rs.getInt("grossisteid") , rs.getString("nomgrossiste"), rs.getString("telgrossiste"), rs.getString("adressegrossister"));
                    listGrossite.add(grossiste);
                }while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Fermeture de la base de données.
        try {
            con.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listGrossite;
    }

    public ArrayList<String > getAllGrossiste_()
    {
        ArrayList<Grossiste> listGrossite1 = new ArrayList<Grossiste>();
        Grossiste grossiste1;

        ArrayList<String > listGrossite = new ArrayList<String >();
        String grossiste;

        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_getGrossiste\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next())
            {
                do {
                    grossiste1 = new Grossiste(rs.getInt("grossisteid") , rs.getString("nomgrossiste"), rs.getString("telgrossiste"), rs.getString("adressegrossister"));
                    listGrossite1.add(grossiste1);

                    grossiste = rs.getString("nomgrossiste");
                    listGrossite.add(grossiste);
                }while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Fermeture de la base de données.
        try {
            con.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Partager.setListeGrossite(listGrossite1);
        return  listGrossite;
    }


    public void updateGrossiste(int id, Grossiste grossiste)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{CALL \"public\".\"ps_update_grossiste\" (?,?,?,?)}";

        try {

            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, id);
            cs.setString(2, grossiste.getLibelle());
            cs.setString(3, grossiste.getTelephone());
            cs.setString(4, grossiste.getAdresse());
            cs.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String username, User user)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{CALL \"public\".\"ps_updateUser\" (?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, username);
            cs.setString(2, user.getFirstName());
            cs.setString(3, user.getLastName());
            cs.setString(4, user.getUsername());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeUserPassword(String username, String oldPassword, String newPassword)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{CALL \"public\".\"ps_update_user_password\" (?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, username);
            cs.setString(2, oldPassword);
            cs.setString(3, newPassword);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<User> getAllUser()
    {
        ArrayList<User> user = new ArrayList<User>();
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getUtilisateurs\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();

            if (rs.next())
            {
                do {
                    user.add(new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("username"), rs.getString("password")));
                }while (rs.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void addProduit(Produit produit)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_add_produit\"(?,?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, produit.getLibelleProduit());
            cs.setString(2, produit.getType());
            cs.setString(3, produit.getNomForme());
            cs.setString(4, produit.getCode());
            cs.setInt(5, produit.getSuil());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateProduit(int Produitcode, Produit produit)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_add_produit\"(?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, Produitcode);
           // cs.setString(2, produit.getDesignation());
            cs.setString(3, produit.getNomForme());
            //cs.setString(4, produit.getLibelleType());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Produit> getAllProduit()
    {
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getProduits\"}";
        ArrayList<Produit> listeProd = new ArrayList<Produit>();
        Produit produit;

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next())
            {
               do {
                   produit = new Produit( rs.getString("nomProduits"),
                                          rs.getString("typeProduits"),
                                          rs.getString("formeProduits"),
                                          rs.getString("codeProduits"),
                                          rs.getInt("seuilProduits"),
                                          rs.getInt("puProduits"),
                                          rs.getString("dateProduits")
                                        );
                   listeProd.add(produit);

               }while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeProd;
    }

    //Famille de produit
    public void addFamille(FamilleProduit familleProduit)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_add_type_produit\"(?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, familleProduit.getNom());

            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateFamille(int idFamille, FamilleProduit familleProduit)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_add_produit\"(?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
           /* cs.setInt(1, Produitcode);
            cs.setString(2, produit.getDesignation());
            cs.setString(3, produit.getNomForme());
            cs.setString(4, produit.getLibelleType());*/
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<FamilleProduit> getAllFamily()
    {
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getProduits\"}";
        ArrayList<FamilleProduit> listeProd = new ArrayList<FamilleProduit>();
        FamilleProduit familleProduit;

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next())
            {
                do {
                /*    familleProduit = new Produit(rs.getString("designation"), rs.getInt("pu"), rs.getInt("qd"), String.valueOf(rs.getDate("dateperemption")),rs.getString("code"));

                        listeProd.add(familleProduit);*/

                }while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeProd;
    }

    public User getUserByUsername(String userName)
    {
        User user = new User();
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getUserByUsername\"(?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, userName);
            rs = cs.executeQuery();

            if (rs.next())
            {

                    user = new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("username"), rs.getString("password"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    //Get grossiste by id
    public Grossiste getGrossisteById(int id)
    {
        Grossiste grossiste = new Grossiste();
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getGrossisteById\"(?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1,  id);
            rs = cs.executeQuery();

            if (rs.next())
            {

                grossiste = new Grossiste(rs.getInt("grossisteid"), rs.getString("nomgrossiste"), rs.getString("adressegrossister"), rs.getString("telgrossiste") );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return grossiste;
    }

    public ArrayList<Client> getAllClient()
    {
        ArrayList<Client> client = new ArrayList<Client>();
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getclients\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();

            if (rs.next())
            {
                do {
                    client.add(
                            new Client(
                                    rs.getInt("id"),
                                    rs.getString("mutuelle"),
                                    rs.getString("nom"),
                                    rs.getString("prenom"),
                                    rs.getString("tel")
                                    ));
                }while (rs.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public ArrayList<String> getAllClients()
    {
        ArrayList<String> client = new ArrayList<String>();
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getclients\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();

            if (rs.next())
            {
                do {
                    client.add(     rs.getString("nom")+" "+
                                    rs.getString("prenom")
                              );
                }while (rs.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    //Get grossiste by id
    public Client getClientByID(int id)
    {
        Client client = new Client();
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getclientByID\"(?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1,  id);
            rs = cs.executeQuery();

            if (rs.next())
            {

                client = new Client(rs.getInt("id"), rs.getString("mutuelle"), rs.getString("nom"), rs.getString("prenom"), rs.getString("tel"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public ArrayList<String> getAllMutuelle() {
        ArrayList<String> listMutuelle = new ArrayList<String>();


        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getAllMutuelle\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                do {
                    listMutuelle.add(rs.getString("nommutuelle"));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listMutuelle;
    }

    public ArrayList<Mutuelle> getAllMutuelles() {
        ArrayList<Mutuelle> listMutuelle = new ArrayList<Mutuelle>();

        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getAllMutuelle\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                do {
                    listMutuelle.add(
                            new Mutuelle(
                                    rs.getInt("mutuelleid"),
                                    rs.getString("nommutuelle"),
                                    rs.getString("phonemutuelle"),
                                    rs.getString("adressemutuelle"),
                                    rs.getString("emailmutuelle")
                            ));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listMutuelle;
    }

    public Mutuelle getMutuelleByName(String name)
    {
        Mutuelle mutuelle = new Mutuelle();
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_get_mutuelle_by_name\"(?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1,  name);
            rs = cs.executeQuery();

            if (rs.next())
            {

                mutuelle = new Mutuelle(rs.getInt("mutuelleid"), rs.getString("nommutuelle"), rs.getString("phonemutuelle"), rs.getString("adressemutuelle"), rs.getString("emailmutuelle"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mutuelle;
    }
    public ArrayList<String> getAllTypeProduits() {
        ArrayList<String> listTypeProduits = new ArrayList<String>();


        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_gettypeproduits\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                do {
                    listTypeProduits.add(rs.getString("libelletype"));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listTypeProduits;
    }

    public ArrayList<String> getAllFormeProduits() {
        ArrayList<String> listFormeProduits = new ArrayList<String>();


        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getformeproduits\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                do {
                    listFormeProduits.add(rs.getString("libelleforme"));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listFormeProduits;
    }

    public int addCommande()
    {
        con = new ConnexionDB();
        int id = 0;
        con.connexion();
        sql ="{ CALL \"public\".\"ps_addCommande\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                id = rs.getInt("result");
            }
            cs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public void addProduitCommande(ProduitCommande produitCommande)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_addProduitInCommande\"(?,?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, produitCommande.getIdCommande());
            cs.setString(2, produitCommande.getGrossiste());
            cs.setString(3, produitCommande.getProduit());
            cs.setInt(4, produitCommande.getPrixUnitaire());
            cs.setInt(5, produitCommande.getQuantite());

            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Produit> getAllProduitAVendre()
    {
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getProduitsAVendre\"}";
        ArrayList<Produit> listeProd = new ArrayList<Produit>();
        Produit produit;

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next())
            {
                do {
                    produit = new Produit( rs.getString("nomProduits"),
                            rs.getString("typeProduits"),
                            rs.getString("formeProduits"),
                            rs.getString("codeProduits"),
                            rs.getInt("seuilProduits"),
                            rs.getInt("puProduits"),
                            rs.getString("dateProduits"),
                            rs.getInt("quantiteProduit")
                    );
                    listeProd.add(produit);

                }while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeProd;
    }
    public ArrayList<Commande> getAllCommande() {
        ArrayList<Commande> listCommande = new ArrayList<Commande>();

        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_listeCommandeFournisseur\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                do {
                    listCommande.add(
                            new Commande(
                                    rs.getInt("idCmd"),
                                    rs.getString("dateCmd"),
                                    rs.getString("statutCmd"),
                                    rs.getString("grossisteCmd"),
                                    rs.getInt("nbrProduits"),
                                    rs.getInt("montantCmd")
                            ));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listCommande;
    }

    public ArrayList<Commande> getAllCommandeAReceptionne() {
        ArrayList<Commande> listCommande = new ArrayList<Commande>();

        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_listeCommandeAReceptionne\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                do {
                    listCommande.add(
                            new Commande(
                                    rs.getInt("idCmd"),
                                    rs.getString("dateCmd"),
                                    rs.getString("statutCmd"),
                                    rs.getString("grossisteCmd"),
                                    rs.getInt("nbrProduits"),
                                    rs.getInt("montantCmd")
                            ));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listCommande;
    }

    public ArrayList<Produit> getAllProduitCommandeFournisseur(int commande)
    {
        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_listeProduitCommandeFournisseur\"(?)}";
        ArrayList<Produit> listeProd = new ArrayList<Produit>();
        Produit produit;

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, commande);
            rs = cs.executeQuery();
            if (rs.next())
            {
                do {
                    produit = new Produit( rs.getString("libelleProd"),
                            rs.getInt("puProduit"),
                            rs.getInt("qtProduit")
                    );
                    listeProd.add(produit);

                }while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeProd;
    }
    public void livraisonCommande(int idCommande, List<Produit> produit)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{ CALL \"public\".\"ps_addLivraisonProduitCommande\"(?,?,?,?)}";

        try {
            for (int i=0;i<produit.size();i++) {
                cs = con.getCon().prepareCall(sql);
                cs.setInt(1, idCommande);
                cs.setString(2, produit.get(i).getLibelleProduit());
                cs.setInt(3, produit.get(i).getPu());
                cs.setInt(4, produit.get(i).getQuantite());

                cs.executeUpdate();
            }
            cs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<FactureGrossiste> getFactureGrossiste() {
        ArrayList<FactureGrossiste> listFacture = new ArrayList<FactureGrossiste>();

        con = new ConnexionDB();
        con.connexion();
        sql = "{ CALL \"public\".\"ps_getAllFactureFournisseur\"}";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next()) {
                do {
                    listFacture.add(
                            new FactureGrossiste(
                                    rs.getString("numero"),
                                    rs.getInt("montantfac"),
                                    rs.getString("datefac"),
                                    rs.getString("grossistefac")
                            ));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listFacture;
    }
}
