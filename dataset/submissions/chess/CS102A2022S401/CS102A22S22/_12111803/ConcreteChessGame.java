
import java.util.List;


public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private String[] outcome=new String[8];

    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<=7;i++){
            char[] Line=chessboard.get(i).toCharArray();
            outcome[i]=chessboard.get(i);
            for(int j=0;j<=7;j++){
                switch (Line[j]){
                    case 'R':
                        ChessComponent R =new RookChessComponent(Line[j]);
                        chessComponents[i][j]=R;
                        break;
                    case 'r':
                        ChessComponent r=new RookChessComponent(Line[j]);
                        chessComponents[i][j]=r;
                        break;
                    case 'N':
                        ChessComponent N=new KnightChessComponent(Line[j]);
                        chessComponents[i][j]=N;
                        break;
                    case 'n':
                        ChessComponent n=new KnightChessComponent(Line[j]) ;
                        chessComponents[i][j]=n;
                        break;
                    case 'B':
                        ChessComponent B=new BishopChessComponent(Line[j]) ;
                        chessComponents[i][j]=B;
                        break;
                    case 'b':
                        ChessComponent b=new BishopChessComponent(Line[j]) ;
                        chessComponents[i][j]=b;
                        break;
                    case 'Q':
                        ChessComponent Q=new QueenChessComponent(Line[j]) ;
                        chessComponents[i][j]=Q;
                        break;
                    case 'q':
                        ChessComponent q=new QueenChessComponent(Line[j]) ;
                        chessComponents[i][j]=q;
                        break;
                    case 'K':
                        ChessComponent K=new KingChessComponent(Line[j]) ;
                        chessComponents[i][j]=K;
                        break;
                    case 'k':
                        ChessComponent k=new KingChessComponent(Line[j]) ;
                        chessComponents[i][j]=k;
                        break;
                    case '-':
                        ChessComponent empty=new EmptySlotComponent(Line[j]) ;
                        chessComponents[i][j]=empty;
                        break;
                    case 'P':
                        ChessComponent P =new PawnChessComponent(Line[j]);
                        chessComponents[i][j]=P;
                        break;
                    case 'p':
                        ChessComponent p =new PawnChessComponent(Line[j]);
                        chessComponents[i][j]=p;
                        break;    
                }

                char wOrb = chessboard.get(8).charAt(0);
                if (wOrb == 'w') {
                    currentPlayer = ChessColor.WHITE;
                }
                else if(wOrb == 'b'){
                    currentPlayer = ChessColor.BLACK;
                }

            }
        }

    }
    @Override
    public ChessColor getCurrentPlayer  () {
        return this.currentPlayer;
    }




    public String getChessboardGraph(){
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",outcome[0],outcome[1],outcome[2],outcome[3],outcome[4],outcome[5],outcome[6],outcome[7]);
    }



    public String getCapturedChess(ChessColor player){
        int[] capturedChess=new int[5];
        capturedChess[0]=1;
        capturedChess[1]=1;
        capturedChess[2]=2;
        capturedChess[3]=2;
        capturedChess[4]=2;
        capturedChess[5]=8;

        if(currentPlayer==ChessColor.WHITE){
            for(int i=0;i<=7;i++){
                for(int j=0;j<=7;j++){
                    if(chessComponents[i][j].toString().equals("k")){
                        capturedChess[0]=capturedChess[0]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("q") ){
                        capturedChess[1]=capturedChess[1]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("r") ){
                        capturedChess[2]=capturedChess[2]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("b") ){
                        capturedChess[3]=capturedChess[3]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("n") ){
                        capturedChess[4]=capturedChess[4]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("p") ){
                        capturedChess[5]=capturedChess[5]-1;
                    }
                }
            }
        }else if(currentPlayer==ChessColor.BLACK){
            for(int i=0;i<=7;i++){
                for(int j=0;j<=7;j++){
                    if(chessComponents[i][j].toString().equals("K")){
                        capturedChess[0]=capturedChess[0]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("Q")){
                        capturedChess[1]=capturedChess[1]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("R") ){
                        capturedChess[2]=capturedChess[2]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("B") ){
                        capturedChess[3]=capturedChess[3]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("N")){
                        capturedChess[4]=capturedChess[4]-1;
                    }
                    else if(chessComponents[i][j].toString().equals("P") ){
                        capturedChess[5]=capturedChess[5]-1;
                    }
                }
            }
        }
        StringBuilder outPutCaptured=new StringBuilder();
        String[] piece=new String[5];

        if(currentPlayer==ChessColor.WHITE){
            piece[0]="k";
            piece[1]="q";
            piece[2]="r";
            piece[3]="b";
            piece[4]="n";
            piece[5]="p";
            for(int i=0;i<=5;i++){
                if(capturedChess[i]==0){
                    break;
                }else{
                    outPutCaptured.append(String.format("%s %d\n",piece[i],capturedChess[i]));

                }
            }

        }
        else if(currentPlayer==ChessColor.BLACK){
            piece[0]="K";
            piece[1]="Q";
            piece[2]="R";
            piece[3]="B";
            piece[4]="N";
            piece[5]="P";
            for(int i=0;i<=5;i++){
                if(capturedChess[i]==0){
                    break;
                }else{
                    outPutCaptured.append(String.format("%s %d\n",piece[i],capturedChess[i]));

                }
            }

        }
        return outPutCaptured.toString();









    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];

    }





















































}
