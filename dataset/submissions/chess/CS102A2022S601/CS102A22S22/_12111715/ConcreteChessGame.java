import java.util.*;
public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    List<String> chessboard;
    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char a = chessboard.get(i).charAt(j);
                if (a == 'K' || a == 'k') {
                    if (a == 'K')
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    else
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);}
                else if (a == 'Q' || a == 'q') {
                    if (a == 'Q')
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    if (a == 'q')
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);}
                else if (a == 'R' || a == 'r') {
                    if (a == 'R')
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    if (a == 'r')
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);}
                else if (a == 'B' || a == 'b') {
                    if (a == 'B')
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    if (a == 'b')
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);}
                else if (a == 'N' || a == 'n') {
                    if (a == 'N')
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    if (a == 'n')
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);}
                else if (a == 'P' || a == 'p') {
                    if (a == 'P')
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j), chessComponents);
                    if (a == 'p')
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j), chessComponents);}
                else if (a == '_') {
                    chessComponents[i][j] = new EmptySlotComponent();
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        } else currentPlayer = ChessColor.WHITE;
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
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            s.append(chessboard.get(i) + "\n");
        }
        return String.valueOf(s);
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        int k = 1;
        int q = 1;
        int r = 2;
        int b = 2;
        int n = 2;
        int p = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent c = chessComponents[i][j];
                if (c.getChessColor() == player) {
                    if (c instanceof KingChessComponent) k--;
                    if (c instanceof QueenChessComponent) q--;
                    if (c instanceof RookChessComponent) r--;
                    if (c instanceof BishopChessComponent) b--;
                    if (c instanceof KnightChessComponent) n--;
                    if (c instanceof PawnChessComponent) p--;
                }
            }
        }
        StringBuffer s = new StringBuffer();
        if (k > 0) {
            if (player == ChessColor.BLACK) s.append("K " + k + "\n");
            else s.append("k " + k + "\n");
        }
        if (q > 0) {
            if (player == ChessColor.BLACK) s.append("Q " + q + "\n");
            else s.append("q " + q + "\n");
        }
        if (r > 0) {
            if (player == ChessColor.BLACK) s.append("R " + r + "\n");
            else s.append("r " + r + "\n");
        }
        if (b > 0) {
            if (player == ChessColor.BLACK) s.append("B " + b + "\n");
            else s.append("b " + b + "\n");
        }
        if (n > 0) {
            if (player == ChessColor.BLACK) s.append("N " + n + "\n");
            else s.append("n " + n + "\n");
        }
        if (p > 0) {
            if (player == ChessColor.BLACK) s.append("P " + p + "\n");
            else s.append("p " + p + "\n");
        }
        return String.valueOf(s);
    }
    public static boolean check(ChessComponent[][] com,int x1,int y1,int x2,int y2) {
        if (com[x1][y1]instanceof RookChessComponent){
            if(x1==x2) {
                for(int i=Math.max(y1,y2)-1;i>=(Math.min(y1,y2)+1);i--) {
                    if(com[x1][i] instanceof EmptySlotComponent){}
                    else return true;}}
            if(y1==y2) {
                for(int i=Math.max(x1,x2)-1;i>=(Math.min(x1,x2)+1);i--) {
                    if(com[i][y1] instanceof EmptySlotComponent){}
                    else return true;}}}
        if (com[x1][y1]instanceof BishopChessComponent){
            if(x2>x1) {
                if(y2>y1) {
                    for(int i=1;i<=(y2-y1-1);i++) {
                        if(com[x1+i][y1+i] instanceof EmptySlotComponent){}
                        else return true;}}
                if(y2<y1) {
                for(int i=1;i<=(y1-y2-1);i++) {
                    if(com[x1+i][y1-i] instanceof EmptySlotComponent){}
                    else return true;}}}
            if(x1>x2) {
                if(y2>y1) {
                    for(int i=1;i<=(y2-y1-1);i++) {
                        if(com[x1-i][y1+i] instanceof EmptySlotComponent){}
                        else return true;}}
                if(y2<y1) {
                    for(int i=1;i<=(y1-y2-1);i++) {
                        if(com[x1-i][y1-i] instanceof EmptySlotComponent){}
                        else return true;}}}}
        if (com[x1][y1]instanceof QueenChessComponent){
            if(x1==x2) {
                for(int i=Math.max(y1,y2)-1;i>=(Math.min(y1,y2)+1);i--) {
                    if(com[x1][i] instanceof EmptySlotComponent){}
                    else return true;}}
            if(y1==y2) {
                for(int i=Math.max(x1,x2)-1;i>=(Math.min(x1,x2)+1);i--) {
                    if(com[i][y1] instanceof EmptySlotComponent){}
                    else return true;}}
            if(x2>x1) {
                if(y2>y1) {
                    for(int i=1;i<=(y2-y1-1);i++) {
                        if(com[x1+i][y1+i] instanceof EmptySlotComponent){}
                        else return true;}}
                if(y2<y1) {
                    for(int i=1;i<=(y1-y2-1);i++) {
                        if(com[x1+i][y1-i] instanceof EmptySlotComponent){}
                        else return true;}}}
            if(x1>x2) {
                if(y2>y1) {
                    for(int i=1;i<=(y2-y1-1);i++) {
                        if(com[x1-i][y1+i] instanceof EmptySlotComponent){}
                        else return true;}}
                if(y2<y1) {
                    for(int i=1;i<=(y1-y2-1);i++) {
                        if(com[x1-i][y1-i] instanceof EmptySlotComponent){}
                        else return true;}}}}
       return false;
    }
    public static void move(ChessboardPoint src, ChessComponent[][] com, List<ChessboardPoint> can) {
        for (int i = can.size() - 1; i >= 0; i--) {
            if (com[can.get(i).getX()][can.get(i).getY()].getChessColor() == com[src.getX()][src.getY()].getChessColor()) {
                can.remove(i);
            }
        }
        if (com[src.getX()][src.getY()] instanceof QueenChessComponent || com[src.getX()][src.getY()] instanceof BishopChessComponent || com[src.getX()][src.getY()] instanceof RookChessComponent) {
            for(int i=can.size()-1;i>=0;i--) {
                if(check(com,src.getX(),src.getY(),can.get(i).getX(),can.get(i).getY())){
                    can.remove(i);}}}
        if(com[src.getX()][src.getY()] instanceof PawnChessComponent){
            for(int i=can.size()-1;i>=0;i--){
                if(can.get(i).getY()!=src.getY() && com[can.get(i).getX()][can.get(i).getY()] instanceof EmptySlotComponent)
                {can.remove(i);continue;}
                if(can.get(i).getY()==src.getY() && !(com[can.get(i).getX()][can.get(i).getY()] instanceof EmptySlotComponent))
                {can.remove(i);}}
            }
        Collections.sort(can, (o1, o2) -> {
            if(o1.getX()>o2.getX()) return 1;
            else if(o1.getX()<o2.getX()) return -1;
            else if(o1.getY()>o2.getY()) return 1;
            else if(o1.getY()<o2.getY()) return -1;
            return 0;
        });
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
    if (sourceX==targetX&&sourceY==targetY)return false;
    if (currentPlayer!=chessComponents[sourceX][sourceY].getChessColor())return false;
    for(int i=chessComponents[sourceX][sourceY].canMoveTo().size()-1;i>=0;i--){
        if(chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()==targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY()==targetY)
        {break;}
        else if(i==0) {return false;}}
    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(targetX,targetY));
    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
    chessComponents[sourceX][sourceY]=new EmptySlotComponent();
    if(currentPlayer==ChessColor.WHITE)currentPlayer=ChessColor.BLACK;
    else currentPlayer=ChessColor.WHITE;
    return true;
}
}
