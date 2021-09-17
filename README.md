# example-java-concurrent

## History
### Since 1.0
* java.lang.Runnable
* java.lang.Thread

### Since 5
* java.util.concurrent.Callable<T>
* java.util.concurrent.ExecutorService
* java.util.concurrent.Future<T>

### Since 8
* java.util.concurrent.CompletableFuture<T>

### Since 9
* java.util.concurrent.Flow

---

## Examples
### Runnable
* basic.RunnableBasicEx.java
* basic.CallableBasicEx.java

### ExecutorService
* pool.ExecutorServiceEx.java

### CompletableFuture
* pool.CompletableFutureEx.java

### Spring Async API 
* spring package

---

## References
### Java
* [[Java] 프로세스(process)와 쓰레드(Thread)의 개념과 구현](https://devlog-wjdrbs96.tistory.com/m/145)
* [[Java] 멀티 스레드](https://velog.io/@sezzzini/Java-%EB%A9%80%ED%8B%B0-%EC%8A%A4%EB%A0%88%EB%93%9C)
* [Java - Runnable과 Callable의 차이점 이해하기](https://codechacha.com/ko/java-callable-vs-runnable/)

### Spring
* [Spring @Async 비동기처리](http://dveamer.github.io/java/SpringAsync.html)
* [Creating Asynchronous Methods](https://spring.io/guides/gs/async-method/)

### Retrofit
* [[Android] Retrofit 2.0 사용 방법 (Java, Kotlin) - 2. Call 동기, 비동기](https://gwi02379.tistory.com/7)