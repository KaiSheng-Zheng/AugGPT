import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,ChessComponent[][] chessComponents){
        this.source=source;
        this.chessColor=chessColor;
        this.chessComponents=chessComponents;
        if(chessColor==ChessColor.BLACK){
            name='R';
        }else{
            name='r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=source.getX();
        int y=source.getY();
        List<ChessboardPoint> preTarget=new ArrayList<>();

        for(int i=0;i<8;i++){
            if(i!=x){
                preTarget.add(new ChessboardPoint(i,y));
            }
        }
        for (int i=0;i<8;i++){
            if(i!=y){
                preTarget.add(new ChessboardPoint(x,i));
            }
        }

        preTarget.removeIf(chessboardPoint -> !RookCanMove(chessboardPoint));

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

    public boolean RookCanMove(ChessboardPoint destination){
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return chessComponents[destination.getX()][destination.getY()].getChessColor() != chessColor;
    }

    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }

    public String toString() {
        if(chessColor==ChessColor.BLACK){
            return "R";
        }else{
            return "r";
        }
    }
}
