package com.example.sh.morningtext.bean;

public class BookBean {
    public String bookName;
    public String bookTime;

    public String getBookName() {
        return bookName == null ? "" : bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookTime() {
        return bookTime == null ? "" : bookTime;
    }

    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }
}
