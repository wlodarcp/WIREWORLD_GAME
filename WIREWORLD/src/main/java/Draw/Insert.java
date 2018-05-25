package Draw;

import StateTable.Field;
import StateTable.FieldState;

public class Insert implements PenState{

    private FieldState fieldState = null ;

    @Override
    public void changePenState(Pen pen){
        pen.setPenState(new Insert());
    }

    @Override
    public FieldState getFieldState() {
        return fieldState;
    }


}
