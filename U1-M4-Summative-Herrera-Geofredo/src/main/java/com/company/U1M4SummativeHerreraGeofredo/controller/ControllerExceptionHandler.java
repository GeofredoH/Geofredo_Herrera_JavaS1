package com.company.U1M4SummativeHerreraGeofredo.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> magicValidationError(MethodArgumentNotValidException e, WebRequest request) {

        BindingResult result = e.getBindingResult();  // BindingResult holds errors returned from MethodArgumentNotValidException object

        List<FieldError> fieldErrors = result.getFieldErrors();  // validation errors are initialized into a list as field errors

        List<VndErrors.VndError> vndErrorList = new ArrayList<>();  // initialize list to hold translated errors

        //Iterates through field error list and initializes each error to a VndErrors.VndError object preceded by the message from the WebRequest
        //adds each VndErrors.VndError to vndErrorList
        for (FieldError fieldError : fieldErrors) {
            VndErrors.VndError vndError = new VndErrors.VndError(request.toString(), fieldError.getDefaultMessage());
            vndErrorList.add(vndError);
        }

        VndErrors vndErrors = new VndErrors(vndErrorList); // VndErrors object holds the list of VndErrors.VndError objects

        // Create ResponseEntity of the VndErrors type and pass in the VndErrors object and ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) to constructor
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(vndErrors, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;

    }

}
