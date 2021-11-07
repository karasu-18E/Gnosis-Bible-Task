package com.example.gnosis.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.jar.Attributes.Name;

import com.example.gnosis.module.search;
// import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class database {
    final private String url = "jdbc:sqlite:vizbible.sqlite";
    final private String querySelect = "SELECT name, surname,birthPlace, deathPlace, verses from people;";
    private Connection connection = null;
    ObservableList<search> verses = FXCollections.observableArrayList();
    public static database instance = new database();

    public database(){
        try {
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public ObservableList<search> getAllVerse(){
       
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(querySelect);
            while (result.next()) {
               search verse = new search();
               if (result.getString("surname")==null){
                verse.setName(result.getString("name"));
               }
               else{
                   verse.setName(result.getString("name")+" "+result.getString("surname"));
               }
               verse.setBirthplace(result.getString("birthPlace"));
               verse.setDeathplace(result.getString("deadPlace"));
               verse.setVerses(result.getString("verses"));

               verses.add(verse);
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        return verses;
    }
    
}