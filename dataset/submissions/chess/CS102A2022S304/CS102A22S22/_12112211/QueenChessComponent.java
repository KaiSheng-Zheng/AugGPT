import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public void setChessColor(ChessColor chessColor){
        super.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        int[][] ChessMoveDir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int directions = 0; directions < 4; directions++) {
            for (int i = 0; i < 7; i++) {
                ChessboardPoint destination = new ChessboardPoint(getSource().getX()+ChessMoveDir[directions][0], getSource().getY()+ChessMoveDir[directions][1] );
                if (destination.getY() != -1 && chessBoard [destination.getX()][destination.getY()].getChessColor() != chessBoard[getSource().getX()][getSource().getY()].getChessColor()){
                    ans.add(destination);
                    if (chessBoard[destination.getX()][destination.getY()].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                    if (ChessMoveDir[directions][1] >0){
                        ChessMoveDir[directions][1]++;
                    }
                    if (ChessMoveDir[directions][0]<0){
                        ChessMoveDir[directions][0]--;
                    }
                    if (ChessMoveDir[directions][1]< 0){
                        ChessMoveDir[directions][1]--;
                    }
                    if (ChessMoveDir[directions][0]>0){
                        ChessMoveDir[directions][0]++;
                    }



                }else {
                    break;
                }
            }
        }


        int rowOfUR = getSource().getX();
        int rowOfUL = getSource().getX();
        int rowOfDR = getSource().getX();
        int rowOfDL = getSource().getX();
        int colOfUR = getSource().getY();
        int colOfUL = getSource().getY();
        int colOfDR = getSource().getY();
        int colOfDL = getSource().getY();
        for (int times = Math.min(getSource().getX(), getSource().getY()); times < 8; times++) {
            colOfUR++;
            rowOfUR--;
            if (colOfUR==7 || rowOfUR == 0 ){
                break;
            }
        }

        for (int times = Math.min(getSource().getX(), getSource().getY()); times <8 ; times++) {
            colOfDL--;
            rowOfDL++;
            if (colOfDL==0 || rowOfDL == 7 ){
                break;
            }
        }

        for (int times = Math.max(getSource().getX(), getSource().getY()); times > -1 ; times--) {
            colOfUL--;
            rowOfUL--;
            if (colOfUL==0||rowOfUL==0){
                break;
            }
        }

        for (int times = Math.min(getSource().getX(), getSource().getY()); times <8 ; times++) {
            colOfDR++;
            rowOfDR++;
            if (colOfDR == 7|rowOfDR==7){
                break;
            }
        }



        ChessboardPoint upRight = new ChessboardPoint(rowOfUR,colOfUR);
        ChessboardPoint upLeft = new ChessboardPoint(rowOfUL,colOfUL);
        ChessboardPoint downRight = new ChessboardPoint(rowOfDR,colOfDR);
        ChessboardPoint downLeft = new ChessboardPoint(rowOfDL,colOfDL);




    
        if (getFirstOn45(getSource(),upRight) == null){
            int col0 = getSource().getY();
            int row = getSource().getX();
            if (row != 0 && col0 != 7){
                col0= col0+1;
                row = row-1;
            }
            for (int col = col0; col < 8 ; col++) {
                ans.add(new ChessboardPoint(row,col));

                if (row==0||col==7){
                    break;
                }
                row--;
            }
        }else {
            ChessboardPoint temp = getFirstOn45(getSource(),upRight);
            if (chessBoard[getSource().getX()][getSource().getY()].getChessColor() == chessBoard[temp.getX()][temp.getY()].getChessColor()){
                int row = getSource().getX();
                int col0 = getSource().getY();
                if (row != 0 && col0 !=7){
                    row = row-1;
                    col0 = col0+1;
                }
                for (int col = col0; col < temp.getY() ; col++) {
                    ans.add(new ChessboardPoint(row,col));
                    row--;
                }
            }else {
                int row = getSource().getX();
                int col0 = getSource().getY();
                if (row != 0 && col0!=7){
                    row = row - 1;
                    col0= col0+1;
                }
                for (int col = col0; col < temp.getY()+1 ; col++) {
                    ans.add(new ChessboardPoint(row,col));
                    row--;
                }
            }
        }



    
        if (getFirstOn45(getSource(),downLeft) == null){
            int row = getSource().getX();
            int col0 = getSource().getY();
            if (row != 7 && col0 != 0 ){
                row = row +1;
                col0 = col0 - 1;
            }
            for (int col = col0; col > -1  ; col--) {
                ans.add(new ChessboardPoint(row,col));

                if (row==7||col==0){
                    break;
                }
                row++;
            }
        }else {
            ChessboardPoint temp = getFirstOn45(getSource(),downLeft);
            if (chessBoard[getSource().getX()][getSource().getY()].getChessColor() == chessBoard[temp.getX()][temp.getY()].getChessColor()){
                int row = getSource().getX();
                int col0 = getSource().getY();
                if (row != 7 && col0!=0){
                    row=row+1;
                    col0 = col0-1;
                }
                for (int col = col0; col > temp.getY() ; col--) {
                    ans.add(new ChessboardPoint(row,col));
                    row++;
                }
            }else {
                int row = getSource().getX();
                int col0 = getSource().getY();
                if (row != 7 && col0 !=0){
                    row=row+1;
                    col0 = col0-1;
                }
                for (int col = col0; col > temp.getY()-1 ; col--) {
                    ans.add(new ChessboardPoint(row,col));
                    row++;
                }
            }
        }
    
        if (getFirstOn135(getSource(),upLeft) == null){
            int row = getSource().getX();
            int col0 = getSource().getY();
            if (row!=0 && col0 != 0 ){
                row= row-1;
                col0 = col0 - 1;
            }
            for (int col = col0; col > -1 ; col--) {
                ans.add(new ChessboardPoint(row,col));

                if (row == 0 || col == 0){
                    break;
                }
                row--;
            }
        }else {
            ChessboardPoint temp = getFirstOn135(getSource(),upLeft);
            if (chessBoard[getSource().getX()][getSource().getY()].getChessColor() == chessBoard[temp.getX()][temp.getY()].getChessColor()){
                int row = getSource().getX();
                int col0 = getSource().getY();
                if (row!=0 && col0 != 0 ){
                    row= row-1;
                    col0 = col0 - 1;
                }
                for (int col = col0; col >temp.getY() ; col--) {
                    ans.add(new ChessboardPoint(row,col));
                    row--;
                }
            }else {
                int row = getSource().getX();
                int col0 = getSource().getY();
                if (row!=0 && col0 != 0 ){
                    row= row-1;
                    col0 = col0 - 1;
                }
                for (int col = col0; col >temp.getY()-1 ; col--) {
                    ans.add(new ChessboardPoint(row,col));
                    row--;
                }
            }
        }

    
        if (getFirstOn135(getSource(),downRight) == null){
            int row = getSource().getX();
            int col0 = getSource().getY();
            if (row !=7 && col0!=7){
                row = row +1;
                col0= col0+1;
            }
            for (int col = col0; col < 8 ; col++) {
                ans.add(new ChessboardPoint(row,col));

                if (row == 7 || col0 == 7){
                    break;
                }
                row++;
            }
        }else {
            ChessboardPoint temp = getFirstOn135(getSource(),downRight);
            if (chessBoard[getSource().getX()][getSource().getY()].getChessColor() == chessBoard[temp.getX()][temp.getY()].getChessColor()){
                int row = getSource().getX();
                int col0 = getSource().getY();
                if (row !=7 && col0!=7){
                    row = row +1;
                    col0= col0+1;
                }
                for (int col =col0; col <temp.getY() ; col++) {
                    ans.add(new ChessboardPoint(row,col));
                    row++;
                }
            }else {
                int row = getSource().getX();
                int col0 = getSource().getY();
                if (row !=7 && col0!=7){
                    row = row +1;
                    col0= col0+1;
                }
                for (int col = col0; col <temp.getY()+1 ; col++) {
                    ans.add(new ChessboardPoint(row,col));
                    row++;
                }
            }
        }
        return ans;
    }


    public ChessboardPoint getFirstOfRow (ChessboardPoint source, int Y){
        if (Y> source.getY()){
            for (int col = source.getY()+1; col < Y ; col++) {
                if (chessBoard[source.getX()][col].getChessColor() != ChessColor.NONE){
                    return new ChessboardPoint(source.getX(),col);
                }
            }
        }else {
            for (int col = source.getY()-1; col > Y ; col--) {
                if (chessBoard[source.getX()][col].getChessColor() != ChessColor.NONE){
                    return new ChessboardPoint(source.getX(),col);
                }
            }
        }
        return null;
    }


    public ChessboardPoint getFirstOfCol (ChessboardPoint source, int X){
        if (X > source.getX()){
            for (int row = source.getX()+1; row <X ; row++) {
                if (chessBoard[row][source.getY()].getChessColor()!= ChessColor.NONE){
                    return new ChessboardPoint(row,source.getY());
                }
            }
        }else {
            for (int row = source.getX()-1; row >X ; row--) {
                if (chessBoard[row][source.getY()].getChessColor()!= ChessColor.NONE){
                    return new ChessboardPoint(row,source.getY());
                }
            }
        }
        return null;
    }

    public ChessboardPoint getFirstOn45(ChessboardPoint source, ChessboardPoint Bound){
        if (Bound.getY() > source.getY()){
            int col0 = getSource().getY();
            int row = getSource().getX();
            if (row != 0 && col0 != 7){
                col0= col0+1;
                row = row-1;
            }
            for (int col = col0; col <Bound.getY()+1; col++) {
                if (chessBoard[row][col].getChessColor() != ChessColor.NONE){
                    return new ChessboardPoint(row,col);
                }

                if (row ==0 || col == 7){
                    return null;
                }
                row--;
            }
        }else {
            int row = getSource().getX();
            int col0 = getSource().getY();
            if (row != 7 && col0 != 0 ){
                row = row +1;
                col0 = col0 - 1;
            }
            for (int col = col0; col > Bound.getY()-1 ; col--) {
                if (chessBoard[row][col].getChessColor() != ChessColor.NONE){
                    return new ChessboardPoint(row,col);
                }

                if (row == 7 || col0 == 0 ){
                    return null;
                }
                row++;
            }
        }
        return null;
    }

    public ChessboardPoint getFirstOn135(ChessboardPoint source, ChessboardPoint Bound){
        if (Bound.getY() < source.getY()){
            int row = getSource().getX();
            int col0 = getSource().getY();
            if (row!=0 && col0 != 0 ){
                row= row-1;
                col0 = col0 - 1;
            }
            for (int col = col0; col >Bound.getY()-1 ; col--) {
                if (chessBoard[row][col].getChessColor() != ChessColor.NONE){
                    return new ChessboardPoint(row,col);
                }

                if (row == 0 || col==0){
                    return null;
                }
                row--;
            }
        }else {
            int row = getSource().getX();
            int col0 = getSource().getY();
            if (row !=7 && col0!=7){
                row = row +1;
                col0= col0+1;
            }
            for (int col = col0; col < Bound.getY()+1; col++) {
                if (chessBoard[row][col].getChessColor() != ChessColor.NONE){
                    return new ChessboardPoint(row,col);
                }

                if (row == 7 || col ==7){
                    return null;
                }
                row++;
            }
        }
        return null;
    }

}
