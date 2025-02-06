import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint loc = this.getSource();
        int x = loc.getX(), y = loc.getY();
        List possiblemoves = new ArrayList<>();
        possiblemoves.clear();
        int tempx=x+1;int tempy=y-1;
        while(tempx<8&&tempy>=0)
        {
            if(chessboard[tempx][tempy] instanceof EmptySlotComponent)
                possiblemoves.add(chessboard[tempx][tempy].getSource());
            else if(chessboard[tempx][tempy].getChessColor()==this.getChessColor())
                break;
            else
            {
                possiblemoves.add(chessboard[tempx][tempy].getSource());
                break;
            }
            tempx++;
            tempy--;
        }
        tempx=x-1;tempy=y+1;
        while(tempx>=0&&tempy<8)
        {
            if(chessboard[tempx][tempy]instanceof EmptySlotComponent)
                possiblemoves.add(chessboard[tempx][tempy].getSource());
            else if(chessboard[tempx][tempy].getChessColor()==this.getChessColor())
                break;
            else
            {
                possiblemoves.add(chessboard[tempx][tempy].getSource());
                break;
            }
            tempx--;
            tempy++;
        }
        tempx=x-1;tempy=y-1;
        while(tempx>=0&&tempy>=0)
        {
            if(chessboard[tempx][tempy]instanceof EmptySlotComponent)
                possiblemoves.add(chessboard[tempx][tempy].getSource());
            else if(chessboard[tempx][tempy].getChessColor()==this.getChessColor())
                break;
            else
            {
                possiblemoves.add(chessboard[tempx][tempy].getSource());
                break;
            }
            tempx--;
            tempy--;
        }
        tempx=x+1;tempy=y+1;
        while(tempx<8&&tempy<8)
        {
            if(chessboard[tempx][tempy]instanceof EmptySlotComponent)
                possiblemoves.add(chessboard[tempx][tempy].getSource());
            else if(chessboard[tempx][tempy].getChessColor()==this.getChessColor())
                break;
            else
            {
                possiblemoves.add(chessboard[tempx][tempy].getSource());
                break;
            }
            tempx++;
            tempy++;
        }
        return possiblemoves;
    }
}
