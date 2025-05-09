package com.university.console.command;

import com.university.console.Command;
import com.university.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentStatistics implements Command {

    @Autowired
    public CommandService commandService;

    @Override
    public boolean execute(String input) {
        if (!input.startsWith("Show") || !input.endsWith("statistics")) {
            return false;
        }

        String departmentName = input.replace("Show", "")
                .replace("statistics", "")
                .trim();

        try {
            System.out.println(commandService.getStatistics(departmentName));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

        return true;
    }

}
