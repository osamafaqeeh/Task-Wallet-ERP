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

import static com.osama.task.command.Page.*;
import static com.osama.task.utils.MessageManager.DELETION_FAILED_MESSAGE_KEY;

/**
 * Command to delete customer.
 *
 * @author  Osama Alfaqeeh
 * @see CustomerService
 */
public class DeleteCustomerCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(DeleteCustomerCommand.class.getName());
    /**
     * Implementation of command to delete customer.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        CustomerService customerService = new CustomerService();

        String customerIdValue = request.getParameter(CUSTOMER_ID_PARAMETER);
        int customerId = Integer.parseInt(customerIdValue);
        System.out.println(customerId);
        try {
            boolean isOperationSuccessful =  customerService.deleteCustomerById(customerId);
            if (!isOperationSuccessful){
                return new Page(INFORMATION_FORM_PAGE_PATH,false,DELETION_FAILED_MESSAGE_KEY);
            }

            //update the customer list after add customer.
            List<Customer> list = customerService.findAllCustomer();
            HttpSession currentSession = request.getSession();
            currentSession.setAttribute(LIST_ATTRIBUTE,list);
            return new Page(SHOW_ALL_CUSTOMERS_INFORMATION_PAGE_PATH,true);
        }
        catch (ServiceException exception){
            LOGGER.log(Level.INFO,exception.getMessage(),exception);
            return  new Page(ERROR_PAGE_PATH,true);
        }
    }
}
