package org.musical_pursuit.services.db;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.musical_pursuit.services.src.objects.Song;
import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;

/**
 * this class will create our db tables and fill them in from the csv file using SQL queries.
 * then SongBlob class will use it to getRandomly according to attributes our questions and
 * answers.
 */

public class JDBC {
    Connection conn; // DB connection

    /**
     * constructor
     */
    public JDBC() {
        this.conn = null;
    }

    /**
     * @return true if the connection was successfully set
     */
    /*TODO: here config file connection details*/
    public Connection openConnection(String configFileName /*"src/main/resources/application.properties"*/) {

        String host = "";
        String port = "";
        String schema = "";
        String user = "";
        String password = "";

        System.out.print("Trying to connect... ");

        try (InputStream input = new FileInputStream(configFileName)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // creating the connection. Parameters should be taken from config file.
            host = prop.getProperty("host").toString();
            port = prop.getProperty("port").toString();
            schema = prop.getProperty("schema").toString();
            user = prop.getProperty("user").toString();
            password = prop.getProperty("password").toString();

        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO: end program...
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + schema
                    + "?serverTimezone=UTC", user, password);
        } catch (SQLException e) {
            System.out.println("Unable to connect - " + e.getMessage());
            return null;
        }
        System.out.println("Connected!");
        return this.conn;
    }

    /*Assuming db already exists, this function will create the 3 tables
     * we need with all primary keys and foreign keys
     */
    public void createDB() throws IOException, SqlToolError {

        SqlFile sf = new SqlFile(new File(
                "src/main/java/com/example/dbcourse/Musical_Pursuit/db/musical_db_creator.sql"));
        sf.setConnection(conn);
        try {
            sf.execute();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void fillDBfromCSV(String csvFileName) throws IOException, SqlToolError {

        int result;

        //TODO: open csv file
//        try {
//
//            CSVLoader loader = new CSVLoader(getCon());
//
//            loader.loadCSV("C:\\employee.sql", "CUSTOMER", true);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //TODO: genereate musical_db_creator.sql

        //TODO: insert with SQL queries all details from csv to db here:
        try (Statement stmt = conn.createStatement();) {
            result = stmt.executeUpdate("INSERT INTO (fname, lname) " + "VALUES('Emma','Stone')");
            result = stmt.executeUpdate("INSERT INTO demo(fname, lname) " + "VALUES('Ryan','Gosling')");
            // result = stmt.executeUpdate("DELETE FROM demo");
            System.out.println("Success - executeUpdate, result = " + result);

        } catch (SQLException e) {
            System.out.println("ERROR executeUpdate - " + e.getMessage());
        }
    }

    /* @param context: background for the question,
     *e.g. artist of a question about who composed this song
     * @param about: the right answer
     * @param correctAmount:
     * @param wrongAmount:
     * @return: HashMap with list of right answers as song objects (and key 1 e.g.)
     *  and list of wrong answers as song objects (and key 0 e.g.)
     */
    public HashMap<Integer, List<Song>> getSongsDtl(int context, int about, int correctAmount, int wrongAmount ) {

        // Question: Which band composed the song "yesterday"?
        // context = song name = "yesterday"
        // about = band = "beatles"

        return null;
    }

    /*
     * @return: List of 30 songs of 2 different bands
     */
    public List<Song> getBandSongs() {

        return null;
    }

    /**
     * close the connection
     */
    public void closeConnection() {

        try {
            Statement stmt = this.conn.createStatement();

            //clear db by dropping schema and creating again the db
            String drop = "DROP SCHEMA IF EXISTS `musical_pursuit_db`";
            stmt.executeUpdate(drop);

            String createDB = "CREATE DATABASE `musical_pursuit_db`";
            stmt.executeUpdate(createDB);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

            // closing the connection
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the connection - " + e.getMessage());
            }
        }
    }
}