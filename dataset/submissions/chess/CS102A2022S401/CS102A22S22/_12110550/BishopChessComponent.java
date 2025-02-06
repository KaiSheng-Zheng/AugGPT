
import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessboardPoint point=getSource();

        for (int i = 1; ; i++) {
            if(point.offset(i,i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()+i,point.getY()+i);
                ChessComponent now=getChess(point.getX()+i,point.getY()+i);
                if(now.name!='_'){
                    if(now.getChessColor()==getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        for (int i = 1; ; i++) {
            if(point.offset(-i,-i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()-i,point.getY()-i);
                ChessComponent now=getChess(point.getX()-i,point.getY()-i);
                if(now.name!='_'){
                    if(now.getChessColor()==getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        for (int i = 1; ; i++) {
            if(point.offset(-i,i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()-i,point.getY()+i);
                ChessComponent now=getChess(point.getX()-i,point.getY()+i);
                if(now.name!='_'){
                    if(now.getChessColor()==getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }

        for (int i = 1; ; i++) {
            if(point.offset(i,-i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()+i,point.getY()-i);
                ChessComponent now=getChess(point.getX()+i,point.getY()-i);
                if(now.name!='_'){
                    if(now.getChessColor()==getChessColor()){
                        break;
                    }else {
                        move.add(add);
                        break;
                    }
                }
                else {
                    move.add(add);
                }
            }
            else {
                break;
            }
        }
        return move;
    }
}
