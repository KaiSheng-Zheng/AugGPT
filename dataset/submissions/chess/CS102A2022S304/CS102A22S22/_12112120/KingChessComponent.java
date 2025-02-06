
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public KingChessComponent(ChessboardPoint point,ChessColor color,ChessComponent[][] chessComponents){
        super(point,color);
        setChessComponents(chessComponents);
    }


    public boolean canM(ChessboardPoint point){
        ChessboardPoint s=getSource();
        return  Math.abs(s.getX()-point.getX())<=1&&Math.abs(s.getY()-point.getY())<=1&&this.getChessColor()!=chessComponents[point.getX()][point.getY()].getChessColor();
    }

    @Override
    public String toString(){
        if(this.getChessColor()==ChessColor.BLACK) return "K";
        else return "k";
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> List=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point=new ChessboardPoint(i,j);
                if(canM(point)){
                    List.add(point);
                }
            }
        }
        return List;
    }
}
