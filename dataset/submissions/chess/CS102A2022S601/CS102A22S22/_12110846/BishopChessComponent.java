import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
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

        if( name == 'B' ){
            int i1 = 1;
            while( x+i1 < 8 && y+i1 < 8 && chessComponents[x+i1][y+i1].name == '_' ){
                result.add(new ChessboardPoint(x+i1,y+i1));
                i1++;
            }
            if( x+i1 < 8 && y+i1 < 8 && chessComponents[x+i1][y+i1].name > 97 ){
                result.add(new ChessboardPoint(x+i1,y+i1));
            }
            int i2 = 1;
            while( x-i2 >= 0 && y-i2 >= 0 && chessComponents[x-i2][y-i2].name == '_' ){
                result.add(new ChessboardPoint(x-i2,y-i2));
                i2++;
            }
            if( x-i2 >= 0 && y-i2 >= 0 && chessComponents[x-i2][y-i2].name > 97 ){
                result.add(new ChessboardPoint(x-i2,y-i2));
            }
            int i3 = 1;
            while( x+i3 < 8 && y-i3 >= 0 && chessComponents[x+i3][y-i3].name == '_' ){
                result.add(new ChessboardPoint(x+i3,y-i3));
                i3++;
            }
            if( x+i3 < 8 && y-i3 >= 0 && chessComponents[x+i3][y-i3].name > 97 ){
                result.add(new ChessboardPoint(x+i3,y-i3));
            }
            int i4 = 1;
            while( x-i4 >= 0 && y+i4 < 8 && chessComponents[x-i4][y+i4].name == '_' ){
                result.add(new ChessboardPoint(x-i4,y+i4));
                i4++;
            }
            if( x-i4 >= 0 && y+i4 < 8 && chessComponents[x-i4][y+i4].name > 97 ){
                result.add(new ChessboardPoint(x-i4,y+i4));
            }
        }
        else {
            int i1 = 1;
            while( x+i1 < 8 && y+i1 < 8 && chessComponents[x+i1][y+i1].name == '_' ){
                result.add(new ChessboardPoint(x+i1,y+i1));
                i1++;
            }
            if( x+i1 < 8 && y+i1 < 8 && chessComponents[x+i1][y+i1].name < 91 ){
                result.add(new ChessboardPoint(x+i1,y+i1));
            }
            int i2 = 1;
            while( x-i2 >= 0 && y-i2 >= 0 && chessComponents[x-i2][y-i2].name == '_' ){
                result.add(new ChessboardPoint(x-i2,y-i2));
                i2++;
            }
            if( x-i2 >= 0 && y-i2 >= 0 && chessComponents[x-i2][y-i2].name < 91 ){
                result.add(new ChessboardPoint(x-i2,y-i2));
            }
            int i3 = 1;
            while( x+i3 < 8 && y-i3 >= 0 && chessComponents[x+i3][y-i3].name == '_' ){
                result.add(new ChessboardPoint(x+i3,y-i3));
                i3++;
            }
            if( x+i3 < 8 && y-i3 >= 0 && chessComponents[x+i3][y-i3].name < 91 ){
                result.add(new ChessboardPoint(x+i3,y-i3));
            }
            int i4 = 1;
            while( x-i4 >= 0 && y+i4 < 8 && chessComponents[x-i4][y+i4].name == '_' ){
                result.add(new ChessboardPoint(x-i4,y+i4));
                i4++;
            }
            if( x-i4 >= 0 && y+i4 < 8 && chessComponents[x-i4][y+i4].name < 91 ){
                result.add(new ChessboardPoint(x-i4,y+i4));
            }
        }

        return result;

    }
}
