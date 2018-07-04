package com.xlj.thread.chapter2.synchronizedtest.innerstatickclass;

public class PublicClass {

    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "PublicClass{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    static class PrivateClass
    {
        String age;
        String address;

        public String getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "PrivateClass{" +
                    "age='" + age + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

}
