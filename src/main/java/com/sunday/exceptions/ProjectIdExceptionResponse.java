package com.sunday.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ProjectIdExceptionResponse {
    private String projectIdentifier;
}
