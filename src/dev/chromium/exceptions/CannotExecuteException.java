package dev.chromium.exceptions;

import dev.chromium.employee.Employee;
import dev.chromium.enums.Action;

public class CannotExecuteException extends Exception {
    public CannotExecuteException(Employee employee, Action action) {
        super("The employee  " + employee.getName() + " cannot execute the action " + action + ".");
    }
}
