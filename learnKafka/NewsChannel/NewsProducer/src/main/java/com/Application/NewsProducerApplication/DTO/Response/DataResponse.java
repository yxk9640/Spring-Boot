package com.Application.NewsProducerApplication.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author - yogesh
 */
@Data
@AllArgsConstructor
public class DataResponse<T> {
    private String message;
    private Boolean status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
