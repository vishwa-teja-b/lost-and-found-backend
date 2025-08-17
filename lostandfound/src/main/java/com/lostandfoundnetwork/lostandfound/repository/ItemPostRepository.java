package com.lostandfoundnetwork.lostandfound.repository;

/*
--> Repository interface for ItemPost entity.
--> It extends JpaRepository, which provides standard CRUD operations and more.
--> Spring Data JPA automatically implements this repository at runtime.
 */


import com.lostandfoundnetwork.lostandfound.entity.ItemPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/** @Repository tells the spring that this class/interface is responsible for interacting with
the database , and it also enables exception translation (converts low-level DB exceptions into
Spring's DataAccessException)

 --> @Repository tells Spring: “This is a bean that talks to the database.
If something goes wrong at the DB level, convert those ugly low-level SQL
exceptions into clean, consistent Spring exceptions (DataAccessException).”
 */


@Repository
public interface ItemPostRepository extends JpaRepository<ItemPost, Long> {
    /*
    * By extending JpaRepository<ItemPost, Long> , we get methods like :
    * save(),
    * findById(),
    * findAll(),
    * deleteById(), etc .
    *
    * We can add custom query methods here later e.g , findByStatus(PostStatus status).
    * */
}
