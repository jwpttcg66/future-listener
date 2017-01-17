package com.snowcattle.future;

/**
 * Created by jiangwenping on 16/12/27.
 */
//只是把两个方法对外暴露
public class DelayAdditionFuture extends AbstractFuture<Integer> {

    @Override
    public ITaskFuture<Integer> setSuccess(Object result) {
        return super.setSuccess(result);
    }

    @Override
    public ITaskFuture<Integer> setFailure(Throwable cause) {
        return super.setFailure(cause);
    }
}
