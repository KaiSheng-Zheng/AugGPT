

import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.source = source;
        this.chessComponents = chessComponents;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX(), y = this.getSource().getY();
        List<ChessboardPoint> components = new ArrayList<>();

        for (int i = x - 1; i >= 0 && i + y - x >= 0; i--) {
            if (chessComponents[i][i + y - x].getChessColor() ==ChessColor.NONE) {
                ChessboardPoint b= new ChessboardPoint(i,i+y-x);
                components.add(b);
            } else {
                if (chessComponents[i][i + y - x] .getChessColor() != this.getChessColor()) {
                    ChessboardPoint b= new ChessboardPoint(i,i+y-x);
                    components.add(b);
                    break;
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0 && x + y - i <= 7; i--) {
            if (chessComponents[i][x + y - i] .getChessColor() ==ChessColor.NONE) {
                ChessboardPoint b= new ChessboardPoint(i,x+y-i);
                components.add(b);
            } else {
                if (chessComponents[i][x + y - i] .getChessColor() != this.getChessColor()) {
                    ChessboardPoint b= new ChessboardPoint(i,x+y-i);
                    components.add(b);
                    break;
                }
                break;
            }
        }
        for (int i = x + 1; i <= 7 && x + y - i >= 0; i++) {
            if (chessComponents[i][x + y - i] .getChessColor() ==ChessColor.NONE) {
                ChessboardPoint b= new ChessboardPoint(i,x+y-i);
                components.add(b);
            } else {
                if (chessComponents[i][x + y - i] .getChessColor() != this.getChessColor()) {
                    ChessboardPoint b= new ChessboardPoint(i,x+y-i);
                    components.add(b);
                    break;
                }
                break;
            }
        }
        for (int i = x + 1; i <= 7 && i + y - x <= 7; i++) {
            if (chessComponents[i][i + y - x] .getChessColor() ==ChessColor.NONE) {
                ChessboardPoint b= new ChessboardPoint(i,i+y-x);
                components.add(b);
            } else {
                if (chessComponents[i][i + y - x] .getChessColor() != this.getChessColor()) {
                    ChessboardPoint b= new ChessboardPoint(i,i+y-x);
                    components.add(b);
                    break;
                }
                break;
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
