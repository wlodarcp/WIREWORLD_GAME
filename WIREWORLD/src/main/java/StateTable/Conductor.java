package StateTable;


import javafx.scene.paint.Color;

public class Conductor implements FieldState {
    private static Color color = Color.YELLOW;

    public Conductor() {
    }

    @Override
    public void changeState(Field field) {
        if(field.getNeighborhood().getHowManyheads() == 1 || field.getNeighborhood().getHowManyheads() == 2){
            field.setFieldState(new Head());
        }
    }

    @Override
    public Color getColor(){
        return this.color;
    }

    @Override
    public String toString() {
        return "Conductor";
    }

    public static void setColor(Color c){
        color = c;
    }
}
