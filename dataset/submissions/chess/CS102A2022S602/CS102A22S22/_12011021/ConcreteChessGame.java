import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    public void standardloading(){
        chessComponents[0][0]=data.BlackRook1;  chessComponents[0][0].setSource(new ChessboardPoint(0,0));
        chessComponents[0][1]=data.BlackKnight1;  chessComponents[0][1].setSource(new ChessboardPoint(0,1));
        chessComponents[0][2]=data.BlackBishop1;  chessComponents[0][2].setSource(new ChessboardPoint(0,2));
        chessComponents[0][3]=data.BlackQueen;  chessComponents[0][3].setSource(new ChessboardPoint(0,3));
        chessComponents[0][4]=data.BlackKing;  chessComponents[0][4].setSource(new ChessboardPoint(0,4));
        chessComponents[0][5]=data.BlackBishop2;  chessComponents[0][5].setSource(new ChessboardPoint(0,5));
        chessComponents[0][6]=data.BlackKnight2;  chessComponents[0][6].setSource(new ChessboardPoint(0,6));
        chessComponents[0][7]=data.BlackRook2;  chessComponents[0][7].setSource(new ChessboardPoint(0,7));
        chessComponents[1][0]=data.BlackPawn1;  chessComponents[1][0].setSource(new ChessboardPoint(1,0));
        chessComponents[1][1]=data.BlackPawn2;  chessComponents[1][1].setSource(new ChessboardPoint(1,1));
        chessComponents[1][2]=data.BlackPawn3;  chessComponents[1][2].setSource(new ChessboardPoint(1,2));
        chessComponents[1][3]=data.BlackPawn4;  chessComponents[1][3].setSource(new ChessboardPoint(1,3));
        chessComponents[1][4]=data.BlackPawn5;  chessComponents[1][4].setSource(new ChessboardPoint(1,4));
        chessComponents[1][5]=data.BlackPawn6;  chessComponents[1][5].setSource(new ChessboardPoint(1,5));
        chessComponents[1][6]=data.BlackPawn7;  chessComponents[1][6].setSource(new ChessboardPoint(1,6));
        chessComponents[1][7]=data.BlackPawn8;  chessComponents[1][7].setSource(new ChessboardPoint(1,7));
        chessComponents[7][0]=data.WhiteRook1;  chessComponents[7][0].setSource(new ChessboardPoint(7,0));
        chessComponents[7][1]=data.WhiteKnight1;  chessComponents[7][1].setSource(new ChessboardPoint(7,1));
        chessComponents[7][2]=data.WhiteBishop1;  chessComponents[7][2].setSource(new ChessboardPoint(7,2));
        chessComponents[7][3]=data.WhiteQueen;  chessComponents[7][3].setSource(new ChessboardPoint(7,3));
        chessComponents[7][4]=data.WhiteKing;  chessComponents[7][4].setSource(new ChessboardPoint(7,4));
        chessComponents[7][5]=data.WhiteBishop2;  chessComponents[7][5].setSource(new ChessboardPoint(7,5));
        chessComponents[7][6]=data.WhiteKnight2;  chessComponents[7][6].setSource(new ChessboardPoint(7,6));
        chessComponents[7][7]=data.WhiteRook2;  chessComponents[7][7].setSource(new ChessboardPoint(7,7));
        chessComponents[6][0]=data.WhitePawn1;  chessComponents[6][0].setSource(new ChessboardPoint(6,0));
        chessComponents[6][1]=data.WhitePawn2;  chessComponents[6][1].setSource(new ChessboardPoint(6,1));
        chessComponents[6][2]=data.WhitePawn3;  chessComponents[6][2].setSource(new ChessboardPoint(6,2));
        chessComponents[6][3]=data.WhitePawn4;  chessComponents[6][3].setSource(new ChessboardPoint(6,3));
        chessComponents[6][4]=data.WhitePawn5;  chessComponents[6][4].setSource(new ChessboardPoint(6,4));
        chessComponents[6][5]=data.WhitePawn6;  chessComponents[6][5].setSource(new ChessboardPoint(6,5));
        chessComponents[6][6]=data.WhitePawn7;  chessComponents[6][6].setSource(new ChessboardPoint(6,6));
        chessComponents[6][7]=data.WhitePawn8;  chessComponents[6][7].setSource(new ChessboardPoint(6,7));
        for (int x = 2; x <6 ; x++) {
            for (int y = 0; y < 8; y++) {
                chessComponents[x][y]=new EmptySlotComponent(new ChessboardPoint(x,y));
            }
        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessesDataClean();
        if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char textname = chessboard.get(i).charAt(j);
                switch (textname) {
                        case '_':
                            chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j));
                            break;
                        case 'K':
                            chessComponents[i][j] = data.allChessComponent[0];
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'k':
                            chessComponents[i][j] = data.allChessComponent[16];
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'Q':
                            chessComponents[i][j] = data.allChessComponent[1];
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'q':
                            chessComponents[i][j] = data.allChessComponent[17];
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'R':
                            if (data.allChessComponent[2].getSource().getX() == -1) {
                                chessComponents[i][j] = data.allChessComponent[2];
                            } else {
                                chessComponents[i][j] = data.allChessComponent[3];
                            }
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'r':
                            if (data.allChessComponent[18].getSource().getX() == -1) {
                                chessComponents[i][j] = data.allChessComponent[18];
                            } else {
                                chessComponents[i][j] = data.allChessComponent[19];
                            }
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'B':
                            if (data.allChessComponent[4].getSource().getX() == -1) {
                                chessComponents[i][j] = data.allChessComponent[4];
                            } else {
                                chessComponents[i][j] = data.allChessComponent[5];
                            }
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'b':
                            if (data.allChessComponent[20].getSource().getX() == -1) {
                                chessComponents[i][j] = data.allChessComponent[20];
                            } else {
                                chessComponents[i][j] = data.allChessComponent[21];
                            }
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'N':
                            if (data.allChessComponent[6].getSource().getX() == -1) {
                                chessComponents[i][j] = data.allChessComponent[6];
                            } else {
                                chessComponents[i][j] = data.allChessComponent[7];
                            }
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'n':
                            if (data.allChessComponent[22].getSource().getX() == -1) {
                                chessComponents[i][j] = data.allChessComponent[22];
                            } else {
                                chessComponents[i][j] = data.allChessComponent[23];
                            }
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'P':
                            int checker1 = 7;
                            for (int k = 0; k < 8; k++) {
                                if (data.allChessComponent[8 + k].getSource().getX() == -1) {
                                    checker1 = k;
                                    break;
                                }
                            }
                            chessComponents[i][j] = data.allChessComponent[8 + checker1];
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
                            break;
                        case 'p':
                            int checker2 = 7;
                            for (int k = 0; k < 8; k++) {
                                if (data.allChessComponent[24 + k].getSource().getX() == -1) {
                                    checker2 = k;
                                    break;
                                }
                            }
                            chessComponents[i][j] = data.allChessComponent[24 + checker2];
                            chessComponents[i][j].setSource(new ChessboardPoint(i, j));
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
        String[] answers=new String[8];
        for (int i = 0; i < 8; i++) {
            answers[i]=String.valueOf(names[i]);
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",answers[0],answers[1],answers[2],answers[3],answers[4],answers[5],answers[6],answers[7]);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        char[][] names=new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                names[i][j]=chessComponents[i][j].name;
            }
        }
        int counterk = 0;
        int counterq = 0;
        int counterr = 0;
        int counterb = 0;
        int countern = 0;
        int counterp = 0;
        if (player==ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (names[i][j] == 'k') {
                        counterk = 1;
                    } else if (names[i][j] == 'q') {
                        counterq = 1;
                    } else if (names[i][j] == 'r') {
                        counterr = counterr + 1;
                    } else if (names[i][j] == 'b') {
                        counterb = counterb + 1;
                    } else if (names[i][j] == 'n') {
                        countern = countern + 1;
                    } else if(names[i][j]=='p'){
                        counterp = counterp + 1;
                    }
                }
            }
            String[] capturedChesses = new String[6];
            capturedChesses[0] = String.format("k %d\n", 1 - counterk);
            capturedChesses[1] = String.format("q %d\n", 1 - counterq);
            capturedChesses[2] = String.format("r %d\n", 2 - counterr);
            capturedChesses[3] = String.format("b %d\n",2-counterb);
            capturedChesses[4] = String.format("n %d\n",2-countern);
            capturedChesses[5] = String.format("p %d\n",8-counterp);
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
                    if (names[i][j] == 'K') {
                        counterk = 1;
                    } else if (names[i][j] == 'Q') {
                        counterq = 1;
                    } else if (names[i][j] == 'R') {
                        counterr = counterr + 1;
                    } else if (names[i][j] == 'B') {
                        counterb = counterb + 1;
                    } else if (names[i][j] == 'N') {
                        countern = countern + 1;
                    } else if(names[i][j]=='P'){
                        counterp = counterp + 1;
                    }
                }
            }
            String[] capturedChesses = new String[6];
            capturedChesses[0] = String.format("K %d\n", 1 - counterk);
            capturedChesses[1] = String.format("Q %d\n", 1 - counterq);
            capturedChesses[2] = String.format("R %d\n", 2 - counterr);
            capturedChesses[3] = String.format("B %d\n",2-counterb);
            capturedChesses[4] = String.format("N %d\n",2-countern);
            capturedChesses[5] = String.format("P %d\n",8-counterp);
            String answer="";
            for (int i = 0; i < 6; i++) {
                if(capturedChesses[i].charAt(2)!='0'){
                    answer=answer+capturedChesses[i];
                }
            }
            return answer;
        }
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if((x>=0&x<8)&(y>=0&y<8)) {
            return chessComponents[x][y];
        }else {
            return null;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(currentPlayer!=chessComponents[sourceX][sourceY].getChessColor()){
            return false;
        }else {
            boolean can=false;
            for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                if ((targetX == chessComponents[sourceX][sourceY].canMoveTo().get(i).getX()) & (targetY == chessComponents[sourceX][sourceY].canMoveTo().get(i).getY())) {
                    can = true;
                    break;
                }
            }
            if (can) {
                ChessComponent copy=chessComponents[sourceX][sourceY];
                copy.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(-1,-1));
                chessComponents[targetX][targetY]=copy;
                if(currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }else {
                    currentPlayer=ChessColor.BLACK;
                }
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x=source.getX();
        int y=source.getY();
        int pointsAmount=chessComponents[x][y].canMoveTo().size();
        ArrayList<Integer> middleHandlingNumbers=new ArrayList<>();
        ArrayList<ChessboardPoint> middleHandlingPoints=new ArrayList<>();
        List<ChessboardPoint> sortedLocations=new ArrayList<>();
        for (int i = 0; i <pointsAmount ; i++) {
            middleHandlingNumbers.add(chessComponents[x][y].canMoveTo().get(i).getX()*10+chessComponents[x][y].canMoveTo().get(i).getY());
            middleHandlingPoints.add(chessComponents[x][y].canMoveTo().get(i));
        }
        for (int i = 0; i < pointsAmount; i++) {
            if(middleHandlingNumbers.size()==1){
                sortedLocations.add(middleHandlingPoints.get(0));
            }else {
                int catcher=0;
                int minimum=middleHandlingNumbers.get(0);
                for (int j = 1; j < middleHandlingNumbers.size(); j++) {
                    if (middleHandlingNumbers.get(j)<minimum){
                        minimum=middleHandlingNumbers.get(j);
                        catcher=j;
                    }
                }
                sortedLocations.add(middleHandlingPoints.get(catcher));
                middleHandlingNumbers.remove(catcher);
                middleHandlingPoints.remove(catcher);
            }
        }
        return sortedLocations;
    }

    public void chessesDataClean(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j] = null;
            }
        }
        for (int i = 0; i < 32; i++) {
            data.allChessComponent[i].setSource(new ChessboardPoint(-1,-1));
        }
    }
}