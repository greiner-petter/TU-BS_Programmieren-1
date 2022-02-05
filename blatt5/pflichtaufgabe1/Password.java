public class Password {

    /** stores the password **/ 
    private String password;

    /**
    constructor for password
    @param password
    **/
    public Password(String password) {
        this.password = password;
    }

    String getPassword() {
        return password;
    }

    /**
    checks if the password is 10 characters long an contains at least 2 numbers
    @return if the password meets the criteria
    **/
    boolean checkPassword() {
        if (password.length() == 10) {
            int numberCounter = 0;
            char[] passwordCharatcerList = password.toCharArray();
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(passwordCharatcerList[i])) {
                    numberCounter++;
                }
            }
            if (numberCounter < 2) {
                return false;
            }
            return true;
        }
        return false;
    }
}
