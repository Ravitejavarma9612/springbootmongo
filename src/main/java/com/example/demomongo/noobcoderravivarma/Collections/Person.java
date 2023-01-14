package com.example.demomongo.noobcoderravivarma.Collections;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document(collection = "Person")
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    @Id
    private Long id;
    private String name;
    private List<Address> address;
}
