# HelloControllerTest
---

```java
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hell가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

}
```

- @RunWith(SpringRunner.class)
    - 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
- @WebMvcTest
    - Spring MVC에 집중할 수 있는 애노테이션
    - 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
    - @Service, @Component, @Repository 등은 사용할 수 없다.
    - 여기서는 컨트롤러만 사용하기 때문에 사용
- @Autowired
    - 스프링이 관리하는 빈을 주입 받음
- private MockMvc mvc
    - 웹 API를 테스트할 때 사용
    - 스프링 MVC 테스트의 시작점
    - 해당 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트 가능
- mvc.perform(get("/hello"))
    - MockMvc를 통해 /hello 주소로 HTTP GET 요청
    - 체이닝이 지원되어 아래와 같이 여러 검증을 이어서 선언 가능
- .andExpect(status().isOk())
    - HTTP Header의 Status를 검증
    - 200, 404, 500 등 HTTP 상태 코드 검증
    - 여기선 200 검증
- .andExpect(content().string(hello))
    - 응답 본문 내용 검증