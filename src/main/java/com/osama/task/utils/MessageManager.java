package com.osama.task.utils;

import java.util.ResourceBundle;

/**
 * Util class for manage messages in JSP page's.
 *
 * @author Osama Alfaqeeh
 * @see ResourceBundle
 */
public class MessageManager {

    public static final String NONE_MESSAGE_KEY = "NONE";
    public static final String COMMAND_ERROR_MESSAGE_KEY = "message.command_error";
    public static final String INVALID_INPUT_DATA_MESSAGE_KEY = "message.invalid_input_data";
    public static final String REGISTRATION_FAILED_MESSAGE_KEY = "message.registration_failed";
    public static final String DELETION_FAILED_MESSAGE_KEY = "message.deletion_failed";




    private static final String RESOURCE_FILE_NAME = "messages";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

    public MessageManager() {
    }

    /**
     * Gets property from resource file.
     *
     * @param messageKey the key of property.
     * @return the property.
     */
    public static String getProperty(String messageKey){
        return RESOURCE_BUNDLE.getString(messageKey);
    }
}
