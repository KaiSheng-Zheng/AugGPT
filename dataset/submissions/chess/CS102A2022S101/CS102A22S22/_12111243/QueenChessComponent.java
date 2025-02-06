import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
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
            if(chessboard[tempx][y] instanceof EmptySlotComponent)
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


        //Checking possible moves in horizontal Direction
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

        //Checking for possible moves in diagonal direction
        tempx=x+1;tempy=y-1;
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
            if(chessboard[tempx][tempy] instanceof EmptySlotComponent)
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
            if(chessboard[tempx][tempy] instanceof EmptySlotComponent)
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
            tempy++;
        }
        return possiblemoves;
    }
}
