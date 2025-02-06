import java.util.List;

public class ConcreteChessGame implements ChessGame {
    //implement all the previously written abstract methods in detail

    private ChessComponent[][] chessComponents;
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    // we set the first is x, the second is y
    private ChessColor currentPlayer;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    /**
     * load chess game from given chessboard
     *
     * R/r=rooks,
     * N/n=knights,
     * B/b=bishops,
     * Q/q=queen,
     * K/k=king,
     * P/p=pawns,
     * _=nothing.
     *
     * upper letter, black one; lower letter, white one
     *
     * "w" current player is white, "b" the current player is black.
     *
     * @param chessboard
     *
     *  x\y 0 1 2 3 4 5 6 7
     *   0  R N B Q K B N R
     *   1  P P P P P P P P
     *   2  _ _ _ _ _ _ _ _
     *   3  _ _ _ _ _ _ _ _
     *   4  _ _ _ _ _ _ _ _
     *   5  _ _ _ _ _ _ _ _
     *   6  p p p p p p p p
     *   7  r n b q k b n r
     */
    @Override
    public void loadChessGame(List<String> chessboard){
        if (chessboard.get(8).equals("w")){
            setCurrentPlayer(ChessColor.WHITE);
        }else setCurrentPlayer(ChessColor.BLACK);
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        for (int i = 0; i <=7 ; i++) {
            String a = chessboard.get(i);
            for (int j = 0; j <= 7; j++) {
                chessComponents[i][j] = witchChessComponent(i,j,a.charAt(j));
            }
        }
        this.chessComponents = chessComponents;
        ChessComponent.setChessComponents(chessComponents);
    }
    public ChessComponent witchChessComponent(int x, int y, char name){
        switch (name){
            case 'b':
            case 'B':
                return new BishopChessComponent(x,y,name);
            case 'k':
            case 'K':
                return new KingChessComponent(x, y, name);
            case 'r':
            case 'R':
                return new RookChessComponent(x, y, name);
            case 'n':
            case 'N':
                return new KnightChessComponent(x, y, name);
            case 'q':
            case 'Q':
                return new QueenChessComponent(x, y, name);
            case 'p':
            case 'P':
                return new PawnChessComponent(x, y, name);
            case '_':
                return new EmptySlotComponent(x, y, name);
        }
        return null;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * This method returns the chessboard status.
     * You should return an 8-rows String in the same format with input chessboard.
     * Use \n to separate 2 rows.
     * @return
     * x\y 0 1 2 3 4 5 6 7
     *  0  R N B Q K B N R
     *  1  P P P P P P P P
     *  2  _ _ _ _ _ _ _ _
     *  3  _ _ _ _ _ _ _ _
     *  4  _ _ _ _ _ _ _ _
     *  5  _ _ _ _ _ _ _ _
     *  6  p p p p p p p p
     *  7  r n b q k b n r
     */
    @Override
    public String getChessboardGraph(){
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                this.getCertainLine(0),this.getCertainLine(1),
                this.getCertainLine(2),this.getCertainLine(3),
                this.getCertainLine(4),this.getCertainLine(5),
                this.getCertainLine(6),this.getCertainLine(7));
    }

    public String getCertainLine(int x){
        return String.format("%c%c%c%c%c%c%c%c",
                chessComponents[x][0].getName(),chessComponents[x][1].getName(),
                chessComponents[x][2].getName(),chessComponents[x][3].getName(),
                chessComponents[x][4].getName(),chessComponents[x][5].getName(),
                chessComponents[x][6].getName(),chessComponents[x][7].getName());
    }

