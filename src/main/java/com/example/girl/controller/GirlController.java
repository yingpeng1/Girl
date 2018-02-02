package com.example.girl.controller;

import com.example.girl.domain.Girl;
import com.example.girl.domain.Result;
import com.example.girl.repository.GirlRepository;
import com.example.girl.service.GirlService;
import com.example.girl.utils.ResultUtil;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girllist");

        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     */
    @PostMapping(value="/girls")
    public Object girladd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return null;
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());

        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 通过id来查询一个女生
     */
    @GetMapping(value="/girls/{id}")
    public Girl girlfindbyid(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlupdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    //通过年龄查询女生
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/twoin")
    public void girlInsertTwo(){
        girlService.inserttwo();
    }

    @GetMapping(value = "/girls/getage/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
