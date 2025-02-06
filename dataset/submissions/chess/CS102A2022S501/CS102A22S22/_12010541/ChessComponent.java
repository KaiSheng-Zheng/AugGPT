import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent(){};

    public ChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        this.name = name;
        this.chessColor = chessColor;
        this.source = source;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(int x, int y) {
        source = new ChessboardPoint(x, y);
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor color) {
        this.chessColor = color;
    }

    boolean isOnBoard(ChessboardPoint p) {
        if (0 <= p.getX() && p.getX() <= 7 && 0 <= p.getY() && p.getY() <= 7) {
            return true;
        }else {
            return false;
        }
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> validMovement = new ArrayList<>();
        return validMovement;
    }
}

class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> validMovement = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        int i;

        i = 1;
        // down
        while (x < 7) {
            if (isValid(x+i, y, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // up
        i = 1;
        while (x > 0) {
            if (isValid(x-i, y, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // left
        i = 1;
        while (y > 0) {
            if (isValid(x, y-i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // right
        i = 1;
        while (y < 7) {
            if (isValid(x, y+i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        return validMovement;
    }

    private boolean isValid(int x, int y, ChessColor chessColor, List<ChessboardPoint> validMovement) {
        boolean isBreakUp = false;
        int result;

        ChessboardPoint p = new ChessboardPoint(x, y);
        if (isOnBoard(p)) {
            if (chessComponents[x][y] instanceof EmptySlotComponent) {
                result = 0;
            }else {
                if (chessComponents[x][y].getChessColor() == chessColor) {
                    result = 1;
                }else {
                    result = -1;
                }
            }
        }else {
            result = 1;
        }

        switch (result) {
            case -1:    // opposite side
                validMovement.add(p);
                isBreakUp = true;
                break;
            case 0:    // valid
                validMovement.add(p);
                break;
            case 1:    // own side or out of board
                isBreakUp = true;
                break;
        }

        return isBreakUp;
    }
}

class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> validMovement = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        int i;

        // left up
        i = 1;
        while (x > 0 && y > 0) {
            if (isValid(x-i, y-i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // right up
        i = 1;
        while (x > 0 && y < 7) {
            if (isValid(x-i, y+i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // left down
        i = 1;
        while (x < 7 && y > 0) {
            if (isValid(x+i, y-i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // right down
        i = 1;
        while (x < 7 && y < 7) {
            if (isValid(x+i, y+i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        return validMovement;
    }

    private boolean isValid(int x, int y, ChessColor chessColor, List<ChessboardPoint> validMovement) {
        boolean isBreakUp = false;
        int result;

        ChessboardPoint p = new ChessboardPoint(x, y);
        if (isOnBoard(p)) {
            if (chessComponents[x][y] instanceof EmptySlotComponent) {
                result = 0;
            }else {
                if (chessComponents[x][y].getChessColor() == chessColor) {
                    result = 1;
                }else {
                    result = -1;
                }
            }
        }else {
            result = 1;
        }

        switch (result) {
            case -1:    // opposite side
                validMovement.add(p);
                isBreakUp = true;
                break;
            case 0:    // valid
                validMovement.add(p);
                break;
            case 1:    // own side or out of board
                isBreakUp = true;
                break;
        }

        return isBreakUp;
    }
}

class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> validMovement = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        int i;

        i = 1;
        // down
        while (x < 7) {
            if (isValid(x+i, y, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // up
        i = 1;
        while (x > 0) {
            if (isValid(x-i, y, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // left
        i = 1;
        while (y > 0) {
            if (isValid(x, y-i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // right
        i = 1;
        while (y < 7) {
            if (isValid(x, y+i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // left up
        i = 1;
        while (x > 0 && y > 0) {
            if (isValid(x-i, y-i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // right up
        i = 1;
        while (x > 0 && y < 7) {
            if (isValid(x-i, y+i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // left down
        i = 1;
        while (x < 7 && y > 0) {
            if (isValid(x+i, y-i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        // right down
        i = 1;
        while (x < 7 && y < 7) {
            if (isValid(x+i, y+i, getChessColor(), validMovement)) {
                break;
            }
            i++;
        }

        return validMovement;
    }

    private boolean isValid(int x, int y, ChessColor chessColor, List<ChessboardPoint> validMovement) {
        boolean isBreakUp = false;
        int result;

        ChessboardPoint p = new ChessboardPoint(x, y);
        if (isOnBoard(p)) {
            if (chessComponents[x][y] instanceof EmptySlotComponent) {
                result = 0;
            }else {
                if (chessComponents[x][y].getChessColor() == chessColor) {
                    result = 1;
                }else {
                    result = -1;
                }
            }
        }else {
            result = 1;
        }

        switch (result) {
            case -1:    // opposite side
                validMovement.add(p);
                isBreakUp = true;
                break;
            case 0:    // valid
                validMovement.add(p);
                break;
            case 1:    // own side or out of board
                isBreakUp = true;
                break;
        }

        return isBreakUp;
    }
}

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }

    public List check(List validMovement, int x, int y) {
        ChessboardPoint p = new ChessboardPoint(x, y);
        if (isOnBoard(p) && (chessComponents[x][y] instanceof EmptySlotComponent || chessComponents[x][y].getChessColor() != this.getChessColor())) {
            validMovement.add(p);
        }
        return validMovement;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> validMovement = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();

        validMovement = check(validMovement, x+1, y+2);
        validMovement = check(validMovement, x+1, y-2);
        validMovement = check(validMovement, x+2, y+1);
        validMovement = check(validMovement, x+2, y-1);
        validMovement = check(validMovement, x-1, y+2);
        validMovement = check(validMovement, x-1, y-2);
        validMovement = check(validMovement, x-2, y+1);
        validMovement = check(validMovement, x-2, y-1);

        return validMovement;
    }
}

class KingChessComponent extends ChessComponent {
    public KingChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> validMovement = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();

        int i = x-1, j = y-1;
        labelK0:
        while (i <= x+1) {
            labelK1:
            while (j <= y+1) {
                if (i == x && j == y) {
                    j++;
                    continue labelK1;
                }

                ChessboardPoint temp = new ChessboardPoint(i, j);
                boolean b1 = isOnBoard(temp);

                if (b1) {
                    ChessboardPoint p = new ChessboardPoint(i, j);

                    boolean b2 = chessComponents[i][j] instanceof EmptySlotComponent || chessComponents[i][j].getChessColor() != this.getChessColor();

                    if (b2) {
                        boolean b3 = true;

//                        int m = i-1, n = j-1;
//                        labelK2:
//                        while (m <= i+1) {
//                            labelK3:
//                            while (n <= j+1) {
//                                if (m == i && n == j) {
//                                    n++;
//                                    continue labelK3;
//                                };
//                                temp = new ChessboardPoint(m, n);
//                                if (isOnBoard(temp)) {
//                                    if (chessComponents[m][n] instanceof Knight && chessComponents[m][n].getChessColor() != this.getChessColor()) {
//                                        b3 = false;
//                                        break labelK2;
//                                    }
//                                }
//                                n++;
//                            }
//                            n = j-1;
//                            m++;
//                        }

                        if (b3) {
                            validMovement.add(p);
                        }
                    }
                }
                j++;
            }
            j = y-1;
            i++;
        }
        return validMovement;
    }
}

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> validMovement = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();

        if (this.getChessColor() == ChessColor.BLACK) {
            if (x == 1) {
                if (chessComponents[2][y] instanceof EmptySlotComponent) {
                    validMovement.add(new ChessboardPoint(2,y));
                    if (chessComponents[3][y] instanceof EmptySlotComponent) {
                        validMovement.add(new ChessboardPoint(3,y));
                    }
                }
            }

            ChessboardPoint temp = new ChessboardPoint(x+1, y+1);
            if (isOnBoard(temp) && !(chessComponents[x+1][y+1] instanceof EmptySlotComponent) && chessComponents[x+1][y+1].getChessColor() != this.getChessColor()) {
                validMovement.add(temp);
            }
            temp = new ChessboardPoint(x+1, y-1);
            if (isOnBoard(temp) && !(chessComponents[x+1][y-1] instanceof EmptySlotComponent) && chessComponents[x+1][y-1].getChessColor() != this.getChessColor()) {
                validMovement.add(temp);
            }
        }else {
            if (x == 6) {
                if (chessComponents[5][y] instanceof EmptySlotComponent) {
                    validMovement.add(new ChessboardPoint(5,y));
                    if (chessComponents[4][y] instanceof EmptySlotComponent) {
                        validMovement.add(new ChessboardPoint(4,y));
                    }
                }
            }

            ChessboardPoint temp = new ChessboardPoint(x-1, y+1);
            if (isOnBoard(temp) && !(chessComponents[x-1][y+1] instanceof EmptySlotComponent) && chessComponents[x-1][y+1].getChessColor() != this.getChessColor()) {
                validMovement.add(temp);
            }
            temp = new ChessboardPoint(x-1, y-1);
            if (isOnBoard(temp) && !(chessComponents[x-1][y-1] instanceof EmptySlotComponent) && chessComponents[x-1][y-1].getChessColor() != this.getChessColor()) {
                validMovement.add(temp);
            }
        }

        return validMovement;
    }
}
