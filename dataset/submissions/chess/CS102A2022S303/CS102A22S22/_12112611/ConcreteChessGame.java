import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }
    

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (chessboard.get(i).charAt(j)=='_'){
                    this.chessComponents[i][j]=new EmptySlotComponent();
                    this.chessComponents[i][j].name='_';
                }else if(chessboard.get(i).charAt(j)=='R'){
                    this.chessComponents[i][j]=new RookChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name='R';
                }else if(chessboard.get(i).charAt(j)=='r'){
                    this.chessComponents[i][j]=new RookChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name='r';
                }else if(chessboard.get(i).charAt(j)=='N'){
                    this.chessComponents[i][j]=new KnightChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name='N';
                }else if(chessboard.get(i).charAt(j)=='n'){
                    this.chessComponents[i][j]=new KnightChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name='n';
                }else if(chessboard.get(i).charAt(j)=='B'){
                    this.chessComponents[i][j]=new BishopChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name='B';
                }else if(chessboard.get(i).charAt(j)=='b'){
                    this.chessComponents[i][j]=new BishopChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name='b';
                }else if(chessboard.get(i).charAt(j)=='Q'){
                    this.chessComponents[i][j]=new QueenChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name='Q';
                }else if(chessboard.get(i).charAt(j)=='q'){
                    this.chessComponents[i][j]=new QueenChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name='q';
                }else if(chessboard.get(i).charAt(j)=='K'){
                    this.chessComponents[i][j]=new KingChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name='K';
                }else if(chessboard.get(i).charAt(j)=='k'){
                    this.chessComponents[i][j]=new KingChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name='k';
                }else if(chessboard.get(i).charAt(j)=='P'){
                    this.chessComponents[i][j]=new PawnChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    this.chessComponents[i][j].name='P';
                }else if(chessboard.get(i).charAt(j)=='p'){
                    this.chessComponents[i][j]=new PawnChessComponent();
                    this.chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    this.chessComponents[i][j].name='p';
                }if(chessboard.get(8).charAt(0)=='w'){
                    currentPlayer=ChessColor.WHITE;
                }else if(chessboard.get(8).charAt(0)=='b'){
                    currentPlayer=ChessColor.BLACK;
                }
            }
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        ChessComponent chessComponent=this.chessComponents[x][y];
        return chessComponent;
    }



    @Override
    public String getChessboardGraph() {
        StringBuilder chessboard=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
               if (this.chessComponents[i][j].name=='R'){
                   chessboard.append('R');
               }else if(this.chessComponents[i][j].name=='r'){
                   chessboard.append('r');
               }else if(this.chessComponents[i][j].name=='N'){
                   chessboard.append('N');
               }else if(this.chessComponents[i][j].name=='n'){
                   chessboard.append('n');
               }else if(this.chessComponents[i][j].name=='B'){
                   chessboard.append('B');
               }else if(this.chessComponents[i][j].name=='b'){
                   chessboard.append('b');
               }else if(this.chessComponents[i][j].name=='Q'){
                   chessboard.append('Q');
               }else if(this.chessComponents[i][j].name=='q'){
                   chessboard.append('q');
               }else if(this.chessComponents[i][j].name=='K'){
                   chessboard.append('K');
               }else if(this.chessComponents[i][j].name=='k'){
                   chessboard.append('k');
               }else if(this.chessComponents[i][j].name=='P'){
                   chessboard.append('P');
               }else if(this.chessComponents[i][j].name=='p'){
                   chessboard.append('p');
               }else if(this.chessComponents[i][j].name=='_'){
                   chessboard.append('_');
               }if(j==7){chessboard.append('\n');}
            }

        }return chessboard.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder lostChess=new StringBuilder();
        int lostKing=1;
        int lostQueen=1;
        int lostRook=2;
        int lostBishop=2;
        int lostKnight=2;
        int lostPawn=8;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (player==ChessColor.BLACK){
                    if (chessComponents[i][j].name=='R'){
                        lostRook--;
                    }else if (chessComponents[i][j].name=='N'){
                        lostKnight--;
                    }else if (chessComponents[i][j].name=='B'){
                        lostBishop--;
                    }else if (chessComponents[i][j].name=='Q'){
                        lostQueen--;
                    }else if (chessComponents[i][j].name=='K'){
                        lostKing--;
                    }else if (chessComponents[i][j].name=='P'){
                        lostPawn--;
                    }else continue;
                }else {if (chessComponents[i][j].name=='r'){
                    lostRook--;
                }else if (chessComponents[i][j].name=='n'){
                    lostKnight--;
                }else if (chessComponents[i][j].name=='b'){
                    lostBishop--;
                }else if (chessComponents[i][j].name=='q'){
                    lostQueen--;
                }else if (chessComponents[i][j].name=='k'){
                    lostKing--;
                }else if (chessComponents[i][j].name=='p'){
                    lostPawn--;
                }else continue;}
            }
        }if(player==ChessColor.BLACK){
            if (lostKing!=0){
                lostChess.append(String.format("K %d",lostKing));lostChess.append('\n');
            }if (lostQueen!=0){
                lostChess.append(String.format("Q %d",lostQueen));lostChess.append('\n');
            }if(lostRook!=0){
                lostChess.append(String.format("R %d",lostRook));lostChess.append('\n');
            }if(lostBishop!=0){
                lostChess.append(String.format("B %d",lostBishop));lostChess.append('\n');
            }if(lostKnight!=0){
                lostChess.append(String.format("N %d",lostKnight));lostChess.append('\n');
            }if(lostPawn!=0){
                lostChess.append(String.format("P %d",lostPawn));lostChess.append('\n');
            }
        }else if(player==ChessColor.WHITE){
            if (lostKing!=0){
                lostChess.append(String.format("k %d",lostKing));lostChess.append('\n');
            }if (lostQueen!=0){
                lostChess.append(String.format("q %d",lostQueen));lostChess.append('\n');
            }if(lostRook!=0){
                lostChess.append(String.format("r %d",lostRook));lostChess.append('\n');
            }if(lostBishop!=0){
                lostChess.append(String.format("b %d",lostBishop));lostChess.append('\n');
            }if(lostKnight!=0){
                lostChess.append(String.format("n %d",lostKnight));lostChess.append('\n');
            }if(lostPawn!=0){
                lostChess.append(String.format("p %d",lostPawn));lostChess.append('\n');
            }
        }return lostChess.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess=this.getChess(source.getX(),source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }



}




