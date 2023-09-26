package com.mindinc.edu.rest.builder;

import com.mindinc.edu.rest.beckn.enums.AckStatus;
import com.mindinc.edu.rest.beckn.enums.ErrorCode;
import com.mindinc.edu.rest.beckn.model.common.*;
import com.mindinc.edu.rest.beckn.model.common.Error;
import com.mindinc.edu.rest.beckn.model.response.Response;
import com.mindinc.edu.rest.beckn.model.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
public class ResponseBuilder {
    public static final String DSEP_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String URL = "https://mapetit.app/dsep/v1";
    private static final String ALGO = "ed25519";
    private static final String UNIQ_KEY_ID = "mapetit.bpp";
    private static final String SUB_ID = "mapetit.app/dsep/v1";
    private static final String PRIVATE_KEY = "E1YUw7qUDrg2Doo768VXeG5ivZAB2V1LfdTf2bLWdIGL0ttitsQwR59l6xIdHI48XnOakM+wJvowYxe+zNJQbg==";
    private static final String PUBLIC_KEY = "i9LbYrbEMEefZesSHRyOPF5zmpDPsCb6MGMXvszSUG4=";
    private static final long REQUEST_EXPIRY_TIME_PERIOD_IN_SEC = 600;

    public static Context buildContext(Context context, String action) {
        context.setAction(action);
        context.setBppUri(URL);
        context.setBppId("mapetit.bpp");
        return context;
    }

    public static Response buildResponseEntity(Context ctx) {
        Location location = new Location();
        Country country = new Country();
        country.setName("India");
        country.setCode("IND");
        location.setCountry(country);

        ctx.setLocation(location);

        return buildAckResponse(ctx);
    }

    private static Response buildAckResponse(Context context) {
        Response response = new Response();
        ResponseMessage resMsg = new ResponseMessage();

        resMsg.setAck(new Ack(AckStatus.ACK));
        response.setMessage(resMsg);

        context.setTimestamp(getDateTimeString(new Date()));

        response.setContext(context);
        return response;
    }

    public static Response buildNACKResponseEntity(Context ctx, String error) {
        Location location = new Location();
        City city = new City();
        city.setName("Bangalore");
        city.setCode("std:080");
        location.setCity(city);

        Country country = new Country();
        country.setName("India");
        country.setCode("IND");
        location.setCountry(country);

        ctx.setLocation(location);

        return buildNACKResponse(ctx, error);
    }

    private static Response buildNACKResponse(Context context, String error) {
        Response response = new Response();
        ResponseMessage resMsg = new ResponseMessage();

        resMsg.setAck(new Ack(AckStatus.NACK));
        response.setMessage(resMsg);

        Error err = new Error();
        err.setCode(error);
        err.setMessage(ErrorCode.ERRORCODE.get(error));
        response.setError(err);

        context.setTimestamp(getDateTimeString(new Date()));

        response.setContext(context);
        return response;
    }

    public static String getDateTimeString(Date date) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat(DSEP_TIMESTAMP_FORMAT);
        df.setTimeZone(tz);
        return df.format(date);
    }

    public static String getDateTimeString(OffsetDateTime date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DSEP_TIMESTAMP_FORMAT);

        return date.format(df);
    }

    public static String getDateTimeString(LocalDateTime date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DSEP_TIMESTAMP_FORMAT);

        return date.format(df);
    }

    public static String generateAuthHeader(String request) {

        SigningUtil signingUtil = new SigningUtil();
        String reqBleckHash = signingUtil.generateBlakeHash(request);
        long creationTime = System.currentTimeMillis() / 1000L;
        String kid = SUB_ID + "|" + UNIQ_KEY_ID + "|" + ALGO;
        String header = "(created) (expires) digest";
        String signingString = "(created): "
                + creationTime + "\n(expires): "
                + (creationTime + REQUEST_EXPIRY_TIME_PERIOD_IN_SEC)
                + "\ndigest: BLAKE-512=" + reqBleckHash + "";
        String signedReq = signingUtil.generateSignature(signingString, PRIVATE_KEY);

        header = "Signature keyId=" + kid + ", created=" + creationTime + ", expires="
                + (creationTime + 60000) + ", algorithm=" + ALGO + ", headers="
                + header + ", signature=" + signedReq + "";

        log.info("Generated Auth Header ==> {} ", header);

        return header;
    }
}
