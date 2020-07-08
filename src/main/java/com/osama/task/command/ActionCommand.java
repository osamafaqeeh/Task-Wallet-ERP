package com.osama.task.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The interface Action commands.
 *
 * @author Osama Alfaqeeh
 */
public interface ActionCommand {
    /**
     * parameters.
     */
    String COMMAND_PARAMETER = "command";
    String CUSTOMER_ID_PARAMETER = "customer_id";
    String NAME_PARAMETER = "name";
    String COUNTRY_PARAMETER = "country";
    String CITY_PARAMETER = "city";
    String ADDRESS_PARAMETER = "address";
    String TAX_NUMBER_PARAMETER = "tax_number";
    String ACTIVE_CUSTOMER_PARAMETER =  "active_customer";
    String SHOW_ALL_CUSTOMERS_INFORMATION_PARAMETER = "show_all_customers_information";


    /**
     * Attributes.
     */
    String MESSAGE_ATTRIBUTE = "message";
    String LIST_ATTRIBUTE = "list";

     Page execute(HttpServletRequest request);
}
