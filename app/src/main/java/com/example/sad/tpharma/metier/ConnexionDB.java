package com.example.sad.tpharma.metier;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDB {
    private Connection con;



    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public boolean connexion()
    {
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            String driver = "org.postgresql.Driver";
            Class.forName(driver).newInstance();
            String conString = "jdbc:postgresql://10.10.10.24:5432/TelyaDB";
            setCon(DriverManager.getConnection(conString, "Telya", "123456789"));
            return true;

        }catch (Exception e)
        {
            e.getMessage();
            return false;
        }


    }
}
