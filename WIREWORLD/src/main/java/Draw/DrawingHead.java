package Draw;

import StateTable.FieldState;
import StateTable.Head;


public class DrawingHead implements PenState {

    private FieldState fieldState = new Head();

    @Override
    public FieldState getFieldState() {

        return fieldState;
    }


    @Override
    public void changePenState(Pen pen) {
        pen.setPenState(new DrawingHead());
    }
}
