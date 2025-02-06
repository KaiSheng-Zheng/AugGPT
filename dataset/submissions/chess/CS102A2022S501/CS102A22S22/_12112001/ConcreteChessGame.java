import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private static ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
          for(int j=0;j<8;j++){
              if(chessboard.get(i).charAt(j)=='R'){
                  chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
              }else if(chessboard.get(i).charAt(j)=='N'){
                  chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
              }else if(chessboard.get(i).charAt(j)=='Q'){
                  chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
              }else if(chessboard.get(i).charAt(j)=='K'){
                  chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
              }else if(chessboard.get(i).charAt(j)=='P'){
                  chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
              }else if(chessboard.get(i).charAt(j)=='_'){
                  chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
              }else if(chessboard.get(i).charAt(j)=='r'){
                  chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
              }else if(chessboard.get(i).charAt(j)=='n'){
                  chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
              }else if(chessboard.get(i).charAt(j)=='k'){
                  chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
              }else if(chessboard.get(i).charAt(j)=='q'){
                  chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
              }else if(chessboard.get(i).charAt(j)=='p'){
                  chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
              }else if(chessboard.get(i).charAt(j)=='b'){
                  chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
              }else if(chessboard.get(i).charAt(j)=='B'){
                  chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
              }
          }
        }
        if(chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
        }else if(chessboard.get(8).charAt(0)=='b'){
            currentPlayer=ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder XX = new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j] instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    XX.append('R');
                }else if(chessComponents[i][j] instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    XX.append('Q');
                }else if(chessComponents[i][j] instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    XX.append('B');
                }else if(chessComponents[i][j] instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    XX.append('N');
                }else if(chessComponents[i][j] instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK ){
                    XX.append('K');
                }else if (chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){
                    XX.append("P");
                }if (chessComponents[i][j]instanceof EmptySlotComponent&&chessComponents[i][j].getChessColor()==ChessColor.NONE){
                    XX.append("_");
                }else if (chessComponents[i][j]instanceof BishopChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    XX.append("b");
                }else if (chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    XX.append("k");
                } else if (chessComponents[i][j]instanceof KnightChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    XX.append("n");
                } else if (chessComponents[i][j]instanceof PawnChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    XX.append("p");
                } else if (chessComponents[i][j]instanceof QueenChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    XX.append("q");
                }else if (chessComponents[i][j]instanceof RookChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){
                    XX.append("r");
                }
            }XX.append("\n");
        }
        return XX.toString();
    }

    public String getCapturedChess(ChessColor player){
        int r=0;
        int q=0;
        int k=0;
        int b=0;
        int n=0;
        int p=0;
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if (player==ChessColor.BLACK){
                if (chessComponents[i][j].getChessColor().equals(ChessColor.BLACK)) {
                    if (chessComponents[i][j] instanceof BishopChessComponent) {
                        b++;
                    } else if (chessComponents[i][j] instanceof KingChessComponent) {
                        k++;
                    } else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        n++;
                    } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        p++;
                    } else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        q++;
                    } else if (chessComponents[i][j] instanceof RookChessComponent) {
                        r++;
                    }
                }
                }
            }
        }
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if(player==ChessColor.WHITE) {
                    if (chessComponents[i][j].getChessColor().equals(ChessColor.WHITE)) {
                        if (chessComponents[i][j] instanceof BishopChessComponent) {
                            b++;
                        } else if (chessComponents[i][j] instanceof KingChessComponent) {
                            k++;
                        } else if (chessComponents[i][j] instanceof KnightChessComponent) {
                            n++;
                        } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                            p++;
                        } else if (chessComponents[i][j] instanceof QueenChessComponent) {
                            q++;
                        } else if (chessComponents[i][j] instanceof RookChessComponent) {
                            r++;
                        }
                    }
                }
            }
        }
        StringBuilder xyz=new StringBuilder();
        if(player==ChessColor.BLACK){
            if(k!=1){
                 xyz.append("K ").append(1-k).append("\n");
            }
            if(q!=1){
                xyz.append("Q ").append(1-q).append("\n");
            }
            if(r!=2){
                xyz.append("R ").append(2-r).append("\n");
            }
            if(b!=2){
                xyz.append("B ").append(2-b).append("\n");
            }
            if(n!=2){
                xyz.append("N ").append(2-n).append("\n");
            }
            if(p!=8){
                xyz.append("P ").append(8-p).append("\n");
            }
        }
        if (player==ChessColor.WHITE){
            if(k!=1){
                xyz.append("k ").append(1-k).append("\n");
            }
            if(q!=1){
                xyz.append("q ").append(1-q).append("\n");
            }
            if (r!=2){
                xyz.append("r ").append(2-r).append("\n");
            }
            if(b!=2){
                xyz.append("b ").append(2-b).append("\n");
            }
            if(n!=2){
                xyz.append("n ").append(2-n).append("\n");
            }
            if(p!=8){
                xyz.append("p ").append(8-p).append("\n");
            }
        }
        return xyz.toString();
    }

    public ChessComponent getChess(int x,int y){
        return chessComponents[x][y];
    }


@Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if(chessComponents[sourceX][sourceY].getChessColor()==currentPlayer) {
            boolean x=false;
            for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == chessComponents[targetX][targetY].getChessboardPoint().getX()
                        && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == chessComponents[targetX][targetY].getChessboardPoint().getY()) {
                   x=true;
                }
            }
            if(x){
                if (chessComponents[sourceX][sourceY].name == 'K') {
                    chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'K');
                }
                if (chessComponents[sourceX][sourceY].name == 'Q') {
                    chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'Q');
                }
                if (chessComponents[sourceX][sourceY].name == 'B') {
                    chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'B');
                }
                if (chessComponents[sourceX][sourceY].name == 'N') {
                    chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'N');
                }
                if (chessComponents[sourceX][sourceY].name == 'R') {
                    chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'R');
                }
                if (chessComponents[sourceX][sourceY].name == 'k') {
                    chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'k');
                }
                if (chessComponents[sourceX][sourceY].name == 'q') {
                    chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'q');
                }
                if (chessComponents[sourceX][sourceY].name == 'b') {
                    chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'b');
                }
                if (chessComponents[sourceX][sourceY].name == 'n') {
                    chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'n');
                }
                if (chessComponents[sourceX][sourceY].name == 'r') {
                    chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'r');
                }
                if (chessComponents[sourceX][sourceY].name == 'p') {
                    chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'p');
                }
                if (chessComponents[sourceX][sourceY].name == 'P') {
                    chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'P');
                }
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                if (currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }

        }
        return false;
    }
@Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public static ChessComponent[][] getChessComponents() {
        return chessComponents;
    }


}
