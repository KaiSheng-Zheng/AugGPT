import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
        super(source,chessColor,name,chessComponents);
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();

        int x = source.getX(),
                y = source.getY();

        if( name == 'R' ){
            int i1 = 1;
            while( x+i1 < 8 && chessComponents[x+i1][y].name == '_' ){
                result.add(new ChessboardPoint(x+i1,y));
                i1++;
            }
            if( x+i1 < 8 && chessComponents[x+i1][y].name > 97 ){
                result.add(new ChessboardPoint(x+i1,y));
            }
            int i2 = 1;
            while( x-i2 >= 0 && chessComponents[x-i2][y].name == '_' ){
                result.add(new ChessboardPoint(x-i2,y));
                i2++;
            }
            if( x-i2 >= 0 && chessComponents[x-i2][y].name > 97 ){
                result.add(new ChessboardPoint(x-i2,y));
            }
            int i3 = 1;
            while( y+i3 < 8 && chessComponents[x][y+i3].name == '_' ){
                result.add(new ChessboardPoint(x,y+i3));
                i3++;
            }
            if( y+i3 < 8 && chessComponents[x][y+i3].name > 97 ){
                result.add(new ChessboardPoint(x,y+i3));
            }
            int i4 = 1;
            while( y-i4 >= 0 && chessComponents[x][y-i4].name == '_' ){
                result.add(new ChessboardPoint(x,y-i4));
                i4++;
            }
            if( y-i4 >= 0 && chessComponents[x][y-i4].name > 97 ){
                result.add(new ChessboardPoint(x,y-i4));
            }
        }
        else {
            int i1 = 1;
            while( x+i1 < 8 && chessComponents[x+i1][y].name == '_' ){
                result.add(new ChessboardPoint(x+i1,y));
                i1++;
            }
            if( x+i1 < 8 && chessComponents[x+i1][y].name < 91 ){
                result.add(new ChessboardPoint(x+i1,y));
            }
            int i2 = 1;
            while( x-i2 > 0 && chessComponents[x-i2][y].name == '_' ){
                result.add(new ChessboardPoint(x-i2,y));
                i2++;
            }
            if( x-i2 >= 0 && chessComponents[x-i2][y].name < 91 ){
                result.add(new ChessboardPoint(x-i2,y));
            }
            int i3 = 1;
            while( y+i3 < 8 && chessComponents[x][y+i3].name == '_' ){
                result.add(new ChessboardPoint(x,y+i3));
                i3++;
            }
            if( y+i3 < 8 && chessComponents[x][y+i3].name < 91 ){
                result.add(new ChessboardPoint(x,y+i3));
            }
            int i4 = 1;
            while( y-i4 >= 0 && chessComponents[x][y-i4].name == '_' ){
                result.add(new ChessboardPoint(x,y-i4));
                i4++;
            }
            if( y-i4 >= 0 && chessComponents[x][y-i4].name < 91 ){
                result.add(new ChessboardPoint(x,y-i4));
            }
        }

        return result;
    }
}
