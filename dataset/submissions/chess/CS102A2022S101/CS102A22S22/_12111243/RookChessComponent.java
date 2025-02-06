import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint loc = this.getSource();
        int x = loc.getX(), y = loc.getY();
        List<ChessboardPoint> possiblemoves = new ArrayList<>();
        possiblemoves.clear();
        int tempx=x-1;
        while(tempx>=0)
        {
            if(chessboard[tempx][y] instanceof EmptySlotComponent)
                possiblemoves.add(chessboard[tempx][y].getSource());
            else if(chessboard[tempx][y].getChessColor()==this.getChessColor())
                break;
            else
            {
                possiblemoves.add(chessboard[tempx][y].getSource());
                break;
            }
            tempx--;
        }

        tempx=x+1;
        while(tempx<8)
        {
            if(chessboard[tempx][y]instanceof EmptySlotComponent)
                possiblemoves.add(chessboard[tempx][y].getSource());
            else if(chessboard[tempx][y].getChessColor()==this.getChessColor())
                break;
            else
            {
                possiblemoves.add(chessboard[tempx][y].getSource());
                break;
            }
            tempx++;
        }

        int tempy=y-1;
        while(tempy>=0)
        {
            if(chessboard[x][tempy] instanceof EmptySlotComponent)
                possiblemoves.add(chessboard[x][tempy].getSource());
            else if(chessboard[x][tempy].getChessColor()==this.getChessColor())
                break;
            else
            {
                possiblemoves.add(chessboard[x][tempy].getSource());
                break;
            }
            tempy--;
        }
        tempy=y+1;
        while(tempy<8)
        {
            if(chessboard[x][tempy] instanceof EmptySlotComponent)
                possiblemoves.add(chessboard[x][tempy].getSource());
            else if(chessboard[x][tempy].getChessColor()==this.getChessColor())
                break;
            else
            {
                possiblemoves.add(chessboard[x][tempy].getSource());
                break;
            }
            tempy++;
        }
        return possiblemoves;
    }
}
