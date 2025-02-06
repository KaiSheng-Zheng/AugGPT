import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;

    private ChessColor currentPlayer;


    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer=ChessColor.WHITE;
        }else {
            this.currentPlayer=ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');

                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');

                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                } else if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
             chessComponents[i][j].setChessboard(this.chessComponents);
            }

        }
    }




    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                status.append(this.chessComponents[i][j].name);
            }
            status.append("\n");
//            status.append(System.getProperty("line.separator"));
        }
        return status.toString();
    }

    public String getCapturedChess(ChessColor player) {

        StringBuilder capturedchess = new StringBuilder();
        int numberR = 2;
        int numberN = 2;
        int numberB = 2;
        int numberQ = 1;
        int numberK = 1;
        int numberP = 8;
        int numberr = 2;
        int numbern = 2;
        int numberb = 2;
        int numberq = 1;
        int numberk = 1;
        int numberp = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.chessComponents[i][j].name=='R')  {
                    numberR--;

                } else if (this.chessComponents[i][j].name=='N'){
                    numberN--;
                } else if (this.chessComponents[i][j].name=='B') {
                    numberB--;

                } else if (this.chessComponents[i][j].name=='Q') {
                    numberQ--;
                } else if (this.chessComponents[i][j].name=='K') {
                    numberK--;
                } else if (this.chessComponents[i][j].name=='P') {
                    numberP--;
                }
                if (this.chessComponents[i][j].name=='r') {
                    numberr--;
                } else if (this.chessComponents[i][j].name=='n') {
                    numbern--;
                } else if (this.chessComponents[i][j].name=='b') {
                    numberb--;
                } else if (this.chessComponents[i][j].name=='q') {
                    numberq--;
                } else if (this.chessComponents[i][j].name=='k') {
                    numberk--;
                } else if (this.chessComponents[i][j].name=='p') {
                    numberp--;
                }
            }

        }
        if (player == ChessColor.BLACK) {
            if (numberK != 0) {
                capturedchess.append("K");
                capturedchess.append(" ");
                capturedchess.append(numberK);
                capturedchess.append("\n");
            }  if (numberQ != 0) {
                capturedchess.append("Q");
                capturedchess.append(" ");
                capturedchess.append(numberQ);
                capturedchess.append("\n");
            }  if (numberR != 0) {
                capturedchess.append("R");
                capturedchess.append(" ");
                capturedchess.append(numberR);
                capturedchess.append("\n");
            }  if (numberB != 0) {
                capturedchess.append("B");
                capturedchess.append(" ");
                capturedchess.append(numberB);
                capturedchess.append("\n");
            } if (numberN != 0) {
                capturedchess.append("N");
                capturedchess.append(" ");
                capturedchess.append(numberN);
                capturedchess.append("\n");
            }  if (numberP != 0) {
                capturedchess.append("P");
                capturedchess.append(" ");
                capturedchess.append(numberP);
                capturedchess.append("\n");
            }

        }
        if (player == ChessColor.WHITE) {
            if (numberk != 0) {
                capturedchess.append("k");
                capturedchess.append(" ");
                capturedchess.append(numberk);
                capturedchess.append("\n");
            }  if (numberq != 0) {
                capturedchess.append("q");
                capturedchess.append(" ");
                capturedchess.append(numberq);
                capturedchess.append("\n");
            } if (numberr != 0) {
                capturedchess.append("r");
                capturedchess.append(" ");
                capturedchess.append(numberr);
                capturedchess.append("\n");
            }  if (numberb != 0) {
                capturedchess.append("b");
                capturedchess.append(" ");
                capturedchess.append(numberb);
                capturedchess.append("\n");
            }  if (numbern != 0) {
                capturedchess.append("n");
                capturedchess.append(" ");
                capturedchess.append(numbern);
                capturedchess.append("\n");
            }  if (numberp != 0) {
                capturedchess.append("p");
                capturedchess.append(" ");
                capturedchess.append(numberp);
                capturedchess.append("\n");
            }

        }
        return capturedchess.toString();


    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chessComponent= getChess(source.getX(),source.getY());
        List<ChessboardPoint> CanMovePoints= chessComponent.canMoveTo();
        Collections.sort(CanMovePoints);
        return CanMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessColor chessColor=ChessColor.BLACK;

        ChessboardPoint chu=new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint mo=new ChessboardPoint(targetX,targetY);

        if (currentPlayer==ChessColor.BLACK){
            chessColor = ChessColor.WHITE;
        }
        if (getChess(sourceX,sourceY).getChessColor()==currentPlayer){
            if (getCanMovePoints(getChess(sourceX,sourceY).getSource()).contains(getChess(targetX,targetY).getSource())){

                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(mo);
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE, '_');
                    this.currentPlayer=chessColor;
                    return true;
                }

            return false;
        }else {
            return false;
        }

    }
}



