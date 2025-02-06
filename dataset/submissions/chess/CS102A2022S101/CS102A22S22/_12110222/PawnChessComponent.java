import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name ;
    private ChessComponent[][] components ;


    public void setComponents(ChessComponent[][] components) {
        this.components = components;
    }
    public PawnChessComponent(ChessboardPoint source , ChessColor chessColor , char name) {
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
        boolean first = false;
        if (chessColor == ChessColor.WHITE) {
            if (source.getX() == 6) {
                first = true;
            }
        }
        if (chessColor == ChessColor.BLACK) {
            if (source.getX() == 1) {
                first = true;
            }
        }
        if (first) {
            if (chessColor == ChessColor.WHITE) {
                if (source.offset(-2, 0) != null && components[x - 2][y].getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(x - 2, y));
                }
            }

            if (chessColor == ChessColor.BLACK) {
                if (source.offset(2, 0) != null && components[x + 2][y].getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(x + 2, y));
                }
            }}
            if (chessColor == ChessColor.WHITE) {
                if (source.offset(-1, 0) != null && components[x - 1][y].getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(x - 1, y));
                }
                if (x - 1>=0 && y - 1 >=0) {
                    if (components[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                        list.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                if (x + 1 < 8 && y - 1 >=0) {
                    if (components[x + 1][y - 1].getChessColor() == ChessColor.BLACK) {
                        list.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if (x + 1 < 8 && y + 1 < 8) {
                    if (components[x + 1][y + 1].getChessColor() == ChessColor.BLACK) {
                        list.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
                if (x - 1 >= 0 && y + 1 < 8) {
                    if (components[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                        list.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }

            }
            if (chessColor == ChessColor.BLACK) {
                if (source.offset(1, 0) != null && components[x + 1][y].getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(x + 1, y));
                }
                if (x - 1 >= 0 && y - 1 >= 8) {
                    if (components[x - 1][y - 1].getChessColor() == ChessColor.WHITE) {
                        list.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                if (x - 1 >=0 && y + 1 < 8) {
                    if (components[x - 1][y + 1].getChessColor() == ChessColor.WHITE) {
                        list.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
                if (x + 1 < 8 && y - 1 >=0) {
                    if (components[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                        list.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if (x + 1 < 8 && y + 1 < 8) {
                    if (components[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                        list.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }

            }
            return list;
        }
        public String toString () {
            return String.valueOf(this.name);
        }
    }
