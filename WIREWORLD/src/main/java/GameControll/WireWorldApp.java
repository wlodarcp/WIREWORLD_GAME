package GameControll;

import StateTable.Conductor;
import StateTable.FieldsTable;
import StateTable.Head;
import StateTable.Tail;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WireWorldApp extends Application {


    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/GUI/MainScene.fxml"));
        AnchorPane pane = null;
        FieldsTable fieldsTable = new FieldsTable(20,20);
        fieldsTable.findFieldByPosition(3,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,4).setFieldState(new Tail());
        fieldsTable.findFieldByPosition(5,4).setFieldState(new Head());
        fieldsTable.findFieldByPosition(6,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(7,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(8,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(9,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(10,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(11,5).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(11,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(11,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(12,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(12,5).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(13,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(14,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(15,4).setFieldState(new Conductor());
        try{
            pane=loader.load();
        }catch(IOException e){
            e.printStackTrace();
        }
        gameDemo gameDemo = new gameDemo();
        Group root = new Group();
        Scene scene2 = new Scene(root, 10, 10);
        gameDemo.animate(scene2,fieldsTable);
        Scene scene = new Scene(pane);

        ((Pane) scene.getRoot()).getChildren().add(scene2.getRoot());

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("WireCAD");
        stage.show();
    }
}

