package com.osama.task.dao;

import com.osama.task.entities.customer.ActiveCustomer;
import com.osama.task.entities.customer.Customer;
import com.osama.task.exceptions.DAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that provide access to the database and deal with User entity.
 *
 * @author Osama ALfaqeeh
 * @see AbstractDAOImpl
 * @see Customer
 */
public class CustomerDAOImpl extends AbstractDAOImpl<Customer> {

    /**
     * Common queries.
     */
    private static final String SELECT_ALL_QUERY = "SELECT * FROM wallet_erp_task.customer ";
    private static final String SELECT_BY_ID_QUERY = "";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM wallet_erp_task.customer WHERE id = ?";
    private static final String INSERT_ENTITY_QUERY = "INSERT INTO wallet_erp_task.customer (name, country, city, address, tax_number, active) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_ENTITY_QUERY = "UPDATE wallet_erp_task.customer SET name = ?, country = ?, city = ?, address = ?, tax_number = ?, active = ? WHERE id = ?";

    private static final String NAME_COLUMN_LABEL = "name";
    private static final String COUNTRY_COLUMN_LABEL = "country";
    private static final String CITY_COLUMN_LABEL = "city";
    private static final String ADDRESS_COLUMN_LABEL = "address";
    private static final String TAX_NUMBER_COLUMN_LABEL = "tax_number";
    private static final String ACTIVE_CUSTOMER_COLUMN_LABEL = "active";


    /**
     * Instantiates a new AbstractDAOImpl.
     *
     * @param connection the connection to database.
     */
    public CustomerDAOImpl(Connection connection) {
        super(connection);
    }

    /**
     * This method gets customer's parameters.
     *
     * @param entity the entity.
     * @return List object with parameters.
     */
    @Override
    protected List<String> getEntityParameters(Customer entity) {
        List<String> parameters = new ArrayList<>();

        String name = entity.getName();
        parameters.add(name);

        String country = entity.getCountry();
        parameters.add(country);

        String city = entity.getCity();
        parameters.add(city);

        String address = entity.getAddress();
        parameters.add(address);

        String taxNumber = entity.getTaxNumber();
        parameters.add(taxNumber);

        ActiveCustomer activeCustomer = entity.getActiveCustomer();
        String activeCustomerValue = String.valueOf(activeCustomer);
        parameters.add(activeCustomerValue);

        return parameters;

    }

    /**
     * This method builds customer from ResultSet object.
     *
     * @param resultSet the result set of statement.
     * @return the customer.
     * @throws DAOException object if execution of query is failed.
     */
    @Override
    protected Customer buildEntity(ResultSet resultSet) throws DAOException {
       try {
           Customer customer =new Customer();

           int id = resultSet.getInt(ID_COLUMN_LABEL);
           customer.setId(id);

           String name = resultSet.getString(NAME_COLUMN_LABEL);
           customer.setName(name);

           String country = resultSet.getString(COUNTRY_COLUMN_LABEL);
           customer.setCountry(country);

           String city = resultSet.getString(CITY_COLUMN_LABEL);
           customer.setCity(city);

           String address = resultSet.getString(ADDRESS_COLUMN_LABEL);
           customer.setAddress(address);

           String taxNumber = resultSet.getString(TAX_NUMBER_COLUMN_LABEL);
           customer.setTaxNumber(taxNumber);

           String activeCustomerValue = resultSet.getString(ACTIVE_CUSTOMER_COLUMN_LABEL);
           ActiveCustomer activeCustomer = ActiveCustomer.valueOf(activeCustomerValue);
           customer.setActiveCustomer(activeCustomer);

           return customer;
       }
       catch (SQLException exception){
           throw new DAOException(exception);
       }

    }

    /**
     * This method initialize queries for common operations.
     *
     * @return Map object with queries.
     */
    @Override
    protected Map<String, String> initializeCommonQueries() {
        Map<String, String> commonQueries = new HashMap<>();

        commonQueries.put(SELECT_ALL_QUERY_KEY, SELECT_ALL_QUERY);
        commonQueries.put(SELECT_BY_ID_QUERY_KEY, SELECT_BY_ID_QUERY);
        commonQueries.put(DELETE_BY_ID_QUERY_KEY, DELETE_BY_ID_QUERY);
        commonQueries.put(INSERT_ENTITY_QUERY_KEY, INSERT_ENTITY_QUERY);
        commonQueries.put(UPDATE_ENTITY_QUERY_KEY, UPDATE_ENTITY_QUERY);

        return commonQueries;
    }
}
