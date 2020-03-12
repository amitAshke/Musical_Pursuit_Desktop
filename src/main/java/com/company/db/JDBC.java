package com.company.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.company.objects.Artist;
import com.company.objects.Song;

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
        //open connection on construction
        while(this.conn == null){
            try {
                this.openConnection(/*String configFileName*/);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @return true if the connection was successfully set
     */
    public Connection openConnection(/*String configFileName*/) {

        String host = "127.0.0.1";
        String port = "3306";
        String schema = "musical_pursuit";
        String user = "root";
        String password = "1234567890";

        System.out.print("Trying to connect... ");

        // Used to input the database detail using a configuration file.
//        try (InputStream input = new FileInputStream(configFileName)) {
//
//            Properties prop = new Properties();
//
//            // load a properties file
//            prop.load(input);
//
//            // creating the connection. Parameters should be taken from config file.
//            host = prop.getProperty("host").toString();
//            port = prop.getProperty("port").toString();
//            schema = prop.getProperty("schema").toString();
//            user = prop.getProperty("user").toString();
//            password = prop.getProperty("password").toString();
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        try {
            Class driver_class = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver driver = (Driver) driver_class.newInstance();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + schema
                    + "?serverTimezone=UTC", user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unable to connect - " + e.getMessage());
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("Connected!");
        return this.conn;
    }


    /* @param context: background for the question,
     *e.g. artist of a question about who composed this song
     * @param about: the right answer
     * @param correctAmount:
     * @param wrongAmount:
     * @return: HashMap with list of right answers as song objects (and key 1 e.g.)
     *  and list of wrong answers as song objects (and key 0 e.g.)
     */
    public HashMap<Integer, List<Song>> getSongsDtl(int correctAmount, int wrongAmount ) {

        HashMap<Integer, List<Song>> answers = new HashMap<>();
        List<Song> right = new ArrayList<>();
        List<Song> wrong = new ArrayList<>();
        String artist_id, title, song_id, getRightAns, getWrongAns, artist_name = null;
        int year;
        ResultSet rs, rs1;
        StringBuilder notRightOnes = new StringBuilder();

        //create statement
        try {
            Statement stmt = this.conn.createStatement();

            //get right answers
            try {
                //Statement stmt = this.conn.createStatement();

                for (int i = 0; i < correctAmount; i++) {
                    //clear db by dropping schema and creating again the db
                    getRightAns = "SELECT * " +
                            "FROM  `songs` " +
                            "WHERE `title`<>'' AND `title` IS NOT NULL " +
                            "ORDER BY RAND() " +
                            "LIMIT 1";

                    rs = stmt.executeQuery(getRightAns);

                    if (rs.next()) {
                        song_id = rs.getString("song_id");
                        year = rs.getInt("year");
                        title = rs.getString("title");
                        artist_id = rs.getString("artist_id");

                        getRightAns = "SELECT  `name` " +
                                "FROM  `artists` " +
                                "WHERE `id`='" + artist_id + "'";
                        rs1 = stmt.executeQuery(getRightAns);

                        if (rs1.next()) {
                            artist_name = rs1.getString("name");
                        }

                        right.add(new Song(song_id, title, year, new Artist(artist_id, artist_name)));
                    }
                }

                //add to HashMap right answers
                answers.put(0, right);

            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            }

            //get wrong ones
            try {
                notRightOnes.append("`title`= '" + right.get(0).getTitle() + "'");

                //Statement stmt = this.conn.createStatement();
                for (int n = 1; n < right.size(); n++) {
                    title = (right.get(n).getTitle());
                    notRightOnes.append(" OR `title`= '" + title + "'");
                }

                for (int j = 0; j < wrongAmount; j++) {
                    //clear db by dropping schema and creating again the db
                    getWrongAns = "SELECT * " +
                            "FROM  `songs` " +
                            "WHERE NOT (" + notRightOnes + ") " +
                            "ORDER BY RAND() " +
                            "LIMIT 1";

                    rs = stmt.executeQuery(getWrongAns);

                    if (rs.next()) {
                        song_id = rs.getString("song_id");
                        year = rs.getInt("year");
                        title = rs.getString("title");
                        artist_id = rs.getString("artist_id");

                        getWrongAns = "SELECT  `name` " +
                                "FROM  `artists` " +
                                "WHERE `id`='" + artist_id + "'";
                        rs1 = stmt.executeQuery(getWrongAns);

                        if (rs1.next()) {
                            artist_name = rs1.getString("name");
                        }

                        wrong.add(new Song(song_id, title, year, new Artist(artist_id, artist_name)));
                    }
                }

                //add to HashMap wrong answers
                answers.put(1, wrong);

            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            }

            //catch of failed create statement
        } catch (NullPointerException | SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }

        return answers;
    }

    /* @param associationsAmount:
     * @param wrongAmount:
     * @return: HashMap with list of songs that are associated with the artist that serves as the key.
     */
//    public HashMap<Artist, List<Song>> getAssociations(int associationsAmount) {
//        HashMap<Artist, List<Song>> answers = new HashMap<>();
//        List<Song> songs = new ArrayList<>();
//        String artist_id = "", title, song_id, getArtists, getSongs, artist_name = null;
//        int year;
//        ResultSet rs, rs1;
//
//        //create statement
//        try {
//            Statement stmt = this.conn.createStatement();
//
//            //get right answers
//            try {
//                //Statement stmt = this.conn.createStatement();
//
//                for (int i = 0; i < 2; i++) {
//                    songs.clear();
//
//                    //clear db by dropping schema and creating again the db
//                    getArtists = "SELECT * " +
//                            "FROM  `artists` " +
//                            "WHERE `name`<>'' AND `title` IS NOT NULL " +
//                            "ORDER BY RAND() " +
//                            "LIMIT 2";
//
//                    rs = stmt.executeQuery(getArtists);
//
//                    if (rs.next()) {
//                        artist_id = rs.getString("artist_id");
//                        artist_name = rs.getString("name");
//
//                        getSongs = "SELECT  `name` " +
//                                "FROM  `songs` " +
//                                "WHERE `ARTIST_id`='" + artist_id + "'" +
//                                "LIMIT " + (associationsAmount / 2);
//                        rs1 = stmt.executeQuery(getSongs);
//
//                        if (rs1.next()) {
//                            song_id = rs1.getString("song_id");
//                            year = rs1.getInt("year");
//                            title = rs1.getString("title");
//                            artist_id = rs1.getString("artist_id");
//
//                            songs.add(new Song(song_id, title, year, new Artist(artist_id, artist_name)));
//                        }
//                    }
//                    //add to HashMap right answers
//                    answers.put(new Artist(artist_id, artist_name), songs);
//                }
//            } catch (SQLException se) {
//                //Handle errors for JDBC
//                se.printStackTrace();
//            }
//            //catch of failed create statement
//        } catch (NullPointerException | SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        }
//
//        return answers;
//    }

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