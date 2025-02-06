import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        if(getSource().offset(2,1)!=null
                &&!getChessComponents(getSource().getX()+2,getSource().getY()+1).getChessColor().equals(getChessColor())){
            list.add(getSource().offset(2,1));
        }
        if(getSource().offset(2,-1)!=null
                &&!getChessComponents(getSource().getX()+2,getSource().getY()-1).getChessColor().equals(getChessColor())){
            list.add(getSource().offset(2,-1));
        }
        if(getSource().offset(-2,1)!=null
                &&!getChessComponents(getSource().getX()-2,getSource().getY()+1).getChessColor().equals(getChessColor())){
            list.add(getSource().offset(-2,1));
        }
        if(getSource().offset(-2,-1)!=null
                &&!getChessComponents(getSource().getX()-2,getSource().getY()-1).getChessColor().equals(getChessColor())){
            list.add(getSource().offset(-2,-1));
        }
        if(getSource().offset(1,2)!=null
                &&!getChessComponents(getSource().getX()+1,getSource().getY()+2).getChessColor().equals(getChessColor())){
            list.add(getSource().offset(1,2));
        }
        if(getSource().offset(1,-2)!=null
                &&!getChessComponents(getSource().getX()+1,getSource().getY()-2).getChessColor().equals(getChessColor())){
            list.add(getSource().offset(1,-2));
        }
        if(getSource().offset(-1,2)!=null
                &&!getChessComponents(getSource().getX()-1,getSource().getY()+2).getChessColor().equals(getChessColor())){
            list.add(getSource().offset(-1,2));
        }
        if(getSource().offset(-1,-2)!=null
                &&!getChessComponents(getSource().getX()-1,getSource().getY()-2).getChessColor().equals(getChessColor())){
            list.add(getSource().offset(-1,-2));
        }
        if(list.size()!=0){
            return list;
        }else{
            return new ArrayList<>();
        }
    }
    public String toString() {
        return String.valueOf(getName());
    }
}
