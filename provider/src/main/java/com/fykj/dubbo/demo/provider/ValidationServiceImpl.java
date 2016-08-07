package com.fykj.dubbo.demo.provider;

import com.fykj.dubbo.demo.api.ValidationService;
import com.fykj.dubbo.demo.vo.ValidationParameter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2016/1/6.
 */
@Service(value = "validationService")
public class ValidationServiceImpl implements ValidationService {
    public void save(ValidationParameter parameter) {

    }

    public void update(ValidationParameter parameter) {

    }

    public void delete(@Min(1) int id) {

    }
}
