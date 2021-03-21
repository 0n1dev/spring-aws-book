# Gradle
---
> 스프링 이니셜라이저(https://start.spring.io/)를 사용하지 않고 진행하기

```java
buildscript {
    ext {
        springBootVersion = '2.1.7.RELEASE'
    }

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}
```

- 의존성 관리를 위한 설정
    - ext : 전역변수를 생성

```java
apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'
```

- 앞서 선언한 플러그인 의존성들을 적용할 것인지 결정

```java
repositories {
    mavenCentral()
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter-web')
    testCompile('org.springframework.boot:spring-boot-starter-test')
}
```

- repositories : 각종 의존성들을 어떤 원격 저장소에서 받을지 설정
- dependencies : 프로젝트 개발에 필요한 의존성들을 선언