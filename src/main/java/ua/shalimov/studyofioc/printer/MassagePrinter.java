package ua.shalimov.studyofioc.printer;

import ua.shalimov.studyofioc.beanpostprocessor.InjectValue;
import ua.shalimov.studyofioc.beanpostprocessor.Logger;

@Logger
public class MassagePrinter implements Printer {
    private String massage;

    @InjectValue(value= "5")
    private int count;

    @Override
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(massage);
        }
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
