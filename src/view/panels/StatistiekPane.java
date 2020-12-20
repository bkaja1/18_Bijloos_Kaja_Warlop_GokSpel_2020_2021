package view.panels;

import controller.StatistiekController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Spel;
import model.gokstrategies.EvenStrategy;
import model.gokstrategies.GokStrategy;
import model.gokstrategies.HogerDanEenStrategy;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.util.Observable;

/**
 * @Author Sébastien Warlop
 */


public class StatistiekPane extends GridPane {
    StatistiekController statistiekController;

    private ObservableList<GokStrategy> stats;
    private TableView<GokStrategy> table;

    TableView tableView;

    public StatistiekPane(StatistiekController statistiekController) {
        this.statistiekController = statistiekController;

        Label lblHoofding = new Label ("Spelerslijst: ");
        lblHoofding.setFont(new Font("Arial", 20, 10));

        table = new TableView<GokStrategy>();
        refresh();

        TableColumn<GokStrategy, String> colGokStrategy = new TableColumn<>("Gok Strategy");
        colGokStrategy.setMinWidth(120);
        colGokStrategy.setCellValueFactory(new PropertyValueFactory<>("gokStrategyString"));

        TableColumn<GokStrategy, Integer> colAantal = new TableColumn<>("aantal spellen");
        colAantal.setMinWidth(100);
        colAantal.setCellValueFactory(new PropertyValueFactory<>("aantal"));

        TableColumn<GokStrategy, Integer> colWon = new TableColumn<>("aantal gewonnen spellen");
        colWon.setMinWidth(100);
        colWon.setCellValueFactory(new PropertyValueFactory<>("gewonnen"));

        TableColumn<GokStrategy, Double> colBetTotal = new TableColumn<>("euro inzet");
        colBetTotal.setMinWidth(100);
        colBetTotal.setCellValueFactory(new PropertyValueFactory<>("TotaleInzet"));

        TableColumn<GokStrategy, Double> colWonTotal = new TableColumn<>("euro gewonnen");
        colWonTotal.setMinWidth(100);
        colWonTotal.setCellValueFactory(new PropertyValueFactory<>("TotaalGewonnen"));

        table.getColumns().addAll(colGokStrategy, colAantal, colWon, colBetTotal, colWonTotal);

        this.add(table, 5, 5, 5, 5);
    }

    public void refresh(Spel spel) {
        table.setItems(FXCollections.observableArrayList(spel.getSpelersList()));
        table.refresh();
    }
}
