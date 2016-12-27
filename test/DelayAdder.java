import com.future.ITaskFuture;
import com.future.ITaskFutureListener;

/**
 * Created by jiangwenping on 16/12/27.
 */
public class DelayAdder {

    public static void main(String[] args) {

        new DelayAdder().add(3 * 1000, 1, 2).addListener(new ITaskFutureListener() {

            @Override
            public void operationComplete(ITaskFuture future) throws Exception {
                Object object = future.get();
                if(object != null && object instanceof  Integer){
                    Integer integer = (Integer)object;
                    System.out.println(integer);
                }
            }

        });
    }
    /**
     * 延迟加
     * @param delay 延时时长 milliseconds
     * @param a 加数
     * @param b 加数
     * @return 异步结果
     */
    public DelayAdditionFuture add(long delay, int a, int b) {
        DelayAdditionFuture future = new DelayAdditionFuture();
        new Thread(new DelayAdditionTask(delay, a, b, future)).start();
        return future;
    }

    private class DelayAdditionTask implements Runnable {

        private long delay;

        private int a, b;

        private DelayAdditionFuture future;

        public DelayAdditionTask(long delay, int a, int b, DelayAdditionFuture future) {
            super();
            this.delay = delay;
            this.a = a;
            this.b = b;
            this.future = future;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                Integer i = a + b;
                // TODO 这里设置future为完成状态(正常执行完毕)
                future.setSuccess(i);
            } catch (InterruptedException e) {
                // TODO 这里设置future为完成状态(异常执行完毕)
                future.setFailure(e.getCause());
            }
        }

    }
}
