import java.util.List;

public class PawnChessComponent extends ChessComponent {
    boolean killed;
    public PawnChessComponent(ChessColor chessColor,ChessboardPoint source)
    {
        super.chessColor=chessColor;
        super.source=source;
        if(chessColor==ChessColor.WHITE)
            super.name='p';
        else if(chessColor==ChessColor.BLACK)
            super.name='P';
    }
    public List<ChessboardPoint> canMoveTo()
    {
        return null;
    }
    public void setKilled(){
        killed=true;
        if(chessColor==ChessColor.WHITE)
            nokoru[1][5]--;
        else if(chessColor==ChessColor.BLACK)
            nokoru[0][5]--;
    }
    public String toString() {
        if(chessColor==ChessColor.WHITE)
            return "p";
        else if(chessColor==ChessColor.BLACK)
            return "P";
        else
            return "_";
    }
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination,ChessboardPoint source){

        if(source.getX()==destination.getX())
            return false;
        if(source.getY()==destination.getY()&&source.getX()==1&&destination.getX()==3&&chessComponents[2][destination.getY()] instanceof EmptySlotComponent&&chessComponents[3][destination.getY()] instanceof EmptySlotComponent&&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.BLACK){
            return true;
        }
        if(source.getY()==destination.getY()&&source.getX()==6&&destination.getX()==4&&chessComponents[5][destination.getY()] instanceof EmptySlotComponent&&chessComponents[4][destination.getY()] instanceof EmptySlotComponent&&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.WHITE){
            return true;
        }
        if(source.getY()==destination.getY()&&source.getX()==1&&destination.getX()==2&&chessComponents[2][destination.getY()] instanceof EmptySlotComponent&&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.BLACK){
            return true;
        }
        if(source.getY()==destination.getY()&&source.getX()==6&&destination.getX()==5&&chessComponents[5][destination.getY()] instanceof EmptySlotComponent&&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.WHITE){
            return true;
        }
//        if(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)&&source.getY()!=destination.getY())
//            return false;
        if((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)&&source.getY()!=destination.getY())
            return false;
        if(source.getX()==destination.getX()&&source.getY()==destination.getY())
            return false;
        if(chessComponents[destination.getX()][destination.getY()].getChessColor()==chessComponents[source.getX()][source.getY()].getChessColor())
            return false;
        int length=1;
        if(Math.abs(source.getX()-destination.getX())==Math.abs(source.getY()-destination.getY())&&Math.abs(source.getY()-destination.getY())==1){
            if(chessComponents[destination.getX()][destination.getY()].getChessColor() != ChessColor.NONE && chessComponents[destination.getX()][destination.getY()].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor())
            {
                if(chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.BLACK&&(destination.getX()-source.getX())==-1)
                    return false;
                else if(chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.WHITE&&(destination.getX()-source.getX())==1)
                    return false;
                return true;
            }
            return false;
        }
        else if(source.getX()==destination.getX()&&destination.getX()==3&&chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.BLACK&&
                chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.WHITE&&chessComponents[destination.getX()][destination.getY()] instanceof PawnChessComponent)
        {
            return true;
        }
        else if(source.getX()==destination.getX()&&destination.getX()==4&&chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.WHITE&&
                chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.BLACK&&chessComponents[destination.getX()][destination.getY()] instanceof PawnChessComponent)
        {
            return true;
        }
        else if(source.getY()==destination.getY()&&(source.getX()-destination.getX())==1&&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.WHITE&&chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.NONE)
        {
            return true;
        }
        else if(source.getY()==destination.getY()&&(source.getX()-destination.getX())==-1&&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.BLACK&&chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.NONE)
        {
            return true;
        }
        else if(source.getY()==destination.getY()&&(source.getX()-destination.getX())==2&&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.WHITE&&source.getX()==6&&chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.NONE)
        {
            return false;
        }
        else if(source.getY()==destination.getY()&&(source.getX()-destination.getX())==-2&&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.BLACK&&source.getX()==1&&chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.NONE)
        {
            return false;
        }
        return false;
    }
}
