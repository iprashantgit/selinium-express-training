package dynamicproxy;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        ITEmployee itEmployee = new ITEmployee();
        itEmployee.setId(101);
        itEmployee.setName("Aman");
        itEmployee.setSalary(10000);

        EmployeeSalaryInvocationHandler salaryInvocationHandler = new EmployeeSalaryInvocationHandler(itEmployee);

        IEmployee proxyInstance = (IEmployee) Proxy.newProxyInstance(ITEmployee.class.getClassLoader(), new Class[]{IEmployee.class}, salaryInvocationHandler);
        proxyInstance.giveHike(-5000);
        System.out.println(proxyInstance.getSalary());
    }

}