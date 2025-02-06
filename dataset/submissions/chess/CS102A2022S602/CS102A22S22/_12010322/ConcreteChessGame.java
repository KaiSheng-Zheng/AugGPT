import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private static ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    List<String> load=new ArrayList<>();



    public void loadChessGame(List<String> chessboard){
        for(ChessComponent cs : chess.pawnList){
            cs.setSource(chess.defaultSource);
        }
        chess.bBishop1.setSource(chess.defaultSource);
        chess.bBishop2.setSource(chess.defaultSource);
        chess.wBishop1.setSource(chess.defaultSource);
        chess.wBishop2.setSource(chess.defaultSource);
        chess.bRook1.setSource(chess.defaultSource);
        chess.bRook2.setSource(chess.defaultSource);
        chess.wRook1.setSource(chess.defaultSource);
        chess.wRook2.setSource(chess.defaultSource);
        chess.bKnight1.setSource(chess.defaultSource);
        chess.bKnight2.setSource(chess.defaultSource);
        chess.wKnight1.setSource(chess.defaultSource);
        chess.wKnight2.setSource(chess.defaultSource);
        chess.bKing.setSource(chess.defaultSource);
        chess.wKing.setSource(chess.defaultSource);
        chess.bQueen.setSource(chess.defaultSource);
        chess.wQueen.setSource(chess.defaultSource);

        if(chessboard.get(8).equals("b")){this.currentPlayer=ChessColor.BLACK;}
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char name=chessboard.get(i).charAt(j);
                switch (name){
                    case '_':
                        chessComponents[i][j]=new EmptySlotComponent(i,j);
                        break;
                    case 'k':
                        chessComponents[i][j]=chess.wKing;
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;
                    case 'K':
                        chessComponents[i][j]=chess.bKing;
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;
                    case 'q':
                        chessComponents[i][j]=chess.wQueen;
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;
                    case 'Q':
                        chessComponents[i][j]=chess.bQueen;
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;
                    case'r':
                        if(chess.wRook1.getSource().getX()==-1){
                            chessComponents[i][j]=chess.wRook1;
                        }else {
                            chessComponents[i][j]=chess.wRook2;
                        }
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;
                    case 'R':
                        if(chess.bRook1.getSource().getX()==-1){
                            chessComponents[i][j]=chess.bRook1;
                        }else {
                            chessComponents[i][j]=chess.bRook2;
                        }
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;
                    case'n':
                        if(chess.wKnight1.getSource().getX()==-1){
                            chessComponents[i][j]=chess.wKnight1;
                        }else {
                            chessComponents[i][j]=chess.wKnight2;
                        }
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;
                    case 'N':
                        if(chess.bKnight1.getSource().getX()==-1){
                            chessComponents[i][j]=chess.bKnight1;
                        }else {
                            chessComponents[i][j]=chess.bKnight2;
                        }
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;
                    case'b':
                        if(chess.wBishop1.getSource().getX()==-1){
                            chessComponents[i][j]=chess.wBishop1;
                        }else {
                            chessComponents[i][j]=chess.wBishop2;
                        }
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;
                    case 'B':
                        if(chess.bBishop1.getSource().getX()==-1){
                            chessComponents[i][j]=chess.bBishop1;
                        }else {
                            chessComponents[i][j]=chess.bBishop2;
                        }
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;

                    case 'p':
                        for (int k = 0; k < 8; k++) {
                            if (chess.pawnList[k].getSource().getX()==-1){
                                chessComponents[i][j]=chess.pawnList[k];
                                break;
                            }
                        }
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;

                    case 'P':
                        for (int k = 8; k < 16; k++) {
                            if (chess.pawnList[k].getSource().getX()==-1){
                                chessComponents[i][j]=chess.pawnList[k];
                                break;
                            }
                        }
                        chessComponents[i][j].setSource(new ChessboardPoint(i,j));
                        break;

                    default:
                        break;

                }
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        char[][] names=new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                names[i][j]=chessComponents[i][j].name;
            }
        }
        String[] load=new String[8];
        for (int i = 0; i < 8; i++) {
            load[i]=String.valueOf(names[i]);
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",load[0],load[1],load[2],load[3],load[4],load[5],load[6],load[7]);
    }

    public ChessComponent getChess(int x, int y){
        if(x>=0&&x<8&&y>=0&&y<8) {
            return chessComponents[x][y];
        }
            return null;
    }

    public String getCapturedChess(ChessColor player) {

        int k = 0;
        int q = 0;
        int r = 0;
        int b = 0;
        int n = 0;
        int  p = 0;
        if (player==ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name== 'k') {
                         k ++;
                    } else if (chessComponents[i][j].name == 'q') {
                         q ++;
                    } else if (chessComponents[i][j].name == 'r') {
                         r ++;
                    } else if (chessComponents[i][j].name == 'b') {
                         b ++;
                    } else if (chessComponents[i][j].name == 'n') {
                         n ++;
                    } else if(chessComponents[i][j].name=='p'){
                         p ++;
                    }
                }
            }
            String[] capturedChesses = new String[6];
            capturedChesses[0] = String.format("k %d\n", 1 -  k);
            capturedChesses[1] = String.format("q %d\n", 1 -  q);
            capturedChesses[2] = String.format("r %d\n", 2 -  r);
            capturedChesses[3] = String.format("b %d\n",2-b);
            capturedChesses[4] = String.format("n %d\n",2- n);
            capturedChesses[5] = String.format("p %d\n",8- p);
            String answer="";
            for (int i = 0; i < 6; i++) {
                if(capturedChesses[i].charAt(2)!='0'){
                    answer=answer+capturedChesses[i];
                }
            }
            return answer;
        }else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                         k++;
                    } else if (chessComponents[i][j].name == 'Q') {
                        q++;
                    } else if (chessComponents[i][j].name == 'R') {
                        r++;
                    } else if (chessComponents[i][j].name == 'B') {
                        b++;
                    } else if (chessComponents[i][j].name == 'N') {
                        n++;
                    } else if(chessComponents[i][j].name=='P'){
                        p ++;
                    }
                }
            }
            String[] capturedChesses = new String[6];
            capturedChesses[0] = String.format("K %d\n", 1 - k);
            capturedChesses[1] = String.format("Q %d\n", 1 - q);
            capturedChesses[2] = String.format("R %d\n", 2 - r);
            capturedChesses[3] = String.format("B %d\n",2-b);
            capturedChesses[4] = String.format("N %d\n",2- n);
            capturedChesses[5] = String.format("P %d\n",8- p);
            String answer="";
            for (int i = 0; i < 6; i++) {
                if(capturedChesses[i].charAt(2)!='0'){
                    answer=answer+capturedChesses[i];
                }
            }
            return answer;
        }
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        ChessComponent chess=getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return canMovePoints;
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent chess=getChess(sourceX,sourceY);
        if(chess.canMoveTo(targetX,targetY)&&chess.getChessColor()==currentPlayer){
            if(currentPlayer==ChessColor.WHITE){currentPlayer=ChessColor.BLACK;}
            else {currentPlayer=ChessColor.WHITE;}
            ChessComponent empty=new EmptySlotComponent(sourceX,sourceY);
            ChessboardPoint target=new ChessboardPoint(targetX,targetY);
            chess.setSource(target);
            chessComponents[targetX][targetY]=chess;
            chessComponents[sourceX][sourceY]=empty;
            return true;
        }
        return false;
    }



}
