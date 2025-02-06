import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.BLACK,this);
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.WHITE,this);
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.BLACK,this);
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.WHITE,this);
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.BLACK,this);
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.WHITE,this);
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.BLACK,this);
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.WHITE,this);
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.BLACK,this);
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.WHITE,this);
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.BLACK,this);
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.WHITE,this);
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(chessboard.get(i).charAt(j), new ChessboardPoint(i, j), ChessColor.NONE,this);
                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        ArrayList<String> chessboard = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            StringBuilder stb = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                stb.append(chessComponents[i][j]);
            }
            chessboard.add(stb.toString());
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                chessboard.get(0), chessboard.get(1), chessboard.get(2), chessboard.get(3),
                chessboard.get(4), chessboard.get(5), chessboard.get(6), chessboard.get(7));
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        ArrayList<ChessComponent> capturedChess = new ArrayList<>();
        int kingCnt = 0;
        int queenCnt = 0;
        int bishopCnt = 0;
        int knightCnt = 0;
        int rookCnt = 0;
        int pawnCnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == player) {
                    if (chessComponents[i][j].getName() == 'K' || chessComponents[i][j].getName() == 'k') {
                        kingCnt++;
                        break;
                    }
                    if (chessComponents[i][j].getName() == 'Q' || chessComponents[i][j].getName() == 'q') {
                        queenCnt++;
                        break;
                    }
                    if (chessComponents[i][j].getName() == 'B' || chessComponents[i][j].getName() == 'b') {
                        bishopCnt++;
                        break;
                    }
                    if (chessComponents[i][j].getName() == 'N' || chessComponents[i][j].getName() == 'n') {
                        knightCnt++;
                        break;
                    }
                    if (chessComponents[i][j].getName() == 'R' || chessComponents[i][j].getName() == 'r') {
                        rookCnt++;
                        break;
                    }
                    if (chessComponents[i][j].getName() == 'P' || chessComponents[i][j].getName() == 'p') {
                        pawnCnt++;
                        break;
                    }
                }
            }
        }

        if (kingCnt == 0) {
            capturedChess.add(new KingChessComponent(player,kingCnt));
        }
        if (queenCnt == 0) {
            capturedChess.add(new QueenChessComponent(player,queenCnt));
        }
        if (0<=rookCnt && rookCnt<=1) {
            capturedChess.add(new RookChessComponent(player,rookCnt));
        }
        if (0<=bishopCnt && bishopCnt <= 1) {
            capturedChess.add(new BishopChessComponent(player,bishopCnt));
        }
        if (0<=knightCnt && knightCnt <= 1) {
            capturedChess.add(new KnightChessComponent(player,kingCnt));
        }
        if (0<=pawnCnt && pawnCnt <=7) {
            capturedChess.add(new PawnChessComponent(player,pawnCnt));
        }

        StringBuilder stbCapturedChess = new StringBuilder();
        for (int i = 0; i < capturedChess.size(); i++) {
            if(i != capturedChess.size()-1){
                stbCapturedChess.append(capturedChess.get(i).name +" "+capturedChess.get(i).getCapturedCnt());
                stbCapturedChess.append("\n");
            } else{
                stbCapturedChess.append(capturedChess.get(i).name + " "+capturedChess.get(i).getCapturedCnt());
            }

        }
        return stbCapturedChess.toString();

    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor() == this.currentPlayer){
            if(getCanMovePoints(new ChessboardPoint(sourceX,sourceY)).contains(new ChessboardPoint(targetX,targetY))){
                int x1,y1;
                x1 = targetX;
                y1 = targetY;
                chessComponents[x1][y1] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,this);
                currentPlayer = swapColor(currentPlayer);
                return true;
            }
        }
        return false;
    }
    public ChessColor swapColor(ChessColor color){
        if(color == ChessColor.BLACK){
            return ChessColor.WHITE;
        }
        if(color == ChessColor.WHITE){
            return ChessColor.BLACK;
        }
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints (ChessboardPoint source){
        List<ChessboardPoint> re = chessComponents[source.getX()][source.getY()].canMoveTo();
        Collections.sort(re,new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX() !=o2.getX()){
                    return o1.getX()-o2.getX();
                }
                return o1.getY()-o2.getY();
            }
        });
        return re;
    }

}
