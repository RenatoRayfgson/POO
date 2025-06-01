package poo.utilities;

public class Utilities {

    public static boolean isValidCPF(String cpf) {
        // Remove non-numeric characters
        cpf = cpf.replaceAll("[^0-9]", "");        
        // Check if the length is 11        
        return cpf.length() == 11;
    }

    public static boolean isOnlyDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }        
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }    
        return true;
    }
    
    public static boolean isValidEmail(String email) {
        // Simple regex for basic email validation
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    public static boolean isValidTelephone(String telephone) {
        // Simple regex for Brazilian telephone validation (XX XXXXXXXXX)
        String telephoneRegex = "^\\d{2} \\d{9}$";
        return telephone != null && telephone.matches(telephoneRegex);
    }
}
