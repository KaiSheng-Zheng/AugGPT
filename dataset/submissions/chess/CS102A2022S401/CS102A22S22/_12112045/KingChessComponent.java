import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private final ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] components) {
        this.source = source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=components;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> cbp=new ArrayList<>();
        if(source.offset(1,-1)!=null){
            if(chessComponents[source.getX()+1][source.getY()-1].getName()=='_')
                cbp.add(source.offset(1,-1));
            else{
                if(chessComponents[source.getX()+1][source.getY()-1].getChessColor()!=this.chessColor)
                    cbp.add(source.offset(1,-1));
            }
        }
        if(source.offset(1,1)!=null){
            if(chessComponents[source.getX()+1][source.getY()+1].getName()=='_')
                cbp.add(source.offset(1,1));
            else{
                if(chessComponents[source.getX()+1][source.getY()+1].getChessColor()!=this.chessColor)
                    cbp.add(source.offset(1,1));
            }
        }
        if(source.offset(-1,1)!=null){
            if(chessComponents[source.getX()-1][source.getY()+1].getName()=='_')
                cbp.add(source.offset(-1,1));
            else{
                if(chessComponents[source.getX()-1][source.getY()+1].getChessColor()!=this.chessColor)
                    cbp.add(source.offset(-1,1));
            }
        }
        if(source.offset(-1,-1)!=null){
            if(chessComponents[source.getX()-1][source.getY()-1].getName()=='_')
                cbp.add(source.offset(-1,-1));
            else{
                if(chessComponents[source.getX()-1][source.getY()-1].getChessColor()!=this.chessColor)
                    cbp.add(source.offset(-1,-1));
            }
        }
        if(source.offset(0,1)!=null){
            if(chessComponents[source.getX()][source.getY()+1].getName()=='_')
                cbp.add(source.offset(0,1));
            else{
                if(chessComponents[source.getX()][source.getY()+1].getChessColor()!=this.chessColor)
                    cbp.add(source.offset(0,1));
            }
        }
        if(source.offset(0,-1)!=null){
            if(chessComponents[source.getX()][source.getY()-1].getName()=='_')
                cbp.add(source.offset(0,-1));
            else{
                if(chessComponents[source.getX()][source.getY()-1].getChessColor()!=this.chessColor)
                    cbp.add(source.offset(0,-1));
            }
        }
        if(source.offset(1,0)!=null){
            if(chessComponents[source.getX()+1][source.getY()].getName()=='_')
                cbp.add(source.offset(1,0));
            else{
                if(chessComponents[source.getX()+1][source.getY()].getChessColor()!=this.chessColor)
                    cbp.add(source.offset(1,0));
            }
        }
        if(source.offset(-1,0)!=null){
            if(chessComponents[source.getX()-1][source.getY()].getName()=='_')
                cbp.add(source.offset(-1,0));
            else{
                if(chessComponents[source.getX()-1][source.getY()].getChessColor()!=this.chessColor)
                    cbp.add(source.offset(-1,0));
            }
        }
        return cbp;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    @Override
    public char getName() {
        return name;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setName(){
        if(chessColor.equals(ChessColor.BLACK))
            this.name='K';
        else if(chessColor.equals(ChessColor.WHITE))
            this.name='k';
        else
            this.name='_';
    }
}
