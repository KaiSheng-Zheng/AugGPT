import java.util.List;
import java.util.Objects;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private List<String> chessboard;
    private String[][] chessboard2;

    public ChessComponent(){
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public List<String> getChessboard() {
        return chessboard;
    }

    public String[][] getChessboard2() {
        return chessboard2;
    }

    public void setChessboard2(String[][] chessboard2) {
        this.chessboard2 = chessboard2;
    }

    public void setChessboard(List<String> chessboard) {
        this.chessboard = chessboard;
    }

    public ChessColor whichcolor(ChessboardPoint chessboardPoint){
        int x = chessboardPoint.getX();
        int y = chessboardPoint.getY();
        if(Objects.equals(chessboard2[x][y], "_")){
            return ChessColor.NONE;
        }if(Objects.equals(chessboard2[x][y], "R")){
            return ChessColor.BLACK;
        }if(Objects.equals(chessboard2[x][y], "N")){
            return ChessColor.BLACK;
        }if(Objects.equals(chessboard2[x][y], "B")){
            return ChessColor.BLACK;
        }if(Objects.equals(chessboard2[x][y], "Q")){
            return ChessColor.BLACK;
        }if(Objects.equals(chessboard2[x][y], "K")){
            return ChessColor.BLACK;
        }if(Objects.equals(chessboard2[x][y], "P")){
            return ChessColor.BLACK;
        }if(Objects.equals(chessboard2[x][y], "r")){
            return ChessColor.WHITE;
        }if(Objects.equals(chessboard2[x][y], "n")){
            return ChessColor.WHITE;
        }if(Objects.equals(chessboard2[x][y], "b")){
            return ChessColor.WHITE;
        }if(Objects.equals(chessboard2[x][y], "q")){
            return ChessColor.WHITE;
        }if(Objects.equals(chessboard2[x][y], "k")){
            return ChessColor.WHITE;
        }if(Objects.equals(chessboard2[x][y], "p")){
            return ChessColor.WHITE;
        }return null;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
