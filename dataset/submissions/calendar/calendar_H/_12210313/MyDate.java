public class MyDate {
    private int year;
    private int month;
    private int day;
    static int [] runnian = {31,29,31,30,31,30,31,31,30,31,30,31};
    static int [] feirunnian = {31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;}
    public void addDays(int days){
        for (int i = 0; i < this.month -1; i++) {
            if ((this.year %4 == 0 && this.year  % 100 != 0) || this.year  % 400 == 0){
                days += runnian[i] ; }
            else {days += feirunnian[i];}}
        days += this.day - 1;
        while (days >= 365){
            if ((this.year %4 == 0 && this.year  % 100 != 0) || (this.year  % 400 == 0)){
                days -= 366 ; }
            else {days -= 365;}
            this.year ++;}
        this.month = 0;
        while (days>31){
            if ((this.year %4 == 0 && this.year  % 100 != 0) || (this.year  % 400 == 0)){
                days -= runnian[this.month];
                if (days <= runnian[this.month+1]){
                    break;}}
            else {days -= feirunnian[this.month];
                if (days <= feirunnian[this.month+1]){
                    break;}}
            this.month++;}
        if (this.month == 0){this.month =1;}
        else {this.month +=2;}
        this.day = days + 1;}
    public  String toString(){
        if (month <10 && day < 10){
            return String.format("%d-0%d-0%d",year,month,day);
        } else if (month < 10) {
            return String.format("%d-0%d-%d",year,month,day);
        } else if (day<10) {
            return String.format("%d-%d-0%d",year,month,day);
        } else {
            return String.format("%d-%d-%d",year,month,day);}}
    public static int difference(MyDate date1, MyDate date2){
        int days = 0;
        if (Bigger(date1,date2) == 1){
            for (int i = date1.year; i < date2.year ; i++) {
                if(i%4 == 0 && i % 100 != 0 || i % 400 == 0){
                    days +=366;
                }else{
                    days +=365;}}
            if (date1.year%4 == 0 && date1.year % 100 != 0 || date1.year % 400 == 0){
                for (int i = 0; i < date1.month - 1; i++) {
                    days -= runnian[i];}}
            else {
                for (int i = 0; i < date1.month - 1; i++) {
                    days -= feirunnian[i];}}
            days -= date1.day;
            if (date2.year%4 == 0 && date2.year % 100 != 0 || date2.year % 400 == 0){
                for (int i = 0; i < date2.month - 1; i++) {
                    days += runnian[i];}}
            else {
                for (int i = 0; i < date2.month - 1; i++) {
                    days += feirunnian[i];}}
            days += date2.day;
            return -days;}
        else {
            for (int i = date2.year; i < date1.year ; i++) {
                if(i%4 == 0 && i % 100 != 0 || i % 400 == 0){
                    days +=366;
                }else{
                    days +=365;}}
            if (date1.year%4 == 0 && date1.year % 100 != 0 || date1.year % 400 == 0){
                for (int i = 0; i < date1.month - 1; i++) {
                    days += runnian[i];}}
            else {
                for (int i = 0; i < date1.month - 1; i++) {
                    days += feirunnian[i];}}
            days += date1.day;
            if (date2.year%4 == 0 && date2.year % 100 != 0 || date2.year % 400 == 0){
                for (int i = 0; i < date2.month - 1; i++) {
                    days -= runnian[i];}}
            else {
                for (int i = 0; i < date2.month - 1; i++) {
                    days -= feirunnian[i];}}
            days -= date2.day;
            return days;}}
    public static int Bigger(MyDate date1, MyDate date2){
        if (date1.year>date2.year){
            return 0;
        } else if (date1.year == date2.year && date1.month > date2.month) {
            return 0;
        } else if (date1.year == date2.year && date1.month == date2.month && date1.day > date2.day) {
            return 0;
        } else {
            return 1;}}}