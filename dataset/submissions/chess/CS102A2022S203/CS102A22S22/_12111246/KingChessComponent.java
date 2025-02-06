import java.util.ArrayList;
import java.util.List;


public class KingChessComponent extends ChessComponent {
    private ChessComponent chess;
    private ChessComponent movedChess;

    public KingChessComponent(char name) {
        this.name = name;
        if (name == 'K') {
            setChessColor(ChessColor.BLACK);
        } else {
            setChessColor(ChessColor.WHITE);
        }
    }

    public KingChessComponent() {
    }

    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessboard = ChessComponent.chessboard;
        ChessboardPoint origin = new ChessboardPoint(this.getSource().getX(), this.getSource().getY());
        this.setSource(origin);
        List<ChessboardPoint> canMoveList = new ArrayList<>();

        ChessboardPoint toMove = new ChessboardPoint(getSource().getX(), getSource().getY() + 1);


        if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
            movedChess = chessboard[getSource().getX()][this.getSource().getY() + 1];
            if (movedChess.getChessColor() != this.getChessColor()) {
                canMoveList.add(toMove);
            }
        }

        toMove = new ChessboardPoint(getSource().getX(), getSource().getY() - 1);

        if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
            movedChess = chessboard[getSource().getX()][this.getSource().getY() - 1];
            if (movedChess.getChessColor() != this.getChessColor()) {
                canMoveList.add(toMove);
            }
        }

        toMove = new ChessboardPoint(getSource().getX() + 1, getSource().getY());

        if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
            movedChess = chessboard[getSource().getX()+1][this.getSource().getY() ];
            if (movedChess.getChessColor() != this.getChessColor()) {
                canMoveList.add(toMove);
            }
        }

        toMove = new ChessboardPoint(getSource().getX() - 1, getSource().getY());

        if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
            movedChess = chessboard[getSource().getX()-1][this.getSource().getY() ];
            if (movedChess.getChessColor() != this.getChessColor()) {
                canMoveList.add(toMove);
            }
        }

        toMove = new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1);

        if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
            movedChess = chessboard[getSource().getX()+1][this.getSource().getY() + 1];
            if (movedChess.getChessColor() != this.getChessColor()) {
                canMoveList.add(toMove);
            }
        }

        toMove = new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1);

        if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
            movedChess = chessboard[getSource().getX()+1][this.getSource().getY() - 1];
            if (movedChess.getChessColor() != this.getChessColor()) {
                canMoveList.add(toMove);
            }
        }

        toMove = new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1);

        if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
            movedChess = chessboard[getSource().getX()-1][this.getSource().getY() + 1];
            if (movedChess.getChessColor() != this.getChessColor()) {
                canMoveList.add(toMove);
            }
        }

        toMove = new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1);

        if (toMove.getX() < 8 && toMove.getX() > -1 && toMove.getY() < 8 && toMove.getY() > -1) {
            movedChess = chessboard[getSource().getX()-1][this.getSource().getY() - 1];
            if (movedChess.getChessColor() != this.getChessColor()) {
                canMoveList.add(toMove);
            }
        }


        return canMoveList;
    }


    public void setChess(ChessComponent chess) {
        this.chess = chess;
    }

    public void setMovedChess(ChessComponent movedChess) {
        this.movedChess = movedChess;
    }
//    @Override
//    public List<ChessboardPoint> canMoveTo() {
//        canMoveList = new ArrayList<>();
//
//            canMoveList.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
//            canMoveList.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
//            canMoveList.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
//            canMoveList.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
//
//            canMoveList.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
//            canMoveList.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
//            canMoveList.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
//            canMoveList.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
//        return canMoveList;
//    }
}


