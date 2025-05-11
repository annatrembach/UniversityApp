package com.university.console.command;

import com.university.console.Command;
import com.university.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentStatistics implements Command {

    @Autowired
    private CommandService commandService;

    @Override
    public boolean execute(String input) {
        if (!input.startsWith("Show") || !input.endsWith("statistics")) {
            return false;
        }
        String departmentName = input.replace("Show", "")
                .replace("statistics", "")
                .trim();
        System.out.println(commandService.getStatistics(departmentName));
        return true;
    }

}
