import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
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

        ChessboardPoint a1 = new ChessboardPoint(x+1,y+2);
        ChessboardPoint a2 = new ChessboardPoint(x+1,y-2);
        ChessboardPoint a3 = new ChessboardPoint(x-1,y+2);
        ChessboardPoint a4 = new ChessboardPoint(x-1,y-2);
        ChessboardPoint a5 = new ChessboardPoint(x+2,y+1);
        ChessboardPoint a6 = new ChessboardPoint(x+2,y-1);
        ChessboardPoint a7 = new ChessboardPoint(x-2,y+1);
        ChessboardPoint a8 = new ChessboardPoint(x-2,y-1);
        result.add(a1);
        result.add(a2);
        result.add(a3);
        result.add(a4);
        result.add(a5);
        result.add(a6);
        result.add(a7);
        result.add(a8);

        if( name == 'N' ){
            if( x+1 > 7 || y+2 > 7 || chessComponents[x+1][y+2].name < 91 ){
                result.remove(a1);
            }
            if( x+1 > 7 || y-2 < 0 || chessComponents[x+1][y-2].name < 91 ){
                result.remove(a2);
            }
            if( x-1 < 0 || y+2 >7 || chessComponents[x-1][y+2].name < 91 ){
                result.remove(a3);
            }
            if( x-1 < 0 || y-2 < 0 || chessComponents[x-1][y-2].name < 91 ){
                result.remove(a4);
            }
            if( x+2 > 7 || y+1 > 7 || chessComponents[x+2][y+1].name < 91 ){
                result.remove(a5);
            }
            if( x+2 > 7 || y-1 < 0 || chessComponents[x+2][y-1].name < 91 ){
                result.remove(a6);
            }
            if( x-2 < 0 || y+1 > 7 || chessComponents[x-2][y+1].name < 91 ){
                result.remove(a7);
            }
            if( x-1 < 0 || y-1 < 0 || chessComponents[x-2][y-1].name < 91 ){
                result.remove(a8);
            }
        }
        else{
            if( x+1 > 7 || y+2 > 7 || chessComponents[x+1][y+2].name > 97 ){
                result.remove(a1);
            }
            if( x+1 > 7 || y-2 < 0 || chessComponents[x+1][y-2].name > 97 ){
                result.remove(a2);
            }
            if( x-1 < 0 || y+2 >7 || chessComponents[x-1][y+2].name > 97 ){
                result.remove(a3);
            }
            if( x-1 < 0 || y-2 < 0 || chessComponents[x-1][y-2].name > 97 ){
                result.remove(a4);
            }
            if( x+2 > 7 || y+1 > 7 || chessComponents[x+2][y+1].name > 97 ){
                result.remove(a5);
            }
            if( x+2 > 7 || y-1 < 0 || chessComponents[x+2][y-1].name > 97 ){
                result.remove(a6);
            }
            if( x-2 < 0 || y+1 > 7 || chessComponents[x-2][y+1].name > 97 ){
                result.remove(a7);
            }
            if( x-1 < 0 || y-1 < 0 || chessComponents[x-2][y-1].name > 97 ){
                result.remove(a8);
            }

        }

        return result;
    }
}
