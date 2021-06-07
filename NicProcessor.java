import java.io.Console;

public class NicProcessor{
    public static void main(String[] args) {
        
        Console cons = System.console();
        String nic = cons.readLine("Enter NIC : ");

        boolean nicValidity = CeylonNic.isValid(nic);

        if(nicValidity){
            String yrstr = nic.substring(0,2);
            String fullyrstr = "19"+yrstr;

            String genstr = nic.substring(2,5);
            int gen = Integer.parseInt(genstr);

            String gender = "not defined";

            if(gen<500){gender = "Male";}
            else{gender = "Female";}

            String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
            int dates[] = {31,59,90,120,151,181,212,243,273,304,334,365};

            int j=0;
            while(j<dates.length){
                if (gen<dates[j]) break;
                j++;
            }
            System.out.println();
            int birthMon = j+1;
            String monStr = months[j];

            int date = gen-dates[j-1];

            cons.printf("Birth Year - " + fullyrstr + "\n");
            cons.printf("Gender - " + gender + "\n");   
            cons.printf("Birth Month - " + birthMon + " (" +monStr + ")" +"\n");  
            cons.printf("Birth Date - " + fullyrstr + " : " + birthMon + " : " + date);
        } 
        else{ cons.printf("NIC is invalid"+ "\n"); }

    }
}