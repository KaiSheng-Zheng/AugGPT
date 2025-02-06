import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        this.source=chessboardPoint;
        this.chessColor=chessColor;
        this.name=name;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource(){
        return source;
    }

    public void setColor(ChessColor color){
        this.chessColor=color;
    }

    public void setName(char name){
        this.name=name;
    }

    public ChessComponent[][] getChessGame(){
        return chessComponents;
    }

    public ChessColor getColor(){
        return chessColor;
    }

    public void setSource(int x,int y){
        this.source=new ChessboardPoint(x,y);
    }

    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }



}
