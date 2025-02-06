import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private ChessboardPoint source;

    public ConcreteChessGame () {
        chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        for(int i = 0 ; i <8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                ChessboardPoint che = new ChessboardPoint(i,j);
                if(chessboard.get(i).charAt(j) == 'R'){
                    this.chessComponents[i][j] = new RookChessComponent(che,ChessColor.BLACK,chessComponents);
                    this.chessComponents[i][j].name = 'R';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'r'){
                    this.chessComponents[i][j] = new RookChessComponent(che,ChessColor.WHITE,chessComponents);
                    this.chessComponents[i][j].name = 'r';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'N'){
                    this.chessComponents[i][j] = new KnightChessComponent(che,ChessColor.BLACK,chessComponents);
                    this.chessComponents[i][j].name = 'N';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'n'){
                    this.chessComponents[i][j] = new KnightChessComponent(che,ChessColor.WHITE,chessComponents);
                    this.chessComponents[i][j].name = 'n';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'B'){
                    this.chessComponents[i][j] = new BishopChessComponent(che,ChessColor.BLACK,chessComponents);
                    this.chessComponents[i][j].name = 'B';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'b'){
                    this.chessComponents[i][j] = new BishopChessComponent(che,ChessColor.WHITE,chessComponents);
                    this.chessComponents[i][j].name = 'b';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'Q'){
                    this.chessComponents[i][j] = new QueenChessComponent(che,ChessColor.BLACK,chessComponents);
                    this.chessComponents[i][j].name = 'Q';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'q'){
                    this.chessComponents[i][j] = new QueenChessComponent(che,ChessColor.WHITE,chessComponents);
                    this.chessComponents[i][j].name = 'q';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'K'){
                    this.chessComponents[i][j] = new KingChessComponent(che,ChessColor.BLACK,chessComponents);
                    this.chessComponents[i][j].name = 'K';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'k'){
                    this.chessComponents[i][j] = new KingChessComponent(che,ChessColor.WHITE,chessComponents);
                    this.chessComponents[i][j].name = 'k';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'P'){
                    this.chessComponents[i][j] = new PawnChessComponent(che,ChessColor.BLACK,chessComponents);
                    this.chessComponents[i][j].name = 'P';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == 'p'){
                    this.chessComponents[i][j] = new PawnChessComponent(che,ChessColor.WHITE,chessComponents);
                    this.chessComponents[i][j].name = 'p';
                    this.chessComponents[i][j].setSource(i,j);
                }else if(chessboard.get(i).charAt(j) == '_'){
                    this.chessComponents[i][j] = new EmptySlotComponent(che,ChessColor.NONE);
                    this.chessComponents[i][j].name = '_';
                    this.chessComponents[i][j].setSource(i,j);
                }
            }
        }if (Objects.equals(chessboard.get(8), "w")){
            this.currentPlayer = ChessColor.WHITE;
        }else if (Objects.equals(chessboard.get(8), "b")){
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }

    @Override
    public String getChessboardGraph(){
        String chess1 = "";String chess2 = "";String chess3 = "";String chess4 = "";
        String chess5 = "";String chess6 = "";String chess7 = "";String chess8 = "";
        for(int i = 0 ; i < 8 ; i++){
            chess1 = chess1 + this.chessComponents[0][i].name;
            chess2 = chess2 + this.chessComponents[1][i].name;
            chess3 = chess3 + this.chessComponents[2][i].name;
            chess4 = chess4 + this.chessComponents[3][i].name;
            chess5 = chess5 + this.chessComponents[4][i].name;
            chess6 = chess6 + this.chessComponents[5][i].name;
            chess7 = chess7 + this.chessComponents[6][i].name;
            chess8 = chess8 + this.chessComponents[7][i].name;
        }
        return chess1+"\n"+chess2+"\n"+chess3+"\n"+chess4+"\n"+chess5+"\n"+chess6+"\n"+chess7+"\n"+chess8;
    }

    @Override
    public String getCapturedChess(ChessColor player){
        int R = 0;int r = 0;int B = 0;int b = 0;int N = 0;int n = 0;
        int K = 0;int k = 0;int Q = 0;int q = 0;int P = 0;int p = 0;
        for(int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                if(chessComponents[i][j].name=='R'){
                    R++;
                }if(chessComponents[i][j].name=='r'){
                    r++;
                }if(chessComponents[i][j].name=='N'){
                    N++;
                }if(chessComponents[i][j].name=='n'){
                    n++;
                }if(chessComponents[i][j].name=='B'){
                    B++;
                }if(chessComponents[i][j].name=='b'){
                    b++;
                }if(chessComponents[i][j].name=='K'){
                    K++;
                }if(chessComponents[i][j].name=='k'){
                    k++;
                }if(chessComponents[i][j].name=='Q'){
                    Q++;
                }if(chessComponents[i][j].name=='q'){
                    q++;
                }if(chessComponents[i][j].name=='P'){
                    P++;
                }if(chessComponents[i][j].name=='p') {
                    p++;
                }
            }
        }
        StringBuilder Black = new StringBuilder();
        StringBuilder White = new StringBuilder();
        if (K < 1){
            Black.append("K ").append(1 - K).append("\n");
        }if (Q < 1){
            Black.append("Q ").append(1- Q).append("\n");
        }if (R < 2){
            Black.append("R ").append(2 - R).append("\n");
        }if (B < 2){
            Black.append("B ").append(2 - B).append("\n");
        }if (N < 2){
            Black.append("N ").append(2 - N).append("\n");
        }if (P < 8){
            Black.append("P ").append(8 - P).append("\n");
        }if (k < 1){
            White.append("k ").append(1 - k).append("\n");
        }if (q < 1){
            White.append("q ").append(1 - q).append("\n");
        }if (r < 2){
            White.append("r ").append(2 - r).append("\n");
        }if (b < 2){
            White.append("b ").append(2 - b).append("\n");
        }if (n < 2){
            White.append("n ").append(2 - n).append("\n");
        }if (p < 8){
            White.append("p ").append(8 - p).append("\n");
        }
        if (player.equals(ChessColor.WHITE)){
            return White.toString();
        }else{
            return Black.toString();
        }
    }

    @Override
    public ChessComponent getChess(int x, int y){
        return this.chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> chess = getChess(source.getX(),source.getY()).canMoveTo();
        for(int i = 0 ; i < chess.size()-1 ; i++){
            for(int j = 0 ; j < chess.size()-1-i ; j++){
                if(chess.get(j).getX() > chess.get(j+1).getX()){
                    Collections.swap(chess,j,j+1);
                }else if(chess.get(j).getX() == chess.get(j+1).getX()){
                    if(chess.get(j).getY()>chess.get(j+1).getY()){
                        Collections.swap(chess,j,j+1);
                    }
                }
            }
        }
        return chess;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint DC = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint Xman = new ChessboardPoint(targetX,targetY);
        if(8>targetX && targetX>=0 && targetY>=0 && targetY<8){
            if(currentPlayer != chessComponents[sourceX][sourceY].getChessColor()){
                return false;}
            else{
                char AWM = chessComponents[sourceX][sourceY].name;
                for (int r = 0 ; r < getCanMovePoints(DC).size() ; r++){
                    if(getCanMovePoints(DC).get(r).getX()==targetX && getCanMovePoints(DC).get(r).getY()==targetY){
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(DC,ChessColor.NONE);
                    if( AWM=='B'){
                        this.chessComponents[targetX][targetY]=new BishopChessComponent(Xman,ChessColor.BLACK,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='B';
                    }else if( AWM=='b'){
                        this.chessComponents[targetX][targetY]=new BishopChessComponent(Xman,ChessColor.WHITE,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='b';
                    }else if( AWM=='K'){
                        this.chessComponents[targetX][targetY]=new KingChessComponent(Xman,ChessColor.BLACK,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='K';
                    }else if( AWM=='k'){
                        this.chessComponents[targetX][targetY]=new KingChessComponent(Xman,ChessColor.WHITE,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='k';
                    }else if( AWM=='N'){
                        this.chessComponents[targetX][targetY]=new KnightChessComponent(Xman,ChessColor.BLACK,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='N';
                    }else if( AWM=='n'){
                        this.chessComponents[targetX][targetY]=new KnightChessComponent(Xman,ChessColor.WHITE,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='n';
                    }else if( AWM=='Q'){
                        this.chessComponents[targetX][targetY]=new QueenChessComponent(Xman,ChessColor.BLACK,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='Q';
                    }else if( AWM=='q'){
                        this.chessComponents[targetX][targetY]=new QueenChessComponent(Xman,ChessColor.WHITE,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='q';
                    }else if( AWM=='P'){
                        this.chessComponents[targetX][targetY]=new PawnChessComponent(Xman,ChessColor.BLACK,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='P';
                    }else if( AWM=='p'){
                        this.chessComponents[targetX][targetY]=new PawnChessComponent(Xman,ChessColor.WHITE,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='p';
                    }else if( AWM=='R'){
                        this.chessComponents[targetX][targetY]=new RookChessComponent(Xman,ChessColor.BLACK,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='R';
                    }else if( AWM=='r'){
                        this.chessComponents[targetX][targetY]=new RookChessComponent(Xman,ChessColor.WHITE,chessComponents);
                        this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                        this.chessComponents[targetX][targetY].name='r';
                    }if(currentPlayer==ChessColor.WHITE){
                        this.currentPlayer=ChessColor.BLACK;
                    }else{this.currentPlayer=ChessColor.WHITE;}
                        return true;
                    }
                }
            }
        }return false;
    }
}
