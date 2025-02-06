public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setsp(Treasure temp[],int i,int j) {
        while (i < temp.length) {
            try {
                this.treasures[i] = temp[j];
            } catch (NullPointerException e) {
                setsp(temp, i ,j+1);
            }
            if (j==temp.length-1){
                for (int k = i+1; k < temp.length; k++) {
                    this.treasures[k]= new Treasure(0,new Position(0,0));
                    this.treasures[k].setFind(true);
                }
            }
            i++;
            j++;
        }

    }
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=new Treasure[treasures.length];
        Treasure[] temp = new Treasure[treasures.length];
        for (int i = 0; i < treasures.length; i++) {
            Boolean test =true;
            for (int j = 0; j < i; j++) {
                if (treasures[i].getPosition().equals(treasures[j].getPosition())) {
                    test= false;
                }
            }
            if (test) temp[i] = treasures[i];

        }
        setsp(temp,0,0);


        isActive=true;
    }
    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (!treasures[i].isFind()&&treasures[i].getPosition().equals(position)){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (!treasures[i].isFind()&treasures[i].getPosition().equals(position)){
                treasures[i].setFind(true);
                break;
            }
        }
        isActive=false;
        for (int i = 0; i < treasures.length; i++) {
            if (!treasures[i].isFind()){
                isActive=true;
                break;
            }
        }

    }


}
