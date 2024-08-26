package br.com.emanuelcosta.barbershop.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="tb_client")
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = -1867328277199595076L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;

    private LocalDate nascimento;
    //nascimento  = LocalDate.parse("2024-12-28");
    //nascimento  = LocalDate.now();
    //DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    //nascimento  = LocalDate.parse("20/07/2022", fmt1);

    private BigDecimal salario;

    public Client() {
    }

    public Client(Long id, String name, LocalDate nascimento, BigDecimal salario) {
        this.id = id;
        this.name = name;
        this.nascimento = nascimento;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(nascimento, client.nascimento) && Objects.equals(salario, client.salario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nascimento, salario);
    }
}
