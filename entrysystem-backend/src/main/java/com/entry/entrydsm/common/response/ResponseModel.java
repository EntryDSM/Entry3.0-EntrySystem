package com.entry.entrydsm.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel<T> {
    private T data;
    private String message;
    private List<Error> errors;

    private ResponseModel(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public ResponseModel(List<Error> errors, String message) {
        this.errors = errors;
        this.message = message;
    }

    public static <T> ResponseModel<T> ofSuccess(T data, String message) {
        return new ResponseModel<>(data, message);
    }

    public static <T> ResponseModel<T> ofFailure(List<Error> errors, String message) {
        return new ResponseModel<>(errors, message);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Error {
        private String field;
        private String message;

        public Error(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public Error(String message) {
            this.message = message;
        }
    }
}
