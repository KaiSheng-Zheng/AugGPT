import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor color,ChessboardPoint cp,char name){
        this.chessColor = color;
        this.source = cp;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        if (source.getX() != 0 && source.getX() != 7 && source.getY() != 0 && source.getY() != 7){
            if (chessComponent[source.getX() - 1][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                a.add(new ChessboardPoint(source.getX() - 1,source.getY() - 1));
            }
            if (chessComponent[source.getX() - 1][source.getY()].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                a.add(new ChessboardPoint(source.getX() - 1,source.getY()));
            }
            if (chessComponent[source.getX() - 1][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                a.add(new ChessboardPoint(source.getX() - 1,source.getY() + 1));
            }
            if (chessComponent[source.getX()][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                a.add(new ChessboardPoint(source.getX(),source.getY() - 1));
            }
            if (chessComponent[source.getX()][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                a.add(new ChessboardPoint(source.getX(),source.getY() + 1));
            }
            if (chessComponent[source.getX() + 1][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                a.add(new ChessboardPoint(source.getX() + 1,source.getY() - 1));
            }
            if (chessComponent[source.getX() + 1][source.getY()].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                a.add(new ChessboardPoint(source.getX() + 1,source.getY()));
            }
            if (chessComponent[source.getX() + 1][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                a.add(new ChessboardPoint(source.getX() + 1,source.getY() + 1));
            }
        }

        if (source.getX() == 0){
            if (source.getY() == 0){
                if (chessComponent[source.getX()][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX(),source.getY() + 1));
                }
                if (chessComponent[source.getX() + 1][source.getY()].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() + 1,source.getY()));
                }
                if (chessComponent[source.getX() + 1][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() + 1,source.getY() + 1));
                }
            }

            if (source.getY() == 7){
                if (chessComponent[source.getX()][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX(),source.getY() - 1));
                }
                if (chessComponent[source.getX() + 1][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() + 1,source.getY() - 1));
                }
                if (chessComponent[source.getX() + 1][source.getY()].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() + 1,source.getY()));
                }

            }
            else {
                if (chessComponent[source.getX()][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX(),source.getY() - 1));
                }
                if (chessComponent[source.getX()][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX(),source.getY() + 1));
                }
                if (chessComponent[source.getX() + 1][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() + 1,source.getY() - 1));
                }
                if (chessComponent[source.getX() + 1][source.getY()].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() + 1,source.getY()));
                }
                if (chessComponent[source.getX() + 1][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() + 1,source.getY() + 1));
                }
            }
        }

        if (source.getX() == 7){
            if (source.getY() == 0){
                if (chessComponent[source.getX()][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX(),source.getY() + 1));
                }
                if (chessComponent[source.getX() - 1][source.getY()].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() - 1,source.getY()));
                }
                if (chessComponent[source.getX() - 1][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() - 1,source.getY() + 1));
                }
            }
            if (source.getY() == 7){
                if (chessComponent[source.getX()][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX(),source.getY() - 1));
                }
                if (chessComponent[source.getX() - 1][source.getY()].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() - 1,source.getY()));
                }
                if (chessComponent[source.getX() - 1][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() - 1,source.getY() - 1));
                }
            }
            else {
                if (chessComponent[source.getX()][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX(),source.getY() - 1));
                }
                if (chessComponent[source.getX()][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX(),source.getY() + 1));
                }
                if (chessComponent[source.getX() - 1][source.getY()].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() - 1,source.getY()));
                }
                if (chessComponent[source.getX() - 1][source.getY() - 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() - 1,source.getY() - 1));
                }
                if (chessComponent[source.getX() - 1][source.getY() + 1].getChessColor() != chessComponent[source.getX()][source.getY()].getChessColor()){
                    a.add(new ChessboardPoint(source.getX() - 1,source.getY() + 1));
                }
            }

        }

        return a;
    }
}
