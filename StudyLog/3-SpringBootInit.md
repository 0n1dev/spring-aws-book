# SpringBootInit
---

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

- @SpringBootApplication
    - 스프링 부트의 자동 설정
    - 스프링 Bean 읽기와 생성 자동

> 프로젝트의 최상단에 위치해야 한다.

- SpringApplication.run을 통해 내장 WAS를 실행