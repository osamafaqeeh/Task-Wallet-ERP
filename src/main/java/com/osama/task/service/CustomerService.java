package com.osama.task.service;
import com.osama.task.entities.customer.ActiveCustomer;
import com.osama.task.entities.customer.Customer;
import com.osama.task.dao.CustomerDAOImpl;
import com.osama.task.connectionManger.ConnectionManger;
import com.osama.task.exceptions.DAOException;
import com.osama.task.exceptions.ServiceException;

import java.util.List;

/**
 * Service class for Customer entity.
 *
 * @author Osama Alfaqeeh
 * @see Customer
 * @see CustomerDAOImpl
 * @see ConnectionManger
 */
public class CustomerService {

    /**
     * This method finds all customers in database.
     *
     * @return List of customers.
     * @throws ServiceException object if execution of method is failed.
     */
    public List<Customer> findAllCustomer() throws ServiceException {
        try(ConnectionManger connectionManger = new ConnectionManger()) {
            CustomerDAOImpl customerDAO = new CustomerDAOImpl(connectionManger.getConnection());
            return customerDAO.selectAll();
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during find all customer operation.", exception);
        }
    }

    /**
     * This method finds customers by Id in database.
     *
     * @param customerId The customer's id.
     * @return The Customer.
     * @throws ServiceException object if execution of method is failed.
     */
    public Customer findCustomerById(int customerId) throws ServiceException {
        try(ConnectionManger connectionManger = new ConnectionManger()) {
            CustomerDAOImpl customerDAO = new CustomerDAOImpl(connectionManger.getConnection());
            return customerDAO.selectEntityById(customerId);
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during find customer by Id operation.", exception);
        }
    }

    /**
     * This method delete customers by Id in database.
     *
     * @param customerId The customer's id.
     * @return true if operation was made successful and false otherwise.
     * @throws ServiceException object if execution of method is failed.
     */
    public boolean deleteCustomerById(int customerId) throws ServiceException {
        try(ConnectionManger connectionManger = new ConnectionManger()) {
            CustomerDAOImpl customerDAO = new CustomerDAOImpl(connectionManger.getConnection());
            return customerDAO.deleteById(customerId);
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during delete customer by Id operation.", exception);
        }
    }

    /**
     *The method registers customer into data base.
     *
     * @param name                The customer's name.
     * @param country             The customer's country.
     * @param city                The customer's city.
     * @param address             The customer's address.
     * @param taxNumber           The customer's tax number.
     * @param activeCustomerValue The customer's active.
     * @return true if operation was made successful and false otherwise.
     * @throws ServiceException object if execution of method is failed.
     */
    public boolean registerCustomer(String name, String country, String city, String address, String taxNumber, String activeCustomerValue) throws ServiceException {
        try(ConnectionManger connectionManger = new ConnectionManger()) {
            CustomerDAOImpl customerDAO = new CustomerDAOImpl(connectionManger.getConnection());
            Customer customer = new Customer();

            customer.setName(name);
            customer.setCountry(country);
            customer.setCity(city);
            customer.setAddress(address);
            customer.setTaxNumber(taxNumber);
            ActiveCustomer activeCustomer = ActiveCustomer.valueOf(activeCustomerValue);
            customer.setActiveCustomer(activeCustomer);

            return customerDAO.insert(customer);
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during register customer operation.", exception);
        }
    }

    /**
     *The method update customer information in data base.
     *
     * @param customerIdValue     The customer's Id value.
     * @param name                The customer's name.
     * @param country             The customer's country.
     * @param city                The customer's city.
     * @param address             The customer's address.
     * @param taxNumber           The customer's tax number.
     * @param activeCustomerValue The customer's active.
     * @return true if operation was made successful and false otherwise.
     * @throws ServiceException ServiceException object if execution of method is failed.
     */
    public boolean updateCustomer(String customerIdValue, String name, String country, String city, String address, String taxNumber, String activeCustomerValue) throws ServiceException {
        try(ConnectionManger connectionManger = new ConnectionManger()) {
            CustomerDAOImpl customerDAO = new CustomerDAOImpl(connectionManger.getConnection());
            Customer customer = new Customer();

            int customerId = Integer.parseInt(customerIdValue);
            customer.setId(customerId);
            customer.setName(name);
            customer.setCountry(country);
            customer.setCity(city);
            customer.setAddress(address);
            customer.setTaxNumber(taxNumber);
            ActiveCustomer activeCustomer = ActiveCustomer.valueOf(activeCustomerValue);
            customer.setActiveCustomer(activeCustomer);

            return customerDAO.update(customer);
        }
        catch (DAOException exception){
            throw new ServiceException("Exception during update customer information operation.", exception);
        }
    }
}
