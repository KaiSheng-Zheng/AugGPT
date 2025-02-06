import java.util.ArrayList;
        import java.util.List;



public class KnightChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> list = new ArrayList<>();
    public KnightChessComponent(ChessboardPoint source, ChessComponent[][] chessComponents, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.chessComponents = chessComponents;
        this.name = name;
        this.chessColor = chessColor;
    }

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
        System.out.println(list);
        return list;
    }

    public boolean canMove(int x, int y){
        ChessboardPoint source = getSource();
        int r=Math.abs(source.getX() - x);
        int c=Math.abs(source.getY() - y);
        if((r==1&&c==2)||(r==2&&c==1)){
            int row = Math.min(source.getX(), x) + 1;
            int col = Math.min(source.getY(), y) + 1;
            return true;
        }
        return false;
    }
    public boolean chick(int x, int y){
        ChessboardPoint source = getSource();
        if (chessComponents[x][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[x][y] instanceof EmptySlotComponent){
            return true;
        }
        return false;
    }
}


