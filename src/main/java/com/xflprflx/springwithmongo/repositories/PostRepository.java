package com.xflprflx.springwithmongo.repositories;

import com.xflprflx.springwithmongo.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
