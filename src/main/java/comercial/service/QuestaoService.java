package comercial.service;

import comercial.model.Util.Paginador;
import comercial.model.repository.*;
import comercial.model.vo.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    TurmaRepository turmaRepository;

    @Autowired
    RespostaRepository respostaRepository;

    @Autowired
    ItemDominioRepository itemDominioRepository;


    public List<QuestaoVO> buscarQuestoesInstituicao() {

        ItemDominioVO flagTipoAvaliacao = itemDominioRepository.getReferenceById(12);

        return questaoRepository.findByFlagTipoAvaliacao(flagTipoAvaliacao);
    }

    public List<TurmasVO> buscarTurma() {
        return turmaRepository.findAll();
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

    public void salvaCookies(HttpServletRequest request) {
        Cookie[] cookiesArray = request.getCookies();
        if (cookiesArray != null) {

            String login = Arrays.stream(cookiesArray)
                    .filter(cookie -> "login".equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .distinct()
                    .findFirst()
                    .orElse(null);


            Arrays.stream(cookiesArray)
                    .filter(cookie -> cookie.getName().startsWith("Questao_"))
                    .forEach(cookie -> {
                        List<String> cookieValues = List.of(cookie.getName().split("_"));
                        Integer id = Integer.parseInt(cookieValues.get(1));
                        RespostaVO vo = new RespostaVO();
                        vo.setUsuario(login);
                        vo.setQuestao(questaoRepository.findById(id).orElse(null));
                        vo.setFlagAlternativa(itemDominioRepository.findById(Integer.parseInt(cookie.getValue())).orElse(null));
                        respostaRepository.save(vo);
                    });
        } else {
            System.out.println("Nenhum cookie foi encontrado.");
        }
    }

    public void deletaCookies(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
    }

    private static final String SECRET_KEY = "1234567890123456";

    public String criptografar(String valor) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] valorCriptografado = cipher.doFinal(valor.getBytes());

        return Base64.getEncoder().encodeToString(valorCriptografado);
    }
}
