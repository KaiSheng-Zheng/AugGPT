import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessboardPoint getChessboardPoint() {
        return source;
    }

    public void setChessboardPoint(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    //should design
    public ChessComponent() {
    }

    public ChessComponent(int x, int y, ChessComponent[][] chessComponents) {
        this.source = new ChessboardPoint(x, y);
        this.chessComponents = chessComponents;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


    public char getName() {
        return this.name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}

class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(int x, int y, ChessComponent[][] chessComponents) {
        super(x, y, chessComponents);
        this.name = '_';
        setChessColor(ChessColor.NONE);
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}

class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessColor color, int x, int y, ChessComponent[][] chessComponents) {
        super(x, y, chessComponents);
        if (color == ChessColor.WHITE) {
            this.name = 'b';
            setChessColor(ChessColor.WHITE);
        } else {
            this.name = 'B';
            setChessColor(ChessColor.BLACK);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList valid = new ArrayList<>();
        int x = this.getChessboardPoint().getX();
        int y = this.getChessboardPoint().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean can = true;
                if (x + y == i + j) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        for (int row = Math.min(x, i) + 1, col = Math.max(y, j) - 1; row < Math.max(x, i); row++, col--) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                can = false;
                            }
                        }
                        if (can) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                } else if (x - y == i - j) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        for (int row = Math.min(x, i) + 1, col = Math.min(y, j) + 1; row < Math.max(x, i); row++, col++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                can = false;
                            }
                        }
                        if (can) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                }
            }
        }
        return valid;
    }
}

class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor color, int x, int y, ChessComponent[][] chessComponents) {
        super(x, y, chessComponents);
        if (color == ChessColor.WHITE) {
            this.name = 'k';
            setChessColor(ChessColor.WHITE);
        } else {
            this.name = 'K';
            setChessColor(ChessColor.BLACK);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getChessboardPoint().getX();
        int y = this.getChessboardPoint().getY();
        ArrayList valid = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(x - i) == 1 && Math.abs(y - j) <= 1 || Math.abs(y - j) == 1 && Math.abs(x - i) <= 1) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        valid.add(chessComponents[i][j].getChessboardPoint());
                    }
                }
            }
        }
        return valid;
    }

}

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessColor color, int x, int y, ChessComponent[][] chessComponents) {
        super(x, y, chessComponents);
        if (color == ChessColor.WHITE) {
            this.name = 'n';
            setChessColor(ChessColor.WHITE);
        } else {
            this.name = 'N';
            setChessColor(ChessColor.BLACK);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getChessboardPoint().getX();
        int y = this.getChessboardPoint().getY();
        ArrayList valid = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(y - j) == 2) {
                    if (Math.abs(x - i) == 1) {
                        if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                } else if (Math.abs(x - i) == 2) {
                    if (Math.abs(y - j) == 1) {
                        if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                }
            }
        }
        return valid;
    }

}

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessColor color, int x, int y, ChessComponent[][] chessComponents) {
        super(x, y, chessComponents);
        if (color == ChessColor.WHITE) {
            this.name = 'p';
            setChessColor(ChessColor.WHITE);
        } else {
            this.name = 'P';
            setChessColor(ChessColor.BLACK);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList valid = new ArrayList<>();
        int x = this.getChessboardPoint().getX();
        int y = this.getChessboardPoint().getY();
        if (this.getChessColor() == ChessColor.WHITE) {
            if (x == 6) {
                if (chessComponents[x - 2][y] instanceof EmptySlotComponent && chessComponents[x - 1][y] instanceof EmptySlotComponent) {
                    valid.add(chessComponents[x - 2][y].getChessboardPoint());
                }
                for (int i = 0; i < 8; i++) {
                    if (Math.abs(i - y) == 1) {
                        if (chessComponents[x - 1][i].getChessColor() != this.getChessColor() && !(chessComponents[x - 1][i] instanceof EmptySlotComponent)) {
                            valid.add(chessComponents[x - 1][i].getChessboardPoint());
                        }
                    }
                    if (i == y) {
                        if (chessComponents[x - 1][i] instanceof EmptySlotComponent) {
                            valid.add(chessComponents[x - 1][i].getChessboardPoint());
                        }
                    }
                }
                
            } else if (x > 0) {
                for (int i = 0; i < 8; i++) {
                    if (Math.abs(i - y) == 1) {
                        if (chessComponents[x - 1][i].getChessColor() != this.getChessColor() && !(chessComponents[x - 1][i] instanceof EmptySlotComponent)) {
                            valid.add(chessComponents[x - 1][i].getChessboardPoint());
                        }
                    }
                    if (i == y) {
                        if (chessComponents[x - 1][i] instanceof EmptySlotComponent) {
                            valid.add(chessComponents[x - 1][i].getChessboardPoint());
                        }
                    }
                }
            }
        } else if (this.getChessColor() == ChessColor.BLACK) {
            if (x == 1) {
                for (int i = 0; i < 8; i++) {
                    if (Math.abs(y - i) == 1) {
                        if (chessComponents[x + 1][i].getChessColor() != this.getChessColor() && !(chessComponents[x + 1][i] instanceof EmptySlotComponent)) {
                            valid.add(chessComponents[x + 1][i].getChessboardPoint());
                        }
                    } else if (y == i) {
                        if (chessComponents[x + 1][i] instanceof EmptySlotComponent) {
                            valid.add(chessComponents[x + 1][i].getChessboardPoint());
                        }
                    }
                }
                if (chessComponents[x + 2][y] instanceof EmptySlotComponent && chessComponents[x + 1][y] instanceof EmptySlotComponent) {
                    valid.add(chessComponents[x + 2][y].getChessboardPoint());
                }
            } else if (x < 7) {
                for (int i = 0; i < 8; i++) {
                    if (Math.abs(y - i) == 1) {
                        if (chessComponents[x + 1][i].getChessColor() != this.getChessColor() && !(chessComponents[x + 1][i] instanceof EmptySlotComponent)) {
                            valid.add(chessComponents[x + 1][i].getChessboardPoint());
                        }
                    } else if (y == i) {
                        if (chessComponents[x + 1][i] instanceof EmptySlotComponent) {
                            valid.add(chessComponents[x + 1][i].getChessboardPoint());
                        }
                    }
                }
            }
        }
        return valid;
    }

}

