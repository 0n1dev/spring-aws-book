# Controller
---

```java
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
```

- @RestController
    - 컨트롤러를 JSON 포맷으로 반환하는 컨트롤러로 만들어 줍니다.
    - @ResponseBody를 각 메소드마다 선언했던 방식을 한번에 사용할 수 있게 해줍니다.
- @GetMapping
    - HTTP Method인 Get 요청을 받을 수 있는 API를 만들어 줍니다.
    - 예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용 되었습니다.