package com.company;

public class Post {
    private long id;
    private String post;

    public Post() {}

    public Post(long id, String post) {
        this.id = id;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
