package com.xuyuan.importexcel.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.xuyuan.importexcel.bean.*;
import com.xuyuan.importexcel.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname ImportExcelController
 * @Description TODO
 * @Date 2021/4/28 9:12
 * @Created by XuYuan
 */
@Slf4j
@RestController
public class ImportExcelController {

    @PostMapping(value = "/excelImport", produces = "application/json;charset=utf-8")
    public Object excelImport(@RequestParam("file") MultipartFile file) {
        try {
            if (file == null) {
                return "文件为空！";
            } else {
                //excel中每一行数据
                List<User> users = baseImport(file.getInputStream(), 0, 1, true, User.class);
                //六张表中需要插入的数据 list中的对象根据实际情况封装，这只是demo 我就用了一个对象封装
                List<Table1Field> table1List = new LinkedList();//需要插入表1中的数据，其中Table1Field对应表1的实体类
                List<Table2Field> table2List = new LinkedList();//需要插入表2中的数据，其中Table2Field对应表2的实体类
                List<Table3Field> table3List = new LinkedList();//需要插入表3中的数据，其中Table3Field对应表3的实体类、以下类推
                List<Table4Field> table4List = new LinkedList();//需要插入表4中的数据
                List<Table5Field> table5List = new LinkedList();//需要插入表5中的数据
                List<Table6Field> table6List = new LinkedList();//需要插入表6中的数据
                if(!CollectionUtils.isEmpty(users)){
                    users.forEach( u -> {
                        table1List.add(new Table1Field(u));
                        table2List.add(new Table2Field(u));
                        table3List.add(new Table3Field(u));
                        table4List.add(new Table4Field(u));
                        table5List.add(new Table5Field(u));
                        table6List.add(new Table6Field(u));
                    });
                }
                //Excel解析完毕，数据保存到数据库
                log.info("需要保存到表1中的数据为：{}",table1List);
                log.info("需要保存到表2中的数据为：{}",table2List);
                log.info("需要保存到表3中的数据为：{}",table3List);
                log.info("需要保存到表4中的数据为：{}",table4List);
                log.info("需要保存到表5中的数据为：{}",table5List);
                log.info("需要保存到表6中的数据为：{}",table6List);
                //TODO  将以上6个list保存到相应的数据库中
                //如果有存在即更新的情况 可以将需要更新的数据摘出来，单独做一个update操作


            }
        } catch (Exception e) {
            log.info("文件解析失败！！");
        }
        return "文件解析失败！！";

    }

    /**
     * 最基础导入
     *
     * @param inputStream
     * @param titleRows   表格标题行数,默认0
     * @param headerRows  表头行数,默认1
     * @param needVerify  是否需要检测excel
     * @param pojoClass   导入的对象
     * @return
     * @throws IOException List<T>
     */
    private <T> List<T> baseImport(InputStream inputStream, Integer titleRows, Integer headerRows,
                                   boolean needVerify, Class<T> pojoClass) throws Exception {
        if (inputStream == null) {
            return null;
        } else {
            final ImportParams params = new ImportParams();
            params.setTitleRows(titleRows);
            params.setHeadRows(headerRows);
            params.setSaveUrl("/temp/excel/");
            params.setNeedSave(true);
            params.setNeedVerify(needVerify);
            return ExcelImportUtil.importExcel(inputStream, pojoClass, params);
        }

    }
}
