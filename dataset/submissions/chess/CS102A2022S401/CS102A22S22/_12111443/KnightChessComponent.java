import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int left=getSource().getY();
        int right=7-getSource().getY();
        int up=getSource().getX();
        int down=7-getSource().getX();

        //to left-up
        if (left>=2 && up>=1){
            if (currentChessboard[getSource().getX()-1][getSource().getY()-2].getClass().equals(EmptySlotComponent.class) || currentChessboard[getSource().getX()-1][getSource().getY()-2].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor())
            canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-2));
        }
        if (left>=1 && up>=2){
            if (currentChessboard[getSource().getX()-2][getSource().getY()-1].getClass().equals(EmptySlotComponent.class) || currentChessboard[getSource().getX()-2][getSource().getY()-1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor())
            canMove.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()-1));
        }
        //to right-up
        if (right>=2 && up>=1){
            if (currentChessboard[getSource().getX()-1][getSource().getY()+2].getClass().equals(EmptySlotComponent.class) || currentChessboard[getSource().getX()-1][getSource().getY()+2].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor())
            canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+2));
        }
        if (right>=1 && up>=2){
            if (currentChessboard[getSource().getX()-2][getSource().getY()+1].getClass().equals(EmptySlotComponent.class) || currentChessboard[getSource().getX()-2][getSource().getY()+1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor())
                canMove.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()+1));
        }
        //to left-down
        if (left>=2 && down>=1){
            if (currentChessboard[getSource().getX()+1][getSource().getY()-2].getClass().equals(EmptySlotComponent.class) || currentChessboard[getSource().getX()+1][getSource().getY()-2].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor())
            canMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-2));
        }
        if (left>=1 && down>=2){
            if (currentChessboard[getSource().getX()+2][getSource().getY()-1].getClass().equals(EmptySlotComponent.class) || currentChessboard[getSource().getX()+2][getSource().getY()-1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor())
            canMove.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()-1));
        }
        //to right-down
        if (right>=2 && down>=1){
            if (currentChessboard[getSource().getX()+1][getSource().getY()+2].getClass().equals(EmptySlotComponent.class) || currentChessboard[getSource().getX()+1][getSource().getY()+2].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor())
            canMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+2));
        }
        if (right>=1 && down>=2){
            if (currentChessboard[getSource().getX()+2][getSource().getY()+1].getClass().equals(EmptySlotComponent.class) || currentChessboard[getSource().getX()+2][getSource().getY()+1].getChessColor()!=super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor())
            canMove.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()+1));
        }

        return canMove;
    }

    @Override
    public void setName(){
        if (super.getChessColor().equals(ChessColor.BLACK)){
            super.name = 'N';
        }else
            super.name = 'n';
    }
}
