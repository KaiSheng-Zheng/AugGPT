import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove=new ArrayList<>();
        int left=getSource().getY();
        int right=7-getSource().getY();
        int up=getSource().getX();
        int down=7-getSource().getX();

        //to left-up
        if(left>=1 && up>=1){
            if (currentChessboard[getSource().getX()-1][getSource().getY()-1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor() || currentChessboard[getSource().getX()-1][getSource().getY()-1].getClass().equals(EmptySlotComponent.class))
            canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
        }
        //to up
        if (up>=1){
            if (currentChessboard[getSource().getX()-1][getSource().getY()].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor() || currentChessboard[getSource().getX()-1][getSource().getY()].getClass().equals(EmptySlotComponent.class))
                canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
        }
        //to right-up
        if (right>=1 && up>=1){
            if (currentChessboard[getSource().getX()-1][getSource().getY()+1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor() || currentChessboard[getSource().getX()-1][getSource().getY()+1].getClass().equals(EmptySlotComponent.class))
                canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
        }

        //to left
        if (left>=1){
            if (currentChessboard[getSource().getX()][getSource().getY()-1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor() || currentChessboard[getSource().getX()][getSource().getY()-1].getClass().equals(EmptySlotComponent.class))
                canMove.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
        }
        //to right
        if (right>=1){
            if (currentChessboard[getSource().getX()][getSource().getY()+1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor() || currentChessboard[getSource().getX()][getSource().getY()+1].getClass().equals(EmptySlotComponent.class))
                canMove.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
        }
        //to left-down
        if (left>=1 && down>=1){
            if (currentChessboard[getSource().getX()+1][getSource().getY()-1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor() || currentChessboard[getSource().getX()+1][getSource().getY()-1].getClass().equals(EmptySlotComponent.class))
                canMove.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1));
        }
        //to down
        if (down>=1){
            if (currentChessboard[getSource().getX()+1][getSource().getY()].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor() || currentChessboard[getSource().getX()+1][getSource().getY()].getClass().equals(EmptySlotComponent.class))
                canMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
        }

        //to right-down
        if (right>=1 && down>=1){
            if (currentChessboard[getSource().getX()+1][getSource().getY()+1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor() || currentChessboard[getSource().getX()+1][getSource().getY()+1].getClass().equals(EmptySlotComponent.class))
            canMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
        }

        return canMove;
    }

    @Override
    public void setName(){
        if (super.getChessColor().equals(ChessColor.BLACK)){
            super.name = 'K';
        }else
        super.name = 'k';
    }

}
