package com.example.demo.repository;

import com.example.demo.entity.resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by brian on 2017/9/16.
 */
public interface ResourceRepository extends JpaRepository<resource, Long>{

}
