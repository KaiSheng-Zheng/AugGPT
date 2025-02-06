import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    protected char name;
    private ChessboardPoint source;

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> location = new ArrayList<>();

        int i = source.getX();
        int j = source.getY();

        while((i+1<8&&j<8)){
            if(this.chessColor == chessComponents[i+1][j].getChessColor()){
                break;
            }
            else if (chessComponents[i+1][j].getName() == '_'){
                ChessboardPoint destination = new ChessboardPoint(i+1,j);
                location.add(destination);
                i++;
            }
            else {
                ChessboardPoint eat = new ChessboardPoint(i+1,j);
                location.add(eat);
                break;
            }
        }
        i = source.getX();
        j = source.getY();

        while(i-1>=0&&j>=0){
            if(this.chessColor == chessComponents[i-1][j].getChessColor()){
                break;
            }
            else if (chessComponents[i-1][j].getName() == '_'){
                ChessboardPoint destination = new ChessboardPoint(i-1,j);
                location.add(destination);
                i--;
            }
            else {
                ChessboardPoint eat = new ChessboardPoint(i-1,j);
                location.add(eat);
                break;
            }
        }

        i = source.getX();
        j = source.getY();


        while(i<8&&j-1>=0){
            if(this.chessColor == chessComponents[i][j-1].getChessColor()){
                break;
            }
            else if (chessComponents[i][j-1].getName() == '_'){
                ChessboardPoint destination = new ChessboardPoint(i,j-1);
                location.add(destination);
                j--;
            }
            else {
                ChessboardPoint eat = new ChessboardPoint(i,j-1);
                location.add(eat);
                break;
            }
        }

        i = source.getX();
        j = source.getY();


        while(i>=0&&j+1<8){
            if(this.chessColor == chessComponents[i][j+1].getChessColor()){
                break;
            }
            else if (chessComponents[i][j+1].getName() == '_'){
                ChessboardPoint destination = new ChessboardPoint(i,j+1);
                location.add(destination);
                j++;
            }
            else {
                ChessboardPoint eat = new ChessboardPoint(i,j+1);
                location.add(eat);
                break;
            }
        }

        return location;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        this.chessColor = chessColor;
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
        super.setChessColor(chessColor);
        super.setName(name);
        super.setSource(source);
        super.setChessComponents(chessComponents);
    }
}
