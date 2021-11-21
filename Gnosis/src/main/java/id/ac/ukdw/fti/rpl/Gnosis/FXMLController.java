package id.ac.ukdw.fti.rpl.Gnosis;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import id.ac.ukdw.fti.rpl.Gnosis.database.Database;
import id.ac.ukdw.fti.rpl.Gnosis.modal.Search;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;

public class FXMLController implements Initializable{
    
    private ObservableList<Search> verses = FXCollections.observableArrayList();

    @FXML
    private TableView<Search> maintable;
    
    @FXML
    private TableColumn<Search, String> tcpeople;
    
    @FXML
    private TableColumn<Search, String> tcbirthplace;
    
    @FXML
    private TableColumn<Search, String> tcdeathplace;
    
    @FXML
    private TableColumn<Search, String> verseDuration;
    
    @FXML
    private TextField tfsearch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verses = Database.instance.getAllVerse();
        tcpeople.setCellValueFactory(new PropertyValueFactory<Search, String>("Name"));
        tcbirthplace.setCellValueFactory(new PropertyValueFactory<Search, String>("Birthplace"));
        tcdeathplace.setCellValueFactory(new PropertyValueFactory<Search, String>("Deathplace"));
        verseDuration.setCellValueFactory(new PropertyValueFactory<Search,String>("verseDuration1"));
        maintable.setItems(verses);

        //menampilkan semua data
        FilteredList<Search> filteredData= new FilteredList<>(verses,searching->true);

        tfsearch.textProperty().addListener((Observable, oldValue, newValue) -> {
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
                if(verse.getVerseDuration1().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                else{
                    return false;
                }
            });
        });
        SortedList<Search> sortingData=new SortedList<>(filteredData);
        sortingData.comparatorProperty().bind(maintable.comparatorProperty());
        maintable.setItems(sortingData);
    }   
}
    

