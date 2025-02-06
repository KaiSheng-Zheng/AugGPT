import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(char name) {
        if (Character.isLowerCase(name))
            super.name = 'k';
        else super.name = 'K';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Kings = new ArrayList<>();
        ChessboardPoint a = getSource();
        a.offset(1,-1);
        int x = a.getX();
        int y = a.getY();
        if (x>0&&x<7&&y>0&&y<7){
            Kings.add(new ChessboardPoint(x - 1, y - 1));
            Kings.add(new ChessboardPoint(x - 1, y));
            Kings.add(new ChessboardPoint(x - 1, y + 1));
            Kings.add(new ChessboardPoint(x, y - 1));
            Kings.add(new ChessboardPoint(x, y + 1));
            Kings.add(new ChessboardPoint(x + 1, y - 1));
            Kings.add(new ChessboardPoint(x + 1, y));
            Kings.add(new ChessboardPoint(x + 1, y + 1));
        }else if (x == 0 && y == 0){
            Kings.add(new ChessboardPoint(x, y + 1));
            Kings.add(new ChessboardPoint(x + 1, y));
            Kings.add(new ChessboardPoint(x + 1, y + 1));
        }else if (x == 0 && y != 0 && y != 7){
            Kings.add(new ChessboardPoint(x, y - 1));
            Kings.add(new ChessboardPoint(x, y + 1));
            Kings.add(new ChessboardPoint(x + 1, y - 1));
            Kings.add(new ChessboardPoint(x + 1, y));
            Kings.add(new ChessboardPoint(x + 1, y + 1));
        }else if (x == 0 && y == 7){
            Kings.add(new ChessboardPoint(x, y - 1));
            Kings.add(new ChessboardPoint(x + 1, y - 1));
            Kings.add(new ChessboardPoint(x + 1, y + 1));
        } else if (y == 0 && x != 0 && x != 7) {
            Kings.add(new ChessboardPoint(x - 1, y));
            Kings.add(new ChessboardPoint(x - 1, y + 1));
            Kings.add(new ChessboardPoint(x, y + 1));
            Kings.add(new ChessboardPoint(x + 1, y));
            Kings.add(new ChessboardPoint(x + 1, y + 1));
        } else if (y == 7 && x != 0 && x != 7) {
            Kings.add(new ChessboardPoint(x - 1, y - 1));
            Kings.add(new ChessboardPoint(x - 1, y));
            Kings.add(new ChessboardPoint(x, y - 1));
            Kings.add(new ChessboardPoint(x + 1, y - 1));
            Kings.add(new ChessboardPoint(x + 1, y));
        } else if (x == 7 && y == 7) {
            Kings.add(new ChessboardPoint(x - 1, y - 1));
            Kings.add(new ChessboardPoint(x - 1, y));
            Kings.add(new ChessboardPoint(x, y - 1));
        } else if (x == 7 && y == 0) {
            Kings.add(new ChessboardPoint(x - 1, y));
            Kings.add(new ChessboardPoint(x - 1, y + 1));
            Kings.add(new ChessboardPoint(x, y + 1));
        }else {
            Kings.add(new ChessboardPoint(x - 1, y - 1));
            Kings.add(new ChessboardPoint(x - 1, y));
            Kings.add(new ChessboardPoint(x - 1, y + 1));
            Kings.add(new ChessboardPoint(x, y - 1));
            Kings.add(new ChessboardPoint(x, y + 1));
        }
        return Kings;
    }
}
