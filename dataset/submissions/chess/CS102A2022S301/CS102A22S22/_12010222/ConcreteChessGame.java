import java.util.*;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    @Override
    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
            String a =chessboard.get(i);
            String[]arr1=a.split("");
            for(int m=0;m<8;m++) {
                if(arr1[m].equals("B")){
                    chessComponents[i][m]=new BishopChessComponent('B',ChessColor.valueOf("BLACK"));
                }
                else if(arr1[m].equals("b")){
                    chessComponents[i][m]=new BishopChessComponent('b',ChessColor.valueOf("WHITE"));
                }
                else if(arr1[m].equals("-")){
                    chessComponents[i][m]=new EmptySlotComponent('-');
                }
                else if(arr1[m].equals("K")){
                    chessComponents[i][m]=new KingChessComponent('K',ChessColor.valueOf("BLACK"));
                }
                else if(arr1[m].equals("k")){
                    chessComponents[i][m]=new KingChessComponent('k',ChessColor.valueOf("WHITE"));
                }
                else if(arr1[m].equals("N")){
                    chessComponents[i][m]=new KnightChessComponent('N',ChessColor.valueOf("BLACK"));
                }
                else if(arr1[m].equals("n")){
                    chessComponents[i][m]=new KnightChessComponent('n',ChessColor.valueOf("WHITE"));
                }
                else if(arr1[m].equals("P")){
                    chessComponents[i][m]=new PawnChessComponent('P',ChessColor.valueOf("BLACK"));
                }
                else if(arr1[m].equals("p")){
                    chessComponents[i][m]=new PawnChessComponent('p',ChessColor.valueOf("WHITE"));
                }
                else if(arr1[m].equals("Q")){
                    chessComponents[i][m]=new QueenChessComponent('Q',ChessColor.valueOf("BLACK"));
                }
                else if(arr1[m].equals("q")){
                    chessComponents[i][m]=new QueenChessComponent('q',ChessColor.valueOf("WHITE"));
                }
                else if(arr1[m].equals("R")){
                    chessComponents[i][m]=new RookChessComponent('R',ChessColor.valueOf("BLACK"));
                }
                else if(arr1[m].equals("r")){
                    chessComponents[i][m]=new RookChessComponent('r',ChessColor.valueOf("WHITE"));
                }
            }
        }
        String b=chessboard.get(8);
        if(b.equals("w")){
            currentPlayer=ChessColor.valueOf("WHITE");
        }
        else if(b.equals("b")){
            currentPlayer=ChessColor.valueOf("BLACK");
        }
        else{
            currentPlayer=ChessColor.valueOf("NONE");
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    @Override
    public String getChessboardGraph(){
        String[]arr1=new String[8];
        for(int i=0;i<8;i++){
            StringBuffer s1=new StringBuffer();
            for(int m=0;m<8;m++){
                s1.append(chessComponents[i][m].toString());
            }
            arr1[i]=s1.toString();
        }
        return arr1[0]+"\n"+arr1[1]+"\n"+arr1[3]+"\n"+arr1[4]+"\n"+arr1[5]+"\n"+arr1[6]+"\n"+arr1[7]+"\n";
    }
    @Override
    public String getCapturedChess(ChessColor player){
        int B=0,b=0,K=0,k=0,Q=0,q=0,N=0,n=0,R=0,r=0,P=0,p=0;
        for(int i=0;i<8;i++){
            for(int m=0;m<8;m++){
                if(chessComponents[i][m].toString().equals("B")){
                    B++;
                }
                else if(chessComponents[i][m].toString().equals("b")){
                    b++;
                }
                else if(chessComponents[i][m].toString().equals("K")){
                    K++;
                }
                else if(chessComponents[i][m].toString().equals("k")){
                    k++;
                }
                else if(chessComponents[i][m].toString().equals("Q")){
                    Q++;
                }
                else if(chessComponents[i][m].toString().equals("q")){
                    q++;
                }
                else if(chessComponents[i][m].toString().equals("N")){
                    N++;
                }
                else if(chessComponents[i][m].toString().equals("n")){
                    n++;
                }
                else if(chessComponents[i][m].toString().equals("R")){
                    R++;
                }
                else if(chessComponents[i][m].toString().equals("r")){
                    r++;
                }
                else if(chessComponents[i][m].toString().equals("P")){
                    P++;
                }
                else if(chessComponents[i][m].toString().equals("p")){
                    p++;
                }
            }
        }
                B=2-B;
                b=2-b;
                K=1-K;
                k=1-k;
                Q=1-Q;
                q=1-q;
                N=2-N;
                n=2-n;
                R=2-R;
                r=2-r;
                P=8-P;
                p=8-p;
                StringBuffer str=new StringBuffer();
                if(player.toString().equals("WHITE")){
                    if(k<1){
                        str.append("k"+" "+k+"\\n");
                    }
                    if(q<1){
                        str.append("q"+" "+q+"\\n");
                    }
                    if(r<2){
                        str.append("r"+" "+r+"\\n");
                    }
                    if(b<2){
                        str.append("b"+" "+b+"\\n");
                    }
                    if(n<2){
                        str.append("n"+" "+"\\n");
                    }
                    if(p<8){
                        str.append("p"+" "+p+"\\n");
                    }

                }
                else{
                    if(K<1){
                        str.append("K"+" "+K+"\\n");
                    }
                    if(Q<1){
                        str.append("Q"+" "+Q+"\\n");
                    }
                    if(R<2){
                        str.append("R"+" "+R+"\\n");
                    }
                    if(B<2){
                        str.append("B"+" "+B+"\\n");
                    }
                    if(N<2){
                        str.append("N"+" "+N+"\\n");
                    }
                    if(P<8){
                        str.append("P"+" "+P+"\\" +
                                "n");
                    }
                }
        return str.toString();
    }
    @Override
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        return null;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        return true;
    }
}