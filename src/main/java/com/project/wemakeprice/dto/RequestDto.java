package com.project.wemakeprice.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RequestDto {
    @NotNull
    @URL
    private String url;

    @NotNull
    private String type;

    @NotNull
    private Integer bundle;
}
