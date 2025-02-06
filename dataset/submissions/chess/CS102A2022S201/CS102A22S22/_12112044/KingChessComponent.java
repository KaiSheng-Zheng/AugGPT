import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    protected char name;
    private ChessboardPoint source;
    private List<ChessboardPoint> location = new ArrayList<>();

    public List<ChessboardPoint> canMoveTo(){;

        int i = source.getX();
        int j = source.getY();

        if(i+1<=7&&j+1<=7&&(this.chessColor != chessComponents[i+1][j+1].getChessColor()||chessComponents[i+1][j+1].getName() == '_')){
            ChessboardPoint destination = new ChessboardPoint(i+1,j+1);
            location.add(destination);
        }

        if(i+1<=7&&j<=7&&(this.chessColor != chessComponents[i+1][j].getChessColor()||chessComponents[i+1][j].getName() == '_')){
            ChessboardPoint destination = new ChessboardPoint(i+1,j);
            location.add(destination);
        }

        if(i+1<=7&&j-1>=0&&(this.chessColor != chessComponents[i+1][j-1].getChessColor()||chessComponents[i+1][j-1].getName() == '_')){
            ChessboardPoint destination = new ChessboardPoint(i+1,j-1);
            location.add(destination);
        }

        if(i<=7&&j+1<=7&&(this.chessColor != chessComponents[i][j+1].getChessColor()||chessComponents[i][j+1].getName() == '_')){
            ChessboardPoint destination = new ChessboardPoint(i,j+1);
            location.add(destination);
        }

        if(i<=7&&j-1>=0&&(this.chessColor != chessComponents[i][j-1].getChessColor()||chessComponents[i][j-1].getName() == '_')){
            ChessboardPoint destination = new ChessboardPoint(i,j-1);
            location.add(destination);
        }

        if(i-1>=0&&j+1<=7&&(this.chessColor != chessComponents[i-1][j+1].getChessColor()||chessComponents[i-1][j+1].getName() == '_')){
            ChessboardPoint destination = new ChessboardPoint(i-1,j+1);
            location.add(destination);
        }

        if(i-1>=0&&j<=7&&(this.chessColor != chessComponents[i-1][j].getChessColor()||chessComponents[i-1][j].getName() == '_')){
            ChessboardPoint destination = new ChessboardPoint(i-1,j);
            location.add(destination);
        }

        if(i-1>=0&&j-1>=0&&(this.chessColor != chessComponents[i-1][j-1].getChessColor()||chessComponents[i-1][j-1].getName() == '_')){
            ChessboardPoint destination = new ChessboardPoint(i-1,j-1);
            location.add(destination);
        }

        return location;
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor,char name,ChessComponent[][] chessComponents){
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
