package fileencrypt;

public class CaesarCipher {
    public static String encryptData(String inputStr, int shiftKey) {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   
        
        inputStr = inputStr.toLowerCase();
        String encryptStr = "";
        
        for (int i = 0; i < inputStr.length(); i++) {   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));   
              
            int encryptPos = (shiftKey + pos) % 26;   
            char encryptChar = ALPHABET.charAt(encryptPos);
            
            encryptStr += encryptChar;   
        }
        
        return encryptStr;   
    }   
      
    // create decryptData() method for decrypting user input string with given shift key   
    public static String decryptData(String inputStr, int shiftKey) {   
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   
        
        inputStr = inputStr.toLowerCase();   
        String decryptStr = "";   
          
        // use for loop for traversing each character of the input string   
        for (int i = 0; i < inputStr.length(); i++) {   
              
            // get position of each character of inputStr in ALPHABET   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));   
              
            // get decrypted char for each char of inputStr   
            int decryptPos = (pos - shiftKey) % 26;   
              
            // if decryptPos is negative   
            if (decryptPos < 0) {
                decryptPos = ALPHABET.length() + decryptPos;   
            }   
            char decryptChar = ALPHABET.charAt(decryptPos);
            
            decryptStr += decryptChar;   
        }   
        
        return decryptStr;
    }
    
    public static String caesar(String text) {
        StringBuilder sb = new StringBuilder(text.length());
        
        int shift = 7;
        
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c += shift;
                if (c > 'Z') c -= 26;
            } else if (c >= 'a' && c <= 'z') {
                c += shift;
                if (c > 'z') c -= 26;
            }

            sb.append((char) c);
        }
        return sb.toString();
    }
}
