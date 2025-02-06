import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;


    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0)=='b'){
            currentPlayer = ChessColor.BLACK;
        }
        if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer = ChessColor.WHITE;
        }
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, new ChessboardPoint(i, j));
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, new ChessboardPoint(i, j));
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j));
                }
                chessComponents[i][j].setChessboard(chessComponents);
                chessComponents[i][j].setItsConcreteGame(this);

            }
        }}
    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0 ;i<8 ;i++){
            for (int j=0;j<8;j++){
                if(chessComponents[i][j] instanceof RookChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('R');
                }
                else if(chessComponents[i][j] instanceof RookChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('r');
                }
                else if(chessComponents[i][j] instanceof KnightChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('N');
                }
                else if(chessComponents[i][j] instanceof KnightChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('n');
                }
                else if(chessComponents[i][j] instanceof KingChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('K');
                }
                else if(chessComponents[i][j] instanceof KingChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('k');
                }
                else if(chessComponents[i][j] instanceof QueenChessComponent&& (chessComponents[i][j]).getColor()==ChessColor.BLACK){
                    stringBuilder.append('Q');
                }
                else if(chessComponents[i][j] instanceof QueenChessComponent&& (chessComponents[i][j]).getColor()==ChessColor.WHITE){
                    stringBuilder.append('q');
                }
                else if(chessComponents[i][j] instanceof BishopChessComponent&& (chessComponents[i][j]).getColor()==ChessColor.BLACK){
                    stringBuilder.append('B');
                }
                else if(chessComponents[i][j] instanceof BishopChessComponent&& (chessComponents[i][j]).getColor()==ChessColor.WHITE){
                    stringBuilder.append('b');
                }
                else if(chessComponents[i][j] instanceof PawnChessComponent&&chessComponents[i][j].getColor()==ChessColor.BLACK){
                    stringBuilder.append('P');
                }
                else if(chessComponents[i][j] instanceof PawnChessComponent&&chessComponents[i][j].getColor()==ChessColor.WHITE){
                    stringBuilder.append('p');
                }
                if(chessComponents[i][j] instanceof EmptySlotComponent){
                    stringBuilder.append('_');
                }
            }
            if (i!=7)
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int King = 0;
        int Queen = 0;
        int Rook = 0;
        int Bishop = 0;
        int Knight = 0;
        int Pawn = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((chessComponents[i][j]).getColor() == player ){
                    if ( chessComponents[i][j] instanceof KingChessComponent) {
                        King++;
                    } else if ( chessComponents[i][j] instanceof QueenChessComponent) {
                        Queen++;
                    } else if (chessComponents[i][j] instanceof RookChessComponent) {
                        Rook++;
                    } else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        Bishop++;
                    } else if ( chessComponents[i][j] instanceof KnightChessComponent) {
                        Knight++;
                    } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        Pawn++;
                    }
                }

            }
        }
        String s ="";
        if (player==ChessColor.BLACK){
            if(King !=1){
                s+="K "+(1-King)+"\n";
            }
            if(Queen !=1){
                s+= "Q "+(1-Queen)+"\n";
            }
            if(Rook !=2){
                s+="R "+(2-Rook)+"\n";
            }
            if(Bishop !=2){
                s+="B "+(2-Bishop)+"\n";
            }
            if(Knight !=2){
                s+="N "+(2-Knight)+"\n";
            }
            if(Pawn !=8){
                s+="P "+(8-Pawn)+"\n";
            }
        }else if (player == ChessColor.WHITE){
            if(King !=1){
                s+="K "+(1-King)+"\n";
            }
            if(Queen !=1){
                s+= "Q "+(1-Queen)+"\n";
            }
            if(Rook !=2){
                s+="R "+(2-Rook)+"\n";
            }
            if(Bishop !=2){
                s+="B "+(2-Bishop)+"\n";
            }
            if(Knight !=2){
                s+="N "+(2-Knight)+"\n";
            }
            if(Pawn !=8){
                s+="P "+(8-Pawn)+"\n";
            }
        }
        return  s ;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        ChessComponent chess=chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int r1=Math.min(sourceX, targetX);
        int r2=Math.max(sourceX, targetX);
        int c1=Math.min(sourceY, targetY);
        int c2=Math.max(sourceY, targetY);
        if (sourceX>7||sourceY>7)
            return false;
        if (targetX>7||targetY>7)
            return false;
        ChessComponent destination = chessComponents[targetX][targetY];
        ChessComponent source=chessComponents[sourceX][sourceY];
        if (source instanceof KnightChessComponent) {
            int r = Math.abs(sourceX - targetX);
            int c = Math.abs(sourceY - targetY);
            if ((r == 1 && c == 2) || (r == 2 && c == 1)) {
                if (destination instanceof EmptySlotComponent) {
                    return true;
                }
            } else
                return false;
        }else if  (source instanceof RookChessComponent) {

            if(sourceX==targetX&&sourceY==targetY){
                return false;
            }
            if(sourceY==targetY){
                for(int i=r1;i<=r2;i++){
                    if(chessComponents[i][sourceY]!=source){
                        if((chessComponents[i][sourceY]==destination&&(!(destination instanceof EmptySlotComponent)))){
                            if(source.getColor()==destination.getColor()) {
                                return false;
                            }
                        }else if(!(chessComponents[i][sourceY] instanceof EmptySlotComponent))
                        {
                            return false;

                        }
                    }
                }
                return true;
            }
            if(sourceX==targetX){
                for(int i=c1;i<=c2;i++){
                    if(chessComponents[sourceX][i]!=source){
                        if((chessComponents[sourceX][i]==destination&&(!(destination instanceof EmptySlotComponent))))
                        {
                            if(source.getColor()==destination.getColor()) {
                                return false;
                            }
                        }else if(!(chessComponents[sourceX][i] instanceof EmptySlotComponent))
                        {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;


        }else if  (source instanceof KingChessComponent) {
            if(((Math.abs(sourceY-targetY)+Math.abs(sourceX-targetX))==1)||(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY)&&Math.abs(sourceX-targetX)==1)){
                if (destination instanceof EmptySlotComponent){
                    return true;
                }else
                {
                    return false;
                }
            }

        }else if  (source instanceof QueenChessComponent) {
            if(sourceX==targetX&&sourceY==targetY){
                return false;
            }
            if(sourceY==targetY){
                for(int i=r1;i<=r2;i++){
                    if(chessComponents[i][sourceY]!=source){
                        if((chessComponents[i][sourceY]==destination&&(!(destination instanceof EmptySlotComponent)))){
                            if(source.getColor()==destination.getColor()) {
                                return false;
                            }
                        }else if(!(chessComponents[i][sourceY] instanceof EmptySlotComponent))
                        {
                            return false;

                        }
                    }
                }
                return true;
            }
            if(sourceX==targetX){
                for(int i=c1;i<=c2;i++){
                    if(chessComponents[sourceX][i]!=source){
                        if((chessComponents[sourceX][i]==destination&&(!(destination instanceof EmptySlotComponent))))
                        {
                            if(source.getColor()==destination.getColor()) {
                                return false;
                            }
                        }else if(!(chessComponents[sourceX][i] instanceof EmptySlotComponent))
                        {
                            return false;
                        }
                    }
                }
                return true;
            }
            if(!samediagonal(sourceX,sourceY,targetX,targetY)){
                return false;
            }
            for(int i=c1;i<=c2;i++){
                for(int j=r1;j<=r2;j++){
                    ChessboardPoint temp=chessComponents[i][j].getChessboardPoint();
                    if(chessComponents[i][j]!=source&&samediagonal(temp.getX(),temp.getY(),sourceX,sourceY)){
                        if(temp==destination.getChessboardPoint()&&(!(destination instanceof EmptySlotComponent))){
                            if(source.getColor()==destination.getColor()) {
                                return false;
                            }
                        }else if (!(chessComponents[i][j] instanceof EmptySlotComponent)){
                            return false;
                        }
                    }
                }
                return true;
            }


        }else if  (source instanceof PawnChessComponent) {

            if (sameline(sourceX,sourceY,targetX,targetY)||(samediagonal(sourceX,sourceY,targetX,targetY)))
            {
                if(sourceX==6&&(source.getColor()==ChessColor.WHITE)){
                    if ((destination==chessComponents[sourceX-2][sourceY]||destination==chessComponents[sourceX-1][sourceY])&&(destination instanceof  EmptySlotComponent)){
                        return true;
                    }else if ((samediagonal(sourceX,sourceY,targetX,targetY))&&(Math.abs(sourceX-targetX)==1)&&(destination.getColor()!=source.getColor())&&(!(destination instanceof EmptySlotComponent))){
                        return true;
                    }
                }else if(sourceX==1&&(source.getColor()==ChessColor.BLACK)){
                    if ((destination==chessComponents[sourceX+2][sourceY]||destination==chessComponents[sourceX+1][sourceY])&&(destination instanceof  EmptySlotComponent)){
                        return true;
                    }else if ((samediagonal(sourceX,sourceY,targetX,targetY))&&(Math.abs(sourceX-targetX)==1)&&(destination.getColor()!=source.getColor())&&(!(destination instanceof EmptySlotComponent))){
                        return true;
                    }
                }else
                {
                    if (source.getColor()==ChessColor.WHITE){
                        if ((destination==chessComponents[sourceX-1][sourceY])&&(destination instanceof  EmptySlotComponent)){
                            return true;
                        }else if ((samediagonal(sourceX,sourceY,targetX,targetY))&&(Math.abs(sourceX-targetX)==1)&&(destination.getColor()!=source.getColor())&&(!(destination instanceof EmptySlotComponent))){
                            return true;
                        }
                    }else if (source.getColor()==ChessColor.BLACK){
                        if ((destination==chessComponents[sourceX+1][sourceY])&&(destination instanceof  EmptySlotComponent)){
                            return true;
                        }else if ((samediagonal(sourceX,sourceY,targetX,targetY))&&(Math.abs(sourceX-targetX)==1)&&(destination.getColor()!=source.getColor())&&(!(destination instanceof EmptySlotComponent))){
                            return true;
                        }
                    }

                }

            }

        }else if  (source instanceof BishopChessComponent) {
            if (sourceY - targetY== sourceX - targetX){
                for (int i = 0;i <= Math.abs(sourceX - targetX)-2;i++) {
                    if (!(chessComponents[r1+i][c1+i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else if (sourceY - targetY == -(sourceX - targetX)){
                for (int i = 0;i <= Math.abs(sourceX - targetX)-2;i++) {
                    if (!(chessComponents[r1+i][c2-i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;

        }

        return false;

    }

   
    


    public boolean sameline(int sourceX, int sourceY, int targetX, int targetY) {
        if ((sourceX == targetX && sourceY != targetY) || (sourceY == targetY && sourceX != targetX)) {
            return true;
        }
        return false;
    }
    public boolean samediagonal(int sourceX, int sourceY, int targetX, int targetY) {
        if (Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY)) {
            return true;
        }
        return false;
    }
}
