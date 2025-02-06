import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,ChessComponent[][] chessComponents){
        this.source=source;
        this.chessColor=chessColor;
        this.chessComponents=chessComponents;
        if(chessColor==ChessColor.BLACK){
            name='B';
        }else{
            name='b';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=source.getX();
        int y=source.getY();
        List<ChessboardPoint> preTarget=new ArrayList<>();

       
        if(x<=y){
            for(int i=0;i<=7-(y-x);i++){
                if(i!=x){
                    preTarget.add(new ChessboardPoint(i,i+y-x));
                }
            }
        }else{
            for(int i=0;i<=7-(x-y);i++){
                if(i!=y){
                    preTarget.add(new ChessboardPoint(i+x-y,i));
                }
            }
        }
        
        if(x+y<=7){
            for(int i=0;i<=x+y;i++){
                if(i!=x){
                    preTarget.add(new ChessboardPoint(i,x+y-i));
                }
            }
        }else{
            for(int i=7;i>=x+y-7;i--){
                if(i!=x){
                    preTarget.add(new ChessboardPoint(i,x+y-i));
                }
            }
        }

        
        preTarget.removeIf(chessboardPoint -> !BishopCanMove(chessboardPoint));

        
        Collections.sort(preTarget, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                int flag=o1.getX()-o2.getX();
                if(flag==0){
                    flag=o1.getY()-o2.getY();
                }
                return flag;
            }
        });
        return preTarget;
    }

    public boolean BishopCanMove(ChessboardPoint destination){
        if(source.getX()-destination.getX()==source.getY()-destination.getY() || source.getX()-destination.getX()==destination.getY()-source.getY()){
            if(source.getX()-destination.getX()==source.getY()-destination.getY()){
                if(destination.getX()-source.getX()>0){
                    for(int i=destination.getX()-source.getX()-1;i>=1;i--){
                        if (!(chessComponents[source.getX()+i][source.getY()+i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }else{
                    for(int i=destination.getX()-source.getX()+1;i<=-1;i++){
                        if (!(chessComponents[source.getX()+i][source.getY()+i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            }else{
                if(source.getX()-destination.getX()>0){
                    for(int i=destination.getX()-source.getX()+1;i<=-1;i++){
                        if (!(chessComponents[source.getX()+i][source.getY()-i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }else{
                    for(int i=destination.getX()-source.getX()-1;i>=1;i--){
                        if (!(chessComponents[source.getX()+i][source.getY()-i] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            }
        } else {
            return false;
        }
        return chessComponents[destination.getX()][destination.getY()].getChessColor() != this.chessColor;
    }

    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public String toString() {
        if(chessColor==ChessColor.BLACK){
            return "B";
        }else{
            return "b";
        }
    }
}
