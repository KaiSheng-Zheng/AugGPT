import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ChessComponent[][]chessComponents;
    private ConcreteChessGame game;

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    protected char name;
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ConcreteChessGame game,ChessComponent[][] chessComponents){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.game=game;
        this.chessComponents=chessComponents;
    }
    public Boolean eatable(int x,int y){
        if (chessComponents[x][y].chessColor!=null&&chessComponents[x][y].chessColor!=this.chessColor)
            return true;
        else
            return false;
    }
    public boolean eatablePlus(int x,int y){
        if (x>=0&&x<8&&y>=0&&y<8){
            if (eatable(x,y)){
                return true;
            }
            else {return false;}
        }
        else {return false;}
    }
    public ChessComponent(){
    }
    public ChessComponent KnowPoint(int x,int y){
        return chessComponents[x][y];
    }
    public ChessColor getChessColor(ChessComponent chessComponent){
        return chessColor;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
public Boolean ifBlank(int x, int y){
    if (chessComponents[x][y].chessColor!=null&&chessComponents[x][y].chessColor==ChessColor.NONE)
        return true;
    else
        return false;
}public void setChessboard(ChessComponent[][] chessboard) {
        this.chessComponents = chessboard;
    }
public Boolean ifBlankPlus(int x,int y){
    if (x>=0&&x<8&&y>=0&&y<8){
        if (chessComponents[x][y].name=='_'){
            return true;
        }
        else {return false;}
    }
    else {return false;}
}

    public ChessColor getChessColor() {
        return chessColor;
    }
}

