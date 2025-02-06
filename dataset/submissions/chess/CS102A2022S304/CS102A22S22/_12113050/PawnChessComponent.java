import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.WHITE) {
            name = 'p';
        } else {
            name = 'P';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Pawn = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getSource().getX() == 1) {
                    if ((i - getSource().getX() == 1 || i - getSource().getX() == 2) && getSource().getY() == j &&
                            getChessComponents()[i][j].getChessColor() == ChessColor.NONE) {
                        ChessboardPoint n = new ChessboardPoint(i, j);
                        Pawn.add(n);//buchiziqiekeyizouliangbu
                    }
                    if (i - getSource().getX() == 1 && Math.abs(getSource().getY() - j) == 1 &&
                            getChessComponents()[i][j].getChessColor() != this.getChessColor() &&
                            getChessComponents()[i][j].getChessColor() != ChessColor.NONE) {
                        ChessboardPoint n = new ChessboardPoint(i, j);
                        Pawn.add(n);//chizizouyibu
                    }
                }
                else if (getSource().getX() == 6) {
                    if ((getSource().getX() - i == 1 || getSource().getX() - i == 2) && getSource().getY() == j &&
                            getChessComponents()[i][j].getChessColor() == ChessColor.NONE) {
                        ChessboardPoint n = new ChessboardPoint(i, j);
                        Pawn.add(n);//buchiziqiekeyizouliangbu
                    }
                    if (getSource().getX() - i == 1 &&Math.abs(getSource().getY() - j) == 1 &&
                            getChessComponents()[i][j].getChessColor() != this.getChessColor() &&
                            getChessComponents()[i][j].getChessColor() != ChessColor.NONE) {
                        ChessboardPoint n = new ChessboardPoint(i, j);
                        Pawn.add(n);//chizizouyibu
                    }
                }
               else if (this.getChessColor()==ChessColor.WHITE){
                    if (getSource().getX() - i == 1 && getSource().getY() == j &&
                            getChessComponents()[i][j].getChessColor() == ChessColor.NONE) {
                        ChessboardPoint n = new ChessboardPoint(i, j);
                        Pawn.add(n);//buchiziqiekeyizouliangbu
                    }
                    if (getSource().getX() - i == 1 && Math.abs(getSource().getY() - j) == 1 &&
                            getChessComponents()[i][j].getChessColor() != this.getChessColor() &&
                            getChessComponents()[i][j].getChessColor() != ChessColor.NONE) {
                        ChessboardPoint n = new ChessboardPoint(i, j);
                        Pawn.add(n);//chizizouyibu
                    }

                }
                else if (this.getChessColor()==ChessColor.BLACK) {
                    if (i - getSource().getX() == 1  && getSource().getY() == j &&
                            getChessComponents()[i][j].getChessColor() == ChessColor.NONE) {
                        ChessboardPoint n = new ChessboardPoint(i, j);
                        Pawn.add(n);//buchiziqiekeyizouliangbu
                    }
                    if (i - getSource().getX() == 1&&Math.abs(getSource().getY() - j) == 1 &&
                            getChessComponents()[i][j].getChessColor() != this.getChessColor() &&
                            getChessComponents()[i][j].getChessColor() != ChessColor.NONE) {
                        ChessboardPoint n = new ChessboardPoint(i, j);
                        Pawn.add(n);//chizizouyibu
                    }
                }
            }
        }
        return Pawn;
    }
}