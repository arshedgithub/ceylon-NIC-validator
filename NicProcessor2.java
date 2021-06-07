import java.io.Console;
import java.time.LocalDate;

public class NicProcessor2{
    
    public static void main(String[] args) {

        Console cons = System.console();
        String nic = cons.readLine("Enter NIC : ");

        int birthyear = CeylonNic.getBirthYear(nic);
        String gender = CeylonNic.getGender(nic);
        int birthMon = CeylonNic.getBirthMonth(nic);
        String monName = CeylonNic.getMonthName(nic);
        int day = CeylonNic.getBirthDay(nic);

        if(birthyear != -1){
            cons.printf("BirthYear - " + birthyear + "\n");
            cons.printf("Gender - " + gender + "\n");
            cons.printf("Birth Month - " + birthMon + "\n");
            cons.printf("Month Name - " + monName + "\n");
            cons.printf("Day - " + day + "\n");
            cons.printf("-------------------\n");

            LocalDate dob = CeylonNic.getBirthDate(nic);
            cons.printf("Birth Year - " + dob.getYear() + "\n");
            cons.printf("Gender - " + gender + "\n");
            cons.printf("Birth Month - " + dob.getMonthValue() + "\n");
            cons.printf("Month Name - " + dob.getMonth() + "\n");
            cons.printf("Day - " + dob.getDayOfMonth() + "\n");

        }else{
            cons.printf("NIC is invlalid" + "\n");
        }

    }

}