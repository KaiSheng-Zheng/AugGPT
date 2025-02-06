import java.util.ArrayList;
import java.util.List;
public  class QueenChessComponent extends ChessComponent {
    public ChessComponent[][] c;
    public QueenChessComponent() {
        c = new ChessComponent[8][8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                c[i][j] = new ChessComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }

                    @Override
                    public void setQP(ChessComponent[][] cc) {

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
        for(int i=super.getSource().getX()-1;i>=0;i--) {
            if(c[i][super.getSource().getY()].getChessColor() == super.getChessColor()) i=-1;
            else if(c[i][super.getSource().getY()].getChessColor() == ChessColor.NONE) a.add(new ChessboardPoint(i,super.getSource().getY()));
            else {
                a.add(new ChessboardPoint(i,super.getSource().getY())); i=-1;
            }
        }
        for(int i=super.getSource().getX()+1;i<=7;i++) {
            if(c[i][super.getSource().getY()].getChessColor() == super.getChessColor()) i=8;
            else if(c[i][super.getSource().getY()].getChessColor() == ChessColor.NONE) a.add(new ChessboardPoint(i,super.getSource().getY()));
            else {
                a.add(new ChessboardPoint(i,super.getSource().getY())); i=8;
            }
        }

        for(int j=super.getSource().getY()-1;j>=0;j--) {
            if(c[super.getSource().getX()][j].getChessColor() == super.getChessColor()) j=-1;
            else if(c[super.getSource().getX()][j].getChessColor() == ChessColor.NONE) a.add(new ChessboardPoint(super.getSource().getX(),j));
            else {
                a.add(new ChessboardPoint(super.getSource().getX(),j)); j=-1;
            }
        }
        for(int j=super.getSource().getY()+1;j<=7;j++) {
            if(c[super.getSource().getX()][j].getChessColor() == super.getChessColor()) j=8;
            else if(c[super.getSource().getX()][j].getChessColor() == ChessColor.NONE) a.add(new ChessboardPoint(super.getSource().getX(),j));
            else {
                a.add(new ChessboardPoint(super.getSource().getX(),j)); j=8;
            }
        }

        boolean l=true,r=true;
        for(int i=x-1;i>=0;i--) {
            int d = x-i;
            if(y - d >= 0 && l==true) {
                if(c[i][y-d].getChessColor() == ChessColor.NONE) a.add(new ChessboardPoint(i,y-d));
                else if(c[i][y-d].getChessColor() != super.getChessColor()) {
                    a.add(new ChessboardPoint(i,y-d)); l=false;
                }
                else l=false;
            }
            if(y + d <= 7 && r==true) {
                if(c[i][y+d].getChessColor() == ChessColor.NONE) a.add(new ChessboardPoint(i,y+d));
                else if(c[i][y+d].getChessColor() != super.getChessColor()) {
                    a.add(new ChessboardPoint(i,y+d)); r=false;
                }
                else r=false;
            }
        }
        l=true; r=true;
        for(int i=x+1;i<=7;i++) {
            int d = i-x;
            if(y - d >= 0 && l==true) {
                if(c[i][y-d].getChessColor() == ChessColor.NONE) a.add(new ChessboardPoint(i,y-d));
                else if(c[i][y-d].getChessColor() != super.getChessColor()) {
                    a.add(new ChessboardPoint(i,y-d)); l=false;
                }
                else l=false;
            }
            if(y + d <= 7 && r==true) {
                if(c[i][y+d].getChessColor() == ChessColor.NONE) a.add(new ChessboardPoint(i,y+d));
                else if(c[i][y+d].getChessColor() != super.getChessColor()) {
                    a.add(new ChessboardPoint(i,y+d)); r=false;
                }
                else r=false;
            }
        }

        if(a.size()==0) return new ArrayList<>();
        return a;
    }
}
