package utils;

public class Payload {

    public static String generateTokenPayload(){
        String generateToken = "{\n" +
                "  \"email\": \"tests@batch17.com\",\n" +
                "  \"password\": \"Tests@123\"\n" +
                "}";
        return generateToken;
    }
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"mili\",\n" +
                "  \"emp_lastname\": \"guru\",\n" +
                "  \"emp_middle_name\": \"ms\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2002-11-25\",\n" +
                "  \"emp_status\": \"confirmed\",\n" +
                "  \"emp_job_title\": \"qa\"\n" +
                "}";
        return createEmployeePayload;
    }

}
