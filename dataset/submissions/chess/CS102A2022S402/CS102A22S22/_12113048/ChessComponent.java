import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent{
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public ChessComponent(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }
//should design


    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        if (getSource().getY()+1 < 8){
        if (chessboard[getSource().getX()][getSource().getY()+1].getChessColor() != getChessColor())
        list.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));}
        if (getSource().getX()-1 >= 0){
        if (chessboard[getSource().getX()-1][getSource().getY()].getChessColor() != getChessColor())
        list.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));}
        if (getSource().getY()-1 >= 0){
        if (chessboard[getSource().getX()][getSource().getY()-1].getChessColor() != getChessColor())
        list.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));}
        if (getSource().getX()+1 < 8){
        if (chessboard[getSource().getX()+1][getSource().getY()].getChessColor() != getChessColor())
        list.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));}
        if (getSource().getY()+1 < 8 && getSource().getX()+1 < 8){
        if (chessboard[getSource().getX()+1][getSource().getY()+1].getChessColor() != getChessColor())
        list.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));}
        if (getSource().getY()+1 < 8 && getSource().getX()-1 >=0){
        if (chessboard[getSource().getX()-1][getSource().getY()+1].getChessColor() != getChessColor())
        list.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));}
        if (getSource().getY()-1 >=0 && getSource().getX()-1 >=0){
        if (chessboard[getSource().getX()-1][getSource().getY()-1].getChessColor() != getChessColor())
        list.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));}
        if (getSource().getY()-1 >=0 && getSource().getX()+1 <8){
        if (chessboard[getSource().getX()+1][getSource().getY()-1].getChessColor() != getChessColor())
        list.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));}
        return list;
    }
}

class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = getSource().getX()+1; i < 8; i++){
                if (chessboard[i][getSource().getY()].getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint(i, getSource().getY()));
                }
                else if (chessboard[i][getSource().getY()].getChessColor() !=getChessColor()){
                    list.add(new ChessboardPoint(i, getSource().getY()));
                    break;
                }
                else break;
        }
        for (int i = getSource().getX()-1; i >=0; i--){
            if (chessboard[i][getSource().getY()].getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint(i, getSource().getY()));
            }
            else if (chessboard[i][getSource().getY()].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(i, getSource().getY()));
                break;
            }
            else break;
        }
        for (int i = getSource().getY() +1; i < 8; i++){
                if (chessboard[getSource().getX()][i].getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint(getSource().getX(),i));}
                else if (chessboard[getSource().getX()][i].getChessColor() !=getChessColor()){
                    list.add(new ChessboardPoint(getSource().getX(),i));
                    break;
                }
                else break;
        }
        for (int i = getSource().getY() -1; i >=0; i--){
            if (chessboard[getSource().getX()][i].getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint(getSource().getX(),i));
            }
            else if (chessboard[getSource().getX()][i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX(),i));
                break;
            }
            else break;
        }
        int i;
        i = 1;
        while (getSource().getX() +i < 8 && getSource().getY() +i<8){
            if (chessboard[getSource().getX()+i][getSource().getY() +i].getChessColor() ==ChessColor.NONE)
                list.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i));
            else if (chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
                break;
            }
            else break;
            i++;
        }

        i = 1;
        while (getSource().getX() -i >=0 && getSource().getY() +i<8){
            if (chessboard[getSource().getX()-i][getSource().getY() +i].getChessColor() ==ChessColor.NONE)
                list.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()+i));
            else if (chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
                break;
            }
            else break;
            i++;
        }
        i = 1;
        while (getSource().getX() +i < 8 && getSource().getY() -i>=0){
            if (chessboard[getSource().getX()+i][getSource().getY() -i].getChessColor() ==ChessColor.NONE)
                list.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()-i));
            else if (chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));
                break;
            }
            else break;
            i++;
        }
        i = 1;
        while (getSource().getX() -i>=0 && getSource().getY() -i>=0){
            if (chessboard[getSource().getX()-i][getSource().getY() -i].getChessColor() ==ChessColor.NONE)
                list.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()-i));
            else if (chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
                break;
            }
            else break;
            i++;
        }
        return list;
    }
}
class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = getSource().getX()+1; i < 8; i++){
            if (chessboard[i][getSource().getY()].getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint(i, getSource().getY()));
            }
            else if (chessboard[i][getSource().getY()].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(i, getSource().getY()));
                break;
            }
            else break;
        }
        for (int i = getSource().getX()-1; i >=0; i--){
            if (chessboard[i][getSource().getY()].getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint(i, getSource().getY()));
            }
            else if (chessboard[i][getSource().getY()].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(i, getSource().getY()));
                break;
            }
            else break;
        }
        for (int i = getSource().getY() +1; i < 8; i++){
            if (chessboard[getSource().getX()][i].getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint(getSource().getX(),i));}
            else if (chessboard[getSource().getX()][i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX(),i));
                break;
            }
            else break;
        }
        for (int i = getSource().getY() -1; i >=0; i--){
            if (chessboard[getSource().getX()][i].getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint(getSource().getX(),i));
            }
            else if (chessboard[getSource().getX()][i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX(),i));
                break;
            }
            else break;
        }
        return list;
    }
}

