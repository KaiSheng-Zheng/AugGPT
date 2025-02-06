import java.util.*;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name,ChessComponent[][] chessComponents) {
       super();
        this.setSource(chessboardPoint);
       this.setChessColor(chessColor);
       this.name = name;
       this.chessComponents = chessComponents;
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> result = new ArrayList<>();

        if(this.getChessboardPoint().getX()>=1&&this.getChessboardPoint().getY()>=1){
            if(getChessComponents()[this.getChessboardPoint().getX()-1][this.getChessboardPoint().getY()-1] instanceof EmptySlotComponent ||!getChessComponents()[this.getChessboardPoint().getX()-1][this.getChessboardPoint().getY()-1].getChessColor().equals(this.getChessColor())){
                result.add(new ChessboardPoint(this.getChessboardPoint().getX()-1,this.getChessboardPoint().getY()-1));
            }
        }
        if(this.getChessboardPoint().getX()>=1){
            if(getChessComponents()[this.getChessboardPoint().getX()-1][this.getChessboardPoint().getY()] instanceof EmptySlotComponent ||!getChessComponents()[this.getChessboardPoint().getX()-1][this.getChessboardPoint().getY()].getChessColor().equals(this.getChessColor())){
                result.add(new ChessboardPoint(this.getChessboardPoint().getX()-1,this.getChessboardPoint().getY()));
            }
        }

        if(this.getChessboardPoint().getX()>=1&&this.getChessboardPoint().getY()<=6){
            if(getChessComponents()[this.getChessboardPoint().getX()-1][this.getChessboardPoint().getY()+1] instanceof EmptySlotComponent ||!getChessComponents()[this.getChessboardPoint().getX()-1][this.getChessboardPoint().getY()+1].getChessColor().equals(this.getChessColor())){
                result.add(new ChessboardPoint(this.getChessboardPoint().getX()-1,this.getChessboardPoint().getY()+1));
            }
        }

        if(this.getChessboardPoint().getY()>=1){
            if(getChessComponents()[this.getChessboardPoint().getX()][this.getChessboardPoint().getY()-1] instanceof EmptySlotComponent ||!getChessComponents()[this.getChessboardPoint().getX()][this.getChessboardPoint().getY()-1].getChessColor().equals(this.getChessColor())){
                result.add(new ChessboardPoint(this.getChessboardPoint().getX(),this.getChessboardPoint().getY()-1));
            }
        }

        if(this.getChessboardPoint().getY()<=6){
            if(getChessComponents()[this.getChessboardPoint().getX()][this.getChessboardPoint().getY()+1] instanceof EmptySlotComponent ||!getChessComponents()[this.getChessboardPoint().getX()][this.getChessboardPoint().getY()+1].getChessColor().equals(this.getChessColor())){
                result.add(new ChessboardPoint(this.getChessboardPoint().getX(),this.getChessboardPoint().getY()+1));
            }
        }

        if(this.getChessboardPoint().getX()<=6&&this.getChessboardPoint().getY()>=1){
            if(getChessComponents()[this.getChessboardPoint().getX()+1][this.getChessboardPoint().getY()-1] instanceof EmptySlotComponent ||!getChessComponents()[this.getChessboardPoint().getX()+1][this.getChessboardPoint().getY()-1].getChessColor().equals(this.getChessColor())){
                result.add(new ChessboardPoint(this.getChessboardPoint().getX()+1,this.getChessboardPoint().getY()-1));
            }
        }

        if(this.getChessboardPoint().getX()<=6){
            if(getChessComponents()[this.getChessboardPoint().getX()+1][this.getChessboardPoint().getY()] instanceof EmptySlotComponent ||!getChessComponents()[this.getChessboardPoint().getX()+1][this.getChessboardPoint().getY()].getChessColor().equals(this.getChessColor())){
                result.add(new ChessboardPoint(this.getChessboardPoint().getX()+1,this.getChessboardPoint().getY()));
            }
        }

        if(this.getChessboardPoint().getX()<=6&&this.getChessboardPoint().getY()<=6){
            if(getChessComponents()[this.getChessboardPoint().getX()+1][this.getChessboardPoint().getY()+1] instanceof EmptySlotComponent ||!getChessComponents()[this.getChessboardPoint().getX()+1][this.getChessboardPoint().getY()+1].getChessColor().equals(this.getChessColor())){
                result.add(new ChessboardPoint(this.getChessboardPoint().getX()+1,this.getChessboardPoint().getY()+1));
            }
        }

        return result;



    }
}
