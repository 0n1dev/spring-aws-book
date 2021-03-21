# HelloResponseDto
---

```java
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
```

- @Getter
    - 선언된 모든 필드의 get 메소드를 생성
- @RequiredArgsConstructor
    - 선언된 모든 final 필드가 포함된 생성자를 생성
    
## Test 코드
---

```java
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
```

- assertThat
    - assertj라는 테스트 검증 라이브러리의 검증 메소드
    - 검증하고 싶은 대상을 메소드 인자로 받는다.

> Gradle 5버전 사용자는 테스트 코드 실행시 오류가 발생
>
```java
     annotationProcessor("org.projectlombok:lombok")
     compile('org.projectlombok:lombok')
```