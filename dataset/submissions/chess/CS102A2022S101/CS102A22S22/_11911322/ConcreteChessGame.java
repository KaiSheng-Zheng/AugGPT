import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;
    private ChessColor upperPlayerAt0 = ChessColor.BLACK;
    // default black at 0 and white at 7

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'K' :
                        this.chessComponents[i][j] = new KingChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName('K');
                        break;
                    case 'Q' :
                        this.chessComponents[i][j] = new QueenChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName('Q');
                        break;
                    case 'R' :
                        this.chessComponents[i][j] = new RookChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName('R');
                        break;
                    case 'B' :
                        this.chessComponents[i][j] = new BishopChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName('B');
                        break;
                    case 'N' :
                        this.chessComponents[i][j] = new KnightChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName('N');
                        break;
                    case 'P' :
                        this.chessComponents[i][j] = new PawnChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        this.chessComponents[i][j].setName('P');
                        if (upperPlayerAt0.equals(ChessColor.BLACK)) {
                            if (i != 1) this.chessComponents[i][j].Moved();
                        } else {
                            if (i != 6) this.chessComponents[i][j].Moved();
                        }
                        break;
                    case 'k' :
                        this.chessComponents[i][j] = new KingChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName('k');
                        break;
                    case 'q' :
                        this.chessComponents[i][j] = new QueenChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName('q');
                        break;
                    case 'r' :
                        this.chessComponents[i][j] = new RookChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName('r');
                        break;
                    case 'b' :
                        this.chessComponents[i][j] = new BishopChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName('b');
                        break;
                    case 'n' :
                        this.chessComponents[i][j] = new KnightChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName('n');
                        break;
                    case 'p' :
                        this.chessComponents[i][j] = new PawnChessComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        this.chessComponents[i][j].setName('p');
                        if (upperPlayerAt0.equals(ChessColor.BLACK)) {
                            if (i != 6) this.chessComponents[i][j].Moved();
                        } else {
                            if (i != 1) this.chessComponents[i][j].Moved();
                        }
                        break;
                    default :
                        this.chessComponents[i][j] = new EmptySlotComponent();
                        this.chessComponents[i][j].setChessColor(ChessColor.NONE);
                        this.chessComponents[i][j].setName('_');
                        break;
                }
                this.chessComponents[i][j].setSource(new ChessboardPoint(i,j));
            }
            switch (chessboard.get(8)) {
                case "w" :
                    setCurrentPlayer(ChessColor.WHITE);
                    break;
                case "b" :
                    setCurrentPlayer(ChessColor.BLACK);
                    break;
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if (x < 0 || x > 7) return null;
        if (y < 0 || y > 7) return null;
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String[] Chessboard = new String[9];
        for (int i = 0; i < 8; i++) {
            char[] Line = new char[8];
            for (int j = 0; j < 8; j++) {
                Line[j] = getChess(i,j).getName();
            }
            Chessboard[i] = String.valueOf(Line);
        }
        if (getCurrentPlayer() == ChessColor.WHITE) {
            Chessboard[8] = "w";
        } else if (getCurrentPlayer() == ChessColor.BLACK) {
            Chessboard[8] = "b";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(Chessboard[i]);
            if (i < 7) stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] chessNumber = new int[]{1,1,2,2,2,8};
        char[] chessName = new char[]{'k','q','r','b','n','p'};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getChess(i,j).getChessColor() != player) {
                    continue;
                }
                switch (Character.toLowerCase(getChess(i,j).getName())) {
                    case 'k' :
                        chessNumber[0]--;
                        break;
                    case 'q' :
                        chessNumber[1]--;
                        break;
                    case 'r' :
                        chessNumber[2]--;
                        break;
                    case 'b' :
                        chessNumber[3]--;
                        break;
                    case 'n' :
                        chessNumber[4]--;
                        break;
                    case 'p' :
                        chessNumber[5]--;
                        break;
                }
            }
        }
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 6; i++) {
                chessName[i] = Character.toUpperCase(chessName[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (chessNumber[i] != 0) {
                stringBuilder.append(chessName[i]);
                stringBuilder.append(" ");
                stringBuilder.append(chessNumber[i]);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent source = this.getChess(sourceX,sourceY);
        source.updateConcreteChessGame(this);
        source.setSource(new ChessboardPoint(sourceX,sourceY));
        if (!source.getChessColor().equals(this.currentPlayer)) return false;
//        boolean canMoveTo = source.canMoveTo().contains(new ChessboardPoint(targetX,targetY));
        boolean canMoveTo = false;
        for (ChessboardPoint point : source.canMoveTo()) {
            if (point.getX() != targetX) continue;
            if (point.getY() != targetY) continue;
            canMoveTo = true;
            break;
        }
        if (canMoveTo) {
            moveChessComponents(targetX,targetY,source);
            moveChessComponents(sourceX,sourceY,new EmptySlotComponent());
            if (this.currentPlayer.equals(ChessColor.WHITE)) {
                setCurrentPlayer(ChessColor.BLACK);
            } else if (this.currentPlayer.equals(ChessColor.BLACK)) {
                setCurrentPlayer(ChessColor.WHITE);
            }
        }
        return canMoveTo;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent sourceChess = getChess(source.getX(),source.getY());
        sourceChess.updateConcreteChessGame(this);
        List<ChessboardPoint> canMovePoints = sourceChess.canMoveTo();
//        if (canMovePoints.isEmpty()) return canMovePoints;
        // sort by x-y ascending order
        int Length = canMovePoints.size();
        for (int i = 0; i < Length-1; i++) {
            for (int j = 0; j < Length-i-1; j++) {
                if (canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()) {
                    Collections.swap(canMovePoints,j,j+1);
                } else if (canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX()) {
                    if (canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()) {
                        Collections.swap(canMovePoints,j,j+1);
                    }
                }
            }
        }
        return canMovePoints;
    }

    public void setCurrentPlayer(ChessColor chessColor) {
        this.currentPlayer = chessColor;
    }

    public void moveChessComponents(int x, int y, ChessComponent source) {
        this.chessComponents[x][y] = source;
        this.chessComponents[x][y].setSource(new ChessboardPoint(x,y));
        this.chessComponents[x][y].Moved();
    }

    public ChessComponent[][] getChessComponents() {
        return this.chessComponents;
    }

    public ChessColor getUpperPlayerAt0() {
        return upperPlayerAt0;
    }
}
