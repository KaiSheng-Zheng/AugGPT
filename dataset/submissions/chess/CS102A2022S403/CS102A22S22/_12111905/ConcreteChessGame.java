import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            String raw = chessboard.get(i);
            for (int j=0;j<8;j++){
                switch (raw.charAt(j)){
                    case 'P':{
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                        break;
                    }
                    case 'p':{
                        chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                        break;
                    }
                    case 'R':{
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                        break;
                    }
                    case 'r':{
                        chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                        break;
                    }
                    case 'N':{
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                        break;
                    }
                    case 'n':{
                        chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                        break;
                    }
                    case 'B':{
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                        break;
                    }
                    case 'b':{
                        chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                        break;
                    }
                    case 'Q':{
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                        break;
                    }
                    case 'q':{
                        chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                        break;
                    }
                    case 'K':{
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                        break;
                    }
                    case 'k':{
                        chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                        break;
                    }
                    case '_':{
                        chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                        break;
                    }
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else currentPlayer=ChessColor.BLACK;
        ChessComponent.chessComponents = chessComponents;
    }



    public ChessColor getCurrentPlayer() {
        return currentPlayer; }

    public String getChessboardGraph(){
        StringBuilder Graph =new StringBuilder();
        for (int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                Graph.append(chessComponents[i][j].name);
            }
            Graph.append("\n");
        }
        return Graph.toString();
    }
    public String getCapturedChess(ChessColor player) {
        int[] white = new int[6];
        int[] black = new int[6];
        StringBuilder out = new StringBuilder();
        if (player==ChessColor.BLACK){
            for (int i =0;i<8;i++){
                for (int j=0;j<8;j++){
                    switch (chessComponents[i][j].name){
                        case 'K':{
                            black[0]++;
                            break;
                        }
                        case 'Q':{
                            black[1]++;
                            break;
                        }
                        case 'R':{
                            black[2]++;
                            break;
                        }
                        case 'B':{
                            black[3]++;
                            break;
                        }
                        case 'N':{
                            black[4]++;
                            break;
                        }
                        case 'P':{
                            black[5]++;
                            break;
                        }
                    }
                }
            }
            if (black[0]!=1){
                out.append("K ").append(1 - black[0]).append("\n");
            }
            if (black[1]!=1){
                out.append("Q ").append(1 - black[1]).append("\n");
            }
            if (black[2]!=2){
                out.append("R ").append(2 - black[2]).append("\n");
            }
            if (black[3]!=2){
                out.append("B ").append(2 - black[3]).append("\n");
            }
            if (black[4]!=2){
                out.append("N ").append(2 - black[4]).append("\n");
            }
            if (black[5]!=8){
                out.append("P ").append(8 - black[5]).append("\n");
            }
        }else {
            for (int i =0;i<8;i++){
                for (int j=0;j<8;j++){
                    switch (chessComponents[i][j].name){
                        case 'k':{
                            white[0]++;
                            break;
                        }
                        case 'q':{
                            white[1]++;
                            break;
                        }
                        case 'r':{
                            white[2]++;
                            break;
                        }
                        case 'b':{
                            white[3]++;
                            break;
                        }
                        case 'n':{
                            white[4]++;
                            break;
                        }
                        case 'p':{
                            white[5]++;
                            break;
                        }
                    }
                }
            }
            if (white[0]!=1){
                out.append("k ").append(1 - white[0]).append("\n");
            }
            if (white[1]!=1){
                out.append("q ").append(1 - white[1]).append("\n");
            }
            if (white[2]!=2){
                out.append("r ").append(2 - white[2]).append("\n");
            }
            if (white[3]!=2){
                out.append("b ").append(2 - white[3]).append("\n");
            }
            if (white[4]!=2){
                out.append("n ").append(2 - white[4]).append("\n");
            }
            if (white[5]!=8){
                out.append("p ").append(8 - white[5]).append("\n");
            }
        }
        return out.toString();
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint>in=getChess(source.getX(),source.getY()).canMoveTo();
        in.sort((o1, o2) -> {
            if (o1.getX()>o2.getX()||(o1.getX()==o2.getX()&&o1.getY()>o2.getY())){
                    return 1;
            }else return -1;
        });
        return in;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (currentPlayer!=chessComponents[sourceX][sourceY].getChessColor()){
            return false;
        }
       if (getChess(sourceX,sourceY).canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
           switch (getChess(sourceX,sourceY).name){
               case 'P':{
                   chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'P');
                   break;
               }
               case 'p':{
                   chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'p');
                   break;
               }
               case 'R':{
                   chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'R');
                   break;
               }
               case 'r':{
                   chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'r');
                   break;
               }
               case 'N':{
                   chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'N');
                   break;
               }
               case 'n':{
                   chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'n');
                   break;
               }
               case 'B':{
                   chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'B');
                   break;
               }
               case 'b':{
                   chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'b');
                   break;
               }
               case 'Q':{
                   chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'Q');
                   break;
               }
               case 'q':{
                   chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'q');
                   break;
               }
               case 'K':{
                   chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.BLACK,'K');
                   break;
               }
               case 'k':{
                   chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),ChessColor.WHITE,'k');
                   break;
               }
           }
           chessComponents[sourceX][sourceY]= new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
           if (getCurrentPlayer()==ChessColor.BLACK){
               currentPlayer=ChessColor.WHITE;
           }else{ currentPlayer=ChessColor.BLACK;}
              
           return true;
       }else return false;
    }
}
