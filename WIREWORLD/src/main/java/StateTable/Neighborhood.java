package StateTable;

public class Neighborhood {

    private int howManyEmpty;
    private int howManyheads;
    private int howManyconductors;
    private int howManytails;

    public Neighborhood(){

    }

    public Neighborhood(int howManyEmpty, int howManyheads, int howManyconductors, int howManytails){
        this.howManyEmpty = howManyEmpty;
        this.howManyheads = howManyheads;
        this.howManyconductors = howManyconductors;
        this.howManytails = howManytails;
    }

    public void addEmpty(){
        this.howManyEmpty ++;
    }
    public void addHead(){
        this.howManyheads ++;
    }
    public void addTail(){
        this.howManytails ++;
    }
    public void addConductor(){
        this.howManyconductors ++;
    }
    public int getHowManyEmpty() {
        return howManyEmpty;
    }

    public void setHowManyEmpty(int howManyEmpty) {
        this.howManyEmpty = howManyEmpty;
    }

    public int getHowManyheads() {
        return howManyheads;
    }

    public void setHowManyheads(int howManyheads) {
        this.howManyheads = howManyheads;
    }

    public int getHowManyconductors() {
        return howManyconductors;
    }

    public void setHowManyconductors(int howManyconductors) {
        this.howManyconductors = howManyconductors;
    }

    public int getHowManytails() {
        return howManytails;
    }

    public void setHowManytails(int howManytails) {
        this.howManytails = howManytails;
    }
}
