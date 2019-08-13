package com.guoxuezhishi.utils;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: jiang
 * @date: 2019/7/4
 */
public class RSASignUtil {
    private String certFilePath = null;
    private String password = null;
    private String hexCert = null;
    private String rootCertPath = null;

    public RSASignUtil(String certFilePath, String password) {
        this.certFilePath = certFilePath;
        this.password = password;
    }

    public RSASignUtil(String rootCertPath) {
        this.rootCertPath = rootCertPath;
    }

    public RSASignUtil() {
    }

    public String sign(String indata, String encoding) {
        String singData = null;

        try {
            CAP12CertTool c = new CAP12CertTool(this.certFilePath, this.password);
            X509Certificate cert = c.getCert();
            byte[] si = c.getSignData(indata.getBytes(encoding));
            byte[] cr = cert.getEncoded();
            this.hexCert = HexStringByte.byteToHex(cr);
            singData = HexStringByte.byteToHex(si);
        } catch (CertificateEncodingException var8) {
            var8.printStackTrace();
        } catch (FileNotFoundException var9) {
            var9.printStackTrace();
        } catch (UnsupportedEncodingException var10) {
            var10.printStackTrace();
        } catch (SecurityException var11) {
            var11.printStackTrace();
        }

        return singData;
    }

    public String getCertInfo() {
        return this.hexCert;
    }

    public boolean verify(String oridata, String signData, String svrCert, String encoding) {
        boolean res = false;

        try {
            byte[] signDataBytes = HexStringByte.hexToByte(signData.getBytes());
            byte[] inDataBytes = oridata.getBytes(encoding);
            byte[] signaturepem = checkPEM(signDataBytes);
            if (signaturepem != null) {
                signDataBytes = Base64.decode(signaturepem);
            }

            X509Certificate cert = this.getCertFromHexString(svrCert);
            if (cert != null) {
                PublicKey pubKey = cert.getPublicKey();
                Signature signet = Signature.getInstance("SHA256WITHRSA");
                signet.initVerify(pubKey);
                signet.update(inDataBytes);
                res = signet.verify(signDataBytes);
            }
        } catch (InvalidKeyException var12) {
            var12.printStackTrace();
        } catch (NoSuchAlgorithmException var13) {
            var13.printStackTrace();
        } catch (SignatureException var14) {
            var14.printStackTrace();
        } catch (SecurityException var15) {
            var15.printStackTrace();
        } catch (UnsupportedEncodingException var16) {
            var16.printStackTrace();
        }

        return res;
    }

    public X509Certificate getCertfromPath(String crt_path) throws SecurityException {
        X509Certificate cert = null;
        FileInputStream inStream = null;

        try {
            inStream = new FileInputStream(new File(crt_path));
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            cert = (X509Certificate) cf.generateCertificate(inStream);
            return cert;
        } catch (CertificateException var5) {
            throw new SecurityException(var5.getMessage());
        } catch (FileNotFoundException var6) {
            throw new SecurityException(var6.getMessage());
        }
    }

    public static PublicKey getPublicKeyfromPath(String svrCertpath) throws SecurityException {
        X509Certificate cert = null;
        FileInputStream inStream = null;

        try {
            inStream = new FileInputStream(new File(svrCertpath));
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            cert = (X509Certificate) cf.generateCertificate(inStream);
        } catch (CertificateException var4) {
            throw new SecurityException(var4.getMessage());
        } catch (FileNotFoundException var5) {
            throw new SecurityException(var5.getMessage());
        }

        return cert.getPublicKey();
    }

    public boolean verifyCert(X509Certificate userCert, X509Certificate rootCert) throws SecurityException {
        boolean res = false;

        try {
            PublicKey rootKey = rootCert.getPublicKey();
            userCert.checkValidity();
            userCert.verify(rootKey);
            res = true;
            if (!userCert.getIssuerDN().equals(rootCert.getSubjectDN())) {
                res = false;
            }

            return res;
        } catch (CertificateExpiredException var5) {
            throw new SecurityException(var5.getMessage());
        } catch (CertificateNotYetValidException var6) {
            throw new SecurityException(var6.getMessage());
        } catch (InvalidKeyException var7) {
            throw new SecurityException(var7.getMessage());
        } catch (CertificateException var8) {
            throw new SecurityException(var8.getMessage());
        } catch (NoSuchAlgorithmException var9) {
            throw new SecurityException(var9.getMessage());
        } catch (NoSuchProviderException var10) {
            throw new SecurityException(var10.getMessage());
        } catch (SignatureException var11) {
            throw new SecurityException(var11.getMessage());
        }
    }

