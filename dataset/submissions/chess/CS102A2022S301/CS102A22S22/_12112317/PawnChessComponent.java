import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name,ChessComponent[][] chessComponents) {
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
        if(getChessComponents()[x][y] instanceof EmptySlotComponent){
            if(y==this.getChessboardPoint().getY()){
                if(this.getChessColor().equals(ChessColor.BLACK)){
                    if(this.getChessboardPoint().getX()==1){
                        if(x-this.getChessboardPoint().getX()==1){
                            return true;
                        }
                        if(x-this.getChessboardPoint().getX()==2){
                            if(getChessComponents()[x-1][y] instanceof EmptySlotComponent){
                                return true;
                            }

                        }

                    }else{
                        if(x-this.getChessboardPoint().getX()==1){
                            return true;
                        }
                    }
                }
                if(this.getChessColor().equals(ChessColor.WHITE)){
                    if(this.getChessboardPoint().getX()==6){
                        if(this.getChessboardPoint().getX()-x==1){
                            return true;
                        }
                        if(this.getChessboardPoint().getX()-x==2){
                            if(getChessComponents()[x+1][y] instanceof EmptySlotComponent){
                                return true;
                            }

                        }
                    }else{
                        if(this.getChessboardPoint().getX()-x==1){
                            return true;
                        }
                    }
                }

            }
        }else{
            if(!getChessComponents()[x][y].getChessColor().equals(this.getChessColor())){
                if(this.getChessColor().equals(ChessColor.BLACK)){
                    if(x-this.getChessboardPoint().getX()==1&&Math.abs(y-this.getChessboardPoint().getY())==1){
                        return true;
                    }
                }
                if(this.getChessColor().equals(ChessColor.WHITE)){
                    if(this.getChessboardPoint().getX()-x==1&&Math.abs(y-this.getChessboardPoint().getY())==1){
                        return true;
                    }
                }
            }

        }
        return false;


    }


}
