package com.hobo.utils;

import com.hobo.model.User;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lixianfeng on 2018/9/4.
 */
public class DateUtil {
    public Date getDate(){
        return new Date();
    }
    public String getCurrentDateStr(String str){
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(69 / 12);
        String naem = "镇江机构";
        System.out.println(naem.indexOf("镇11江"));

        Integer tt = -129,yy=-129;
        System.out.println(tt == yy);
        


        int value = 0;
        for (int i = 1; i <= 100; i++) {
            value = value + i;
        }
        System.out.println(value);
        System.out.println(100 * 0.5 * (1 + 100));
        System.out.println(100 * 100 * 0.5 + (1 - 0.5) * 100);


        Long f1 = 150L, f2 = 150L, f3 = 100L, f4 = 100L;
        Long f5 = 150L;
        Long a = 169L;
        Integer b = 169;
        System.out.println(a.toString() == b.toString());
        System.out.println(a.toString().equals(b.toString()));
        System.out.println(f1.hashCode());
        System.out.println(f1.toString().hashCode());
        System.out.println(f1.toString().equals(f1));
        System.out.println("150".equals(f1.toString()));
        System.out.println(f3.equals("100"));//
        System.out.println(f2 == 150);
        System.out.println(f1 == f5);//
        System.out.println(f3 == f4);
        System.out.println(f1.equals(f2));
        System.out.println(f3.equals(f4));
        System.out.println(f2 == new Long(f2));
        System.out.println(f3 == new Long(f3));
        List<User> list = new ArrayList<User>();
        System.out.println(list.hashCode());
        for (User user : list) {
            System.out.println(user.getName());
        }

        Field[] fieldsA = A.class.getFields();
        Field[] fieldsB = B.class.getDeclaredFields();
        System.out.println(A.class.getAnnotations());
        System.out.println("AAAA");
        for (Field field : fieldsA) {
            System.out.println(field.getName());
        }
        System.out.println("BBBB");
        for (Field field : fieldsB) {
            System.out.println(field.getName());
        }
        System.out.println("CCCCCCCCC");
        System.out.println(A.class.getCanonicalName());
        try {
            System.out.println(Class.forName(A.class.getName()).getName());

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public class A{
        private int id;
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

    }
    public class B{
        private int id;
        private String name;
        private boolean b;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            B b1 = (B) o;

            if (id != b1.id) return false;
            if (b != b1.b) return false;
            return !(name != null ? !name.equals(b1.name) : b1.name != null);

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (b ? 1 : 0);
            return result;
        }

        public B() {
            super();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }

        @Override
        public String toString() {
            return "B{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", b=" + b +
                    '}';
        }

        public B(int id, String name, boolean b) {
            this.id = id;
            this.name = name;
            this.b = b;
        }
    }
}
//false
//        true
//        false
//        true
//        true
//        true
//        false
//        false
//        1
