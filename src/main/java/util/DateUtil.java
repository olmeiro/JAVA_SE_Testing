package util;

public class DateUtil {
    public  static boolean isLeapYear(int year) {

        //   if(year % 4 == 0 && year % 100 != 0){
        //       return true;
        //   //   if(year % 400 == 0){
        //       return true;
        //   }else{
        //       return false;

        //       //refactor:
        //   if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
        //       return true;
        //   }else{
        //       return false;
        //   }

        //refactoring:
        return (year % 4 == 0 && year % 100 != 0) || (year % 400) == 0;
    }
}
