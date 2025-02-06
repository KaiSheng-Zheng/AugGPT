import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
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
    public KingChessComponent(ChessColor color, ChessboardPoint chessboardPoint, char name){
        this.color=color;
        this.chessboardPoint=chessboardPoint;
        super.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((chessboardPoint.getX()-i==1||chessboardPoint.getX()-i==-1||chessboardPoint.getX()-i==0)&&
                        (chessboardPoint.getY()-j==1||chessboardPoint.getY()-j==-1||chessboardPoint.getY()-j==0)
                &&!(chessboardPoint.getX()-i==0&&chessboardPoint.getY()-j==0)){
                    if (//itsConcreteGame.getCurrentPlayer() == color &&
                            color!=chessboard[i][j].getColor())
                        chessboardPoints.add(new ChessboardPoint(i, j));
                }
            }
        }
            return chessboardPoints;
    }
}
