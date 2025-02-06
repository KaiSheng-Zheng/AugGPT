import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int x, int y, ChessColor chessColor) {
        super();
        this.setSource(new ChessboardPoint(x,y));
        if (chessColor.equals(ChessColor.BLACK)){
            this.name = 'N';
        } else {
            this.name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> result = new ArrayList<>();

        ChessboardPoint curPosition = this.getSource();
        int curX = curPosition.getX();
        int curY = curPosition.getY();


        for (int i = 0;i<8;i++){
            for (int j = 0;j<8;j++){
                int xChange = Math.abs(curX - i);
                int yChange = Math.abs(curY - j);
                if ((xChange == 2 && yChange == 1)||(xChange == 1 && yChange == 2)){
                    ChessboardPoint newPos = new ChessboardPoint(i,j);
                    result.add(newPos);
                }
            }
        }
        return result;
    }
}
