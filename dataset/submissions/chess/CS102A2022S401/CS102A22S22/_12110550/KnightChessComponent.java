import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessboardPoint point=getSource();

        if(point.offset(1,2)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()+1,point.getY()+2);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(2,1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()+2,point.getY()+1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(1,-2)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()+1,point.getY()-2);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(2,-1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()+2, point.getY()-1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(-1,2)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()-1, point.getY()+2);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(-2,1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()-2, point.getY()+1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(-2,-1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()-2,point.getY()-1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(-1,-2)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()-1,point.getY()-2);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }
            return move;
    }
}
