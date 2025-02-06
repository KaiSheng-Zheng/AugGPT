import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessComponent chess ;
    private ChessComponent movedChess ;
    private List<ChessboardPoint> canMoveList;
    public QueenChessComponent(char name){
        this.name=name;
        if (name=='Q'){
            setChessColor(ChessColor.BLACK);}
        else {setChessColor(ChessColor.WHITE);}
    }
    public QueenChessComponent(){

        this.name=name;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {ChessComponent[][] chessboard = ChessComponent.chessboard;
        canMoveList = new ArrayList<>();
        ChessboardPoint origin = new ChessboardPoint(this.getSource().getX(),this.getSource().getY());
        for (int i = this.getSource().getY()+1; i < 8; i++) {

            ChessboardPoint toMove = new ChessboardPoint(this.getSource().getX(),i);
            movedChess = chessboard[this.getSource().getX()][i];
            if (movedChess.getChessColor() == this.getChessColor()){break;}
            else if (movedChess.getChessColor() == ChessColor.NONE){canMoveList.add(toMove);}
            else {canMoveList.add(toMove);break;}

        }
        for (int i = this.getSource().getY()-1; i > -1; i--) {

            ChessboardPoint toMove = new ChessboardPoint(this.getSource().getX(),i);
            movedChess = chessboard[this.getSource().getX()][i];
            if (movedChess.getChessColor() == this.getChessColor()){break;}
            else if (movedChess.getChessColor() == ChessColor.NONE){canMoveList.add(toMove);}
            else {canMoveList.add(toMove);break;}

        }
        for (int i = this.getSource().getX()+1; i < 8; i++) {

            ChessboardPoint toMove = new ChessboardPoint(i,this.getSource().getY());
            movedChess = chessboard[i][this.getSource().getY()];
            if (movedChess.getChessColor() == this.getChessColor()){break;}
            else if (movedChess.getChessColor() == ChessColor.NONE){canMoveList.add(toMove);}
            else {canMoveList.add(toMove);break;}

        }
        for (int i = this.getSource().getX()-1; i > -1; i--) {

            ChessboardPoint toMove = new ChessboardPoint(i,this.getSource().getY());
            movedChess = chessboard[i][this.getSource().getY()];
            if (movedChess.getChessColor() == this.getChessColor()){break;}
            else if (movedChess.getChessColor() == ChessColor.NONE){canMoveList.add(toMove);}
            else {canMoveList.add(toMove);break;}

        }
        ChessComponent movedChess;
        for (int i = 1; i < 8; i++) {

            ChessboardPoint toMove = new ChessboardPoint(this.getSource().getX() + i, this.getSource().getY() + i);
            if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
                movedChess = chessboard[this.getSource().getX() + i][this.getSource().getY() + i];
                if (movedChess.getChessColor() == ChessColor.NONE) {
                    canMoveList.add(toMove);
                    continue;
                } else if (movedChess.getChessColor() == this.getChessColor()) {

                    break;
                } else {
                    canMoveList.add(toMove);
                    break;
                }
            }

        }
        for (int i = 1; i < 8; i++) {

            ChessboardPoint toMove = new ChessboardPoint(this.getSource().getX() - i, this.getSource().getY() - i);

            if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
                movedChess = chessboard[this.getSource().getX() - i][this.getSource().getY() - i];

                if (movedChess.getChessColor() == this.getChessColor()) {
                    break;
                } else if (movedChess.getChessColor() == ChessColor.NONE) {
                    canMoveList.add(toMove);
                } else {
                    canMoveList.add(toMove);
                    break;
                }
            }

        }
        for (int i = 1; i < 8; i++) {

            ChessboardPoint toMove = new ChessboardPoint(this.getSource().getX() + i, this.getSource().getY() - i);
            if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
                movedChess = chessboard[this.getSource().getX() + i][this.getSource().getY() - i];
                if (movedChess.getChessColor() == this.getChessColor()) {
                    break;
                } else if (movedChess.getChessColor() == ChessColor.NONE) {
                    canMoveList.add(toMove);
                } else {
                    canMoveList.add(toMove);
                    break;
                }
            }

        }
        for (int i = 1; i < 8; i++) {

            ChessboardPoint toMove = new ChessboardPoint(this.getSource().getX() - i, this.getSource().getY() + i);
            if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
                movedChess = chessboard[this.getSource().getX() - i][this.getSource().getY() + i];
                if (movedChess.getChessColor() == this.getChessColor()) {
                    break;
                } else if (movedChess.getChessColor() == ChessColor.NONE) {
                    canMoveList.add(toMove);
                } else {
                    canMoveList.add(toMove);
                    break;
                }
            }

        }
        canMoveList.remove(origin);
        return canMoveList;
    }

    public void setChess(ChessComponent chess) {
        this.chess = chess;
    }

    public void setMovedChess(ChessComponent movedChess) {
        this.movedChess = movedChess;
    }
}

