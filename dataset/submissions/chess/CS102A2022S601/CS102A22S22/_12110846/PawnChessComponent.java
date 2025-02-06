import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
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
        ChessboardPoint a2 = new ChessboardPoint(x+2,y);
        ChessboardPoint a3 = new ChessboardPoint(x+1,y+1);
        ChessboardPoint a4 = new ChessboardPoint(x+1,y-1);

        ChessboardPoint a5 = new ChessboardPoint(x-1,y);
        ChessboardPoint a6 = new ChessboardPoint(x-2,y);
        ChessboardPoint a7 = new ChessboardPoint(x-1,y+1);
        ChessboardPoint a8 = new ChessboardPoint(x-1,y-1);


        if( name == 'P' ){
            if( x+1 < 8 && chessComponents[x+1][y].name == 95 ){
                result.add(a1);
            }
            if( x == 1 && chessComponents[x+2][y].name == 95 ){
                result.add(a2);
            }
            if( x+1 < 8 && y+1 < 8 && chessComponents[x+1][y+1].name > 97 ){
                result.add(a3);
            }
            if( x+1 < 8 && y-1 >= 0 && chessComponents[x+1][y-1].name > 97 ){
                result.add(a4);
            }
        }
        else{
            if( x-1 >= 0 && chessComponents[x-1][y].name == 95 ){
                result.add(a5);
            }
            if( x == 6 && chessComponents[x-2][y].name == 95 ){
                result.add(a6);
            }
            if( x-1 >= 0 && y+1 < 8 && chessComponents[x-1][y+1].name < 91 ){
                result.add(a7);
            }
            if( x-1 >= 0 && y-1 >= 0 && chessComponents[x-1][y-1].name < 91 ){
                result.add(a8);
            }
        }

        return result;
    }
}
