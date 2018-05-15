package Draw;

import StateTable.Conductor;
import StateTable.FieldState;

public class DrawingWire implements PenState{

    private FieldState fieldState = new Conductor();

    @Override
    public void changePenState(Pen pen) {
        pen.setPenState(new DrawingWire());
    }

    @Override
    public FieldState getFieldState() {
        return fieldState;
    }
}
