import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private final int viTriGoc;
    private final int tienTienPhuongHuong;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);

        if (chessColor == ChessColor.BLACK) {
            viTriGoc = 1;
            tienTienPhuongHuong = 1;
            this.name = 'P';
        } else {
            viTriGoc = 6;
            tienTienPhuongHuong = -1;
            this.name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> mucTieu = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int x = source.getX();
        int y = source.getY();

        if (checkEnemy(x + tienTienPhuongHuong, y - 1)) {
            mucTieu.add(new ChessboardPoint(x + tienTienPhuongHuong, y - 1));
        }

        if (checkEnemy(x + tienTienPhuongHuong, y + 1)) {
            mucTieu.add(new ChessboardPoint(x + tienTienPhuongHuong, y + 1));
        }

        if (checkEmpty(x + tienTienPhuongHuong, y)) {
            mucTieu.add(new ChessboardPoint(x + tienTienPhuongHuong, y));
            if ((x == viTriGoc) && (checkEmpty(x + tienTienPhuongHuong * 2, y))) {
                mucTieu.add(new ChessboardPoint(x + tienTienPhuongHuong * 2, y));
            }
        }

        return mucTieu;
    }

    public boolean checkEmpty (int x, int y){
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        if (ConcreteChessGame.I.getChess(x, y).getChessColor() == ChessColor.NONE) {
            return true;
        }
        return false;
    }

    public boolean checkEnemy (int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        if (ConcreteChessGame.I.getChess(x, y).getChessColor() == this.getChessColor()) {
            return false;
        } else if (ConcreteChessGame.I.getChess(x, y).getChessColor() == ChessColor.NONE) {
            return false;
        }
        return true;
    }
}