    private X509Certificate getCertFromHexString(String hexCert) throws SecurityException {
        ByteArrayInputStream bIn = null;
        X509Certificate certobj = null;
        byte[] cert = HexStringByte.hexToByte(hexCert.getBytes());
        CertificateFactory fact = null;

        try {
            fact = CertificateFactory.getInstance("X.509");
        } catch (CertificateException var13) {
            var13.printStackTrace();
        }

        bIn = new ByteArrayInputStream(cert);

        try {
            certobj = (X509Certificate) fact.generateCertificate(bIn);
            bIn.close();
            bIn = null;
        } catch (CertificateException var11) {
            var11.printStackTrace();
        } catch (IOException var12) {
            var12.printStackTrace();
        }

        try {
            if (bIn != null) {
                bIn.close();
            }
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        try {
            if (bIn != null) {
                bIn.close();
            }
        } catch (IOException var9) {
            ;
        }

        try {
            if (bIn != null) {
                bIn.close();
            }
        } catch (IOException var8) {
            ;
        }

        try {
            if (bIn != null) {
                bIn.close();
            }
        } catch (IOException var7) {
            ;
        }

        return certobj;
    }

    public static byte[] checkPEM(byte[] paramArrayOfByte) {
        String str1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/+= \r\n-";

        for (int i = 0; i < paramArrayOfByte.length; ++i) {
            if (str1.indexOf(paramArrayOfByte[i]) == -1) {
                return null;
            }
        }

        StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
        String str2 = new String(paramArrayOfByte);

        for (int j = 0; j < str2.length(); ++j) {
            if (str2.charAt(j) != ' ' && str2.charAt(j) != '\r' && str2.charAt(j) != '\n') {
                localStringBuffer.append(str2.charAt(j));
            }
        }

        return localStringBuffer.toString().getBytes();
    }

    public String getFormValue(String respMsg, String name) {
        String[] resArr = StringUtils.split(respMsg, "&");
        Map resMap = new HashMap();

        for (int i = 0; i < resArr.length; ++i) {
            String data = resArr[i];
            int index = StringUtils.indexOf(data, '=');
            String nm = StringUtils.substring(data, 0, index);
            String val = StringUtils.substring(data, index + 1);
            resMap.put(nm, val);
        }

        return (String) resMap.get(name) != null ? (String) resMap.get(name) : "";
    }

    public String getValue(String respMsg, String name) {
        String[] resArr = StringUtils.split(respMsg, "&");
        Map resMap = new HashMap();

        for (int i = 0; i < resArr.length; ++i) {
            String data = resArr[i];
            int index = StringUtils.indexOf(data, '=');
            String nm = StringUtils.substring(data, 0, index);
            String val = StringUtils.substring(data, index + 1);
            resMap.put(nm, val);
        }

        return (String) resMap.get(name) != null ? (String) resMap.get(name) : "";
    }

    public static Map coverString2Map(String respMsg) {
        String[] resArr = StringUtils.split(respMsg, "&");
        Map resMap = new HashMap();

        for (int i = 0; i < resArr.length; ++i) {
            String data = resArr[i];
            int index = StringUtils.indexOf(data, '=');
            String nm = StringUtils.substring(data, 0, index);
            String val = StringUtils.substring(data, index + 1);
            resMap.put(nm, val);
        }

        return resMap;
    }

    public static String coverMap2String(Map data) {
        TreeMap tree = new TreeMap();
        Iterator it = data.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry en = (Map.Entry) it.next();
            String value = "";
            if (!"merchantSign".equals(((String) en.getKey()).trim()) && !"serverSign".equals(((String) en.getKey()).trim()) && !"serverCert".equals(((String) en.getKey()).trim())) {
                tree.put(en.getKey(), en.getValue());
            }
        }

        it = tree.entrySet().iterator();
        StringBuffer sf = new StringBuffer();

        while (it.hasNext()) {
            Map.Entry en = (Map.Entry) it.next();
            sf.append((String) en.getKey() + "=" + (String) en.getValue() + "&");
        }

        return sf.substring(0, sf.length() - 1);
    }

    public static String encryptData(String dataString, String encoding, String svrCertPath) {
        Object var3 = null;

        try {
            byte[] data = encryptedPin(getPublicKeyfromPath(svrCertPath), dataString.getBytes(encoding));
            return new String(base64Encode(data), encoding);
        } catch (Exception var5) {
            var5.printStackTrace();
            return "";
        }
    }

    public static byte[] encryptedPin(PublicKey publicKey, byte[] plainPin) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", new BouncyCastleProvider());
            cipher.init(1, publicKey);
            int blockSize = cipher.getBlockSize();
            int outputSize = cipher.getOutputSize(plainPin.length);
            int leavedSize = plainPin.length % blockSize;
            int blocksSize = leavedSize == 0 ? plainPin.length / blockSize : plainPin.length / blockSize + 1;
            byte[] raw = new byte[outputSize * blocksSize];

            for (int i = 0; plainPin.length - i * blockSize > 0; ++i) {
                if (plainPin.length - i * blockSize > blockSize) {
                    cipher.doFinal(plainPin, i * blockSize, blockSize, raw, i * outputSize);
                } else {
                    cipher.doFinal(plainPin, i * blockSize, plainPin.length - i * blockSize, raw, i * outputSize);
                }
            }

            return raw;
        } catch (Exception var9) {
            throw new Exception(var9.getMessage());
        }
    }

    public static byte[] base64Encode(byte[] inputByte) throws IOException {
        return Base64.encode(inputByte);
    }
}
