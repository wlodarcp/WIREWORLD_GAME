package Draw;

import StateTable.FieldState;
import StateTable.Tail;

public class DrawingTail implements PenState {

    private FieldState fieldState = new Tail();

    @Override
    public FieldState getFieldState() {

        return fieldState;
    }

    @Override
    public void changePenState(Pen pen) {
        pen.setPenState(new DrawingTail());
    }
}
