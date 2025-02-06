import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    public void loadChessGame(List<String> chessboard){
        this.chessComponents = new ChessComponent[8][8];
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(chessboard.get(i).charAt(j) == 'r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                    chessComponents[i][j].setChessboard(this.chessComponents);
                }
                if(chessboard.get(i).charAt(j) == 'R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                    chessComponents[i][j].setChessboard(this.chessComponents);

                }
                if(chessboard.get(i).charAt(j) == 'N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                    chessComponents[i][j].setChessboard(this.chessComponents);

                }
                if(chessboard.get(i).charAt(j) == 'B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                    chessComponents[i][j].setChessboard(this.chessComponents);

                }
                if(chessboard.get(i).charAt(j) == 'Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                    chessComponents[i][j].setChessboard(this.chessComponents);

                }
                if(chessboard.get(i).charAt(j) == 'K'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                    chessComponents[i][j].setChessboard(this.chessComponents);

                }
                if(chessboard.get(i).charAt(j) == 'P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                    chessComponents[i][j].setChessboard(this.chessComponents);

                }
                if(chessboard.get(i).charAt(j) == '_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j));
                    chessComponents[i][j].setChessboard(this.chessComponents);

                }
            }
        }

        if(chessboard.get(8).charAt(0) == 'w'){
            this.currentPlayer = ChessColor.WHITE;
        }
        else if(chessboard.get(8).charAt(0) == 'b'){
            this.currentPlayer = ChessColor.BLACK;
        }
        else{
            this.currentPlayer = ChessColor.NONE;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(this.chessComponents);

            }

        }

    }

    public ChessColor getCurrentPlayer() {//returns the current player
        return this.currentPlayer;
    }


    @Override
    public String getChessboardGraph() {// returns the chessboard status.
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ans.append(chessComponents[i][j].toString());
            }
            ans.append("\n");
        }
        return ans.toString();



    }

    @Override
    public String getCapturedChess(ChessColor player) { //returns all the chess pieces that are already captured
        int R=2,r=2,N=2,n=2,B=2,b=2,Q=1,q=1,K=1,k=1,P=8,p=8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].toString().equals("R"))
                    R--;
                if(chessComponents[i][j].toString().equals("r"))
                    r--;

                if(chessComponents[i][j].toString().equals("N"))
                    N--;
                if(chessComponents[i][j].toString().equals("n"))
                    n--;

                if(chessComponents[i][j].toString().equals("B"))
                    B--;
                if(chessComponents[i][j].toString().equals("b"))
                    b--;

                if(chessComponents[i][j].toString().equals("Q"))
                    Q--;
                if(chessComponents[i][j].toString().equals("q"))
                    q--;

                if(chessComponents[i][j].toString().equals("K"))
                    K--;
                if(chessComponents[i][j].toString().equals("k"))
                    k--;

                if(chessComponents[i][j].toString().equals("P"))
                    P--;
                if(chessComponents[i][j].toString().equals("p"))
                    p--;


            }
        }
        StringBuilder ans = new StringBuilder();
        if (player == ChessColor.BLACK){
            if(K != 0)ans.append(String.format("K %d\n",K));
            if(Q != 0)ans.append(String.format("Q %d\n",Q));
            if(R != 0)ans.append(String.format("R %d\n",R));
            if(B != 0)ans.append(String.format("B %d\n",B));
            if(N != 0)ans.append(String.format("N %d\n",N));
            if(P != 0)ans.append(String.format("P %d\n",P));
            return ans.toString();
        }
        if (player == ChessColor.WHITE){
            if(k != 0)ans.append(String.format("k %d\n",k));
            if(q != 0)ans.append(String.format("q %d\n",q));
            if(r != 0)ans.append(String.format("r %d\n",r));
            if(b != 0)ans.append(String.format("b %d\n",b));
            if(n != 0)ans.append(String.format("n %d\n",n));
            if(p != 0)ans.append(String.format("p %d\n",p));
            return ans.toString();

        }
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        boolean contains = false;

        if(currentPlayer != chessComponents[sourceX][sourceY].getChessColor()){
            return false;
        }
       List<ChessboardPoint> canMovePoint = getCanMovePoints(source);
        for (ChessboardPoint chessboardPoint : canMovePoint) {
            if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                contains = true;
                break;
            }
        }
        if(contains){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(source);

            if(currentPlayer.equals(ChessColor.WHITE))currentPlayer = ChessColor.BLACK;
            else currentPlayer = ChessColor.WHITE;


            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));


            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessComponents[i][j].setChessboard(this.chessComponents);

                }

            }
            return true;
        }else return false;

    }

    public ChessComponent getChess(int x, int y){// returns the ChessComponent object in the given position.
        return chessComponents[x][y];

    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }



}
