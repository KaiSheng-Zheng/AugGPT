import java.nio.channels.NonWritableChannelException;
import java.util.*;

import static java.util.Collections.sort;

public class ConcreteChessGame implements ChessGame {


    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer;


    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE, new ChessboardPoint(i,j));
            }
        }
        if (chessboard.get(8).charAt(0)=='w'){
            currentPlayer=ChessColor.WHITE;
            currentPlayer.setCurrentPlayer(currentPlayer);
        }else {
            currentPlayer=ChessColor.BLACK;
            currentPlayer.setCurrentPlayer(currentPlayer);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
//RNBQKP
                switch (chessboard.get(i).charAt(j)) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, new ChessboardPoint(i,j));
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,new ChessboardPoint(i,j));
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,new ChessboardPoint(i,j));
                        break;
                    default:
                        chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(i,j));
                        break;
                }
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
    }

    public String getChessboardGraph() {
        String string = new String();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                string+=chessComponents[i][j].getName();
            }
            string+="\n";
        }
        return string;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder stringBuilder = new StringBuilder();
        int wang = 0, huanghou = 0, che = 0, zhujiao = 0, qishi = 0, bin = 0;
        if (player==ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].getName()) {
                        case 'r':
                            che++;
                            break;
                        case 'n':
                            qishi++;
                            break;
                        case 'b':
                            zhujiao++;
                            break;
                        case 'q':
                            huanghou++;
                            break;
                        case 'k':
                            wang++;
                            break;
                        case 'p':
                            bin++;
                            break;
                    }
                }
            }
            if (wang != 1) {
                stringBuilder.append("k 1");
                stringBuilder.append("\n");
            }
            if (huanghou != 1) {
                stringBuilder.append("q 1");
                stringBuilder.append("\n");
            }
            if (che != 2) {
                che = 2 - che;
                stringBuilder.append("r ");
                stringBuilder.append(che);
                stringBuilder.append("\n");
            }
            if (zhujiao != 2) {
                zhujiao = 2 - zhujiao;
                stringBuilder.append("b ");
                stringBuilder.append(zhujiao);
                stringBuilder.append("\n");
            }
            if (qishi != 2) {
                qishi = 2 - qishi;
                stringBuilder.append("n ");
                stringBuilder.append(qishi);
                stringBuilder.append("\n");
            }
            if (bin != 8) {
                bin = 8 - bin;
                stringBuilder.append("p ");
                stringBuilder.append(bin);
                stringBuilder.append("\n");
            }
        }
        else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].getName()) {
                        case 'R':
                            che++;
                            break;
                        case 'N':
                            qishi++;
                            break;
                        case 'B':
                            zhujiao++;
                            break;
                        case 'Q':
                            huanghou++;
                            break;
                        case 'K':
                            wang++;
                            break;
                        case 'P':
                            bin++;
                            break;
                    }
                }
            }
                if (wang != 1) {
                    stringBuilder.append("K 1");
                    stringBuilder.append("\n");
                }
                if (huanghou != 1) {
                    stringBuilder.append("Q 1");
                    stringBuilder.append("\n");
                }
                if (che != 2) {
                    che = 2 - che;
                    stringBuilder.append("R ");
                    stringBuilder.append(che);
                    stringBuilder.append("\n");
                }
                if (zhujiao != 2) {
                    zhujiao = 2 - zhujiao;
                    stringBuilder.append("B ");
                    stringBuilder.append(zhujiao);
                    stringBuilder.append("\n");
                }
                if (qishi != 2) {
                    qishi = 2 - qishi;
                    stringBuilder.append("N ");
                    stringBuilder.append(qishi);
                    stringBuilder.append("\n");
                }
                if (bin != 8) {
                    bin = 8 - bin;
                    stringBuilder.append("P ");
                    stringBuilder.append(bin);
                    stringBuilder.append("\n");
                }
            }
        return stringBuilder.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if (source==null||source.getX()<0||source.getX()>8||source.getY()<0||source.getY()>8){
            return new ArrayList<>();
        }else{
            int hang = source.getX();
            int lie = source.getY();
            List<ChessboardPoint> canMovePoints =chessComponents[hang][lie].canMoveTo();
            //paixu haimeizuo
            sort(canMovePoints,new getCanMovePointsx());
            sort(canMovePoints,new getCanMovePointsy());
            return canMovePoints;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint soure = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX,targetY);
        List<ChessboardPoint> kequdifang = getCanMovePoints(soure);
        for (int i = 0; i < kequdifang.size(); i++) {
                if (kequdifang.get(i).getX() == targetX && kequdifang.get(i).getY() == targetY && currentPlayer==chessComponents[sourceX][sourceY].getChessColor()) {
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,new ChessboardPoint(sourceX,sourceY));

                    if (currentPlayer == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    } else {
                        currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
            return false;

    }





    public ChessComponent getChess(int x, int y){
       chessComponents[x][y].getName();
       chessComponents[x][y].getChessColor();
       chessComponents[x][y].getSource();
        return chessComponents[x][y];
    }
}
class getCanMovePointsx implements Comparator<ChessboardPoint> {

    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        if(o1.getX()<o2.getX()){
            return -1;
        }else if (o1.getX()>o2.getX()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
class getCanMovePointsy implements Comparator<ChessboardPoint> {

    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        if(o1.getX()==o2.getX()&&o1.getY()<o2.getY()){
            return -1;
        }else if (o1.getX()==o2.getX()&&o1.getY()>o2.getY()){
            return 1;
        }
        else {
            return 0;
        }
    }
}