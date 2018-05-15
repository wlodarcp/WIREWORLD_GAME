package StateTable;

public class Position implements Comparable<Position>{
    private int x;
    private int y;


    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Position o) {

        return 0;
    }
}
