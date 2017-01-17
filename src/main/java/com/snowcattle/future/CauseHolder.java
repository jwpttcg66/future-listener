package com.snowcattle.future;

/**
 * Created by jiangwenping on 16/12/27.
 * 错误原因
 */
public class CauseHolder {
    public Throwable cause;

    public CauseHolder(Throwable cause) {
        this.cause = cause;
    }

    public CauseHolder() {

    }
}
