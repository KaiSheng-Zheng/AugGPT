import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent(){}

    public boolean move(int sourceX, int sourceY, int targetX, int targetY) {
        int row = Math.abs(targetX - sourceX);
        int column = Math.abs(targetY - sourceY);
        if(row==0&&column==0){return false;}
        if(row<=1&&column<=1){
            return true;
        }else {return false;}
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> chessboardPointList = new ArrayList<>();
        int sourceX = source.getX();
        int sourceY = source.getY();
        ChessColor player =this.getChessColor();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(move(sourceX,sourceY,i,j)){
                    if(!(chessComponents[i][j].getChessColor().equals(player))){
                        chessboardPointList.add(new ChessboardPoint(i,j));
                    }
                }

            }

        }
        return chessboardPointList;
    }
}
