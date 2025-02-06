import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(char name,ChessColor chessColor,ChessboardPoint chessboardPoint) {
        this.setName(name);
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> List = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(getSource().getX()-i)==1 && Math.abs(getSource().getY()-j)==0 && getChessComponents()[i][j].getChessColor()!=this.getChessColor() )
                        ||(Math.abs(getSource().getX()-i)==0 && Math.abs(getSource().getY()-j)==1 && getChessComponents()[i][j].getChessColor()!=this.getChessColor() )
                        ||(Math.abs(getSource().getX()-i)==1 && Math.abs(getSource().getY()-j)==1 && getChessComponents()[i][j].getChessColor()!=this.getChessColor()) ){
                    List.add(new ChessboardPoint(i,j));
                }
            }
        }
        return List;
    }



}
