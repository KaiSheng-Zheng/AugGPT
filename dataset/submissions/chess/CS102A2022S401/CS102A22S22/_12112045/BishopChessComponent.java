import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private final ChessComponent[][] chessComponents;


    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] components) {
        this.source = source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=components;
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> cbp=new ArrayList<>();
                for(int i=1;i<8;i++){
            if(source.offset(i,i)!=null){
                if(chessComponents[source.getX()+i][source.getY()+i].getName()=='_')
                    cbp.add(source.offset(i,i));
                else{
                    if(chessComponents[source.getX()+i][source.getY()+i].getChessColor()==this.chessColor)
                        break;
                    else{
                        cbp.add(source.offset(i,i));
                        break;
                    }
                }
            }
            else
                break;
        }
        for(int i=-1;i>-8;i--){
            if(source.offset(i,i)!=null){
                if(chessComponents[source.getX()+i][source.getY()+i].getName()=='_')
                    cbp.add(source.offset(i,i));
                else{
                    if(chessComponents[source.getX()+i][source.getY()+i].getChessColor()==this.chessColor)
                        break;
                    else{
                        cbp.add(source.offset(i,i));
                        break;
                    }
                }
            }
            else
                break;
        }
        for(int i=1;i<8;i++){
            if(source.offset(i,-i)!=null){
                if(chessComponents[source.getX()+i][source.getY()-i].getName()=='_')
                    cbp.add(source.offset(i,-i));
                else{
                    if(chessComponents[source.getX()+i][source.getY()-i].getChessColor()==this.chessColor)
                        break;
                    else{
                        cbp.add(source.offset(i,-i));
                        break;
                    }
                }
            }
            else
                break;
        }
        for(int i=-1;i>-8;i--){
            if(source.offset(i,-i)!=null){
                if(chessComponents[source.getX()+i][source.getY()-i].getName()=='_')
                    cbp.add(source.offset(i,-i));
                else{
                    if(chessComponents[source.getX()+i][source.getY()-i].getChessColor()==this.chessColor)
                        break;
                    else{
                        cbp.add(source.offset(i,-i));
                        break;
                    }
                }
            }
            else
                break;
        }
        return cbp;
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
            this.name='B';
        else if(chessColor.equals(ChessColor.WHITE))
            this.name='b';
        else
            this.name='_';
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
