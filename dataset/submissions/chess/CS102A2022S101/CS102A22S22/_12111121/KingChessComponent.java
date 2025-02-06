import java.util.ArrayList;
import java.util.List;
public  class KingChessComponent extends ChessComponent {
    public ChessComponent[][] c;
    public KingChessComponent() {
        c = new ChessComponent[8][8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                c[i][j] = new ChessComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }
                };
            }
        }
    }
    public  void setQP(ChessComponent[][] cc) {
        for(int i=0;i<=7;i++) {
            for(int j=0;j<=7;j++) {
                c[i][j] = cc[i][j];
            }
        }
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList a = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();

        if(x-1 >= 0) {
            if(c[x-1][y].getChessColor() != super.getChessColor()) a.add(new ChessboardPoint(x-1,y));
        }
        if(x-1 >= 0 && y-1 >= 0 ) {
            if(c[x-1][y-1].getChessColor() != super.getChessColor()) a.add(new ChessboardPoint(x-1,y-1));
        }
        if(x-1 >= 0 && y+1 <= 7) {
            if(c[x-1][y+1].getChessColor() != super.getChessColor()) a.add(new ChessboardPoint(x-1,y+1));
        }
        if(y-1 >= 0) {
            if(c[x][y-1].getChessColor() != super.getChessColor()) a.add(new ChessboardPoint(x,y-1));
        }
        if(y+1 <= 7) {
            if(c[x][y+1].getChessColor() != super.getChessColor()) a.add(new ChessboardPoint(x,y+1));
        }
        if(x+1 <= 7) {
            if(c[x+1][y].getChessColor() != super.getChessColor()) a.add(new ChessboardPoint(x+1,y));
        }
        if(x+1 <= 7 && y-1 >= 0 ) {
            if(c[x+1][y-1].getChessColor() != super.getChessColor()) a.add(new ChessboardPoint(x+1,y-1));
        }
        if(x+1 <= 7 && y+1 <= 7) {
            if(c[x+1][y+1].getChessColor() != super.getChessColor()) a.add(new ChessboardPoint(x+1,y+1));
        }

        if(a.size()==0) return new ArrayList<>();
        return a;
    }
}
