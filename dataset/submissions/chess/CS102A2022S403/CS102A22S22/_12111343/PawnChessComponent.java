import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessColor chessColor, ChessboardPoint source) {
        super(chessColor,source);
        if (chessColor.equals(ChessColor.BLACK)){
            this.name='P';
        }else{
            this.name='p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        if (super.chessboard[source.getX()][source.getY()].chessColor.equals(ChessColor.BLACK)){
            if (source.getX()==1){
                if (super.chessboard[2][source.getY()].chessColor.equals(ChessColor.NONE)){
                    moveTo.add(new ChessboardPoint(2, source.getY()));
                    if (super.chessboard[3][source.getY()].chessColor.equals(ChessColor.NONE)){
                        moveTo.add(new ChessboardPoint(3, source.getY()));
                    }
                }
            } else {
                if (source.getX()+1<8) {
                    if (super.chessboard[source.getX()+1][source.getY()].chessColor.equals(ChessColor.NONE)) {
                        moveTo.add(new ChessboardPoint(source.getX()+1, source.getY()));
                    }
                }
            }
            if (!super.chessboard[source.getX()+1][source.getY()+1].chessColor.equals(super.chessboard[source.getX()][source.getY()].chessColor)
                    && !super.chessboard[source.getX()+1][source.getY()+1].chessColor.equals(ChessColor.NONE)){
                moveTo.add(new ChessboardPoint(source.getX()+1, source.getY()+1));
            }
            if (!super.chessboard[source.getX()+1][source.getY()-1].chessColor.equals(super.chessboard[source.getX()][source.getY()].chessColor)
                    &&!super.chessboard[source.getX()+1][source.getY()-1].equals(ChessColor.NONE)){
                moveTo.add(new ChessboardPoint(source.getX()+1, source.getY()-1));
            }
        }
        if (super.chessboard[source.getX()][source.getY()].chessColor.equals(ChessColor.WHITE)){
            if (source.getX()==6){
                if (super.chessboard[5][source.getY()].chessColor.equals(ChessColor.NONE)){
                    moveTo.add(new ChessboardPoint(5, source.getY()));
                    if (super.chessboard[4][source.getY()].chessColor.equals(ChessColor.NONE)){
                        moveTo.add(new ChessboardPoint(4, source.getY()));
                    }
                }
            }
            else {
                if (source.getX()-1>=0) {
                    if (super.chessboard[source.getX()-1][source.getY()].chessColor.equals(ChessColor.NONE)) {
                        moveTo.add(new ChessboardPoint(source.getX()-1, source.getY()));
                    }
                }
            }
            if (!super.chessboard[source.getX()-1][source.getY()+1].chessColor.equals(super.chessboard[source.getX()][source.getY()].chessColor)
                    && !super.chessboard[source.getX()-1][source.getY()+1].chessColor.equals(ChessColor.NONE)){
                moveTo.add(new ChessboardPoint(source.getX()-1, source.getY()+1));
            }
            if (!super.chessboard[source.getX()-1][source.getY()-1].chessColor.equals(super.chessboard[source.getX()][source.getY()].chessColor)
                    &&!super.chessboard[source.getX()-1][source.getY()-1].chessColor.equals(ChessColor.NONE)){
                moveTo.add(new ChessboardPoint(source.getX()-1, source.getY()-1));
            }
        }
        return moveTo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}