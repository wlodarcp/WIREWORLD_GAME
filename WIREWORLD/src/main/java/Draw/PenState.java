package Draw;

import StateTable.FieldState;

public interface PenState {

   public void changePenState(Pen pen);

   public FieldState getFieldState();
}
