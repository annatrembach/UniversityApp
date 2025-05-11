package com.university.console.command;

import com.university.console.Command;
import com.university.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GlobalSearch implements Command {

    @Autowired
    private CommandService commandService;

    @Override
    public boolean execute(String input) {
        if (!input.startsWith("Global search by ")) { return false; }
        String template = input.replace("Global search by ", "").trim();
        System.out.println(commandService.globalSearch(template));
        return true;
    }
}
