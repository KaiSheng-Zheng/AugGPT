import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessColor color, ChessboardPoint chessboardPoint){
        if (color.equals(ChessColor.BLACK)){
            this.name='K';
        }else {
            this.name='k';
        }
        this.setSource(chessboardPoint);
        this.setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if ((Math.abs(x-i)==1&&j==y) || (Math.abs(y-j)==1&&i==x) || (Math.abs(x-i)==1&&Math.abs(y-j)==1)){
                    if (chessboard[i][j].getChessColor()!=chessboard[x][y].getChessColor()){
                        arrayList.add(chessboard[i][j].getSource());
                    }
                }
            }
        }
        return arrayList;
    }
}
