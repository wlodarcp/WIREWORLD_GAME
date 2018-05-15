package StateTable;

public class main {
    public static void main(String []args){
        FieldsTable table = new FieldsTable(2,4);
        table.checkNeighborhoodForAll();
        for (int i = 0; i < table.getHeight(); i++)
            for (int j = 0; j < table.getWidth(); j++)
                System.out.println("Pozycja X: " +j + " Y: " + i + "Ilosc Empty = " + table.getFieldsArray()[j][i].getNeighborhood().getHowManyEmpty());
        for (int i = 0; i < table.getHeight(); i++)
            for (int j = 0; j < table.getWidth(); j++){
                if( i == j)
                    table.getFieldsArray()[j][i].setFieldState(new Tail());
            }
        table.checkNeighborhoodForAll();
        System.out.println();
        for (int i = 0; i < table.getHeight(); i++) {
            for (int j = 0; j < table.getWidth(); j++) {
                System.out.println("Pozycja X: " + j + " Y: " + i + "Ilosc Empty = " + table.getFieldsArray()[j][i].getNeighborhood().getHowManyEmpty());
                System.out.println("Pozycja X: " + j + " Y: " + i + "Ilosc Tail = " + table.getFieldsArray()[j][i].getNeighborhood().getHowManytails());
            }
        }
        table.changeStateForAll();
        table.checkNeighborhoodForAll();
        System.out.println();
        for (int i = 0; i < table.getHeight(); i++) {
            for (int j = 0; j < table.getWidth(); j++) {
                System.out.println("Pozycja X: " + j + " Y: " + i + "Ilosc Empty = " + table.getFieldsArray()[j][i].getNeighborhood().getHowManyEmpty());
                System.out.println("Pozycja X: " + j + " Y: " + i + "Ilosc Tail = " + table.getFieldsArray()[j][i].getNeighborhood().getHowManytails());
                System.out.println("Pozycja X: " + j + " Y: " + i + "Ilosc Conductor = " + table.getFieldsArray()[j][i].getNeighborhood().getHowManyconductors());
            }
        }


    }
}
