import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ChessComponent implements Cloneable{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected ConcreteChessGame chessBoard;

    public ConcreteChessGame getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ConcreteChessGame chessBoard) {
        this.chessBoard = chessBoard;
    }



    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    protected char name;

    public ChessComponent(){
    }


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

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString(){
        return String.valueOf(this.name);
    }

    @Override
    public ChessComponent clone() {
        ChessComponent chessComponent = null;
        try{
            chessComponent = (ChessComponent) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return chessComponent;
    }

    protected boolean checkOccupied(ChessColor chessColor, ChessComponent chessComponent){
        if (chessColor == ChessColor.BLACK){
            if (Character.isUpperCase(chessComponent.getName())){
                return true;
            }
        } else {
            if (Character.isLowerCase(chessComponent.getName())){
                return true;
            }
        }
        return false;
    }
}

