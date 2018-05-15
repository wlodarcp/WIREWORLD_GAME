package StateTable;


import javafx.scene.paint.Color;

public class Head implements FieldState {
    private final Color color = Color.RED;

    public Head() { }

    @Override
    public void changeState(Field field){
        field.setFieldState(new Tail());
    }

    @Override
    public Color getColor(){
        return this.color;
    }


}
