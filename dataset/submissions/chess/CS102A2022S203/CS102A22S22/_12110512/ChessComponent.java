import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

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

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }

    protected ChessComponent[][] chessboard;

    public ChessComponent(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public boolean outOfRange(ChessboardPoint destination){

        int x = destination.getX();
        int y = destination.getY();
        boolean OutOfRange = false;

        if (x < 0 || x > 7){
            OutOfRange = true;
        }
        else if (y < 0 || y > 7){
            OutOfRange = true;
        }
        return OutOfRange;
    }

    public boolean canMove(ChessboardPoint destination){

        boolean canMove = false;
        ChessColor chessColor = getChessColor();
        ChessColor destinationColor = chessboard[destination.getX()][destination.getY()].getChessColor();

        if (chessColor != destinationColor){
            canMove = true;
        }
        return canMove;
    }

}

class KingChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();

        //set destination
        ChessboardPoint destination1 = new ChessboardPoint(x-1, y-1);
        ChessboardPoint destination2 = new ChessboardPoint(x-1, y);
        ChessboardPoint destination3 = new ChessboardPoint(x-1, y+1);
        ChessboardPoint destination4 = new ChessboardPoint(x, y-1);
        ChessboardPoint destination5 = new ChessboardPoint(x, y+1);
        ChessboardPoint destination6 = new ChessboardPoint(x+1, y-1);
        ChessboardPoint destination7 = new ChessboardPoint(x+1, y);
        ChessboardPoint destination8 = new ChessboardPoint(x+1, y+1);

        //test whether chess can move
        if (outOfRange(destination1)){
            if (canMove(destination1))
                canMoveTo.add(destination1);
        }
        if (outOfRange(destination2)){
            if (canMove(destination2))
                canMoveTo.add(destination2);
        }
        if (outOfRange(destination3)){
            if (canMove(destination3))
                canMoveTo.add(destination3);
        }
        if (outOfRange(destination4)){
            if (canMove(destination4))
                canMoveTo.add(destination4);
        }
        if (outOfRange(destination5)){
            if (canMove(destination5))
                canMoveTo.add(destination5);
        }
        if (outOfRange(destination6)){
            if (canMove(destination6))
                canMoveTo.add(destination6);
        }
        if (outOfRange(destination7)){
            if (canMove(destination7))
                canMoveTo.add(destination7);
        }
        if (outOfRange(destination8)){
            if (canMove(destination8))
                canMoveTo.add(destination8);
        }


        return canMoveTo;
    }
}

class QueenChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class RookChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class BishopChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class KnightChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

class PawnChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessColor color = getChessColor();
        int x = getSource().getX();
        int y = getSource().getY();

        return canMoveTo;
    }
}

class EmptySlotComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
