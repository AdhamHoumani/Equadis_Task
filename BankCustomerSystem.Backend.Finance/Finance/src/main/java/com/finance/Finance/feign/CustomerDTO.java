package com.finance.Finance.feign;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class CustomerDTO {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Type(type = "pg-uuid")
    private UUID id;

    @NotBlank(message = "{should.not.be.empty.key}")
    @Column(name = "fName", nullable = false)
    private String fName;


    @NotBlank(message = "{should.not.be.empty.key}")
    @Column(name = "lName", nullable = false)
    private String lName;

    @NotBlank(message = "{should.not.be.empty.key}")
    @Column(unique = true, name = "email", nullable = false)
    private String email;


    @NotNull(message = "{should.not.be.empty.key}")
    @Column(unique = true,name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull(message = "{should.not.be.empty.key}")
    @Column(name = "address", nullable = false)
    private String address;
}
