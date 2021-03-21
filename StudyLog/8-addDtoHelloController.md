# addDtoHelloController
---

```java
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
```

- @RequestParam
    - 외부에서 API로 넘긴 파라미터를 가져오는 애너테이션

## 테스트 코드
---

```java
    @Test
    public void DTO_테스트() throws Exception {
        String name = "Spring";
        int amount = 10000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
```