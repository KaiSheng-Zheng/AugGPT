import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{



    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='b';
        }else{
            this.name='B';
        }
    }
    public BishopChessComponent(ChessColor chessColor) {
        super(chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='b';
        }else{
            this.name='B';
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
                for (int j = 1; j < 8; j++) {
                    if(row-j<0||col-j<0){
                        break;
                    }

                    if(!(chessComponents[row-j][col-j] instanceof  EmptySlotComponent)) {
                        if ((chessComponents[row - j][col - j].getChessColor() !=chessColor)) {
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
                        break;
                    }
//                    if(row-j<0||col-j<0){
//                        continue;
//                    }

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
//                        System.out.println("j="+j+" row="+row+" col="+col);
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
//        }

        for (int i = 0; i < legalpoints.size(); i++) {
            if(chessComponents[legalpoints.get(i).getX()][legalpoints.get(i).getY()].getChessColor()==chessColor){
                legalpoints.remove(i);
                i--;
            }
        }

        return legalpoints;
    }
}
