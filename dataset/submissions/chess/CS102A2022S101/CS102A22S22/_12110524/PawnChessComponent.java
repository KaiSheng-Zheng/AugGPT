import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private boolean first;

    public PawnChessComponent(boolean color, int x, int y) {
        this.name = color ? 'P' : 'p';
        this.setSource(new ChessboardPoint(x, y));
        this.first = true;
        if (Character.isUpperCase(this.name)) this.first = x == 1;
        else this.first = x == 6;
    }
    public void useFirst() {
        this.first = false;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List list = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX(), y = this.getSource().getY();
        if (Character.isUpperCase(this.name)) {
            if (x <= 6 && board[x+1][y].name == '_') {
                list.add(new ChessboardPoint(x+1, y));
                if (first && x <= 5 && board[x+2][y].name == '_') list.add(new ChessboardPoint(x+2, y));
            }
            if (x <= 6 && y >= 1 && board[x+1][y-1].name != '_' && !Character.isUpperCase(board[x+1][y-1].name)) list.add(new ChessboardPoint(x+1, y-1));
            if (x <= 6 && y <= 6 && board[x+1][y+1].name != '_' && !Character.isUpperCase(board[x+1][y+1].name)) list.add(new ChessboardPoint(x+1, y+1));
        }
        else {
            if (x >= 1 && board[x-1][y].name == '_') {
                list.add(new ChessboardPoint(x-1, y));
                if (first && x >= 2 && board[x-2][y].name == '_') list.add(new ChessboardPoint(x-2, y));
            }
            if (x >= 1 && y >= 1 && board[x-1][y-1].name != '_' && Character.isUpperCase(board[x-1][y-1].name)) list.add(new ChessboardPoint(x-1, y-1));
            if (x >= 1 && y <= 6 && board[x-1][y+1].name != '_' && Character.isUpperCase(board[x-1][y+1].name)) list.add(new ChessboardPoint(x-1, y+1));
        }
        return list;
    }
}