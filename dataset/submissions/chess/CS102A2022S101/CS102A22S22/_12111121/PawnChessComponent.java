import java.util.ArrayList;
import java.util.List;
public  class PawnChessComponent extends ChessComponent {
    public ChessComponent[][] c;
    public PawnChessComponent() {
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

        if(super.getChessColor() == ChessColor.BLACK) {
            if(x == 1) {
                if(c[x+1][y].getChessColor() != ChessColor.NONE) {
                    if(y-1 >= 0) {
                        if(c[x+1][y-1].getChessColor() != super.getChessColor() && c[x-1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y-1));
                    }
                    if(y+1 <= 7) {
                        if(c[x+1][y+1].getChessColor() != super.getChessColor() && c[x-1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y+1));
                    }
                }
                else {
                    if(c[x+2][y].getChessColor() != ChessColor.NONE) {
                        a.add(new ChessboardPoint(x+1,y));
                        if(y-1 >= 0) {
                            if(c[x+1][y-1].getChessColor() != super.getChessColor() && c[x-1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y-1));
                        }
                        if(y+1 <= 7) {
                            if(c[x+1][y+1].getChessColor() != super.getChessColor() && c[x-1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y+1));
                        }
                    }
                    else {
                        a.add(new ChessboardPoint(x+1,y));
                        a.add(new ChessboardPoint(x+2,y));
                        if(y-1 >= 0) {
                            if(c[x+1][y-1].getChessColor() != super.getChessColor() && c[x+1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y-1));
                        }
                        if(y+1 <= 7) {
                            if(c[x+1][y+1].getChessColor() != super.getChessColor() && c[x+1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y+1));
                        }
                    }
                }
            }
            else {
                if(c[x+1][y].getChessColor() != ChessColor.NONE) {
                    if(y-1 >= 0) {
                        if(c[x+1][y-1].getChessColor() != super.getChessColor() && c[x+1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y-1));
                    }
                    if(y+1 <= 7) {
                        if(c[x+1][y+1].getChessColor() != super.getChessColor() && c[x+1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y+1));
                    }
                }
                else {
                    a.add(new ChessboardPoint(x+1,y));
                    if(y-1 >= 0) {
                        if(c[x+1][y-1].getChessColor() != super.getChessColor() && c[x+1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y-1));
                    }
                    if(y+1 <= 7) {
                        if(c[x+1][y+1].getChessColor() != super.getChessColor() && c[x+1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x+1,y+1));
                    }
                }
            }
        }
        else if(super.getChessColor() == ChessColor.WHITE) {
            if(x == 6) {
                if(c[x-1][y].getChessColor() != ChessColor.NONE) {
                    if(y-1 >= 0) {
                        if(c[x-1][y-1].getChessColor() != super.getChessColor() && c[x-1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y-1));
                    }
                    if(y+1 <= 7) {
                        if(c[x-1][y+1].getChessColor() != super.getChessColor() && c[x-1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y+1));
                    }
                }
                else {
                    if(c[x-2][y].getChessColor()  != ChessColor.NONE) {
                        a.add(new ChessboardPoint(x-1,y));
                        if(y-1 >= 0) {
                            if(c[x-1][y-1].getChessColor() != super.getChessColor() && c[x-1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y-1));
                        }
                        if(y+1 <= 7) {
                            if(c[x-1][y+1].getChessColor() != super.getChessColor() && c[x-1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y+1));
                        }
                    }
                    else {
                        a.add(new ChessboardPoint(x-1,y));
                        a.add(new ChessboardPoint(x-2,y));
                        if(y-1 >= 0) {
                            if(c[x-1][y-1].getChessColor() != super.getChessColor() && c[x-1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y-1));
                        }
                        if(y+1 <= 7) {
                            if(c[x-1][y+1].getChessColor() != super.getChessColor() && c[x-1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y+1));
                        }
                    }
                }
            }
            else {
                if(c[x-1][y].getChessColor() != ChessColor.NONE) {
                    if(y-1 >= 0) {
                        if(c[x-1][y-1].getChessColor() != super.getChessColor() && c[x-1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y-1));
                    }
                    if(y+1 <= 7) {
                        if(c[x-1][y+1].getChessColor() != super.getChessColor() && c[x-1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y+1));
                    }
                }
                else {
                    a.add(new ChessboardPoint(x-1,y));
                    if(y-1 >= 0) {
                        if(c[x-1][y-1].getChessColor() != super.getChessColor() && c[x-1][y-1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y-1));
                    }
                    if(y+1 <= 7) {
                        if(c[x-1][y+1].getChessColor() != super.getChessColor() && c[x-1][y+1].getChessColor()!=ChessColor.NONE) a.add(new ChessboardPoint(x-1,y+1));
                    }
                }
            }
        }

        if(a.size()==0) return new ArrayList<>();
        return a;
    }
}
