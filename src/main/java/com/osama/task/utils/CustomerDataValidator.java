package com.osama.task.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.osama.task.entities.customer.ActiveCustomer.ACTIVE;
import static com.osama.task.entities.customer.ActiveCustomer.INACTIVE;


/**
 * Util class for customer data validation.
 *
 * @author Osama Alfaqeeh
 */
public class CustomerDataValidator {

    private static final String NAME_PATTERN = "^[a-zA-z ]*$";
    private static final String ADDRESS_PATTERN = "^[a-zA-z0-9 ]*$";
    private static final String COUNTRY_PATTERN = "^[a-zA-z ]*$";
    private static final String CITY_PATTERN = "^[a-zA-z, ]*$";
    private static final String TAX_NUMBER_PATTERN = "[0-9]+";

    /**
     * Check customer data for errors.
     *
     * @param name The customer's data.
     * @param address The customer's address.
     * @param country The customer's country.
     * @param city The customer's city.
     * @param taxNumber The customer's taxNumber.
     * @param activeCustomer The customer's activeCustomer.
     * @return result of validation.
     */
    public boolean checkData(String name,String address, String country, String city, String taxNumber, String activeCustomer){

        if (name == null || name.isEmpty()){
            return false;
        }
        if (address == null || address.isEmpty()){
            return false;
        }
        if (country == null || country.isEmpty()){
            return false;
        }
        if (city == null || city.isEmpty()){
            return false;
        }
        if (activeCustomer == null || activeCustomer.isEmpty()){
            return false;
        }

        return matchPattern(name,NAME_PATTERN)&&matchPattern(address,ADDRESS_PATTERN)&&matchPattern(country,COUNTRY_PATTERN)&&matchPattern(city,CITY_PATTERN)&&matchPattern(taxNumber,TAX_NUMBER_PATTERN)&&checkActiveCustomer(activeCustomer);
    }

    private boolean checkActiveCustomer(String activeCustomer){
        if (String.valueOf(ACTIVE).equals(activeCustomer)){
            return true;
        }
        if (String.valueOf(INACTIVE).equals(activeCustomer)){
            return true;
        }
        return false;
    }

    private boolean matchPattern(String data, String currentPattern){
        Pattern pattern = Pattern.compile(currentPattern);
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }
}
