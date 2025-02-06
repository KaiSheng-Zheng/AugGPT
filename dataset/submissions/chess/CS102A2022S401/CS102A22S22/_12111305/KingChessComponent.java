import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,ChessComponent[][] chessComponents){
        this.source=source;
        this.chessColor=chessColor;
        this.chessComponents=chessComponents;
        if(chessColor==ChessColor.BLACK){
            name='K';
        }else{
            name='k';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=source.getX();
        int y=source.getY();
        List<ChessboardPoint> preTarget=new ArrayList<>();

        for(int i=y-1;i<=y+1;i++){
            if(x-1>=0&&i>=0&&i<=7){
                preTarget.add(new ChessboardPoint(x-1,i));
            }
        }
        if(y-1>=0){
            preTarget.add(new ChessboardPoint(x,y-1));
        }
        if(y+1<=7){
            preTarget.add(new ChessboardPoint(x,y+1));
        }
        for(int i=y-1;i<=y+1;i++){
            if(x+1<=7&&i>=0&&i<=7){
                preTarget.add(new ChessboardPoint(x+1,i));
            }
        }

        preTarget.removeIf(chessboardPoint -> !KingCanMove(chessboardPoint));

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

    public boolean KingCanMove(ChessboardPoint destination){
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
            return "K";
        }else{
            return "k";
        }
    }
}