    /**
     * This method returns all the captured chess pieces.
     * Pieces should be sort by the order of "King>Queen>Rooks>Bishops>Knights>Pawns".
     * At the beginning of a game, the original count of those chess pieces of
     * King, Queen, Rooks, Bishops, Knights, Pawns are 1, 1, 2, 2, 2, 8 respectively,
     * so that the captured cheeses are those whose have been lost from chessboard.
     * @param player
     * @return
     */
    @Override
    public String getCapturedChess(ChessColor player){
        int[] a = {1,1,2,2,2,8};
        //King>Queen>Rooks>Bishops>Knights>Pawns
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int c = witchChess(chessComponents[i][j].getName(),player);
                if (c>=0){
                    a[c]=a[c]-1;
                }
            }
        }
        int[] b = {0,0,0,0,0,0};
        int c = 0;
        for (int i = 0; i < 6; i++) {
            if (a[i]!=0){
                b[c] = i;
                c++;
            }
        }
        if (b[0]!=0){
            StringBuilder outcome = new StringBuilder(lost(b[0],a[b[0]],player));
            for (int i = 1; i < 6; i++) {
                if (b[i]!=0){
                    outcome.append(lost(b[i],a[b[i]],player));
                }
            }
            return String.valueOf(outcome);
        }else return "";
    }

    public int witchChess(char name, ChessColor Player){
        switch (Player){
            case WHITE:
                return witchChessW(name);
            case BLACK:
                return witchChessB(name);
        }
        return -1;
    }
    public int witchChessW(char name){
        switch (name){
            case 'k':
                return 0;
            case 'q':
                return 1;
            case 'r':
                return 2;
            case 'b':
                return 3;
            case 'n':
                return 4;
            case 'p':
                return 5;
        }
        return -1;
    }

    public int witchChessB(char name){
        switch (name){
            //upper
            case 'K':
                return 0;
            case 'Q':
                return 1;
            case 'R':
                return 2;
            case 'B':
                return 3;
            case 'N':
                return 4;
            case 'P':
                return 5;
        }
        return -1;
    }

    public String lost(int witchOne, int howMany, ChessColor Player){
        switch (Player){
            case BLACK :
                return lostB(witchOne, howMany);
            case WHITE:
                return lostW(witchOne, howMany);
        }
        return null;
    }

    public String lostW(int witchOne, int howMany){
        switch (witchOne){
            case 0:
                return String.format("k %d\n",howMany);
            case 1:
                return String.format("q %d\n",howMany);
            case 2:
                return String.format("r %d\n",howMany);
            case 3:
                return String.format("b %d\n",howMany);
            case 4:
                return String.format("n %d\n",howMany);
            case 5:
                return String.format("p %d\n",howMany);
        }
        return null;
    }

    public String lostB(int witchOne, int howMany){
        switch (witchOne){
            case 0:
                return String.format("K %d\n",howMany);
            case 1:
                return String.format("Q %d\n",howMany);
            case 2:
                return String.format("R %d\n",howMany);
            case 3:
                return String.format("B %d\n",howMany);
            case 4:
                return String.format("N %d\n",howMany);
            case 5:
                return String.format("P %d\n",howMany);
        }
        return null;
    }
    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        // 1. find chess according to source
        // 2. as below statement:
        // 3.sort canMovePoints by x - y ascending order
        return chess.canMoveTo();
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean inTheList;
        if (chessComponents[sourceX][sourceY].getName()=='Q'||chessComponents[sourceX][sourceY].getName()=='q'||
            chessComponents[sourceX][sourceY].getName()=='B'){
             inTheList = true;
        }else {
            inTheList =false;
            for (ChessboardPoint a :getCanMovePoints(chessComponents[sourceX][sourceY].getSource())) {
                if (a.getX() == targetX && a.getY() == targetY) {
                    inTheList = true;
                    break;
                }

            }
        }

        boolean playerCheck = getCurrentPlayer() == chessComponents[sourceX][sourceY].getChessColor();
        if (playerCheck && inTheList){
            ChessComponent[][] output =  getChessComponents();
            output[targetX][targetY] = output[sourceX][sourceY];
            output[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY,'_');
            setChessComponents(output);
            if (getCurrentPlayer()==ChessColor.WHITE){
                setCurrentPlayer(ChessColor.BLACK);
            } else if (getCurrentPlayer()==ChessColor.BLACK) {
                setCurrentPlayer(ChessColor.WHITE);
            }
            ChessComponent.setChessComponents(output);
            return true;
        }else return false;
    }
}
