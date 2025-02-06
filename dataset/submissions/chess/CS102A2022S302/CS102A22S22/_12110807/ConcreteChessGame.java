import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame(){}

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer){
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'R',this);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'N',this);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'B',this);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'Q',this);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'K',this);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j),'P',this);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j),'_',this);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'r',this);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'n',this);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'b',this);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'q',  this);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'k',this);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j),'p',this);
                    default:break;
                }
            }
        }
        if (chessboard.get(chessboard.size() - 1).equals("w")){
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(chessboard.size() - 1).equals("b")){
            currentPlayer = ChessColor.BLACK;
        } else {
            currentPlayer = ChessColor.WHITE;
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

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                if (chessComponents[i][j] instanceof RookChessComponent){
                    if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                        s.append("R");
                    } else {
                        s.append("r");
                    }
                }
                if (chessComponents[i][j] instanceof KingChessComponent){
                    if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                        s.append("K");
                    } else {
                        s.append("k");
                    }
                }
                if (chessComponents[i][j] instanceof KnightChessComponent){
                    if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                        s.append("N");
                    } else {
                        s.append("n");
                    }
                }
                if (chessComponents[i][j] instanceof BishopChessComponent){
                    if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                        s.append("B");
                    } else {
                        s.append("b");
                    }
                }
                if (chessComponents[i][j] instanceof PawnChessComponent){
                    if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                        s.append("P");
                    } else {
                        s.append("p");
                    }
                }
                if (chessComponents[i][j] instanceof QueenChessComponent){
                    if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                        s.append("Q");
                    } else {
                        s.append("q");
                    }
                }
                if (chessComponents[i][j] instanceof EmptySlotComponent){
                    s.append("_");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int r = 0,p = 0,q = 0,k = 0,n = 0,b = 0;
        StringBuilder s = new StringBuilder("");
        if (player == ChessColor.BLACK){
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    if (chessComponents[i][j] instanceof RookChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                            r++;
                        }
                    }
                    if (chessComponents[i][j] instanceof PawnChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                            p++;
                        }
                    }
                    if (chessComponents[i][j] instanceof KingChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                            k++;
                        }
                    }
                    if (chessComponents[i][j] instanceof QueenChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                            q++;
                        }
                    }
                    if (chessComponents[i][j] instanceof BishopChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                            b++;
                        }
                    }
                    if (chessComponents[i][j] instanceof KnightChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.BLACK){
                            n++;
                        }
                    }
                }
            }
            //King>Queen>Rooks>Bishops>Knights>Pawns
            if (k != 1){
                s.append("K ");
                s.append(1 - k);
                s.append("\n");
            }
            if (q != 1){
                s.append("Q ");
                s.append(1 - q);
                s.append("\n");
            }
            if (r != 2){
                s.append("R ");
                s.append(2 - r);
                s.append("\n");
            }
            if (b != 2){
                s.append("B ");
                s.append(2 - b);
                s.append("\n");
            }
            if (n != 2){
                s.append("N ");
                s.append(2 - n);
                s.append("\n");
            }
            if (p != 8){
                s.append("P ");
                s.append(8 - p);
                s.append("\n");
            }
            return s.toString();

        } else if (player == ChessColor.WHITE){
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    if (chessComponents[i][j] instanceof RookChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                            r++;
                        }
                    }
                    if (chessComponents[i][j] instanceof PawnChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                            p++;
                        }
                    }
                    if (chessComponents[i][j] instanceof KingChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                            k++;
                        }
                    }
                    if (chessComponents[i][j] instanceof QueenChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                            q++;
                        }
                    }
                    if (chessComponents[i][j] instanceof BishopChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                            b++;
                        }
                    }
                    if (chessComponents[i][j] instanceof KnightChessComponent){
                        if (chessComponents[i][j].getChessColor() == ChessColor.WHITE){
                            n++;
                        }
                    }
                }
            }
            if (k != 1){
                s.append("k ");
                s.append(1 - k);
                s.append("\n");
            }
            if (q != 1){
                s.append("q ");
                s.append(1 - q);
                s.append("\n");
            }
            if (r != 2){
                s.append("r ");
                s.append(2 - r);
                s.append("\n");
            }
            if (b != 2){
                s.append("b ");
                s.append(2 - b);
                s.append("\n");
            }
            if (n != 2){
                s.append("n ");
                s.append(2 - n);
                s.append("\n");
            }
            if (p != 8){
                s.append("p ");
                s.append(8 - p);
                s.append("\n");
            }
            return s.toString();
        } else {
            return "";
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order


        for (int j = 0; j < canMovePoints.size(); j++) {
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                if (canMovePoints.get(i).getX() > canMovePoints.get(i + 1).getX() ){
                    ChessboardPoint tem = canMovePoints.get(i);
                    canMovePoints.set(i,canMovePoints.get(i + 1));
                    canMovePoints.set(i + 1, tem);
                } else if (canMovePoints.get(i).getX() == canMovePoints.get(i + 1).getX()){
                    if (canMovePoints.get(i).getY() > canMovePoints.get(i + 1).getY()){
                        ChessboardPoint tem = canMovePoints.get(i);
                        canMovePoints.set(i,canMovePoints.get(i + 1));
                        canMovePoints.set(i + 1, tem);
                    }
                }
            }
        }

        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        boolean contain = false;
        for (int i = 0; i < getCanMovePoints(source).size(); i++) {
            if (
                    getCanMovePoints(source).get(i).getX() == targetX
                    && getCanMovePoints(source).get(i).getY() == targetY
            ){
                contain = true;
                break;
            }
        }

        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer){
            if (contain){
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(sourceX,sourceY));
                ChessComponent tem = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = chessComponents[targetX][targetY];
                chessComponents[targetX][targetY] = tem;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE,
                        new ChessboardPoint(sourceX,sourceY),
                        '_',this
                        );

                if (currentPlayer == ChessColor.BLACK){
                    setCurrentPlayer(ChessColor.WHITE);
                } else {
                    setCurrentPlayer(ChessColor.BLACK);
                }

                return true;
            }
        }
        return false;
    }

}
