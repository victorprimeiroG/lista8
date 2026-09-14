package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.SistemaSeguranca;
import br.com.cybercorp.model.Veiculo;

public class MainTeste {

    public static void main(String[] args) {
        // 1. Instancia 1 Departamento, 1 Funcionário e 1 Veículo
        Departamento depto = new Departamento("TI", "Tecnologia da Informação", 3);
        Funcionario func = new Funcionario("F123", "Victor Hugo", depto);
        Veiculo veiculo = new Veiculo("ABC-1234", "Civic", func);

        // 2. Instancia SistemaSeguranca com 2 vagas de garagem
        SistemaSeguranca sistema = new SistemaSeguranca(2);

        // 3. Criação da credencial original
        Credencial c1 = new Credencial("FFF-999", true, func);

        // 4. Criação do CLONE (mesmo codigoHex, outro objeto em memória)
        Credencial clone = new Credencial("FFF-999", true, func);

        // 5. Teste da Catraca (Permite o mesmo funcionário múltiplas vezes)
        System.out.println("=== TESTE DA CATRACA ===");
        sistema.registrarCatraca(func);
        sistema.registrarCatraca(func);

        // 6. Teste do Cofre (HashSet bloqueia a credencial clonada)
        System.out.println("\n=== TESTE DO COFRE FÍSICO ===");
        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        // 7. Teste da Garagem (Estaciona na vaga 0 e força o erro na vaga 5)
        System.out.println("\n=== TESTE DA GARAGEM ===");
        sistema.estacionarVeiculo(veiculo, 0);

        System.out.println("\n--- Forçando erro de Array (Vaga fora do limite) ---");
        sistema.estacionarVeiculo(veiculo, 5); // Lança ArrayIndexOutOfBoundsException
    }
}
