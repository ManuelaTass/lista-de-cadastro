
package com.defensoria.service;

import com.defensoria.model.Assistee;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço responsável por gerenciar os dados dos assistidos
 * Implementa as operações básicas de CRUD (Criar, Ler, Atualizar, Deletar)
 */
public class AssisteeService {
    // Lista que simula um banco de dados em memória
    private List<Assistee> assistees = new ArrayList<>();

    /**
     * Cria um novo registro de assistido
     * @param assistee Objeto contendo os dados do novo assistido
     */
    public void create(Assistee assistee) {
        assistees.add(assistee);
    }

    /**
     * Retorna todos os assistidos cadastrados
     * @return Lista com todos os assistidos
     */
    public List<Assistee> readAll() {
        return new ArrayList<>(assistees);
    }

    /**
     * Busca um assistido específico pelo CPF
     * @param cpf CPF do assistido a ser encontrado
     * @return O assistido encontrado ou null se não existir
     */
    public Assistee findByCpf(String cpf) {
        return assistees.stream()
                .filter(a -> a.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    /**
     * Atualiza os dados de um assistido existente
     * @param cpf CPF do assistido a ser atualizado
     * @param updatedAssistee Novos dados do assistido
     * @return true se a atualização foi bem sucedida, false caso contrário
     */
    public boolean update(String cpf, Assistee updatedAssistee) {
        for (int i = 0; i < assistees.size(); i++) {
            if (assistees.get(i).getCpf().equals(cpf)) {
                assistees.set(i, updatedAssistee);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um assistido do sistema
     * @param cpf CPF do assistido a ser removido
     * @return true se a remoção foi bem sucedida, false caso contrário
     */
    public boolean delete(String cpf) {
        return assistees.removeIf(a -> a.getCpf().equals(cpf));
    }
}
