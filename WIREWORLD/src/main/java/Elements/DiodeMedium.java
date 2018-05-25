package Elements;

import StateTable.Conductor;
import StateTable.FieldsTable;

public class DiodeMedium implements Element {

    private int width = 6;
    private int height = 5;
    private FieldsTable fieldsTable;


    public DiodeMedium(){
        fieldsTable = new FieldsTable(height,width);
        fieldsTable.findFieldByPosition(2,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(3,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(0,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(1,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(3,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(5,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(0,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(1,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(2,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(3,4).setFieldState(new Conductor());

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
