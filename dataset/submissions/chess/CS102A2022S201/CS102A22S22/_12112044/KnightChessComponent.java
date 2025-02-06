import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    protected char name;
    private ChessboardPoint source;
    private List<ChessboardPoint> location = new ArrayList<>();

    public List<ChessboardPoint> canMoveTo(){

        int i = source.getX();
        int j = source.getY();


        if(i+1<=7&&j+2<=7&&this.chessColor != chessComponents[i+1][j+2].getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(i+1,j+2);
            location.add(destination);
        }
        if(i+1<=7&&j-2>=0&&this.chessColor != chessComponents[i+1][j-2].getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(i+1,j-2);
            location.add(destination);
        }
        if(i+2<=7&&j+1<=7&&this.chessColor != chessComponents[i+2][j+1].getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(i+2,j+1);
            location.add(destination);
        }
        if(i+2<=7&&j-1>=0&&this.chessColor != chessComponents[i+2][j-1].getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(i+2,j-1);
            location.add(destination);
        }
        if(i-1>=0&&j+2<=7&&this.chessColor != chessComponents[i-1][j+2].getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(i-1,j+2);
            location.add(destination);
        }
        if(i-1>=0&&j-2>=0&&this.chessColor != chessComponents[i-1][j-2].getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(i-1,j-2);
            location.add(destination);
        }
        if(i-2>=0&&j+1<=7&&this.chessColor != chessComponents[i-2][j+1].getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(i-2,j+1);
            location.add(destination);
        }
        if(i-2>=0&&j-1>=0&&this.chessColor != chessComponents[i-2][j-1].getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(i-2,j-1);
            location.add(destination);
        }


        return location;
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        this.chessColor = chessColor;
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
        super.setChessColor(chessColor);
        super.setName(name);
        super.setSource(source);
        super.setChessComponents(chessComponents);
    }

}
