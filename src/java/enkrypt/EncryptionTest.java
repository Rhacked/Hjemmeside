/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enkrypt;

/**
 *
 * @author Rubenhag
 */
public class EncryptionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Encryption enc = new Encryption();
        String pw = "3318ruben";
        byte[] x = enc.encrypt(pw);
        System.out.println(x);
        System.out.println(enc.decrypt(x));
    }
}
