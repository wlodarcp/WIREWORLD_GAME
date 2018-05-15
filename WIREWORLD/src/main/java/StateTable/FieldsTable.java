package StateTable;


public class FieldsTable {
    private Field[][] fieldsArray;
    private int height;
    private int width;

    public FieldsTable(int height, int width) {
        this.height = height;
        this.width = width;
        fieldsArray = new Field[width][height];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                Field field = new Field(new Position(j, i));
                fieldsArray[j][i] = field;
            }
    }

    public Field findFieldByPosition(int x, int y) {
        if (y >= 0 && y < height && x >= 0 && x < width)
            return fieldsArray[x][y];
        return null;
    }

    public void countNeighbors(Field field) {
        field.setNeighborhood(new Neighborhood());
        int x = field.getPosition().getX();
        int y = field.getPosition().getY();
        Field temporaryField;
        for (int i = y - 1; i <= y + 1; i++)
            for (int j = x - 1; j <= x + 1; j++) {
                temporaryField = this.findFieldByPosition(j, i);
                if (temporaryField != null && (i != y || j != x)) {
                    if (temporaryField.getFieldState() instanceof Empty)
                        field.getNeighborhood().addEmpty();
                    if (temporaryField.getFieldState() instanceof Tail)
                        field.getNeighborhood().addTail();
                    if (temporaryField.getFieldState() instanceof Conductor)
                        field.getNeighborhood().addConductor();
                    if (temporaryField.getFieldState() instanceof Head)
                        field.getNeighborhood().addHead();
                }
            }
    }

    public void checkNeighborhoodForAll() {
        for (int i = 0; i < this.height; i++)
            for (int j = 0; j < this.width; j++)
                countNeighbors(this.fieldsArray[j][i]);
    }

    public void changeStateForAll(){
        for (int i = 0; i < this.height; i++)
            for (int j = 0; j < this.width; j++)
                this.fieldsArray[j][i].changeState();
    }

    public Field[][] getFieldsArray() {
        return fieldsArray;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
