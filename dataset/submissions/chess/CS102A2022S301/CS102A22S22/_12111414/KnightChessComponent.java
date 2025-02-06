import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((Math.abs(i-x)==2&&Math.abs(j-y)==1)||(Math.abs(i-x)==1&&Math.abs(j-y)==2)){
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()){
                        canMovePoints.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        return canMovePoints;
    }

}