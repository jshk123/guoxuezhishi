package com.guoxuezhishi.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: jiang
 * @date: 2019/7/26
 */
public class MapBeanTest {

    /**
     * bean转map
     */
    public MapBeanTest() {
        try {
            Map<String, Object> user = beanTransformToMap(new User(1, "zs"));
            Iterator<Map.Entry<String, Object>> iterator = user.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                System.out.println(next.getKey() + " " + next.getValue());
            }

        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | IntrospectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * map转实体
     *
     * @param map
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws IntrospectionException
     */
    private static User mapTransformToBean(Map<String, Object> map) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {

        User user = new User();
        BeanInfo beanInfo = Introspector.getBeanInfo(user.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (map.containsKey(key)) {
                Object value = map.get(key);
                //得到property对应的setter方法
                Method setter = property.getWriteMethod();
                setter.invoke(user, value);
            }
        }
        return user;
    }

    /**
     * 实体转map
     *
     * @param user
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws IntrospectionException
     */
    private static Map<String, Object> beanTransformToMap(User user) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {

        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(user.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            // 过滤class属性
            if (!key.equals("class")) {
                // 得到property对应的getter方法
                Method getter = property.getReadMethod();
                Object value = getter.invoke(user);
                map.put(key, value);
            }
        }
        return map;
    }

    public static void main(String[] args) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        //BEAN转MAP
        /*User user = new User(1, "zs");
        System.out.println(user);
        Map<String, Object> stringObjectMap = beanTransformToMap(user);
        Iterator<Map.Entry<String, Object>> iterator = stringObjectMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }*/

        //MAP转BEAN
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("id", 2);
        stringObjectMap.put("name", "ls");
        User user = mapTransformToBean(stringObjectMap);
        System.out.println(user);

    }
}

