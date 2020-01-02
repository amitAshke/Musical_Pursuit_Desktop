package com.example.dbcourse.Musical_Pursuit.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSonsDtlGetter {
    private Connection conn;

    public DBSonsDtlGetter(Connection conn) {
        this.conn = conn;
    }


    //TODO: gets with SQL queries details of song requested.
    public void demoExecuteQuery() {

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM country");) {

            while (rs.next() == true) {
                System.out.print(rs.getInt("COUNTRY_ID"));
                System.out.print("\t");
                System.out.print(rs.getString("COUNTRY"));
                System.out.print("\t");
                System.out.print(rs.getString(3));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("ERROR executeQuery - " + e.getMessage());
        }
    }
}
