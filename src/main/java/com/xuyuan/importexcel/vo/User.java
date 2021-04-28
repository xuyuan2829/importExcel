package com.xuyuan.importexcel.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/4/28 9:12
 * @Created by XuYuan
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -247326016475405564L;

    @Excel(name = "id")
    private String id;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "年龄")
    private Integer age;

    @Excel(name = "生日", importFormat = "yyyy-MM-dd")
    private Date birthday;

    @Excel(name = "表2字段A")
    private String table2FieldA;

    @Excel(name = "表2字段B")
    private String table2FieldB;

    @Excel(name = "表3字段A")
    private String table3FieldA;

    @Excel(name = "表3字段B")
    private String table3FieldB;

    @Excel(name = "表4字段A")
    private String table4FieldA;

    @Excel(name = "表4字段B")
    private String table4FieldB;

    @Excel(name = "表5字段A")
    private String table5FieldA;

    @Excel(name = "表5字段B")
    private String table5FieldB;

    @Excel(name = "表6字段A")
    private String table6FieldA;

    @Excel(name = "表6字段B")
    private String table6FieldB;

}
