import java.io.Console;

public class CustomerRegister{
    public static void main(String[] args) {
        
        Console cons = System.console();
        String nic = cons.readLine("Enter NIC : ");
        boolean nicValidity = CeylonNic.isValid(nic);

        if (nicValidity)
        {
            cons.printf("Successfully Registered");
        }


    }
}