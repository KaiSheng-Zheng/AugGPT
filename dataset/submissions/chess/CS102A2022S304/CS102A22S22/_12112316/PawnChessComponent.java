import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, char name){
        super();
        setSource(source);
        if(name == 'P'){
            setChessColor(ChessColor.BLACK);
        }
        if(name == 'p'){
            setChessColor(ChessColor.WHITE);
        }
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int k = 1, t = 1;
        if(this.getChessColor().equals(ChessColor.WHITE)){
            k = -1;
            t = 6;
        }
        int x = getSource().getX()+k, y = getSource().getY();//front
        if (0 <= x && x < 8 && 0 <= y && y < 8 && chessboard[x][y].getChessColor().equals(ChessColor.NONE)) {
            canMoveTo.add(new ChessboardPoint(x, y));
            if(getSource().getX() == t){
                x = x + k;
                if(x < 8 && chessboard[x][y].getChessColor().equals(ChessColor.NONE)){
                    canMoveTo.add(new ChessboardPoint(x, y));
                }
            }
        }
        int[] dy = new int[]{1,-1};
        x = getSource().getX()+k;
        for (int i = 0; i < 2; i++) {
            y = getSource().getY() + dy[i];
            if (0 <= x && x < 8 && 0 <= y && y < 8 && !chessboard[x][y].getChessColor().equals(this.getChessColor()) && !chessboard[x][y].getChessColor().equals(ChessColor.NONE)) {
                canMoveTo.add(new ChessboardPoint(x, y));
            }
        }
        Collections.sort(canMoveTo);
        return canMoveTo;
    }

}
