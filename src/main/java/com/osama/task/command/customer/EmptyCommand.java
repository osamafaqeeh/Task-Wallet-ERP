package com.osama.task.command.customer;

import com.osama.task.command.ActionCommand;
import com.osama.task.command.Page;

import javax.servlet.http.HttpServletRequest;

import static com.osama.task.command.Page.SHOW_ALL_CUSTOMERS_INFORMATION_PAGE_PATH;

public class EmptyCommand implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request) {
        return new Page(SHOW_ALL_CUSTOMERS_INFORMATION_PAGE_PATH,true);
    }
}
