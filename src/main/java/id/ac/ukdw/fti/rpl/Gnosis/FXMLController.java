package id.ac.ukdw.fti.rpl.Gnosis;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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

public class FXMLController implements Initializable {

    private ObservableList<Search> verses = FXCollections.observableArrayList();
    private ObservableList<Search> pernyataann = FXCollections.observableArrayList();
    private ObservableList<Search> people = FXCollections.observableArrayList();
    private ObservableList<Search> perjalanann = FXCollections.observableArrayList();

    @FXML
    private TableView<Search> maintable;
    
    @FXML
    private TableView<Search> tablealkitab;

    @FXML
    private TableView<Search> tabletimeline;

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

    @FXML
    private TextField tfsearchtm;

    @FXML
    private TableColumn<Search, String> tcname;

    @FXML
    private TableColumn<Search, String> eastons;

    @FXML
    private TableColumn<Search, String> tcayat;

    @FXML
    private TextInputControl tfsearch2;

    @FXML
    private TableColumn<Search, String> verseText;

    @FXML
    private Object FilteredList;

    @FXML
    private Object FilteredList2;

    @FXML
    private Object FilteredList3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // visualisasi utama topik
        verses = Database.instance.getAllVerse();
        tcplace.setCellValueFactory(new PropertyValueFactory<Search, String>("place"));
        tcpeopledied.setCellValueFactory(new PropertyValueFactory<Search, String>("peopledied"));
        tchasbeenhere.setCellValueFactory(new PropertyValueFactory<Search, String>("hasbeenhere"));
        verseDuration.setCellValueFactory(new PropertyValueFactory<Search, String>("verseDuration1"));
        maintable.setItems(verses);

        // menampilkan semua data
        FilteredList<Search> filteredData = new FilteredList<>(verses, searching -> true);

        tfsearch.textProperty().addListener((Observable, oldValue, newValue) -> {
            filteredData.setPredicate(verse -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }
                String lowerCase = newValue.toLowerCase();
                if (verse.getPlace().toLowerCase().indexOf(lowerCase) != -1) {
                    return true;
                }
                if (verse.getPeopledied().toLowerCase().indexOf(lowerCase) != -1) {
                    return true;
                }
                if (verse.getHasbeenhere().toLowerCase().indexOf(lowerCase) != -1) {
                    return true;

                }
                if (verse.getVerseDuration1().toLowerCase().indexOf(lowerCase) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Search> sortingData = new SortedList<>(filteredData);
        sortingData.comparatorProperty().bind(maintable.comparatorProperty());
        maintable.setItems(sortingData);

        // alkitab
        pernyataann = Database.instance.getAllPernyataan();
        tcayat.setCellValueFactory(new PropertyValueFactory<Search, String>("ayat"));
        verseText.setCellValueFactory(new PropertyValueFactory<Search, String>("verseText1"));
        tablealkitab.setItems(pernyataann);

        FilteredList<Search> filteredData2 = new FilteredList<>(verses, searching -> true);

        tfsearch2.textProperty().addListener((Observable, oldValue, newValue) -> {
            filteredData2.setPredicate(pernyataan2 -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;

                }
                String lowerCase = newValue.toLowerCase();
                if (pernyataan2.getAyat().toLowerCase().indexOf(lowerCase) != -1) {
                    return true;

                }
                if (pernyataan2.getVerseText1().toLowerCase().indexOf(lowerCase) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Search> sortingData1 = new SortedList<>(filteredData2);
        sortingData1.comparatorProperty().bind(tablealkitab.comparatorProperty());
        tablealkitab.setItems(sortingData1);

        // Visualisasi Sekunder
        perjalanann = Database.instance.getAllPerjalanan();
        tcname.setCellValueFactory(new PropertyValueFactory<Search, String>("placeLookup"));
        eastons.setCellValueFactory(new PropertyValueFactory<Search, String>("eastons"));
        tabletimeline.setItems(perjalanann);

        FilteredList<Search> filteredData3 = new FilteredList<>(perjalanann, searching -> true);

        tfsearchtm.textProperty().addListener((Observable, oldValue, newValue) -> {
            filteredData3.setPredicate(perjalanan2 -> {
                if (newValue == null || newValue.isEmpty()) {

                    return true;
                }
                String lowerCase = newValue.toLowerCase();

                if (perjalanan2.getName().toLowerCase().indexOf(lowerCase) != -1) {
                    return true;
                }

                if (perjalanan2.getEastons().toLowerCase().indexOf(lowerCase) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Search> sortingData3 = new SortedList<>(filteredData3);
        sortingData3.comparatorProperty().bind(tabletimeline.comparatorProperty());
        tabletimeline.setItems(sortingData3);
        
        // grafik
        //people = Database.instance.getAllKategori();
        /*
         * tcplace.setCellValueFactory(new PropertyValueFactory<Search,
         * String>("place"));
         * 
         * tcpeopledied.setCellValueFactory(new PropertyValueFactory<Search,
         * String>("peopledied"));
         */
        /*
        XYChart.Series<String, Integer> datapeople = new XYChart.Series<String, Integer>();

        for (int i = 0; i < people.size(); i++) {
            datapeople.getData()
                    .add(new XYChart.Data<String, Integer>(people.get(0).getPeople(), people.get(0).getJumlah()));

        }

        bcpeople.getData().add(datapeople);
        */

        // bcpeople.setItems(people);

    }

}
