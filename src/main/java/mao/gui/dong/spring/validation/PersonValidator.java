package mao.gui.dong.spring.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author maoguidong
 */
public class PersonValidator implements Validator {
    private static final int AGE_MAX=100;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
         Person person= (Person) target;
         if(person.getAge()>AGE_MAX){
            errors.rejectValue("age", "too old");
         }
    }
}
