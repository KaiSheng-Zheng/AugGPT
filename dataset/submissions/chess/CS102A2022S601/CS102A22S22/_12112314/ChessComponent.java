import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessboardPoint getSource() {
        return source;
    }
    protected char name;
    protected ChessComponent[][] chessboard=new ChessComponent[8][8];
    public ChessComponent(){}
    public void loadChessboard(ChessComponent[][] chessComponents){
        for (int i = 0; i < chessComponents.length; i++) {
            System.arraycopy(chessComponents[i], 0, chessboard[i], 0, chessComponents[i].length);
        }
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public String getName(){return String.valueOf(name);}
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
class SortByXY implements Comparator<ChessboardPoint> {
    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        if(o1.getX()>o2.getX()) {
            return 1;
        }
        else if (o1.getX() == o2.getX()) {
            if (o1.getY()>o2.getY()){
                return 1;
            }
            else if (o1.getY()==o2.getY()){return 0;}
            return -1;
        }
        return -1;
    }
}
class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint point, ChessColor color){
        super.setSource(point);super.setChessColor(color);
        if (color.equals(ChessColor.WHITE)){this.name='k';}else {this.name='K';}
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> w = new ArrayList<>();
        if (getSource().getX() != 0  ) {
            if (!chessboard[getSource().getX() - 1][getSource().getY()].getChessColor().equals(getChessColor())){
            w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
        }}
        if (getSource().getX() != 0 & getSource().getY() != 7  ) {
            if (!chessboard[getSource().getX() - 1][getSource().getY() + 1].getChessColor().equals(getChessColor())){
            w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
        }}
        if (getSource().getX() != 0 & getSource().getY() != 0 ) {
            if (!chessboard[getSource().getX() - 1][getSource().getY() - 1].getChessColor().equals(getChessColor())){
            w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
        }}
        if (getSource().getY() != 0 ) {
            if (!chessboard[getSource().getX()][getSource().getY() - 1].getChessColor().equals(getChessColor())){
            w.add(new ChessboardPoint(getSource().getX(), getSource().getY() - 1));
        }}
        if ( getSource().getY() != 7  ) {
            if (!chessboard[getSource().getX()][getSource().getY() + 1].getChessColor().equals(getChessColor())){
            w.add(new ChessboardPoint(getSource().getX() , getSource().getY() + 1));
        }}
        if (getSource().getX() != 7   ) {
            if (!chessboard[getSource().getX() + 1][getSource().getY() ].getChessColor().equals(getChessColor())){
            w.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() ));
        }}
        if (getSource().getX() != 7 & getSource().getY() != 0  ) {
            if (!chessboard[getSource().getX() + 1][getSource().getY() - 1].getChessColor().equals(getChessColor())){
            w.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
        }}
        if (getSource().getX() != 7 & getSource().getY() != 7  ) {
            if (!chessboard[getSource().getX() + 1][getSource().getY() + 1].getChessColor().equals(getChessColor())){
            w.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
        }}
        w.sort(new SortByXY());
        return w;
    }
}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint point,ChessColor color){
        super.setSource(point);super.setChessColor(color);
        if (color.equals(ChessColor.WHITE)){this.name='q';}else {this.name='Q';}
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> w = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() + i <= 7&getSource().getY()+i<=7) {
                if (chessboard[getSource().getX() + i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()+i));
                } else if (chessboard[getSource().getX() + i][getSource().getY()+i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() + i][getSource().getY()+i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() + i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()+i));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() - i >=0&getSource().getY()-i>=0) {
                if (chessboard[getSource().getX() - i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()-i));
                } else if (chessboard[getSource().getX() - i][getSource().getY()-i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() - i][getSource().getY()-i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() - i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()-i));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() -i>=0&getSource().getY()+i<=7) {
                if (chessboard[getSource().getX() - i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()+i));
                } else if (chessboard[getSource().getX() - i][getSource().getY()+i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() - i][getSource().getY()+i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() - i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()+i));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() + i <= 7&getSource().getY()-i>=0) {
                if (chessboard[getSource().getX() + i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()-i));
                } else if (chessboard[getSource().getX() + i][getSource().getY()-i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() + i][getSource().getY()-i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() + i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()-i));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() + i <= 7) {
                if (chessboard[getSource().getX() + i][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));
                } else if (chessboard[getSource().getX() + i][getSource().getY()].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() + i][getSource().getY()].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() + i][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() - i >=0) {
                if (chessboard[getSource().getX() - i][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()));
                } else if (chessboard[getSource().getX() - i][getSource().getY()].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() - i][getSource().getY()].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() - i][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getY() + i <= 7) {
                if (chessboard[getSource().getX() ][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() , getSource().getY()+i));
                } else if (chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() ][getSource().getY()+i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() ][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() , getSource().getY()+i));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getY() - i >=0) {
                if (chessboard[getSource().getX() ][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() , getSource().getY()-i));
                } else if (chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() ][getSource().getY()-i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() ][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() , getSource().getY()-i));break;
                }
            }
            else break;
        }
        w.sort(new SortByXY());
        return w;
    }
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint point,ChessColor color){
        super.setSource(point);super.setChessColor(color);
        if (color.equals(ChessColor.WHITE)){this.name='r';}else {this.name='R';}
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> w = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() + i <= 7) {
                if (chessboard[getSource().getX() + i][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));
                } else if (chessboard[getSource().getX() + i][getSource().getY()].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() + i][getSource().getY()].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() + i][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() - i >=0) {
                if (chessboard[getSource().getX() - i][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()));
                } else if (chessboard[getSource().getX() - i][getSource().getY()].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() - i][getSource().getY()].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() - i][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getY() + i <= 7) {
                if (chessboard[getSource().getX() ][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() , getSource().getY()+i));
                } else if (chessboard[getSource().getX()][getSource().getY()+i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() ][getSource().getY()+i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() ][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() , getSource().getY()+i));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getY() - i >=0) {
                if (chessboard[getSource().getX() ][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() , getSource().getY()-i));
                } else if (chessboard[getSource().getX()][getSource().getY()-i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() ][getSource().getY()-i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() ][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() , getSource().getY()-i));break;
                }
            }
            else break;
        }
        w.sort(new SortByXY());
        return w;
    }
}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint point,ChessColor color){
        super.setSource(point);super.setChessColor(color);
        if (color.equals(ChessColor.WHITE)){this.name='b';}else {this.name='B';}
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> w = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() + i <= 7&getSource().getY()+i<=7) {
                if (chessboard[getSource().getX() + i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()+i));
                } else if (chessboard[getSource().getX() + i][getSource().getY()+i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() + i][getSource().getY()+i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() + i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()+i));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() - i >=0&getSource().getY()-i>=0) {
                if (chessboard[getSource().getX() - i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()-i));
                } else if (chessboard[getSource().getX() - i][getSource().getY()-i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() - i][getSource().getY()-i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() - i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()-i));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() -i>=0&getSource().getY()+i<=7) {
                if (chessboard[getSource().getX() - i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()+i));
                } else if (chessboard[getSource().getX() - i][getSource().getY()+i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() - i][getSource().getY()+i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() - i][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()+i));break;
                }
            }
            else break;
        }
        for (int i = 1; i < 8; i++) {
            if (getSource().getX() + i <= 7&getSource().getY()-i>=0) {
                if (chessboard[getSource().getX() + i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()-i));
                } else if (chessboard[getSource().getX() + i][getSource().getY()-i].getChessColor().equals(getChessColor())) {
                    break;
                }else if (!(chessboard[getSource().getX() + i][getSource().getY()-i].getChessColor()).equals(getChessColor())&!chessboard[getSource().getX() + i][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                    w.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()-i));break;
                }
            }
            else break;
        }
        w.sort(new SortByXY());
        return w;
    }
}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint point,ChessColor color){
        super.setSource(point);super.setChessColor(color);
        if (color.equals(ChessColor.WHITE)){this.name='n';}else {this.name='N';}
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> w = new ArrayList<>();
        if (getSource().getX() + 1 <= 7&getSource().getY()+2<=7) {
            if (!chessboard[getSource().getX() + 1][getSource().getY()+2].getChessColor().equals(getChessColor())) {
                w.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()+2));
            }
        }
        if (getSource().getX() + 2 <= 7&getSource().getY()+1<=7) {
            if (!chessboard[getSource().getX() + 2][getSource().getY()+1].getChessColor().equals(getChessColor())) {
                w.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY()+1));
            }
        }
        if (getSource().getX() - 1 >=0&getSource().getY()+2<=7) {
            if (!chessboard[getSource().getX() - 1][getSource().getY()+2].getChessColor().equals(getChessColor())) {
                w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()+2));
            }
        }
        if (getSource().getX() - 2 >=0&getSource().getY()+1<=7) {
            if (!chessboard[getSource().getX() - 2][getSource().getY()+1].getChessColor().equals(getChessColor())) {
                w.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY()+1));
            }
        }
        if (getSource().getX() + 1 <= 7&getSource().getY()-2>=0) {
            if (!chessboard[getSource().getX() + 1][getSource().getY()-2].getChessColor().equals(getChessColor())) {
                w.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()-2));
            }
        }
        if (getSource().getX() + 2 <= 7&getSource().getY()-1>=0) {
            if (!chessboard[getSource().getX() + 2][getSource().getY()-1].getChessColor().equals(getChessColor())) {
                w.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY()-1));
            }
        }
        if (getSource().getX() - 1 >=0&getSource().getY()-2>=0) {
            if (!chessboard[getSource().getX() - 1][getSource().getY()-2].getChessColor().equals(getChessColor())) {
                w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()-2));
            }
        }
        if (getSource().getX() - 2>=0&getSource().getY()-1>=0) {
            if (!chessboard[getSource().getX() -2][getSource().getY()-1].getChessColor().equals(getChessColor())) {
                w.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY()-1));
            }
        }
        w.sort(new SortByXY());
        return w;
    }
}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint point,ChessColor color){
        super.setSource(point);super.setChessColor(color);
        if (color.equals(ChessColor.WHITE)){this.name='p';}else {this.name='P';}
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> w = new ArrayList<>();
        if (getChessColor().equals(ChessColor.BLACK)&getSource().getX()==1){
            w.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
            w.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()));
            if (getSource().getY()+1<=7) {
                if (chessboard[getSource().getX() + 1][getSource().getY() + 1].getChessColor().equals(ChessColor.WHITE)) {
                    w.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                }}
            if (getSource().getY() - 1>=0){
                if (chessboard[getSource().getX() + 1][getSource().getY() - 1].getChessColor().equals(ChessColor.WHITE)) {
                    w.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                }}
        }
        else if (getChessColor().equals(ChessColor.WHITE)&getSource().getX()==6) {
            w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
            w.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY()));
            if (getSource().getY()+1<=7) {
                if (chessboard[getSource().getX() - 1][getSource().getY() + 1].getChessColor().equals(ChessColor.BLACK)) {
                    w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                }}
            if (getSource().getY() - 1>=0){
                if (chessboard[getSource().getX() - 1][getSource().getY() - 1].getChessColor().equals(ChessColor.BLACK)) {
                    w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                }}
        }
        else {
            if (getChessColor().equals(ChessColor.BLACK)&getSource().getX()<=6){
                if (chessboard[getSource().getX()+1][getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    w.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
                }
                if (getSource().getY()+1<=7) {
                    if (chessboard[getSource().getX() + 1][getSource().getY() + 1].getChessColor().equals(ChessColor.WHITE)) {
                        w.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }}
                if (getSource().getY() - 1>=0){
                    if (chessboard[getSource().getX() + 1][getSource().getY() - 1].getChessColor().equals(ChessColor.WHITE)) {
                        w.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }}
            }
            else if (getChessColor().equals(ChessColor.WHITE)&getSource().getX()!=0){
                if (chessboard[getSource().getX()-1][getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    w.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
                }
                if (getSource().getY()+1<=7) {
                    if (chessboard[getSource().getX() - 1][getSource().getY() + 1].getChessColor().equals(ChessColor.BLACK)) {
                        w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }}
                if (getSource().getY() - 1>=0){
                    if (chessboard[getSource().getX() - 1][getSource().getY() - 1].getChessColor().equals(ChessColor.BLACK)) {
                        w.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }}
                }
            }
        w.sort(new SortByXY());
        return w;
    }
}
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint point){
        super.setSource(point);super.setChessColor(ChessColor.NONE);this.name='_';
    }
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
}