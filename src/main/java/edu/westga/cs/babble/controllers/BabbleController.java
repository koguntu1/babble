package edu.westga.cs.babble.controllers;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileNotInGroupException;
import edu.westga.cs.babble.model.TileRack;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * This is the Babble Controller class
 * 
 * @author Keith Oguntuwase 
 * @version 1.0 * 
 * 
 */
public class BabbleController {
    private TileBag bag;
    private WordDictionary dictionary;
    private TileRack rack;
    private PlayedWord word;
    private IntegerProperty scoreProperty;

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ListView<Tile> rackListView;
    @FXML
    private ListView<Tile> playedWordListView;
    @FXML
    private Button resetButton;
    @FXML
    private Button playWordButton;
    @FXML
    private TextField scoreTextField;  
    @FXML

    void initialize() {    
        initGameState();
        setupScoreTextField();
        setupRackListView();
        setupPlayedWordListView();
        setupResetButton();
        setupPlayWordButton();
        refreshTileRack();
    }

    private void setupScoreTextField() {
        this.scoreTextField.textProperty().bindBidirectional(this.scoreProperty, new NumberStringConverter());
    }

    private void setupPlayWordButton() {
        this.playWordButton.setOnMouseClicked(new EventHandler<MouseEvent>() {      
            private void showUserMessage(String message) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.contentTextProperty().set(message);
                alert.showAndWait();
            }

            public void handle(MouseEvent event) {
                if (BabbleController.this.dictionary.isValidWord(BabbleController.this.word.getHand())) {
                    int handScore = BabbleController.this.word.getScore();
                    BabbleController.this.increaseScoreBy(handScore);
                    BabbleController.this.refreshTileRack();
                    BabbleController.this.clearPlayedWord();
                } else {
                    showUserMessage("Not a valid word");
                }
            }
        });
    }

    private void clearPlayedWord() {
        this.word.clear();
    }

    private void setupResetButton() {
        this.resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                List<Tile> tiles = new ArrayList<Tile>(BabbleController.this.word.tiles());
                for (Tile tile : tiles) {
                    try {
                        BabbleController.this.word.remove(tile);
                    } catch (TileNotInGroupException e) {
                        e.printStackTrace();
                    }
                    BabbleController.this.rack.append(tile);
                }
            }
        });
    }

    class TileCellFactory implements Callback<ListView<Tile>, ListCell<Tile>> {
        TileCellFactory() {

        }

        public ListCell<Tile> call(ListView<Tile> param) {
            final TextFieldListCell<Tile> cell = new TextFieldListCell<Tile>();
            cell.setConverter(new StringConverter<Tile>() {
                public String toString(Tile tile) {
                    String value = "" + tile.getLetter();
                    cell.setAccessibleText(value);
                    return value;
                }

                public Tile fromString(String string) {
                    throw new UnsupportedOperationException();
                }
            });
            return cell;
        }
    }

    private void setupPlayedWordListView() {
        this.playedWordListView.setItems(this.word.tiles());
        this.playedWordListView.setCellFactory(new TileCellFactory());
        this.playedWordListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Tile selectedTile = (Tile) BabbleController.this.playedWordListView.getSelectionModel().getSelectedItem();
                if (selectedTile == null) {
                    return;
                }
                try {
                    BabbleController.this.word.remove(selectedTile);
                    BabbleController.this.rack.append(selectedTile);
                } catch (TileNotInGroupException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setupRackListView() {
        this.rackListView.setItems(this.rack.tiles());
        this.rackListView.setCellFactory(new TileCellFactory());
        this.rackListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Tile selectedTile = (Tile) BabbleController.this.rackListView.getSelectionModel().getSelectedItem();
                if (selectedTile == null) {
                    return;
                }
                try {
                    BabbleController.this.rack.remove(selectedTile);
                    BabbleController.this.word.append(selectedTile);
                } catch (TileNotInGroupException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor
     */
    public BabbleController() {
        initGameState();
    }

    /**
     * Init the game
     */
    public void initGameState() {
        this.dictionary = new WordDictionary();
        this.bag = new TileBag();
        this.rack = new TileRack();
        this.scoreProperty = new SimpleIntegerProperty(0);
        this.dictionary = new WordDictionary();
        this.word = new PlayedWord();
    }

    /**
     * Refresh the Tile Rack
     */
    public void refreshTileRack() {
        int numberOfTilesToDraw = this.rack.getNumberOfTilesNeeded();
        Tile tile;

        for (int i = 0; i < numberOfTilesToDraw; i++) {
            if (this.bag.isEmpty()) {
                break;
            }
            try {
                tile = this.bag.drawTile();
            } catch (EmptyTileBagException e) {
                throw new IllegalStateException("Draw bag should not be empty");
            }
            this.rack.append(tile);
        }
    }

    private void increaseScoreBy(int score) {
        int currScore = this.scoreProperty.get();
        currScore += score;
        this.scoreProperty.set(currScore);
    }
}
