package com.application.springboot_step_by_step.error;

public class ValidatorErrorDetails {

    private String field;
    private String fieldMessage;

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;
        private String field;
        private String fieldMessage;


        private Builder() {
        }

        public static ResourceNotFoundDetails.Builder newBuilder() {
            return new ResourceNotFoundDetails.Builder();
        }

        public ResourceNotFoundDetails.Builder title(String title) {
            this.title = title;
            return this;
        }

        public ResourceNotFoundDetails.Builder status(int status) {
            this.status = status;
            return this;
        }

        public ResourceNotFoundDetails.Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public ResourceNotFoundDetails.Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ResourceNotFoundDetails.Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetails build() {

            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();

            resourceNotFoundDetails.setTitle(title);
            resourceNotFoundDetails.setDeveloperMessage(developerMessage);
            resourceNotFoundDetails.setDetail(detail);
            resourceNotFoundDetails.setStatus(status);
            resourceNotFoundDetails.setTimestamp(timestamp);

            return resourceNotFoundDetails;
        }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }
}
