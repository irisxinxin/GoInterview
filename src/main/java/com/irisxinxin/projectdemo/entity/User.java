package com.irisxinxin.projectdemo.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class User {
    @JsonIgnore
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "用户名不能为空")
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date entryDate;

    public User(Integer id, String name, Date entryDate) {
        this.id = id;
        this.name = name;
        this.entryDate = entryDate;
    }

}
