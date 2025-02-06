import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
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
    public PawnChessComponent(ChessColor color, ChessboardPoint chessboardPoint, char name){
        this.color=color;
        this.chessboardPoint=chessboardPoint;
        super.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j =0;j<8;j++){
                if(color==ChessColor.BLACK){
                    if(chessboardPoint.getX()==1){
                        if(chessboardPoint.getY()==j&&i-chessboardPoint.getX()==2){
                            if(//itsConcreteGame.getCurrentPlayer()==color&&
                                    chessboard[i][j]instanceof EmptySlotComponent&&
                                    chessboard[(i+chessboardPoint.getX())/2][j]instanceof EmptySlotComponent)
                                chessboardPoints.add(new ChessboardPoint(i,j));
                        }
                    }

                    if(chessboardPoint.getY()==j&&i-chessboardPoint.getX()==1){
                        if(//itsConcreteGame.getCurrentPlayer()==color&&
                                chessboard[i][j]instanceof EmptySlotComponent)
                            chessboardPoints.add(new ChessboardPoint(i,j));
                    }
                    if(i-chessboardPoint.getX()==1&&(j-chessboardPoint.getY()==1||j-chessboardPoint.getY()==-1)){
                        if(//itsConcreteGame.getCurrentPlayer()==color&&
                                !(chessboard[i][j]instanceof EmptySlotComponent)&&!(chessboard[i][j].getColor()==color))
                            chessboardPoints.add(new ChessboardPoint(i,j));
                    }
                }
                else{
                    if(chessboardPoint.getX()==6){
                        if(chessboardPoint.getY()==j&&i-chessboardPoint.getX()==-2){
                            if(//itsConcreteGame.getCurrentPlayer()==color&&
                                    chessboard[i][j]instanceof EmptySlotComponent&&
                                    chessboard[(i+chessboardPoint.getX())/2][j]instanceof EmptySlotComponent)
                                chessboardPoints.add(new ChessboardPoint(i,j));
                        }
                    }

                    if(chessboardPoint.getY()==j&&i-chessboardPoint.getX()==-1){
                        if(//itsConcreteGame.getCurrentPlayer()==color&&
                                chessboard[i][j]instanceof EmptySlotComponent)
                            chessboardPoints.add(new ChessboardPoint(i,j));
                    }
                    if(i-chessboardPoint.getX()==-1&&(j-chessboardPoint.getY()==1||j-chessboardPoint.getY()==-1)){
                        if(//itsConcreteGame.getCurrentPlayer()==color&&
                                !(chessboard[i][j]instanceof EmptySlotComponent)&&!(chessboard[i][j].getColor()==color))
                            chessboardPoints.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return chessboardPoints;
    }
}
