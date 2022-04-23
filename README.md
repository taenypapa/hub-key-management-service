# Key Management Sevice

### SW 기반 Data 암호화에 필요한 key management 서비스

## 1. KMS 필요성

<pre>
Micro Service Architecture로 개발하다보면 각 MS 별로 데이터 암호화가 필요하다. 높은 수준의 MSA를 위해서는 DB 분리도 필요한데, 
현 한국에서는 디비 암호화를 솔루션 기반으로 많이 사용하고 있다.
솔루션 기반은 주로 함수 기반의 암호화를 사용하기 때문에 스프링부트의 JPA 활용도가 떨어진다.
이를 해결 하기 위해서는 SW 기반 암호화가 필요하다. SW 암호화에 사용될 키를 관리하기 위한 서비스이다.

한국 환경에서는 몇 개의 디비기반 암호화 솔루션이 대부분이다. C솔루션과, D솔루션이 대표적인 예이다.
그 솔루션은 기존에는 DBMS의 함수 기반으로 구축되어 있다.
기존 레거시 시스템을 클라우드 네이티브 기반으로 전환하기 위해서는 마이그레이션이 필요하다.ㅈ
</pre>

## 2. KMS 구축 방법

### 1) 레거시 시스템
<pre>
</pre>