class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessColor color, int x, int y, ChessComponent[][] chessComponents) {
        super(x, y, chessComponents);
        if (color == ChessColor.WHITE) {
            this.name = 'q';
            setChessColor(ChessColor.WHITE);
        } else {
            this.name = 'Q';
            setChessColor(ChessColor.BLACK);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList valid = new ArrayList<>();
        int x = this.getChessboardPoint().getX();
        int y = this.getChessboardPoint().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean can = true;
                if (x + y == i + j) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        for (int row = Math.min(x, i) + 1, col = Math.max(y, j) - 1; row < Math.max(x, i); row++, col--) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                can = false;
                            }
                        }
                        if (can) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                } else if (x - y == i - j) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        for (int row = Math.min(x, i) + 1, col = Math.min(y, j) + 1; row < Math.max(x, i); row++, col++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                can = false;
                            }
                        }
                        if (can) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                } else if (x == i) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        for (int col = Math.min(y, j) + 1; col < Math.max(y, j); col++) {
                            if (!(chessComponents[x][col] instanceof EmptySlotComponent)) {
                                can = false;
                            }
                        }
                        if (can) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                } else if (y == j) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        for (int row = Math.min(x, i) + 1; row < Math.max(x, i); row++) {
                            if (!(chessComponents[row][y] instanceof EmptySlotComponent)) {
                                can = false;
                            }
                        }
                        if (can) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                }
            }
        }
        return valid;
    }

}

class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessColor color, int x, int y, ChessComponent[][] chessComponents) {
        super(x, y, chessComponents);
        if (color == ChessColor.WHITE) {
            this.name = 'r';
            setChessColor(ChessColor.WHITE);
        } else {
            this.name = 'R';
            setChessColor(ChessColor.BLACK);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList valid = new ArrayList<>();
        int x = this.getChessboardPoint().getX();
        int y = this.getChessboardPoint().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean can = true;
                if (x == i) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        for (int col = Math.min(y, j) + 1; col < Math.max(y, j); col++) {
                            if (!(chessComponents[x][col] instanceof EmptySlotComponent)) {
                                can = false;
                            }
                        }
                        if (can) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                } else if (y == j) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        for (int row = Math.min(x, i) + 1; row < Math.max(x, i); row++) {
                            if (!(chessComponents[row][y] instanceof EmptySlotComponent)) {
                                can = false;
                            }
                        }
                        if (can) {
                            valid.add(chessComponents[i][j].getChessboardPoint());
                        }
                    }
                }
            }
        }
        return valid;
    }
}