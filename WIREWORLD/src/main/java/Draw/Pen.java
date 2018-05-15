package Draw;

import StateTable.*;
import javafx.util.Pair;


public class Pen {

    private PenState penState = new DrawingWire();
    private Element element;
    private MouseHandler mouseHandler;
    private FieldsTable fieldsTable;

    public Pen (FieldsTable fieldsTable){
        this.fieldsTable = fieldsTable;
    }

    public FieldsTable getFieldsTable() { return fieldsTable; }

    public void setFieldsTable(FieldsTable fieldsTable) {this.fieldsTable = fieldsTable;}

    public PenState getPenState() {
        return penState;
    }

    public void setPenState(PenState penState) {
        this.penState = penState;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public MouseHandler getMouseHandler() {
        return mouseHandler;
    }

    public void setMouseHandler(MouseHandler mouseHandler) {
        this.mouseHandler = mouseHandler;
    }

    public void changePenState(Pen pen){
        this.penState.changePenState(pen);
    }

    public void affectField(Position position, double widthOfField, double heightOfField){

        int x = position.getX();
        int y = position.getY();

        x= (int) (x/widthOfField);
        y = (int) (y/heightOfField);

        fieldsTable.findFieldByPosition(x,y).setFieldState(this.penState.getFieldState());
    }


}
