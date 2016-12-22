package com.example.luissam.mit.Conexion;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que realiza la conexion
 * a SQl server, misma devuelve
 * la variable conn;
 *
 *
 * Created by luissam
 * @samanocedillo
 * on 12-02-16.
 */

public class CONN {

    Connection conn = null;
    String ConnURL = null;

    @SuppressLint("NewApi")
    public Connection CONN() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://172.16.16.7:1433/dbMatrizIT;instance=SQLEXPRESS;user=sa;password=sysserver;";
            conn = DriverManager.getConnection(ConnURL);

        } catch (SQLException se) {
            Log.e("ERRO1",se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO2",e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO3",e.getMessage());
        }

        return conn;
    }//public Connection CONN()


    public void CloseConn () {

        try {

            conn.close();

        }catch (SQLException se) {
            Log.e("ERRO1",se.getMessage());
        }


    }//public void CloseConn ()


}