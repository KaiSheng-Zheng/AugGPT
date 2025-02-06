import java.util.List;

public abstract class ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ConcreteChessGame game;

    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public ChessComponent(char name,char color,int x,int y) {
        this.name=name;
        if(color=='w'){
            this.chessColor= ChessColor.WHITE;
        }else if(color=='b'){
            this.chessColor= ChessColor.BLACK;
        }else{
            this.chessColor= ChessColor.NONE;
        }
        source=new ChessboardPoint(x,y);
    }
    public ChessboardPoint getSource(){
        return source;
    }
    public ChessColor getChessColor(){
        return this.chessColor;
    }
}
