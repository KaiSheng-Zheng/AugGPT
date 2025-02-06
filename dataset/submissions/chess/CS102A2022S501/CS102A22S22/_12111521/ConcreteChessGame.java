import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size()-1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,'R');
                    case 'r' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,'r');
                    case 'K' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,'K');
                    case 'k' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,'k');
                    case 'Q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,'Q');
                    case 'q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,'q');
                    case 'B' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,'B');
                    case 'b' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,'b');
                    case 'N' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,'N');
                    case 'n' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,'n');
                    case 'P' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK,'P');
                    case 'p' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE,'p');
                    case '_' -> chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE,'_');
                }
            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else if(chessboard.get(8).equals("b")){
            currentPlayer = ChessColor.BLACK;
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
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                switch (chessComponents[i][j].name) {
                    case 'R' -> a.append("R");
                    case 'r' -> a.append("r");
                    case 'K' -> a.append("K");
                    case 'k' -> a.append("k");
                    case 'Q' -> a.append("Q");
                    case 'q' -> a.append("q");
                    case 'B' -> a.append("B");
                    case 'b' -> a.append("b");
                    case 'N' -> a.append("N");
                    case 'n' -> a.append("n");
                    case 'P' -> a.append("P");
                    case 'p' -> a.append("p");
                    case '_' -> a.append("_");
                }
            }
            if(i < 7){
                a.append("\n");
            }
        }
        return a.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int R = 0;
        int r = 0;
        int K = 0;
        int k = 0;
        int Q = 0;
        int q = 0;
        int B = 0;
        int b = 0;
        int N = 0;
        int n = 0;
        int P = 0;
        int p = 0;
        StringBuilder a = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'R' -> R++;
                        case 'K' -> K++;
                        case 'Q' -> Q++;
                        case 'B' -> B++;
                        case 'N' -> N++;
                        case 'P' -> P++;
                    }
                }
            }
            if (1 - K != 0) {
                a.append("K ");
                a.append(1 - K);
                a.append("\n");
            }
            if (1 - Q != 0) {
                a.append("Q ");
                a.append(1 - Q);
                a.append("\n");
            }
            if (2 - R != 0) {
                a.append("R ");
                a.append(2 - R);
                a.append("\n");
            }
            if (2 - B != 0) {
                a.append("B ");
                a.append(2 - B);
                a.append("\n");
            }
            if (2 - N != 0) {
                a.append("N ");
                a.append(2 - N);
                a.append("\n");
            }
            if (8 - P != 0) {
                a.append("P ");
                a.append(8 - P);
                a.append("\n");
            }
            return a.toString();
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'r' -> r++;
                        case 'k' -> k++;
                        case 'q' -> q++;
                        case 'b' -> b++;
                        case 'n' -> n++;
                        case 'p' -> p++;
                    }
                }
            }
            if (1 - k != 0) {
                a.append("k ");
                a.append(1 - k);
                a.append("\n");
            }
            if (1 - q != 0) {
                a.append("q ");
                a.append(1 - q);
                a.append("\n");
            }
            if (2 - r != 0) {
                a.append("r ");
                a.append(2 - r);
                a.append("\n");
            }
            if (2 - b != 0) {
                a.append("b ");
                a.append(2 - b);
                a.append("\n");
            }
            if (2 - n != 0) {
                a.append("n ");
                a.append(2 - n);
                a.append("\n");
            }
            if (8 - p != 0) {
                a.append("p ");
                a.append(8 - p);
                a.append("\n");
            }
            return a.toString();
        } else {
            return null;
        }

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessboard(chessComponents);
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setChessboard(chessComponents);
        ChessboardPoint destination = new ChessboardPoint(targetX,targetY);
        if(targetX<8 &&targetY <8 &&targetX >=0 && targetY>=0 && !(targetX ==sourceX && targetY ==sourceY)
                && getCurrentPlayer() == chessComponents[sourceX][sourceY].getChessColor()
                && chessComponents[sourceX][sourceY].canMove(chessComponents,destination)){
            if(chessComponents[sourceX][sourceY] instanceof PawnChessComponent){
                chessComponents[sourceX][sourceY].setFirst(chessComponents[sourceX][sourceY].first+1);
            }
            chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] =
                    new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE,'_');
            if(currentPlayer == ChessColor.WHITE){
                currentPlayer = ChessColor.BLACK;
            }else if(currentPlayer == ChessColor.BLACK){
                currentPlayer = ChessColor.WHITE;
            }
            return true;
        }else{
            return false;
        }
    }
}
