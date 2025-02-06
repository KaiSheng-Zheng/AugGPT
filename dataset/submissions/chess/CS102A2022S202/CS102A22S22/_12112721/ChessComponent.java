import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ConcreteChessGame chessGame;

    //should design
    public ChessComponent() {}

    public ChessComponent(ChessboardPoint source, char name, ConcreteChessGame chessGame){
        this.source = source;
        this.name = name;
        this.chessGame = chessGame;
        if (name>='A'&&name<='Z') {
            this.chessColor = ChessColor.BLACK;
        } else if (name>='a'&&name<='z') {
            this.chessColor = ChessColor.WHITE;
        } else this.chessColor = ChessColor.NONE;
    }

    public ConcreteChessGame getChessGame() {
        return chessGame;
    }

    public void setChessGame(ConcreteChessGame chessGame) {
        this.chessGame = chessGame;
    }

    //    public void swapLocation(ChessComponent another) {
//        ChessboardPoint chessboardPoint1 = getSource(), chessboardPoint2 = another.getSource();
//        setSource(chessboardPoint2);
//        another.setSource(chessboardPoint1);
//    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        }catch (CloneNotSupportedException ignore){

        }
        return null;
    }


    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


}
