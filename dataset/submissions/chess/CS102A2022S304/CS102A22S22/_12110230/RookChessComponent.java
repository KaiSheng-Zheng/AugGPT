import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent
{
    public  RookChessComponent(int x,int y,ChessColor chessColor,char name)
    {
        setSource(x,y);
        setChessColor(chessColor);
        setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        List<ChessboardPoint> output=new ArrayList<>();
        ChessColor color=this.getChessColor();

        for (int i = getSource().getX()+1; i < 8; i++) {
            if (Chessboard[i][getSource().getY()] instanceof EmptySlotComponent) {output.add(new ChessboardPoint(i, getSource().getY()));}
            else
            {if(color !=Chessboard[i][getSource().getY()].getChessColor()) {output.add(new ChessboardPoint(i, getSource().getY()));}
                break;}
        }

        for (int i = getSource().getX()-1; i >=0; i--) {
            if (Chessboard[i][getSource().getY()] instanceof EmptySlotComponent) {output.add(new ChessboardPoint(i, getSource().getY()));}
            else
            {if(color !=Chessboard[i][getSource().getY()].getChessColor()) {output.add(new ChessboardPoint(i, getSource().getY()));}
                break;}
        }

        for (int i = getSource().getY()+1; i < 8; i++) {
            if (Chessboard[getSource().getX()][i] instanceof EmptySlotComponent) {output.add(new ChessboardPoint(getSource().getX(), i));}
            else
            {if(color !=Chessboard[getSource().getX()][i].getChessColor()) {output.add(new ChessboardPoint(getSource().getX(), i));}
                break;}
        }

        for (int i = getSource().getY()-1; i >=0; i--) {
            if (Chessboard[getSource().getX()][i] instanceof EmptySlotComponent) {output.add(new ChessboardPoint(getSource().getX(), i));}
            else
            {if(color !=Chessboard[getSource().getX()][i].getChessColor()) {output.add(new ChessboardPoint(getSource().getX(), i));}
                break;}
        }
        return output;
    }
}