package com.example.girl.service;

import com.example.girl.enums.ResultEnums;
import com.example.girl.exception.GirlException;
import com.example.girl.repository.GirlRepository;
import com.example.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void inserttwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(20);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("DDDDD");
        girlB.setAge(25);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws GirlException{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age <= 10){
            //返回“你还在上小学吧” code=100
            throw new GirlException(ResultEnums.PRIMARY_SCHOOL);
        }else if(age >10 && age <16){
            //返回“你可能还在上初中” code=101
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL);
        }
    }
}
