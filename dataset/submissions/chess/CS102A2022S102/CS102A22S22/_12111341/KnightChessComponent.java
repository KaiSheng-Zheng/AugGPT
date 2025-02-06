
import java.util.LinkedList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessColor color,ChessboardPoint chessboardPoint){
        if (color.equals(ChessColor.BLACK)){
            this.name='N';
        }else {
            this.name = 'n';
        }
        this.setSource(chessboardPoint);
        this.setChessColor(color);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> arrayList=new LinkedList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                int dx=Math.abs(x-i);
                int dy=Math.abs(y-j);
                if ((dx==1&&dy==2)||(dx==2&&dy==1)){
                    if (chessboard[i][j].getChessColor()!=chessboard[x][y].getChessColor()){
                        arrayList.add(chessboard[i][j].getSource());
                    }
                }
            }
        }
        return arrayList;
    }
}
