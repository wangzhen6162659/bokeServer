package com.hengyunsoft.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UploadResult implements Serializable {
    private List<UploadResult.UploadFileResult> list = new ArrayList<>();

    public List<UploadFileResult> getList() {
        return list;
    }

    public void setList(List<UploadFileResult> list) {
        this.list = list;
    }

    public static class UploadFileResult implements Serializable {
        private Long id;
        private String url;
        /**
         * 原始文件名
         *
         * @mbggenerated
         */
        private String submittedFileName;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSubmittedFileName() {
            return submittedFileName;
        }

        public void setSubmittedFileName(String submittedFileName) {
            this.submittedFileName = submittedFileName;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("UploadFileResult{");
            sb.append("id=").append(id);
            sb.append(", url='").append(url).append('\'');
            sb.append(", submittedFileName='").append(submittedFileName).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UploadResult{");
        sb.append("list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
