package builder.classic;

public class Request {
    private String reqId;
    private Customer requester;
    private Agent agent;
    private String reqContent;
    private String respContent;
    private boolean isAnswered;
    private boolean isSaleLead;
    private boolean needCallBack;

    private Request(RequestBuilder requestBuilder) {
        this.reqId = requestBuilder.reqId;
        this.requester = requestBuilder.requester;
        this.agent = requestBuilder.agent;
        this.reqContent = requestBuilder.reqContent;
        this.respContent = requestBuilder.respContent;
        this.isAnswered = requestBuilder.isAnswered;
        this.isSaleLead = requestBuilder.isSaleLead;
        this.needCallBack = requestBuilder.needCallBack;
    }

    public static class RequestBuilder {
        private String reqId;
        private Customer requester;
        private Agent agent;
        private String reqContent;
        private String respContent;
        private boolean isAnswered;
        private boolean isSaleLead;
        private boolean needCallBack;

        public RequestBuilder(String reqId, Agent agent) {
            this.reqId = reqId;
            this.agent = agent;
        }

        public RequestBuilder setRequester(Customer requester) {
            this.requester = requester;
            return this;
        }

        public RequestBuilder setReqContent(String reqContent) {
            this.reqContent = reqContent;
            return this;
        }

        public RequestBuilder setRespContent(String respContent) {
            this.respContent = respContent;
            return this;
        }

        public RequestBuilder setAnswered(boolean answered) {
            isAnswered = answered;
            return this;
        }

        public RequestBuilder setSaleLead(boolean saleLead) {
            isSaleLead = saleLead;
            return this;
        }

        public RequestBuilder setNeedCallBack(boolean needCallBack) {
            this.needCallBack = needCallBack;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}