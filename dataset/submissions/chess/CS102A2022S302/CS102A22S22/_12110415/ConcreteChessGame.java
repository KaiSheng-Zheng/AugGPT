import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;


    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame(){}


    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char c = chessboard.get(i).charAt(j);
                switch (c) {
                    case 'k':
                    {chessComponents[i][j] = (new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k'));
                        break;}
                    case 'K':
                    {chessComponents[i][j] = (new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K'));
                        break;}
                    case 'q':
                    {chessComponents[i][j] = (new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q'));
                        break;}
                    case 'Q':
                    {chessComponents[i][j] = (new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q'));
                        break;}
                    case 'b':
                    {chessComponents[i][j] = (new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b'));
                        break;}
                    case 'B':
                    {chessComponents[i][j] = (new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B'));
                        break;}
                    case 'n':
                    {chessComponents[i][j] = (new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n'));
                        break;}
                    case 'N':
                    {chessComponents[i][j] = (new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N'));
                        break;}
                    case 'r':
                    {chessComponents[i][j] = (new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r'));
                        break;}
                    case 'R':
                    {chessComponents[i][j] = (new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R'));
                         break;}
                    case 'p':
                    {chessComponents[i][j] = (new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p'));
                        break;}
                    case 'P':
                    {chessComponents[i][j] = (new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P'));
                        break;}
                    default:{
                        chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }
        else currentPlayer=ChessColor.BLACK;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
                chessComponents[i][j].setCurrentPlayer(currentPlayer);
            }
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
        StringBuilder needToReturn=new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                needToReturn.append(chessComponents[i][j].toString());
            }
            needToReturn.append(String.format("\n"));
        }
        return needToReturn.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K =0;
        int Q =0;
        int N =0;
        int B =0;
        int P =0;
        int R =0;
        int k =0;
        int q=0;
        int n =0;
        int b =0;
        int p =0;
        int r =0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char c = chessComponents[i][j].toString().charAt(0);
                switch (c) {
                    case 'k':
                    {k++;
                        break;}
                    case 'K':
                    {K++;
                        break;}
                    case 'q':
                    {q++;
                        break;}
                    case 'Q':
                    {Q++;
                        break;}
                    case 'b':{
                        {b++;
                            break;}
                    }
                    case 'B':
                    {B++;
                        break;}
                    case 'n':
                    {n++;
                        break;}
                    case 'N':
                    {N++;
                        break;}
                    case 'r':
                    {r++;
                        break;}
                    case 'R':
                    {R++;
                        break;}
                    case 'p':
                    {p++;
                        break;}
                    case 'P':
                    {P++;
                        break;}
                    default:{
                        break;
                    }
                }
            }
        }

        if (player.equals(ChessColor.BLACK)){
            StringBuilder needToReturn=new StringBuilder();
            if (K!=1)   needToReturn.append(String.format("K %d\n",(1-K)));
            if (Q!=1)   needToReturn.append(String.format("Q %d\n",(1-Q)));
            if (R!=2)   needToReturn.append(String.format("R %d\n",(2-R)));
            if (B!=2)   needToReturn.append(String.format("B %d\n",(2-B)));
            if (N!=2)   needToReturn.append(String.format("N %d\n",(2-N)));
            if (P!=8)   needToReturn.append(String.format("P %d\n",(8-P)));
            return needToReturn.toString();
        }  else {
            StringBuilder needToReturn=new StringBuilder();
            if (k!=1)   needToReturn.append(String.format("k %d\n",(1-K)));
            if (q!=1)   needToReturn.append(String.format("q %d\n",(1-q)));
            if (r!=2)   needToReturn.append(String.format("r %d\n",(2-r)));
            if (b!=2)   needToReturn.append(String.format("b %d\n",(2-b)));
            if (n!=2)   needToReturn.append(String.format("n %d\n",(2-n)));
            if (p!=8)   needToReturn.append(String.format("p %d\n",(8-p)));
            return needToReturn.toString();
        }


    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        List<ChessboardPoint> needToSorts=chessComponents[source.getX()][source.getY()].canMoveTo();

        List<ChessboardPoint> needToReturn=new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {


                boolean test=false;
                for (int k = 0; k < needToSorts.size(); k++) {
                    if (needToSorts.get(k).getY()==j&needToSorts.get(k).getX()==i){
                        test=true;
                    }
                }
                if (test){
                    needToReturn.add(new ChessboardPoint(i,j));
                }


            }
        }

        return (List)needToReturn;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {

        if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
                if (currentPlayer.equals(ChessColor.WHITE)){
                    currentPlayer=ChessColor.BLACK;
                }
                else currentPlayer=ChessColor.WHITE;

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        chessComponents[i][j].setChessComponents(chessComponents);
                        chessComponents[i][j].setCurrentPlayer(currentPlayer);
                    }
                }
                return true;
            }

            else
                return false;

    }
}
