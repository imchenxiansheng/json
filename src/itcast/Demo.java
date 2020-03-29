package itcast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author cjs
 * @Date 2020/3/2 0:44
 * @Description: ObjectMapper的主要用法
 */
public class Demo {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User(1L, "张三", 15, new Date());
//        User user = new User(1L, "", 15, new Date());
//        User user = null;

        //默认 时间 类型 序列化后是一个时间戳,  改为false
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //设置自己要的 时间 表现形式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));
        //序列化所有属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //null ,空字符串 "" , 空集合  都不会被序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //反序列化遇到未知属性，就是没有setter方法的属性， false ,不抛异常
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        //序列化
        try {
            String json = objectMapper.writeValueAsString(user);
            System.out.println("++222json = " + json);
            //json = {"id":1,"name":"张三","age":15,"brithday":1583082422463}
            //json = {"id":1,"name":"张三","age":15,"brithday":"2020-03-02 01:19:21 860"}

//            json = "{\"id\":1,\"name\":\"张三\",\"age\":15,\"brithday\":1583082422463,\"statu\":1}";
//            json = null;
////            反序列化
//            //Bean
//            User user1 = objectMapper.readValue(json, User.class);
//            System.out.println(user1.toString());
//            //数组 集合
//            String json2 = "[1,2,3,5]";
//            List<Integer> list = objectMapper.readValue(json2, objectMapper.getTypeFactory().constructCollectionType(List.class, Integer.class));
//            System.out.println(list.toString());
//            //map
//            String json3 = "{\"id\":\"2\",\"name\":\"张三\",\"age\":\"15\",\"brithday\":\"1583082422463\"}";
//            Map<String,String> map = objectMapper.readValue(json3, objectMapper.getTypeFactory().constructMapType(Map.class, String.class, String.class));
//            for (Map.Entry<String, String> entry: map.entrySet()) {
//                System.out.println(entry.getKey()+" : " +entry.getValue());
//            }
//            //复杂类型  List<Map<Object,Object>>
//            String json4 = "[{\"id\":\"3\",\"name\":\"张三\",\"age\":\"15\",\"brithday\":\"1583082422463\"},{\"id\":\"4\",\"name\":\"李四\",\"age\":\"15\",\"brithday\":\"1583082422463\"}]";
//            List<Map<String, String>> maps = objectMapper.readValue(json4, new TypeReference<List<Map<String, String>>>() {
//            });
//            for (Map<String, String> stringMap : maps) {
//                System.out.println("map =" + stringMap);
//            }
//            User user2 = objectMapper.readValue(json, new TypeReference<User>() {
//            });
//            System.out.println(user2.toString());
        } catch(JsonProcessingException e){
                e.printStackTrace();
            }


        }
    }
