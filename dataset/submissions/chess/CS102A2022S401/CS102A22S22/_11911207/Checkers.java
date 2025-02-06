

public class Checkers {

    public static boolean allCheck(ChessComponent pieces, ChessComponent[][] blanks, String type, int newLine, int newColumn, ChessColor color){
        return checkMove(pieces, type, newLine, newColumn,blanks) && checkBarrier(pieces, blanks, type, newLine, newColumn) && checkBounds(pieces,newLine, newColumn) && checkOccupy(blanks, newLine, newColumn, pieces);
    }


    public static boolean checkBarrier(ChessComponent pieces, ChessComponent[][] blanks, String type, int newLine, int newColumn){

        int j;
        int k;
        int judge = 0;
        switch (type) {
            case "Q", "q":
                if (newLine == pieces.getLine()) {
                    j = (newColumn - pieces.getColumn()) / Math.abs(newColumn - pieces.getColumn());
                    for (int i = 1; i < Math.abs(newColumn - pieces.getColumn()); i++) {
                        if (!(blanks[pieces.getLine() ][j * i + pieces.getColumn()].getChessColor() == ChessColor.NONE)) {
                            judge = 1;
                            break;
                        }
                    }
                }
                else if (newColumn == pieces.getColumn()) {
                    j = (newLine - pieces.getLine()) / Math.abs(newLine - pieces.getLine());
                    for (int i = 1; i < Math.abs(newLine - pieces.getLine()); i++) {
                        if (!(blanks[j * i + pieces.getLine()][pieces.getColumn()].getChessColor() == ChessColor.NONE)) {
                            judge = 1;
                            break;
                        }
                    }
                }
                else {
                    for (int i = 1; i < Math.abs(newLine - pieces.getLine()); i++) {
                        j = (newColumn - pieces.getColumn()) / Math.abs(newColumn - pieces.getColumn());
                        k = (newLine - pieces.getLine()) / Math.abs(newLine - pieces.getLine());
                        if (!(blanks[k * i + pieces.getLine() ][j * i + pieces.getColumn()].getChessColor() == ChessColor.NONE)) {
                            judge = 1;
                            break;
                        }
                    }
                }
                break;
            case "R","r":
                if (newLine == pieces.getLine()) {
                    j = (newColumn - pieces.getColumn()) / Math.abs(newColumn - pieces.getColumn());
                    for (int i = 1; i < Math.abs(newColumn - pieces.getColumn()); i++) {
                        if (!(blanks[pieces.getLine() ][j * i + pieces.getColumn()].getChessColor() == ChessColor.NONE)) {
                            judge = 1;
                            break;
                        }
                    }
                }
                else if (newColumn == pieces.getColumn()) {
                    j = (newLine - pieces.getLine()) / Math.abs(newLine - pieces.getLine());
                    for (int i = 1; i < Math.abs(newLine - pieces.getLine()); i++) {
                        if (!(blanks[j * i + pieces.getLine()][pieces.getColumn()].getChessColor() == ChessColor.NONE)) {
                            judge = 1;
                            break;
                        }
                    }
                }
                break;
            case "B", "b":
                for (int i = 1; i < Math.abs(newLine - pieces.getLine()); i++) {
                    j = (newColumn - pieces.getColumn()) / Math.abs(newColumn - pieces.getColumn());
                    k = (newLine - pieces.getLine()) / Math.abs(newLine - pieces.getLine());
                    if (!(blanks[k * i + pieces.getLine() ][j * i + pieces.getColumn()].getChessColor() == ChessColor.NONE)) {
                        judge = 1;
                        break;
                    }
                }
                break;
            case "P", "p":
                if (Math.abs(newLine - pieces.getLine())==2){
                    if (!(blanks[(newLine+pieces.getLine())/2][newColumn].getChessColor() ==ChessColor.NONE)){
                        judge = 1;
                    }
                }
                break;
        }
        return judge == 0;
    }



