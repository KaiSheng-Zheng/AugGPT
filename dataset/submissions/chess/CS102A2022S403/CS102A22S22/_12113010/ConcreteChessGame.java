import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessboard.get(i).charAt(j)=='k'||chessboard.get(i).charAt(j)=='K')
                    chessComponents[i][j] = new KingChessComponent(chessboard.get(i).charAt(j),i,j,chessComponents);
                if(chessboard.get(i).charAt(j)=='q'||chessboard.get(i).charAt(j)=='Q')
                    chessComponents[i][j] = new QueenChessComponent(chessboard.get(i).charAt(j),i,j,chessComponents);
                if(chessboard.get(i).charAt(j)=='n'||chessboard.get(i).charAt(j)=='N')
                    chessComponents[i][j] = new KnightChessComponent(chessboard.get(i).charAt(j),i,j,chessComponents);
                if(chessboard.get(i).charAt(j)=='r'||chessboard.get(i).charAt(j)=='R')
                    chessComponents[i][j] = new RookChessComponent(chessboard.get(i).charAt(j),i,j,chessComponents);
                if(chessboard.get(i).charAt(j)=='P'||chessboard.get(i).charAt(j)=='p')
                    chessComponents[i][j] = new PawnChessComponent(chessboard.get(i).charAt(j),i,j,chessComponents);
                if(chessboard.get(i).charAt(j)=='b'||chessboard.get(i).charAt(j)=='B')
                    chessComponents[i][j] = new BishopChessComponent(chessboard.get(i).charAt(j),i,j,chessComponents);
                if(chessboard.get(i).charAt(j)=='_')
                    chessComponents[i][j] = new EmptySlotComponent(chessboard.get(i).charAt(j),i,j);

            }
        }
        if(chessboard.get(8).equals("w"))
            currentPlayer=ChessColor.WHITE;
        else
            currentPlayer=ChessColor.BLACK;
    }
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s.append(chessComponents[i][j].name);
            }
            s.append("\n");
        }
        return s.toString();
    }
    public String getCapturedChess(ChessColor player){
        int q=0;int k=0;int r =0;int n=0;int b =0;int p=0;
        StringBuilder s = new StringBuilder();
        if(player == ChessColor.BLACK){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessComponents[i][j].name == 'Q')
                    q++;
                if(chessComponents[i][j].name == 'K')
                    k++;
                if(chessComponents[i][j].name == 'R')
                    r++;
                if(chessComponents[i][j].name == 'N')
                    n++;
                if(chessComponents[i][j].name == 'B')
                    b++;
                if(chessComponents[i][j].name == 'P')
                    p++;
            }
        }
        if(k!=1)
            s.append(String.format("K %d\n",1-k));
        if(q!=1)
                s.append(String.format("Q %d\n",1-q));
        if(r!=2)
            s.append(String.format("R %d\n",2-r));
        if(b!=2)
                s.append(String.format("B %d\n",2-b));
        if(n!=2)
            s.append(String.format("N %d\n",2-n));
        if(p!=8)
            s.append(String.format("P %d\n",8-p));
        }
        else{
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(chessComponents[i][j].name == 'q')
                        q++;
                    if(chessComponents[i][j].name == 'k')
                        k++;
                    if(chessComponents[i][j].name == 'r')
                        r++;
                    if(chessComponents[i][j].name == 'n')
                        n++;
                    if(chessComponents[i][j].name == 'b')
                        b++;
                    if(chessComponents[i][j].name == 'p')
                        p++;
                }
            }
            if(k!=1)
                s.append(String.format("k %d\n",1-k));
            if(q!=1)
                s.append(String.format("q %d\n",1-q));
            if(r!=2)
                s.append(String.format("r %d\n",2-r));
            if(b!=2)
                s.append(String.format("b %d\n",2-b));
            if(n!=2)
                s.append(String.format("n %d\n",2-n));
            if(p!=8)
                s.append(String.format("p %d\n",8-p));
        }
        return s.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int a=0;
        ChessComponent chess =  chessComponents[sourceX][sourceY];
        if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer)
            return false;
        for (int i = 0; i < chess.canMoveTo().size(); i++) {
            if(chess.canMoveTo().get(i).getY()==targetY && chess.canMoveTo().get(i).getX()==targetX)
                a=1;
        }
        if(a==0) {
            return false;
        } else {
            if(currentPlayer == ChessColor.WHITE)
                currentPlayer = ChessColor.BLACK;
            else
                currentPlayer = ChessColor.WHITE;

            if(chessComponents[sourceX][sourceY].name=='k'||chessComponents[sourceX][sourceY].name=='K')
                chessComponents[targetX][targetY] = new KingChessComponent(chessComponents[sourceX][sourceY].name,targetX,targetY,chessComponents);
            if(chessComponents[sourceX][sourceY].name=='q'||chessComponents[sourceX][sourceY].name=='Q')
                chessComponents[targetX][targetY] = new QueenChessComponent(chessComponents[sourceX][sourceY].name,targetX,targetY,chessComponents);
            if(chessComponents[sourceX][sourceY].name=='N'||chessComponents[sourceX][sourceY].name=='n')
                chessComponents[targetX][targetY] = new KnightChessComponent(chessComponents[sourceX][sourceY].name,targetX,targetY,chessComponents);
            if(chessComponents[sourceX][sourceY].name=='P'||chessComponents[sourceX][sourceY].name=='p')
                chessComponents[targetX][targetY] = new PawnChessComponent(chessComponents[sourceX][sourceY].name,targetX,targetY,chessComponents);
            if(chessComponents[sourceX][sourceY].name=='b'||chessComponents[sourceX][sourceY].name=='B')
                chessComponents[targetX][targetY] = new BishopChessComponent(chessComponents[sourceX][sourceY].name,targetX,targetY,chessComponents);
            if(chessComponents[sourceX][sourceY].name=='r'||chessComponents[sourceX][sourceY].name=='R')
                chessComponents[targetX][targetY] = new RookChessComponent(chessComponents[sourceX][sourceY].name,targetX,targetY,chessComponents);

            chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',sourceX,sourceY);
            return true;
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess =  chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        if(chess.canMoveTo().size()!=0){
            Collections.sort(canMovePoints,new Comparator<ChessboardPoint>() {
                public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                    if(o1.getX() - o2.getX()>0)
                        return  1;
                    else if(o1.getX() - o2.getX()<0)
                        return -1;
                    else {
                        if(o1.getY() - o2.getY()>0)
                            return  1;
                        else if(o1.getY() - o2.getY()<0)
                            return -1;
                        else
                            return 0;
                    }
                }
            });
        }
        return canMovePoints;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
}