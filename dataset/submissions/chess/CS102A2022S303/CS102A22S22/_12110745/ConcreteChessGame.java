import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                switch (chessboard.get(i).charAt(j)){
                    case 'K':{
                        ChessboardPoint blackK = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new KingChessComponent(blackK,ChessColor.BLACK, 'K');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'Q': {
                        ChessboardPoint blackQ = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new QueenChessComponent(blackQ,ChessColor.BLACK,'Q');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'R': {
                        ChessboardPoint blackR = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new RookChessComponent(blackR,ChessColor.BLACK,'R');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'B': {
                        ChessboardPoint blackB = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new BishopChessComponent(blackB,ChessColor.BLACK,'B');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'N': {
                        ChessboardPoint blackN = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new KnightChessComponent(blackN,ChessColor.BLACK,'N');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'P': {
                        ChessboardPoint blackP = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new PawnChessComponent(blackP,ChessColor.BLACK,'P');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'k': {
                        ChessboardPoint whiteK = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new KingChessComponent(whiteK,ChessColor.WHITE,'k');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'q': {
                        ChessboardPoint whiteQ = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new QueenChessComponent(whiteQ,ChessColor.WHITE,'q');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'r': {
                        ChessboardPoint whiteR = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new RookChessComponent(whiteR,ChessColor.WHITE,'r');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'b': {
                        ChessboardPoint whiteB = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new BishopChessComponent(whiteB,ChessColor.WHITE,'b');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'n': {
                        ChessboardPoint whiteN = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new KnightChessComponent(whiteN,ChessColor.WHITE,'n');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    case 'p': {
                        ChessboardPoint whiteP = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new PawnChessComponent(whiteP,ChessColor.WHITE,'p');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }break;
                    default: {
                        ChessboardPoint emp = new ChessboardPoint(i,j);
                        chessComponents[i][j] = new EmptySlotComponent(emp,ChessColor.NONE,'_');
                        chessComponents[i][j].setChessboard(chessComponents);
                    }
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w'){
            currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).charAt(0) == 'b'){
            currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    @Override
    public String getChessboardGraph() {
        StringBuilder[] string1 = new StringBuilder[8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0){
                    string1[i] = new StringBuilder();
                }
                string1[i].append(chessComponents[i][j].name);
            }
        }
        return string1[0].toString()+"\n"+string1[1].toString()+"\n"+string1[2].toString()+"\n"
        +string1[3].toString()+"\n"+string1[4].toString()+"\n"+string1[5].toString()+"\n"
                +string1[6].toString()+"\n"+string1[7].toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] cnt = {0,0,0,0,0,0};
        int[] cnt2 = {0,0,0,0,0,0};
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name){
                    case 'K': cnt[0]++;break;
                    case 'Q': cnt[1]++;break;
                    case 'R': cnt[2]++;break;
                    case 'B': cnt[3]++;break;
                    case 'N': cnt[4]++;break;
                    case 'P': cnt[5]++;break;
                    case 'k': cnt2[0]++;break;
                    case 'q': cnt2[1]++;break;
                    case 'r': cnt2[2]++;break;
                    case 'b': cnt2[3]++;break;
                    case 'n': cnt2[4]++;break;
                    case 'p': cnt2[5]++;break;
                }
            }
        }
        if (player == ChessColor.BLACK){
            if (cnt[0]<1) string1.append("K 1\n");
            if (cnt[1]<1) string1.append("Q 1\n");
            if (cnt[2]<2) {
                String lost = "R "+(2-cnt[2])+"\n";
                string1.append(lost);
            }
            if (cnt[3]<2){
                String lost = "B "+(2-cnt[3])+"\n";
                string1.append(lost);
            }
            if (cnt[4]<2){
                String lost = "N "+(2-cnt[4])+"\n";
                string1.append(lost);
            }
            if (cnt[5]<8){
                String lost = "P "+(8-cnt[5])+"\n";
                string1.append(lost);
            }
            return string1.toString();
        }
        if (player == ChessColor.WHITE){
            if (cnt2[0]<1) string2.append("k 1\n");
            if (cnt2[1]<1) string2.append("q 1\n");
            if (cnt2[2]<2) {
                String lost = "r "+(2-cnt2[2])+"\n";
                string2.append(lost);
            }
            if (cnt2[3]<2){
                String lost = "b "+(2-cnt2[3])+"\n";
                string2.append(lost);
            }
            if (cnt2[4]<2){
                String lost = "n "+(2-cnt2[4])+"\n";
                string2.append(lost);
            }
            if (cnt2[5]<8){
                String lost = "p "+(8-cnt2[5])+"\n";
                string2.append(lost);
            }
            return string2.toString();
        }
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints);
        return canMovePoints;
    
    }

    public void switchPlayer(){
        if (this.currentPlayer == ChessColor.BLACK){
            this.currentPlayer = ChessColor.WHITE;
        }else{
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean k = true;
        ChessboardPoint point = new ChessboardPoint(targetX,targetY);
        ChessComponent chess = this.getChess(sourceX, sourceY);
        if (this.currentPlayer == chessComponents[sourceX][sourceY].getChessColor()){
            if (targetX>=0 && targetX<=7 && targetY>=0 && targetY<=7){
                List<ChessboardPoint> move = getCanMovePoints(chessComponents[sourceX][sourceY].getSource());
                for (int i = 0; i < move.size(); i++) {
                    if (move.get(i).getX() == targetX && move.get(i).getY() == targetY){
                        switch (chessComponents[sourceX][sourceY].name){
                            case 'k': {
                                chessComponents[targetX][targetY] = new KingChessComponent(point,ChessColor.WHITE,'k');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'q': {
                                chessComponents[targetX][targetY] = new QueenChessComponent(point,ChessColor.WHITE,'q');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'r': {
                                chessComponents[targetX][targetY] = new RookChessComponent(point,ChessColor.WHITE,'r');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'b': {
                                chessComponents[targetX][targetY] = new BishopChessComponent(point,ChessColor.WHITE,'b');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'n': {
                                chessComponents[targetX][targetY] = new KnightChessComponent(point,ChessColor.WHITE,'n');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'p': {
                                chessComponents[targetX][targetY] = new PawnChessComponent(point,ChessColor.WHITE,'p');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'K': {
                                chessComponents[targetX][targetY] = new KingChessComponent(point,ChessColor.BLACK,'K');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'Q': {
                                chessComponents[targetX][targetY] = new QueenChessComponent(point,ChessColor.BLACK,'Q');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'R': {
                                chessComponents[targetX][targetY] = new RookChessComponent(point,ChessColor.BLACK,'R');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'B': {
                                chessComponents[targetX][targetY] = new BishopChessComponent(point,ChessColor.BLACK,'B');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'N': {
                                chessComponents[targetX][targetY] = new KnightChessComponent(point,ChessColor.BLACK,'N');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }break;
                            case 'P': {
                                chessComponents[targetX][targetY] = new PawnChessComponent(point,ChessColor.BLACK,'P');
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(chess.getSource(),ChessColor.NONE,'_');
                                chessComponents[targetX][targetY].setChessboard(chessComponents);
                                chessComponents[sourceX][sourceY].setChessboard(chessComponents);
                            }
                        }
                        switchPlayer();k = true;
                        break;
                    }
                    k=false;
                }
                return k;
            }
            else{
                return false;
            }
        }else{
            return false;
        }
    }
}

