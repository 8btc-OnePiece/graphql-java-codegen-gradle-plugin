package com.kobylynskyi.graphql.generator.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MappingConfig {

    /**
     * Scalars mapping can be defined here.
     * e.g.: DateTime -> String
     */
    private Map<String, String> customTypesMapping = new HashMap<>();
    private String javaPackage;

}
