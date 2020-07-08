package com.osama.task.command.customer;

import com.osama.task.command.ActionCommand;
import com.osama.task.command.Page;
import com.osama.task.entities.customer.Customer;
import com.osama.task.exceptions.ServiceException;
import com.osama.task.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.osama.task.command.Page.SHOW_ALL_CUSTOMERS_INFORMATION_PAGE_PATH;
import static com.osama.task.command.Page.ERROR_PAGE_PATH;

/**
 * Command to show all customer information.
 *
 * @author  Osama Alfaqeeh
 * @see CustomerService
 */
public class ShowAllCustomersInformationCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(ShowAllCustomersInformationCommand.class.getName());

    /**
     * Implementation of command to show all customer information.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        try{
            CustomerService customerService = new CustomerService();
            List<Customer> list = customerService.findAllCustomer();

            HttpSession currentSession = request.getSession();
            currentSession.setAttribute(LIST_ATTRIBUTE,list);
            return new Page(SHOW_ALL_CUSTOMERS_INFORMATION_PAGE_PATH,true);
        }
        catch (ServiceException exception){
            LOGGER.log(Level.INFO,exception.getMessage(),exception);
            return new Page(ERROR_PAGE_PATH,true);
        }
    }
}
