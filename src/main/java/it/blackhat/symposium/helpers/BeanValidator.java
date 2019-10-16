package it.blackhat.symposium.helpers;

import org.apache.bval.jsr.ApacheValidationProvider;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 *
 * Handle bean validation
 */
public class BeanValidator {

  private static Validator validator;
  private static ValidatorFactory factory = Validation
          .byProvider(ApacheValidationProvider.class)
          .configure().buildValidatorFactory();

  /**
   *
   * @param <T> the bean class to validate
   * @param bean the bean to validate
   * @return true if the validations goes ok
   */
  public static <T> boolean validateBean(T bean) {
    validator = factory.getValidator();
    Set<ConstraintViolation<T>> violations = validator.validate(bean);
    return violations.isEmpty();
  }

}
