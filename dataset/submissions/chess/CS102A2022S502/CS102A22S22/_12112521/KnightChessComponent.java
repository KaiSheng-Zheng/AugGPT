import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
        chessComponents[source.getX()][source.getY()] = new HasChessComponent(source,chessColor);
        if(chessColor == ChessColor.BLACK){
            name = 'N';
        }else if(chessColor == ChessColor.WHITE){
            name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<ChessboardPoint>();
        int[][] judge = {{2,1},{1,2},{-2,-1},{-1,-2},{2,-1},{-2,1},{1,-2},{-1,2}};
        for(int i=0 ; i<8; i++) {
            if(getSource().getX() + judge[i][0]<8&&getSource().getX() + judge[i][0]>=0&&getSource().getY() + judge[i][1]<8&&getSource().getY() + judge[i][1]>=0) {
                if (!(getChessComponents(getSource().getX() + judge[i][0], getSource().getY() + judge[i][1]) instanceof HasChessComponent)) {
                    answer.add(new ChessboardPoint(getSource().getX() + judge[i][0], getSource().getY() + judge[i][1]));
                } else if (getChessComponents(getSource().getX() + judge[i][0], getSource().getY() + judge[i][1]) instanceof HasChessComponent && getChessColor() != getChessComponents(getSource().getX() + judge[i][0], getSource().getY() + judge[i][1]).getChessColor()) {
                    answer.add(new ChessboardPoint(getSource().getX() + judge[i][0], getSource().getY() + judge[i][1]));
                }
            }
        }
        return answer;
}
}

