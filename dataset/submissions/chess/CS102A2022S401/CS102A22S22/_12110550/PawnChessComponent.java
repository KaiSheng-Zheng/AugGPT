import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessboardPoint point=getSource();

        if(getChessColor()==ChessColor.WHITE){   //6
            if(point.getX()==6){
                    ChessComponent location=getChess(getSource().getX()-2, getSource().getY());
                    ChessboardPoint add=new ChessboardPoint(getSource().getX()-2, getSource().getY());
                    if(location.name=='_'){
                        move.add(add);
                    }
            }

            if(point.offset(-1,0)!=null){
                ChessComponent location=getChess(getSource().getX()-1, getSource().getY());
                ChessboardPoint add=new ChessboardPoint(getSource().getX()-1, getSource().getY());
                if(location.name=='_'){
                    move.add(add);
                }
            }
            if(point.offset(-1,-1)!=null){
                ChessComponent location=getChess(getSource().getX()-1, getSource().getY()-1);
                ChessboardPoint add=new ChessboardPoint(getSource().getX()-1, getSource().getY()-1);
                if(location.name!='_'){
                    if(location.getChessColor()!=this.getChessColor()){
                        move.add(add);
                    }
                }
            }
            if(point.offset(-1,1)!=null){
                ChessComponent location=getChess(getSource().getX()-1, getSource().getY()+1);
                ChessboardPoint add=new ChessboardPoint(getSource().getX()-1, getSource().getY()+1);
                if(location.name!='_'){
                    if(location.getChessColor()!=this.getChessColor()){
                        move.add(add);
                    }
                }
            }


        }else if(getChessColor()==ChessColor.BLACK){  //1
            if(point.getX()==1){
                ChessComponent location=getChess(getSource().getX()+2, getSource().getY());
                ChessboardPoint add=new ChessboardPoint(getSource().getX()+2, getSource().getY());
                if(location.name=='_'){
                    move.add(add);
                }
            }

            if(point.offset(1,0)!=null){
                ChessComponent location=getChess(getSource().getX()+1, getSource().getY());
                ChessboardPoint add=new ChessboardPoint(getSource().getX()+1, getSource().getY());
                if(location.name=='_'){
                    move.add(add);
                }
            }
            if(point.offset(1,-1)!=null){
                ChessComponent location=getChess(getSource().getX()+1, getSource().getY()-1);
                ChessboardPoint add=new ChessboardPoint(getSource().getX()+1, getSource().getY()-1);
                if(location.name!='_'){
                    if(location.getChessColor()!=this.getChessColor()){
                        move.add(add);
                    }
                }
            }
            if(point.offset(1,1)!=null){
                ChessComponent location=getChess(getSource().getX()+1, getSource().getY()+1);
                ChessboardPoint add=new ChessboardPoint(getSource().getX()+1, getSource().getY()+1);
                if(location.name!='_'){
                    if(location.getChessColor()!=this.getChessColor()){
                        move.add(add);
                    }
                }
            }
        }

        return move;
    }

    public boolean CanEat(int dx,int dy){
        ChessComponent location=getChess(getSource().getX()+dx, getSource().getY()+dy);
        if(location.name!='_'){
            if(location.getChessColor()!=this.getChessColor()){
                return true;
            }
        }
            return false;
    }
}
