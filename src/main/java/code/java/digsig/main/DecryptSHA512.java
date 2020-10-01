package code.java.digsig.main;
import java.io.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DecryptSHA512 {

    public static void main(String[] args) {
        DecryptSHA512 dsg = new DecryptSHA512();
        String msg="vikash";
        //String msg = "a8f51fd86e36fa6b49da51438cc2fb3051b3f86323f6ab043ef67ef713d1a0e5f8cd95ecbbbae65000bcf3d0f8cfe11e54d764ed413a6f5314c6ad9fcc5f0400$d462287e74820bed";
        try {
            System.out.println("In Try");
            String result= dsg.dsGenerator(msg);
            System.out.println("result value is " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("exiting");
    }

    public String dsGenerator(String msg) throws IOException {
        String sigEncoded = null;
        BufferedInputStream bufin = null;
        InputStream is = null;
        try {
            //InputStream keyfis = DecryptSHA512.class.getResourceAsStream("/key/PrivateKey.pem");
            InputStream keyfis = new FileInputStream("G:\\AWS\\digsig\\PrivateKey.pem");
            System.out.println("value of key==");
            byte[] encKey = new BASE64Decoder().decodeBuffer(keyfis);
            keyfis.close();
            PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(encKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privKey = keyFactory.generatePrivate(privKeySpec);
            Signature rsa = Signature.getInstance("SHA1withRSA");
            rsa.initSign(privKey);
            is = new ByteArrayInputStream(msg.getBytes("UTF-8"));
            bufin = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            while (bufin.available() != 0) {
                int len = bufin.read(buffer);
                rsa.update(buffer, 0, len);
            }
            bufin.close();
            byte[] realSig = rsa.sign();
            sigEncoded = new BASE64Encoder().encode(realSig).replace("\r\n", "");
        } catch (Exception e) {
            e.printStackTrace();
            bufin.close();
            is.close();
        } finally {
            bufin.close();
            is.close();
        }
        return sigEncoded;
    }
}
