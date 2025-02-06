import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class BishopChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> list = new ArrayList<>();


    public BishopChessComponent(ChessboardPoint source, ChessComponent[][] chessComponents, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.chessComponents = chessComponents;
        this.name = name;
        this.chessColor = chessColor;
    }


    @Override
    public ChessColor getChessColor(){
        return this.chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (canMove(i,j) && chick(i,j)){
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }

        return list.stream().distinct().collect(Collectors.toList());
    }

    public boolean canMove(int x, int y){
        ChessboardPoint source = getSource();
        if (((x- source.getX())==(y- source.getY())) && Math.abs(x- source.getX())!=0){
            int row = Math.min(source.getX(),x)+1;
            int col = Math.min(source.getY(),y)+1;
            for (; row<Math.max(source.getX(),x)&&col < Math.max(source.getY(), y);
                 row++,col++){
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)){
                    return false;
                }
            }
        }else if (((x- source.getX()) == (source.getY() - y)) && (x - source.getX() != 0)){
            int row = Math.min(source.getX(),x)+1;
            int col = Math.max(source.getY(),y)-1;
            for (; row<Math.max(source.getX(),x)&&col > Math.min(source.getY(), y);
                 row++,col--){
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)){
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    public boolean chick(int x, int y){
        ChessboardPoint source = getSource();
        if (chessComponents[x][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[x][y] instanceof EmptySlotComponent){
            return true;
        }
        return false;
    }
}
