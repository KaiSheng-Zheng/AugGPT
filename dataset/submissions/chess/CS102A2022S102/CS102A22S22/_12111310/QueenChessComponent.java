import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public QueenChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Queentrail = new ArrayList<ChessboardPoint>();
        //+x
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(i, 0) != null) {
                ChessColor p =this.getChessComponents()[this.getSource().getX()+i][this.getSource().getY()].getChessColor();
                if (p==this.getChessColor()) {
                    break;
                } else if (p!=this.getChessColor()&&p!=ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(i,0));
                    break;
                } else if (p!=this.getChessColor()&&p==ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(i,0));
                }
            }
        }
        //-x
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(-i, 0) != null) {
                ChessColor p =this.getChessComponents()[this.getSource().getX()-i][this.getSource().getY()].getChessColor();
                if (p==this.getChessColor()) {
                    break;
                } else if (p!=this.getChessColor()&&p!=ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(-i,0));
                    break;
                } else if (p!=this.getChessColor()&&p==ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(-i,0));
                }
            }
        }
        //+y
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(0, i) != null) {
                ChessColor p =this.getChessComponents()[this.getSource().getX()][this.getSource().getY()+i].getChessColor();
                if (p==this.getChessColor()) {
                    break;
                } else if (p!=this.getChessColor()&&p!=ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(0,i));
                    break;
                } else if (p!=this.getChessColor()&&p==ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(0,i));
                }
            }
        }
        //-y
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(0, -i) != null) {
                ChessColor p =this.getChessComponents()[this.getSource().getX()][this.getSource().getY()-i].getChessColor();
                if (p==this.getChessColor()) {
                    break;
                } else if (p!=this.getChessColor()&&p!=ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(0,-i));
                    break;
                } else if (p!=this.getChessColor()&&p==ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(0,-i));
                }
            }
        }
        //++
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(i, i) != null) {
                ChessColor p = this.getChessComponents()[this.getSource().getX() + i][this.getSource().getY() + i].getChessColor();
                if (p == this.getChessColor()) {
                    break;
                } else if (p != this.getChessColor() && p != ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(i, i));
                    break;
                } else if (p != this.getChessColor() && p == ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(i, i));
                }
            }
        }
        //+-
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(i, -i) != null) {
                ChessColor p = this.getChessComponents()[this.getSource().getX() + i][this.getSource().getY() - i].getChessColor();
                if (p == this.getChessColor()) {
                    break;
                } else if (p != this.getChessColor() && p != ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(i, -i));
                    break;
                } else if (p != this.getChessColor() && p == ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(i, -i));
                }
            }
        }
        //-+
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(-i, i) != null) {
                ChessColor p = this.getChessComponents()[this.getSource().getX() - i][this.getSource().getY() + i].getChessColor();
                if (p == this.getChessColor()) {
                    break;
                } else if (p != this.getChessColor() && p != ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(-i, i));
                    break;
                } else if (p != this.getChessColor() && p == ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(-i, i));
                }
            }
        }
        //--
        for (int i = 0; i < 8; i++) {
            if (this.getSource().offset(-i, -i) != null) {
                ChessColor p = this.getChessComponents()[this.getSource().getX() - i][this.getSource().getY() - i].getChessColor();
                if (p == this.getChessColor()) {
                    break;
                } else if (p != this.getChessColor() && p != ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(-i, -i));
                    break;
                } else if (p != this.getChessColor() && p == ChessColor.NONE) {
                    Queentrail.add(this.getSource().offset(-i, -i));
                }
            }
        }
        return Queentrail;
    }

}
