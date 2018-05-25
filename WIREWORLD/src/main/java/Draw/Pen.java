package Draw;

import Elements.Element;
import StateTable.*;


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
        if (this.penState instanceof Insert){
            for (int i = 0; i <  this.getElement().getHeight(); i++){
                for (int j = 0; j < this.getElement().getWidth(); j++){
                    if (fieldsTable.findFieldByPosition(x+j, y+i)!= null)
                    fieldsTable.findFieldByPosition(x+j,y+i).setFieldState(element.getFieldsTable().findFieldByPosition(j,i).getFieldState());

                }
            }

        }else {
            if (fieldsTable.findFieldByPosition(x, y)== null){}
            else fieldsTable.findFieldByPosition(x, y).setFieldState(this.penState.getFieldState());
        }
    }


}
