package mao.gui.dong.spring.validation;

import org.springframework.validation.ValidationUtils;

/**
 * @author maoguidong
 */
public class ValidationApp{
    public static void main(String[] args) {
        Person person = new Person(180);
        PersonValidator personValidator = new PersonValidator();
        ValidationUtils.invokeValidator(personValidator, person, new MyErrors());
        System.out.println("over");

    }
}
