package mybatis.exercise.business.exception;

@SuppressWarnings("serial")
public class InvalidUserDataException extends RuntimeException {

	public InvalidUserDataException(String msg){
		super(msg);
	}
}
