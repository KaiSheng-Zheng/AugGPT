import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessColor currentPlayer;
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];


    @Override
    public void loadChessGame(List<String> chessboard) {



        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                switch (chessboard.get(x).charAt(y)){
                    case 'P':
                        chessComponents[x][y]=new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(x,y));
                        break;
                    case 'p':
                        chessComponents[x][y]=new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(x,y));
                        break;
                    case 'B':
                        chessComponents[x][y]=new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(x,y));
                        break;
                    case 'b':
                        chessComponents[x][y]=new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(x,y));
                        break;

                    case 'N':
                        chessComponents[x][y]=new KnightChessComponent('N',ChessColor.BLACK,new ChessboardPoint(x,y));
                        break;
                    case 'n':
                        chessComponents[x][y]=new KnightChessComponent('n',ChessColor.WHITE,new ChessboardPoint(x,y));
                        break;
                    case 'R':
                        chessComponents[x][y]=new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(x,y));
                        break;
                    case 'r':
                        chessComponents[x][y]=new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(x,y));
                        break;
                    case 'K':
                        chessComponents[x][y]=new KingChessComponent('K',ChessColor.BLACK,new ChessboardPoint(x,y));
                        break;
                    case 'k':
                        chessComponents[x][y]=new KingChessComponent('k',ChessColor.WHITE,new ChessboardPoint(x,y));
                        break;
                    case 'Q':
                        chessComponents[x][y]=new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(x,y));
                        break;
                    case 'q':
                        chessComponents[x][y]=new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(x,y));
                        break;
                    case '_':
                        chessComponents[x][y]=new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(x,y));
                        break;

                }

            }

        }
        if(chessboard.get(8).charAt(0)=='w'){currentPlayer=ChessColor.WHITE;

        }else {
            currentPlayer=ChessColor.BLACK;
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
        StringBuilder f= new StringBuilder();
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
            f.append(this.chessComponents[x][y].name);
        }
            if(x<7){
                f.append("\n");
            }
        }
        return f.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int k=0;int b=0;int n=0;int p=0;int q=0;int r=0;
        int K=0;int B=0;int N=0;int P=0;int Q=0;int R=0;
        StringBuilder f=new StringBuilder();
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    switch (chessComponents[x][y].name) {
                        case 'P':
                            P++;
                            break;
                        case 'p':
                            p++;
                            break;
                        case 'B':
                            B++;
                            break;
                        case 'b':
                            b++;
                            break;

                        case 'N':
                            N++;
                            break;
                        case 'n':
                            n++;
                            break;
                        case 'R':
                            R++;
                            break;
                        case 'r':
                            r++;
                            break;
                        case 'K':
                            K++;
                            break;
                        case 'k':
                            k++;
                            break;
                        case 'Q':
                            Q++;
                            break;
                        case 'q':
                            q++;
                            break;


                    }
                }
            }
            if(player==ChessColor.WHITE){
                if(k!=1){
                    f.append(String.format("k %d\n",1-k));
                }
                if(q!=1){
                    f.append(String.format("q %d\n",1-q));
                }
                if(r!=2){
                    f.append(String.format("r %d\n",2-r));
                }
                if(b!=2){
                    f.append(String.format("b %d\n",2-b));
                }
                if(n!=2){
                    f.append(String.format("n %d\n",2-n));
                }
                if(p!=8){
                    f.append(String.format("p %d\n",8-p));
                }
            }else{
                if(K!=1){
                    f.append(String.format("K %d\n",1-K));
                }
                if(Q!=1){
                    f.append(String.format("Q %d\n",1-Q));
                }
                if(R!=2){
                    f.append(String.format("R %d\n",2-R));
                }
                if(B!=2){
                    f.append(String.format("B %d\n",2-B));
                }
                if(N!=2){
                    f.append(String.format("N %d\n",2-N));
                }
                if(P!=8){
                    f.append(String.format("P %d\n",8-P));
                }
            }
            return f.toString();
        }






    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=chessComponents[source.getX()][source.getY()];
        chess.setSource(source);
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint target=new ChessboardPoint(targetX,targetY);
        ChessboardPoint source=new ChessboardPoint(targetX,targetY);
        if(getCanMovePoints(source).contains(target)){

        }
        return false;
    }
}
