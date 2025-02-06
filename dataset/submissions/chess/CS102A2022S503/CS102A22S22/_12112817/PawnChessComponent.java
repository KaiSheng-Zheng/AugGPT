import java.util.ArrayList;
import java.util.List;

class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            this.name='P';
        }
        if (chessColor.equals(ChessColor.WHITE)) {
            this.name='p';
        }
    }
    ArrayList<ChessboardPoint> PawnCanMoveTo=new ArrayList<>();
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[][]canMoveUnit=new int[][]{{-1,0},{-2,0},{-1,-1},{-1,1},  {1,0},{2,0},{1,-1},{1,1}};
        if (chessColor==ChessColor.WHITE) {
            if (source.getX()>=1&&getComponentColor(chessBoard[source.getX()+canMoveUnit[0][0]][source.getY()+canMoveUnit[0][1]].name)==ChessColor.NONE){
                PawnCanMoveTo.add(new ChessboardPoint(source.getX()+canMoveUnit[0][0],source.getY()+canMoveUnit[0][1]));
                if (source.getX()==6&&getComponentColor(chessBoard[source.getX()+canMoveUnit[1][0]][source.getY()+canMoveUnit[1][1]].name)==ChessColor.NONE){
                    PawnCanMoveTo.add(new ChessboardPoint(source.getX()+canMoveUnit[1][0],source.getY()+canMoveUnit[1][1]));
                }}
            if (source.getY()>=1&&getComponentColor(chessBoard[source.getX()+canMoveUnit[2][0]][source.getY()+canMoveUnit[2][1]].name)==ChessColor.BLACK){
                PawnCanMoveTo.add(new ChessboardPoint(source.getX()+canMoveUnit[2][0],source.getY()+canMoveUnit[2][1]));
            }
            if (source.getY()<=6&&getComponentColor(chessBoard[source.getX()+canMoveUnit[3][0]][source.getY()+canMoveUnit[3][1]].name)==ChessColor.BLACK){
                PawnCanMoveTo.add(new ChessboardPoint(source.getX()+canMoveUnit[3][0],source.getY()+canMoveUnit[3][1]));
            }
        }
        else{
            if (source.getX()<=6&&getComponentColor(chessBoard[source.getX()+canMoveUnit[4][0]][source.getY()+canMoveUnit[4][1]].name)==ChessColor.NONE){
                PawnCanMoveTo.add(new ChessboardPoint(source.getX()+canMoveUnit[4][0],source.getY()+canMoveUnit[4][1]));
                if (source.getX()==1&&getComponentColor(chessBoard[source.getX()+canMoveUnit[5][0]][source.getY()+canMoveUnit[5][1]].name)==ChessColor.NONE){
                    PawnCanMoveTo.add(new ChessboardPoint(source.getX()+canMoveUnit[5][0],source.getY()+canMoveUnit[5][1]));
                }
            }
            if (source.getY()>=1&&getComponentColor(chessBoard[source.getX()+canMoveUnit[6][0]][source.getY()+canMoveUnit[6][1]].name)==ChessColor.WHITE){
                PawnCanMoveTo.add(new ChessboardPoint(source.getX()+canMoveUnit[6][0],source.getY()+canMoveUnit[6][1]));
            }
            if (source.getY()<=6&&getComponentColor(chessBoard[source.getX()+canMoveUnit[7][0]][source.getY()+canMoveUnit[7][1]].name)==ChessColor.WHITE){
                PawnCanMoveTo.add(new ChessboardPoint(source.getX()+canMoveUnit[7][0],source.getY()+canMoveUnit[7][1]));
            }
        }
        return PawnCanMoveTo;
    }
}
