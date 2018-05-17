package GUI;

import Draw.Pen;
import GameControll.FieldsTableEditor;
import StateTable.Conductor;
import StateTable.FieldsTable;
import StateTable.Head;
import StateTable.Tail;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class WireWorldApp extends Application {


    public MainWindowController mainWindowController;
    private Stage primaryStage;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private FieldsTable mainFieldsTable = new FieldsTable(30, 30);
    private Color bacgroundColor;
    private Pen pen = new Pen(mainFieldsTable);
    private Timeline timeline;
    private Duration animationSpeed = Duration.seconds(1);

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(final Stage stage) throws Exception {

        this.primaryStage = stage;
        mainWindowController = load("MainScene.fxml");
        mainWindowController.toMain();

        mainWindowController.setPen(this.pen);
        stage.centerOnScreen();
        stage.setTitle("WireCAD");
        stage.show();
    }


    public MainWindowController load(final String name) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
        loader.load();
        final MainWindowController controller = loader.getController();
        controller.configure(this, new Scene(loader.getRoot()));
        return controller;
    }

    public void animate() {
        mainFieldsTable = pen.getFieldsTable();
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        KeyFrame changingState = new KeyFrame(animationSpeed, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainFieldsTable.checkNeighborhoodForAll();
                mainFieldsTable.changeStateForAll();
                mainWindowController.refresh(mainFieldsTable);
            }
        });
        timeline.getKeyFrames().add(changingState);
        timeline.play();

    }

    public void pause() {
        timeline.pause();
    }

    public void show(Scene scene) {
        primaryStage.setScene(scene);
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void setMainFieldsTable(FieldsTable mainFieldsTable) {
        this.mainFieldsTable = mainFieldsTable;
    }

    public void setBacgroundColor(Color bacgroundColor) {
        this.bacgroundColor = bacgroundColor;
    }

    public FieldsTable getMainFieldsTable() {
        return mainFieldsTable;
    }

    public Pen getPen() {
        return pen;
    }

    public Timeline getTimeline() {
        return timeline;
    }
}

