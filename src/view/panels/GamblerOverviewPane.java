package view.panels;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Spel;
import model.Speler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * @Author Sébastien Warlop
 */

public class GamblerOverviewPane extends GridPane{
    private TableView<Speler> table;
    private Spel spel;

	public GamblerOverviewPane() {
		this.table = new TableView<>();
		this.spel = new Spel();

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

		this.getChildren().addAll(table);
	}

	public void refresh() {
		ArrayList<Speler> spelers = new ArrayList<>(spel.getSpelersMap().values());
		Collections.sort(spelers);
		table.setItems(FXCollections.observableArrayList(spelers));
		table.refresh();
	}
}
