import java.util.*;
public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
        chessComponents[source.getX()][source.getY()] = new HasChessComponent(source,chessColor);
        if(chessColor == ChessColor.BLACK){
            name = 'K';
        }else if(chessColor == ChessColor.WHITE){
            name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<ChessboardPoint>();
        int[][] judge = {{1,1},{1,-1},{-1,1},{-1,-1},{0,1},{0,-1},{1,0},{-1,0}};
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
