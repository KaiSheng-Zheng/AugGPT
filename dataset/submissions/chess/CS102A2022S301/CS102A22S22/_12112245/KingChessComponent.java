import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.source = source;
        this.chessComponents = chessComponents;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX(), y = this.getSource().getY();
        List<ChessboardPoint> components = new ArrayList<>();
        if (x + 1 <= 7 && chessComponents[x + 1][y].getChessColor()!=chessComponents[x][y].getChessColor()) {
            ChessboardPoint a= new ChessboardPoint(x+1,y);
            components.add(a);
        }
        if (x - 1 >= 0 && chessComponents[x - 1][y].getChessColor() !=chessComponents[x][y].getChessColor()) {
            ChessboardPoint a= new ChessboardPoint(x-1,y);
            components.add(a);
        }
        if (y + 1 <= 7 && chessComponents[x][y + 1] .getChessColor() !=chessComponents[x][y].getChessColor()) {
            ChessboardPoint a= new ChessboardPoint(x,y+1);
            components.add(a);
        }
        if (y - 1 >= 0 && chessComponents[x][y - 1] .getChessColor() !=chessComponents[x][y].getChessColor()) {
            ChessboardPoint a= new ChessboardPoint(x,y-1);
            components.add(a);
        }
        if (x + 1 <= 7 && y + 1 <= 7 && chessComponents[x + 1][y + 1] .getChessColor() !=chessComponents[x][y].getChessColor()) {
            ChessboardPoint a= new ChessboardPoint(x+1,y+1);
            components.add(a);
        }
        if (x + 1 <= 7 && y - 1 >= 0 && chessComponents[x + 1][y - 1] .getChessColor() !=chessComponents[x][y].getChessColor()) {
            ChessboardPoint a= new ChessboardPoint(x+1,y-1);
            components.add(a);
        }
        if (x - 1 >= 0 && y - 1 >= 0 && chessComponents[x - 1][y - 1] .getChessColor() !=chessComponents[x][y].getChessColor()) {
            ChessboardPoint a= new ChessboardPoint(x-1,y-1);
            components.add(a);
        }
        if (x - 1 >= 0 && y + 1 <= 7 && chessComponents[x - 1][y + 1] .getChessColor() !=chessComponents[x][y].getChessColor()) {
            ChessboardPoint a= new ChessboardPoint(x-1,y+1);
            components.add(a);
        }
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        for (ChessboardPoint component : components) {
            if (!noKing(x, y, component.getX(), component.getY(), chessComponents)) {
                arrayList.add(component);
            }
        }
        for (ChessboardPoint chessComponent : arrayList) {
            components.remove(chessComponent);
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
    public boolean inChessboard(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    public boolean noKing(int x, int y, int x0, int y0, ChessComponent[][] chessComponents) {
        List<ChessComponent> components = new ArrayList<>();
        if (inChessboard(x0, y0 + 1)) {
            components.add(chessComponents[x0][y0 + 1]);
        }
        if (inChessboard(x0, y0 - 1)) {
            components.add(chessComponents[x0][y0 - 1]);
        }
        if (inChessboard(x0 - 1, y0)) {
            components.add(chessComponents[x0 - 1][y0]);
        }
        if (inChessboard(x0 + 1, y0)) {
            components.add(chessComponents[x0 + 1][y0]);
        }
        if (inChessboard(x0 + 1, y0 + 1)) {
            components.add(chessComponents[x0 + 1][y0 + 1]);
        }
        if (inChessboard(x0 - 1, y0 + 1)) {
            components.add(chessComponents[x0 - 1][y0 + 1]);
        }
        if (inChessboard(x0 + 1, y0 - 1)) {
            components.add(chessComponents[x0 + 1][y0 - 1]);
        }
        if (inChessboard(x0 - 1, y0 - 1)) {
            components.add(chessComponents[x0 - 1][y0 - 1]);
        }
        for (ChessComponent component : components) {
            if (component instanceof KingChessComponent && component.getChessColor() != chessComponents[x][y].getChessColor()) {
                return false;
            }
        }
        return true;
    }

}

