import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private final ChessComponent[][] chessComponents;


    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] components) {
        this.source = source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=components;
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> cbp=new ArrayList<>();
        if(this.chessColor==ChessColor.BLACK){
            if(this.source.getX()==1){
                ChessboardPoint move=new ChessboardPoint(2,this.source.getY());
                ChessboardPoint move2=new ChessboardPoint(3,this.source.getY());
                if(chessComponents[2][move.getY()].getName()=='_'){
                    cbp.add(move);
                    if(chessComponents[3][move2.getY()].getName()=='_')
                        cbp.add(move2);
                }
                if(source.offset(1,1)!=null)
                    if(chessComponents[source.getX()+1][source.getY()+1].getName()!='_'&&chessComponents[source.getX()+1][source.getY()+1].getChessColor()!=ChessColor.BLACK){
                        cbp.add(source.offset(1,1));
                    }

                if(source.offset(1,-1)!=null)
                    if(chessComponents[source.getX()+1][source.getY()-1].getName()!='_'&&chessComponents[source.getX()+1][source.getY()-1].getChessColor()!=ChessColor.BLACK){
                        cbp.add(source.offset(1,-1));
                    }
            }
            else{
                if(source.offset(1,1)!=null)
                    if(chessComponents[source.getX()+1][source.getY()+1].getName()!='_'&&chessComponents[source.getX()+1][source.getY()+1].getChessColor()!=ChessColor.BLACK){
                        cbp.add(source.offset(1,1));
                    }
                if(source.offset(1,-1)!=null)
                    if(chessComponents[source.getX()+1][source.getY()-1].getName()!='_'&&chessComponents[source.getX()+1][source.getY()-1].getChessColor()!=ChessColor.BLACK){
                        cbp.add(source.offset(1,-1));
                    }
                ChessboardPoint move=new ChessboardPoint(this.source.getX()+1,this.source.getY());
                if(chessComponents[move.getX()][move.getY()].getName()=='_'){
                    cbp.add(move);
                }
            }
        }
        else if(this.chessColor==ChessColor.WHITE){
            if(this.source.getX()==6){
                ChessboardPoint move=new ChessboardPoint(4,this.source.getY());
                ChessboardPoint move2=new ChessboardPoint(5,this.source.getY());
                if(chessComponents[5][move.getY()].getName()=='_'){
                    cbp.add(move2);
                    if(chessComponents[4][move.getY()].getName()=='_')
                        cbp.add(move);
                }
                if(source.offset(-1,1)!=null)
                    if(chessComponents[source.getX()-1][source.getY()+1].getName()!='_'&&chessComponents[source.getX()-1][source.getY()+1].getChessColor()==ChessColor.BLACK){
                        cbp.add(source.offset(-1,1));
                    }
                if(source.offset(-1,-1)!=null)
                    if(chessComponents[source.getX()-1][source.getY()-1].getName()!='_'&&chessComponents[source.getX()-1][source.getY()-1].getChessColor()==ChessColor.BLACK){
                        cbp.add(source.offset(-1,-1));
                    }
            }
            else{
                if(source.offset(-1,1)!=null)
                    if(chessComponents[source.getX()-1][source.getY()+1].getName()!='_'&&chessComponents[source.getX()-1][source.getY()+1].getChessColor()!=ChessColor.WHITE){
                        cbp.add(source.offset(-1,1));
                    }
                if(source.offset(-1,-1)!=null)
                    if(chessComponents[source.getX()-1][source.getY()-1].getName()!='_'&&chessComponents[source.getX()-1][source.getY()-1].getChessColor()!=ChessColor.WHITE){
                        cbp.add(source.offset(-1,-1));
                    }
                ChessboardPoint move=new ChessboardPoint(this.source.getX()-1,this.source.getY());
                if(chessComponents[move.getX()][move.getY()].getName()=='_'){
                    cbp.add(move);
                }
            }
        }
        return cbp;
    }

    public char getName() {
        return name;
    }

    public void setName(){
        if(chessColor.equals(ChessColor.BLACK))
            this.name='P';
        else if(chessColor.equals(ChessColor.WHITE))
            this.name='p';
        else
            this.name='_';
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
