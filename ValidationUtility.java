public class ValidationUtility{
    public static boolean isNumeric(String value) {
        
        boolean validity = true;
        int i=0;

        while(i < value.length() && validity){
            
            char chr = value.charAt(i);

            if(chr == '0' || chr == '1' || chr == '2' || chr == '3' || chr == '4' || chr == '5' || chr == '6' || chr == '7' || chr == '8' || chr == '9'){ validity=true; }
            else { validity=false;
            }
            i++;

        }

        return validity;

    }
}