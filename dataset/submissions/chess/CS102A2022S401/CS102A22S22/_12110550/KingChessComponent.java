import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessboardPoint point=getSource();

        if(point.offset(1,1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()+1,point.getY()+1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(-1,-1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()-1,point.getY()-1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(1,-1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()+1,point.getY()-1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(-1,1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()-1, point.getY()+1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(0,1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX(), point.getY()+1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(0,-1)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX(), point.getY()-1);
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(1,0)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()+1,point.getY());
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        if(point.offset(-1,0)!=null){
            ChessboardPoint add=new ChessboardPoint(point.getX()-1,point.getY());
            if(judge(getChessColor(),add)){
                move.add(add);
            }
        }

        return move;
    }
}
