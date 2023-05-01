package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeSalaryInvocationHandler implements InvocationHandler {

    private IEmployee employeeTarget;

    public EmployeeSalaryInvocationHandler(IEmployee employeeTarget) {
        this.employeeTarget = employeeTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        // preprocessing
        // making call to service layer
        System.out.println(method.getName() + " Starts");
        if("giveHike".equals(method.getName())){
            double salaryIncrement = (double) args[0];
            if(salaryIncrement > 0){
                result = method.invoke(employeeTarget, args);
            }else {
                System.out.println("Given amount is not valid.");
            }
        }else {
            result = method.invoke(employeeTarget, args);
        }
        // postprocessing

        return result;
    }
}