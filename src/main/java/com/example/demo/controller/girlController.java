package com.example.demo.controller;

import com.example.demo.domain.Girl;
import com.example.demo.domain.Result;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by fankun.zfk on 2017/7/23.
 */
@RestController
public class girlController {

    private final static org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(girlController.class);


    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /**
    * 查询所有女生列表
     */
    @GetMapping(value="/girls")
    public java.util.List<Girl> girlList(){
        logger.info("girlList()");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     */
    @PostMapping(value="/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 通过id查询一个女生
    */
    @GetMapping(value="/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 通过id更新一个女生
     */
    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
    * 通过id删除一个女生
    */
    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
        }

    /**
     *通过年龄查询女生列表
     */
    @GetMapping(value="/girls/age/{age}")
    public java.util.List<Girl> girkListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     *插入两个女生
     */
    @PostMapping(value="/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
