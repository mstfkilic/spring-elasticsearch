package com.mustafa.springelasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String id;
    @Field(name = "name",type = FieldType.Text)
    private String name;
    @Field(name = "surname",type = FieldType.Text)
    private String surname;
    @Field(name = "address",type = FieldType.Text)
    private String address;
    @Field(name = "birth_date",type = FieldType.Date)
    private Date birthDate;
}
