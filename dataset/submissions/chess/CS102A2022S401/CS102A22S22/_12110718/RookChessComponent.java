import java.util.ArrayList;
import java.util.List;

class RookChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint point;
        for (int i = 1; ; i++) {
            if (getSource().getY() + i < 8 && getConcreteChessGame().getChess(getSource().getX(), getSource().getY() + i).name == '_') {
                points.add(new ChessboardPoint(getSource().getX(), getSource().getY() + i));
            } else if (getSource().getY() + i < 8 && getConcreteChessGame().getChess(getSource().getX(), getSource().getY() + i).getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(getSource().getX(), getSource().getY() + i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; ; i++) {
            if (getSource().getX() - i >= 0 && getConcreteChessGame().getChess(getSource().getX() - i, getSource().getY()).name == '_') {
                points.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()));
            } else if (getSource().getX() - i >= 0 && getConcreteChessGame().getChess(getSource().getX() - i, getSource().getY()).getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; ; i++) {
            if (getSource().getY() - i >= 0 && getConcreteChessGame().getChess(getSource().getX(), getSource().getY() - i).name == '_') {
                points.add(new ChessboardPoint(getSource().getX(), getSource().getY() - i));
            } else if (getSource().getY() - i >= 0 && getConcreteChessGame().getChess(getSource().getX(), getSource().getY() - i).getChessColor()!= this.getChessColor()) {
                points.add(new ChessboardPoint(getSource().getX(), getSource().getY() - i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; ; i++) {
            if (getSource().getX() + i < 8 && getConcreteChessGame().getChess(getSource().getX() + i, getSource().getY()).name == '_') {
                points.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));
            } else if (getSource().getX() + i < 8 && getConcreteChessGame().getChess(getSource().getX() + i, getSource().getY()).getChessColor() != this.getChessColor()) {
                points.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));
                break;
            } else {
                break;
            }
        }

        if (points.size() == 0) {
            return points;
        }
        List<ChessboardPoint> points1 = new ArrayList<>();
        for (ChessboardPoint p : points) {
            if (points1.size() == 0) {
                points1.add(points.get(0));
            } else {
                int i = 0;
                while (i < points1.size() && (p.getX() > points1.get(i).getX() || (p.getX() == points1.get(i).getX() && p.getY() > points1.get(i).getY()))) {
                    i++;
                }
                points1.add(i, p);
            }
        }
        return points1;
    }
}
