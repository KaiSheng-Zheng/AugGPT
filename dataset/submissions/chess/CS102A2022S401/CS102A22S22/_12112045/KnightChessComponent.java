import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private final ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] components) {
        this.source = source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=components;
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> cbp=new ArrayList<>();
        if(source.offset(2,1)!=null){
            if(chessComponents[source.getX()+2][source.getY()+1].getName()=='_'||chessComponents[source.getX()+2][source.getY()+1].getChessColor()!=this.chessColor)
                cbp.add(source.offset(2,1));
        }
        if(source.offset(-2,1)!=null){
            if(chessComponents[source.getX()-2][source.getY()+1].getName()=='_'||chessComponents[source.getX()-2][source.getY()+1].getChessColor()!=this.chessColor)
                cbp.add(source.offset(-2,1));
        }
        if(source.offset(2,-1)!=null){
            if(chessComponents[source.getX()+2][source.getY()-1].getName()=='_'||chessComponents[source.getX()+2][source.getY()-1].getChessColor()!=this.chessColor)
                cbp.add(source.offset(2,-1));
            
        }
        if(source.offset(-2,-1)!=null){
            if(chessComponents[source.getX()-2][source.getY()-1].getName()=='_'&&chessComponents[source.getX()-2][source.getY()-1].getChessColor()!=this.chessColor)
                cbp.add(source.offset(-2,-1));
        }
        if(source.offset(1,2)!=null){
            if(chessComponents[source.getX()+1][source.getY()+2].getName()=='_' || chessComponents[source.getX()+1][source.getY()+2].getChessColor()!=this.chessColor)
                cbp.add(source.offset(1,2));
        }
        if(source.offset(1,-2)!=null){
            if(chessComponents[source.getX()+1][source.getY()-2].getName()=='_'||chessComponents[source.getX()+1][source.getY()-2].getChessColor()!=this.chessColor)
                cbp.add(source.offset(1,-2));
        }
        if(source.offset(-1,2)!=null){
            if(chessComponents[source.getX()-1][source.getY()+2].getName()=='_'||chessComponents[source.getX()-1][source.getY()+2].getChessColor()!=this.chessColor)
                cbp.add(source.offset(-1,2));
        }
        if(source.offset(-1,-2)!=null){
            if(chessComponents[source.getX()-1][source.getY()-2].getName()=='_'||chessComponents[source.getX()-1][source.getY()-2].getChessColor()!=this.chessColor)
                cbp.add(source.offset(-1,-2));
        }
        return cbp;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public char getName() {
        return name;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setName(){
        if(chessColor.equals(ChessColor.BLACK))
            this.name='N';
        else if(chessColor.equals(ChessColor.WHITE))
            this.name='n';
        else
            this.name='_';
    }

}
