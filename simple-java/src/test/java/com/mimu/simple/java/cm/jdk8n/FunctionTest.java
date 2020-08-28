package com.mimu.simple.java.cm.jdk8n;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();

        Parent.Child child = functionTest.childInfo(new Function<Parent, Parent>() {
            @Override
            public Parent apply(Parent parent) {
                return parent.setAge(1);
            }
        });
        System.out.println(JSONObject.toJSONString(child));
        Parent.Child child1 = functionTest.childInfo(parent -> parent.setAge(2));
        System.out.println(JSONObject.toJSONString(child1));

    }

    public void calculateInfo() {
        Function<Integer, Integer> addFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + integer;
            }
        };

        Function<Integer, Integer> multiplyFunction = integer -> integer * integer;

        System.out.println(addFunction.apply(3));
        System.out.println(multiplyFunction.apply(3));
        System.out.println(addFunction.compose(multiplyFunction).apply(3));
        System.out.println(addFunction.andThen(multiplyFunction).apply(3));
    }


    public Parent.Child childInfo(Function<? super Parent, ? super Parent> function) {
        return new Parent.Child(new Parent(), function);
    }

    static class Parent {
        private int age;

        public int getAge() {
            return age;
        }

        public Parent setAge(int age) {
            this.age = age;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Parent)) return false;
            Parent parent = (Parent) o;
            return age == parent.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }

        static class Child extends Parent {
            private String name;

            public Child(Parent parent, Function<? super Parent, ? super Parent> function) {
                Parent apply = (Parent) function.apply(parent);
                this.setAge(apply.getAge());
                this.name = "age" + apply.getAge();
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Child)) return false;
                if (!super.equals(o)) return false;
                Child child = (Child) o;
                return Objects.equals(name, child.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(super.hashCode(), name);
            }
        }

    }
}
