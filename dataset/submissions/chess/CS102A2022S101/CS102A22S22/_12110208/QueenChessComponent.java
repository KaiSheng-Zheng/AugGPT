import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        for(int i = 1;i<8;i++){
            if(getSource().offset(i,i) != null&&
                    !getChessComponents(getSource().getX()+i,getSource().getY()+i).getChessColor()
                            .equals(getChessColor())){
                if(!getChessComponents(getSource().getX()+i,getSource().getY()+i).getChessColor().equals(ChessColor.NONE)){
                    list.add(getSource().offset(i,i));break;}
                else{list.add(getSource().offset(i,i));}}
            else break;
        }
        for(int i = 1;i<8;i++){
            if(getSource().offset(i,-i) != null&&
                    !getChessComponents(getSource().getX()+i,getSource().getY()-i).getChessColor()
                            .equals(getChessColor())) {
                if(!getChessComponents(getSource().getX()+i,getSource().getY()-i).getChessColor()
                        .equals(ChessColor.NONE)){
                    list.add(getSource().offset(i,-i));break;}
                else {list.add(getSource().offset(i,-i));}}
            else break;
        }
        for(int i = 1;i<8;i++){
            if(getSource().offset(-i,i) != null&&
                    !getChessComponents(getSource().getX()-i,getSource().getY()+i).getChessColor()
                            .equals(getChessColor())){
                if(!getChessComponents(getSource().getX()-i,getSource().getY()+i).getChessColor()
                        .equals(ChessColor.NONE)){
                    list.add(getSource().offset(-i,i));break;}
                else{list.add(getSource().offset(-i,i));}}
            else break;
        }
        for(int i = 1;i<8;i++){
            if(getSource().offset(-i,-i) != null&&
                    !getChessComponents(getSource().getX()-i,getSource().getY()-i).getChessColor()
                            .equals(getChessColor())){
                if(!getChessComponents(getSource().getX()-i,getSource().getY()-i).getChessColor()
                        .equals(ChessColor.NONE)){
                    list.add(getSource().offset(-i,-i));break;}
                else{list.add(getSource().offset(-i,-i));}}
            else break;
        }
        for(int i = 1;i<8;i++) {
            if (getSource().offset(i, 0) != null
                    &&!getChessComponents(getSource().getX()+i,getSource().getY()).getChessColor().equals(getChessColor())) {
                if(!getChessComponents(getSource().getX()+i,getSource().getY()).getChessColor().equals(ChessColor.NONE)){
                    list.add(getSource().offset(i, 0));break;}
                else{list.add(getSource().offset(i, 0));}
            } else {
                break;
            }
        }
        for(int i = 1;i<8;i++){
            if(getSource().offset(-i,0)  != null
                    &&!getChessComponents(getSource().getX()-i,getSource().getY()).getChessColor().equals(getChessColor())){
                if(!getChessComponents(getSource().getX()-i,getSource().getY()).getChessColor().equals(ChessColor.NONE)){
                    list.add(getSource().offset(-i, 0));break;}
                else{list.add(getSource().offset(-i, 0));}
            }else{
                break;
            }
        }
        for(int i = 1;i<8;i++){
            if(getSource().offset(0, i) != null
                    &&!getChessComponents(getSource().getX(),getSource().getY()+i).getChessColor().equals(getChessColor())){
                if(!getChessComponents(getSource().getX(),getSource().getY()+i).getChessColor().equals(ChessColor.NONE)){
                    list.add(getSource().offset(0, i));break;}
                else{list.add(getSource().offset(0, i));}
            }else{
                break;
            }
        }
        for(int i = 1;i<8;i++){
            if(getSource().offset(0, -i) != null
                    &&!getChessComponents(getSource().getX(),getSource().getY()-i).getChessColor().equals(getChessColor())){
                if(!getChessComponents(getSource().getX(),getSource().getY()-i).getChessColor().equals(ChessColor.NONE)){
                    list.add(getSource().offset(0, -i));break;}
                else{list.add(getSource().offset(0, -i));}
            }else{
                break;
            }
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
