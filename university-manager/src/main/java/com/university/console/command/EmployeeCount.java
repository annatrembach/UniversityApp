package com.university.console.command;

import com.university.console.Command;
import com.university.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCount implements Command {

    @Autowired
    private CommandService commandService;

    @Override
    public boolean execute(String input) {
        if (!input.startsWith("Show count of employee for")) { return false; }
        String departmentName = input.replace("Show count of employee for", "").trim();
        System.out.println(commandService.getEmployeeCount(departmentName));
        return true;
    }
}
