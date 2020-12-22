package view.panels;

import controller.StatistiekController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Spel;
import model.gokstrategies.GokStrategy;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @Author Sébastien Warlop
 */

public class StatistiekPane extends GridPane {
    private TableView<GokStrategy> table;

    public StatistiekPane(StatistiekController controller) {
        this.table = new TableView<>();

        controller.setView(this);

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Statistieken:"), 0, 0, 1, 1);

        TableColumn<GokStrategy, String> colOmschrijving = new TableColumn<>("Omschrijving");
        colOmschrijving.setMinWidth(340);
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<>("omschrijving"));

        TableColumn<GokStrategy, Integer> colGekozen = new TableColumn<>("Gekozen");
        colGekozen.setMinWidth(10);
        colGekozen.setCellValueFactory(new PropertyValueFactory<>("gekozen"));

        TableColumn<GokStrategy, Integer> colGewonnen = new TableColumn<>("Gewonnen");
        colGewonnen.setMinWidth(10);
        colGewonnen.setCellValueFactory(new PropertyValueFactory<>("gewonnen"));

        TableColumn<GokStrategy, Double> colInzet = new TableColumn<>("Inzet");
        colInzet.setMinWidth(10);
        colInzet.setCellValueFactory(new PropertyValueFactory<>("inzet"));

        TableColumn<GokStrategy, Double> colBedrag = new TableColumn<>("Bedrag");
        colBedrag.setMinWidth(10);
        colBedrag.setCellValueFactory(new PropertyValueFactory<>("bedrag"));

        table.getColumns().addAll(colOmschrijving, colGekozen, colGewonnen, colInzet, colBedrag);

        this.add(table, 0, 1);
    }

    public void refresh(Spel spel) {
        table.setItems(FXCollections.observableArrayList(spel.getGokStrategies()));
        table.refresh();
    }
}
