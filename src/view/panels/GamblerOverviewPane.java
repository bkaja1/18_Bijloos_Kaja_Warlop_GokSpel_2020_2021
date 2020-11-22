package view.panels;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Speler;

import java.util.List;


public class GamblerOverviewPane extends GridPane{
	private TableView<Speler> table;
	
	public GamblerOverviewPane() {
		this.table = new TableView<>();

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		this.add(new Label("Spelers:"), 0, 0, 1, 1);

		TableColumn<Speler,String> naam = new TableColumn<>("Achternaam");
		naam.setCellValueFactory(new PropertyValueFactory<>("naam"));

		TableColumn<Speler,String> voornaam = new TableColumn<>("Voornaam");
		voornaam.setCellValueFactory(new PropertyValueFactory<>("voornaam"));

		TableColumn<Speler,String> spelersnaam = new TableColumn<>("Spelersnaam");
		spelersnaam.setCellValueFactory(new PropertyValueFactory<>("spelersnaam"));

		TableColumn<Speler,String> saldo = new TableColumn<>("Saldo");
		saldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));

		table.getColumns().add(naam);
		table.getColumns().add(voornaam);
		table.getColumns().add(spelersnaam);
		table.getColumns().add(saldo);
		//table.getItems().addAll(controller.getSpelers());
		this.add(table,0,1);
	}

	public void update(List<Speler> spelers) {
		this.table.getItems().clear();
		this.table.getItems().addAll(spelers);
	}

}
