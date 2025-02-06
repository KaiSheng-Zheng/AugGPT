import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(){}
    public ChessComponent(int x,int y,char name){
        source=new ChessboardPoint(x,y);
        this.name=name;
        if(name=='_')
        {
            chessColor=ChessColor.NONE;
        }
        else if(Character.isLowerCase(name))
            chessColor=ChessColor.WHITE;
        else
            chessColor=ChessColor.BLACK;

    }
    public ChessboardPoint getPoint(){return this.source;}
    public ChessColor getChessColor(){return chessColor;}
    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public char getName(){return name;
    }
    public ChessComponent getComponent(ChessComponent[][]components,ChessboardPoint point){
        return components[point.getX()][point.getY()];
    }
    public void setSource(ChessboardPoint p){
        this.source=p;
    }
}
