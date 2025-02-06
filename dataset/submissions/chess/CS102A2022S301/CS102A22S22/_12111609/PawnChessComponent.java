import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        setSource(source);
        setChessColor(chessColor);
        setName(name);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> potentialMove= new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        if (getChessColor()==ChessColor.BLACK) {
            if (x == 1) {
                if (y == 0) {
                    if (findOpposite(getChessColor(), getChessComponents()[x + 1][y + 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y + 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x + 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x + 1][y].getChessColor()) && findNone(getChessColor(), getChessComponents()[x + 2][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 2, y));
                    }
                } else if (y == 7) {
                    if (findOpposite(getChessColor(), getChessComponents()[x + 1][y - 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y - 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x + 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x + 1][y].getChessColor()) && findNone(getChessColor(), getChessComponents()[x + 2][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 2, y));
                    }
                } else {
                    if (findOpposite(getChessColor(), getChessComponents()[x + 1][y + 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y + 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x + 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x + 1][y].getChessColor()) && findNone(getChessColor(), getChessComponents()[x + 2][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 2, y));
                    }                    if (findOpposite(getChessColor(), getChessComponents()[x + 1][y - 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
            } else if (x == 3 || x == 4 || x == 5 || x == 6 || x == 2) {
                if (y == 0) {
                    if (findOpposite(getChessColor(), getChessComponents()[x + 1][y + 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y + 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x + 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y));
                    }
                } else if (y == 7) {
                    if (findOpposite(getChessColor(), getChessComponents()[x + 1][y - 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y - 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x + 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y));
                    }

                } else {
                    if (findOpposite(getChessColor(), getChessComponents()[x + 1][y + 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y + 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x + 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x+1, y));
                    }
                    if (findOpposite(getChessColor(), getChessComponents()[x + 1][y - 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
            } else {

            }
        }else if (getChessColor()==ChessColor.WHITE){
            if (x == 6) {
                if (y == 0) {
                    if (findOpposite(getChessColor(), getChessComponents()[x - 1][y + 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y + 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x - 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x - 1][y].getChessColor()) && findNone(getChessColor(), getChessComponents()[x - 2][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y));
                    }
                } else if (y == 7) {
                    if (findOpposite(getChessColor(), getChessComponents()[x - 1][y - 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y - 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x - 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x - 1][y].getChessColor()) && findNone(getChessColor(), getChessComponents()[x - 2][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y));
                    }

                } else {
                    if (findOpposite(getChessColor(), getChessComponents()[x - 1][y + 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y + 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x - 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x - 1][y].getChessColor()) && findNone(getChessColor(), getChessComponents()[x - 2][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y));
                    }
                    if (findOpposite(getChessColor(), getChessComponents()[x - 1][y - 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x -1 , y -1));
                    }
                }
            } else if (x == 3 || x == 4 || x == 5 || x == 1 || x == 2) {
                if (y == 0) {
                    if (findOpposite(getChessColor(), getChessComponents()[x - 1][y + 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y + 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x - 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y));
                    }
                } else if (y == 7) {
                    if (findOpposite(getChessColor(), getChessComponents()[x - 1][y - 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y - 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x - 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y));
                    }

                } else {
                    if (findOpposite(getChessColor(), getChessComponents()[x - 1][y + 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x - 1, y + 1));
                    }
                    if (findNone(getChessColor(), getChessComponents()[x - 1][y].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x-1, y ));
                    }
                    if (findOpposite(getChessColor(), getChessComponents()[x - 1][y - 1].getChessColor())) {
                        potentialMove.add(new ChessboardPoint(x -1 , y -1));
                    }
                }
            } else {

            }
        }
        Collections.sort(potentialMove, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() == o2.getX()){
                    return o1.getY()-o2.getY();
                }
                return o1.getX()-o2.getX();
            }
        });{
        }
        return potentialMove;

    }
}