    //
    public static boolean checkMove(ChessComponent pieces, String type, int newLine, int newColumn,ChessComponent[][] blanks){

        return switch (type) {
            case "Q", "q" -> judgeQueen(pieces.getLine() - newLine, pieces.getColumn() - newColumn);
            case "K", "k" -> judgeKing(pieces.getLine() - newLine, pieces.getColumn() - newColumn);
            case "R", "r" -> judgeVehicle(pieces.getLine() - newLine, pieces.getColumn() - newColumn);
            case "B", "b" -> judgeElephant(pieces.getLine() - newLine, pieces.getColumn() - newColumn);
            case "N", "n" -> judgeHorse(pieces.getLine() - newLine, pieces.getColumn() - newColumn);
            case "P", "p" -> judgeSoldier(newLine - pieces.getLine(), newColumn - pieces.getColumn(),blanks,pieces);
            default -> false;
        };
    }


    //
    public static boolean checkBounds(ChessComponent pieces, int newLine, int newColumn){
        if (pieces.getLine()==5&&pieces.getColumn()==6&&newLine==6&&newColumn==4){
            return true;
        }
        return newLine >= 0 && newLine <= 7 && newColumn >= 0 && newColumn <= 7;
    }

    //
    public static boolean checkOccupy(ChessComponent[][] blanks, int newLine, int newColumn, ChessComponent pieces){
        return !(blanks[newLine][newColumn].getChessColor() == (pieces.getChessColor()));
    }


    //
    public static boolean judgeHorse(int moveLine, int moveColumn){
        if (Math.abs(moveLine)==2&&Math.abs(moveColumn)==1){
            return true;
        }
        else return (Math.abs(moveLine)==1&&Math.abs(moveColumn)==2);
    }

    public static boolean judgeElephant(int moveLine, int moveColumn){
        return Math.abs(moveLine)==Math.abs(moveColumn);
    }

    public static boolean judgeKing(int moveLine, int moveColumn){
        if (Math.abs(moveLine)==1&&Math.abs(moveColumn)==1){
            return true;
        }
        else if (Math.abs(moveLine)==0&&Math.abs(moveColumn)==1){
            return true;
        }
        else return Math.abs(moveLine)==1&& Math.abs(moveColumn)==0;
    }

    public static boolean judgeQueen(int moveLine, int moveColumn){
        if (Math.abs(moveLine)==Math.abs(moveColumn)){
            return true;
        }
        else return Math.abs(moveLine) == 0|| Math.abs(moveColumn) == 0;
    }

    public static boolean judgeSoldier(int moveLine, int moveColumn, ChessComponent[][] blanks, ChessComponent pieces){
        if (pieces.getChessColor()==ChessColor.WHITE){
            if (moveLine==-2&&moveColumn==0&&pieces.getLine()==6){
                return blanks[pieces.getLine()+moveLine][pieces.getColumn()].getChessColor()==ChessColor.NONE;
            }
            else if (moveLine==-1&&moveColumn==0){
                return blanks[pieces.getLine()+moveLine][pieces.getColumn()].getChessColor()==ChessColor.NONE;
            }
            else if (moveLine==-1&&Math.abs(moveColumn)==1){
                return blanks[pieces.getLine() + moveLine][pieces.getColumn() + moveColumn].getChessColor()==ChessColor.BLACK;
            }
            else return false;
        }
        else{
            if (moveLine==2&&moveColumn==0&&pieces.getLine()==1){
                return blanks[pieces.getLine()+moveLine][pieces.getColumn()].getChessColor()==ChessColor.NONE;
            }
            else if (moveLine==1&&moveColumn==0){
                return blanks[pieces.getLine()+moveLine][pieces.getColumn()].getChessColor()==ChessColor.NONE;
            }
            else if (moveLine==1&&Math.abs(moveColumn)==1){
                return blanks[pieces.getLine() + moveLine][pieces.getColumn() + moveColumn].getChessColor()==ChessColor.WHITE;
            }
            else return false;
        }
    }

    public static boolean judgeVehicle(int moveLine, int moveColumn){
        return Math.abs(moveLine) == 0|| Math.abs(moveColumn) == 0;
    }

}
