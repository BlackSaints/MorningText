package com.example.sh.morningtext.mvdesign.mvc.text;

//{"code":200,"message":"成功!","result":{"author":"佚名","origin":"涉江采芙蓉","category":"古诗文-山水-江河","content":"涉江采芙蓉，兰泽多芳草。"}}
public class PortryBean {

    public String code;
    public String message;
    public ResultRes result;

    public String getCode() {
        return code == null ? "" : code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultRes getResult() {
        return result;
    }

    public void setResult(ResultRes result) {
        this.result = result;
    }

    private class ResultRes {

        public String author;
        public String origin;
        public String category;
        public String content;

        public String getAuthor() {
            return author == null ? "" : author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getOrigin() {
            return origin == null ? "" : origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getCategory() {
            return category == null ? "" : category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getContent() {
            return content == null ? "" : content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
