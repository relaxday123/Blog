package com.blog.post.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserException extends RuntimeException {
    private CodeResponse codeResponse;

    public UserException(CodeResponse codeResponse) {
        this.codeResponse = codeResponse;
    }

    public static final CodeResponse EXISTED = new CodeResponse("01", "User existed",
            HttpStatus.BAD_REQUEST);
}
