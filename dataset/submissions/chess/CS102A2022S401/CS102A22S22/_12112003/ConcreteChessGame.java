import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][]chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard){
        for(int u=0;u<=7;u++){
            for(int v=0;v<=7;v++) {
                switch (chessboard.get(u).charAt(v)){
                    case 'R':
                        this.chessComponents[u][v]=new RookChessComponent(new ChessboardPoint(u,v),ChessColor.BLACK,'R');
                        break;
                    case 'N':
                        this.chessComponents[u][v]=new KnightChessComponent(new ChessboardPoint(u,v),ChessColor.BLACK,'N');
                        break;
                    case 'B':
                        this.chessComponents[u][v]=new BishopChessComponent(new ChessboardPoint(u,v),ChessColor.BLACK,'B');
                        break;
                    case 'Q':
                        this.chessComponents[u][v]=new QueenChessComponent(new ChessboardPoint(u,v),ChessColor.BLACK,'Q');
                        break;
                    case 'K':
                        this.chessComponents[u][v]=new KingChessComponent(new ChessboardPoint(u,v),ChessColor.BLACK,'K');
                        break;
                    case 'P':
                        this.chessComponents[u][v]=new PawnChessComponent(new ChessboardPoint(u,v),ChessColor.BLACK,'P');
                        break;
                    case '_':
                        this.chessComponents[u][v]=new EmptySlotComponent(new ChessboardPoint(u,v),ChessColor.NONE,'_');
                        break;
                    case 'r':
                        this.chessComponents[u][v]=new RookChessComponent(new ChessboardPoint(u,v),ChessColor.WHITE,'r');
                        break;
                    case 'n':
                        this.chessComponents[u][v]=new KnightChessComponent(new ChessboardPoint(u,v),ChessColor.WHITE,'n');
                        break;
                    case 'b':
                        this.chessComponents[u][v]=new BishopChessComponent(new ChessboardPoint(u,v),ChessColor.WHITE,'b');
                        break;
                    case 'q':
                        this.chessComponents[u][v]=new QueenChessComponent(new ChessboardPoint(u,v),ChessColor.WHITE,'q');
                        break;
                    case 'k':
                        this.chessComponents[u][v]=new KingChessComponent(new ChessboardPoint(u,v),ChessColor.WHITE,'k');
                        break;
                    case 'p':
                        this.chessComponents[u][v]=new PawnChessComponent(new ChessboardPoint(u,v),ChessColor.WHITE,'p');
                        break;
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }else if (chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int q=0;q<=7;q++) {
            for (int p = 0; p <= 7; p++) {
                graph.append(chessComponents[q][p].getName());
            }
            graph.append("\n");
        }
        graph.deleteCharAt(graph.length()-1);
        return graph.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int[] orginlist=new int[]{1,1,2,2,2,8};
        int[] removelist=new int[]{0,0,0,0,0,0};
        for(int v=0;v<=7;v++){
            for(int u=0;u<=7;u++) {
                if (chessComponents[u][v].getChessColor().equals(player)){
                    switch (chessComponents[u][v].getName()){
                        case 'K','k':
                            removelist[0]++;
                            break;
                        case 'Q','q':
                            removelist[1]++;
                            break;
                        case 'R','r':
                            removelist[2]++;
                            break;
                        case 'B','b':
                            removelist[3]++;
                            break;
                        case 'N','n':
                            removelist[4]++;
                            break;
                        case 'P','p':
                            removelist[5]++;
                            break;
                    }
                }
            }
        }
        StringBuilder remove = new StringBuilder();
        for (int y =0;y<=5;y++) {
            if (removelist[y]!=orginlist[y]) {
                switch (player) {
                    case BLACK:
                        switch (y) {
                            case 0:
                                remove.append("K " +(orginlist[y] -removelist[y] )+ "\n");
                                break;
                            case 1:
                                remove.append("Q " +(orginlist[y] -removelist[y] ) + "\n");
                                break;
                            case 2:
                                remove.append("R " + (orginlist[y] -removelist[y] ) + "\n");
                                break;
                            case 3:
                                remove.append("B " + (orginlist[y] -removelist[y] ) + "\n");
                                break;
                            case 4:
                                remove.append("N " + (orginlist[y] -removelist[y] ) + "\n");
                                break;
                            case 5:
                                remove.append("P " + (orginlist[y] -removelist[y] ) + "\n");
                                break;
                        }
                        break;
                    case WHITE:
                        switch (y) {
                            case 0:
                                remove.append("k " +(orginlist[y] -removelist[y] )+ "\n");
                                break;
                            case 1:
                                remove.append("q " + (orginlist[y] -removelist[y] ) + "\n");
                                break;
                            case 2:
                                remove.append("r " +(orginlist[y] -removelist[y] ) + "\n");
                                break;
                            case 3:
                                remove.append("b " +(orginlist[y] -removelist[y] )+ "\n");
                                break;
                            case 4:
                                remove.append("n " + (orginlist[y] -removelist[y] )+ "\n");
                                break;
                            case 5:
                                remove.append("p " + (orginlist[y] -removelist[y] ) + "\n");
                                break;
                        }
                }
            }
        }
        return remove.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        copy=chessComponents;
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        copy=chessComponents;
        if(getChess(sourceX,sourceY).getChessColor()==(currentPlayer)){
            boolean t=false;
            for (ChessboardPoint m:getChess(sourceX,sourceY).canMoveTo()){
                if (m.getX()==targetX&&m.getY()==targetY){
                    t=true;
                    break;
                }
            }
            if (t){
                int u =targetX;
                int v= targetY;
                switch (chessComponents[sourceX][sourceY].name) {
                    case 'R':
                        chessComponents[u][v] = new RookChessComponent(new ChessboardPoint(u, v), ChessColor.BLACK, 'R');
                        break;
                    case 'N':
                        chessComponents[u][v] = new KnightChessComponent(new ChessboardPoint(u, v), ChessColor.BLACK, 'N');
                        break;
                    case 'B':
                        chessComponents[u][v] = new BishopChessComponent(new ChessboardPoint(u, v), ChessColor.BLACK, 'B');
                        break;
                    case 'Q':
                        chessComponents[u][v] = new QueenChessComponent(new ChessboardPoint(u, v), ChessColor.BLACK, 'Q');
                        break;
                    case 'K':
                        chessComponents[u][v] = new KingChessComponent(new ChessboardPoint(u, v), ChessColor.BLACK, 'K');
                        break;
                    case 'P':
                        chessComponents[u][v] = new PawnChessComponent(new ChessboardPoint(u, v), ChessColor.BLACK, 'P');
                        break;
                    case '_':
                        chessComponents[u][v] = new EmptySlotComponent(new ChessboardPoint(u, v), ChessColor.NONE, '_');
                        break;
                    case 'r':
                        chessComponents[u][v] = new RookChessComponent(new ChessboardPoint(u, v), ChessColor.WHITE, 'r');
                        break;
                    case 'n':
                        chessComponents[u][v] = new KnightChessComponent(new ChessboardPoint(u, v), ChessColor.WHITE, 'n');
                        break;
                    case 'b':
                        chessComponents[u][v] = new BishopChessComponent(new ChessboardPoint(u, v), ChessColor.WHITE, 'b');
                        break;
                    case 'q':
                        chessComponents[u][v] = new QueenChessComponent(new ChessboardPoint(u, v), ChessColor.WHITE, 'q');
                        break;
                    case 'k':
                        chessComponents[u][v] = new KingChessComponent(new ChessboardPoint(u, v), ChessColor.WHITE, 'k');
                        break;
                    case 'p':
                        chessComponents[u][v] = new PawnChessComponent(new ChessboardPoint(u, v), ChessColor.WHITE, 'p');
                        break;
                }
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                if (currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }else {
                    currentPlayer=ChessColor.WHITE;
                }
                return true;
            }else return false;
        }else return false;
    }
    static ChessComponent[][] copy=new ChessComponent[8][8];
    public static ChessComponent[][] getChessComponents() {
        return copy;
    }
}
