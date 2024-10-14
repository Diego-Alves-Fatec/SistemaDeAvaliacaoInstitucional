package comercial.service;

import comercial.model.repository.*;
import comercial.model.vo.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

@Service
public class QuestaoService {

    @Autowired
    QuestaoRepository questaoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RespostaInstituicaoRepository respostaInstituicaoRepository;

    @Autowired
    RespostaProfessoresRepository respostaProfessoresRepository;

    @Autowired
    ItemDominioRepository itemDominioRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    SugestaoInstituicaoRepository sugestaoInstituicaoRepository;

    @Autowired
    SugestaoProfessorRepository sugestaoProfessorRepository;


    public List<QuestaoVO> buscarQuestoesInstituicao() {

        ItemDominioVO flagTipoAvaliacao = itemDominioRepository.getReferenceById(12);

        return questaoRepository.findByFlagTipoAvaliacao(flagTipoAvaliacao);
    }

    public UsuarioVO buscarUsuarioPorEmail(String login) {
        return usuarioRepository.findByEmail(login);
    }

    public void geraCookies(Map<String, String> formParams, HttpServletResponse response) {
        formParams.forEach((key, value) -> {
            Cookie cookie = new Cookie(key, value);
            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
        });
    }

    private static final String SECRET_KEY = "1234567890123456";

    public String criptografar(String valor) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] valorCriptografado = cipher.doFinal(valor.getBytes());

        return Base64.getEncoder().encodeToString(valorCriptografado);
    }

    public void persistirRespostasInstituicao(Map<String, String> formParams, HttpServletRequest request) {
        String login = getLoginFromCookie(request.getCookies());
        SugestaoInstituicaoVO voSugestao = new SugestaoInstituicaoVO();
        voSugestao.setSugestao(formParams.get("sugestoes"));
        voSugestao.setUsuario(login);
        sugestaoInstituicaoRepository.save(voSugestao);
        for (Map.Entry<String, String> entry : formParams.entrySet()) {
            if (entry.getKey().startsWith("Questao_")) {
                String[] valores = entry.getKey().split("_");
                QuestaoVO questaoVO = questaoRepository.findById(Integer.parseInt(valores[1])).orElse(null);
                ItemDominioVO itemDominioVO = itemDominioRepository.findById(Integer.parseInt(entry.getValue())).orElse(null);

                if (questaoVO != null && itemDominioVO != null) {
                    RespostaInstituicaoVO vo = new RespostaInstituicaoVO();
                    vo.setQuestao(questaoVO);
                    vo.setFlagAlternativa(itemDominioVO);
                    vo.setUsuario(login);
                    respostaInstituicaoRepository.save(vo);
                } else {
                    throw new RuntimeException("Questão Inválida");
                }
            }
        }
    }

    public void persistirRespostasProfessores(Map<String, String> formParams, HttpServletRequest request) {
        String login = getLoginFromCookie(request.getCookies());
        SugestaoProfessorVO voSugestao = new SugestaoProfessorVO();
        voSugestao.setSugestao(formParams.get("sugestoes"));
        voSugestao.setUsuario(login);
        sugestaoProfessorRepository.save(voSugestao);
        for (Map.Entry<String, String> entry : formParams.entrySet()) {
            if (entry.getKey().contains("Questao")) {
                String[] valores = entry.getKey().split("_");
                DisciplinasVO disciplinasVO = disciplinaRepository.findById(Integer.parseInt(valores[0])).orElse(null);
                QuestaoVO questaoVO = questaoRepository.findById(Integer.parseInt(valores[2])).orElse(null);
                ItemDominioVO itemDominioVO = itemDominioRepository.findById(Integer.parseInt(entry.getValue())).orElse(null);
                if (questaoVO != null && itemDominioVO != null) {
                    RespostaProfessoresVO vo = new RespostaProfessoresVO();
                    vo.setQuestao(questaoVO);
                    vo.setFlagAlternativa(itemDominioVO);
                    vo.setUsuario(login);
                    vo.setFlagDisciplina(disciplinasVO);
                    respostaProfessoresRepository.save(vo);
                } else {
                    throw new RuntimeException("Questão Inválida");
                }
            }
        }
    }

    private String getLoginFromCookie(Cookie[] request) {
        return Arrays.stream(request)
                .filter(cookie -> "criptografia".equals(cookie.getName()))
                .map(Cookie::getValue)
                .distinct()
                .findFirst()
                .orElse(null);
    }

    public String criptografar(Map<String, String> formParams, HttpServletRequest request) throws Exception {
        String login = null;
        if (request.getCookies() != null) {

            login = Arrays.stream(request.getCookies())
                    .filter(cookie -> "login".equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .distinct()
                    .findFirst()
                    .orElse(null);
        }

        String criptografia = formParams.get("criptografia");

        if (login == null || criptografia == null) {
            return "index";
        }

        String concatenacao = login + criptografia;
        String valorCriptografado = criptografar(concatenacao);
        formParams.put("login", login);
        formParams.put("criptografia", valorCriptografado);
        return null;
    }

    public List<QuestaoVO> buscarQuestoesProfessores() {
        ItemDominioVO flagTipoAvaliacao = itemDominioRepository.getReferenceById(24);
        return questaoRepository.findByFlagTipoAvaliacao(flagTipoAvaliacao);
    }

    public List<DisciplinasVO> buscarDisciplinas() {
        return disciplinaRepository.findAll();
    }
}
