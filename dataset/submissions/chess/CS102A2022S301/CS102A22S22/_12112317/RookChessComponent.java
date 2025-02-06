import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name,ChessComponent[][] chessComponents) {
        super();
        this.setSource(chessboardPoint);
        this.setChessColor(chessColor);
        this.name = name;
        this.chessComponents = chessComponents;
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> result = new ArrayList<>();
        for (int i = 0; i <=7 ; i++) {
            for (int j = 0; j <=7 ; j++) {
                if(this.canBeMovedTo(i,j)){
                    result.add(new ChessboardPoint(i,j));
                }
            }
        }
        return result;
    }

    public boolean canBeMovedTo(int x,int y){
        int count = 0;
        if(getChessComponents()[x][y] instanceof EmptySlotComponent ||!getChessComponents()[x][y].getChessColor().equals(this.getChessColor())){
            count = 0;
            if(this.getChessboardPoint().getY()==y){

                    if(Math.abs(x-this.getChessboardPoint().getX())==1){
                        return true;
                    }
                    for (int i = Math.min(x,this.getChessboardPoint().getX())+1; i <Math.max(x,this.getChessboardPoint().getX()) ; i++) {
                        if(getChessComponents()[i][y] instanceof EmptySlotComponent){
                            count++;
                        }
                    }
                    if(count==Math.abs(x-this.getChessboardPoint().getX())-1){
                        return true;
                    }



            }
            if(this.getChessboardPoint().getX()==x){
                count = 0;

                    if(Math.abs(y-this.getChessboardPoint().getY())==1){
                        return true;
                    }
                    for (int i = Math.min(y,this.getChessboardPoint().getY())+1; i <Math.max(y,this.getChessboardPoint().getY()) ; i++) {
                        if(getChessComponents()[x][i] instanceof EmptySlotComponent){
                            count++;
                        }
                    }
                    if(count==Math.abs(y-this.getChessboardPoint().getY())-1){
                        return true;
                    }



            }


            return false;
        }
        return false;

    }
}
