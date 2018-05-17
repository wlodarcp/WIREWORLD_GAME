package StateTable;


public class Field  {
    private Neighborhood neighborhood;
    private FieldState fieldState;
    private Position position;

    public Field(Position position){
        this.neighborhood = new Neighborhood();
        this.fieldState = new Empty();
        this.position = position;
    }

    @Override
    public String toString() {
        return fieldState.toString();
    }

    public void changeState(){
        fieldState.changeState(this);
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public FieldState getFieldState() {
        return fieldState;
    }

    public void setFieldState(FieldState fieldState) {
        this.fieldState = fieldState;
    }

    public Position getPosition() {
        return position;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }
}
