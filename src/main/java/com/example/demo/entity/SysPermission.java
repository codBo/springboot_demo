package com.example.demo.entity;
 
import lombok.Data;

import java.io.Serializable;
import java.util.List;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
 
/**
 * 权限实体类;
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
@Entity
@Data
public class SysPermission implements Serializable{

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue
    private long id;//主键.
    private String name;//名称.
    @Column(columnDefinition="enum('menu','button')")
    //资源类型，[menu|button]
    private String resourceType;
    private String url;//资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private Long parentId; //父编号
    private String parentIds; //父编号列表
    private Boolean available = Boolean.FALSE;
    @ManyToMany
    @JoinTable(
            name="SysRolePermission",
            joinColumns={@JoinColumn(name="permissionId")},
            inverseJoinColumns={@JoinColumn(name="roleId")}
    )
    private List<SysRole> roles;

}