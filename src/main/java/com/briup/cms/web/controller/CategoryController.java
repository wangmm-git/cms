package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(description = "栏目管理")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/add")
    @ApiOperation("添加栏目")
    public Message addCategory(Category category) {
        categoryService.savaOrUpdateCategory(category);
        return MessageUtil.success();
    }

    @GetMapping("/delete")
    @ApiOperation("删除栏目")
    @ApiImplicitParam(name = "id",paramType = "query",dataType = "int",required = true)
    public Message deleteCategory(int id) {
        categoryService.deleteCategory(id);
        return MessageUtil.success();
    }

    @GetMapping("queryById")
    @ApiOperation("根据id查询")
    @ApiImplicitParam(name = "id",paramType = "query",dataType = "int",required = true)
    public Message<Category> queryById(int id) {
        categoryService.queryById(id);
        return MessageUtil.success();
    }

    @GetMapping("update")
    @ApiOperation("更新")
    public Message update(Category category) {
        categoryService.savaOrUpdateCategory(category);
        return MessageUtil.success();
    }

    @GetMapping("/getAll")
    @ApiOperation("获取所有栏目")
    public Message<List<Category>> getAll() {
        List<Category> categories = categoryService.getAllCategory();
        return MessageUtil.success(categories);
    }
}
