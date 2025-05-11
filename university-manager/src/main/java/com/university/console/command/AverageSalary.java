package com.university.console.command;

import com.university.console.Command;
import com.university.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AverageSalary implements Command {

    @Autowired
    private CommandService commandService;

    @Override
    public boolean execute(String input) {
        if (!input.startsWith("Show the average salary for the department")) { return false; }
        String departmentName = input.replace("Show the average salary for the department", "").trim();
        System.out.println(commandService.getAverageSalary(departmentName));
        return true;
    }
}
