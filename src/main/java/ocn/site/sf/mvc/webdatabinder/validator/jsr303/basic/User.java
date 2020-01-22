package ocn.site.sf.mvc.webdatabinder.validator.jsr303.basic;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {

	// JSR303 验证规范
	// JSR 303 是java为Bean数据合法性校验所提供的一种标准的规范 目前java内建库中未提供具体的实现框架 不可直接使用
	// 比较推荐使用的第三方的实现框架是hibernate 并且新增了较为通用的其他验证注解
	// maven的依赖地址为 artifact/org.hibernate/hibernate-validator
	// 测试使用的版本是 5.2.0-Final

	// JSR 303 的校验注解
	// Constraint 详细信息
	// @Null 被注释的元素必须为 null
	// @NotNull 被注释的元素必须不为 null
	// @AssertTrue 被注释的元素必须为 true
	// @AssertFalse 被注释的元素必须为 false
	// @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
	// @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
	// @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
	// @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
	// @Size(max, min) 被注释的元素的大小必须在指定的范围内
	// @Digits (integer, fraction) 被注释的元素必须是一个数字，其值必须在可接受的范围内
	// @Past 被注释的元素必须是一个过去的日期
	// @Future 被注释的元素必须是一个将来的日期
	// @Pattern(value) 被注释的元素必须符合指定的正则表达式

	// hibernate validator 新增的校验注解
	// Constraint 详细信息
	// @Email 被注释的元素必须是电子邮箱地址
	// @Length 被注释的字符串的大小必须在指定的范围内
	// @NotEmpty 被注释的字符串的必须非空
	// @Range 被注释的元素必须在合适的范围内

	private static final long serialVersionUID = 1L;
	private int id;
	@Size(min = 4, message = "size must >= 4")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}