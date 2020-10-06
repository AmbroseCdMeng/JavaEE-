# Java 并发编程

## Java 创建多线程的方式

- 继承 Thread 类

    ```java
    // 自定义线程类，继承 Thread 类
    public class MyThread extends Thread{
        // 线程的运行逻辑
        public void run(){
            System.out.println("My Thread run ... ");
        }
    }
    
    // 定义测试类
    public class MyThreadTest{
        public static void main(String[] args){
            // 实例化自定义的线程对象
            MyThread myThread = new MyThread();
            // 调用 start 方法启动线程
            myThread.start();
        }
    }
    ```

- 实现 Runnable 接口
    ```java
    // 自定义线程类，实现 Runnable 接口，覆写 run 方法
    public class MyThread implements Runnable{
        @Override
        public void run(){
            System.out.println("My Thread run ...");
        }
    }
    
    // 定义测试类
    public class MyThreadTest(){
        public static void main(String[] args){
            // 实例化自定义的线程类对象
            MyThread myThread = new MyThread();
            // 创建线程对象，并传入线程实例
            Thread thread = new Thread(myThread)
            // 调用 start 方法启动线程
            thread.start();
        }
    }
    ```
    
    当然，也可以用匿名内部类或者 Lambda 表达式来写，更加方便
    
    ```java
    new Thread(() -> {
                System.out.println("myThread");
    }).start();
    
    new Thread(new Runnable(){
        @Override
        public void run(){
            System.out.println("myThread");
        }
    }).start();
    ```

- 基于线程池
> 使用线程池来管理线程，可以最大限度的利用线程资源。
> 
> JVM 会先根据用户的参数创建指定数量的可运行线程任务，并将其放入队列中，
> 在线程创建后启动这些任务，如果正在运行的线程数量超过用户设置的最大线程数量，则超出的线程排队等候，
> 在有线程执行完成后，线程池调度器会从队列中取出一个等待的任务并执行

```java

```

- 通过 `ExecutorService` 和 `Callable<Class>` 实现

    > 适用于有返回值得线程。比如有时候需要并发执行一个任务，开启多个线程，然后收集各个线程执行返回的结果并将最终的结果汇总起来。
    
    ```java
    /**
     * 创建线程，实现 Callable 接口
     */
    class MyCallable implements Callable<String> {
    
        private String name;
    
        // 构造函数为线程传参
        public MyCallable(String name){
            this.name = name;
        }
    
        /**
         * 覆写 call 方法，编写线程实现逻辑
         * @return
         * @throws Exception
         */
        @Override
        public String call() throws Exception {
            return name;
        }
    }
    ```
    
    ```java
    public class MyThreadByCallable{
        @Test
        public void myThreadByCallableTest() throws ExecutionException, InterruptedException {
            // 创建一个线程池，指定大小 5
            ExecutorService pool = Executors.newFixedThreadPool(5);
            // 创建多个有返回值的任务
            List<Future> list = new ArrayList<>();
            for (Future item : list){
                Callable callable = new MyCallable(item.toString() );
                // 提交线程，获取 Future 对象并将其保存到 list 中
                Future future = pool.submit(callable);
                System.out.println("Submit a callable thread ...");
                list.add(future);
            }
            // 关闭线程池，等待线程执行结束
            pool.shutdown();
            // 获取所有线程的运行结果
            for (Future future: list){
                String result = future.get().toString();
                System.out.println(result);
            }
        }
    }
    ```
