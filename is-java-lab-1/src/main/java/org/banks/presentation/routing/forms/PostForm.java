package org.banks.presentation.routing.forms;

import lombok.Data;

import java.util.Map;

@Data
public class PostForm {
    private final Map<String, String> formData;

    public void addData(String key, String value) {
        formData.put(key, value);
    }
}
