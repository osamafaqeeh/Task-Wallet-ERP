package com.osama.task.entities.customer;

import com.osama.task.entities.Entity;

import java.io.InputStream;

/**
 * This class describes customer of application.
 *
 * @author Osama Alfaqeeh
 * @see ActiveCustomer
 * @see Entity
 */
public class Customer extends Entity {
    private String name;
    private String country;
    private String city;
    private String address;
    private String taxNumber;
    private ActiveCustomer activeCustomer;

    /**
     * Instantiates a new Customer.
     */
    public Customer() {
    }

    /**
     * Gets customer's name.
     *
     * @return the customer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets customer's name.
     *
     * @param name the customer's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets customer's country.
     *
     * @return the customer's country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets customer's country.
     *
     * @param country the customer's country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets customer's city.
     *
     * @return the customer's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets customer's city.
     *
     * @param city the customer's city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets customer's address.
     *
     * @return the customer's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets customer's address.
     *
     * @param address the customer's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets customer's tax number.
     *
     * @return the customer's tax number.
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * Sets customer's tax number.
     *
     * @param taxNumber the customer's tax number.
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * Gets customer's active customer.
     *
     * @return the customer's active customer.
     */
    public ActiveCustomer getActiveCustomer() {
        return activeCustomer;
    }

    /**
     * Sets customer's active customer.
     *
     * @param activeCustomer the customer's active customer.
     */
    public void setActiveCustomer(ActiveCustomer activeCustomer) {
        this.activeCustomer = activeCustomer;
    }


    /**
     * This method equals two objects.
     *
     * @param object the object.
     * @return true if objects are equal and false otherwise.
     */

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (!super.equals(object)) {
            return false;
        }
        Customer customer = (Customer)object;

        if (name != null ? !name.equals(customer.getName()) : customer.name != null){
            return false;
        }
        if (country != null ? !country.equals(customer.country) : customer.country != null){
            return false;
        }
        if (city != null ? !city.equals(customer.city) : customer.city != null){
            return false;
        }
        if (address != null ? !address.equals(customer.address) : customer.address != null){
            return false;
        }
        if (taxNumber != null ? !taxNumber.equals(customer.taxNumber) : customer.taxNumber != null){
            return false;
        }
       if (activeCustomer != customer.getActiveCustomer()){
           return false;
       }

       return true;
    }

    /**
     * This method calculate object's hashcode.
     *
     * @return hashcode of object.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (taxNumber != null ? taxNumber.hashCode() : 0);
        result = 31 * result + (activeCustomer != null ? activeCustomer.hashCode() : 0);

        return result;
    }

    /**
     * This method builds string information about object.
     *
     * @return string information about object.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", activeCustomer=" + activeCustomer +
                '}';
    }
}
