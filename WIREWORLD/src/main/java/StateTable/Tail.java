package StateTable;


import javafx.scene.paint.Color;

public class Tail implements FieldState {

    private final Color color = Color.BLUE;

    public Tail() { }

    @Override
    public void changeState(Field field){
        field.setFieldState(new Conductor());
    }

    @Override
    public Color getColor(){
        return this.color;
    }

}
