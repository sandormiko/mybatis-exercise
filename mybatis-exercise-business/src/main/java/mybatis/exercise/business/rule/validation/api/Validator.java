package mybatis.exercise.business.rule.validation.api;


public interface Validator<E> {

	public void validate(E value);
}
