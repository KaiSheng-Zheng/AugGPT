
import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public KnightChessComponent(ChessboardPoint point,ChessColor color,ChessComponent[][] chessComponents){
        super(point,color);
        setChessComponents(chessComponents);
    }

    public boolean canM(ChessboardPoint point){
        ChessboardPoint source = getSource();
        boolean a=!(source.getX()==point.getX());
        boolean b=!(source.getY()==point.getY());
        return (Math.abs(source.getX() - point.getX()) + Math.abs(source.getY() - point.getY()) == 3 && a && b && this.getChessColor()!=chessComponents[point.getX()][point.getY()].getChessColor()) ;
    }

    @Override
    public String toString(){
        if(this.getChessColor()==ChessColor.BLACK) return "N";
        else return "n";
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
