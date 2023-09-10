import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        int fromYear = 2001;
        int toYear = 2080;

        printBonusDatesBetween(fromYear, toYear);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        String pattern = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int y = fromYear; y <= toYear; y++) {
            for (int m = 1; m <= 12; m++) {
                for (int d = 1; d <= 31; d++) {
                    try {
                        String dateString = String.format("%04d%02d%02d", y, m, d);
                        Date date = simpleDateFormat.parse(dateString);
                        String checkedDate = simpleDateFormat.format(date);
                        String reverseDate = new StringBuilder(checkedDate).reverse().toString();

                        if (checkedDate.equals(reverseDate)) {
                            String finalDate = outputDateFormat.format(date);
                            System.out.println(finalDate);
                        }
                    } catch (java.text.ParseException e) {}
                }
            }
        }
    }
}
