package com.todoapp.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Todo")
public class Todo {

    @Id
    private Long id;

    private String content;

    private Boolean checked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean isChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", checked=" + checked +
                '}';
    }
}
