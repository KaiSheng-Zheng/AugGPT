
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public RookChessComponent(ChessboardPoint source,ChessColor color,char name){
        this.source=source;
        this.chessColor=color;
        this.name=name;
    }
    public ChessColor getChessColor(){return this.chessColor;}

    public  List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<ChessboardPoint>();
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                if (source.getX() == i &&source.getY()!=j) {
                    int o=0;
                    int row = source.getX();
                    for (int col = Math.min(source.getY(), j)+1;
                         col < Math.max(source.getY(), j); col++) {
                        if (!(chessComponents[row][col].toString().equals("_"))) {
                            o=1;
                        }
                    }
                    if (o==0 &&chessComponents[i][j].getChessColor()!=this.chessColor){
                        chessboardPoints.add(new ChessboardPoint(i,j));
                    }
                } else if (source.getY() == j &&source.getX()!=i) {
                    int col = source.getY();
                    int o=0;
                    for (int row = Math.min(source.getX(), i)+1;
                         row < Math.max(source.getX(), i); row++) {
                        if (!(chessComponents[row][col].toString().equals("_"))) {
                            o=1;
                        }
                    }
                    if (o==0 &&chessComponents[i][j].getChessColor()!=this.chessColor){
                        chessboardPoints.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return chessboardPoints;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public String toString() {
        return String.valueOf(this.name);
    }
}
