package Elements;

import StateTable.Conductor;
import StateTable.FieldsTable;

public class DiodeSmallLeft implements Element {

    private int width = 4;
    private int height = 3;
    private FieldsTable fieldsTable;


    public DiodeSmallLeft(){
        fieldsTable = new FieldsTable(height,width);
        fieldsTable.findFieldByPosition(1,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(2,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(0,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(1,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(3,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(1,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(2,2).setFieldState(new Conductor());

    }


    @Override
    public FieldsTable getFieldsTable() {
        return fieldsTable;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
