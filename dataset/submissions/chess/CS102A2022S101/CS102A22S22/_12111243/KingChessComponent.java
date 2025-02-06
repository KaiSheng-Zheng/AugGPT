import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint loc = this.getSource();
        int x = loc.getX(), y = loc.getY();
        List<ChessboardPoint> possiblemoves = new ArrayList<>();
        possiblemoves.clear();
        int posx[]={x,x,x+1,x+1,x+1,x-1,x-1,x-1};
        int posy[]={y-1,y+1,y-1,y,y+1,y-1,y,y+1};
        for(int i=0;i<8;i++){
            if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
                if(chessboard[posx[i]][posy[i]]instanceof EmptySlotComponent||chessboard[posx[i]][posy[i]].getChessColor()!=this.getChessColor())
                    possiblemoves.add(chessboard[posx[i]][posy[i]].getSource());
        }
        return possiblemoves;
    }
}
