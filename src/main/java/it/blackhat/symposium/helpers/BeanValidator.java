package it.blackhat.symposium.helpers;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
public class BeanValidator {

    private static Validator validator;

    /**
     *
     * @param <T> the bean class to validate
     * @param bean the bean to validate
     * @return true if the validations goes ok
     * @author Angelo Maffettone
     */
    public static <T> boolean validateBean(T bean){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(bean);
        return violations.isEmpty();
    }

}