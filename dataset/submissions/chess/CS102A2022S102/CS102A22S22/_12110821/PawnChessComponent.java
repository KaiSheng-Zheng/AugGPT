import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private int num=0 ;

    public PawnChessComponent(ChessColor chessColor, char name, int x, int y, ChessComponent[][] chessComponents) {
        super(chessColor, name, x, y, chessComponents);
        num++;
    }


    // num++

    @Override
    public List<ChessboardPoint> canMoveTo() {
       //zu
        ArrayList<ChessboardPoint> temp=new ArrayList<>();
        if (getChessColor().equals(ChessColor.BLACK)
                &&(!array[getSource().getX()][getSource().getY()+1].getChessColor().equals(ChessColor.BLACK))
                &&getSource().getY()!=7) {
            temp.add(new ChessboardPoint(getSource().getX(), getSource().getY()).offset(0,1));
            if (num==1 && array[getSource().getX()][getSource().getY()+1].getChessColor().equals(ChessColor.NONE)
                    && getSource().getY()!=6
                    &&(!array[getSource().getX()][getSource().getY()+2].getChessColor().equals(ChessColor.BLACK))){
                temp.add(new ChessboardPoint(getSource().getX(), getSource().getY()).offset(0,2));}
        }
        if (getChessColor().equals(ChessColor.WHITE)
                && (!array[getSource().getX()][getSource().getY()-1].getChessColor().equals(ChessColor.WHITE))
                &&getSource().getY()!=0) {
            temp.add(new ChessboardPoint(getSource().getX(), getSource().getY()).offset(0,-1));
            if (num==1&& (array[getSource().getX()][getSource().getY()-1].getChessColor().equals(ChessColor.NONE))
                    && getSource().getY()!=1
                    && (!array[getSource().getX()][getSource().getY()-2].getChessColor().equals(ChessColor.WHITE))){
                temp.add(new ChessboardPoint(getSource().getX(), getSource().getY()).offset(0,-2));}
        }
        // add if pawn can eat it
            //you,xia
            if (getSource().getX()+1>=1&&
                    getSource().getX()+1<=7&&
                    getSource().getY()+1>=1&&
                    getSource().getY()+1<=7&&
                    !getChessColor() .equals(array[getSource().getX()+1][getSource().getY()+1].getChessColor()) &&
                    !array[getSource().getX()+1][getSource().getY()+1].getChessColor().equals(ChessColor.NONE)){
                temp.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1 ));
            }
            //you,shang
            if (getSource().getX()+1>=1&&
                    getSource().getX()+1<=7&&
                    getSource().getY()-1>=0&&
                    getSource().getY()-1<=7&&
                    !getChessColor() .equals(array[getSource().getX()+1][getSource().getY()-1].getChessColor())&&
                    !array[getSource().getX()+1][getSource().getY()-1].getChessColor().equals(ChessColor.NONE)){
                temp.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1 ));
            }
            //zuo,xia
            if (getSource().getX()-1>=0&&
                    getSource().getX()-1<=7&&
                    getSource().getY()-1>=0&&
                    getSource().getY()-1<=7&&
                    !getChessColor() .equals(array[getSource().getX()-1][getSource().getY()-1].getChessColor())&&
                    !array[getSource().getX()-1][getSource().getY()-1].getChessColor().equals(ChessColor.NONE)){
                temp.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1 ));
            }
            //zuo,shang
            if (getSource().getX()-1>=0&&
                    getSource().getX()-1<=7&&
                    getSource().getY()+1>=0&&
                    getSource().getY()+1<=7&&
                    !getChessColor() .equals(array[getSource().getX()-1][getSource().getY()+1].getChessColor())&&
                    !array[getSource().getX()-1][getSource().getY()+1].getChessColor().equals(ChessColor.NONE) ){
                temp.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1 ));
            }
        temp.removeIf(dot -> array[getSource().getX()][getSource().getY()].getChessColor() .equals(array[dot.getX()][dot.getY()].getChessColor()) );

        return temp;
    }
}
