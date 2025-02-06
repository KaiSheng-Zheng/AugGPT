import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer=ChessColor.WHITE;
    public int blackChess[]=new int[6];
    public int whiteChess[]=new int[6];

    //
    public void loadChessGame(List<String> chessboard){
        int j=0;
        blackChess[0]=1;
        blackChess[1]=1;
        blackChess[2]=2;
        blackChess[3]=2;
        blackChess[4]=2;
        blackChess[5]=8;
        whiteChess[0]=1;
        whiteChess[1]=1;
        whiteChess[2]=2;
        whiteChess[3]=2;
        whiteChess[4]=2;
        whiteChess[5]=8;

        for(String str:chessboard){
            if(str.length()==8){
                for(int i=0;i<8;i++){
                    ChessboardPoint cp=new ChessboardPoint(j,i);
                    switch(str.charAt(i)){
                        case '_':
                            EmptySlotComponent chess=new EmptySlotComponent(cp);
                            chessComponents[j][i]=chess;
                           break;
                        case 'K':
                            KingChessComponent kingChessComponent1=new KingChessComponent(cp,ChessColor .BLACK);
                            chessComponents[j][i]=kingChessComponent1;
                            blackChess[0]--;
                            break;
                        case 'k':
                            KingChessComponent kingChessComponent2=new KingChessComponent(cp,ChessColor .WHITE);
                            chessComponents[j][i]=kingChessComponent2;
                            whiteChess[0]--;
                            break;
                        case 'Q':
                            QueenChessComponent queenChessComponent1=new QueenChessComponent(cp,ChessColor.BLACK );
                            chessComponents[j][i]=queenChessComponent1;
                            blackChess[1]--;
                            break;
                        case 'q':
                            QueenChessComponent queenChessComponent2=new QueenChessComponent(cp,ChessColor.WHITE );
                            chessComponents [j][i]=queenChessComponent2;
                            whiteChess[1]--;
                            break;
                        case 'R':
                            RookChessComponent rookChessComponent1=new RookChessComponent(cp,ChessColor.BLACK );
                            chessComponents [j][i]=rookChessComponent1;
                            blackChess[2]--;
                            break;
                        case 'r':
                            RookChessComponent rookChessComponent2=new RookChessComponent(cp,ChessColor.WHITE );
                            chessComponents [j][i]=rookChessComponent2;
                            whiteChess[2]--;
                            break;
                        case 'B':
                            BishopChessComponent bishopchess1=new BishopChessComponent(cp,ChessColor.BLACK);
                            chessComponents[j][i]=bishopchess1;
                            blackChess[3]--;
                            break;
                        case 'b':
                            BishopChessComponent bishopchess2=new BishopChessComponent(cp,ChessColor.WHITE);
                            chessComponents[j][i]=bishopchess2;
                            whiteChess[3]--;
                            break;
                        case 'N':
                            KnightChessComponent knightChessComponent1=new KnightChessComponent(cp,ChessColor.BLACK );
                            chessComponents [j][i]=knightChessComponent1;
                            blackChess[4]--;
                            break;
                        case 'n':
                            KnightChessComponent knightChessComponent2=new KnightChessComponent(cp,ChessColor.WHITE );
                            chessComponents [j][i]=knightChessComponent2;
                            whiteChess[4]--;
                            break;
                        case 'P':
                            PawnChessComponent pawnChessComponent1=new PawnChessComponent(cp,ChessColor.BLACK);
                            chessComponents[j][i]=pawnChessComponent1;
                            blackChess[5]--;
                            break;
                        case 'p':
                            PawnChessComponent pawnChessComponent2=new PawnChessComponent(cp,ChessColor.WHITE);
                            chessComponents[j][i]=pawnChessComponent2;
                            whiteChess[5]--;
                            break;
                    }
                }
            }
            else{
                if(str.equals("w")){
                    currentPlayer=ChessColor.WHITE;
                }
                else{
                    currentPlayer=ChessColor.BLACK;
                }
            }
            j++;
        }
    }


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                sb.append(chessComponents[i][j].name);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //
    public String getCapturedChess(ChessColor player){
        StringBuilder sb=new StringBuilder();
        if(player==ChessColor.BLACK ){
            if(blackChess[0]!=0){
                sb.append("K ");
                sb.append(blackChess[0]);
                sb.append("\n");
            }
            if(blackChess[1]!=0){
                sb.append("Q ");
                sb.append(blackChess[1]);
                sb.append("\n");
            }
            if(blackChess[2]!=0){
                sb.append("R ");
                sb.append(blackChess[2]);
                sb.append("\n");
            }
            if(blackChess[3]!=0){
                sb.append("B ");
                sb.append(blackChess[3]);
                sb.append("\n");
            }
            if(blackChess[4]!=0){
                sb.append("N ");
                sb.append(blackChess[4]);
                sb.append("\n");
            }
            if(blackChess[5]!=0){
                sb.append("P ");
                sb.append(blackChess[5]);
                sb.append("\n");
            }

        }
        else{
            if(whiteChess[0]!=0){
                sb.append("k ");
                sb.append(whiteChess[0]);
                sb.append("\n");
            }
            if(whiteChess[1]!=0){
                sb.append("q ");
                sb.append(whiteChess[1]);
                sb.append("\n");
            }
            if(whiteChess[2]!=0){
                sb.append("r ");
                sb.append(whiteChess[2]);
                sb.append("\n");
            }
            if(whiteChess[3]!=0){
                sb.append("b ");
                sb.append(whiteChess[3]);
                sb.append("\n");
            }
            if(whiteChess[4]!=0){
                sb.append("n ");
                sb.append(whiteChess[4]);
                sb.append("\n");
            }
            if(whiteChess[5]!=0){
                sb.append("p ");
                sb.append(whiteChess[5]);
                sb.append("\n");
            }
        }
        return sb.toString();
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
