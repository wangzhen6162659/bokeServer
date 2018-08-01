package com.admin.user.repository.base.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCollectMusicExample extends com.hengyunsoft.db.example.BaseExample<UserCollectMusicExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {

        public GeneratedCriteria() {
            super();
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIsNull() {
            addCriterion("album_id is null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIsNotNull() {
            addCriterion("album_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdEqualTo(Long value) {
            addCriterion("album_id =", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotEqualTo(Long value) {
            addCriterion("album_id <>", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThan(Long value) {
            addCriterion("album_id >", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThanOrEqualTo(Long value) {
            addCriterion("album_id >=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThan(Long value) {
            addCriterion("album_id <", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThanOrEqualTo(Long value) {
            addCriterion("album_id <=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("album_id in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("album_id not in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdBetween(Long value1, Long value2) {
            addCriterion("album_id between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotBetween(Long value1, Long value2) {
            addCriterion("album_id not between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNull() {
            addCriterion("album_name is null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNotNull() {
            addCriterion("album_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameEqualTo(String value) {
            addCriterion("album_name =", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotEqualTo(String value) {
            addCriterion("album_name <>", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThan(String value) {
            addCriterion("album_name >", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThanOrEqualTo(String value) {
            addCriterion("album_name >=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThan(String value) {
            addCriterion("album_name <", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThanOrEqualTo(String value) {
            addCriterion("album_name <=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLike(String value) {
            addCriterion("album_name like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotLike(String value) {
            addCriterion("album_name not like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIn(java.util.List<java.lang.String> values) {
            addCriterion("album_name in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("album_name not in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameBetween(String value1, String value2) {
            addCriterion("album_name between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotBetween(String value1, String value2) {
            addCriterion("album_name not between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andMusicDurIsNull() {
            addCriterion("music_dur is null");
            return (Criteria) this;
        }

        public Criteria andMusicDurIsNotNull() {
            addCriterion("music_dur is not null");
            return (Criteria) this;
        }

        public Criteria andMusicDurEqualTo(Integer value) {
            addCriterion("music_dur =", value, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicDurNotEqualTo(Integer value) {
            addCriterion("music_dur <>", value, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicDurGreaterThan(Integer value) {
            addCriterion("music_dur >", value, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicDurGreaterThanOrEqualTo(Integer value) {
            addCriterion("music_dur >=", value, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicDurLessThan(Integer value) {
            addCriterion("music_dur <", value, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicDurLessThanOrEqualTo(Integer value) {
            addCriterion("music_dur <=", value, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicDurIn(java.util.List<java.lang.Integer> values) {
            addCriterion("music_dur in", values, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicDurNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("music_dur not in", values, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicDurBetween(Integer value1, Integer value2) {
            addCriterion("music_dur between", value1, value2, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicDurNotBetween(Integer value1, Integer value2) {
            addCriterion("music_dur not between", value1, value2, "musicDur");
            return (Criteria) this;
        }

        public Criteria andMusicIdIsNull() {
            addCriterion("music_id is null");
            return (Criteria) this;
        }

        public Criteria andMusicIdIsNotNull() {
            addCriterion("music_id is not null");
            return (Criteria) this;
        }

        public Criteria andMusicIdEqualTo(Long value) {
            addCriterion("music_id =", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotEqualTo(Long value) {
            addCriterion("music_id <>", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdGreaterThan(Long value) {
            addCriterion("music_id >", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdGreaterThanOrEqualTo(Long value) {
            addCriterion("music_id >=", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdLessThan(Long value) {
            addCriterion("music_id <", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdLessThanOrEqualTo(Long value) {
            addCriterion("music_id <=", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("music_id in", values, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("music_id not in", values, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdBetween(Long value1, Long value2) {
            addCriterion("music_id between", value1, value2, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotBetween(Long value1, Long value2) {
            addCriterion("music_id not between", value1, value2, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicNameIsNull() {
            addCriterion("music_name is null");
            return (Criteria) this;
        }

        public Criteria andMusicNameIsNotNull() {
            addCriterion("music_name is not null");
            return (Criteria) this;
        }

        public Criteria andMusicNameEqualTo(String value) {
            addCriterion("music_name =", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameNotEqualTo(String value) {
            addCriterion("music_name <>", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameGreaterThan(String value) {
            addCriterion("music_name >", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameGreaterThanOrEqualTo(String value) {
            addCriterion("music_name >=", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameLessThan(String value) {
            addCriterion("music_name <", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameLessThanOrEqualTo(String value) {
            addCriterion("music_name <=", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameLike(String value) {
            addCriterion("music_name like", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameNotLike(String value) {
            addCriterion("music_name not like", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameIn(java.util.List<java.lang.String> values) {
            addCriterion("music_name in", values, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("music_name not in", values, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameBetween(String value1, String value2) {
            addCriterion("music_name between", value1, value2, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameNotBetween(String value1, String value2) {
            addCriterion("music_name not between", value1, value2, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlIsNull() {
            addCriterion("music_picurl is null");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlIsNotNull() {
            addCriterion("music_picurl is not null");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlEqualTo(String value) {
            addCriterion("music_picurl =", value, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlNotEqualTo(String value) {
            addCriterion("music_picurl <>", value, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlGreaterThan(String value) {
            addCriterion("music_picurl >", value, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlGreaterThanOrEqualTo(String value) {
            addCriterion("music_picurl >=", value, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlLessThan(String value) {
            addCriterion("music_picurl <", value, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlLessThanOrEqualTo(String value) {
            addCriterion("music_picurl <=", value, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlLike(String value) {
            addCriterion("music_picurl like", value, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlNotLike(String value) {
            addCriterion("music_picurl not like", value, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlIn(java.util.List<java.lang.String> values) {
            addCriterion("music_picurl in", values, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("music_picurl not in", values, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlBetween(String value1, String value2) {
            addCriterion("music_picurl between", value1, value2, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andMusicPicurlNotBetween(String value1, String value2) {
            addCriterion("music_picurl not between", value1, value2, "musicPicurl");
            return (Criteria) this;
        }

        public Criteria andSingerIdIsNull() {
            addCriterion("singer_id is null");
            return (Criteria) this;
        }

        public Criteria andSingerIdIsNotNull() {
            addCriterion("singer_id is not null");
            return (Criteria) this;
        }

        public Criteria andSingerIdEqualTo(Long value) {
            addCriterion("singer_id =", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotEqualTo(Long value) {
            addCriterion("singer_id <>", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdGreaterThan(Long value) {
            addCriterion("singer_id >", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("singer_id >=", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdLessThan(Long value) {
            addCriterion("singer_id <", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdLessThanOrEqualTo(Long value) {
            addCriterion("singer_id <=", value, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("singer_id in", values, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("singer_id not in", values, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdBetween(Long value1, Long value2) {
            addCriterion("singer_id between", value1, value2, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerIdNotBetween(Long value1, Long value2) {
            addCriterion("singer_id not between", value1, value2, "singerId");
            return (Criteria) this;
        }

        public Criteria andSingerNameIsNull() {
            addCriterion("singer_name is null");
            return (Criteria) this;
        }

        public Criteria andSingerNameIsNotNull() {
            addCriterion("singer_name is not null");
            return (Criteria) this;
        }

        public Criteria andSingerNameEqualTo(String value) {
            addCriterion("singer_name =", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameNotEqualTo(String value) {
            addCriterion("singer_name <>", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameGreaterThan(String value) {
            addCriterion("singer_name >", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameGreaterThanOrEqualTo(String value) {
            addCriterion("singer_name >=", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameLessThan(String value) {
            addCriterion("singer_name <", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameLessThanOrEqualTo(String value) {
            addCriterion("singer_name <=", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameLike(String value) {
            addCriterion("singer_name like", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameNotLike(String value) {
            addCriterion("singer_name not like", value, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameIn(java.util.List<java.lang.String> values) {
            addCriterion("singer_name in", values, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("singer_name not in", values, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameBetween(String value1, String value2) {
            addCriterion("singer_name between", value1, value2, "singerName");
            return (Criteria) this;
        }

        public Criteria andSingerNameNotBetween(String value1, String value2) {
            addCriterion("singer_name not between", value1, value2, "singerName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(java.util.List<java.lang.Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(java.util.List<java.lang.Long> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
    user_collect_musicaddClassComment 472
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        public Criteria() {
            super();
        }
    }
}