package itcast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author cjs
 * @Date 2020/3/2 0:44
 * @Description:
 */

/**
 * ignoreUnknown = true
 * 反序列化时，忽略未知属性， 就是没有set方法的属性，json字符串中比pojo多的属性
 * value = {"id","name"}
 * 序列化时，忽略改字段
 */
@JsonIgnoreProperties(ignoreUnknown = true,value = {"id","name"})
public class User implements Serializable {
//    @JsonIgnore //属性字段 注解， 序列化时，忽略改字段
    private Long id;
    private String name;
    private Integer age;
//    @JsonIgnore
    private Date brithday;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", brithday=" + brithday +
                '}';
    }

    public User(Long id, String name, Integer age, Date brithday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.brithday = brithday;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }
//
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }
}
