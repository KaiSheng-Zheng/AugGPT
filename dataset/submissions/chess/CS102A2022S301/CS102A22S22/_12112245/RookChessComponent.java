
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source){
        this.source=source;
        this.chessComponents=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX(), y = this.getSource().getY();
        List<ChessboardPoint> components = new ArrayList<>();
        for (int i = x + 1; i <= 7; i++) {
            if (chessComponents[i][y] instanceof EmptySlotComponent) {
                ChessboardPoint b=new ChessboardPoint(i,y);
                components.add(b);
            } else {
                if (chessComponents[i][y].getChessColor() != this.getChessColor()) {
                    ChessboardPoint b=new ChessboardPoint(i,y);
                    components.add(b);
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (chessComponents[i][y] instanceof EmptySlotComponent) {
                ChessboardPoint b=new ChessboardPoint(i,y);
                components.add(b);
            } else {
                if (chessComponents[i][y].getChessColor() != this.getChessColor()) {
                    ChessboardPoint b=new ChessboardPoint(i,y);
                    components.add(b);
                }
                break;
            }
        }
        for (int i = y + 1; i <= 7; i++) {
            if (chessComponents[x][i] instanceof EmptySlotComponent) {
                ChessboardPoint b=new ChessboardPoint(x,i);
                components.add(b);
            } else {
                if (chessComponents[x][i].getChessColor() != this.getChessColor()) {
                    ChessboardPoint b=new ChessboardPoint(x,i);
                    components.add(b);
                }
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (chessComponents[x][i] instanceof EmptySlotComponent) {
                ChessboardPoint b=new ChessboardPoint(x,i);
                components.add(b);
            } else {
                if (chessComponents[x][i].getChessColor() != this.getChessColor()) {
                    ChessboardPoint b=new ChessboardPoint(x,i);
                    components.add(b);
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
