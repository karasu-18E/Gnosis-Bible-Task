package id.ac.ukdw.fti.rpl.Gnosis;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
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
    private ObservableList<Search> kategori = FXCollections.observableArrayList();

    @FXML
    private TableView<Search> maintable;
    
    @FXML
    private TableColumn<Search, String> tcplace;
    
    @FXML
    private TableColumn<Search, String> tcpeopledied;
    
    @FXML
    private TableColumn<Search, String> tchasbeenhere;
    
    @FXML
    private TableColumn<Search, String> verseDuration;
    
    @FXML
    private TextField tfsearch;

    @FXML
    private BarChart<String, Integer> bcpeople;

    @FXML
    private CategoryAxis xpeople;

    @FXML
    private NumberAxis ynumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //VUT
        verses = Database.instance.getAllVerse();
        tcplace.setCellValueFactory(new PropertyValueFactory<Search, String>("place"));
        tcpeopledied.setCellValueFactory(new PropertyValueFactory<Search, String>("peopledied"));
        tchasbeenhere.setCellValueFactory(new PropertyValueFactory<Search, String>("hasbeenhere"));
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
                if(verse.getPlace().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }              
                if(verse.getPeopledied().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                if(verse.getHasbeenhere().toLowerCase().indexOf(lowerCase)!=-1){
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

        //grafik
        kategori = Database.instance.getPeople();
        xpeople.setCellValueFactory(new PropertyValueFactory)
    }   
}
    

