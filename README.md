## What is?

* 멀티 모듈 기반의 모놀리식 아키텍쳐로 *EDA(Event Driven Architecture)* 를 구현한 SpringBoot 애플리케이션 입니다.

* 구조화 된 모놀리식 아키텍쳐에서 간단한 *CQRS* 패턴을 구현합니다.

* *SRP* 와 *OCP* 를 중점으로 설계되었습니다.

---

### 멀티 모듈

멀티 모듈을 구성할때 어떤 점을 중심으로 모듈 단위를 나누고 설계해야 할까?
모든 선택에 트레이드 오프가 존재하겠지만 아래와 같은 나만의 *최소한 지켜야하는 것* 을 정의해보자..

#### 좋은 구조를 만드는 원칙들

* 하나의 목적만 제공한다.
* 반드시 사용되는 의존만 가진다.
* 순환 참조는 하지 않는다.
* ...

#### commons 계층

```
commons
|-abstraction
|-utils
|-spring
  |-aop
...
- commons: 시스템 내부에서 공통으로 사용되는 모듈 
  - abstraction: 시스템 내에서 사용되는 핵심 추상화에 대한 책임
  - utils: 시스템 내에서 사용되는 유틸리티에 대한 책임
  - spring:aop : 스프링 프레임워크에서 사용되는 횡단 관심사 대한 책임
```

#### bootstrap 계층

```
bootstrap
|-bootstrap-api
|-bootstrap-xxx(batch)
|-bootstrap-xxx(worker)
...
- bootstrap : 독립적으로 실행 가능한 애플리케이션 모듈 계층
core 계층의 interface 모듈을 조합해서 실행 가능한 애플리케이션을 제공하는 책임
```

#### core(domain) 계층

```
core
|-{domain}
  |-application
  |-domain
  |-infra
  |-interface
...
- core: 시스템의 핵심 도메인이 존재하는 모듈 계층
  - application: interface 를 통해 들어온 요청을 적절한 도메인 규칙을 적용하는 책임
  - domain: POJO 형식의 순수 자바 코드로 핵심 도메인 모델 및 도메인 이벤트에 대한 책임
  - infra: 외부 시스템 연동에 대한 구현 및 연결 책임
  - interface: 특정 비즈니스 도메인을 사용하기 위한 유저 인터페이스 제공하는 책임
```