package com.kobylynskyi.graphql.generator.mapper;

import com.kobylynskyi.graphql.generator.model.MappingConfig;
import com.kobylynskyi.graphql.generator.utils.Utils;
import graphql.language.EnumTypeDefinition;

import java.util.HashMap;
import java.util.Map;

import static com.kobylynskyi.graphql.generator.model.DataModelFields.*;

/**
 * Map enum definition to a Freemarker data model
 *
 * @author kobylynskyi
 */
public class EnumDefinitionToDataModelMapper {

    /**
     * Map field definition to a Freemarker data model
     *
     * @param enumDef       GraphQL enum definition
     * @param mappingConfig Global mapping configuration
     * @return Freemarker data model of the GraphQL enum
     */
    public static Map<String, Object> map(EnumTypeDefinition enumDef, MappingConfig mappingConfig) {
        Map<String, Object> dataModel = new HashMap<>();

        String className = Utils.capitalize(enumDef.getName()) + "Enum";
        dataModel.put(PACKAGE, MapperUtils.getJavaPackageLine(mappingConfig));
        dataModel.put(CLASS_NAME, className);
        dataModel.put(FIELDS, EnumValueDefinitionToStringMapper.map(enumDef.getEnumValueDefinitions()));

        return dataModel;
    }

}
