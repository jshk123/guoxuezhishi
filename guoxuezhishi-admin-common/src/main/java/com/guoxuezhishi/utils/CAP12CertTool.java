package com.guoxuezhishi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * @author: jiang
 * @date: 2019/7/4
 */
public class CAP12CertTool {
    private static SignedPack signedPack;

    public CAP12CertTool(String path, String keyPass) throws SecurityException, FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        signedPack = this.getP12(fileInputStream, keyPass);
    }

    private SignedPack getP12(InputStream fileInputStream, String keyPass) throws SecurityException {
        SignedPack sp = new SignedPack();

        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            char[] nPassword = (char[]) null;
            if (keyPass != null && !keyPass.trim().equals("")) {
                nPassword = keyPass.toCharArray();
            } else {
                nPassword = (char[]) null;
            }

            ks.load(fileInputStream, nPassword);
            Enumeration enum2 = ks.aliases();
            String keyAlias = null;
            if (enum2.hasMoreElements()) {
                keyAlias = (String) enum2.nextElement();
            }

            PrivateKey priKey = (PrivateKey) ks.getKey(keyAlias, nPassword);
            System.out.println(priKey);
            Certificate cert = ks.getCertificate(keyAlias);
            PublicKey pubKey = cert.getPublicKey();
            sp.setCert((X509Certificate) cert);
            sp.setPubKey(pubKey);
            sp.setPriKey(priKey);
        } catch (Exception var13) {
            var13.printStackTrace();
            throw new SecurityException(var13.getMessage());
        }

        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException var12) {
                ;
            }
        }

        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException var11) {
                ;
            }
        }

        return sp;
    }

    public X509Certificate getCert() {
        return signedPack.getCert();
    }

    public byte[] getSignData(byte[] indata) throws SecurityException {
        byte[] res = (byte[]) null;

        try {
            Signature signet = Signature.getInstance("SHA256WITHRSA");
            signet.initSign(this.getPrivateKey());
            signet.update(indata);
            res = signet.sign();
            return res;
        } catch (InvalidKeyException var4) {
            throw new SecurityException(var4.getMessage());
        } catch (NoSuchAlgorithmException var5) {
            throw new SecurityException(var5.getMessage());
        } catch (SignatureException var6) {
            throw new SecurityException(var6.getMessage());
        }
    }

    public PrivateKey getPrivateKey() {
        return signedPack.getPriKey();
    }
}
