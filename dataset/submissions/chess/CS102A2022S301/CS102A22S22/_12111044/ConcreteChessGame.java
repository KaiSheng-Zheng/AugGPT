import java.util.*;
public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.NONE;
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++){
                char a=chessboard.get(i).charAt(j);
                switch (a){
                    case 'K':
                        chessComponents[i][j]=new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'k':
                        chessComponents[i][j]=new KingChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'Q':
                        chessComponents[i][j]=new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'q':
                        chessComponents[i][j]=new QueenChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'N':
                        chessComponents[i][j]=new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'n':
                        chessComponents[i][j]=new KnightChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'P':
                        chessComponents[i][j]=new PawnChessComponent(i-1);
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'p':
                        chessComponents[i][j]=new PawnChessComponent(6-i);
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'R':
                        chessComponents[i][j]=new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'r':
                        chessComponents[i][j]=new RookChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    case 'B':
                        chessComponents[i][j]=new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                        break;
                    case 'b':
                        chessComponents[i][j]=new BishopChessComponent();
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                        break;
                    default:
                        chessComponents[i][j]=new EmptySlotComponent();
                        chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                chessComponents[i][j].name=a;
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }
        else if(chessboard.get(8).equals("b"))
        {currentPlayer=ChessColor.BLACK;}
//        else currentPlayer=ChessColor.NONE;
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
        StringBuilder str = new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                str.append(chessComponents[i][j]);
            }
            str.append('\n');
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int bk=0;   int wk=0;
        int bq=0;   int wq=0;
        int br=0;   int wp=0;
        int bp=0;   int wr=0;
        int bb=0;   int wb=0;
        int bn=0;   int wn=0;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].name=='K')bk++;
                if(chessComponents[i][j].name=='Q')bq++;
                if(chessComponents[i][j].name=='R')br++;
                if(chessComponents[i][j].name=='N')bn++;
                if(chessComponents[i][j].name=='B')bb++;
                if(chessComponents[i][j].name=='P')bp++;
            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].name=='k')wk++;
                if(chessComponents[i][j].name=='q')wq++;
                if(chessComponents[i][j].name=='r')wr++;
                if(chessComponents[i][j].name=='n')wn++;
                if(chessComponents[i][j].name=='b')wb++;
                if(chessComponents[i][j].name=='p')wp++;
            }
        }
        if(player==ChessColor.BLACK) {
            if (bk == 0) {
                str.append("K 1\n");
            }
            if (bq == 0) {
                str.append("Q 1\n");
            }
            if (br < 2) {
                str.append("R ").append(2 - br).append("\n");
            }
            if (bb < 2) {
                str.append("B ").append(2 - bb).append("\n");
            }
            if (bn < 2) {
                str.append("N ").append(2 - bn).append("\n");
            }
            if (bp < 8) {
                str.append("P ").append(8 - bp).append("\n");
            }
        }
        else {
            if (wk == 0) {
                str.append("k 1\n");
            }
            if (wq == 0) {
                str.append("q 1\n");
            }
            if (wr < 2) {
                str.append("r ").append(2 - wr).append("\n");
            }
            if (wb < 2) {
                str.append("b ").append(2 - wb).append("\n");
            }
            if (wn < 2) {
                str.append("n ").append(2 - wn).append("\n");
            }
            if (wp < 8) {
                str.append("p ").append(8 - wp).append("\n");
            }
        }
        return String.valueOf(str);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> CanMovePoints=chess.canMoveTo();
        CanMovePoints.sort((o1, o2) -> o1.getX()!=o2.getX()?o1.getX()-o2.getX():o1.getY()-o2.getY());
        return CanMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = this.getChess(sourceX,sourceY);
        if(getCurrentPlayer()!=chess.getChessColor()){
            return false;
        }
        List<ChessboardPoint> CanMovePoints=chess.canMoveTo();
        for(ChessboardPoint point:CanMovePoints){
            if(point.getX()==targetX&&point.getY()==targetY){
                chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                if(chess.getChessColor()==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }
                if(chess.getChessColor()==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }

                return true;
            }

        }
        return false;
    }
}
