# SpringWebLayer
---

- Web Layer
    - 컨트롤러(@Controller)와 JSP/Freemarker 등 뷰 템플릿 영역
    - 필터(@Filter), 인터셉터, 컨트롤러 어드바이스 등 **외부 요청과 응답**에 대한 전반적인 영역
- Service Layer
    - @Service에 사용되는 서비스 영역
    - 일반적으로 Controller와 Dao의 중간 영역
    - @Transactional이 사용되어야 하는 영역
- Repository Layer
    - **Database**와 같이 데이터 저장소에 접근하는 영역
    - DAO
- Dtos
    - DTO는 **계층 간에 데이터 교환을 위한 객체**를 이야기하며 Dtos는 이들의 영역
    - 뷰 템플릿 엔진에서 사용될 객체 또는 Repository Layer에서 결과로 넘겨준 객체 등
- Domain Model
    - 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록 단순화 시킨 것
    