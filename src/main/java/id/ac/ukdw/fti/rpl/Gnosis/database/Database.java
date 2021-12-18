package id.ac.ukdw.fti.rpl.Gnosis.database;

import java.sql.Statement;

import id.ac.ukdw.fti.rpl.Gnosis.modal.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    final private String url="jdbc:sqlite:vizbible.sqlite";
    final private String querySelect="SELECT displayTitle, peopleDied, hasBeenHere, verses from places";
    final private String queryGrafikPeople="SELECT people.displayTitle FROM people INNER JOIN places on hasBeenHere = people.personLookup GROUP BY  people.displayTitle;";
    
    ObservableList<Search> verses=FXCollections.observableArrayList();
    ObservableList<Search> kategori=FXCollections.observableArrayList();

    private Connection connection = null;
    public static Database instance= new Database();

    public Database(){
        try{
            connection = DriverManager.getConnection(url);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Connection openConnection() {
        return connection;
    }

    public ObservableList<Search> getAllVerse(){
        try {  
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()){
                Search verse= new Search();
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

    public ObservableList<Search> getPeople(){
        try{
            Statement grafikstatement = connection.createStatement();
            ResultSet grafikresult = grafikstatement.executeQuery(queryGrafikPeople;     
            } catch (Exception e){
                System.out.println(e.getMessage());

        }
        return kategori;
    }
}
