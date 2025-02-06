import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame  implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){}

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0)=='b'){
            this.currentPlayer = ChessColor.BLACK;}
        else{
            this.currentPlayer = ChessColor.WHITE;}
        this.chessComponents=new ChessComponent[8][8];
        for (int i = 0; i <= 7; i++)
            for (int j = 0; j <= 7; j++) {
                if(chessboard.get(i).charAt(j)=='k')
                    chessComponents[i][j]=new KingChessComponent();
                else if(chessboard.get(i).charAt(j)=='r')
                    chessComponents[i][j]=new RookChessComponent();
                else if(chessboard.get(i).charAt(j)=='n')
                    chessComponents[i][j]=new KnightChessComponent();
                else if(chessboard.get(i).charAt(j)=='b')
                    chessComponents[i][j]=new BishopChessComponent();
                else if(chessboard.get(i).charAt(j)=='q')
                    chessComponents[i][j]=new QueenChessComponent();
                else if(chessboard.get(i).charAt(j)=='p')
                    chessComponents[i][j]=new PawnChessComponent();

                else if(chessboard.get(i).charAt(j)=='K')
                    chessComponents[i][j]=new KingChessComponent();
                else if(chessboard.get(i).charAt(j)=='R')
                    chessComponents[i][j]=new RookChessComponent();
                else if(chessboard.get(i).charAt(j)=='N')
                    chessComponents[i][j]=new KnightChessComponent();
                else if(chessboard.get(i).charAt(j)=='B')
                    chessComponents[i][j]=new BishopChessComponent();
                else if(chessboard.get(i).charAt(j)=='Q')
                    chessComponents[i][j]=new QueenChessComponent();
                else if(chessboard.get(i).charAt(j)=='P')
                    chessComponents[i][j]=new PawnChessComponent();
                else chessComponents[i][j]=new EmptySlotComponent();
                chessComponents[i][j].init(i, j, chessboard.get(i).charAt(j));
            }
        for(int k=0;k<8;k++)
            for(int q=0;q<8;q++) {
                chessComponents[k][q].chessComponents=new ChessComponent[8][8];
                for (int i = 0; i <8; i++)
                    for (int j = 0; j <8; j++) {
                        if (this.chessComponents[i][j].name == 'K' )
                            chessComponents[k][q].chessComponents[i][j] = new KingChessComponent();
                        else if (this.chessComponents[i][j].name == 'R')
                            chessComponents[k][q].chessComponents[i][j] = new RookChessComponent();
                        else if (this.chessComponents[i][j].name == 'N')
                            chessComponents[k][q].chessComponents[i][j] = new KnightChessComponent();
                        else if (this.chessComponents[i][j].name == 'B')
                            chessComponents[k][q].chessComponents[i][j] = new BishopChessComponent();
                        else if (this.chessComponents[i][j].name == 'Q')
                            chessComponents[k][q].chessComponents[i][j] = new QueenChessComponent();
                        else if (this.chessComponents[i][j].name == 'P')
                            chessComponents[k][q].chessComponents[i][j] = new PawnChessComponent();

                        else if (this.chessComponents[i][j].name == 'k')
                            chessComponents[k][q].chessComponents[i][j] = new KingChessComponent();
                        else if (this.chessComponents[i][j].name == 'r')
                            chessComponents[k][q].chessComponents[i][j] = new RookChessComponent();
                        else if (this.chessComponents[i][j].name == 'n')
                            chessComponents[k][q].chessComponents[i][j] = new KnightChessComponent();
                        else if (this.chessComponents[i][j].name == 'b')
                            chessComponents[k][q].chessComponents[i][j] = new BishopChessComponent();
                        else if (this.chessComponents[i][j].name == 'q')
                            chessComponents[k][q].chessComponents[i][j] = new QueenChessComponent();
                        else if (this.chessComponents[i][j].name == 'p')
                            chessComponents[k][q].chessComponents[i][j] = new PawnChessComponent();
                        else chessComponents[k][q].chessComponents[i][j] = new EmptySlotComponent();
                        chessComponents[k][q].chessComponents[i][j].init(i, j, this.chessComponents[i][j].name);
                    }
            }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder getChessboardGraph = new StringBuilder();
        for (int i=0;i<8;i++){
            StringBuilder x = new StringBuilder();
            for (int j=0;j<8;j++){
                char e =chessComponents[i][j].name;
                if (e=='b'){
                    x.append("b");}
                else if (e=='k'){
                    x.append("k");}
                else if (e=='p'){
                    x.append("p");}
                else if (e=='q'){
                    x.append("q");}
                else if (e=='r'){
                    x.append("r");}
                else if (e=='n'){
                    x.append("n");}
                else if (e=='B'){
                    x.append("B");}
                else if (e=='K'){
                    x.append("K");}
                else if (e=='P'){
                    x.append("P");}
                else if (e=='Q'){
                    x.append("Q");}
                else if (e=='R'){
                    x.append("R");}
                else if (e=='N'){
                    x.append("N");}
                else{x.append("_");}
            }getChessboardGraph.append(x).append("\n");
        }
        return String.valueOf(getChessboardGraph);
    }

    @Override
    public String getCapturedChess(ChessColor player){
        int k =1;int q =1;int r =2;int b =2;int n =2; int p =8;
        StringBuilder x = new StringBuilder();
        if (player==ChessColor.BLACK){
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (this.chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                        if (chessComponents[i][j].name=='K'){k--;}
                        else if (chessComponents[i][j].name=='Q'){q--;}
                        else if (chessComponents[i][j].name=='R'){r--;}
                        else if (chessComponents[i][j].name=='B'){b--;}
                        else if (chessComponents[i][j].name=='N'){n--;}
                        else if (chessComponents[i][j].name=='P'){p--;}}}}
            if (k>0){x.append("K ").append(k).append("\n");}
            if (q>0){x.append("Q ").append(q).append("\n");}
            if (r>0){x.append("R ").append(r).append("\n");}
            if (b>0){x.append("B ").append(b).append("\n");}
            if (n>0){x.append("N ").append(n).append("\n");}
            if (p>0){x.append("P ").append(p).append("\n");}
        }
        else if (player==ChessColor.WHITE){
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if (chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                        if (chessComponents[i][j].name=='k'){k--;}
                        else if (chessComponents[i][j].name=='q'){q--;}
                        else if (chessComponents[i][j].name=='r'){r--;}
                        else if (chessComponents[i][j].name=='b'){b--;}
                        else if (chessComponents[i][j].name=='n'){n--;}
                        else if (chessComponents[i][j].name=='p'){p--;}}}}
            if (k>0){x.append("k ").append(k).append("\n");}
            if (q>0){x.append("q ").append(q).append("\n");}
            if (r>0){x.append("r ").append(r).append("\n");}
            if (b>0){x.append("b ").append(b).append("\n");}
            if (n>0){x.append("n ").append(n).append("\n");}
            if (p>0){x.append("p ").append(p).append("\n");}
        }

        return x.toString();}


    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint>getCanMovePoints=this.chessComponents[source.getX()][source.getY()].canMoveTo();
        getCanMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return getCanMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(this.currentPlayer!=this.chessComponents[sourceX][sourceY].getChessColor())
            return false;
        List<ChessboardPoint> l=this.chessComponents[sourceX][sourceY].canMoveTo();
        for (ChessboardPoint chessboardPoint : l){
            if (targetX == chessboardPoint.getX() && targetY == chessboardPoint.getY()) {
                this.currentPlayer = this.currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
                char c = this.chessComponents[sourceX][sourceY].name;
                if (c == 'K' )
                    this.chessComponents[targetX][targetY] = new KingChessComponent();
                else if (c == 'R')
                    this.chessComponents[targetX][targetY] = new RookChessComponent();
                else if (c == 'B')
                    this.chessComponents[targetX][targetY] = new BishopChessComponent();
                else if (c == 'N')
                    this.chessComponents[targetX][targetY] = new KnightChessComponent();
                else if (c == 'Q')
                    this.chessComponents[targetX][targetY] = new QueenChessComponent();
                else if (c == 'P')
                    this.chessComponents[targetX][targetY] = new PawnChessComponent();
                else if (c == 'k')
                    this.chessComponents[targetX][targetY] = new KingChessComponent();
                else if (c == 'r')
                    this.chessComponents[targetX][targetY] = new RookChessComponent();
                else if (c == 'b')
                    this.chessComponents[targetX][targetY] = new BishopChessComponent();
                else if (c == 'n')
                    this.chessComponents[targetX][targetY] = new KnightChessComponent();
                else if (c == 'q')
                    this.chessComponents[targetX][targetY] = new QueenChessComponent();
                else if (c == 'p')
                    this.chessComponents[targetX][targetY] = new PawnChessComponent();
                this.chessComponents[targetX][targetY].init(targetX, targetY, c);

                this.chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                this.chessComponents[sourceX][sourceY].init(sourceX, sourceY, '_');
                for (int k = 0; k <8; k++)
                    for (int q = 0; q <8; q++) {
                        this.chessComponents[k][q].chessComponents=new ChessComponent[8][8];
                        for (int i = 0; i <8; i++)
                            for (int j = 0; j <8; j++) {
                                char t = this.chessComponents[i][j].name;
                                if (t == 'K')
                                    chessComponents[k][q].chessComponents[i][j] = new KingChessComponent();
                                else if (t == 'R')
                                    chessComponents[k][q].chessComponents[i][j] = new RookChessComponent();
                                else if (t == 'N')
                                    chessComponents[k][q].chessComponents[i][j] = new KnightChessComponent();
                                else if (t == 'B')
                                    chessComponents[k][q].chessComponents[i][j] = new BishopChessComponent();
                                else if (t == 'Q')
                                    chessComponents[k][q].chessComponents[i][j] = new QueenChessComponent();
                                else if (t == 'P')
                                    chessComponents[k][q].chessComponents[i][j] = new PawnChessComponent();
                                else if (t == 'k')
                                    chessComponents[k][q].chessComponents[i][j] = new KingChessComponent();
                                else if (t == 'r')
                                    chessComponents[k][q].chessComponents[i][j] = new RookChessComponent();
                                else if (t == 'n')
                                    chessComponents[k][q].chessComponents[i][j] = new KnightChessComponent();
                                else if (t == 'b')
                                    chessComponents[k][q].chessComponents[i][j] = new BishopChessComponent();
                                else if (t == 'q')
                                    chessComponents[k][q].chessComponents[i][j] = new QueenChessComponent();
                                else if (t == 'p')
                                    chessComponents[k][q].chessComponents[i][j] = new PawnChessComponent();
                                else if (t == '_')
                                    chessComponents[k][q].chessComponents[i][j] = new EmptySlotComponent();
                                chessComponents[k][q].chessComponents[i][j].init(i, j, t);
                            }
                    }
                return true;
            }
        }
        return false;
    }
}
