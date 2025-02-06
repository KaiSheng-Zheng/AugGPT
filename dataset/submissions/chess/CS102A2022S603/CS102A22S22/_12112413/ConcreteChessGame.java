import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame  implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){}

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) - 'b' == 0)
            this.currentPlayer = ChessColor.BLACK;
        else
            this.currentPlayer = ChessColor.WHITE;
        this.chessComponents=new ChessComponent[8][8];
        for (int i = 0; i <= 7; i++)
            for (int j = 0; j <= 7; j++) {
                if(chessboard.get(i).charAt(j)=='K'||chessboard.get(i).charAt(j)=='k')
                    chessComponents[i][j]=new KingChessComponent();
                if(chessboard.get(i).charAt(j)=='R'||chessboard.get(i).charAt(j)=='r')
                    chessComponents[i][j]=new RookChessComponent();
                if(chessboard.get(i).charAt(j)=='N'||chessboard.get(i).charAt(j)=='n')
                    chessComponents[i][j]=new KnightChessComponent();
                if(chessboard.get(i).charAt(j)=='B'||chessboard.get(i).charAt(j)=='b')
                    chessComponents[i][j]=new BishopChessComponent();
                if(chessboard.get(i).charAt(j)=='Q'||chessboard.get(i).charAt(j)=='q')
                    chessComponents[i][j]=new QueenChessComponent();
                if(chessboard.get(i).charAt(j)=='P'||chessboard.get(i).charAt(j)=='p')
                    chessComponents[i][j]=new PawnChessComponent();
                if(chessboard.get(i).charAt(j)=='_')
                    chessComponents[i][j]=new EmptySlotComponent();
                chessComponents[i][j].init(i, j, chessboard.get(i).charAt(j));
            }
        for(int k=0;k<=7;k++)
            for(int q=0;q<=7;q++) {
                chessComponents[k][q].chessComponents=new ChessComponent[8][8];
                for (int i = 0; i <= 7; i++)
                    for (int j = 0; j <= 7; j++) {
                        if (this.chessComponents[i][j].name == 'K' || this.chessComponents[i][j].name == 'k')
                            chessComponents[k][q].chessComponents[i][j] = new KingChessComponent();
                        if (this.chessComponents[i][j].name == 'R' || this.chessComponents[i][j].name == 'r')
                            chessComponents[k][q].chessComponents[i][j] = new RookChessComponent();
                        if (this.chessComponents[i][j].name == 'N' || this.chessComponents[i][j].name == 'n')
                            chessComponents[k][q].chessComponents[i][j] = new KnightChessComponent();
                        if (this.chessComponents[i][j].name == 'B' || this.chessComponents[i][j].name == 'b')
                            chessComponents[k][q].chessComponents[i][j] = new BishopChessComponent();
                        if (this.chessComponents[i][j].name == 'Q' || this.chessComponents[i][j].name == 'q')
                            chessComponents[k][q].chessComponents[i][j] = new QueenChessComponent();
                        if (this.chessComponents[i][j].name == 'P' || this.chessComponents[i][j].name == 'p')
                            chessComponents[k][q].chessComponents[i][j] = new PawnChessComponent();
                        if (this.chessComponents[i][j].name == '_')
                            chessComponents[k][q].chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[k][q].chessComponents[i][j].init(i, j, this.chessComponents[i][j].name);
                    }
            }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        String s = "";
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++)
                s += chessComponents[i][j].name;
            s += "\n";
        }
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String s = "";
        int[] a = { 1, 1, 2, 2, 2, 8, 1, 1, 2, 2, 2, 8 };
        char[] b = { 'K', 'Q', 'R', 'B', 'N', 'P', 'k', 'q', 'r', 'b', 'n', 'p' };
        for (int i = 0; i <= 7; i++)
            for (int j = 0; j <= 7; j++)
                for (int k = 0; k <= 11; k++)
                    if (chessComponents[i][j].name == b[k])
                        a[k]--;
        if (player == ChessColor.BLACK)
            for (int i = 0; i <= 5; i++) {
                if (a[i] == 0)
                    continue;
                s += String.valueOf(b[i]);
                s += " ";
                s += String.valueOf(a[i]);
                s += "\n";
            }
        else
            for (int i = 6; i <= 11; i++) {
                if (a[i] == 0)
                    continue;
                s += String.valueOf(b[i]);
                s += " ";
                s += String.valueOf(a[i]);
                s += "\n";
            }
        return s;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> l=this.chessComponents[source.getX()][source.getY()].canMoveTo();
        l.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return l;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(this.currentPlayer!=this.chessComponents[sourceX][sourceY].getChessColor())
            return false;
        List<ChessboardPoint> l=this.chessComponents[sourceX][sourceY].canMoveTo();
        for(int m=0;m<l.size();m++)
            if(targetX==l.get(m).getX()&&targetY==l.get(m).getY()) {
                this.currentPlayer=this.currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE;
                char c=this.chessComponents[sourceX][sourceY].name;
                this.chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                this.chessComponents[sourceX][sourceY].init(sourceX,sourceY,'_');
                if(c=='K'||c=='k')
                    this.chessComponents[targetX][targetY]=new KingChessComponent();
                if(c=='R'||c=='r')
                    this.chessComponents[targetX][targetY]=new RookChessComponent();
                if(c=='B'||c=='b')
                    this.chessComponents[targetX][targetY]=new BishopChessComponent();
                if(c=='N'||c=='n')
                    this.chessComponents[targetX][targetY]=new KnightChessComponent();
                if(c=='Q'||c=='q')
                    this.chessComponents[targetX][targetY]=new QueenChessComponent();
                if(c=='P'||c=='p')
                    this.chessComponents[targetX][targetY]=new PawnChessComponent();
                this.chessComponents[targetX][targetY].init(targetX,targetY,c);
                for(int k=0;k<=7;k++)
                    for(int q=0;q<=7;q++){
                        this.chessComponents[k][q].chessComponents=new ChessComponent[8][8];
                        for(int i=0;i<=7;i++)
                            for(int j=0;j<=7;j++){
                                if (this.chessComponents[i][j].name == 'K' || this.chessComponents[i][j].name == 'k')
                                    chessComponents[k][q].chessComponents[i][j] = new KingChessComponent();
                                if (this.chessComponents[i][j].name == 'R' || this.chessComponents[i][j].name == 'r')
                                    chessComponents[k][q].chessComponents[i][j] = new RookChessComponent();
                                if (this.chessComponents[i][j].name == 'N' || this.chessComponents[i][j].name == 'n')
                                    chessComponents[k][q].chessComponents[i][j] = new KnightChessComponent();
                                if (this.chessComponents[i][j].name == 'B' || this.chessComponents[i][j].name == 'b')
                                    chessComponents[k][q].chessComponents[i][j] = new BishopChessComponent();
                                if (this.chessComponents[i][j].name == 'Q' || this.chessComponents[i][j].name == 'q')
                                    chessComponents[k][q].chessComponents[i][j] = new QueenChessComponent();
                                if (this.chessComponents[i][j].name == 'P' || this.chessComponents[i][j].name == 'p')
                                    chessComponents[k][q].chessComponents[i][j] = new PawnChessComponent();
                                if (this.chessComponents[i][j].name == '_')
                                    chessComponents[k][q].chessComponents[i][j] = new EmptySlotComponent();
                                chessComponents[k][q].chessComponents[i][j].init(i, j, this.chessComponents[i][j].name);
                            }
                    }
                return true;
            }
        return false;
    }
}
