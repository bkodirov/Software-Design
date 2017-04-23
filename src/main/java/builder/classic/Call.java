package builder.classic;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Call {
    private Request.RequestBuilder builder;

    public void callPop(Agent agent) {
        String requestId = "" + (new Date()).getTime();
        builder = new Request.RequestBuilder(requestId, agent);

        String callerNumber = getCallerNumber();
        Customer customer = getOrCreateCustomer(callerNumber);
        builder.setRequester(customer);

        String requestContent = getRequestContent();
        builder.setReqContent(requestContent);

        String responseContent = getResponseContent();
        if (requestContent == null) {
            responseContent = getResponseFromSuperVisorContent();
            if (responseContent == null) {
                builder.setSaleLead(true);
            }
        }
        builder.setRespContent(responseContent);
        builder.setAnswered(responseContent != null);
        builder.setNeedCallBack(needCallBack());
        saveData(builder.build());
    }

    private void saveData(Request build) {
        //Here you sould store data into DB.
    }

    private boolean needCallBack() {
        Random r = new Random(2);
        if (r.nextInt() > 1) {
            return true;
        }
        return false;
    }


    /**
     * This method simulates retriving or creating new customer
     * Method returns CustomerFlyweight if there is any customer with this phone number in DataBase. Otherwise it will create
     * new record in DB and returns newly created data
     *
     * @param callerNumber
     * @return
     */
    private Customer getOrCreateCustomer(String callerNumber) {
        return new Customer();
    }

    public String getCallerNumber() {
        return UUID.randomUUID().toString();
    }

    public String getRequestContent() {
        return UUID.randomUUID().toString();
    }

    public String getResponseContent() {
        Random r = new Random(2);
        if (r.nextInt() > 1) {
            return UUID.randomUUID().toString();
        }
        return null;
    }

    public String getResponseFromSuperVisorContent() {
        Random r = new Random(2);
        if (r.nextInt() > 1) {
            return UUID.randomUUID().toString();
        }
        return null;
    }
}