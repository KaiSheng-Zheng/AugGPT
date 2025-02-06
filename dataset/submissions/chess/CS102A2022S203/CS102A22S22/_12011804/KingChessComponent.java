import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.source = super.getSource();
        this.chessColor = super.getChessColor();
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<ChessboardPoint>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (inComponent(source.getX()-1+i,source.getY()-1+j)){
                    if (i==1&&j==1){
                        continue;
                    }
                    ChessComponent chessComponent = chessBoard[source.getX()-1+i][source.getY()-1+j];
                    if (differ(chessComponent.getChessColor())){
                        canmove.add(chessComponent.getSource());
                    }
                }
            }
        }

        for (int i = 0; i < canmove.size()-1; i++) {
            for (int j = 0; j < canmove.size()-1; j++) {
                if(canmove.get(j).getX()>canmove.get(j+1).getX())
                {
                    ChessboardPoint temp=canmove.get(j);
                    canmove.set(j,canmove.get(j+1)) ;
                    canmove.set(j+1,temp);
                }if (canmove.get(j).getY()>canmove.get(j+1).getY()&&canmove.get(j).getX()==canmove.get(j+1).getX()){
                    ChessboardPoint temp=canmove.get(j);
                    canmove.set(j,canmove.get(j+1)) ;
                    canmove.set(j+1,temp);
                }

            }
        }

        return canmove;
    }

    public boolean differ (ChessColor chessColor_1){
        return chessColor_1 != chessColor;
    }

    public boolean inComponent (int x , int y){
        return x >= 0 && y >= 0 && x < 8 && y < 8;
    }
}
