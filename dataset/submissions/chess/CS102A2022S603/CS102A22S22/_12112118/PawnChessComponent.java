import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private List<String> SourcePoints;

     @Override
    public List<ChessboardPoint> canMoveTo() {
        int X=super.getSource().getX(); int Y=super.getSource().getY();
        List<ChessboardPoint> move=new ArrayList<>();
        if (super.getChessColor()==ChessColor.BLACK){
            if (X==1){
                if (SourcePoints.get(2).charAt(Y)=='_'){move.add(new ChessboardPoint(2,Y));
                    if (SourcePoints.get(3).charAt(Y)=='_'){move.add(new ChessboardPoint(3,Y));}
                }
                if (Y+1<8){if ((int)SourcePoints.get(2).charAt(Y+1)>95){move.add(new ChessboardPoint(2,Y+1));}}
                if (Y-1>=0){if ((int)SourcePoints.get(2).charAt(Y-1)>95){move.add(new ChessboardPoint(2,Y-1));}}
            }
            else if (X+1<8&&X!=1){
                if (SourcePoints.get(X+1).charAt(Y)=='_'){move.add(new ChessboardPoint(X+1,Y));}
                if (Y+1<8){
                    if ((int)SourcePoints.get(X+1).charAt(Y+1)>95){move.add(new ChessboardPoint(X+1,Y+1));}
                }
                if (Y-1>=0){
                    if ((int)SourcePoints.get(X+1).charAt(Y-1)>95){move.add(new ChessboardPoint(X+1,Y-1));}
                }
            }
        }
        if (super.getChessColor()==ChessColor.WHITE){
            if (X==6){
                if (SourcePoints.get(5).charAt(Y)=='_'){move.add(new ChessboardPoint(5,Y));
                    if (SourcePoints.get(4).charAt(Y)=='_'){move.add(new ChessboardPoint(4,Y));}
                }
                if (Y+1<8){if ((int)SourcePoints.get(5).charAt(Y+1)<91){move.add(new ChessboardPoint(5,Y+1));}}
                if (Y-1>=0){if ((int)SourcePoints.get(5).charAt(Y-1)<91){move.add(new ChessboardPoint(5,Y-1));}}
            }
            else if (X-1>=0&&X!=6){
                if (SourcePoints.get(X-1).charAt(Y)=='_'){move.add(new ChessboardPoint(X-1,Y));}
                if (Y+1<8){
                    if ((int)SourcePoints.get(X-1).charAt(Y+1)<91){move.add(new ChessboardPoint(X-1,Y+1));}
                }
                if (Y-1>=0){
                    if ((int)SourcePoints.get(X-1).charAt(Y-1)<91){move.add(new ChessboardPoint(X-1,Y-1));}
                }
            }
        }
        Collections.sort(move);
        return move;
    }
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name,List<String> ChessList) {
        super(source,chessColor,name,ChessList);
        this.SourcePoints=ChessList;

    }
}