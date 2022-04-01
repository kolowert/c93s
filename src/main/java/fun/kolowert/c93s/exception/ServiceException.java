package fun.kolowert.c93s.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1648827676L;

	private ErrorType errorType;

	protected ServiceException(String message) {
		super(message);
	}

	public ErrorType getErrorType() {
		return ErrorType.FATAL_ERROR_TYPE;
	}
}
