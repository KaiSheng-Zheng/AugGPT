import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessColor color;
    private ChessboardPoint chessboardPoint;

    public ChessColor getColor() {
        return color;
    }

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }
public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }
    public KnightChessComponent(ChessColor color, ChessboardPoint chessboardPoint, char name){
        this.color=color;
        this.chessboardPoint=chessboardPoint;
        super.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((chessboardPoint.getX()-i)*(chessboardPoint.getX()-i)+(chessboardPoint.getY()-j)*(chessboardPoint.getY()-j)==5){
                    if (//itsConcreteGame.getCurrentPlayer() == color &&
                     color!=chessboard[i][j].getColor())
                        chessboardPoints.add(new ChessboardPoint(i, j));
                }
            }
        }
        return chessboardPoints;
    }
}
