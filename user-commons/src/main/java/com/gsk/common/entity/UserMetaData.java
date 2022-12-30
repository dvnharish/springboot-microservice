package com.gsk.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMetaData implements Serializable {
    private UUID id;
    private String name;
    private String fileType;
    private Integer amount;
    private Integer balance;
    private LinkedList<Map<String, Object>> metaData;
    private Boolean consentAvailable;
}

