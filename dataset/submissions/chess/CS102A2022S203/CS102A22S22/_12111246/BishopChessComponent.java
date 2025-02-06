import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {


    public BishopChessComponent(char name) {

        this.name = name;
        if (name == 'B') {
            setChessColor(ChessColor.BLACK);
        } else {
            setChessColor(ChessColor.WHITE);
        }
    }

    public BishopChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {ChessComponent[][] chessboard = ChessComponent.chessboard;
        List<ChessboardPoint> canMoveList = new ArrayList<>();
        ChessComponent movedChess;
        for (int i = 1; i < 8; i++) {


            if (getSource().getX() + i < 8 && getSource().getX() + i > -1 && getSource().getY() + i < 8 && getSource().getY() + i > -1) {

                ChessboardPoint toMove = new ChessboardPoint(getSource().getX() + i, getSource().getY() + i);

                movedChess = getChessboard()[getSource().getX() + i][getSource().getY() + i];
                if (movedChess.getChessColor() == ChessColor.NONE) {
                    canMoveList.add(toMove);
                }
                else if (movedChess.getChessColor() == this.getChessColor()) {
                    break;
                }   else {
                    canMoveList.add(toMove);
                    break;
                }
            }

        }
        for (int i = 1; i < 8; i++) {



            if (getSource().getX() - i < 8 && getSource().getX() - i > -1 && getSource().getY() - i < 8 && getSource().getY() - i > -1) {
                ChessboardPoint toMove = new ChessboardPoint(getSource().getX() - i, getSource().getY() - i);

                movedChess = getChessboard()[getSource().getX() - i][getSource().getY() - i];
                if (movedChess.getChessColor() == ChessColor.NONE) {
                    canMoveList.add(toMove);
                }
                else if (movedChess.getChessColor() == this.getChessColor()) {
                    break;
                }   else {
                    canMoveList.add(toMove);
                    break;
                }
            }

        }
        for (int i = 1; i < 8; i++) {


            if (getSource().getX() + i < 8 && getSource().getX() + i > -1 && getSource().getY() - i < 8 && getSource().getY() - i > -1) {
                ChessboardPoint toMove = new ChessboardPoint(this.getSource().getX() + i, this.getSource().getY() - i);
                movedChess = getChessboard()[getSource().getX() + i][getSource().getY() - i];
                if (movedChess.getChessColor() == ChessColor.NONE) {
                    canMoveList.add(toMove);
                }
                else if (movedChess.getChessColor() == this.getChessColor()) {
                    break;
                }   else {
                    canMoveList.add(toMove);
                    break;
                }
            }

        }
        for (int i = 1; i < 8; i++) {

            if (getSource().getX() - i < 8 && getSource().getX() - i > -1 &&getSource().getY() + i < 8 && getSource().getY() + i > -1) {
                ChessboardPoint toMove = new ChessboardPoint(getSource().getX() - i, getSource().getY() + i);
                movedChess = getChessboard()[getSource().getX() - i][getSource().getY() + i];
                if (movedChess.getChessColor() == ChessColor.NONE) {
                    canMoveList.add(toMove);
                }
                else if (movedChess.getChessColor() == this.getChessColor()) {
                    break;
                }   else {
                    canMoveList.add(toMove);
                    break;
                }
            }

        }

        return canMoveList;
    }
}
