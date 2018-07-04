package com.xlj.thread.chapter2.synchronizedtest.innerclass;

public class PublicClass {

    String username;

    @Override
    public String toString() {
        return "PublicClass{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    class PrivateClass
    {
       String age;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

         String address;

        @Override
        public String toString() {
            return "PrivateClass{" +
                    "age='" + age + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

}
