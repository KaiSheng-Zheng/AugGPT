import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer;


    public void loadChessGame(List<String> chessboard) {
        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++) {
                switch (chessboard.get(x).charAt(y)) {
                    case 'R': chessComponents[x][y] = new RookChessComponent(x, y, 'R', chessComponents); break;
                    case 'r': chessComponents[x][y] = new RookChessComponent(x, y, 'r', chessComponents); break;
                    case 'N': chessComponents[x][y] = new KnightChessComponent(x, y, 'N', chessComponents); break;
                    case 'n': chessComponents[x][y] = new KnightChessComponent(x, y, 'n', chessComponents); break;
                    case 'B': chessComponents[x][y] = new BishopChessComponent(x, y, 'B', chessComponents); break;
                    case 'b': chessComponents[x][y] = new BishopChessComponent(x, y, 'b', chessComponents); break;
                    case 'Q': chessComponents[x][y] = new QueenChessComponent(x, y, 'Q', chessComponents); break;
                    case 'q': chessComponents[x][y] = new QueenChessComponent(x, y, 'q', chessComponents); break;
                    case 'K': chessComponents[x][y] = new KingChessComponent(x, y, 'K', chessComponents); break;
                    case 'k': chessComponents[x][y] = new KingChessComponent(x, y, 'k', chessComponents); break;
                    case 'P': chessComponents[x][y] = new PawnChessComponent(x, y, 'P', chessComponents); break;
                    case 'p': chessComponents[x][y] = new PawnChessComponent(x, y, 'p', chessComponents); break;
                    case '_': chessComponents[x][y] = new EmptySlotComponent(x, y, '_', chessComponents);

                }
            }

        if (chessboard.get(8).charAt(0) == 'w')
            currentPlayer = ChessColor.WHITE;
        else if (chessboard.get(8).charAt(0) == 'b')
            currentPlayer = ChessColor.BLACK;

    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].chessColor == currentPlayer)
            for (ChessboardPoint Cbp : chessComponents[sourceX][sourceY].canMoveTo()) {
                if (Cbp.getX() == targetX && Cbp.getY() == targetY) {
                    
                    char k = (chessComponents[sourceX][sourceY].chessColor == ChessColor.WHITE) ? 'k' : 'K';
                    char q = (chessComponents[sourceX][sourceY].chessColor == ChessColor.WHITE) ? 'q' : 'Q';
                    char b = (chessComponents[sourceX][sourceY].chessColor == ChessColor.WHITE) ? 'b' : 'B';
                    char n = (chessComponents[sourceX][sourceY].chessColor == ChessColor.WHITE) ? 'n' : 'N';
                    char r = (chessComponents[sourceX][sourceY].chessColor == ChessColor.WHITE) ? 'r' : 'R';
                    char p = (chessComponents[sourceX][sourceY].chessColor == ChessColor.WHITE) ? 'p' : 'P';
                    
                    if (chessComponents[sourceX][sourceY] instanceof KingChessComponent)
                        chessComponents[targetX][targetY] = new KingChessComponent(targetX, targetY, k, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof QueenChessComponent)
                        chessComponents[targetX][targetY] = new QueenChessComponent(targetX, targetY, q, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof BishopChessComponent)
                        chessComponents[targetX][targetY] = new BishopChessComponent(targetX, targetY, b, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof KnightChessComponent)
                        chessComponents[targetX][targetY] = new KnightChessComponent(targetX, targetY, n, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof RookChessComponent)
                        chessComponents[targetX][targetY] = new RookChessComponent(targetX, targetY, r, chessComponents);
                    else if (chessComponents[sourceX][sourceY] instanceof PawnChessComponent)
                        chessComponents[targetX][targetY] = new PawnChessComponent(targetX, targetY, p, chessComponents);
                    
//                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, '_', chessComponents);
                    currentPlayer = (currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE);
                    return true;
                }
            }
        return false;
    }





    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                graph.append(chessComponents[x][y].name);
            }
            graph.append("\n");
        }
        return graph.toString();
    }




    public String getCapturedChess(ChessColor player) {
        StringBuilder lost = new StringBuilder();
        int kl = 1;
        int ql = 1;
        int rl = 2;
        int bl = 2;
        int nl = 2;
        int pl = 8;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++)
                if (chessComponents[x][y].chessColor == player) {
                    if (chessComponents[x][y] instanceof KingChessComponent)
                        kl--;
                    else if (chessComponents[x][y] instanceof QueenChessComponent)
                        ql--;
                    else if (chessComponents[x][y] instanceof RookChessComponent)
                        rl--;
                    else if (chessComponents[x][y] instanceof BishopChessComponent)
                        bl--;
                    else if (chessComponents[x][y] instanceof KnightChessComponent)
                        nl--;
                    else if (chessComponents[x][y] instanceof PawnChessComponent)
                        pl--;
                }
        }

        if (kl > 0) {
            lost.append((player == ChessColor.WHITE) ? 'k' : 'K');
            lost.append(" ").append(kl).append("\n");
        }
        if (ql > 0) {
            lost.append((player == ChessColor.WHITE) ? 'q' : 'Q');
            lost.append(" ").append(ql).append("\n");
        }
        if (rl > 0) {
            lost.append((player == ChessColor.WHITE) ? 'r' : 'R');
            lost.append(" ").append(rl).append("\n");
        }
        if (bl > 0) {
            lost.append((player == ChessColor.WHITE) ? 'b' : 'B');
            lost.append(" ").append(bl).append("\n");
        }
        if (nl > 0) {
            lost.append((player == ChessColor.WHITE) ? 'n' : 'N');
            lost.append(" ").append(nl).append("\n");
        }
        if (pl > 0) {
            lost.append((player == ChessColor.WHITE) ? 'p' : 'P');
            lost.append(" ").append(pl).append("\n");
        }


        return lost.toString();
    }


    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }



    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }




}
