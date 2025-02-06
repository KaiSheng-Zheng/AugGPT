import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
    public List<ChessboardPoint> canMoveto(){

            List<ChessboardPoint> a = new ArrayList<>();
            for (int i = 1; i <= this.getSource().getX(); i++) {
                if (chessboard[this.getSource().getX() - i][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    a.add(this.getSource().offset(-i, 0));
                } else if (chessboard[this.getSource().getX() - i][this.getSource().getY()].getChessColor().equals(chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                    break;
                } else {
                    a.add(this.getSource().offset(-i, 0));
                    break;
                }
            }

            for (int i = 1; i <= 7-this.getSource().getX(); i++) {
                if (chessboard[this.getSource().getX() +i][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    a.add(this.getSource().offset(i, 0));
                } else if (chessboard[this.getSource().getX() +i][this.getSource().getY()].getChessColor().equals(chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                    break;
                } else {
                    a.add(this.getSource().offset(i, 0));
                    break;
                }
            }

            for (int i = 1; i <= 7-this.getSource().getY(); i++) {
                if (chessboard[this.getSource().getX() ][this.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    a.add(this.getSource().offset(0, i));
                } else if (chessboard[this.getSource().getX() ][this.getSource().getY()+i].getChessColor().equals(chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                    break;
                } else {
                    a.add(this.getSource().offset(0, i));
                    break;
                }
            }

            for (int i = 1; i <= this.getSource().getY(); i++) {
                if (chessboard[this.getSource().getX() ][this.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    a.add(this.getSource().offset(0, -i));
                } else if (chessboard[this.getSource().getX() ][this.getSource().getY()-i].getChessColor().equals(chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
                    break;
                } else {
                    a.add(this.getSource().offset(0,-i));
                    break;
                }
            }
            return a;
        }

        @Override
        public String toString() {
            return String.valueOf(name);
        }
    }


