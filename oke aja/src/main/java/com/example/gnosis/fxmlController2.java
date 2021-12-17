package com.example.gnosis;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

//import java.io.Serial;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.gnosis.database.database;
import com.example.gnosis.module.search;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.scene.control.TableView;


public class fxmlController2 implements Initializable{
    private ObservableList<search> verses = FXCollections.observableArrayList();

    @FXML
    private TextField TfObject;

    @FXML
    private Label LbBible;
    @FXML
    private TableView<search> maintable;

    @FXML
    private TableColumn<search, String> tcpeople;


    @FXML
    private TableColumn<search, String> tcbirthplace;
    

    @FXML
    private TableColumn<search, String> tcdeathplace;

    @FXML
    private TableColumn<search, String> tcverse;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verses = database.instance.getAllVerse();
        tcpeople.setCellValueFactory(new PropertyValueFactory<search, String>("name"));
        tcbirthplace.setCellValueFactory(new PropertyValueFactory<search, String>("birthplace"));
        tcdeathplace.setCellValueFactory(new PropertyValueFactory<search, String>("deathplace"));
        tcverse.setCellValueFactory(new PropertyValueFactory<search,String>("verses"));
        maintable.setItems(verses);


        FilteredList<search> filteredData= new FilteredList<>(verses,searching->true);

        TfObject.textProperty().addListener((Observable, oldValue, newValue) -> {
            filteredData.setPredicate(verse -> {
                if (newValue==null || newValue.isEmpty()) {
                    return true;
                    
                }
                String lowerCase=newValue.toLowerCase();


                if(verse.getName().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }              

                if(verse.getBirthplace().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }

                if(verse.getDeathplace().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }

                if(verse.getVerses().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                else{
                    return false;
                }
            });
        });
        SortedList<search> sortingData=new SortedList<>(filteredData);
        sortingData.comparatorProperty().bind(maintable.comparatorProperty());
        maintable.setItems(sortingData);
    }


}

