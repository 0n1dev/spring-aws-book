# JPA
---

## JPA 탄생
---

- 객체를 관계형 데이터 베이스에서 관리
- 애플리케이션 코드보다 SQL 가득
- 패러다임 불일치 (데이터 저장 방법에 초점)

## Spring Data JPA
---

- 구현체 교체의 용이성
- 저장소 교체의 용이성

## Spring Data JPA 의존성 추가
---

```java
    compile('org.springframework.boot:spring-boot-starter-data-jpa')
    compile('com.h2database:h2')
```

- spring-boot-starter-data-jpa
    - 스프링 부트용 Spring Data Jpa 추상화 라이브러리
- h2
    - 인메모리 관계형 데이터베이스
    - 별도의 설치가 필요 없이 프로젝트 의존성만으로 관리 가능
    - 메모리에서 실행되기 때문에 재시작할 때마다 초기화 (테스트 용)

## Posts 클래스
---

```java
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
```

- @Entity
    - 테이블과 링크될 클래스임을 나타냄
    - 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
    - ex) TestName -> test_name table
- @Id
    - 해당 테이블의 PK 필드
- @GeneratedValue
    - PK의 생성 규칙을 나타냄
    - 스프링 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨
- @Column
    - 선언을 하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
    - 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    - 문자열의 경우 VARCHAR(255)가 기본
    
---

- @NoArgsConstructor
    - 기본 생성자 자동 추가
    - public Posts() {} 와 같은 효과
- @Builder
    - 해당 클래스의 빌더 패턴 클래스 생성
    - 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함

## PostsRepository 인터페이스
---

```java
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
```

- ibatis나 MyBatis 등에서 Dao라 불리는 DB Layer 접근자
- JPA에선 Repository라 부르며 인터페이스로 생성
- Entity 클래스와 Entity Repository는 함께 위치해야 함

## 테스트에서 쿼리문 보기
---

> src/main/resources

- 위 디렉토리에 application.properties 파일 생성

```java
spring.jpa.show_sql=true
```