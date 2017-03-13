package com.lanou.taochangjun.gift.projectbapp.video;

import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by imac on 2017/3/11.
 */

@Table("video")
public class VideoBean {
    //指定自增,每个对象需要有一个主键
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;
    @NotNull
    private String title;
    private String photo;
    private String url;
    private String author;

    public VideoBean() {
    }

    public VideoBean(String author, int id, String photo, String title, String url) {
        this.author = author;
        this.id = id;
        this.photo = photo;
        this.title = title;
        this.url = url;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
