package com.ls.wod.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author francisco
 */

@Entity
@Table(name = "phone")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPhone")
    private Integer idPhone;
    
    @Basic(optional = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 11)
    @Column(name = "phone")
    private String phone;
    
    @JoinColumn(name = "idCountry", referencedColumnName = "idCountry")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Country country;

    public Phone() {
    }

    public Phone(Integer idPhone) {
        this.idPhone = idPhone;
    }
}
