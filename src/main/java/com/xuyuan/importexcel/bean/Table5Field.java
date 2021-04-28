package com.xuyuan.importexcel.bean;

import com.xuyuan.importexcel.vo.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @Classname Table2Field
 * @Description TODO
 * @Date 2021/4/28 9:17
 * @Created by XuYuan
 */
@Data
public class Table5Field implements Serializable {

    private static final long serialVersionUID = -509696502291817591L;

    private String id;

    /**
     * 数据库字段A
     */
    private String fieldA;

    /**
     * 数据库字段B
     */
    private String fieldB;

    public Table5Field() {
    }

    public Table5Field(User u) {
        this.fieldA = u.getTable5FieldA();
        this.fieldB = u.getTable5FieldB();
    }
}
