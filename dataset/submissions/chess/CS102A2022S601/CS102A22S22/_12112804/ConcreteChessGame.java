import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    final static char[] Bname= {'K','Q','R','B','N','P'};
    final static char[] Wname= {'k','q','r','b','n','p'};
    final static int[] max={1,1,2,2,2,8};
    public ConcreteChessGame()
    {
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < chessboard.size(); i++) {
            if(i==8){
                if(chessboard.get(i).charAt(0)=='w')
                    currentPlayer=ChessColor.WHITE;
                else if(chessboard.get(i).charAt(0)=='b')
                    currentPlayer=ChessColor.BLACK;
                break;
            }
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R' -> {
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        ChessComponent.chessset(0,2);
                    }
                    case 'r' -> {
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        ChessComponent.chessset(1, 2);
                    }
                    case 'B' -> {
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        ChessComponent.chessset(0, 3);
                    }
                    case 'b' -> {
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        ChessComponent.chessset(1,3);
                    }
                    case 'K' -> {
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        ChessComponent.chessset(0, 0);
                    }
                    case 'k' -> {
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        ChessComponent.chessset(1, 0);
                    }
                    case 'N' -> {
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        ChessComponent.chessset(0, 4);
                    }
                    case 'n' -> {
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        ChessComponent.chessset(1, 4);
                    }
                    case 'P' -> {
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        ChessComponent.chessset(0, 5);
                    }
                    case 'p' -> {
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        ChessComponent.chessset(1, 5);
                    }
                    case 'Q' -> {
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        ChessComponent.chessset(0, 1);
                    }
                    case 'q' -> {
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        ChessComponent.chessset(1, 1);
                    }
                    case '_' -> chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j));
                }
            }
        }
    }
    public ChessColor getCurrentPlayer(){
        return currentPlayer;
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public String getChessboardGraph(){
        StringBuilder out= new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                out.append(chessComponents[i][j].toString());
            }
            out.append("\n");
        }
        return out.toString();
    }
    public String getCapturedChess(ChessColor player){
        int[] count=new int[6];
        StringBuilder out= new StringBuilder();
        if(player==ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        if(chessComponents[i][j].toString().equals("K"))
                            count[0]++;
                        else if(chessComponents[i][j].toString().equals("Q"))
                            count[1]++;
                        else if(chessComponents[i][j].toString().equals("R"))
                            count[2]++;
                        else if(chessComponents[i][j].toString().equals("B"))
                            count[3]++;
                        else if(chessComponents[i][j].toString().equals("N"))
                            count[4]++;
                        else if(chessComponents[i][j].toString().equals("P"))
                            count[5]++;
                    }
                }
            }
            for (int i = 0; i < 6; i++) {
                if (count[i] < max[i])
                    out.append(Bname[i]).append(" ").append((max[i]-count[i])).append("\n");
            }
        }
        else if(player==ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        if(chessComponents[i][j].toString().equals("k"))
                            count[0]++;
                        else if(chessComponents[i][j].toString().equals("q"))
                            count[1]++;
                        else if(chessComponents[i][j].toString().equals("r"))
                        count[2]++;
                        else if(chessComponents[i][j].toString().equals("b"))
                            count[3]++;
                        else if(chessComponents[i][j].toString().equals("n"))
                            count[4]++;
                        else if(chessComponents[i][j].toString().equals("p"))
                            count[5]++;
                    }
                }
            }
            for (int i = 0; i < 6; i++) {
                if (count[i] < max[i])
                    out.append(Wname[i]).append(" ").append((max[i]-count[i])).append("\n");
            }
        }
        return out.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].setChessBoard(chessComponents);
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setChessBoard(chessComponents);
        if(currentPlayer!=chessComponents[sourceX][sourceY].chessColor){
            return false;
        }
        List<ChessboardPoint> canMovePoints=getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        ChessboardPoint want=new ChessboardPoint(targetX,targetY);
        if(canMovePoints.contains(want)){
            chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].source.move(targetX,targetY);
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));
            swapColor();
            return true;
        }
        else
            return false;
    }
    public void swapColor() {
        currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
    }
}
