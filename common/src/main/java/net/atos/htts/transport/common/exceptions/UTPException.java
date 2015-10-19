package net.atos.htts.transport.common.exceptions;

public class UTPException extends Exception
{
    private static final long serialVersionUID = 1997753363232807009L;

    public UTPException()
    {
    }

    public UTPException(String message)
    {
        super(message);
    }

    public UTPException(Throwable cause)
    {
        super(cause);
    }

    public UTPException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UTPException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
