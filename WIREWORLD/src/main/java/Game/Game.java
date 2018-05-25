package Game;

import Draw.Pen;
import GUI.WireWorldApp;
import StateTable.FieldsTable;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Game {
    private FieldsTable mainFieldsTable;
    private WireWorldApp application;
    private Duration animationSpeed;
    private int generationsNumber;
    private Pen pen;

    public Game(){
        this.mainFieldsTable = new FieldsTable(30,30);
        this.pen = new Pen(mainFieldsTable);
        this.application = new WireWorldApp();
        //this.animationSpeed = Duration.millis(20);
        this.generationsNumber = 50;
    }

    public void gameInitialize(){
        this.application.setMainFieldsTable(this.mainFieldsTable);
    }


    public static void main(String[] args){
        Game game = new Game();
        game.gameInitialize();
        game.application.launch(WireWorldApp.class, args);

    }

}
