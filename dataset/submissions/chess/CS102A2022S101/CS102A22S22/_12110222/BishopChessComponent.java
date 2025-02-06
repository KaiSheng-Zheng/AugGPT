import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name ;
    private ChessComponent[][] components ;


    public void setComponents(ChessComponent[][] components) {
        this.components = components;
    }
    public BishopChessComponent(ChessboardPoint source , ChessColor chessColor , char name) {
        this.source =source;
        this.chessColor =chessColor;
        this.name =name;
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

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int x = source.getX();int y =source.getY();
        for (int i = x,j=y; i <8| j <8 ;i++,j++ ) {

            if(x==7||y==7){break;}
            if(source.offset(i-x+1,j-y+1)!=null){
                if(components[i+1][j+1].getChessColor()==chessColor){break;}
                list.add(new ChessboardPoint(i+1,j+1));
                if(components[i+1][j+1].getChessColor()!=chessColor&&components[i+1][j+1].getChessColor()!=ChessColor.NONE){break;}
            }

        }
        for (int i = x,j=y; i <8|j>=0 ;i++,j--) {

            if(x==7||y==0){break;}
            if(source.offset(i-x+1,j-y-1)!=null){
                if(components[i+1][j-1].getChessColor()==chessColor){break;}
                list.add(new ChessboardPoint(i+1,j-1));
                if(components[i+1][j-1].getChessColor()!=chessColor&&components[i+1][j-1].getChessColor()!=ChessColor.NONE){break;}
            }

        }
        for (int i = x,j=y; i >=0 |j>=0;i--,j--) {

            if(x==0||y==0){break;}
            if(source.offset(i-x-1,j-y-1)!=null){
                if(i-1<0||j-1<0){break;}
                if(components[i-1][j-1].getChessColor()==chessColor){break;}
                list.add(new ChessboardPoint(i-1,j-1));
                if(components[i-1][j-1].getChessColor()!=chessColor&&components[i-1][j-1].getChessColor()!=ChessColor.NONE){break;}
            }

        }

        for (int i = x,j=y; i >=0|j<8 ;i--,j++) {

            if(x==0||y==7){break;}
            if(source.offset(i-x-1,j-y+1)!=null){
                if(components[i-1][j+1].getChessColor()==chessColor){break;}
                list.add(new ChessboardPoint(i-1,j+1));
                if(components[i-1][j+1].getChessColor()!=chessColor&&components[i-1][j+1].getChessColor()!=ChessColor.NONE){break;}
            }

        }


        return list;
    }
    public String toString() {
        return String.valueOf(this.name);
    }
}
