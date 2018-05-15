package StateTable;

import javafx.scene.paint.Color;

public class Empty implements FieldState {
    private final Color color = Color.BLACK;
    public Empty() {
    }

    @Override
    public void changeState(Field field) {
    }

    @Override
    public Color getColor(){
        return this.color;
    }
}
