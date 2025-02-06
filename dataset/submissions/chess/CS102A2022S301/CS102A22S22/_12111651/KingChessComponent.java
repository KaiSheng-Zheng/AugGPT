import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private List<ChessboardPoint> chessboardPoints = new ArrayList<>();
    private ChessboardPoint source;
    private ChessColor chessColor;
    private char name;
    protected ChessComponent[][] chessComponents;

    public KingChessComponent(ChessboardPoint source,ChessColor chessColor , Character name, ChessComponent[][] chessComponents) {
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
        int i = 1;
        ChessColor color = chessComponents[x][y].getChessColor();
//      x, y++
        if (y+i < 8 && y+i >=0){
            if(color != chessComponents [x][y+i].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x, y + i));
            }
        }
//      x, y--
        if (y-i < 8 && y-i >=0){
            if(color != chessComponents [x][y-i].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x, y - i));
            }
        }
//      x++, y
        if(x+i >= 0 && x+i <8){
            if(color != chessComponents [x+i][y].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x+i, y ));
            }
        }
//      x-- , y
        if(x-i >= 0 && x-i <8){
            if(color != chessComponents [x-i][y].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x-i, y ));
            }
        }
//      x++ , y++
        if((x + i)<8 && (y + i)<8 && (x+i) >= 0){
            if(color != chessComponents [x+i][y+i].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x+i, y+i ));
            }
        }
//      x++ , y--
        if((x+i) < 8 && (x+i) >= 0 && (y-i) >= 0 && (y-i) <8){
            if(color != chessComponents [x+i][y-i].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x+i, y-i ));
            }
        }
//      x--, y++
        if((x - i)<8 && (y + i)<8 && (x-i) >= 0 && (y+i) >= 0){
            if(color != chessComponents [x-i][y+i].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x-i, y+i ));
            }
        }
//      x--, y--
        if((x-i) < 8 && (x-i) >= 0 && (y-i) >= 0 && (y-i) <8){
            if(color != chessComponents [x-i][y-i].getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x-i, y-i ));
            }
        }
        for (int k = 0; i < chessboardPoints.size() -1; i++) {
            for (int j = i+1; j <chessboardPoints.size() ; j++) {
                if( chessboardPoints.get(k).getX() == chessboardPoints.get(j).getX() &&  chessboardPoints.get(i).getY() == chessboardPoints.get(j).getY()){
                    chessboardPoints.remove(j);
                }
            }
        }
        return chessboardPoints;
    }
}
