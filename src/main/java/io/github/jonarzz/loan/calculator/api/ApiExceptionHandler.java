package io.github.jonarzz.loan.calculator.api;

import static java.util.stream.Collectors.joining;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ApiExceptionHandler {

    private static final String ERROR_MESSAGE_KEY = "message";

    private MessageSource messageSource;

    ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                              HttpServletRequest request) {
        Locale locale = Optional.ofNullable(request.getHeader(HttpHeaders.ACCEPT_LANGUAGE))
                                .map(Locale::forLanguageTag)
                                .orElse(Locale.US);
        String validationErrors =
                exception.getAllErrors()
                         .stream()
                         .map(DefaultMessageSourceResolvable::getDefaultMessage)
                         .filter(Objects::nonNull)
                         .map(messageCode -> messageSource.getMessage(messageCode, null, locale))
                         .collect(joining(". ", "", "."));
        return Map.of(
                ERROR_MESSAGE_KEY, validationErrors
        );
    }

}
