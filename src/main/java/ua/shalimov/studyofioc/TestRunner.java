package ua.shalimov.studyofioc;

import ua.shalimov.ioc.context.ApplicationContext;
import ua.shalimov.ioc.context.ClassPathApplicationContext;
import ua.shalimov.studyofioc.printer.Printer;

public class TestRunner {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathApplicationContext("context.xml");
        Printer printer=context.getBean(Printer.class);
        printer.print();
    }
}
