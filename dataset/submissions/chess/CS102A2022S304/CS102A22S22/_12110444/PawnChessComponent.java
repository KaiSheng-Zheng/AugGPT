import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(int x, int y, char name, ChessComponent[][] chessComponent) {
        super(x, y, name);
        this.chessComponents=chessComponent;
    }

    @Override public List<ChessboardPoint> canMoveTo() {
    List<ChessboardPoint> move=new ArrayList<>();
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (moveChess(chessComponents,chessComponents[i][j].getChessboardPoint() )) {
                move.add(chessComponents[i][j].getChessboardPoint());

            }
        }
    }
    if(move.size()==0){
        return new ArrayList<>();
    }else {
        return move;
    }
}
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
    public boolean moveChess(ChessComponent chessComponent[][], ChessboardPoint target) {
        ChessboardPoint source = getChessboardPoint();

        if (source.getX() == 6 && chessComponent[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE) {
            if ((source.getX() - target.getX() == 1 && target.getY() == source.getY()) || (source.getX() - target.getX() == 2 && target.getY() == source.getY()&&(chessComponent[source.getX()-1][source.getY()]instanceof EmptySlotComponent))){
                if (chessComponent[target.getX()][target.getY()].getChessColor() == ChessColor.NONE) {
                    return true;
                }else return false;}
                else if(source.getX()-target.getX()==1&&Math.abs(target.getY()- source.getY())==1&&chessComponents[target.getX()][target.getY()].getChessColor()==ChessColor.BLACK){
                    return true;}
                else{
                    return false;
                }
            }
         else if (source.getX() == 1 && chessComponent[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK) {
            if ((target.getX() - source.getX() == 1 && target.getY() == source.getY()) || (target.getX() - source.getX() == 2 && target.getY() == source.getY()&&(chessComponent[source.getX()+1][source.getY()]instanceof EmptySlotComponent))) {
                if (chessComponent[target.getX()][target.getY()].getChessColor() == ChessColor.NONE) {
                    return true;}
            else return false;
                } else if(target.getX()-source.getX()==1&&Math.abs(target.getY()- source.getY())==1&&chessComponents[target.getX()][target.getY()].getChessColor()==ChessColor.WHITE){
                    return true;}
                else {
                    return false;
            }
        } else if (chessComponent[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE) {
            if (chessComponent[target.getX()][target.getY()].getChessColor() == ChessColor.NONE) {
                if (source.getX() - target.getX() == 1 && source.getY() == target.getY()) {
                    return true;
                } else {
                    return false;
                }
            } else if (chessComponent[target.getX()][target.getY()].getChessColor() == ChessColor.BLACK) {
                if (source.getX() - target.getX() == 1 && Math.abs(source.getY() - target.getY()) == 1) {
                    return true;

                } else {
                    return false;
                }}
                else{return false;}
        } else if (chessComponent[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK) {
            if (chessComponent[target.getX()][target.getY()].getChessColor() == ChessColor.NONE) {
                if (target.getX() - source.getX() == 1 && target.getY() == source.getY()) {
                    return true;
                } else {
                    return false;
                }
            } else if (chessComponent[target.getX()][target.getY()].getChessColor() == ChessColor.WHITE) {
                if (target.getX() - source.getX() == 1 && Math.abs(source.getY() - target.getY()) == 1) {
                    return true;
                } else {
                    return false;
                }
            }else {return false;}
        }
        else{return false;

    }
}}