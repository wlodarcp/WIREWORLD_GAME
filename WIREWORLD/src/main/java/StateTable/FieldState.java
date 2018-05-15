package StateTable;

import javafx.scene.paint.Color;

public interface FieldState {
    public void changeState(Field field);

    public Color getColor();
}
