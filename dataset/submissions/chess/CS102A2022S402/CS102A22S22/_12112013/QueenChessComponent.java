
import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public QueenChessComponent(ChessboardPoint source,ChessColor color,char name){
        this.source=source;
        this.chessColor=color;
        this.name=name;
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<ChessboardPoint>();
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                int o=0;
                if (Math.abs(source.getX()-i)==Math.abs(source.getY()-j) &&source.getX()!=i &&source.getY()!=j) {
                    int x =source.getX();
                    int y=source.getY();
                    if (i-source.getX()>0 &&j-source.getY()>0){
                        while(x<i-1 &&y<j-1) {
                            x++;
                            y++;
                            if (!(chessComponents[x][y].toString().equals("_"))) {
                                o=1;
                            }
                        }}
                    if (i-source.getX()<0 &&j-source.getY()>0){
                        while(x>i+1 &&y<j-1) {
                            x--;
                            y++;
                            if (!(chessComponents[x][y].toString().equals("_"))) {
                                o=1;
                            }
                        }}
                    if (i-source.getX()>0 &&j-source.getY()<0){
                        while(x<i-1 &&y>j+1) {
                            x++;
                            y--;
                            if (!(chessComponents[x][y].toString().equals("_"))) {
                                o=1;
                            }
                        }}
                    if (i-source.getX()<0 &&j-source.getY()<0){
                        while(x>i+1 &&y>j+1) {
                            x--;
                            y--;
                            if (!(chessComponents[x][y].toString().equals("_"))) {
                                o=1;
                            }
                        }}
                }else if (source.getX() == i &&source.getY()!=j) {
                    int row = source.getX();
                    for (int col = Math.min(source.getY(), j) + 1;
                         col < Math.max(source.getY(), j); col++) {
                        if (!(chessComponents[row][col].toString().equals("_"))) {
                            o=1;
                        }
                    }
                } else if (source.getY() == j &&source.getX()!=i) {
                    int col = source.getY();
                    for (int row = Math.min(source.getX(), i) + 1;
                         row < Math.max(source.getX(), i); row++) {
                        if (!(chessComponents[row][col].toString().equals("_"))) {
                            o=1;
                        }
                    }
                }else {
                    o=1;
                }
                if (o==0 &&chessComponents[i][j].getChessColor()!=this.getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chessboardPoints;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor(){return this.chessColor;}

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
