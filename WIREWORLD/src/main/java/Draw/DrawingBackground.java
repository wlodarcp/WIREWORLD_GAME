package Draw;

import StateTable.Empty;
import StateTable.FieldState;


public class DrawingBackground implements PenState {

    private FieldState fieldState = new Empty();

    @Override
    public FieldState getFieldState() {

        return fieldState;
    }


    @Override
    public void changePenState(Pen pen) {
        pen.setPenState(new DrawingBackground());
    }
}
