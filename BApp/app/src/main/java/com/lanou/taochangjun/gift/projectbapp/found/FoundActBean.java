package com.lanou.taochangjun.gift.projectbapp.found;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by imac on 2017/3/9.
 */

@Table("person")

public class FoundActBean {
    @PrimaryKey(AssignType.AUTO_INCREMENT)

    private String name;

    public FoundActBean() {
    }

    public FoundActBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
