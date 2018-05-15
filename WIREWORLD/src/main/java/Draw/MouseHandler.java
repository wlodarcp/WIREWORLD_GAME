package Draw;

import StateTable.Position;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;



public class MouseHandler {



    private MouseEvent mouseEvent;
    private Position position;

    public MouseHandler(MouseEvent e) {
        this.mouseEvent = e;
        position = new Position((int)e.getSceneX()-203,(int) e.getSceneY()-130);

    }


    public MouseEvent getMouseEvent() {
        return mouseEvent;
    }

    public Position getPosition() {
        return position;
    }

}
