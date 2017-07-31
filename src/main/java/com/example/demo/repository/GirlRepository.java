package com.example.demo.repository;

import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fankun.zfk on 2017/7/23.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{
    //通过年龄来查询
    public java.util.List<Girl> findByAge(Integer age);

}
