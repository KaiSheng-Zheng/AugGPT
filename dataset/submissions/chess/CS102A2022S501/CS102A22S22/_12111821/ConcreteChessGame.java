import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer = ChessColor.WHITE;

    private ChessComponent create(int x, int y, ChessColor color, char c){
        if (c == 'K' || c == 'k')
            return new KingChessComponent(x, y, color, c);
        else if (c == 'Q' || c == 'q')
            return new QueenChessComponent(x, y, color, c);
        else if (c == 'R' || c == 'r')
            return new RookChessComponent(x, y, color, c);
        else if (c == 'B' || c == 'b')
            return new BishopChessComponent(x, y, color, c);
        else if (c == 'N' || c == 'n')
            return new KnightChessComponent(x, y, color, c);
        else if (c == 'P' || c == 'p')
            return new PawnChessComponent(x, y, color, c);
        else
            return new EmptySlotComponent(x, y, color, c);
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i = 0; i < 8; i++){
            String line = chessboard.get(i);
            for(int j = 0; j < 8; j++){
                char c = line.charAt(j);
                ChessColor cc = ChessColor.NONE;
                if(c - 'a' >= 0 && c - 'a' <= 25)
                    cc = ChessColor.WHITE;
                if(c - 'A' >= 0 && c - 'A' <= 25)
                    cc = ChessColor.BLACK;
                chessComponents[i][j] = create(i, j, cc, c);
            }
        }
        String line = chessboard.get(8);
        if(line.equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else
            currentPlayer = ChessColor.BLACK;
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
        String ans = "";
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                ans += String.valueOf(chessComponents[i][j].name);
            }
            if (i != 7)
                ans += "\n";
        }
        return ans;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String ans = "";
        String [] resC = {"K", "Q", "R", "B", "N", "P"};
        if(player.equals(ChessColor.WHITE))
            resC = new String[]{"k", "q", "r", "b", "n", "p"};
        int [] res = {1, 1, 2, 2, 2, 8};
        int [] count = new int[6];
        for(int i = 0; i < 6; i++){
            count[i] = 0;
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                char c = chessComponents[i][j].name;
                if(chessComponents[i][j].getChessColor().equals(player)){
                    if (c == 'K' || c == 'k')
                        count[0] ++;
                    else if (c == 'Q' || c == 'q')
                        count[1] ++;
                    else if (c == 'R' || c == 'r')
                        count[2] ++;
                    else if (c == 'B' || c == 'b')
                        count[3] ++;
                    else if (c == 'N' || c == 'n')
                        count[4] ++;
                    else if (c == 'P' || c == 'p')
                        count[5] ++;
                }
            }
        }

        for(int i = 0; i < 6; i++){
            int re = res[i] - count[i];
            if(re > 0){
                ans += resC[i] + " " + re + "\n";
            }
        }
        return ans;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> nodes = getCanMovePoints(chessComponents[sourceX][sourceY].getSource());
        ChessColor c = chessComponents[sourceX][sourceY].getChessColor();
        if(!this.currentPlayer.equals(c)) return false;
        for(ChessboardPoint e: nodes){
            if(e.getX() == targetX && e.getY() == targetY){
                ChessComponent tmp = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, ChessColor.NONE, '_');
                chessComponents[targetX][targetY] = tmp;
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                if(currentPlayer.equals(ChessColor.WHITE))
                    currentPlayer = ChessColor.BLACK;
                else
                    currentPlayer = ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX(), y = source.getY();
        chessComponents[x][y].setGame(this.chessComponents);
        List<ChessboardPoint> canMovePoints = chessComponents[x][y].canMoveTo();
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX() < o2.getX())
                    return -1;
                else if((o1.getX() > o2.getX()))
                    return 1;
                else{
                    if(o1.getY() < o2.getY())
                        return -1;
                    else if((o1.getY() > o2.getY()))
                        return 1;
                    else return 0;
                }
            }
        });
        return canMovePoints;
    }
}
