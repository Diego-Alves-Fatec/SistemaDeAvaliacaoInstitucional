package comercial.model.repository;

import comercial.model.vo.ItemDominioVO;
import comercial.model.vo.QuestaoVO;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestaoRepository extends JpaRepository<QuestaoVO,Integer> {
    List<QuestaoVO> findByFlagTipoAvaliacao(ItemDominioVO voe);

}
