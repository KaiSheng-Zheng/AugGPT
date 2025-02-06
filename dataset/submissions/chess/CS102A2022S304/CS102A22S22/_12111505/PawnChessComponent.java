import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    Directions directions = new Directions();
    boolean firstMove = true;
    public PawnChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor, source,chessColor.equals(ChessColor.WHITE)?'p':'P');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int MAS;
        ArrayList<ChessboardPoint> list  = new ArrayList<>();
        ChessboardPoint direct;
        if (this.getChessColor().equals(ChessColor.WHITE)) {
            direct = directions.up();
        } else {
            direct = directions.down();
        }
        ArrayList<ChessboardPoint> eatAble = new ArrayList<>();
        eatAble.add(new ChessboardPoint(direct.getX(),direct.getY()+1));
        eatAble.add(new ChessboardPoint(direct.getX(),direct.getY()-1));
        if (firstMove) {
            MAS= 2;
            for (int i = 1; i <= MAS; i++) {
                ChessboardPoint nextPosition = new ChessboardPoint(this.getSource().getX() + direct.getX() * i, this.getSource().getY());

                if (!nextPosition.offset()) {
                    if (this.getGame().getChess(nextPosition.getX(), nextPosition.getY()).getChessColor().equals(this.getChessColor())) {
                        break;
                    }
                    if(this.getGame().getChess(nextPosition.getX(), nextPosition.getY()).getChessColor().equals(ChessColor.NONE)) {
                        list.add(nextPosition);
                    } else {
                        break;
                    }
                }
                else {
                    break;
                }
            }
            firstMove = false;
        } else {
            MAS = 1;
            for (int i = 1; i <= MAS; i++) {
                ChessboardPoint nextPosition = new ChessboardPoint(this.getSource().getX() + direct.getX() * i, this.getSource().getY());
                if (!nextPosition.offset()) {
                    if (this.getGame().getChess(nextPosition.getX(), nextPosition.getY()).getChessColor().equals(this.getChessColor())) {
                        break;
                    }
                    if(this.getGame().getChess(nextPosition.getX(), nextPosition.getY()).getChessColor().equals(ChessColor.NONE)) {
                        list.add(nextPosition);
                    } else {
                        break;
                    }
                }
                else {
                    break;
                }
            }

        }
        MAS = 1;
        for (ChessboardPoint dire : eatAble) {
            for (int i = 1; i <= MAS; i++) {
                ChessboardPoint nextPosition = new ChessboardPoint(this.getSource().getX() + dire.getX() * i, this.getSource().getY() + dire.getY() * i);
                if (!nextPosition.offset()) {
                    if (!this.getGame().getChess(nextPosition.getX(), nextPosition.getY()).getChessColor().equals(this.getChessColor()) && !this.getGame().getChess(nextPosition.getX(), nextPosition.getY()).getChessColor().equals(ChessColor.NONE)) {
                        list.add(nextPosition);
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        return list;
    }
}