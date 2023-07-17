package com.mjvinnovation.school.jobby.start;

import com.mjvinnovation.school.jobby.model.*;
import com.mjvinnovation.school.jobby.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CommandStarter implements CommandLineRunner {

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private CadastroExperienciaRepository cadastroExperienciaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    //@Autowired
    //private EnderecoRepository enderecoRepository;

    @Autowired
    private ProfissaoRepository profissaoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;



    @Override
    public void run(String... args) throws Exception {
        System.out.println("Use este recurso caso queira executar algum comando");

        /* List<Cidade>  cidades = cidadeRepository.findByUfOrderByNomeMunicipio("RS");
        for (Cidade c:cidades) {
            System.out.println(c.getNomeMunicipio());
        }*/

        //Cadastro cadastro = preencherCadastro();

        //cadastroRepository.save(cadastro);

        //CadastroExperiencia cadastroExperiencia = preencherCadastroExperiencia(cadastro);

        //cadastroExperienciaRepository.save(cadastroExperiencia);

        //cadastroRepository.deleteById(2);

        List<Cadastro> cadastros = cadastroRepository.findBySexoAndUf(Sexo.FEMININO, "SP");
        for (Cadastro c:cadastros) {
            System.out.println(c.getNome());
        }

    }

    private Cadastro preencherCadastro(){
        Cadastro cadastro = new Cadastro();

        cadastro.setNome("João da Silva Template");
        cadastro.setCpf("01234567890");
        cadastro.setDataNascimento(LocalDate.of(1983,3,19));
        cadastro.setEmail("jstemplate@gmail.com");

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua de Teste");
        endereco.setNumero("123B");
        endereco.setComplemento("fundos");
        endereco.setBairro("centro");
        endereco.setCep(13800000L);
        // Cidade cidade = cidadeRepository.findById(3550308).get(); // São Pualo SP
        Cidade cidade = cidadeRepository.findByUfAndNomeMunicipio("SP", "São Paulo");
        endereco.setCidade(cidade);
        cadastro.setEndereco(endereco);

        Celular celular = new Celular();
        celular.setNumero(19998761234L);
        celular.setWhatsapp(true);
        cadastro.setCelular(celular);

        PretencaoSalarial pretencaoSalarial = new PretencaoSalarial();
        pretencaoSalarial.setValorMinimo(1320.0);
        pretencaoSalarial.setValorMaximo(3500.0);
        cadastro.setPretencaoSalarial(pretencaoSalarial);

        List<String> habilidades = new ArrayList<>();
        habilidades.add("Java");
        habilidades.add("Java Persistence API (JPA)");
        habilidades.add("Hibernate ORM");
        habilidades.add("Spring Framework");
        habilidades.add("Apache Maven");
        habilidades.add("JUnit Testing");
        habilidades.add("Spring MVC");
        habilidades.add("SQL");
        habilidades.add("MySQL");
        habilidades.add("PostgreSQL");
        habilidades.add("Version Control Systems (e.g., Git)");
        habilidades.add("IDEs (Integrated Development Environments) like Eclipse or IntelliJ IDEA");
        habilidades.add("Application servers like Apache Tomcat");
        cadastro.setHabilidades(habilidades);

        cadastro.setSexo(Sexo.MASCULINO);

        Profissao profissao = profissaoRepository.findByNome("Analista de Sistemas");
        cadastro.setProfissao(profissao);

        return cadastro;
    }

    private CadastroExperiencia preencherCadastroExperiencia(Cadastro cadastro){

        // Set<CadastroExperiencia> cadastroExperiencias = new HashSet<>();
        CadastroExperiencia cadastroExperiencia = new CadastroExperiencia();
        cadastroExperiencia.setSalario(2500.0);
        cadastroExperiencia.setEmpregoAtual(false);
        cadastroExperiencia.setDataContratacao(LocalDate.now().minusYears(3));
        cadastroExperiencia.setDataDesligamento(LocalDate.now().minusMonths(3));
        cadastroExperiencia.setRegimeContratacao(RegimeContratacao.CLT);

        Empresa empresa = empresaRepository.findByNomeIgnoreCase("MJV technology & innovation");
        cadastroExperiencia.setEmpresa(empresa);
        // private Empresa empresa;

        Profissao profissao = profissaoRepository.findByNome("Analista de Testes");
        cadastroExperiencia.setProfissao(profissao);
        cadastroExperiencia.setCadastro(cadastro);
        // cadastroExperiencias.add(cadastroExperiencia);
        //cadastro.setCadastroExperiencias(cadastroExperiencias);

        return cadastroExperiencia;
    }
}
