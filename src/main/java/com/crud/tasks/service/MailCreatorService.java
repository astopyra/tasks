package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    DbService dbService;

    public String buildTaskDailyUpdateEmail(){

        List<Task> tasks = dbService.getAllTasks();
        int tasksQty = tasks.size();

        Context context = new Context();
        context.setVariable("tasks_url", "https://astopyra.github.io");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("button", "Visit website for more details");
        context.setVariable("show_button", true);
        context.setVariable("is_friend", true);
        context.setVariable("tasks_quantity", tasksQty);

        return templateEngine.process("mail/task-daily-update-mail", context);
    }

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://astopyra.github.io");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("preview", "New task created info");
        context.setVariable("show_button", true);
        context.setVariable("is_friend", true);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
