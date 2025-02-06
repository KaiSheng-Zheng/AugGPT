import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    private ChessComponent[][] chessComponents;

    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents= new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard){
        for(int i=0;i<8;i++){
            String row = chessboard.get(i);
            for(int j=0;j<8;j++){
                char col = row.charAt(j);
                if(col=='_'){chessComponents[i][j]=new EmptySlotComponent(i,j);}
                if(col=='R'){chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.BLACK,'R');}
                if(col=='N'){chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.BLACK,'N');}
                if(col=='B'){chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.BLACK,'B');}
                if(col=='Q'){chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.BLACK,'Q');}
                if(col=='K'){chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.BLACK,'K');}
                if(col=='P'){chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.BLACK,'P');}
                if(col=='r'){chessComponents[i][j]=new RookChessComponent(i,j,ChessColor.WHITE,'r');}
                if(col=='n'){chessComponents[i][j]=new KnightChessComponent(i,j,ChessColor.WHITE,'n');}
                if(col=='b'){chessComponents[i][j]=new BishopChessComponent(i,j,ChessColor.WHITE,'b');}
                if(col=='q'){chessComponents[i][j]=new QueenChessComponent(i,j,ChessColor.WHITE,'q');}
                if(col=='k'){chessComponents[i][j]=new KingChessComponent(i,j,ChessColor.WHITE,'k');}
                if(col=='p'){chessComponents[i][j]=new PawnChessComponent(i,j,ChessColor.WHITE,'p');}
            }
        }
        if(chessboard.get(8).equals("b")){
            setCurrentPlayer(ChessColor.BLACK);
        }
    }

    public ChessComponent[][] getChessComponents() {return chessComponents;}

    public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {this.currentPlayer = currentPlayer;}

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public String getChessboardGraph(){
        StringBuilder row0 = new StringBuilder();
        for(int i=0;i<8;i++){row0.append(chessComponents[0][i].getName());}

        StringBuilder row1 = new StringBuilder();
        for(int i=0;i<8;i++){row1.append(chessComponents[1][i].getName());}

        StringBuilder row2 = new StringBuilder();
        for(int i=0;i<8;i++){row2.append(chessComponents[2][i].getName());}

        StringBuilder row3 = new StringBuilder();
        for(int i=0;i<8;i++){row3.append(chessComponents[3][i].getName());}

        StringBuilder row4 = new StringBuilder();
        for(int i=0;i<8;i++){row4.append(chessComponents[4][i].getName());}

        StringBuilder row5 = new StringBuilder();
        for(int i=0;i<8;i++){row5.append(chessComponents[5][i].getName());}

        StringBuilder row6 = new StringBuilder();
        for(int i=0;i<8;i++){row6.append(chessComponents[6][i].getName());}

        StringBuilder row7 = new StringBuilder();
        for(int i=0;i<8;i++){row7.append(chessComponents[7][i].getName());}

        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s"
                ,row0.toString(), row1.toString(), row2.toString(), row3.toString(), row4.toString(), row5.toString(), row6.toString(), row7.toString());
    }


    public String getCapturedChess(ChessColor player){
        StringBuilder output = new StringBuilder();
        int count=0;
        if(player==ChessColor.WHITE){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='k'){count++;}
                }
            }
            if((1-count)!=0){output.append("k ");output.append(1-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='q'){count++;}
                }
            }
            if((1-count)!=0){output.append("q ");output.append(1-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='r'){count++;}
                }
            }
            if((2-count)!=0){output.append("r ");output.append(2-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='b'){count++;}
                }
            }
            if((2-count)!=0){output.append("b ");output.append(2-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='n'){count++;}
                }
            }
            if((2-count)!=0){output.append("n ");output.append(2-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='p'){count++;}
                }
            }
            if((8-count)!=0){output.append("p ");output.append(8-count);output.append("\n");}
            count=0;
            return output.toString();

        }else{

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='K'){count++;}
                }
            }
            if((1-count)!=0){output.append("K ");output.append(1-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='Q'){count++;}
                }
            }
            if((1-count)!=0){output.append("Q ");output.append(1-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='R'){count++;}
                }
            }
            if((2-count)!=0){output.append("R ");output.append(2-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='B'){count++;}
                }
            }
            if((2-count)!=0){output.append("B ");output.append(2-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='N'){count++;}
                }
            }
            if((2-count)!=0){output.append("N ");output.append(2-count);output.append("\n");}
            count=0;

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(chessComponents[i][j].getName()=='P'){count++;}
                }
            }
            if((8-count)!=0){output.append("P ");output.append(8-count);output.append("\n");}
            count=0;
            return output.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        getChess(source.getX(),source.getY()).setChessComponent(getChessComponents());
        List<ChessboardPoint> value = getChess(source.getX(),source.getY()).canMoveTo();
        value.sort(new SortBy());
        return value;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        getChess(sourceX,sourceY).setChessComponent(getChessComponents());
        List<ChessboardPoint> value = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        boolean isOK = false;
        for(int i = 0;i< value.size();i++){
            if(value.get(i).getX()==targetX){
                if(value.get(i).getY()==targetY){isOK = true;break;}
            }
        }
//        isOK = value.contains(new ChessboardPoint(targetX,targetY));
        if(getCurrentPlayer().equals(ChessColor.BLACK)){
            if(this.chessComponents[sourceX][sourceY].getChessColor().equals(ChessColor.BLACK) && isOK){
                setCurrentPlayer(ChessColor.WHITE);
                this.chessComponents[targetX][targetY]=this.chessComponents[sourceX][sourceY];
                this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY);
                return true;
            }else {return false;}
        }else if(getCurrentPlayer().equals(ChessColor.WHITE)){
            if(this.chessComponents[sourceX][sourceY].getChessColor().equals(ChessColor.WHITE) && isOK){
                setCurrentPlayer(ChessColor.BLACK);
                this.chessComponents[targetX][targetY]=this.chessComponents[sourceX][sourceY];
                this.chessComponents[targetX][targetY].setSource(targetX,targetY);
                this.chessComponents[sourceX][sourceY]=new EmptySlotComponent(sourceX,sourceY);
                return true;
            }else {return false;}
        }else{return false;}
    }

    class SortBy implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint m, ChessboardPoint n){
            if(m.getX() > n.getX()){
                return 1;
            }else if(m.getX() == n.getX()){
                if(m.getY() > n.getY()){
                    return 1;
                }else {
                    return -1;
                }
            }else {
                return -1;
            }
        }
    }
}
