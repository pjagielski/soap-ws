package com.centeractive.ws.client;

/**
 * Copyright (c) centeractive ag, Inc. All Rights Reserved.
 *
 * User: Tom Bujok (tomasz.bujok@centeractive.com)
 * Date: 22/11/11
 * Time: 8:11 PM
 */
public class TransmissionException extends SoapClientException {

    private final String errorResponse;
    private final int errorCode;

    public TransmissionException(String response, int errorCode, Throwable cause) {
        super(response + "; HTTP code = [" + errorCode + "]; possible cause: " +cause.getMessage(), cause);
        this.errorResponse = response;
        this.errorCode = errorCode;
    }

    public String getErrorResponse() {
        return errorResponse;
    }

    public int getErrorCode() {
        return errorCode;
    }

}