/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enkrypt;

/**
 *
 * @author Rubenhag
 */
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;

public class Encryption {
    
    String key = "jKedOp28h67dEIRm817sed43";

    public byte[] encrypt(String str) {
        try {
            byte[] keyBytes = key.getBytes("ASCII");
            DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            SecretKey key;
            key = factory.generateSecret(keySpec);
            
            byte[] text = str.getBytes("ASCII");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] textEncr = cipher.doFinal(text);
            return textEncr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(System.err);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace(System.err);
        } catch (InvalidKeyException e) {
            e.printStackTrace(System.err);
        } catch (IllegalBlockSizeException e){
            e.printStackTrace(System.err);
        } catch (BadPaddingException e){
            e.printStackTrace(System.err);
        } catch (UnsupportedEncodingException e){
            e.printStackTrace(System.err);
        } catch (InvalidKeySpecException e){
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public String decrypt(byte[] byt){
        try{
            byte[] keyBytes = key.getBytes("ASCII");
            DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            SecretKey key = factory.generateSecret(keySpec);
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] textDecr = cipher.doFinal(byt);
            return new String(textDecr);
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace(System.err);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace(System.err);
        } catch (InvalidKeyException e) {
            e.printStackTrace(System.err);
        } catch (IllegalBlockSizeException e){
            e.printStackTrace(System.err);
        } catch (BadPaddingException e){
            e.printStackTrace(System.err);
        } catch (InvalidKeySpecException e){
            e.printStackTrace(System.err);
        } catch (UnsupportedEncodingException e){
           e.printStackTrace(System.err);
        }
        return null;
    }
}
