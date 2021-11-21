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
    private TextField TfObject;

    @FXML
    private TableView<Search> maintable;

    @FXML
    private TableColumn<Search, String> tcpeople;

    @FXML
    private TableColumn<Search, String> tcbirthplace;

    @FXML
    private TableColumn<Search, String> tcdeathplace;

    @FXML
    private TableColumn<Search, String> tcverse;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verses = Database.instance.getAllVerse();
        tcpeople.setCellValueFactory(new PropertyValueFactory<Search, String>("name"));
        tcbirthplace.setCellValueFactory(new PropertyValueFactory<Search, String>("birthplace"));
        tcdeathplace.setCellValueFactory(new PropertyValueFactory<Search, String>("deathplace"));
        tcverse.setCellValueFactory(new PropertyValueFactory<Search,String>("verses"));
        maintable.setItems(verses);

        //menampilkan semua data
        FilteredList<Search> filteredData= new FilteredList<>(verses,searching->true);

        TfObject.textProperty().addListener((Observable, oldValue, newValue) -> {
            filteredData.setPredicate(verse -> {
                if (newValue==null || newValue.isEmpty()) {
                    return true;
                    
                }
                String lowerCase=newValue.toLowerCase();

                // mencari kesesuaian ayat bedasarkan event, jika true maka akan ditampilkan
                if(verse.getName().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }              
                // mencari kesesuaian nama bedasarkan event, jika true maka akan ditampilkan
                if(verse.getBirthplace().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                // mencari kesesuaian tahun bedasarkan event, jika true maka akan ditampilkan
                if(verse.getDeathplace().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                // mencari kesesuaian durasi bedasarkan event, jika true maka akan ditampilkan
                if(verse.getVerses().toLowerCase().indexOf(lowerCase)!=-1){
                    return true; 
                }
                else{
                    return false;
                }
            });
        });
        // mengumpulkan filterlist untuk diurutkan 
        SortedList<Search> sortingData=new SortedList<>(filteredData);
        // mengurutkan list pada tabel dan dikomparasi
        sortingData.comparatorProperty().bind(maintable.comparatorProperty());
        // menambahkan data yang terurut pada tabel
        maintable.setItems(sortingData);
    }   
}
    

