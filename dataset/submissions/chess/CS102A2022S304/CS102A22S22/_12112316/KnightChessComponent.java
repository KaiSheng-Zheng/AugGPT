import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, char name){
        super();
        setSource(source);
        if(name == 'N'){
            setChessColor(ChessColor.BLACK);
        }
        if(name == 'n'){
            setChessColor(ChessColor.WHITE);
        }
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int[] dx = new int[]{2,1,-1,-2,-2,-1,1,2}, dy = new int[]{1,2,2,1,-1,-2,-2,-1};
        for (int i = 0; i < 8; i++) {
            int x = getSource().getX()+dx[i], y = getSource().getY()+dy[i];
            if (0 <= x && x < 8 && 0 <= y && y < 8 && !chessboard[x][y].getChessColor().equals(this.getChessColor())) {
                canMoveTo.add(new ChessboardPoint(x, y));
            }
        }
        Collections.sort(canMoveTo);
        return canMoveTo;
    }
}
