package  mybatis.exercise.business.exception;

@SuppressWarnings("serial")
public class InvalidCouponCodeException extends RuntimeException{

	public InvalidCouponCodeException(String msg){
		super(msg);
	}
}
