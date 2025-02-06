import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,ChessComponent[][] chessComponents){
        this.source=source;
        this.chessColor=chessColor;
        this.chessComponents=chessComponents;
        if(chessColor==ChessColor.BLACK){
            name='N';
        }else{
            name='n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=source.getX();
        int y=source.getY();
        List<ChessboardPoint> preTarget=new ArrayList<>();

        preTarget.add(new ChessboardPoint(x-2,y-1));
        preTarget.add(new ChessboardPoint(x-2,y+1));
        preTarget.add(new ChessboardPoint(x-1,y-2));
        preTarget.add(new ChessboardPoint(x-1,y+2));
        preTarget.add(new ChessboardPoint(x+1,y-2));
        preTarget.add(new ChessboardPoint(x+1,y+2));
        preTarget.add(new ChessboardPoint(x+2,y-1));
        preTarget.add(new ChessboardPoint(x+2,y+1));

        preTarget.removeIf(chessboardPoint -> chessboardPoint.getX() < 0 || chessboardPoint.getX() > 7 || chessboardPoint.getY() < 0 || chessboardPoint.getY() > 7);

        preTarget.removeIf(chessboardPoint -> chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == this.chessColor);

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

    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }

    public String toString() {
        if(chessColor==ChessColor.BLACK){
            return "N";
        }else{
            return "n";
        }
    }
}
