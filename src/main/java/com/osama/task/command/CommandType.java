package com.osama.task.command;

import com.osama.task.command.customer.AddCustomerCommand;
import com.osama.task.command.customer.DeleteCustomerCommand;
import com.osama.task.command.customer.ShowAllCustomersInformationCommand;
import com.osama.task.command.customer.UpdateCustomerCommand;

/**
 * Types of commands.
 *
 * @author Osama Alfaqeeh
 * @see ActionCommand
 */
public enum  CommandType {
    SHOW_ALL_CUSTOMERS_INFORMATION{
        {
            this.command = new ShowAllCustomersInformationCommand();
        }
    },
    ADD_CUSTOMER{
        {
            this.command = new AddCustomerCommand();
        }
    },
    UPDATE_CUSTOMER{
        {
            this.command = new UpdateCustomerCommand();
        }
    },
    DELETE_CUSTOMER{
        {
            this.command = new DeleteCustomerCommand();
        }
    };

    /**
     * Current command.
     */
    ActionCommand command;

    /**
     * Gets current commands.
     *
     * @return the current commands.
     */
    public ActionCommand getCurrentCommand(){
        return this.command;
    }
}
