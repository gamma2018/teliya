package com.example.sad.tpharma.metier.traitement;

import com.example.sad.tpharma.metier.ConnexionDB;
import com.example.sad.tpharma.metier.Partager;
import com.example.sad.tpharma.metier.entite.Client;
import com.example.sad.tpharma.metier.entite.FamilleProduit;
import com.example.sad.tpharma.metier.entite.Grossiste;
import com.example.sad.tpharma.metier.entite.Mutuelle;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.entite.User;
import com.example.sad.tpharma.metier.entite.Utilisateur;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        sql ="{ CALL \"public\".\"ps_add_produit\"(?,?,?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, produit.getDesignation());
            cs.setInt(2, produit.getPu());
            cs.setInt(3, produit.getQuantiteInitial());
            cs.setString(4, produit.getDatePremption());
            cs.setString(5, produit.getLibelleType());
            cs.setString(6, produit.getCode());
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
            cs.setString(2, produit.getDesignation());
            cs.setString(3, produit.getNomForme());
            cs.setString(4, produit.getLibelleType());
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
                   produit = new Produit(rs.getString("designation"), rs.getInt("pu"), rs.getInt("qd"), String.valueOf(rs.getDate("dateperemption")),rs.getString("code"));

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
                    listMutuelle.add(rs.getString("mutuelle"));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listMutuelle;
    }
}
