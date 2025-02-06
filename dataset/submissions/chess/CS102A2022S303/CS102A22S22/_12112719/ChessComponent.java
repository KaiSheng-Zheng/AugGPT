import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name; // declare "name" twice in the parent and the child class

    public ConcreteChessGame currentgame;

    public void setSource(ChessboardPoint source) {
        this.source.setX(source.getX());
        this.source.setY(source.getY());
    }

    public void setCurrentgame(ConcreteChessGame currentgame) {
        this.currentgame = currentgame;
    }

    public ChessGame getCurrentgame() {
        return currentgame;
    }
//    public ArrayList<ChessComponent> chessPos;

    //should design
    public ChessComponent(){};
//    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
//        this.source=source;
//        this.chessColor=chessColor;
//        this.name=name;
//        chessPos.add(this);
//    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

//    public ArrayList<ChessComponent> getChessPos() {
//        return chessPos;
//    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void addChess(ChessboardPoint Chess){

    }
    public char getName() {
        return name;
    }
}
