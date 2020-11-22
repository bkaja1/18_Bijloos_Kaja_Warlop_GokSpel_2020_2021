package view.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Speler;
import model.database.GeneriekeList;
import model.database.SpelerTekstLoadSave;
import model.database.TekstLoadSaveTemplate;

public class GamblerOverviewPane extends GridPane{
	private TekstLoadSaveTemplate tekstLoadSaveTemplate;
	private TableView<Speler> table;
	private ObservableList<Speler> spelers;

	public GamblerOverviewPane() {
		this.table = new TableView<>();
		this.tekstLoadSaveTemplate = new SpelerTekstLoadSave();

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		this.add(new Label("Spelers:"), 0, 0, 1, 1);

		refresh();

		TableColumn<Speler,String> colFamilienaam = new TableColumn<>("Familienaam");
		colFamilienaam.setCellValueFactory(new PropertyValueFactory<>("familienaam"));

		TableColumn<Speler,String> colVoornaam = new TableColumn<>("Voornaam");
		colVoornaam.setCellValueFactory(new PropertyValueFactory<>("voornaam"));

		TableColumn<Speler,String> colSpelernaam = new TableColumn<>("Spelernaam");
		colSpelernaam.setCellValueFactory(new PropertyValueFactory<>("spelernaam"));

		TableColumn<Speler,String> colGoksaldo = new TableColumn<>("Goksaldo");
		colGoksaldo.setCellValueFactory(new PropertyValueFactory<>("goksaldo"));

		table.getColumns().addAll(colFamilienaam, colVoornaam, colSpelernaam, colGoksaldo);

		this.add(table,0,1);
	}

	public void refresh() {
		GeneriekeList<Speler> generiekeList = new GeneriekeList<>();
		for(Object object : tekstLoadSaveTemplate.load().values()) {
			generiekeList.voegToe((Speler) object);
		}
		spelers = FXCollections.observableArrayList(generiekeList.getAll());
		table.setItems(spelers);
		table.refresh();
	}
}
