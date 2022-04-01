package fun.kolowert.c93s.exception;

public class UnitNotFoundException extends ServiceException {
	
	private static final long serialVersionUID = 1648827842L;

	private static final String DEFAULT_MESSAGE = "Unit is not found!";

	public UnitNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.VALIDATION_ERROR_TYPE;
	}
}
