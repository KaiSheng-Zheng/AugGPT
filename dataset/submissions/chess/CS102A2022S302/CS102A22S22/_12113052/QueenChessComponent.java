import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(){}
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        this.name=chessColor==ChessColor.BLACK?'Q':'q';
    }


    public List<ChessboardPoint>canMoveTo(){
        List<ChessboardPoint>canMoveTo=new ArrayList<>();
        /*for (int i = 1; i <7 ; i++) {
            if (getSource().getX())
            canMoveTo.add(getSource().offset(i,0));
            canMoveTo.add(getSource().offset(0,i));
            canMoveTo.add(getSource().offset(i,i));
            canMoveTo.add(getSource().offset(-i,i));
            canMoveTo.add(getSource().offset(-i,-i));
            canMoveTo.add(getSource().offset(i,-i));
        }*/
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX()+i<=7) {
                if (chessComponents[getSource().getX()+i][getSource().getY()]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(i, 0));
                } else if (chessComponents[getSource().getX() +i][getSource().getY()].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(i, 0));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getY()+i<=7) {
                if (chessComponents[getSource().getX()][getSource().getY()+i]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(0, i));
                } else if (chessComponents[getSource().getX()][getSource().getY() +i].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(0, i));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX()-i>=0) {
                if (chessComponents[getSource().getX()-i][getSource().getY()]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(-i, 0));
                } else if (chessComponents[getSource().getX() -i][getSource().getY()].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(-i, 0));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getY()-i>=0) {
                if (chessComponents[getSource().getX()][getSource().getY()-i]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(0, -i));
                } else if (chessComponents[getSource().getX() ][getSource().getY()-i].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(0, -i));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX()+i<8&&getSource().getY()+i<8) {
                if (chessComponents[getSource().getX()+i][getSource().getY()+i]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(i, i));
                } else if (chessComponents[getSource().getX() +i][getSource().getY() +i].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(i, i));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX()-i>=0&&getSource().getY()+i<=7) {
                if (chessComponents[getSource().getX()-i][getSource().getY()+i]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(-i, i));
                } else if (chessComponents[getSource().getX() - i][getSource().getY() +i].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(-i, i));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX()-i>=0&&getSource().getY()-i>=0) {
                if (chessComponents[getSource().getX()-i][getSource().getY()-i]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(-i, -i));
                } else if (chessComponents[getSource().getX() - i][getSource().getY() -i].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(-i, -i));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX()+i<8&&getSource().getY()-i>=0) {
                if (chessComponents[getSource().getX()+i][getSource().getY()-i]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(i, -i));
                } else if (chessComponents[getSource().getX() + i][getSource().getY() -i].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(i, -i));
                    break;
                }else break;
            }
        }
        return canMoveTo;
    }


    public ChessColor getCurrentPlayer(){
        if (this.name=='Q'){
            return ChessColor.BLACK;
        }else return ChessColor.WHITE;
    }
}
