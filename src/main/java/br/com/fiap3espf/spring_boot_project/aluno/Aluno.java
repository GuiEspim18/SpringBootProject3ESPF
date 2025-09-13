package br.com.fiap3espf.spring_boot_project.aluno;

import br.com.fiap3espf.spring_boot_project.endereco.Endereco;
import br.com.fiap3espf.spring_boot_project.instrutor.DadosAtualizacaoInstrutor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alunos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    String telefone;

    Boolean ativo = true;
    @Enumerated(EnumType.STRING)
    Carteira carteira;

    String cpf;

    @Embedded
    Endereco endereco;

    public Aluno(DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.carteira = dados.carteira();
        this.cpf = dados.cpf();
    }


    public void atualizarInformacoes(@Valid DadosAtualizacaoAluno dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        if (dados.carteira() != null) {
            this.carteira = dados.carteira();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
