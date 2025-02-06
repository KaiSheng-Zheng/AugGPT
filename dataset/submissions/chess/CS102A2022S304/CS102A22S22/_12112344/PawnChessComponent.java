import java.util.*;

public class PawnChessComponent extends ChessComponent{
    ArrayList<String> SourcePoints;
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        SourcePoints = (ArrayList<String>) chessboard;
    }

@Override
public List<ChessboardPoint> canMoveTo() {
    int X=super.getSource().getX(); int Y=super.getSource().getY();
    List<ChessboardPoint> move=new ArrayList<>();
    if (super.getChessColor()==ChessColor.BLACK){
        if (X+1<8){
            if (SourcePoints.get(X+1).charAt(Y)=='_'){
                move.add(new ChessboardPoint(X+1,Y));
            }
        }
        if (X==1){
            if ((int)SourcePoints.get(X+2).charAt(Y)=='_'){
                move.add(new ChessboardPoint(X+2,Y));
            }}
        if (X+1<8&&Y+1<8){
            if ((int)SourcePoints.get(X+1).charAt(Y+1)>96){
                move.add(new ChessboardPoint(X+1,Y+1));
            }}
        if (X+1<8&&Y-1>=0){
            if ((int)SourcePoints.get(X+1).charAt(Y-1)>96){
                move.add(new ChessboardPoint(X+1,Y-1));
            }}
    }
    if (super.getChessColor()==ChessColor.WHITE){
        if (X-1>=0){
            if (SourcePoints.get(X-1).charAt(Y)=='_'){
                move.add(new ChessboardPoint(X-1,Y));
            }
        }
        if (X==7){
            if ((int)SourcePoints.get(X-2).charAt(Y)=='_'){
                move.add(new ChessboardPoint(X-2,Y));
            }}
        if (X-1>=0&&Y-1>=0){
            if ((int)SourcePoints.get(X-1).charAt(Y-1)<91){
                move.add(new ChessboardPoint(X-1,Y-1));
            }}
        if (X-1>=0&&Y+1<8){
            if ((int)SourcePoints.get(X-1).charAt(Y+1)<91){
                move.add(new ChessboardPoint(X-1,Y+1));
            }}
    }

           for (int k=0;k<move.size();k++){
           for (int l=k+1;l<move.size();l++){
                if (move.get(k).getX()>move.get(l).getX()){
Collections.swap(move,k,l);
               }else if (move.get(k).getX()==move.get(l).getX()&&move.get(k).getY()>move.get(l).getY()){
                    Collections.swap(move,k,l);
                }
            }
       }
    return move;
}
}

