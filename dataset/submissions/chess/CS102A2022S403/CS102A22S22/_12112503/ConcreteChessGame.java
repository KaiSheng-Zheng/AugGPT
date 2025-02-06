import java.util.*;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                switch (chessboard.get(i).charAt(j)){
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent('R',ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent('N',ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent('B',ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent('Q',ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent('K',ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent('P',ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent('_',ChessColor.NONE,new ChessboardPoint(i,j));
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent('p',ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent('k',ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent('q',ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent('b',ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent('n',ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent('r',ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                }

            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer = ChessColor.WHITE;
        }else if (chessboard.get(8).charAt(0)=='b'){
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                stringBuilder.append(chessComponents[i][j].name);
            }
            stringBuilder.append("\n");
        }
        stringBuilder.reverse();
        stringBuilder.deleteCharAt(0);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> arrayList = new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (moveChess(source.getX(),source.getY(),i,j)){
                    arrayList.add(new ChessboardPoint(i,j));
                }
            }
        }
        return arrayList;
    }
    public String getCapturedChess(ChessColor player){
        StringBuilder stringBuilder = new StringBuilder();
        if (player == ChessColor.WHITE){
            int a=0,b=0,c=0,d=0,e=0,f=0;
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    switch (chessComponents[i][j].getName()){
                        case 'k':
                            a++;
                            break;
                        case 'q':
                            b++;
                            break;
                        case 'r':
                            c++;
                            break;
                        case 'b':
                            d++;
                            break;
                        case 'n':
                            e++;
                            break;

                        case 'p':
                            f++;
                            break;
                    }
                }
            }
            if (a!=1){
                stringBuilder.append('k');
                stringBuilder.append(' ');
                stringBuilder.append(1-a);
                stringBuilder.append('\n');
            }
            if (b!=1){
                stringBuilder.append('q');
                stringBuilder.append(' ');
                stringBuilder.append(1-b);
                stringBuilder.append('\n');
            }
            if (c!=2){
                stringBuilder.append('r');
                stringBuilder.append(' ');
                stringBuilder.append(2-c);
                stringBuilder.append('\n');
            }
            if (d != 2) {
                stringBuilder.append('b');
                stringBuilder.append(' ');
                stringBuilder.append(2-d);
                stringBuilder.append('\n');
            }
            if (e!=2){
                stringBuilder.append('n');
                stringBuilder.append(' ');
                stringBuilder.append(2-e);
                stringBuilder.append('\n');
            }
            if (f!=8){
                stringBuilder.append('p');
                stringBuilder.append(' ');
                stringBuilder.append(8-f);
            }
            return stringBuilder.toString();
        }else if (player == ChessColor.BLACK){
            int a=0,b=0,c=0,d=0,e=0,f=0;
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    switch (chessComponents[i][j].getName()){
                        case 'K':
                            a++;
                            break;
                        case 'Q':
                            b++;
                            break;
                        case 'R':
                            c++;
                            break;
                        case 'B':
                            d++;
                            break;
                        case 'N':
                            e++;
                            break;
                        case 'P':
                            f++;
                            break;
                    }
                }
            }
            if (a!=1){
                stringBuilder.append('K');
                stringBuilder.append(' ');
                stringBuilder.append(1-a);
                stringBuilder.append('\n');
            }
            if (b!=1){
                stringBuilder.append('Q');
                stringBuilder.append(' ');
                stringBuilder.append(1-b);
                stringBuilder.append('\n');
            }
            if (c!=2){
                stringBuilder.append('R');
                stringBuilder.append(' ');
                stringBuilder.append(2-c);
                stringBuilder.append('\n');
            }
            if (d != 2) {
                stringBuilder.append('B');
                stringBuilder.append(' ');
                stringBuilder.append(2-d);
                stringBuilder.append('\n');
            }
            if (e!=2){
                stringBuilder.append('N');
                stringBuilder.append(' ');
                stringBuilder.append(2-e);
                stringBuilder.append('\n');
            }
            if (f!=8){
                stringBuilder.append('P');
                stringBuilder.append(' ');
                stringBuilder.append(8-f);
            }
        }
        return stringBuilder.toString();
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        int a=0;
        for (int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++){
            if (Objects.equals(chessComponents[sourceX][sourceY].canMoveTo().get(i), new ChessboardPoint(targetX, targetY))
                    &&
            chessComponents[targetX][targetY].name=='_'){
                a++;
            }
        }
        return a != 0;
    }

}