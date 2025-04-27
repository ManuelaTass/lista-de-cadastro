package com.defensoria.controller;

import com.defensoria.model.Assistee;
import com.defensoria.service.AssisteeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

/**
 * Controlador responsável por gerenciar as requisições HTTP relacionadas aos assistidos
 * Implementa os endpoints para as operações CRUD e renderização das páginas
 */
@Controller
public class AssisteeController {
    private final AssisteeService service = new AssisteeService();

    /**
     * Exibe a página inicial com o formulário de cadastro
     * @param model Modelo para passar dados para a view
     * @return Nome da view a ser renderizada
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("assistee", new Assistee());
        return "index";
    }

    /**
     * Exibe a página com a lista de todos os assistidos
     * @param model Modelo para passar dados para a view
     * @return Nome da view a ser renderizada
     */
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("assistees", service.readAll());
        return "list";
    }

    /**
     * Processa o formulário de cadastro de um novo assistido
     * @param assistee Dados do novo assistido
     * @return Redireciona para a página inicial após o cadastro
     */
    @PostMapping("/assistee/add")
    public String addAssistee(@ModelAttribute Assistee assistee) {
        service.create(assistee);
        return "redirect:/";
    }

    /**
     * Exibe o formulário de edição de um assistido
     * @param cpf CPF do assistido a ser editado
     * @param model Modelo para passar dados para a view
     * @return Nome da view a ser renderizada
     */
    @GetMapping("/assistee/edit/{cpf}")
    public String editForm(@PathVariable String cpf, Model model) {
        Assistee assistee = service.findByCpf(cpf);
        if (assistee != null) {
            model.addAttribute("assistee", assistee);
            return "edit";
        }
        return "redirect:/list";
    }

    /**
     * Processa o formulário de atualização de um assistido
     * @param assistee Dados atualizados do assistido
     * @param model Modelo para passar dados para a view
     * @return Redireciona para a lista após a atualização
     */
    @PostMapping("/assistee/update")
    public String updateAssistee(@ModelAttribute Assistee assistee, Model model) {
        if (service.update(assistee.getCpf(), assistee)) {
            return "redirect:/list";
        }
        model.addAttribute("error", "Erro ao atualizar assistido");
        return "edit";
    }

    /**
     * Processa a requisição de exclusão de um assistido
     * @param cpf CPF do assistido a ser excluído
     * @return Resposta HTTP indicando sucesso ou falha
     */
    @PostMapping("/assistee/delete/{cpf}")
    @ResponseBody
    public ResponseEntity<String> deleteAssistee(@PathVariable String cpf) {
        if (service.delete(cpf)) {
            return ResponseEntity.ok().body("Assistido excluído com sucesso");
        }
        return ResponseEntity.badRequest().body("Erro ao excluir assistido");
    }
}