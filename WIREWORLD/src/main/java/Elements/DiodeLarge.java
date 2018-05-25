package Elements;

import StateTable.Conductor;
import StateTable.FieldsTable;

public class DiodeLarge implements Element{

    private int width = 9;
    private int height = 7;
    private FieldsTable fieldsTable;

    public DiodeLarge(){
        fieldsTable = new FieldsTable(height,width);
        fieldsTable.findFieldByPosition(3,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(2,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(5,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(0,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(1,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(5,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(6,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(7,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(6,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(7,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(8,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(0,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(1,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(5,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(6,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(7,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(2,5).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(5,5).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(3,6).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,6).setFieldState(new Conductor());


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
