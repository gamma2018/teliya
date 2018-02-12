package com.example.sad.tpharma.metier.traitement;

import com.example.sad.tpharma.metier.ConnexionDB;
import com.example.sad.tpharma.metier.entite.Grossiste;
import com.example.sad.tpharma.metier.entite.Produit;
import com.example.sad.tpharma.metier.entite.User;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class model {

    ConnexionDB con;
    ResultSet rs = null;
    CallableStatement cs;
    String sql;

    public int login(String username, String password)
    {
        con = new ConnexionDB();
        con.connexion();
        sql = "{? = CALL \"public\".\"ps_login\" (?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, username);
            cs.setString(2, password);
            rs = cs.executeQuery();

            if (rs.next())
                {
                    return rs.getInt("log");
                }

        }catch (SQLException e)
        {
            e.getMessage();
        }
        return 1;
    }
    public void addUser(User user)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="{?= CALL \"public\".\"ps_add_user\"(?,?,?,?)}";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, user.getFirstName());
            cs.setString(2, user.getLastName());
            cs.setString(3, user.getUsername());
            cs.setString(4, user.getPrivilege());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(User user)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="ICI LA REQUETE";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, user.getFirstName());
            cs.setString(2, user.getLastName());
            cs.setString(3, user.getUsername());
            cs.setString(4, user.getPrivilege());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void changeUserPassword(String username)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="ICI LA REQUETE";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, username);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addProduit(Produit produit)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="ICI LA REQUETE";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, produit.getCode());
            cs.setString(2, produit.getLibelle());
            cs.setInt(3, produit.getPrixUnitaire());
            cs.setInt(4, produit.getQuantite());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateProduit(int code)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="ICI LA REQUETE";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setInt(1, code);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getAllProduit()
    {
        con = new ConnexionDB();
        con.connexion();
        sql = "ICI LA REQUETE";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next())
            {
                //recuperation
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addGrossiste(Grossiste grossiste)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="ICI LA REQUETE";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, grossiste.getLibelle());
            cs.setString(2, grossiste.getAdresse());
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getAllGrossiste()
    {
        con = new ConnexionDB();
        con.connexion();
        sql = "ICI LA REQUETE";

        try {
            cs = con.getCon().prepareCall(sql);
            rs = cs.executeQuery();
            if (rs.next())
            {
                //recuperation
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateGrossiste(String code)
    {
        con = new ConnexionDB();
        con.connexion();
        sql ="ICI LA REQUETE";

        try {
            cs = con.getCon().prepareCall(sql);
            cs.setString(1, code);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
