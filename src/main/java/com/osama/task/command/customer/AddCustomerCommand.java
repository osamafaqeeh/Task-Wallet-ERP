package com.osama.task.command.customer;

import com.osama.task.command.ActionCommand;
import com.osama.task.command.Page;
import com.osama.task.entities.customer.Customer;
import com.osama.task.exceptions.ServiceException;
import com.osama.task.service.CustomerService;
import com.osama.task.utils.CustomerDataValidator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.osama.task.command.Page.ERROR_PAGE_PATH;
import static com.osama.task.command.Page.SHOW_ALL_CUSTOMERS_INFORMATION_PAGE_PATH;
import static com.osama.task.command.Page.INFORMATION_FORM_PAGE_PATH;
import static com.osama.task.utils.MessageManager.INVALID_INPUT_DATA_MESSAGE_KEY;



/**
 * Command to add customer.
 *
 * @author  Osama Alfaqeeh
 * @see CustomerService
 */
public class AddCustomerCommand implements ActionCommand {

    private static final Logger LOGGER = Logger.getLogger(AddCustomerCommand.class.getName());

    /**
     * Implementation of command to add customer.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public Page execute(HttpServletRequest request) {
        CustomerService customerService = new CustomerService();
        try {
         String name = request.getParameter(NAME_PARAMETER);
         String country = request.getParameter(COUNTRY_PARAMETER);
         String city = request.getParameter(CITY_PARAMETER);
         String address = request.getParameter(ADDRESS_PARAMETER);
         String taxNumber = request.getParameter(TAX_NUMBER_PARAMETER);
         String activeCustomerValue = request.getParameter(ACTIVE_CUSTOMER_PARAMETER);


            CustomerDataValidator customerDataValidator = new CustomerDataValidator();
            boolean isCustomerDataValid = customerDataValidator.checkData(name,address,country,city,taxNumber,activeCustomerValue);
            if (!isCustomerDataValid){
                return new Page(INFORMATION_FORM_PAGE_PATH,false,INVALID_INPUT_DATA_MESSAGE_KEY);
            }

            boolean isOperationSuccessful =  customerService.registerCustomer(name, country, city, address, taxNumber, activeCustomerValue);
            if (!isOperationSuccessful){
                return new Page(INFORMATION_FORM_PAGE_PATH,false,INVALID_INPUT_DATA_MESSAGE_KEY);
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
