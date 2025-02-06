import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j) == 'R')
                    chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,i,j,chessComponents);
                if(chessboard.get(i).charAt(j) == 'r')
                    chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,i,j,chessComponents);
                if(chessboard.get(i).charAt(j) == 'N')
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,i,j,chessComponents);
                if(chessboard.get(i).charAt(j) == 'n')
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,i,j,chessComponents);

                if(chessboard.get(i).charAt(j) == 'B')
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,i,j,chessComponents);
                if(chessboard.get(i).charAt(j) == 'b')
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,i,j,chessComponents);
                if(chessboard.get(i).charAt(j) == 'Q')
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,i,j,chessComponents);
                if(chessboard.get(i).charAt(j) == 'q')
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,i,j,chessComponents);

                if(chessboard.get(i).charAt(j) == 'K')
                    chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,i,j,chessComponents);
                if(chessboard.get(i).charAt(j) == 'k')
                    chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,i,j,chessComponents);
                if(chessboard.get(i).charAt(j) == 'P')
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,i,j,chessComponents);
                if(chessboard.get(i).charAt(j) == 'p')
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,i,j,chessComponents);

                if(chessboard.get(i).charAt(j) == '_')
                    chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,i,j,chessComponents);
            }
        }
        if(chessboard.get(8).equals("w") ) currentPlayer = ChessColor.WHITE;
        if(chessboard.get(8).equals("b") ) currentPlayer = ChessColor.BLACK;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(this.chessComponents);
            }   }
//        List<String> chessboard;
//        chessboard.get(0) equals to "RNBQKBNR";
//        chessboard.get(1) equals to "PPPPPPPP";
//        chessboard.get(2) equals to "________";
//        chessboard.get(3) equals to "________";
//        chessboard.get(4) equals to "________";
//        chessboard.get(5) equals to "________";
//        chessboard.get(6) equals to "pppppppp";
//        chessboard.get(7) equals to "rnbqkbnr";
//        chessboard.get(8) equals to "w";
    }
    public String getChessboardGraph(){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j] != null) {
                    if (chessComponents[i][j] instanceof RookChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                        output.append('R');
                    if (chessComponents[i][j] instanceof RookChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                        output.append('r');
                    if (chessComponents[i][j] instanceof KingChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                        output.append('K');
                    if (chessComponents[i][j] instanceof KingChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                        output.append('k');
                    if (chessComponents[i][j] instanceof KnightChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                        output.append('N');
                    if (chessComponents[i][j] instanceof KnightChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                        output.append('n');
                    if (chessComponents[i][j] instanceof BishopChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                        output.append('B');
                    if (chessComponents[i][j] instanceof BishopChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                        output.append('b');
                    if (chessComponents[i][j] instanceof QueenChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                        output.append('q');
                    if (chessComponents[i][j] instanceof QueenChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                        output.append('Q');
                    if (chessComponents[i][j] instanceof PawnChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.BLACK)
                        output.append('P');
                    if (chessComponents[i][j] instanceof PawnChessComponent
                            && chessComponents[i][j].getChessColor() == ChessColor.WHITE)
                        output.append('p');
                    if(chessComponents[i][j] instanceof EmptySlotComponent)
                       output.append('_');
                }
                else output.append('_');
            }
            if(i<7)
            output.append('\n');
        }
        return String.valueOf(output);
    }

    public String getCapturedChess(ChessColor player){
        int[] chess = new int[]{1, 1, 2, 2, 2, 8};
        StringBuilder output = new StringBuilder();
        if(player == ChessColor.BLACK){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j] instanceof KingChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.BLACK)
                        chess[0]--;
                    if(chessComponents[i][j] instanceof QueenChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.BLACK)
                        chess[1]--;
                    if(chessComponents[i][j] instanceof RookChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.BLACK)
                        chess[2]--;
                    if(chessComponents[i][j] instanceof BishopChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.BLACK)
                        chess[3]--;
                    if(chessComponents[i][j] instanceof KnightChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.BLACK)
                        chess[4]--;
                    if(chessComponents[i][j] instanceof PawnChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.BLACK)
                        chess[5]--;
                } }
            for (int i = 0; i < chess.length; i++)
                if (chess[i] != 0) {
                    if (i == 0) {
                        output.append('K');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 1) {
                        output.append('Q');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 2) {
                        output.append('R');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 3) {
                        output.append('B');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 4) {
                        output.append('N');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 5) {
                        output.append('P');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                }
        }
        if(player == ChessColor.WHITE){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j] instanceof KingChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.WHITE)
                        chess[0]--;
                    if(chessComponents[i][j] instanceof QueenChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.WHITE)
                        chess[1]--;
                    if(chessComponents[i][j] instanceof RookChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.WHITE)
                        chess[2]--;
                    if(chessComponents[i][j] instanceof BishopChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.WHITE)
                        chess[3]--;
                    if(chessComponents[i][j] instanceof KnightChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.WHITE)
                        chess[4]--;
                    if(chessComponents[i][j] instanceof PawnChessComponent
                            && chessComponents[i][j].getChessColor() ==ChessColor.WHITE)
                        chess[5]--;
                } }
            for (int i = 0; i < chess.length; i++)
                if (chess[i] != 0) {
                    if (i == 0) {
                        output.append('k');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 1) {
                        output.append('q');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 2) {
                        output.append('r');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 3) {
                        output.append('b');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 4) {
                        output.append('n');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                    if (i == 5) {
                        output.append('p');
                        output.append(' ');
                        output.append(chess[i]);
                        output.append('\n');
                    }
                }
        }
        return String.valueOf(output);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> input =  chessComponents[source.getX()][source.getY()].canMoveTo();
        int[] x= new  int[input.size()];
        int[] y= new  int[input.size()];
        ChessboardPoint[] in = new ChessboardPoint[input.size()];
        for (int i = 0; i < input.size() ; i++) {
            x[i] = input.get(i).getX();
            y[i] = input.get(i).getY();
            in[i] = input.get(i);
        }
        for (int i = 0; i < input.size(); i++) {
            for (int j = i+1; j < input.size(); j++) {
                if( in[i].getX()>in[j].getX()
                ||( in[i].getX()==in[j].getX())&&in[i].getY()>in[j].getY()){
                    ChessboardPoint n = in[i];
                    int l1 = x[i];
                    int l2 = y[i];

                    x[i] = x[j];
                    y[i] = y[j];
                    in[i] = in[j];

                    x[j] = l1;
                    y[j] = l2;
                    in[j] = n;  }
            }
        }
        ArrayList<ChessboardPoint> output = new ArrayList<>(Arrays.asList(in).subList(0, input.size()));
        return output;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean can = false;
        List<ChessboardPoint> canList =  chessComponents[sourceX][sourceY].canMoveTo();
        for (ChessboardPoint chessboardPoint : canList) {
            if(chessboardPoint.getY() == targetY && chessboardPoint.getX()==targetX){
            //if (chessboardPoint.equals(new ChessboardPoint(targetX, targetY))){
                can = true;
                break;}
        }
       if(can && chessComponents[sourceX][sourceY].getChessColor().equals(currentPlayer)){
           chessComponents[targetX][targetY]  = chessComponents[sourceX][sourceY];
           chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
           chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE,sourceX,sourceY,chessComponents);

           for (int i = 0; i < 8; i++) {
               for (int j = 0; j < 8; j++) {
                   chessComponents[i][j].setChessComponents(this.chessComponents);
               }   }
        if(currentPlayer == ChessColor.BLACK) currentPlayer = ChessColor.WHITE;
        else currentPlayer = ChessColor.BLACK;
        return true;}
       else return false;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

}
