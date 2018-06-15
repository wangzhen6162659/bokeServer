package com.admin.user.content;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ArticleContent {
    ARTICLE_TYPE("type"),
    ORDER_BY("create_time desc");

    String value;
}
