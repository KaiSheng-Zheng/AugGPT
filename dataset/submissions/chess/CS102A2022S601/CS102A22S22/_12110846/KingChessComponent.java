import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
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

        ChessboardPoint a1 = new ChessboardPoint(x+1,y);
        ChessboardPoint a2 = new ChessboardPoint(x+1,y+1);
        ChessboardPoint a3 = new ChessboardPoint(x+1,y-1);
        ChessboardPoint a4 = new ChessboardPoint(x,y+1);
        ChessboardPoint a5 = new ChessboardPoint(x,y-1);
        ChessboardPoint a6 = new ChessboardPoint(x-1,y);
        ChessboardPoint a7 = new ChessboardPoint(x-1,y+1);
        ChessboardPoint a8 = new ChessboardPoint(x-1,y-1);
        result.add(a1);
        result.add(a2);
        result.add(a3);
        result.add(a4);
        result.add(a5);
        result.add(a6);
        result.add(a7);
        result.add(a8);

        if( name == 'K' ){
            if( x+1 > 7 || (chessComponents[x+1][y].name > 64 && chessComponents[x+1][y].name < 91) ){
                result.remove(a1);
            }
            if( x+1 > 7 || y+1 > 7 || (chessComponents[x+1][y+1].name > 64 && chessComponents[x+1][y+1].name < 91) ){
                result.remove(a2);
            }
            if( x+1 > 7 || y-1 < 0 || (chessComponents[x+1][y-1].name > 64 && chessComponents[x+1][y-1].name < 91) ){
                result.remove(a3);
            }
            if( y+1 > 7 || (chessComponents[x][y+1].name > 64 && chessComponents[x][y+1].name < 91) ){
                result.remove(a4);
            }
            if( y-1 < 0 || (chessComponents[x][y-1].name > 64 && chessComponents[x][y-1].name < 91) ){
                result.remove(a5);
            }
            if( x-1 < 0 || (chessComponents[x-1][y].name > 64 && chessComponents[x-1][y].name < 91) ){
                result.remove(a6);
            }
            if( x-1 < 0 || y+1 > 7 || (chessComponents[x-1][y+1].name > 64 && chessComponents[x-1][y+1].name < 91) ){
                result.remove(a7);
            }
            if( x-1 < 0 || y-1 < 0 || (chessComponents[x-1][y-1].name > 64 && chessComponents[x-1][y-1].name < 91) ){
                result.remove(a8);
            }
        }
        else{
            if( x+1 > 7 || chessComponents[x+1][y].name > 97 ){
                result.remove(a1);
            }
            if( x+1 > 7 || y+1 > 7 || chessComponents[x+1][y+1].name > 97 ){
                result.remove(a2);
            }
            if( x+1 > 7 || y-1 < 0 || chessComponents[x+1][y-1].name > 97 ){
                result.remove(a3);
            }
            if( y+1 > 7 || chessComponents[x][y+1].name > 97 ){
                result.remove(a4);
            }
            if( y-1 < 0 || chessComponents[x][y-1].name > 97 ){
                result.remove(a5);
            }
            if( x-1 < 0 || chessComponents[x-1][y].name > 97 ){
                result.remove(a6);
            }
            if( x-1 < 0 || y+1 > 7 || chessComponents[x-1][y+1].name > 97 ){
                result.remove(a7);
            }
            if( x-1 < 0 || y-1 < 0 || chessComponents[x-1][y-1].name > 97 ){
                result.remove(a8);
            }

        }

        return result;
    }
}
