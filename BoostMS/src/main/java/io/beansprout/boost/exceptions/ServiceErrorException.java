package io.beansprout.boost.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * Custom RuntimeException
 * Inherited from an open code repo and modified for use in this project
 * @author https://github.com/NorthConcepts/java-exception-handling, Kollier Martin
 * @date 1/6/2021
 */

@Getter
@Setter
public class ServiceErrorException extends RuntimeException {
    private static Logger logger = Logger.getLogger(ServiceErrorException.class.toString());
    private ErrorCode errorCode;
    private final Map<String, Object> properties = new TreeMap<>();

    public static ServiceErrorException wrap(Throwable exception, ErrorCode errorCode) {
        if (exception instanceof ServiceErrorException) {
            ServiceErrorException se = (ServiceErrorException) exception;
            if (errorCode != null && errorCode != se.getErrorCode()) {
                return new ServiceErrorException(exception.getMessage(), exception, errorCode);
            }
            return se;
        } else {
            return new ServiceErrorException(exception.getMessage(), exception, errorCode);
        }
    }

    public static ServiceErrorException wrap(Throwable exception) {
        return wrap(exception, null);
    }

    public ServiceErrorException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceErrorException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceErrorException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ServiceErrorException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    @Override
    public void printStackTrace(PrintStream s) {
        synchronized (s) {
            printStackTrace(new PrintWriter(s));
        }
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        synchronized (s) {
            s.println(this);
            s.println("\t-------------------------------");
            if (errorCode != null) {
                s.println("\t" + errorCode + ":" + errorCode.getClass().getName());
            }
            for (String key : properties.keySet()) {
                s.println("\t" + key + "=[" + properties.get(key) + "]");
            }
            s.println("\t-------------------------------");

            StackTraceElement[] trace = getStackTrace();
            for (StackTraceElement stackTraceElement : trace)
                s.println("\tat " + stackTraceElement);

            Throwable ourCause = getCause();
            if (ourCause != null) {
                ourCause.printStackTrace(s);
            }
            s.flush();
        }
    }
}