class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int i;
        i = 1;
        while (getSource().getX() +i < 8 && getSource().getY() +i<8){
            if (chessboard[getSource().getX()+i][getSource().getY() +i].getChessColor() ==ChessColor.NONE)
                list.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i));
            else if (chessboard[getSource().getX()+i][getSource().getY()+i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
                break;
            }
            else break;
            i++;
        }

        i = 1;
        while (getSource().getX() -i >=0 && getSource().getY() +i<8){
            if (chessboard[getSource().getX()-i][getSource().getY() +i].getChessColor() ==ChessColor.NONE)
                list.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()+i));
            else if (chessboard[getSource().getX()-i][getSource().getY()+i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
                break;
            }
            else break;
            i++;
        }
        i = 1;
        while (getSource().getX() +i < 8 && getSource().getY() -i>=0){
            if (chessboard[getSource().getX()+i][getSource().getY() -i].getChessColor() ==ChessColor.NONE)
                list.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()-i));
            else if (chessboard[getSource().getX()+i][getSource().getY()-i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()-i));
                break;
            }
            else break;
            i++;
        }
        i = 1;
        while (getSource().getX() -i>=0 && getSource().getY() -i>=0){
            if (chessboard[getSource().getX()-i][getSource().getY() -i].getChessColor() ==ChessColor.NONE)
                list.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()-i));
            else if (chessboard[getSource().getX()-i][getSource().getY()-i].getChessColor() !=getChessColor()){
                list.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
                break;
            }
            else break;
            i++;
        }
        return list;
    }
}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        if (getSource().getX() +1 <8 && getSource().getY() +2 < 8)
        if (chessboard[getSource().getX()+1][getSource().getY()+2].getChessColor() != getChessColor())
            list.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+2));
        if (getSource().getX() +1 <8 && getSource().getY() -2 >=0)
        if (chessboard[getSource().getX()+1][getSource().getY()-2].getChessColor() != getChessColor())
            list.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-2));
        if (getSource().getX() -1 >=0 && getSource().getY() +2 < 8)
        if (chessboard[getSource().getX()-1][getSource().getY()+2].getChessColor() != getChessColor())
            list.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+2));
        if (getSource().getX() -1 >=0 && getSource().getY() -2 >=0)
        if (chessboard[getSource().getX()-1][getSource().getY()-2].getChessColor() != getChessColor())
            list.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-2));
        if (getSource().getX() +2 <8 && getSource().getY() +1<8)
        if (chessboard[getSource().getX()+2][getSource().getY()+1].getChessColor() != getChessColor())
            list.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()+1));
        if (getSource().getX() +2 <8 && getSource().getY() -1 >=0)
        if (chessboard[getSource().getX()+2][getSource().getY()-1].getChessColor() != getChessColor())
            list.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()-1));
        if (getSource().getY() +1 <8 && getSource().getX() -2 >=0)
        if (chessboard[getSource().getX()-2][getSource().getY()+1].getChessColor() != getChessColor())
            list.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()+1));
        if (getSource().getY() -1 >=0 && getSource().getX() -2 >=0)
        if (chessboard[getSource().getX()-2][getSource().getY()-1].getChessColor() != getChessColor())
            list.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()-1));
        return list;
    }
}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        if (getChessColor() == ChessColor.BLACK){
            if (getSource().getY() +1 <8 && getSource().getX()+1 < 8 &&
                    chessboard[getSource().getX()+1][getSource().getY()+1].getChessColor() == ChessColor.WHITE){
                list.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+1));
            }
            if (getSource().getY() -1 >=0 && getSource().getX()+1 < 8 &&
                    chessboard[getSource().getX()+1][getSource().getY()-1].getChessColor() == ChessColor.WHITE){
                list.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1));
            }
            if (getSource().getX() == 1){
                if (chessboard[getSource().getX()+1][getSource().getY()].getChessColor() == ChessColor.NONE){
                    list.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
                    if (chessboard[getSource().getX()+2][getSource().getY()].getChessColor() != getChessColor())
                        list.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()));
                }
            }
            else {
                if (getSource().getX()+1 < 8 )
                if (chessboard[getSource().getX()+1][getSource().getY()].getChessColor() == ChessColor.NONE)
                    list.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
            }
        }
        if (getChessColor() == ChessColor.WHITE){
            if (getSource().getY() +1 <8 && getSource().getX()-1 >=0 &&
                    chessboard[getSource().getX()-1][getSource().getY()+1].getChessColor() == ChessColor.BLACK){
                list.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+1));
            }
            if (getSource().getX() -1 >=0 && getSource().getY()-1 >=0 &&
                    chessboard[getSource().getX()-1][getSource().getY()-1].getChessColor() == ChessColor.BLACK){
                list.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-1));
            }
            if (getSource().getX() == 6){
                if (chessboard[getSource().getX()-1][getSource().getY()].getChessColor() == ChessColor.NONE){
                    list.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
                    if (chessboard[getSource().getX()-2][getSource().getY()].getChessColor() != getChessColor())
                        list.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()));
                }
            }
            else {
                if (getSource().getX() -1 >= 0 )
                if (chessboard[getSource().getX()-1][getSource().getY()].getChessColor() == ChessColor.NONE)
                    list.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
            }
        }
        return list;
    }
}
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    public EmptySlotComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
