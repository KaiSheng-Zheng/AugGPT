import java.util.ArrayList;
import java.util.List;

class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();
        ChessboardPoint point;
        if (getSource().getX() - 2 >= 0 && getSource().getY() + 1 < 8) {
            point = new ChessboardPoint(getSource().getX() - 2, getSource().getY() + 1);
            if (getConcreteChessGame().getChess(point.getX(), point.getY()).getChessColor()!=this.getChessColor())points.add(point);
        }
        if (getSource().getX() - 2 >= 0 && getSource().getY() - 1 >= 0) {
            point = new ChessboardPoint(getSource().getX() - 2, getSource().getY() - 1);
            if (getConcreteChessGame().getChess(point.getX(), point.getY()).getChessColor()!=this.getChessColor())points.add(point);
        }
        if (getSource().getX() + 2 < 8 && getSource().getY() + 1 < 8) {
            point = new ChessboardPoint(getSource().getX() + 2, getSource().getY() + 1);
            if (getConcreteChessGame().getChess(point.getX(), point.getY()).getChessColor()!=this.getChessColor())points.add(point);
        }
        if (getSource().getX() + 1 < 8 && getSource().getY() + 2 < 8) {
            point = new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 2);
            if (getConcreteChessGame().getChess(point.getX(), point.getY()).getChessColor()!=this.getChessColor())points.add(point);
        }
        if (getSource().getX() + 2 < 8 && getSource().getY() - 1 >= 0) {
            point = new ChessboardPoint(getSource().getX() + 2, getSource().getY() - 1);
            if (getConcreteChessGame().getChess(point.getX(), point.getY()).getChessColor()!=this.getChessColor())points.add(point);
        }
        if (getSource().getX() + 1 < 8 && getSource().getY() - 2 >= 0) {
            point = new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 2);
            if (getConcreteChessGame().getChess(point.getX(), point.getY()).getChessColor()!=this.getChessColor())points.add(point);
        }
        if (getSource().getX() - 1 >= 0 && getSource().getY() + 2 < 8) {
            point = new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 2);
            if (getConcreteChessGame().getChess(point.getX(), point.getY()).getChessColor()!=this.getChessColor())points.add(point);
        }
        if (getSource().getX() - 1 >= 0 && getSource().getY() - 2 >= 0) {
            point = new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 2);
            if (getConcreteChessGame().getChess(point.getX(), point.getY()).getChessColor()!=this.getChessColor())points.add(point);
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
