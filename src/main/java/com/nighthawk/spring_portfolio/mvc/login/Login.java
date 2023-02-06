package com.nighthawk.spring_portfolio.mvc.login;
import java.text.*;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.util.GregorianCalendar;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TypeDef(name="json", typeClass = JsonType.class)
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // email, password, roles are key attributes to login and authentication
    @NotEmpty
    @Size(min=5)
    @Email
    @Column(name="email")
    private String email;
    @NotEmpty
    private String password;
    // @NonNull, etc placed in params of constructor: "@NonNull @Size(min = 2, max = 30, message = "Name (2 to 30 chars)") String name"
    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @Column(unique=false)
    private int height;
    @Column(unique=false)
    private int weight;
    /* HashMap is used to store JSON for daily "stats"
    "stats": {
        "2022-11-13": {
            "calories": 2200,
            "steps": 8000
        }
    }
    */
    @Type(type="json")
    @Column(columnDefinition = "jsonb")
    private Map<String,Map<String, Object>> stats = new HashMap<>();

    private ArrayList<Map<String,Map<String, Object>>> statArray = new ArrayList<Map<String,Map<String, Object>>>();

    // Constructor used when building object from an API
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
    

    public String toString(){
        return ( "{ \"email\": "  +this.email+  ", " + "\"password\": "  +this.password+" }" );
    }
    


}