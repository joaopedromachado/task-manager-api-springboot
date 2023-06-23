package br.com.task.resource.exception;

public class StandardError {
    private int statusCode;
    private long timestamp;
    private String message;
    private String path;

    public StandardError(Builder builder) {
        this.statusCode = builder.statusCode;
        this.timestamp = builder.timestamp;
        this.message = builder.message;
        this.path = builder.path;
    }

    public static class Builder {
        private int statusCode;
        private long timestamp;
        private String message;
        private String path;

        public Builder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public StandardError build() {
            return new StandardError(this);
        }
    }

}
