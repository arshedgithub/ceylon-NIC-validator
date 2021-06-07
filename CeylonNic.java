import java.time.LocalDate;

public class CeylonNic{

    public static LocalDate getBirthDate(String nic) {
        LocalDate bdate = null;

        boolean nicValidity = isValid(nic);

        if(nicValidity){
            int yr = getBirthYear(nic);
            int mon = getBirthMonth(nic);
            int dt = getBirthDay(nic);

            bdate = LocalDate.of(yr,mon,dt);
        }
        return bdate;
    }

    public static boolean isValid(String nic) {
        
        int length = nic.length();
        char lastchar = nic.charAt(length-1);
        String numpart = nic.substring(0, length-1);

        boolean numValidity = ValidationUtility.isNumeric(numpart);

        if(length == 10 && (lastchar == 'V' || lastchar == 'v') && numValidity ) {return true;}
        else {return false;}

    }

    public static int getBirthYear(String nic) {
        
        boolean nicValidity = isValid(nic);

        if(nicValidity){

            String yrstr =nic.substring(0,2);
            int yr = Integer.parseInt(yrstr);
            yr=yr+1900;
            return yr;
        }
        else { return -1;}
    }

    public static String getGender(String nic){
        boolean nicValidity = isValid(nic);

        if(nicValidity){
            int ds = getBirthDays(nic);
            String gen = null;
            if(ds<500) gen="male";
            else gen = "female";

            return gen;
        }
        else {return null;}
    }

    public static int getBirthDays(String validNic) {
            String dsstr = validNic.substring(2,5);
            int ds = Integer.parseInt(dsstr);
            return ds;
    }

    public static int getBirthMonth(String nic) {
        boolean nicValidity = isValid(nic);

        if(nicValidity){
            int ds = getBirthDays(nic);
           if (ds>500) ds = ds-500;
           int dts[] = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
           
           int j=0;

           while(j<dts.length){
               if(ds< dts[j]) break;
               j++;
           }

           int birthMon = j+1;
           return birthMon;
        }
        else return -1;
    }

    public static String getMonthName(String nic) {
        int m = getBirthMonth(nic);
         
        String mn = null;
        String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}; 

        if (m != -1) {mn = months[m-1];}
        return mn;
    }

    public static int getBirthDay(String nic) {
        boolean nicValidity = isValid(nic);

        if(nicValidity){
            int ds = getBirthDays(nic);

            if(ds>500) ds = ds-500;
            int m = getBirthMonth(nic);

           int dts[] = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
           int day = ds - dts[m-2];
           return day;
        }
        else return -1;
    }
}