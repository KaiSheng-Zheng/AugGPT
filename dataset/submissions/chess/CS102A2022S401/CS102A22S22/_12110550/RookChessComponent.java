import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessboardPoint point=getSource();

        for (int i = 1; ; i++) {
            if(point.offset(0,i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX(),point.getY()+i);
                ChessComponent now=getChess(point.getX(),point.getY()+i);
                if(now.name!='_'){
                    if(now.getChessColor()==this.getChessColor()){
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
            if(point.offset(0,-i)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX(),point.getY()-i);
                ChessComponent now=getChess(point.getX(),point.getY()-i);
                if(now.name!='_'){
                    if(now.getChessColor()==this.getChessColor()){
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
            if(point.offset(i,0)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()+i,point.getY());
                ChessComponent now=getChess(point.getX()+i,point.getY());
                if(now.name!='_'){
                    if(now.getChessColor()==this.getChessColor()){
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
            if(point.offset(-i,0)!=null){
                ChessboardPoint add=new ChessboardPoint(point.getX()-i,point.getY());
                ChessComponent now=getChess(point.getX()-i,point.getY());
                if(now.name!='_'){
                    if(now.getChessColor()==this.getChessColor()){
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
