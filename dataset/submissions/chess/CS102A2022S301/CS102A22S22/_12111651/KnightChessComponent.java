import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private List<ChessboardPoint> chessboardPoints = new ArrayList<>();
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor , Character name,ChessComponent[][] chessComponents){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        super.setSource(source);
        super.setChessColor(chessColor);
        super.setName(name);
        this.chessComponents = chessComponents;
        super.setChessComponents(chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
//      x+2 , y+1
        if( (x+2) >= 0 && (x+2) < 8 && (y+1) >= 0 && (y+1) < 8){
            if(chessColor != chessComponents [x+2][y+1].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x + 2, y + 1));
            }
        }
//      x+2 , y-1
        if( (x+2) >= 0 && (x+2) < 8 && (y-1) >= 0 && (y-1) < 8){
            if(chessColor != chessComponents [x+2][y-1].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x + 2, y - 1));
            }
        }
//      x-2 , y+1
        if( (x-2) >= 0 && (x-2) < 8 && (y+1) >= 0 && (y+1) < 8){
            if(chessColor != chessComponents [x-2][y+1].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x - 2, y + 1));
            }
        }
//      x-2 , y-1
        if( (x-2) >= 0 && (x-2) < 8 && (y-1) >= 0 && (y-1) < 8){
            if(chessColor != chessComponents [x-2][y-1].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x - 2, y - 1));
            }
        }
//      x+1 , y+2
        if( (x+1) >= 0 && (x+1) < 8 && (y+2) >= 0 && (y+2) < 8){
            if(chessColor != chessComponents [x+1][y+2].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x + 1, y + 2));
            }
        }
//      x+1 , y-2
        if( (x+1) >= 0 && (x+1) < 8 && (y-2) >= 0 && (y-2) < 8){
            if(chessColor != chessComponents [x+1][y-2].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x + 1, y - 2));
            }
        }
//      x-1 , y+2
        if( (x-1) >= 0 && (x-1) < 8 && (y+2) >= 0 && (y+2) < 8){
            if(chessColor != chessComponents [x-1][y+2].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x - 1, y + 2));
            }
        }
//      x-1 , y-2
        if( (x-1) >= 0 && (x-1) < 8 && (y-2) >= 0 && (y-2) < 8){
            if(chessColor != chessComponents [x-1][y-2].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x - 1, y - 2));
            }
        }
        for (int i = 0; i < chessboardPoints.size() -1; i++) {
            for (int j = i+1; j <chessboardPoints.size() ; j++) {
                if( chessboardPoints.get(i).getX() == chessboardPoints.get(j).getX() &&  chessboardPoints.get(i).getY() == chessboardPoints.get(j).getY()){
                    chessboardPoints.remove(j);
                }
            }
        }

        return chessboardPoints;
    }
}
