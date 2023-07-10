import java.time.*;
import java.time.format.*;
public class DateTest{
  public static void main(String[] args){
    LocalDateTime ps = LocalDateTime.of(2017, 03, 02, 10,12, 13);
    System.out.println(ps);
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);

    DateTimeFormatter f1 = DateTimeFormatter.ISO_LOCAL_DATE;
    
    String toen = ps.format(f1);
    System.out.println(toen);
  }
}