package org.example.jpamovie.week10_jpaproject.Repository;

import org.example.jpamovie.week10_jpaproject.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
/*  ② Q3.  JpaRepository<Entity, Long>에서 두 타입은 각각 무엇을 의미하는가?
          Entity는 객체class를 의미하고 , Long은 Primary key 값의 타입을 의미한다.


    ② Q4. JpaRepository에서 기본 제공하는 CRUD 메서드를요. 5개 이상 찾아 메서드명과 역할을 주석으로 작성하세요.
          Save(): 새로운 Entity 객체 정보를 받아드리고 저장하는 역할을 한다.
          findByID(id): id를 인자로 받아 해당 id의 Entity를 조회하는 역할을 한다.
          findAll(): 모든 Entity를 조회하는 역할을 한다.
          deleteByID(id): id를 인자로 받아 해당 id의 Entity를 삭제하는 역할을 한다.
          existByID(id):  id를 인자로 받아 해당 id의 Entity가 존재하는지 알려주는 역할을 한다.


    ② Q5. findById()의 반환 타입이 Optional인 이유는 무엇인가?
          해당 id의 entity class가 존재하지 않을 수 있기 때문에 , 값을 반환할 때 안전하게 처리하기 위해 optional를 사용한다.



    ② Q6. JpaRepository에서 기본 제공하는 메서드와 개발자가 직접 작성하는 Query Method의 차이는 무엇인가?
        개발자가 사용, 작성하는 쿼리 메서드는 직접 정의해야하며 기능을 더 확장시킬 수 있는 반면에, JpaRepository는
        기본적으로 제공되는 공통 기능, 일반적인 CRUD 역할 정도를 수행한다.

 */


public interface MovieRepository extends JpaRepository<Movie, Long> {

}