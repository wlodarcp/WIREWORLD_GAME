package StateTable;

import javafx.scene.paint.Color;

public class Empty implements FieldState {
    private static Color color = Color.BLACK;
    public Empty() {
    }

    @Override
    public void changeState(Field field) {
    }

    @Override
    public Color getColor(){
        return this.color;
    }

    @Override
    public String toString() {
        return "Empty";
    }

    public static void setColor(Color c) {
        color = c;
    }
}
