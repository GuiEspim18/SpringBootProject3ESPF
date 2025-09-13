package br.com.fiap3espf.spring_boot_project.aluno;


public record DadosListagemAluno(
        Long id,
        String nome,
        String email,
        Carteira carteira,
        String cpf
) {
    public DadosListagemAluno(Aluno dados) {
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getCarteira(), dados.getCpf());
    }

}
