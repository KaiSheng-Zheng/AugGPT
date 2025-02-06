import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private List<ChessboardPoint> chessboardPoints = new ArrayList<>();
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;


    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor , Character name, ChessComponent[][] chessComponents){
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
        if( color == ChessColor.BLACK ){
            if(x == 1){
                if( chessComponents[x+1][y].getChessColor() == ChessColor.NONE) {
                    chessboardPoints.add(new ChessboardPoint(x + 1, y));
                    if( chessComponents[x+2][y].getChessColor() == ChessColor.NONE) {
                        chessboardPoints.add(new ChessboardPoint(x + 2, y));
                    }
                }
                if( y-1 >= 0 && y-1<8) {
                    if (chessComponents[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                        chessboardPoints.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if(y+1 >=0 && y+1 <8) {
                    if (chessComponents[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                        chessboardPoints.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
            }
            else{
                if( x+1 >= 0 && x+1 < 8 ) {
                    if (chessComponents[x + 1][y].getChessColor() == ChessColor.NONE) {
                        chessboardPoints.add(new ChessboardPoint(x + 1, y));
                    }
                }
                if(x+1 >= 0 && x+1 < 8 && y-1 >= 0 && y-1 < 8 ) {
                    if (chessComponents[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                        chessboardPoints.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if(x+1 >= 0 && x+1 <8 && y+1 >= 0 && y+1 < 8) {
                    if (chessComponents[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                        chessboardPoints.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
            }
        }
        else{
            if(x == 6){
                if(chessComponents[x-1][y].getChessColor() == ChessColor.NONE){
                    chessboardPoints.add(new ChessboardPoint(x-1,y));
                    if(chessComponents[x-2][y].getChessColor() == ChessColor.NONE){
                        chessboardPoints.add(new ChessboardPoint(x-2,y));
                    }
                }
                if( y-1 >=0 && y-1<8) {
                    if (chessComponents[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                        chessboardPoints.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                if( y+1 >= 0 && y+1 <8) {
                    if (chessComponents[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                        chessboardPoints.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
            }
            else{
                if((x-1) >= 0 && (x-1) < 8){
                    if(chessComponents[x-1][y].getChessColor() == ChessColor.NONE){
                        chessboardPoints.add(new ChessboardPoint(x-1,y));
                    }
                    if( y-1 >=0 && y-1 <8) {
                        if (chessComponents[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                            chessboardPoints.add(new ChessboardPoint(x - 1, y - 1));
                        }
                    }
                    if(y+1 >= 0 && y+1 <8 ) {
                        if (chessComponents[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                            chessboardPoints.add(new ChessboardPoint(x - 1, y + 1));
                        }
                    }
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
