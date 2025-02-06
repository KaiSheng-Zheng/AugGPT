import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;
    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public void loadChessGame(List<String> chessboard){
        if(chessboard.get(chessboard.size()-1).equals("w")){currentPlayer=ChessColor.WHITE;}
        else {currentPlayer=ChessColor.BLACK;}
        for (int i = 0; i < chessboard.size()-1; i++) {
            String[] w=chessboard.get(i).split("");
            for (int j = 0; j < w.length; j++) {
                switch (w[j]){
                    case "R":{setChess(i,j,new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK));break;}
                    case "r":{setChess(i,j,new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE));break;}
                    case "N":{setChess(i,j,new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK));break;}
                    case "n":{setChess(i,j,new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE));break;}
                    case "B":{setChess(i,j,new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK));break;}
                    case "b":{setChess(i,j,new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE));break;}
                    case "Q":{setChess(i,j,new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK));break;}
                    case "q":{setChess(i,j,new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE));break;}
                    case "K":{setChess(i,j,new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK));break;}
                    case "k":{setChess(i,j,new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE));break;}
                    case "P":{setChess(i,j,new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK));break;}
                    case "p":{setChess(i,j,new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE));break;}
                    case "_":{setChess(i,j,new EmptySlotComponent(new ChessboardPoint(i,j)));break;}
                }
            }
        }
    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 8; j++) {
                    stringBuilder.append(chessComponents[i][j].getName());
                }
                stringBuilder.append("\n");
            }
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(chessComponents[7][i].getName());
        }
            return stringBuilder.toString();
        }
    public String getCapturedChess(ChessColor player){
        StringBuilder w=new StringBuilder();
        int k=0;int q=0;int r=0;int n=0;int b=0;int p=0;
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor().equals(player)) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        k++;
                    } else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        q++;
                    } else if (chessComponents[i][j] instanceof RookChessComponent) {
                        r++;
                    } else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        n++;
                    } else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        b++;
                    } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        p++;
                    }
                }
            }
        }
        int K=1-k;int Q=1-q;int R=2-r;int B=2-b;int N=2-n;int P=8-p;
        if (K != 0) {
            if (player.equals(ChessColor.BLACK)){
            w.append(String.format("K %d\n",K));}
            else w.append(String.format("k %d\n",K));
        }if (Q != 0) {
            if (player.equals(ChessColor.BLACK)){
                w.append(String.format("Q %d\n",Q));}
            else w.append(String.format("q %d\n",Q));
        }if (R != 0) {
            if (player.equals(ChessColor.BLACK)){
                w.append(String.format("R %d\n",R));}
            else w.append(String.format("r %d\n",R));
        }if (B != 0) {
            if (player.equals(ChessColor.BLACK)){
                w.append(String.format("B %d\n",B));}
            else w.append(String.format("b %d\n",B));
        }if (N != 0) {
            if (player.equals(ChessColor.BLACK)){
                w.append(String.format("N %d\n",N));}
            else w.append(String.format("n %d\n",N));
        }if (P != 0) {
            if (player.equals(ChessColor.BLACK)){
                w.append(String.format("P %d\n",P));}
            else w.append(String.format("p %d\n",P));
        }
        return w.toString();
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public void setChess(int x,int y,ChessComponent chess){
        chessComponents[x][y]=chess;
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        getChess(source.getX(),source.getY()).loadChessboard(chessComponents);
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX,sourceY).getChessColor()==getCurrentPlayer()) {
            getChess(sourceX, sourceY).loadChessboard(chessComponents);
            boolean b = false;List<ChessboardPoint> move =getCanMovePoints(getChess(sourceX,sourceY).getSource());
            for (ChessboardPoint chessboardPoint : move){
                if (chessboardPoint.getX() == targetX &&  chessboardPoint.getY() == targetY ){
                    b = true;
                    break;
                }
            }
            if (b) {
                this.chessComponents[targetX][targetY] = getChess(sourceX,sourceY);
                this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                this.chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
                if (getCurrentPlayer() == ChessColor.WHITE){
            setCurrentPlayer(ChessColor.BLACK);
        }
        else {
            setCurrentPlayer(ChessColor.WHITE);
        }
                return true;
            }else  return false;
        }
        return false;
    }
}
