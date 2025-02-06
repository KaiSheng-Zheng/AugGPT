import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    
    //should design
    public ChessComponent() {
    }
    
    public ChessComponent(int x, int y, ChessColor chessColor) {
        this.chessColor = chessColor;
        this.source = new ChessboardPoint(x, y);
    }
    
    public ChessColor getChessColor() {
        return chessColor;
    }
    
    public ChessboardPoint getSource() {
        return source;
    }
    
    // should design
    public abstract List<ChessboardPoint> canMoveTo();
    
    /**
     * should design
     *
     * @return the name of current chess piece.
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    
    public void setSource(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
    }
}

class BishopChessComponent extends ChessComponent {
    
    private final ChessComponent[][] chessBoard;
    private final ChessColor chessColor;
    
    public BishopChessComponent(ChessComponent[][] chessComponents, char name, int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        this.name = name;
        this.chessBoard = chessComponents;
        this.chessColor = chessColor;
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentPoint = super.getSource();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = currentPoint.getX();
        int y = currentPoint.getY();
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            if (chessBoard[i][j].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessBoard[i][j].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessBoard[i][j].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            if (chessBoard[i][j].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessBoard[i][j].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessBoard[i][j].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            if (chessBoard[i][j].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessBoard[i][j].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessBoard[i][j].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessBoard[i][j].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessBoard[i][j].getChessColor() == chessColor) {
                break;
            }
        }
        return canMoveTo;
    }
}

class EmptySlotComponent extends ChessComponent {
    
    public EmptySlotComponent(ChessComponent[][] chessComponents, char name, int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        this.name = name;
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

class KingChessComponent extends ChessComponent {
    
    private final ChessComponent[][] chessBoard;
    private final ChessColor chessColor;
    
    public KingChessComponent(ChessComponent[][] chessComponents, char name, int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        this.name = name;
        this.chessBoard = chessComponents;
        this.chessColor = chessColor;
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentPoint = super.getSource();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = currentPoint.getX();
        int y = currentPoint.getY();
        if (x + 1 < 8 && chessBoard[x + 1][y].getChessColor() != chessColor && chessBoard[x + 1][y].name != 'K' && chessBoard[x + 1][y].name != 'k') {
            canMoveTo.add(new ChessboardPoint(x + 1, y));
        }
        if (x - 1 >= 0 && chessBoard[x - 1][y].getChessColor() != chessColor && chessBoard[x - 1][y].name != 'K' && chessBoard[x - 1][y].name != 'k') {
            canMoveTo.add(new ChessboardPoint(x - 1, y));
        }
        if (y + 1 < 8 && chessBoard[x][y + 1].getChessColor() != chessColor && chessBoard[x][y + 1].name != 'K' && chessBoard[x][y + 1].name != 'k') {
            canMoveTo.add(new ChessboardPoint(x, y + 1));
        }
        if (y - 1 >= 0 && chessBoard[x][y - 1].getChessColor() != chessColor && chessBoard[x][y - 1].name != 'K' && chessBoard[x][y - 1].name != 'k') {
            canMoveTo.add(new ChessboardPoint(x, y - 1));
        }
        if (x + 1 < 8 && y + 1 < 8 && chessBoard[x + 1][y + 1].getChessColor() != chessColor && chessBoard[x + 1][y + 1].name != 'K' && chessBoard[x + 1][y + 1].name != 'k') {
            canMoveTo.add(new ChessboardPoint(x + 1, y + 1));
        }
        if (x + 1 < 8 && y - 1 >= 0 && chessBoard[x + 1][y - 1].getChessColor() != chessColor && chessBoard[x + 1][y - 1].name != 'K' && chessBoard[x + 1][y - 1].name != 'k') {
            canMoveTo.add(new ChessboardPoint(x + 1, y - 1));
        }
        if (x - 1 >= 0 && y + 1 < 8 && chessBoard[x - 1][y + 1].getChessColor() != chessColor && chessBoard[x - 1][y + 1].name != 'K' && chessBoard[x - 1][y + 1].name != 'k') {
            canMoveTo.add(new ChessboardPoint(x - 1, y + 1));
        }
        if (x - 1 >= 0 && y - 1 >= 0 && chessBoard[x - 1][y - 1].getChessColor() != chessColor && chessBoard[x - 1][y - 1].name != 'K' && chessBoard[x - 1][y - 1].name != 'k') {
            canMoveTo.add(new ChessboardPoint(x - 1, y - 1));
        }
        return canMoveTo;
    }
}

class KnightChessComponent extends ChessComponent {
    
    private final ChessComponent[][] chessBoard;
    private final ChessColor chessColor;
    
    public KnightChessComponent(ChessComponent[][] chessComponents, char name, int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        this.name = name;
        this.chessBoard = chessComponents;
        this.chessColor = chessColor;
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentPoint = super.getSource();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = currentPoint.getX();
        int y = currentPoint.getY();
        if (x + 2 < 8 && y + 1 < 8 && chessBoard[x + 2][y + 1].getChessColor() != chessColor) {
            canMoveTo.add(new ChessboardPoint(x + 2, y + 1));
        }
        if (x + 2 < 8 && y - 1 >= 0 && chessBoard[x + 2][y - 1].getChessColor() != chessColor) {
            canMoveTo.add(new ChessboardPoint(x + 2, y - 1));
        }
        if (x - 2 >= 0 && y + 1 < 8 && chessBoard[x - 2][y + 1].getChessColor() != chessColor) {
            canMoveTo.add(new ChessboardPoint(x - 2, y + 1));
        }
        if (x - 2 >= 0 && y - 1 >= 0 && chessBoard[x - 2][y - 1].getChessColor() != chessColor) {
            canMoveTo.add(new ChessboardPoint(x - 2, y - 1));
        }
        if (x + 1 < 8 && y + 2 < 8 && chessBoard[x + 1][y + 2].getChessColor() != chessColor) {
            canMoveTo.add(new ChessboardPoint(x + 1, y + 2));
        }
        if (x + 1 < 8 && y - 2 >= 0 && chessBoard[x + 1][y - 2].getChessColor() != chessColor) {
            canMoveTo.add(new ChessboardPoint(x + 1, y - 2));
        }
        if (x - 1 >= 0 && y + 2 < 8 && chessBoard[x - 1][y + 2].getChessColor() != chessColor) {
            canMoveTo.add(new ChessboardPoint(x - 1, y + 2));
        }
        if (x - 1 >= 0 && y - 2 >= 0 && chessBoard[x - 1][y - 2].getChessColor() != chessColor) {
            canMoveTo.add(new ChessboardPoint(x - 1, y - 2));
        }
        return canMoveTo;
    }
}

class PawnChessComponent extends ChessComponent {
    
    private final ChessComponent[][] chessBoard;
    private final ChessColor chessColor;
    
    public PawnChessComponent(ChessComponent[][] chessComponents, char name, int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        this.name = name;
        this.chessBoard = chessComponents;
        this.chessColor = chessColor;
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentPoint = super.getSource();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = currentPoint.getX();
        int y = currentPoint.getY();
        if (chessColor == ChessColor.BLACK) {
            if (x + 1 < 8 && chessBoard[x + 1][y].name == '_') {
                canMoveTo.add(new ChessboardPoint(x + 1, y));
            }
            if (x == 1 && chessBoard[x + 1][y].name == '_' && chessBoard[x + 2][y].name == '_') {
                canMoveTo.add(new ChessboardPoint(x + 2, y));
            }
            if (x + 1 < 8 && y + 1 < 8 && chessBoard[x + 1][y + 1].name != '_' && chessBoard[x + 1][y + 1].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(x + 1, y + 1));
            }
            if (x + 1 < 8 && y - 1 >= 0 && chessBoard[x + 1][y - 1].name != '_' && chessBoard[x + 1][y - 1].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(x - 1, y + 1));
            }
        } else if (chessColor == ChessColor.WHITE) {
            if (x - 1 >= 0 && chessBoard[x - 1][y].name == '_') {
                canMoveTo.add(new ChessboardPoint(x - 1, y));
            }
            if (x == 6 && chessBoard[x - 1][y].name == '_' && chessBoard[x - 2][y].name == '_') {
                canMoveTo.add(new ChessboardPoint(x - 2, y));
            }
            if (x - 1 >= 0 && y + 1 < 8 && chessBoard[x - 1][y + 1].name != '_' && chessBoard[x - 1][y + 1].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(x - 1, y + 1));
            }
            if (x - 1 >= 0 && y - 1 >= 0 && chessBoard[x - 1][y - 1].name != '_' && chessBoard[x - 1][y - 1].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(x - 1, y - 1));
            }
        }
        return canMoveTo;
    }
}

class QueenChessComponent extends ChessComponent {
    
    private final ChessComponent[][] chessBoard;
    private final ChessColor chessColor;
    
    public QueenChessComponent(ChessComponent[][] chessComponents, char name, int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        this.name = name;
        this.chessBoard = chessComponents;
        this.chessColor = chessColor;
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentPoint = super.getSource();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = currentPoint.getX();
        int y = currentPoint.getY();
        for (int i = x + 1; i < 8; i++) {
            if (chessBoard[i][y].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, y));
            } else if (chessBoard[i][y].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, y));
                break;
            } else if (chessBoard[i][y].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (chessBoard[i][y].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, y));
            } else if (chessBoard[i][y].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, y));
                break;
            } else if (chessBoard[i][y].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if (chessBoard[x][i].name == '_') {
                canMoveTo.add(new ChessboardPoint(x, i));
            } else if (chessBoard[x][i].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(x, i));
                break;
            } else if (chessBoard[x][i].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (chessBoard[x][i].name == '_') {
                canMoveTo.add(new ChessboardPoint(x, i));
            } else if (chessBoard[x][i].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(x, i));
                break;
            } else if (chessBoard[x][i].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            if (chessBoard[i][j].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessBoard[i][j].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessBoard[i][j].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            if (chessBoard[i][j].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessBoard[i][j].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessBoard[i][j].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            if (chessBoard[i][j].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessBoard[i][j].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessBoard[i][j].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessBoard[i][j].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessBoard[i][j].getChessColor() == chessColor) {
                break;
            }
        }
        return canMoveTo;
    }
}

class RookChessComponent extends ChessComponent {
    
    private final ChessComponent[][] chessBoard;
    private final ChessColor chessColor;
    
    public RookChessComponent(ChessComponent[][] chessComponents, char name, int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        this.name = name;
        this.chessBoard = chessComponents;
        this.chessColor = chessColor;
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint currentPoint = super.getSource();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = currentPoint.getX();
        int y = currentPoint.getY();
        for (int i = x + 1; i < 8; i++) {
            if (chessBoard[i][y].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, y));
            } else if (chessBoard[i][y].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, y));
                break;
            } else if (chessBoard[i][y].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (chessBoard[i][y].name == '_') {
                canMoveTo.add(new ChessboardPoint(i, y));
            } else if (chessBoard[i][y].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(i, y));
                break;
            } else if (chessBoard[i][y].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if (chessBoard[x][i].name == '_') {
                canMoveTo.add(new ChessboardPoint(x, i));
            } else if (chessBoard[x][i].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(x, i));
                break;
            } else if (chessBoard[x][i].getChessColor() == chessColor) {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (chessBoard[x][i].name == '_') {
                canMoveTo.add(new ChessboardPoint(x, i));
            } else if (chessBoard[x][i].getChessColor() != chessColor) {
                canMoveTo.add(new ChessboardPoint(x, i));
                break;
            } else if (chessBoard[x][i].getChessColor() == chessColor) {
                break;
            }
        }
        return canMoveTo;
    }
}