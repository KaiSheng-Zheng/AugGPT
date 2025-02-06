import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    protected ChessComponent[][] chess;
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChess() {
        return chess;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public ConcreteChessGame(ChessComponent[][] chess) {
        this.chess = chess;
    }

    public void setChess(ChessComponent[][] chess) {
        this.chess = chess;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

 public boolean contain(List<ChessboardPoint> list,ChessboardPoint chessboardPoint) {
     for (int i = 0; i < list.size(); i++) {
         if ((chessboardPoint).toString().equals(list.get(i).toString())) return true;
     }return false;
 }
    public void loadChessGame(List<String> chessboard) {
        if (Objects.equals(chessboard.get(8), "w")) {
            setCurrentPlayer(ChessColor.WHITE);
        } else if (Objects.equals(chessboard.get(8), "b")) setCurrentPlayer(ChessColor.BLACK);


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ('R' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('R');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('r' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('r');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('N' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('N');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('n' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('n');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('B' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('B');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('b' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('b');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('Q' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('Q');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('q' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('q');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('K' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('K');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('k' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('k');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('P' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].setName('P');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('p' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].setName('p');
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                } else if ('_' == chessboard.get(i).charAt(j)) {
                    this.chessComponents[i][j] = new EmptySlotComponent();
                    this.chessComponents[i][j].setChessboard(this.chessComponents);
                    this.chessComponents[i][j].setName('_');
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].getName());
            }
            sb.append("\n");
        }
        for (int i = 0; i < 8; i++) {
            sb.append(chessComponents[7][i]);
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int CR = 2, cr = 2, CB = 2, cb = 2, CK = 1, ck = 1, CQ = 1, cq = 1, CP = 8, cp = 8, CN = 2, cn = 2;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    CR--;
                } else if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    cr--;
                } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    CQ--;
                } else if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    cq--;
                } else if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    CK--;
                } else if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    ck--;
                } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    CN--;
                } else if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    cn--;
                } else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    CB--;
                } else if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    cb--;
                } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                    CP--;
                } else if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                    cp--;
                }
            }
        }
        if (player == ChessColor.BLACK) {
            if (CK > 0) {
                stringBuilder.append("K ");
                stringBuilder.append(CK);
                stringBuilder.append("\n");
            }
            if (CQ > 0) {
                stringBuilder.append("Q ").append(CQ).append("\n");
            }
            if (CR > 0) {
                stringBuilder.append("R ").append(CR).append("\n");
            }
            if (CB > 0) {
                stringBuilder.append("B ").append(CB).append("\n");
            }
            if (CN > 0) {
                stringBuilder.append("N ").append(CN).append("\n");
            }
            if (CP > 0) {
                stringBuilder.append("P ").append(CP).append("\n");
            }
        } else {
            if (ck > 0) {
                stringBuilder.append("k ").append(ck).append("\n");
            }
            if (cq > 0) {
                stringBuilder.append("q ").append(cq).append("\n");
            }
            if (cr > 0) {
                stringBuilder.append("r ").append(cr).append("\n");
            }
            if (cb > 0) {
                stringBuilder.append("b ").append(cb).append("\n");
            }
            if (cn > 0) {
                stringBuilder.append("n ").append(cn).append("\n");
            }
            if (cp > 0) {
                stringBuilder.append("p ").append(cp).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        return chess.canMoveTo();

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX <= 7 && sourceX >= 0 && sourceY <= 7 && sourceY >= 0 && targetX <= 7 && targetX >= 0 && targetY <= 7 && targetY >= 0) {
            if (this.chessComponents[sourceX][sourceY].getChessColor() == this.currentPlayer) {
                ChessboardPoint target = new ChessboardPoint(targetX, targetY);
                ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
                List<ChessboardPoint> canMovePoints = getCanMovePoints(source);
                if (canMovePoints==null)return false;
                else if (contain(canMovePoints,target)) {
                    this.chessComponents[target.getX()][target.getY()] =chessComponents[sourceX][sourceY];
                    this.chessComponents[source.getX()][source.getY()] = new EmptySlotComponent();
                    this.chessComponents[source.getX()][source.getY()].setChessColor(ChessColor.NONE);
                    this.chessComponents[source.getX()][source.getY()].setName('_');
                    this.chessComponents[source.getX()][source.getY()].setSource(new ChessboardPoint(source.getX(),source.getY()));
                    this.chessComponents[target.getX()][target.getY()].setChessboard(chessComponents);
                     this.chessComponents[target.getX()][target.getY()].setSource(new ChessboardPoint(target.getX(),target.getY()));
                    this.chessComponents[source.getX()][source.getY()].setChessboard(chessComponents);
                    currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
                    return true;
                } else return false;
            } else return false;


        } else return false;
    }
}