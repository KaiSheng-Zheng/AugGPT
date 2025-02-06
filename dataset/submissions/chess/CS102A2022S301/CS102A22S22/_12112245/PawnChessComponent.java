
import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.source = source;
        this.chessComponents = chessComponents;

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {


        int x = this.getSource().getX(), y = this.getSource().getY();
        List<ChessboardPoint> components = new ArrayList<>();
        if (this.getChessColor() == ChessColor.WHITE) {
            if (x == 6 && chessComponents[5][y] .getChessColor() !=chessComponents[x][y].getChessColor()) {
                ChessboardPoint a = new ChessboardPoint(5, y);
                components.add(a);
                System.out.printf("(%s,%s)\n", 5, y);
                if (chessComponents[4][y] .getChessColor() !=chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a2 = new ChessboardPoint(4, y);
                    components.add(a2);
                    ;
                }
            } else if (x - 1 >= 0 && chessComponents[x - 1][y].getChessColor() ==ChessColor.NONE) {
                ChessboardPoint a = new ChessboardPoint(x - 1, y);
                components.add(a);
            }
            if (x - 1 >= 0 && y - 1 >= 0  && chessComponents[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                ChessboardPoint a = new ChessboardPoint(x - 1, y - 1);
                components.add(a);
            }
            if (x - 1 >= 0 && y + 1 <= 7 && chessComponents[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                ChessboardPoint a = new ChessboardPoint(x - 1, y + 1);
                components.add(a);
            }
        }
        if (chessComponents[x][y].getChessColor() == ChessColor.BLACK) {
            if (x == 1 && chessComponents[2][y] .getChessColor()==ChessColor.NONE) {
                ChessboardPoint a = new ChessboardPoint(2, y);
                components.add(a);
                if (chessComponents[3][y].getChessColor()==ChessColor.NONE) {
                    ChessboardPoint a2 = new ChessboardPoint(3, y);
                    components.add(a2);
                }
            } else if (x + 1 <= 7 && chessComponents[x + 1][y] .getChessColor()==ChessColor.NONE) {
                ChessboardPoint a = new ChessboardPoint(x + 1, y);
                components.add(a);
            }
            if (x + 1 <= 7 && y - 1 >= 0  && chessComponents[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                ChessboardPoint a = new ChessboardPoint(x + 1, y - 1);
                components.add(a);
            }
            if (x + 1 <= 7 && y + 1 <= 7&& chessComponents[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                ChessboardPoint a = new ChessboardPoint(x + 1, y + 1);
                components.add(a);
            }
        }
        for (int i = components.size()-1; i >0; i--) {
            for (int j = i-1; j >=0; j--) {
                if(components.get(j).getX()>components.get(i).getX()){
                    ChessboardPoint t=components.get(j);
                    components.set(j,components.get(i));
                    components.set(i,t);

                }
                if(components.get(j).getX()==components.get(i).getX()&&components.get(j).getY()>components.get(i).getY()){
                    ChessboardPoint t=components.get(j);
                    components.set(j,components.get(i));
                    components.set(i,t);

                }

            }

        }

        return components;
    }
}
