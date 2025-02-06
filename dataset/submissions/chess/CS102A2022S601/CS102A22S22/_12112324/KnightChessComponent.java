import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponent;
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor){
        this.source = source;
        this.chessColor = chessColor;
        if(this.chessColor==ChessColor.BLACK){
            name = 'N';
        }else {
            name = 'n';
        }
    }
    @Override
    public void setChessboardPoint(ChessboardPoint chessboardPoint){
        source=chessboardPoint;
    }
    @Override
    public void setChessComponent(ChessComponent[][] chessComponent){
        this.chessComponent = chessComponent;
    }
    @Override
    public ChessComponent[][] getChessComponent(){
        return chessComponent;
    }
    @Override
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list = new ArrayList<>();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(Math.abs(i-source.getX())==1 && Math.abs(j-source.getY())==2 && chessComponent[i][j].getChessColor() != chessColor){
                    list.add(new ChessboardPoint(i,j));
                }else if(Math.abs(i-source.getX())==2 && Math.abs(j-source.getY())==1 && chessComponent[i][j].getChessColor() != chessColor){
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }
        return list;
    }
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
    
}