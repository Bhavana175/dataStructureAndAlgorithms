package com.workspace.learning.interviews.paypalpractice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private HttpStatus status;
    private String message;
}
