import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private List<String> SourcePoints;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int X=super.getSource().getX(); int Y=super.getSource().getY();
        List<ChessboardPoint> move=new ArrayList<>();
        if (super.getChessColor()==ChessColor.BLACK){
            if (X+2<8&&Y+1<8){
                if ((int)SourcePoints.get(X+2).charAt(Y+1)>94){move.add(new ChessboardPoint(X+2,Y+1));}
            }
            if (X+1<8&&Y+2<8){
                if ((int)SourcePoints.get(X+1).charAt(Y+2)>94){move.add(new ChessboardPoint(X+1,Y+2));}
            }
            if (X+2<8&&Y-1>=0){
                if ((int)SourcePoints.get(X+2).charAt(Y-1)>94){move.add(new ChessboardPoint(X+2,Y-1));}
            }
            if (X+1<8&&Y-2>=0){
                if ((int)SourcePoints.get(X+1).charAt(Y-2)>94){move.add(new ChessboardPoint(X+1,Y-2));}
            }
            if (X-2>=0&&Y+1<8){
                if ((int)SourcePoints.get(X-2).charAt(Y+1)>94){move.add(new ChessboardPoint(X-2,Y+1));}
            }
            if (X-1>=0&&Y+2<8){
                if ((int)SourcePoints.get(X-1).charAt(Y+2)>94){move.add(new ChessboardPoint(X-1,Y+2));}
            }
            if (X-2>=0&&Y-1>=0){
                if ((int)SourcePoints.get(X-2).charAt(Y-1)>94){move.add(new ChessboardPoint(X-2,Y-1));}
            }
            if (X-1>=0&&Y-2>=0){
                if ((int)SourcePoints.get(X-1).charAt(Y-2)>94){move.add(new ChessboardPoint(X-1,Y-2));}
            }}
        if (super.getChessColor()==ChessColor.WHITE){
            if (X+2<8&&Y+1<8){
                if ((int)SourcePoints.get(X+2).charAt(Y+1)<96){move.add(new ChessboardPoint(X+2,Y+1));}
            }
            if (X+1<8&&Y+2<8){
                if ((int)SourcePoints.get(X+1).charAt(Y+2)<96){move.add(new ChessboardPoint(X+1,Y+2));}
            }
            if (X+2<8&&Y-1>=0){
                if ((int)SourcePoints.get(X+2).charAt(Y-1)<96){move.add(new ChessboardPoint(X+2,Y-1));}
            }
            if (X+1<8&&Y-2>=0){
                if ((int)SourcePoints.get(X+1).charAt(Y-2)<96){move.add(new ChessboardPoint(X+1,Y-2));}
            }
            if (X-2>=0&&Y+1<8){
                if ((int)SourcePoints.get(X-2).charAt(Y+1)<96){move.add(new ChessboardPoint(X-2,Y+1));}
            }
            if (X-1>=0&&Y+2<8){
                if ((int)SourcePoints.get(X-1).charAt(Y+2)<96){move.add(new ChessboardPoint(X-1,Y+2));}
            }
            if (X-2>=0&&Y-1>=0){
                if ((int)SourcePoints.get(X-2).charAt(Y-1)<96){move.add(new ChessboardPoint(X-2,Y-1));}
            }
            if (X-1>=0&&Y-2>=0){
                if ((int)SourcePoints.get(X-1).charAt(Y-2)<96){move.add(new ChessboardPoint(X-1,Y-2));}
            }
        }
        Collections.sort(move);
        return move;
    }

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name,List<String> ChessList) {
        super(source,chessColor,name,ChessList);
        this.SourcePoints=ChessList;
    }
}
