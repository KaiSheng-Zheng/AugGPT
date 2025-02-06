
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name ;
    private ChessComponent[][] components ;


    public void setComponents(ChessComponent[][] components) {
        this.components = components;
    }
    public KingChessComponent(ChessboardPoint source , ChessColor chessColor , char name) {
    this.source =source;
    this.chessColor =chessColor;
    this.name =name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }



    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        if (source.offset(1, 1) != null && components[x + 1][y + 1].getChessColor() != chessColor) {
            list.add(new ChessboardPoint(x + 1, y + 1));
        }
        if (source.offset(1, 0) != null && components[x + 1][y].getChessColor() != chessColor) {
            list.add(new ChessboardPoint(x + 1, y));
        }
        if (source.offset(0, 1) != null && components[x][y + 1].getChessColor() != chessColor) {
            list.add(new ChessboardPoint(x, y + 1));
        }
        if (source.offset(-1, 1) != null && components[x - 1][y + 1].getChessColor() != chessColor) {
            list.add(new ChessboardPoint(x - 1, y + 1));
        }
        if (source.offset(-1, -1) != null && components[x - 1][y - 1].getChessColor() != chessColor) {
            list.add(new ChessboardPoint(x - 1, y - 1));
        }
        if (source.offset(-1, 0) != null && components[x - 1][y].getChessColor() != chessColor) {
            list.add(new ChessboardPoint(x - 1, y));
        }
        if (source.offset(1, -1) != null && components[x + 1][y - 1].getChessColor() != chessColor) {
            list.add(new ChessboardPoint(x + 1, y - 1));
        }
        if (source.offset(0, -1) != null && components[x][y - 1].getChessColor() != chessColor) {
            list.add(new ChessboardPoint(x, y - 1));
        }
        return list;
    }
    public String toString() {
        return String.valueOf(this.name);
    }
}
