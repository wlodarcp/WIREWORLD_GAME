package GameControll;

import StateTable.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class gameDemo extends Application {
    private Scene scene;
    private static final int TILE_SIZE = 20;
    private static final int W = 400;
    private static final int H = 400;

    private static final int X_TILES = W / TILE_SIZE;
    private static final int Y_TILES = H / TILE_SIZE;

    private GamePane[][] grid = new GamePane[X_TILES][Y_TILES];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FieldsTable fieldsTable = new FieldsTable(X_TILES,X_TILES);
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
        Group root = new Group();
        scene = new Scene(root, W, W);

        stage.setScene(scene);
        animate(scene,fieldsTable);
        stage.show();

    }

    public Parent createContent(FieldsTable fieldsTable) {

        StackPane root = new StackPane();
        root.setPrefSize(W, W);
        root.setAlignment(Pos.BASELINE_LEFT);


        for (int y = 0; y < X_TILES; y++) {
            for (int x = 0; x < X_TILES; x++) {
                GamePane pane = new GamePane(x,y, fieldsTable.findFieldByPosition(x,y));
                grid[x][y] = pane;
                root.getChildren().add(pane);
            }
        }
        return root;
    }

    private class GamePane extends StackPane  {
        private Rectangle border = new Rectangle(TILE_SIZE-2, TILE_SIZE-2);
        private int x, y;

        public GamePane(int x, int y, Field field) {
            this.x = x;
            this.y = y;
            border.setFill(field.getFieldState().getColor());
            getChildren().addAll(border);
            setTranslateX(x * TILE_SIZE);
            setTranslateY(y * TILE_SIZE);

        }
    }

    public void animate(final Scene scene, FieldsTable fieldsTable){
        final Group root = (Group) scene.getRoot();
        Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        KeyFrame changingState = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fieldsTable.checkNeighborhoodForAll();;
                fieldsTable.changeStateForAll();
                root.getChildren().add(createContent(fieldsTable));
            }
        });
        tl.getKeyFrames().add(changingState);
        tl.play();
    }
}
