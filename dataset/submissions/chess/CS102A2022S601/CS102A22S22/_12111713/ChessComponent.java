import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private int id;

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public ChessboardPoint getSource() {
        return source;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public void setName(char name) {
        this.name = name;
    }
    public char getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
//////////////////////////////////////////////////////KING///////////////////////////////////////////////////////////
class KingChessComponent extends ChessComponent{
    public KingChessComponent(int x, int y, boolean color){
        setId(color?1:7);
        setName(color?'k':'K');
        setChessColor(color?ChessColor.WHITE:ChessColor.BLACK);
        setSource(new ChessboardPoint(x,y));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (x > 0 && y > 0) if (!LocalData.getChess(x - 1,y - 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x - 1,y - 1));
        if (x > 0) if (!LocalData.getChess(x - 1,y).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x - 1, y));
        if (x > 0 && y < 7) if (!LocalData.getChess(x - 1,y + 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x - 1,y + 1));
        if (y > 0) if (!LocalData.getChess(x,y - 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x, y - 1));
        if (y < 7) if (!LocalData.getChess(x,y + 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x, y + 1));
        if (x < 7 && y > 0) if (!LocalData.getChess(x + 1,y - 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x + 1,y - 1));
        if (x < 7) if (!LocalData.getChess(x + 1,y).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x + 1, y));
        if (x < 7 && y < 7) if (!LocalData.getChess(x + 1,y + 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x + 1,y + 1));
        return ans;
    }
}
//////////////////////////////////////////////////////QUEEN///////////////////////////////////////////////////////////
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(int x, int y, boolean color){
        setId(color?2:8);
        setName(color?'q':'Q');
        setChessColor(color?ChessColor.WHITE:ChessColor.BLACK);
        setSource(new ChessboardPoint(x,y));
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        int i; int j; boolean block;
        i = x - 1; block = true;
        while (i >= 0 && block){
            if (!LocalData.getChess(i,y).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,y).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,y));
            i--;
        }
        i = x + 1; block = true;
        while (i <= 7 && block){
            if (!LocalData.getChess(i,y).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,y).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,y));
            i++;
        }
        j = y - 1; block = true;
        while (j >= 0 && block){
            if (!LocalData.getChess(x,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(x,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x,j));
            j--;
        }
        j = y + 1; block = true;
        while (j <= 7 && block){
            if (!LocalData.getChess(x,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(x,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x,j));
            j++;
        }
        i = x - 1; j = y - 1; block = true;
        while (i >= 0 && j >= 0 && block){
            if (!LocalData.getChess(i,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,j));
            i--;j--;
        }
        i = x + 1; j = y - 1; block = true;
        while (i <= 7 && j >= 0 && block){
            if (!LocalData.getChess(i,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,j));
            i++;j--;
        }
        i = x - 1; j = y + 1; block = true;
        while (i >= 0 && j <= 7 && block){
            if (!LocalData.getChess(i,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,j));
            i--;j++;
        }
        i = x + 1; j = y + 1; block = true;
        while (i <= 7 && j <= 7 && block){
            if (!LocalData.getChess(i,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,j));
            i++;j++;
        }
        return ans;
    }
}
//////////////////////////////////////////////////////ROOK///////////////////////////////////////////////////////////
class RookChessComponent extends ChessComponent{
    public RookChessComponent(int x, int y, boolean color){
        setId(color?3:9);
        setName(color?'r':'R');
        setChessColor(color?ChessColor.WHITE:ChessColor.BLACK);
        setSource(new ChessboardPoint(x,y));
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        int i; int j; boolean block;
        i = x - 1; block = true;
        while (i >= 0 && block){
            if (!LocalData.getChess(i,y).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,y).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,y));
            i--;
        }
        i = x + 1; block = true;
        while (i <= 7 && block){
            if (!LocalData.getChess(i,y).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,y).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,y));
            i++;
        }
        j = y - 1; block = true;
        while (j >= 0 && block){
            if (!LocalData.getChess(x,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(x,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x,j));
            j--;
        }
        j = y + 1; block = true;
        while (j <= 7 && block){
            if (!LocalData.getChess(x,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(x,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x,j));
            j++;
        }
        return ans;
    }
}
/////////////////////////////////////////////////////BISHOP//////////////////////////////////////////////////////////
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(int x, int y, boolean color){
        setId(color?4:10);
        setName(color?'b':'B');
        setChessColor(color?ChessColor.WHITE:ChessColor.BLACK);
        setSource(new ChessboardPoint(x,y));
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        int i; int j; boolean block;
        i = x - 1; j = y - 1; block = true;
        while (i >= 0 && j >= 0 && block){
            if (!LocalData.getChess(i,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,j));
            i--;j--;
        }
        i = x + 1; j = y - 1; block = true;
        while (i <= 7 && j >= 0 && block){
            if (!LocalData.getChess(i,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,j));
            i++;j--;
        }
        i = x - 1; j = y + 1; block = true;
        while (i >= 0 && j <= 7 && block){
            if (!LocalData.getChess(i,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,j));
            i--;j++;
        }
        i = x + 1; j = y + 1; block = true;
        while (i <= 7 && j <= 7 && block){
            if (!LocalData.getChess(i,j).getChessColor().equals(ChessColor.NONE)) block = false;
            if (!LocalData.getChess(i,j).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(i,j));
            i++;j++;
        }
        return ans;
    }
}
/////////////////////////////////////////////////////KNIGHT//////////////////////////////////////////////////////////
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int x, int y, boolean color){
        setId(color?5:11);
        setName(color?'n':'N');
        setChessColor(color?ChessColor.WHITE:ChessColor.BLACK);
        setSource(new ChessboardPoint(x,y));
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (x > 1 && y > 0) if (!LocalData.getChess(x - 2,y - 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x - 2,y - 1));
        if (x > 0 && y > 1) if (!LocalData.getChess(x - 1,y - 2).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x - 1,y - 2));
        if (x > 1 && y < 7) if (!LocalData.getChess(x - 2,y + 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x - 2,y + 1));
        if (x > 0 && y < 6) if (!LocalData.getChess(x - 1,y + 2).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x - 1,y + 2));
        if (x < 6 && y > 0) if (!LocalData.getChess(x + 2,y - 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x + 2,y - 1));
        if (x < 7 && y > 1) if (!LocalData.getChess(x + 1,y - 2).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x + 1,y - 2));
        if (x < 6 && y < 7) if (!LocalData.getChess(x + 2,y + 1).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x + 2,y + 1));
        if (x < 7 && y < 6) if (!LocalData.getChess(x + 1,y + 2).getChessColor().equals(getChessColor())) ans.add(new ChessboardPoint(x + 1,y + 2));
        return ans;
    }
}
//////////////////////////////////////////////////////PAWN///////////////////////////////////////////////////////////
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(int x, int y, boolean color){
        setId(color?6:12);
        setName(color?'p':'P');
        setChessColor(color?ChessColor.WHITE:ChessColor.BLACK);
        setSource(new ChessboardPoint(x,y));
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();

        if (getChessColor().equals(ChessColor.WHITE)) {
            if (x == 1){
                if (LocalData.getChess(x + 1, y).getChessColor().equals(ChessColor.NONE)){
                    ans.add(new ChessboardPoint(x + 1,y));
                    if (LocalData.getChess(x + 2, y).getChessColor().equals(ChessColor.NONE)) ans.add(new ChessboardPoint(x + 2,y));
                }
            }
            else if (x < 7) if (LocalData.getChess(x + 1, y).getChessColor().equals(ChessColor.NONE)) ans.add(new ChessboardPoint(x + 1,y));
            if (x < 7 && y > 0) if (LocalData.getChess(x + 1, y - 1).getChessColor().equals(ChessColor.BLACK)) ans.add(new ChessboardPoint(x + 1,y - 1));
            if (x < 7 && y < 7) if (LocalData.getChess(x + 1, y + 1).getChessColor().equals(ChessColor.BLACK)) ans.add(new ChessboardPoint(x + 1,y + 1));
        }
        else if (getChessColor().equals(ChessColor.BLACK)){
            if (x == 6){
                if (LocalData.getChess(x - 1, y).getChessColor().equals(ChessColor.NONE)){
                    ans.add(new ChessboardPoint(x - 1,y));
                    if (LocalData.getChess(x - 2, y).getChessColor().equals(ChessColor.NONE)) ans.add(new ChessboardPoint(x - 2,y));
                }
            }
            else if (x > 0) if (LocalData.getChess(x - 1, y).getChessColor().equals(ChessColor.NONE)) ans.add(new ChessboardPoint(x - 1,y));
            if (x > 0 && y > 0) if (LocalData.getChess(x - 1, y - 1).getChessColor().equals(ChessColor.WHITE)) ans.add(new ChessboardPoint(x - 1,y - 1));
            if (x > 0 && y < 7) if (LocalData.getChess(x - 1, y + 1).getChessColor().equals(ChessColor.WHITE)) ans.add(new ChessboardPoint(x - 1,y + 1));
        }
        return ans;
    }
}
//////////////////////////////////////////////////////[   ]///////////////////////////////////////////////////////////
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x, int y){
        setId(0);
        setName('_');
        setChessColor(ChessColor.NONE);
        setSource(new ChessboardPoint(x,y));
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}