import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessColor chessColor;
    public KingChessComponent(ChessColor chessColor ) {
       this.chessColor=chessColor;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> answer=new ArrayList<>();
        for (int i = super.getSource().getX()-1; i <=super.getSource().getX()+1 ; i++) {
            for (int j = super.getSource().getY()-1; j <=super.getSource().getY()+1; j++) {
                if (i<8&&i>=0&&j<8&&j>=0&&chessboard[i][j].getChessColor()!=this.chessColor)
                {answer.add(new ChessboardPoint(i,j));
                }}
        }
        return answer;}




}