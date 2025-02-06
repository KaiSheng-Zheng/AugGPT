
public class Position{
    private int row;
    private int col;
    public Position(int row,int col){
        set(row,col);
    }
    public Position(Position position){
        set(position);
    }
    public void set(int row,int col){
        this.row=row;
        this.col=col;
    }
    public void set(Position position){
        set(position.row,position.col);
    }
    public static Position sum(Position position1,Position position2){
        return new Position(position1.row+position2.row,position1.col+position2.col);
    }
    public void add(Position vector){
        set(sum(this,vector));
    }
    public boolean isOutside(int rowBound,int colBound){
        return row<0||row>=rowBound||col<0||col>=colBound;
    }
    public String toString(){
        return String.format("(%d,%d)",row,col);
    }
    public boolean equals(Object object){
        if(object==null)
            return false;
        if(!(object instanceof Position))
            return false;
        Position position=(Position)object;
        if(this.row==position.row&&this.col==position.col)
            return true;
        else
            return false;
    }
}
