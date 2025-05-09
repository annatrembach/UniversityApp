package com.university.console.command;

import com.university.console.Command;
import com.university.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GlobalSearch implements Command {

    @Autowired
    public CommandService commandService;

    @Override
    public boolean execute(String input) {
        if (!input.startsWith("Global search by ")) { return false; }
        String template = input.replace("Global search by ", "").trim();
        try {
            System.out.println(commandService.globalSearch(template));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }
}
