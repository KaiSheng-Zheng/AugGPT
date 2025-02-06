import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private List<ChessboardPoint> chessboardPoints = new ArrayList<>();
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents = new ChessComponent[8][8];

    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor , Character name,ChessComponent[][] chessComponents){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        super.setSource(source);
        super.setChessColor(chessColor);
        super.setName(name);
        this.chessComponents = chessComponents.clone();
        super.setChessComponents(chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        ChessColor color = chessComponents[x][y].getChessColor();

        //  x++, y++
        for (int i = 1;(x + i)<8 && (y + i)<8 && (x+i) >= 0 && (y+i) >= 0; i++) {
            if(chessComponents [x+i][y+i].getChessColor() == ChessColor.NONE) {
                chessboardPoints.add(new ChessboardPoint(x + i, y + i));
            }
            else{
                if(color != chessComponents [x+i][y+i].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x + i, y + i));
                }
                break;
            }
        }
//        x++, y--
        for (int i = 1; (x+i) < 8 && (x+i) >= 0 && (y-i) >= 0 && (y-i) <8; i++) {
            if(chessComponents [x+i][y-i].getChessColor() == ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(x + i, y - i));
            }
            else{
                if( color != chessComponents [x+i][y-i].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x + i, y - i));
                }
                break;
            }

        }
//       x--, y++
        for (int i = 1;(x - i)<8 && (y + i)<8 && (x-i) >= 0 && (y+i) >= 0 ; i++) {
            if(chessComponents [x-i][y+i].getChessColor() == ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(x - i, y + i));
            }
            else{
                if( color != chessComponents [x-i][y+i].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x - i, y + i));
                }
                break;
            }
        }
//        x--, y--
        for (int i = 1; (x-i) < 8 && (x-i) >= 0 && (y-i) >= 0 && (y-i) <8; i++) {
            if(chessComponents [x-i][y-i].getChessColor() == ChessColor.NONE){
                chessboardPoints.add(new ChessboardPoint(x - i, y - i));
            }
            else{
                if(color != chessComponents [x-i][y-i].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x - i, y - i));
                }
                break;
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
