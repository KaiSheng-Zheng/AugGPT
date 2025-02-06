import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name ;



    private ChessComponent[][] components;


    public void setComponents(ChessComponent[][] components) {
        this.components = components;
    }

    public RookChessComponent(ChessboardPoint source , ChessColor chessColor , char name) {
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
        int x = source.getX();
        int y = source.getY();
        for (int i = x ; i < 8; i++) {
            if(x==7){break;}
            if (source.offset(i - x+1, 0) != null) {
                if (components[i+1][y].getChessColor() == chessColor) {
                    break;
                }
                list.add(new ChessboardPoint(i+1, y));
                if (components[i+1][y].getChessColor() != chessColor && components[i+1][y].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }
        for (int i = x ; i >= 0; i--) {
            if(x==0){break;}
            if (source.offset(i-x-1, 0) != null) {
                if (components[i-1][y].getChessColor() == chessColor) {
                    break;
                }
                list.add(new ChessboardPoint(i-1, y));
                if (components[i-1][y].getChessColor() != chessColor && components[i-1][y].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }
        for (int i = y ; i < 8; i++) {
            if(y==7){break;}
            if (source.offset(0, i - y+1) != null) {
                if (components[x][i+1].getChessColor() == chessColor) {
                    break;
                }
                list.add(new ChessboardPoint(x, i+1));
                if (components[x][i+1].getChessColor() != chessColor && components[x][i+1].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }
        for (int i = y ; i >= 0; i--) {
            if(y==0){break;}
            if (source.offset(0, y - i-1) != null) {
                if (components[x][i-1].getChessColor() == chessColor) {
                    break;
                }
                list.add(new ChessboardPoint(x, i-1));
                if (components[x][i-1].getChessColor() != chessColor && components[x][i-1].getChessColor() != ChessColor.NONE) {
                    break;
                }
            }
        }


        return list;
    }
    public String toString() {
        return String.valueOf(getName());
    }
}
