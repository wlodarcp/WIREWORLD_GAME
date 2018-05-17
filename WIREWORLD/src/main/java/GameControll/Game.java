package GameControll;

import Draw.Pen;
import GUI.WireWorldApp;
import StateTable.FieldsTable;
import com.sun.javafx.tools.packager.Main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Game {
    private FieldsTable mainFieldsTable;
    private WireWorldApp application;
    private Duration animationSpeed;
    private int generationsNumber;
    private Color bacgroundColor;
    private FieldsTableEditor fieldsTableEditor;
    private Pen pen;

    public Game(){
        this.mainFieldsTable = new FieldsTable(30,30);
        this.pen = new Pen(mainFieldsTable);
        this.application = new WireWorldApp();
        this.animationSpeed = Duration.millis(20);
        this.generationsNumber = 50;
        this.bacgroundColor = Color.GRAY;
        this.fieldsTableEditor = new FieldsTableEditor();
    }

    public void gameInitialize(){
        this.application.setMainFieldsTable(this.mainFieldsTable);
        this.application.setBacgroundColor(this.bacgroundColor);
    }
    public void startGame(){
        FieldsTable tmp = application.getMainFieldsTable(); //teraz bierze z drawingu chyba?
        //animate(tmp);
    }

    public static void main(String[] args){
        Game game = new Game();
        game.gameInitialize();
        game.application.launch(WireWorldApp.class, args);

    }

    /*public void animate(WireWorldApp wireWorldApp, double time, int howManyGenerations){
        mainFieldsTable = wireWorldApp.getPen().getFieldsTable();
        //Timeline timeline = wireWorldApp.getTimeline();
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        KeyFrame changingState = new KeyFrame(animationSpeed, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainFieldsTable.checkNeighborhoodForAll();
                mainFieldsTable.changeStateForAll();
                wireWorldApp.mainWindowController.refresh(mainFieldsTable);
            }
        });
        timeline.getKeyFrames().add(changingState);
        timeline.play();

    }*/



}
