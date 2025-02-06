import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private List<ChessboardPoint> chessboardPoints = new ArrayList<>();
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public RookChessComponent(ChessboardPoint source,ChessColor chessColor , Character name, ChessComponent[][] chessComponents){
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
        ChessColor color = chessComponents[x][y].getChessColor();
        //        x, y++
        for (int i = 1;(y + i) >=0 && (y + i) <8 ; i++) {
            if(chessComponents [x][y+i].getChessColor() == ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(x, y + i));
            }
            else{
                if(color != chessComponents [x][y+i].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x, y + i));
                }
                break;
            }
        }
//       x, y--
        for (int i = 1; (y - i) >=0 && (y - i) <8 ; i++) {
            if(chessComponents [x][y-i].getChessColor() == ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(x, y - i));
            }
            else{
                if(color != chessComponents [x][y-i].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x, y - i));
                }
                break;
            }
        }
//      x++, y
        for (int i = 1; (x + i) >= 0 && (x + i) < 8; i++) {
            if(chessComponents [x+i][y].getChessColor() == ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(x + i, y));
            }
            else{
                if(color != chessComponents [x+i][y].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x + i, y));
                }
                break;
            }
        }
//      x--, y
        for (int i = 1; (x - i) >= 0 && (x - i) < 8; i++) {
            if( chessColor == chessComponents [x-i][y].getChessColor()) {
                break;
            }
            else{
                if(chessComponents [x-i][y].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x - i, y));
                }
                if(chessComponents [x-i][y].getChessColor() != ChessColor.NONE &&
                        chessComponents [x][y].getChessColor() != chessComponents [x-i][y].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x - i, y));
                    break;
                }
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
