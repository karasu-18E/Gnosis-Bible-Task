package id.ac.ukdw.fti.rpl.Gnosis.database;

import java.sql.Statement;

import id.ac.ukdw.fti.rpl.Gnosis.modal.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    final private String url = "jdbc:sqlite:vizbible.sqlite";
    final private String querySelect = "SELECT displayTitle, peopleDied, hasBeenHere, verses from places";
    //final private String queryGrafik = "SELECT people.displayTitle, count(places.placeID) FROM people INNER JOIN places on hasBeenHere = people.personLookup GROUP BY  people.displayTitle;";
    final private String querygrafik2 = "SELECT osisRef,placesCount FROM verses WHERE placesCount > 0 AND peopleCount > 0;";
    final private String querySelectt = "SELECT osisRef,verseText from verses";

    ObservableList<Search> verses = FXCollections.observableArrayList();
    // GRAFIK
    ObservableList<Search> kategori = FXCollections.observableArrayList();
    // ALKITAB
    ObservableList<Search> pernyataann = FXCollections.observableArrayList();

    private Connection connection = null;
    public static Database instance = new Database();

    public Database() {
        try {
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection openConnection() {
        return connection;
    }

    public ObservableList<Search> getAllVerse() {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()) {
                Search verse = new Search();
                verse.setPlace(result.getString("displayTitle"));
                verse.setPeopledied(result.getString("peopleDied"));
                verse.setHasbeenhere(result.getString("hasBeenHere"));
                verse.setVerseDuration1(result.getString("verses"));
                verses.add(verse);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return verses;
    }

    public ObservableList<Search> getAllPernyataan() {
        try {
            Statement pernyataan = connection.createStatement();
            ResultSet result2 = pernyataan.executeQuery(querySelectt);
            while (result2.next()) {
                Search pernyataan2 = new Search();
                pernyataan2.setAyat(result2.getString("osisRef"));
                pernyataan2.setVerseText1(result2.getString("verseText"));
                pernyataann.add(pernyataan2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pernyataann;
    }

    public ObservableList<Search> getAllKategori() {
        try {
            Statement grafikstatement = connection.createStatement();
            ResultSet grafikresult = grafikstatement.executeQuery(querygrafik2);
            while (grafikresult.next()) {
                Search people = new Search();
                people.setPeople(grafikresult.getString("osisRef"));
                people.setJumlaho(grafikresult.getInt("placesCount"));
                kategori.add(people);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kategori;

    }
}
