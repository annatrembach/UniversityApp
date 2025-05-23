package com.university.console.command;

import com.university.console.Command;
import com.university.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadOfDepartment implements Command {

    @Autowired
    private CommandService commandService;

    @Override
    public boolean execute(String input) {
        if (!input.startsWith("Who is head of department")) { return false; }
        String departmentName = input.replace("Who is head of department", "").trim();
        System.out.println(commandService.getHeadOfDepartment(departmentName));
        return true;
    }
}
