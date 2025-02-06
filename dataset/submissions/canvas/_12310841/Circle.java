

import java.util.Arrays;

public class Circle extends Shape{
    private int area;
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        this.area=0;
        super.overLapconflict=true;
    }

    @Override
    public void fillGrids(Location l,char[][] c) {
//        super.grids=new char[2*radius][2*radius];
        for(int i= 0;i<radius;i++){
            for(int j=0;j<radius;j++){
                if((radius-i-1)*(radius-i-1)+(radius-j-1)*(radius-j-1)<radius*radius){
                    if(c[i+ l.getX()][j+ l.getY()]==' ' && c[l.getX()+i][l.getY()+2*radius-1-j]==' '&&c[l.getX()+2*radius-1-i][l.getY()+j]==' '&&c[l.getX()+2*radius-1-i][l.getY()+2*radius-1-j]==' '){
                        c[l.getX()+i][l.getY()+j]=pattern;
                        c[l.getX()+i][l.getY()+2*radius-1-j]=pattern;
                        c[l.getX()+2*radius-1-i][l.getY()+j]=pattern;
                        c[l.getX()+2*radius-1-i][l.getY()+2*radius-1-j]=pattern;
                        super.area+=4;
                    }else{
                        super.overLapconflict=false;
                    }
                }
            }
        }
//        for(int i=0;i<2*radius;i++){
//            for(int j=0;j<2*radius;j++){
//                if(super.grids[i][j]!=pattern){
//                    super.grids[i][j]=' ';
//                }
//            }
//        }

    }
    public boolean judgeFull(Location l,char[][]c){
        for(int i= 0;i<radius;i++){
            for(int j=0;j<radius;j++){
                if((radius-i-1)*(radius-i-1)+(radius-j-1)*(radius-j-1)<radius*radius){
                    if(c[i+ l.getX()][j+ l.getY()]==' ' && c[l.getX()+i][l.getY()+2*radius-1-j]==' '&&c[l.getX()+2*radius-1-i][l.getY()+j]==' '&&c[l.getX()+2*radius-1-i][l.getY()+2*radius-1-j]==' '){

                    }else{
                        super.overLapconflict=false;
                    }
                }
            }
        }
        return overLapconflict;
    }
    public void fillOverlap(Location l,char[][] c){
        for(int i= 0;i<radius;i++){
            for(int j=0;j<radius;j++){
                if((radius-i-1)*(radius-i-1)+(radius-j-1)*(radius-j-1)<radius*radius){
//                    c[l.getX()+i][l.getY()+j]=pattern;
//                    c[l.getX()+i][l.getY()+2*radius-1-j]=pattern;
//                    c[l.getX()+2*radius-1-i][l.getY()+j]=pattern;
//                    c[l.getX()+2*radius-1-i][l.getY()+2*radius-1-j]=pattern;
//                    super.area+=4;
                    super.area+=4;
                    if(l.getX()+i<c.length &&l.getY()+j<c[0].length){
                        c[l.getX()+i][l.getY()+j]=pattern;
                        super.overLap=true;
                    }if(l.getX()+i<c.length&&l.getY()+2*radius-1-j<c[0].length){
                        c[l.getX()+i][l.getY()+2*radius-1-j]=pattern;
                        super.overLap=true;
                    }if(l.getX()+2*radius-1-i<c.length&&l.getY()+j<c[0].length){
                        c[l.getX()+2*radius-1-i][l.getY()+j]=pattern;
                        super.overLap=true;
                    }if (l.getX()+2*radius-1-i<c.length&&l.getY()+2*radius-1-j<c[0].length) {
                        c[l.getX()+2*radius-1-i][l.getY()+2*radius-1-j]=pattern;
                        super.overLap=true;
                    }
                }
            }
        }
    }

//  @Override
//    public void shrink() {
//        radius-=1;
//        fillGrids();
//    }
//
//    @Override
//    public void enlarge() {
//        radius+=1;
//        fillGrids();
//    }



    public String toString(){
        return "Circle: ("+this.location.getX()+","+this.location.getY()+") area="+super.getArea()+" pattern="+this.pattern;
    }
//    public String toString(){
//        return "Circle: ("+this.location.getX()+","+this.location.getY()+") area="+super.getArea()+" pattern="+this.pattern;
//    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isOverLapconflict() {
        return overLapconflict;
    }

    public void setOverLapconflict(boolean overLapconflict) {
        this.overLapconflict = overLapconflict;
    }

}
