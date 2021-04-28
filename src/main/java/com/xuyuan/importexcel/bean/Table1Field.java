package com.xuyuan.importexcel.bean;

import com.xuyuan.importexcel.vo.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname Table1Field
 * @Description TODO
 * @Date 2021/4/28 9:22
 * @Created by XuYuan
 */
@Data
public class Table1Field implements Serializable {

    private static final long serialVersionUID = -8595065723446242763L;

    private String id;

    private String name;

    private Integer age;

    private Date birthday;


    public Table1Field() {

    }

    public Table1Field(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.age = u.getAge();
        this.birthday = u.getBirthday();
    }
}
