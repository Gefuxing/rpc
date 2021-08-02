package com.gefuxing.rpc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author gefuxing
 * @create 2021/7/30 9:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School implements Serializable {
    private static final long serialVersionUID = 2L;
    private Integer id;
    private  String name;
}
