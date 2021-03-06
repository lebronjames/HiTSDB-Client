package com.aliyun.hitsdb.client.value.request;

import com.aliyun.hitsdb.client.value.JSONValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By jianhong.hjh
 * Date: 2018/10/29
 */
public class LastPointQuery extends JSONValue {


    public static class Builder {
        private Integer backScan;

        private Boolean msResolution;

        private Long timestamp;

        private List<LastPointSubQuery> queries;

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder backScan(int backScan) {
            this.backScan = backScan;
            return this;
        }

        public Builder msResolution(boolean msResolution) {
            this.msResolution = msResolution;
            return this;
        }

        public Builder sub(LastPointSubQuery subQuery) {
            if (queries == null) {
                queries = new ArrayList<LastPointSubQuery>();
            }
            queries.add(subQuery);
            return this;
        }

        public LastPointQuery build() {
            if(queries == null || queries.isEmpty()){
                throw new IllegalArgumentException("the LastPointSubQuery must be set");
            }
            LastPointQuery query = new LastPointQuery();
            query.backScan = this.backScan;
            query.msResolution = msResolution;
            query.timestamp = timestamp;
            query.setQueries(queries);
            return query;
        }
    }


    public static Builder builder(){
        return new Builder();
    }

    private Boolean msResolution;

    private Integer backScan;

    private Long timestamp;


    private List<LastPointSubQuery> queries;

    public Boolean isMsResolution() {
        return msResolution;
    }

    public void setMsResolution(boolean msResolution) {
        this.msResolution = msResolution;
    }

    public Integer getBackScan() {
        return backScan;
    }

    public void setBackScan(int backScan) {
        this.backScan = backScan;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<LastPointSubQuery> getQueries() {
        return queries;
    }

    public void setQueries(List<LastPointSubQuery> queries) {
        this.queries = queries;
    }
}
