
import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.source = source;
        this.chessComponents = chessComponents;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX(), y = this.getSource().getY();
        List<ChessboardPoint> components = new ArrayList<>();
        for (int i = x + 1; i <= 7; i++) {
            if (chessComponents[i][y] .getChessColor()==ChessColor.NONE){
                ChessboardPoint a=new ChessboardPoint(i,y);
                components.add(a);
            } else {
                if (chessComponents[i][y].getChessColor() != chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a=new ChessboardPoint(i,y);
                    components.add(a);
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (chessComponents[i][y] .getChessColor() ==ChessColor.NONE) {
                ChessboardPoint a=new ChessboardPoint(i,y);
                components.add(a);
            } else {
                if (chessComponents[i][y].getChessColor() != chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a=new ChessboardPoint(i,y);
                    components.add(a);
                }
                break;
            }
        }
        for (int i = y + 1; i <= 7; i++) {
            if (chessComponents[x][i] .getChessColor() ==ChessColor.NONE) {
                ChessboardPoint a=new ChessboardPoint(x,i);
                components.add(a);
            } else {
                if (chessComponents[x][i].getChessColor() != chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a=new ChessboardPoint(x,i);
                    components.add(a);
                }
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (chessComponents[x][i] .getChessColor() ==ChessColor.NONE) {
                ChessboardPoint a=new ChessboardPoint(x,i);
                components.add(a);
            } else {
                if (chessComponents[x][i].getChessColor() != chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a=new ChessboardPoint(x,i);
                    components.add(a);
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0 && y - x + i >= 0; i--) {
            if (chessComponents[i][y - x + i] .getChessColor() ==ChessColor.NONE) {
                ChessboardPoint a=new ChessboardPoint(i,y-x+i);
                components.add(a);
            } else {
                if (chessComponents[i][y - x + i].getChessColor() != chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a=new ChessboardPoint(i,y-x+i);
                    components.add(a);
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0 && x + y - i <= 7; i--) {
            if (chessComponents[i][x + y - i] .getChessColor()==ChessColor.NONE) {
                ChessboardPoint a=new ChessboardPoint(i,y+x-i);
                components.add(a);
            } else {
                if (chessComponents[i][x + y - i].getChessColor() != chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a=new ChessboardPoint(i,y+x-i);
                    components.add(a);
                }
                break;
            }
        }
        for (int i = x + 1; i <= 7 && y - x + i <= 7; i++) {
            if (chessComponents[i][y - x + i].getChessColor() ==ChessColor.NONE) {
                ChessboardPoint a=new ChessboardPoint(i,y-x+i);
                components.add(a);
            } else {
                if (chessComponents[i][y - x + i].getChessColor() != chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a=new ChessboardPoint(i,y-x+i);
                    components.add(a);
                }
                break;
            }
        }
        for (int i = x + 1; i <= 7 && x + y - i >= 0; i++) {
            if (chessComponents[i][x + y - i] .getChessColor() ==ChessColor.NONE) {
                ChessboardPoint a=new ChessboardPoint(i,y+x-i);
                components.add(a);
            } else {
                if (chessComponents[i][x + y - i].getChessColor() != chessComponents[x][y].getChessColor()) {
                    ChessboardPoint a=new ChessboardPoint(i,y+x-i);
                    components.add(a);
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
