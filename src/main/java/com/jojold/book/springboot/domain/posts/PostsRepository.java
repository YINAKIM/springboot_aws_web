package com.jojold.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/********************************************************
 Posts클래스로 DB를 접근하게 해줄 JpaRepository : 마이바티스에서 Dao역할 (DB Layer접근자), JPA에서는 Repository라고 부르고, interface로 생성한다.

 interface로 생성하고 extends JpaRepository<Posts, Long> 해주면 ---> 기본 CRUD메소드가 자동생성된다. (@Repository 안써도됨)
 단, Entity클래스와 EntityRepository는 같은 패키지에 위치해야 한다 (Entity클래스는 기본Repository없이는 제역할을 못함)
    프로젝트 규모가 커져서 도메인별로 프로젝트를 분리해야 한다면
    [Entity클래스 + 기본 Repository]는 함께 움직여야 하므로 domain패키지로 함께 관리한다.
********************************************************/
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();


}
