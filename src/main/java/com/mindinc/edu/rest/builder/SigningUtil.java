package com.mindinc.edu.rest.builder;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.stereotype.Component;

import java.security.Security;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class SigningUtil {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static Map<String, String> parseAuthorizationHeader(String authHeader) {
        Map<String, String> holder = new HashMap<String, String>();
        if (authHeader.contains("Signature ")) {
            authHeader = authHeader.replace("Signature ", "");
            String[] keyVals = authHeader.split(",");
            for (String keyVal : keyVals) {
                String[] parts = keyVal.split("=", 2);
                if (parts[0] != null && parts[1] != null)
                    holder.put(parts[0].trim(), parts[1].trim());
            }
            return holder;
        }
        return null;
    }

    public String generateSignature(String req, String pk) {
        String signature = null;
        try {

            Ed25519PrivateKeyParameters privateKey = new Ed25519PrivateKeyParameters(Base64.getDecoder().decode(pk.getBytes()), 0);

            Signer sig = new Ed25519Signer();
            sig.init(true, privateKey);
            sig.update(req.getBytes(), 0, req.length());

            byte[] s1 = sig.generateSignature();

            signature = Base64.getEncoder().encodeToString(s1);

            log.info("Signature Generated From Data : " + signature);

        } catch (DataLengthException | CryptoException e) {
            log.error("Exception occured while generating signature -", e);
        }
        return signature;
    }

    public String generateBlakeHash(String req) {
        log.info("Creating digest for below:");
        log.info(req);
        Blake2bDigest blake2bDigest = new Blake2bDigest(512);

        byte[] test = req.getBytes();
        blake2bDigest.update(test, 0, test.length);

        byte[] hash = new byte[blake2bDigest.getDigestSize()];
        blake2bDigest.doFinal(hash, 0);

        String hex = Hex.toHexString(hash);
        log.info("Hex : {}", hex);
        String bs64 = Base64.getUrlEncoder().encodeToString(hex.getBytes());
        log.info("Base64 URL Encoded : {}", bs64);
        return bs64;
    }
}
