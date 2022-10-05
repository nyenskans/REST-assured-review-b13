package basicRESTAssured;

import org.json.JSONObject;

public class JsonObject {
    public static String createEmployeePayload1(){ // not a preferred way
        String payload = "{\n" +
                "    \"emp_firstname\": \"azeddine\",\n" +
                "    \"emp_lastname\": \"sterling\",\n" +
                "    \"emp_middle_name\": \"MS\",\n" +
                "    \"emp_gender\": \"M\",\n" +
                "    \"emp_birthday\": \"2022-10-03\",\n" +
                "    \"emp_status\": \"hired\",\n" +
                "    \"emp_job_title\": \"QA\"\n" +
                "}";

        return payload;
    }
    public static String createEmployeePayload(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "mark");
        obj.put("emp_lastname", "johnson");
        obj.put("emp_middlename", "john");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "2022-01-01");
        obj.put("emp_status", "hired");
        obj.put("emp_jobtitle", "QA");

        return obj.toString();
    }
}
