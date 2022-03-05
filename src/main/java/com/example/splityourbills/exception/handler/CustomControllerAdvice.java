package com.example.splityourbills.exception.handler;


import com.example.splityourbills.common.BaseApiResponse;
import com.example.splityourbills.exception.custom_exceptions.common.CustomDataConflictException;
import com.example.splityourbills.exception.custom_exceptions.common.CustomParameterConstraintException;
import com.example.splityourbills.exception.custom_exceptions.auth.AuthenticationException;
import com.example.splityourbills.exception.custom_exceptions.common.InternalServerException;
import com.example.splityourbills.exception.custom_exceptions.common.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
class CustomControllerAdvice {

    private int NO_DATA_FOUND_CODE = 1;

    @ExceptionHandler(NullPointerException.class) // exception handled
    public ResponseEntity<ErrorResponse> handleNullPointerExceptions(
            Exception e
    ) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage()
                ),
                status
        );
    }

    @ExceptionHandler(InternalServerException.class) // exception handled
    public ResponseEntity<ErrorResponse> handleInternalServerException(
            Exception e
    ) {
        // ... potential custom logic

        //TODO change this
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage(),
                        stackTrace
                ),
                status
        );
    }


    @ExceptionHandler(AuthenticationException.class) // exception handled
    public ResponseEntity<ErrorResponse> handleRegistrationException(
            Exception e
    ) {
        // ... potential custom logic

        //TODO change the response code
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage(),
                        stackTrace
                ),
                status
        );
    }

    // fallback method
    @ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<ErrorResponse> handleExceptions(
            Exception e
    ) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

        // converting the stack trace to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage(),
                        stackTrace // specifying the stack trace in case of 500s
                ),
                status
        );
    }


    /***
    * When there is a conflict of data, use cases-
     * 1. While registering the user, if we use already existing phone number
     *
     * ***/
    @ExceptionHandler(CustomDataConflictException.class)
    public BaseApiResponse handleCustomDataNotFoundExceptions(
            Exception e
    ) {
        HttpStatus status = HttpStatus.CONFLICT; // 409

        // converting the stack trace to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();
        ErrorResponse er =  new ErrorResponse(
                status,
                e.getMessage(),
                stackTrace,
                false
        );
        return new BaseApiResponse(false,null,er);
    }

    @ExceptionHandler(CustomParameterConstraintException.class)
    public ResponseEntity<ErrorResponse> handleCustomParameterConstraintExceptions(
            Exception e
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST; // 400

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage()
                ),
                status
        );
    }

    /***
     * This is the default response for 404 not found exception ie the path does not exist
     * ***/
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public BaseApiResponse requestHandlingNoHandlerFound() {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, "This path does not exist");
        return new BaseApiResponse(false,null,errorResponse);
    }
    /***
     * Most common response ; when no data is found
     * ***/

    @ExceptionHandler(ResourceNotFoundException.class) // exception handled
    public ResponseEntity<ErrorResponse> handleResourceNotFound(
            Exception e
    ) {
        // ... potential custom logic

        //TODO change this
        HttpStatus status = HttpStatus.NOT_FOUND; // 404- because the api call is correct but no data found
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage(),
                        stackTrace,
                        false,
                        NO_DATA_FOUND_CODE
                ),
                status
        );
    }


}
