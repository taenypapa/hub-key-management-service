# Key Management Sevice

### SW 기반 Data 암호화에 필요한 key management 서비스

## 1. KMS 필요성

<pre>
Micro Service Architecture로 개발하다보면 각 MS 별로 데이터 암호화가 필요하다. 높은 수준의 MSA를 위해서는 DB 분리도 필요한데, 현 한국에서는 디비 암호화를 솔루션 기반으로 많이 사용하고 있다.
솔루션 기반은 주로 함수 기반의 암호화를 사용하기 때문에 스프링부트의 JPA 활용도가 떨어진다.
이를 해결 하기 위해서는 SW 기반 암호화가 필요하다. SW 암호화에 사용될 키를 관리하기 위한 서비스이다.
</pre>

