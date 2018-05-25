package Elements;

import StateTable.Conductor;
import StateTable.FieldsTable;

public class CustomGate implements Element {

    private int width = 15;
    private int height = 8;
    private FieldsTable fieldsTable;

    public CustomGate(){
        fieldsTable = new FieldsTable(height,width);
        fieldsTable.findFieldByPosition(0,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(1,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(2,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(3,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(5,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(6,0).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(7,0).setFieldState(new Conductor());

        fieldsTable.findFieldByPosition(8,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(9,1).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(10,1).setFieldState(new Conductor());

        fieldsTable.findFieldByPosition(5,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(7,2).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(11,2).setFieldState(new Conductor());

        fieldsTable.findFieldByPosition(0,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(4,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(5,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(6,3).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(11,3).setFieldState(new Conductor());

        fieldsTable.findFieldByPosition(1,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(3,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(5,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(7,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(9,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(11,4).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(14,4).setFieldState(new Conductor());

        fieldsTable.findFieldByPosition(1,5).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(3,5).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(8,5).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(9,5).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(10,5).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(13,5).setFieldState(new Conductor());

        fieldsTable.findFieldByPosition(1,6).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(3,6).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(9,6).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(11,6).setFieldState(new Conductor());
        fieldsTable.findFieldByPosition(12,6).setFieldState(new Conductor());

        fieldsTable.findFieldByPosition(2,7).setFieldState(new Conductor());
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
