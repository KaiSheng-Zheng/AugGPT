import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='q';
        }else{
            this.name='Q';
        }
    }

    public QueenChessComponent(ChessColor chessColor) {
        super(chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='q';
        }else{
            this.name='Q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessColor chessColor = getChessColor();
        ChessComponent[][] chessComponents = getChessComponents();
        ChessboardPoint source = getSource();
        ArrayList<ChessboardPoint> legalpoints = new ArrayList<>();
        ChessboardPoint legalpoint = new ChessboardPoint(0,0);


        int row = source.getX();
        int col = source.getY();

        boolean isCrossRowUp = false;
        boolean isCrossRowDown = false;
        boolean isCrossColUp = false;
        boolean isCrossColDown = false;
        for (int i = 1; i < 8; i++) {
            if(!isCrossRowUp&&row-i>=0){
                if(!(chessComponents[row-i][col] instanceof  EmptySlotComponent)) {
                    if ((chessComponents[row - i][col].getChessColor() != chessColor)) {
                        legalpoint = new ChessboardPoint(row - i, col);
                        legalpoints.add(legalpoint);
                    }
                    isCrossRowUp=true;
                }else{
                    legalpoint = new ChessboardPoint(row - i, col);
                    legalpoints.add(legalpoint);
                }

            }
            if(!isCrossRowDown&&row+i<=7){
                if(!(chessComponents[row+i][col] instanceof  EmptySlotComponent)) {
                    if ((chessComponents[row + i][col].getChessColor() != chessColor)) {
                        legalpoint = new ChessboardPoint(row + i, col);
                        legalpoints.add(legalpoint);
                    }
                    isCrossRowDown=true;
                }else{
                    legalpoint = new ChessboardPoint(row + i, col);
                    legalpoints.add(legalpoint);
                }
            }
            if(!isCrossColUp&&col-i>=0){
                if(!(chessComponents[row][col-i] instanceof  EmptySlotComponent)) {
                    if ((chessComponents[row][col-i].getChessColor() != chessColor)) {
                        legalpoint = new ChessboardPoint(row, col-i);
                        legalpoints.add(legalpoint);
                    }
                    isCrossColUp=true;
                }else{
                    legalpoint = new ChessboardPoint(row, col-i);
                    legalpoints.add(legalpoint);
                }
            }
            if(!isCrossColDown&&col+i<=7){
                if(!(chessComponents[row][col+i] instanceof  EmptySlotComponent)) {
                    if ((chessComponents[row][col+i].getChessColor() != chessColor)) {
                        legalpoint = new ChessboardPoint(row, col+i);
                        legalpoints.add(legalpoint);
                    }
                    isCrossColDown=true;
                }
                else{
                    legalpoint = new ChessboardPoint(row, col+i);
                    legalpoints.add(legalpoint);
                }
            }
        }

                for (int j = 1; j < 8; j++) {
                    if(row-j<0||col-j<0){
                        break;
                    }
                    if(!(chessComponents[row-j][col-j] instanceof  EmptySlotComponent)) {
                        if ((chessComponents[row - j][col - j].getChessColor() != chessColor)) {
                            legalpoint = new ChessboardPoint(row - j, col - j);
                            legalpoints.add(legalpoint);
                        }
                        break;
                    }
                    legalpoint = new ChessboardPoint(row-j,col-j);
                    legalpoints.add(legalpoint);
                }
                for (int j = -1; j > -8; j--) {
                    if(row-j>7||col-j>7){
                        break;}
                    if(!(chessComponents[row-j][col-j] instanceof  EmptySlotComponent)) {
                        if ((chessComponents[row - j][col - j].getChessColor() != chessColor)) {
                            legalpoint = new ChessboardPoint(row - j, col - j);
                            legalpoints.add(legalpoint);
                        }
                        break;
                    }
                    legalpoint = new ChessboardPoint(row-j,col-j);
                    legalpoints.add(legalpoint);
            }
            
            for (int j = 1; j < 8; j++) {
                if(row-j<0||col+j>7){
                    break;
                }
                if(!(chessComponents[row-j][col+j] instanceof  EmptySlotComponent)){
                    if ((chessComponents[row - j][col + j].getChessColor() != chessColor)) {
                        legalpoint = new ChessboardPoint(row - j, col + j);
                        legalpoints.add(legalpoint);
                    }
                    break;
                }
                legalpoint = new ChessboardPoint(row-j,col+j);
                legalpoints.add(legalpoint);
            }
            
            for (int j = -1; j > -8; j--) {
                if(row-j>7||col+j<0){
                    break;
                }
                if(!(chessComponents[row-j][col+j] instanceof  EmptySlotComponent)){
                    if ((chessComponents[row - j][col + j].getChessColor() != chessColor)) {
                        legalpoint = new ChessboardPoint(row - j, col + j);
                        legalpoints.add(legalpoint);
                    }
                    break;
                }
                legalpoint = new ChessboardPoint(row-j,col+j);
                legalpoints.add(legalpoint);
            }



        for (int i = 0; i < legalpoints.size(); i++) {
            if(chessComponents[legalpoints.get(i).getX()][legalpoints.get(i).getY()].getChessColor()==chessColor){
                legalpoints.remove(i);
                i--;
            }
        }

        return legalpoints;
    }
}
