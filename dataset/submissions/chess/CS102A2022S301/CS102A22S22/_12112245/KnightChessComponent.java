

import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent (ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.source = source;
        this.chessComponents = chessComponents;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX(), y = this.getSource().getY();
        List<ChessboardPoint> components = new ArrayList<>();
        if (x + 1 <= 7) {
            if (y + 2 <= 7) {
                if (chessComponents[x + 1][y + 2] .getChessColor() !=chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a = new ChessboardPoint(x+1, y+2);
                    components.add(a);

                }
            }
            if (y - 2 >= 0) {
                if (chessComponents[x + 1][y - 2] .getChessColor() !=chessComponents[x][y].getChessColor() ) {
                    ChessboardPoint a = new ChessboardPoint(x+1, y-2);
                    components.add(a);
                }
            }
        }
        if (x - 1 >= 0) {
            if (y + 2 <= 7) {
                if (chessComponents[x - 1][y + 2] .getChessColor() !=chessComponents[x][y].getChessColor() ) {
                    ChessboardPoint a = new ChessboardPoint(x-1, y+2);
                    components.add(a);
                }
            }
            if (y - 2 >= 0) {
                if (chessComponents[x - 1][y - 2].getChessColor() !=chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a = new ChessboardPoint(x-1, y-2);
                    components.add(a);
                }
            }
        }
        if (y + 1 <= 7) {
            if (x + 2 <= 7) {
                if (chessComponents[x + 2][y + 1] .getChessColor() !=chessComponents[x][y].getChessColor() ) {
                    ChessboardPoint a = new ChessboardPoint(x+2, y+1);
                    components.add(a);
                }
            }
            if (x - 2 >= 0) {
                if (chessComponents[x - 2][y + 1] .getChessColor() !=chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a = new ChessboardPoint(x-2, y+1);
                    components.add(a);
                }
            }
        }
        if (y - 1 >= 0) {
            if (x + 2 <= 7) {
                if (chessComponents[x + 2][y - 1] .getChessColor() !=chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a = new ChessboardPoint(x+2, y-1);
                    components.add(a);
                }
            }
            if (x - 2 >= 0) {
                if (chessComponents[x - 2][y - 1] .getChessColor() !=chessComponents[x][y].getChessColor() ) {
                    ChessboardPoint a = new ChessboardPoint(x-2, y-1);
                    components.add(a);
                }
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
